package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

import java.util.Random;

import static website.skylorbeck.sentimentality3.sentimentality3.Ref.firstWarn;
import static website.skylorbeck.sentimentality3.sentimentality3.Ref.secondWarn;

@Mixin(ItemStack.class)
public abstract class DurabilityWarnMixin {

    @Shadow
    public abstract int getDamage();

    @Shadow
    public abstract Item getItem();

    @Shadow
    public abstract int getMaxDamage();

    @Inject(method = "damage(ILjava/util/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z", at = @At("HEAD"))
    public void onDamage(int amount, Random random, ServerPlayerEntity player, CallbackInfoReturnable<Boolean> cir) {//todo configurable
        if (Ref.durabilityWarn) {
            int durability = getMaxDamage() - getDamage();
            if (durability == firstWarn+1) {
                player.world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.4f, 0.8F + player.world.random.nextFloat() * 0.4F);
                player.sendMessage(new TranslatableText(getItem().getTranslationKey()).append(" is close to breaking!"), true);
            } else if (durability == secondWarn+1) {
                player.world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 0.6f, 0.8F + player.world.random.nextFloat() * 0.4F);
                player.sendMessage(new TranslatableText(getItem().getTranslationKey()).append(" is about to break!"), true);
            }
        }
    }
}