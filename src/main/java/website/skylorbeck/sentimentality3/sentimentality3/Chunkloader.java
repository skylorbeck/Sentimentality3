package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.apache.commons.lang3.ArrayUtils;

public class Chunkloader extends Item {
    public static long[] chunks = new long[]{};

    public Chunkloader(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        NbtCompound compoundTag = itemStack.getOrCreateNbt();
        BlockPos blockPos = user.getBlockPos();
        Chunk chunk = world.getChunk(blockPos);
        ChunkPos chunkPos = chunk.getPos();
        MinecraftServer server = world.getServer();
        if (server != null) {
            long chunkLong = chunkPos.toLong();//get chunk x,y and then convert it to a single long for storage
            chunks = compoundTag.getLongArray("chunks");//get the array stored in the itemstack
            boolean toLoad = true;//set this chunk as needing to be loaded
            for (int i = 0; i < chunks.length; i++) {
                if (chunks[i] == chunkLong) {//check to see if chunk is already loaded
                    server.getCommandManager().execute(new ServerCommandSource(server, new Vec3d(user.getX(), user.getY(), user.getZ()), Vec2f.ZERO, (ServerWorld) world, 4, "Chunk Loader", new LiteralText("Chunk Loader"), server, null),
                            String.format("forceload %s %s %s", "remove", blockPos.getX(), blockPos.getZ()));//unload chunk as server level entity
                    chunks = ArrayUtils.remove(chunks, i);//remove chunk from array on item
                    user.sendMessage(Text.of("Chunk Unloaded"), true);//tell the user what happened
                    toLoad = false;//set chunk as not needed
                }
            }
            if (toLoad) {//if chunk wasn't in list
                server.getCommandManager().execute(new ServerCommandSource(server, new Vec3d(user.getX(), user.getY(), user.getZ()), Vec2f.ZERO, (ServerWorld) world, 4, "Chunk Loader", new LiteralText("Chunk Loader"), server, null),
                        String.format("forceload %s %s %s", "add", blockPos.getX(), blockPos.getZ()));//load the chunk using server level entity
                chunks = ArrayUtils.add(chunks, chunkLong);//add chunk to itemstack
                user.sendMessage(Text.of("Chunk Loaded"), true);//tell the user
            }
            compoundTag.putLongArray("chunks", chunks);//save nbt changes
        }
        return TypedActionResult.success(itemStack);
    }
}