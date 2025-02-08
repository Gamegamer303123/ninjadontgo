package net.gamegamer.ninjago.item;

import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.ModEntities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireSword extends SwordItem {
    public FireSword(ToolMaterial material, Settings settings) {
        super(material, settings);
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {


        // Check if item is on cooldown
        if (!player.getItemCooldownManager().isCoolingDown(this )) {
            if (!world.isClient) {
                // Play a sound
                world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_ANVIL_LAND,
                        SoundCategory.PLAYERS, 1.0F, 1.0F);


               FireWave firewave = new FireWave(ModEntities.FIREWAVE, world);
               firewave.setPosition(player.getX(), player.getY(), player.getZ());
               world.spawnEntity(firewave);



                // Apply cooldown of 20 ticks (1 second)
                player.getItemCooldownManager().set(this, 20);
            }
            else if (world.isClient){
          //   world.addParticle(ModParticles.FIREWAVE_PARTICLE, player.getX(), player.getY(), player.getZ(), 0, 0, 0);

            }


            return TypedActionResult.success(this.getDefaultStack());
        }

        return TypedActionResult.fail(this.getDefaultStack());
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



