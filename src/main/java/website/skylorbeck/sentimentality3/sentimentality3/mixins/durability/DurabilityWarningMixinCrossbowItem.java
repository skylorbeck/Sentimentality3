package website.skylorbeck.sentimentality3.sentimentality3.mixins.durability;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.sentimentality2.Ref;

@Mixin(CrossbowItem.class)
public abstract class DurabilityWarningMixinCrossbowItem {
    @Shadow
    public static boolean isCharged(ItemStack stack) {
        return false;
    }

    @Inject(at = @At("HEAD"), method = "use")
    public void checkDur(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (Ref.durabilityWarn && !world.isClient) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (isCharged(itemStack)) {
                BlockPos pos = user.getBlockPos();
                int curDam = itemStack.getMaxDamage() - itemStack.getDamage();
                CompoundTag tag = itemStack.getOrCreateTag();
                if (curDam >= 12) {
                    tag.remove("hasPlayedSound1");
                    tag.remove("hasPlayedSound2");
                }
                switch (curDam) {
                    case 11:
                        if (!tag.getBoolean("hasPlayedSound1")) {
                            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.4f, 0.8F + world.random.nextFloat() * 0.4F);
                            ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) user, (new TitleS2CPacket(TitleS2CPacket.Action.ACTIONBAR, new TranslatableText(itemStack.getItem().getTranslationKey()).append(" is close to breaking!"))));
                            tag.putBoolean("hasPlayedSound1", true);
                        }
                        break;
                    case 6:
                        if (!tag.getBoolean("hasPlayedSound2")) {
                            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.6f, 0.8F + world.random.nextFloat() * 0.4F);
                            ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) user, (new TitleS2CPacket(TitleS2CPacket.Action.ACTIONBAR, new TranslatableText(itemStack.getItem().getTranslationKey()).append(" is VERY close to breaking!!"))));
                            tag.putBoolean("hasPlayedSound2", true);
                        }
                        break;
                }
            }
        }
    }
}