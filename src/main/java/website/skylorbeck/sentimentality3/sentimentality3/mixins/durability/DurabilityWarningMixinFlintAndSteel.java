package website.skylorbeck.sentimentality3.sentimentality3.mixins.durability;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;


@Mixin(FlintAndSteelItem.class)
public abstract class DurabilityWarningMixinFlintAndSteel {
    @Inject(at = @At("RETURN"), method = "useOnBlock")
    public void checkDur(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();
        BlockPos pos = context.getBlockPos();
        if (Ref.durabilityWarn && !world.isClient) {
            int curDam = stack.getMaxDamage() - stack.getDamage();
            NbtCompound tag = stack.getOrCreateTag();
            if (curDam>=11){
                tag.remove("hasPlayedSound1");
                tag.remove("hasPlayedSound2");
            }
            switch (curDam) {
                case 10:
                    if (!tag.getBoolean("hasPlayedSound1")) {
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.4f, 0.8F + world.random.nextFloat() * 0.4F);
                        ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) player, (new SubtitleS2CPacket( new TranslatableText(stack.getItem().getTranslationKey()).append(" is close to breaking!"))));
                        tag.putBoolean("hasPlayedSound1", true);
                    }
                        break;
                case 5:
                    if (!tag.getBoolean("hasPlayedSound2")) {
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.6f, 0.8F + world.random.nextFloat() * 0.4F);
                        ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) player, (new SubtitleS2CPacket( new TranslatableText(stack.getItem().getTranslationKey()).append(" is VERY close to breaking!!"))));
                        tag.putBoolean("hasPlayedSound2", true);
                    }
                    break;
            }
        }
    }
}