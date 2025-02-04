package net.gamegamer.ninjago.item;

import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.ModEntityTypes;

import net.gamegamer.ninjago.entities.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Cooldown;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireSword extends SwordItem {
    public FireSword(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }


    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        // Check if item is on cooldown
        if (!player.getItemCooldownManager().isCoolingDown(stack)) {
            if (!world.isClient) {
                // Play a sound
                world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_ANVIL_LAND,
                        SoundCategory.PLAYERS, 1.0F, 1.0F);


                FireWave firewave = new FireWave(ModEntityTypes.FIREWAVE, world);
                firewave.setPosition(player.getX(), player.getY(), player.getZ()); // Set position
                world.spawnEntity(firewave);



                // Apply cooldown of 20 ticks (1 second)
                player.getItemCooldownManager().set(stack, 20);
            }
            else {
             //   world.addParticle();

            }


            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }






}
/*
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
        ItemStack stack = user.getMainHandStack();
        //this.getItemCooldownManager().set(shield, 100);
        //this.set(this.getGroup(stack), duration);


        if (!user.getItemCooldownManager().isCoolingDown(hand)) {
        }

        user.getItemCooldownManager().set(stack, 20);
    }
}
*/

       /* if (!world.isClient && hand == hand.MAIN_HAND) {
            user.getItemCooldownManager().set(this, 20);
        } */


  /*  @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
        if (user instanceof PlayerEntity player) {

    }*/



