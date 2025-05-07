package net.gamegamer.ninjago.item;

import net.gamegamer.ninjago.Ninjadontgo;
import net.gamegamer.ninjago.PowerManager;
import net.gamegamer.ninjago.entities.FireWave;
import net.gamegamer.ninjago.entities.ModEntities;

import net.gamegamer.ninjago.entities.SpinjitzuEntity;
import net.gamegamer.ninjago.particles.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.WorldSavePath;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.nio.file.Path;
import java.util.List;

import static net.gamegamer.ninjago.entities.ModEntities.SPINJITZU_ENTITY_TYPE;

public class FireSword extends SwordItem {
    public FireSword(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    private static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 15.0F), ToolComponent.Rule.of(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
       if (attacker instanceof PlayerEntity player) {
             float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
             float extraDamage = baseDamage * 0.1f; //
            target.damage(player.getDamageSources().playerAttack(player), extraDamage);
            System.out.println("basedamage:" + baseDamage + "increased damaga: " + extraDamage);
        }
        return true;
    }

    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }




   @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);


        // Check if item is on cooldown
        if (!player.getItemCooldownManager().isCoolingDown(this )) {
            if (!world.isClient) {
                // Play a sound
                world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_TRIAL_SPAWNER_OMINOUS_ACTIVATE, SoundCategory.PLAYERS, 1.0F, 0.5F);
                world.addParticle(ModParticles.FIREWAVE_PARTICLE, player.getX(), player.getY(), player.getZ(), 0, 0, 0);
                      //  null, player.getBlockPos(), SoundEvents.,
                        //SoundCategory.PLAYERS, 1.0F, 1.0F);

                SpinjitzuEntity spinjitzu = new SpinjitzuEntity(SPINJITZU_ENTITY_TYPE, world);
                spinjitzu.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), 0, 0);

                world.spawnEntity(spinjitzu);
               // spinjitzu.startRiding(player, true);




                Path worldPath = player.getServer().getSavePath(WorldSavePath.ROOT);
                String currentPower = PowerManager.getPlayerPower(player);
                if (currentPower != null) {
                    PowerManager.upgradePowerLevel(player, currentPower, worldPath);
                }





                // Apply cooldown of 20 ticks (1 second)
                player.getItemCooldownManager().set(this, 20);
            }
            else if (world.isClient){
             world.addParticle(Ninjadontgo.FIREWAVEPARTICLE, player.getX(), player.getY(), player.getZ(), 0, 0, 0);
             world.playSound(player, player.getBlockPos(), SoundEvents.BLOCK_TRIAL_SPAWNER_OMINOUS_ACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0F);


            }


            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.fail(itemStack);
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



