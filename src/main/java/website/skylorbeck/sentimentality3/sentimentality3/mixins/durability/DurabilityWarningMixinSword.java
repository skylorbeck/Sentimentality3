package website.skylorbeck.sentimentality3.sentimentality3.mixins.durability;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

@Mixin(SwordItem.class)
public abstract class DurabilityWarningMixinSword {
    @Inject(at = @At("RETURN"), method = "postMine")
    public void checkDur(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity attacker, CallbackInfoReturnable<Boolean> cir) {
        if (Ref.durabilityWarn && !world.isClient && attacker instanceof PlayerEntity && state.getHardness(world, pos) != 0.0F) {
            int curDam = stack.getMaxDamage() - stack.getDamage();
            NbtCompound tag = stack.getOrCreateTag();
            if (curDam>=11){
                tag.remove("hasPlayedSound1");
                tag.remove("hasPlayedSound2");
            }
            switch (curDam) {
                case 10:
                case 9:
                    if (!tag.getBoolean("hasPlayedSound1")) {
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.4f, 0.8F + world.random.nextFloat() * 0.4F);
                        ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) attacker, (new SubtitleS2CPacket( new TranslatableText(stack.getItem().getTranslationKey()).append(" is close to breaking!"))));
                        tag.putBoolean("hasPlayedSound1", true);
                    }
                        break;
                case 5:
                case 4:
                    if (!tag.getBoolean("hasPlayedSound2")) {
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.6f, 0.8F + world.random.nextFloat() * 0.4F);
                        ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) attacker, (new SubtitleS2CPacket( new TranslatableText(stack.getItem().getTranslationKey()).append(" is VERY close to breaking!!"))));
                        tag.putBoolean("hasPlayedSound2", true);
                    }
                    break;
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "postHit")
    public void checkDur2(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> cir) {
        int curDam = stack.getMaxDamage() - stack.getDamage();
        NbtCompound tag = stack.getOrCreateTag();
        if (curDam>=11){
            tag.putBoolean("hasPlayedSound1",false);
            tag.putBoolean("hasPlayedSound2",false);
        }
        switch (curDam) {
            case 10:
            case 9:
                if (!tag.getBoolean("hasPlayedSound1")) {
                    attacker.world.playSound(null, attacker.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.2f, 0.8F + attacker.world.random.nextFloat() * 0.4F);
                    ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) attacker, (new SubtitleS2CPacket(new TranslatableText(stack.getItem().getTranslationKey()).append(" is close to breaking!"))));
                    tag.putBoolean("hasPlayedSound1", true);
                }
                break;
            case 5:
            case 4:
                if (!tag.getBoolean("hasPlayedSound2")) {
                    attacker.world.playSound(null, attacker.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.4f, 0.8F + attacker.world.random.nextFloat() * 0.4F);
                    ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) attacker, (new SubtitleS2CPacket( new TranslatableText(stack.getItem().getTranslationKey()).append(" is VERY close to breaking!!"))));
                    tag.putBoolean("hasPlayedSound2", true);
                }
                break;
        }
    }
}