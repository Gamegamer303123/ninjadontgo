package net.gamegamer.ninjago.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomItem extends Item {
    public CustomItem(Settings settings) {
        super(settings);
    }


    // write this if the version is 1.21.2 or higher:
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        ItemStack stack = user.getMainHandStack();
        user.getItemCooldownManager().set(stack.getItem(), 20);
        return TypedActionResult.success(this.getDefaultStack());
    }
}