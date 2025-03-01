package net.gamegamer.ninjago.item;

import net.gamegamer.ninjago.PowerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.WorldSavePath;
import net.minecraft.world.World;

import java.nio.file.Path;

public class Scrolls extends Item {
    private final String powerType;

    public Scrolls(String powerType, Settings settings) {
        super(settings);
        this.powerType = powerType;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient) {
            playScrollSound(world, player);
            return TypedActionResult.success(player.getStackInHand(hand));
        }

        if (!(player instanceof ServerPlayerEntity serverPlayer)) {
            return TypedActionResult.fail(player.getStackInHand(hand));
        }

        Path worldPath = serverPlayer.getServer().getSavePath(WorldSavePath.ROOT);
        ItemStack heldItem = player.getStackInHand(hand);
        String currentPower = PowerManager.getPlayerPower(player); // Player’s active power

        // CASE 1: If using an empty scroll, store the player's current power
        if (powerType.equals("empty")) {
            if (currentPower != null) {
                PowerManager.removePower(player, worldPath);
                player.setStackInHand(hand, new ItemStack(ModItems.getPowerScroll(currentPower)));
                player.sendMessage(Text.of("You stored your " + currentPower + " power in the scroll!"), true);
                playScrollSound(world, player);
                return TypedActionResult.success(player.getStackInHand(hand));
            } else {
                player.sendMessage(Text.of("You have no power to store."), true);
                return TypedActionResult.fail(player.getStackInHand(hand));
            }
        }

        // CASE 2: If using a power scroll
        if (!powerType.equals(currentPower)) {
            if (PowerManager.isPowerTaken(powerType)) { // New check to prevent duplicates
                player.sendMessage(Text.of("This power is already taken!"), true);
                return TypedActionResult.fail(player.getStackInHand(hand));
            }

            int savedLevel = PowerManager.getPowerLevel(player, powerType); // Get level of the new power
            boolean success = PowerManager.assignPower(player, powerType, worldPath); // Assign new power

            if (success) {
                if (currentPower != null) { // If the player had a power before

                    player.setStackInHand(hand, new ItemStack(ModItems.getPowerScroll(currentPower)));
                    player.sendMessage(Text.of("You stored your " + currentPower + " power in the scroll!"), true);
                } else {
                    player.setStackInHand(hand, new ItemStack(ModItems.EMPTY_SCROLL));
                }

                // Restore power level if it existed before
                if (savedLevel >= 1) {
                    PowerManager.setPowerLevel(player, powerType, savedLevel, worldPath);
                }




                player.sendMessage(Text.of("You have gained the " + powerType + " power!"), true);
                playScrollSound(world, player);
                return TypedActionResult.success(player.getStackInHand(hand));
            }
        }

        // If the power is the same as the one the player already has, do nothing
        player.sendMessage(Text.of("You already have the " + powerType + " power!"), true);
        return TypedActionResult.fail(player.getStackInHand(hand));
    }

    private void playScrollSound(World world, PlayerEntity player) {
        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, 0.5F);
    }
}
