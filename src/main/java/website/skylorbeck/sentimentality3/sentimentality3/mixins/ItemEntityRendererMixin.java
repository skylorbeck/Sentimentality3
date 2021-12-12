package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import net.minecraft.block.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.sentimentality3.sentimentality3.ItemEntityRotator;
import website.skylorbeck.sentimentality3.sentimentality3.Ref;

import java.util.Random;

@Mixin(ItemEntityRenderer.class)
public abstract class ItemEntityRendererMixin extends EntityRenderer<ItemEntity> {
    @Shadow
    @Final
    private Random random;
    @Shadow
    @Final
    private ItemRenderer itemRenderer;

    @Shadow
    protected abstract int getRenderedAmount(ItemStack stack);

    protected ItemEntityRendererMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Inject(at = @At("RETURN"), method = "<init>")
    private void onConstructor(EntityRendererFactory.Context context, CallbackInfo ci) {
        this.shadowRadius = 0.15f;//shadow size fix
    }

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private void render(ItemEntity itemEntity, float f, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (Ref.itemEntity) {
            ItemStack itemStack = itemEntity.getStack();
            Item item = itemStack.getItem();
            int seed = itemStack.isEmpty() ? 187 : Item.getRawId(item) + itemStack.getDamage();//seeds the random with it's own rawid and the itemstacks damage. Usually ends up being only the raw id.
            this.random.setSeed(seed);
            matrixStack.push();
            BakedModel bakedModel = this.itemRenderer.getModel(itemStack, itemEntity.world, null,seed);
            boolean hasDepthInGui = bakedModel.hasDepth();
            int renderCount = this.getRenderedAmount(itemStack);
            boolean flat = false;
            boolean skull = false;
            boolean lantern = false;
            if (item instanceof BlockItem && !(item instanceof AliasedBlockItem)) {//aliasedblockitems are things like redstone dust
                Block b = ((BlockItem) item).getBlock();
                VoxelShape shape = b.getOutlineShape(b.getDefaultState(), itemEntity.world, itemEntity.getBlockPos(), ShapeContext.absent());//get the items voxel shape for size calculations
                if (b instanceof TorchBlock//special item's that do not fall under "flat" using model calculations
                        || b instanceof WallMountedBlock
                        || b instanceof AbstractPlantPartBlock
                        || b instanceof HopperBlock
                        || b instanceof LadderBlock
                        || b instanceof DoorBlock
                        || b instanceof TripwireHookBlock
                        || b instanceof PlantBlock
                        || b instanceof CobwebBlock
                        || b instanceof SugarCaneBlock
                        || b instanceof PaneBlock
                        || shape.getMax(Direction.Axis.X) <= .25//any item that is 1/4th a full block in any direction is considered flat
                        || shape.getMax(Direction.Axis.Y) <= .25
                        || shape.getMax(Direction.Axis.Z) <= .25
                ) {
                    flat = true;
                }
                if (b instanceof TrapdoorBlock || b instanceof AbstractPressurePlateBlock || b instanceof SnowBlock) {//special cases where flat items don't need to be rotated
                    flat = false;
                }
                if (b instanceof SkullBlock) {//special cases for skulls since they have a different hitbox
                    skull = true;
                }
                if (b instanceof LanternBlock) {//special cases for lanterns since they too have a weird hitbox
                    lantern = true;
                }
            }

            matrixStack.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(1.571F));//lay items on their side to start

            ItemEntityRotator rotator = (ItemEntityRotator) itemEntity;
            float rotation = ((float) itemEntity.getItemAge() + partialTicks) / 10f + itemEntity.getHeight() +itemEntity.uniqueOffset;//seeds the rotation with the item's age and it's height to keep it moving at a fixed rate over time and relative to it's falling speed
            boolean isAboveWater1 = itemEntity.world.getBlockState(itemEntity.getBlockPos()).getFluidState().getFluid().isIn(FluidTags.WATER);//check to see if the item is directly above water to prevent water bouncing
            boolean isInCobweb = itemEntity.world.getBlockState(itemEntity.getBlockPos()).getBlock() == Blocks.COBWEB;//check to see if item is stuck in cobweb
            if (itemEntity.isSubmergedInWater() || isAboveWater1 || isInCobweb) {//if it's either of those, make is spin but at 1/4th speed
                rotation = rotation / 4;
                if (rotation % 2 == 0) {//50/50 chance to rotate either direction
                    matrixStack.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion(rotation));
                } else {
                    matrixStack.multiply(Vec3f.NEGATIVE_X.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.NEGATIVE_Y.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.NEGATIVE_Z.getRadialQuaternion(rotation));
                }
                rotator.setRotation(new Vec3d(0, 0, rotation));
            } else if (!itemEntity.isOnGround() && !itemEntity.isSubmergedInWater()) {//if the item  isn't on the ground and isn't in water, spin at full speed
                if (rotation % 2 == 0) {
                    matrixStack.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion(rotation));
                } else {
                    matrixStack.multiply(Vec3f.NEGATIVE_X.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.NEGATIVE_Y.getRadialQuaternion(rotation));
                    matrixStack.multiply(Vec3f.NEGATIVE_Z.getRadialQuaternion(rotation));
                }
                rotator.setRotation(new Vec3d(0, 0, rotation));
            } else if (itemEntity.getStack().getItem() instanceof AliasedBlockItem) {//if it's on the ground, but redstone (or a similar item), special case to lay flat
                matrixStack.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion((float) rotator.getRotation().z));
            } else if (itemEntity.getStack().getItem() instanceof BlockItem && !flat) {//special case to make full cube blocks lay on their correct bottom instead of side
                matrixStack.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(300));
                matrixStack.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion((float) rotator.getRotation().z));
                matrixStack.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion(0));
            } else {
                matrixStack.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion((float) rotator.getRotation().z));//catch all make lay on side when on ground
            }

            if (item instanceof AliasedBlockItem || flat) {//if item is flat or redstone, don't do any adjustments
            } else if (skull || lantern) {//if skull or lantern, adjust to account for extra space on model
                matrixStack.translate(0, 0.06, 0);
            } else if (itemEntity.getStack().getItem() instanceof BlockItem) {//special case to prevent clipping of blocks
                matrixStack.translate(0, -0.06f, 0);
            }

            if (itemEntity.world.getBlockState(itemEntity.getBlockPos()).getBlock().equals(Blocks.SOUL_SAND)) {//lift items out of soul sand
                matrixStack.translate(0, 0, -.1);
            }
            if (itemEntity.isOnGround() && itemEntity.world.getBlockState(itemEntity.getBlockPos()).getBlock().equals(Blocks.SNOW)) {//lift item's out of snow
                matrixStack.translate(0, 0, -0.12);
            }

            float scaleX = bakedModel.getTransformation().ground.scale.getX();
            float scaleY = bakedModel.getTransformation().ground.scale.getY();
            float scaleZ = bakedModel.getTransformation().ground.scale.getZ();

            float x;
            float y;
            if (!hasDepthInGui) {//item sizing
                float r = -0.0F * (float) (renderCount) * 0.5F * scaleX;
                x = -0.0F * (float) (renderCount) * 0.5F * scaleY;
                y = -0.09375F * (float) (renderCount) * 0.5F * scaleZ;
                matrixStack.translate(r, x, y);
            }
            for (int u = 0; u < renderCount; ++u) {//when there is a stack, render more than one item randomly placed around
                matrixStack.push();
                if (u > 0) {
                    if (hasDepthInGui) {
                        x = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                        y = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                        float z = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                        matrixStack.translate(x, y, z);
                    } else {
                        x = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
                        y = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
                        matrixStack.translate(x, y, 0.0D);
                        matrixStack.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion(this.random.nextFloat()));
                    }
                }
                this.itemRenderer.renderItem(itemStack, ModelTransformation.Mode.GROUND, false, matrixStack, vertexConsumerProvider, i, OverlayTexture.DEFAULT_UV, bakedModel);
                matrixStack.pop();
                if (!hasDepthInGui) {
                    matrixStack.translate(0.0F * scaleX, 0.0F * scaleY, 0.0625F * scaleZ);
                }
            }

            matrixStack.pop();
            super.render(itemEntity, f, partialTicks, matrixStack, vertexConsumerProvider, i);
            ci.cancel();
        }
    }
}