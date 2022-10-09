package website.skylorbeck.minecraft.sentimentality3.mixins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.minecraft.sentimentality3.Ref;

import static website.skylorbeck.minecraft.sentimentality3.Ref.firstWarn;
import static website.skylorbeck.minecraft.sentimentality3.Ref.secondWarn;

@Mixin(ItemStack.class)
public abstract class DurabilityWarnMixin {

    @Shadow
    public abstract int getDamage();

    @Shadow
    public abstract Item getItem();

    @Shadow
    public abstract int getMaxDamage();

    @Inject(method = "damage(ILnet/minecraft/util/math/random/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z", at = @At("HEAD"))
    public void onDamage(int amount, net.minecraft.util.math.random.Random random, ServerPlayerEntity player, CallbackInfoReturnable<Boolean> cir) {//todo configurable
        if (Ref.durabilityWarn && player != null) {
            int durability = getMaxDamage() - getDamage();
            if (durability == firstWarn+1) {
                player.world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.4f, 0.8F + player.world.random.nextFloat() * 0.4F);
                player.sendMessage(Text.translatable(getItem().getTranslationKey()).append(" is close to breaking!"), true);
            } else if (durability == secondWarn+1) {
                player.world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.6f, 0.8F + player.world.random.nextFloat() * 0.4F);
                player.sendMessage(Text.translatable(getItem().getTranslationKey()).append(" is about to break!"), true);
            }
        }
    }
}