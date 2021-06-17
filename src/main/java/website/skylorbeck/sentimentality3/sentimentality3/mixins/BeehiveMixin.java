package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

@Mixin(BeehiveBlock.class)
public class BeehiveMixin {
    @Inject(at = @At("HEAD"), method = "onUse")
    public void showBees(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        //we don't want the client to do this since we are sending packets to the client
        if (Ref.beehiveTips) {
            if (!world.isClient && player.getStackInHand(hand).isEmpty()) {//want to make sure the hand is empty
                BeehiveBlockEntity beehiveBlockEntity = (BeehiveBlockEntity) world.getBlockEntity(pos);
                int beeCount = 0;//will not produce exception, since the only time we can get here is if there is something to get
                if (beehiveBlockEntity != null) {
                    beeCount = beehiveBlockEntity.getBeeCount();
                }
                String text;
                if (beeCount == 1) {//if statement to determine grammar
                    text = "This hive contains " + beeCount + " bee";
                } else {
                    text = "This hive contains " + beeCount + " bees";
                }
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, (new TitleS2CPacket( Text.of(text))));//send packet to client to display bee count as brief message on action bar
            }
        }
    }
}