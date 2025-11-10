package net.droidbot.schpeedyboats.mixins;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Redirect(method = "getVelocityMultiplier", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getVelocityMultiplier()F"))
    private float getVelocityMultiplier(Block target) {
		Entity entity = ((Entity) (Object) this);
	    boolean isBoat = entity instanceof AbstractBoatEntity;
		if (isBoat) {
			return 1.05F;
		}
		else {
			return target.getVelocityMultiplier();
		}
	}
}
