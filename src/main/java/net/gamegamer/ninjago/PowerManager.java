package net.gamegamer.ninjago;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.WorldSavePath;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.*;

public class PowerManager {
    private static final Map<UUID, Map<String, PowerData>> playerPowers = new HashMap<>();
    private static final Gson GSON = new Gson();
    private static final String FILE_NAME = "powers.json";

    public static void loadPowers(Path worldPath) {
        File file = worldPath.resolve(FILE_NAME).toFile();
        if (!file.exists()) return;

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<UUID, Map<String, PowerData>>>() {}.getType();
            Map<UUID, Map<String, PowerData>> loadedData = GSON.fromJson(reader, type);
            if (loadedData != null) {
                playerPowers.clear();
                playerPowers.putAll(loadedData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePowers(Path worldPath) {
        File file = worldPath.resolve(FILE_NAME).toFile();
        try (Writer writer = new FileWriter(file)) {
            GSON.toJson(playerPowers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean assignPower(PlayerEntity player, String power, Path worldPath) {
        UUID playerId = player.getUuid();
        playerPowers.putIfAbsent(playerId, new HashMap<>());

        // If player already has this power, just set it as active
        PowerData data = playerPowers.get(playerId).computeIfAbsent(power, k -> new PowerData(1, false));
        data.setActive(true);

        // Deactivate all other powers
        for (Map.Entry<String, PowerData> entry : playerPowers.get(playerId).entrySet()) {
            if (!entry.getKey().equals(power)) {
                entry.getValue().setActive(false);
            }
        }

        savePowers(worldPath);
        return true;
    }

    public static boolean removePower(PlayerEntity player, Path worldPath) {
        UUID playerId = player.getUuid();
        Map<String, PowerData> powers = playerPowers.get(playerId);

        if (powers == null) return false;

        for (Map.Entry<String, PowerData> entry : powers.entrySet()) {
            if (entry.getValue().isActive()) {
                entry.getValue().setActive(false);
                savePowers(worldPath);
                return true;
            }
        }
        return false;
    }

    public static boolean isPowerTaken(String power) {
        for (UUID playerId : playerPowers.keySet()) {
            Map<String, PowerData> powers = playerPowers.get(playerId);
            if (powers != null && powers.containsKey(power)) {
                // Check if the power is active for this player
                if (powers.get(power).isActive()) {
                    return true; // Someone actively has this power
                }
            }
        }
        return false; // No player has this power active
    }



    public static boolean hasPower(PlayerEntity player, String power) {
        UUID playerId = player.getUuid();
        return playerPowers.containsKey(playerId) && playerPowers.get(playerId).containsKey(power);
    }

    public static String getPlayerPower(PlayerEntity player) {
        UUID playerId = player.getUuid();
        if (!playerPowers.containsKey(playerId)) return null;

        for (Map.Entry<String, PowerData> entry : playerPowers.get(playerId).entrySet()) {
            if (entry.getValue().isActive()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static int getPowerLevel(PlayerEntity player, String power) {
        UUID playerId = player.getUuid();
        if (playerPowers.containsKey(playerId) && playerPowers.get(playerId).containsKey(power)) {
            return playerPowers.get(playerId).get(power).getLevel();
        }
        return 1;
    }

    public static void setPowerLevel(PlayerEntity player, String power, int level, Path worldPath) {
        UUID playerId = player.getUuid();
        playerPowers.putIfAbsent(playerId, new HashMap<>());
        playerPowers.get(playerId).put(power, new PowerData(level, playerPowers.get(playerId).getOrDefault(power, new PowerData(1, false)).isActive()));
        savePowers(worldPath);
    }

    public static void upgradePowerLevel(PlayerEntity player, String power, Path worldPath) {
        UUID playerId = player.getUuid();

        if (!playerPowers.containsKey(playerId) || !playerPowers.get(playerId).containsKey(power)) {
            return; // Player doesn't have this power, do nothing
        }

        PowerData data = playerPowers.get(playerId).get(power);
        data.setLevel(data.getLevel() + 1); // Increment the level

        savePowers(worldPath); // Save the updated data
    }

    private static class PowerData {
        private int level;
        private boolean active;

        public PowerData(int level, boolean active) {
            this.level = level;
            this.active = active;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }
}
