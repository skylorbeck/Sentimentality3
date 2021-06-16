package website.skylorbeck.sentimentality3.sentimentality3.mixins;

import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import website.skylorbeck.sentimentality3.sentimentality3.ItemEntityRotator;

@Mixin(ItemEntity.class)
public class ItemEntityMixin implements ItemEntityRotator {

    private Vec3d rotation = new Vec3d(0, 0, 0);//pure 0 vec for reference in renderermixin

    @Override
    public Vec3d getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(Vec3d rotation) {
        this.rotation = rotation;
    }
}