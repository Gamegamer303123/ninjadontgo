package net.gamegamer.ninjago;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.WorldSavePath;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.*;

public class PowerManager {
    private static final Map<UUID, String> playerPowers = new HashMap<>();
    private static final Set<String> takenPowers = new HashSet<>();
    private static final Gson GSON = new Gson();
    private static final String FILE_NAME = "powers.json";

    public static void loadPowers(Path worldPath) {
        File file = worldPath.resolve(FILE_NAME).toFile();
        if (!file.exists()) return;

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<UUID, String>>(){}.getType();
            Map<UUID, String> loadedData = GSON.fromJson(reader, type);
            if (loadedData != null) {
                playerPowers.clear();
                playerPowers.putAll(loadedData);
                takenPowers.clear();
                takenPowers.addAll(playerPowers.values());
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
        if (takenPowers.contains(power)) return false;

        if (playerPowers.containsKey(playerId)) {
            takenPowers.remove(playerPowers.get(playerId));
        }

        playerPowers.put(playerId, power);
        takenPowers.add(power);
        savePowers(worldPath);
        return true;
    }

    public static boolean removePower(PlayerEntity player, Path worldPath) {
        UUID playerId = player.getUuid();

        // Check if player has a power
        if (!playerPowers.containsKey(playerId)) {
            return false; // Player doesn't have a power
        }

        // Remove power from both lists
        String power = playerPowers.remove(playerId);
        takenPowers.remove(power);

        // Save the updated data
        savePowers(worldPath);
        return true;
    }



    public static boolean hasPower(PlayerEntity player, String power) {
        return power.equals(playerPowers.get(player.getUuid()));
    }

    public static String getPlayerPower(PlayerEntity player) {
        return playerPowers.get(player.getUuid());
    }
}