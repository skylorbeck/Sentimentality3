package website.skylorbeck.minecraft.sentimentality3;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

public class Chunkloader extends Item {
    public static long[] chunks = new long[]{};

    public Chunkloader(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {return TypedActionResult.pass(user.getStackInHand(hand));}
        ItemStack itemStack = user.getStackInHand(hand);
        ChunkPos chunkPos = world.getChunk(user.getBlockPos()).getPos();
        MinecraftServer server = world.getServer();
        if (server != null) {
            ServerWorld serverWorld = (ServerWorld) world;
            if (serverWorld.getForcedChunks().contains(chunkPos.toLong())){
                serverWorld.setChunkForced(chunkPos.x,chunkPos.z,false);
                user.sendMessage(Text.of("Chunk Unloaded"), false);
            } else{
                serverWorld.setChunkForced(chunkPos.x,chunkPos.z,true);
                user.sendMessage(Text.of("Chunk Loaded"), false);
            }
        }
        return TypedActionResult.success(itemStack);
    }
}