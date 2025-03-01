package net.gamegamer.ninjago.item;

import net.gamegamer.ninjago.PowerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
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

            world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, 0.5F);
            return TypedActionResult.success(player.getStackInHand(hand));
        }

        world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, 0.5F);
        if (!(player instanceof ServerPlayerEntity serverPlayer)) return TypedActionResult.fail(player.getStackInHand(hand));

        ItemStack heldItem = player.getStackInHand(hand);
        Path worldPath = serverPlayer.getServer().getSavePath(WorldSavePath.ROOT); // Get save path for persistence

        // CASE 1: Player uses a Power Scroll to GET a power
        if (!powerType.equals("empty")) {
            if (PowerManager.assignPower(player, powerType, worldPath)) {
                player.sendMessage(Text.of("You have gained the " + powerType + " power!"), true);
                player.setStackInHand(hand, new ItemStack(ModItems.EMPTY_SCROLL)); // Give empty scroll
                return TypedActionResult.success(player.getStackInHand(hand));
            } else {
                player.sendMessage(Text.of("This power is already taken!"), true);
                return TypedActionResult.fail(player.getStackInHand(hand));
            }
        }

        // CASE 2: Player uses an Empty Scroll to REMOVE and STORE their power
        String playerPower = PowerManager.getPlayerPower(player);
        if (playerPower != null) {
            PowerManager.removePower(player, worldPath); // Remove the power
            player.sendMessage(Text.of("You stored your " + playerPower + " power in the scroll!"), true);
            player.setStackInHand(hand, new ItemStack(ModItems.getPowerScroll(playerPower))); // Turn scroll into power scroll
            return TypedActionResult.success(player.getStackInHand(hand));


        } else {
            player.sendMessage(Text.of("You have no power to store."), true);
            return TypedActionResult.fail(player.getStackInHand(hand));
        }
    }
}
