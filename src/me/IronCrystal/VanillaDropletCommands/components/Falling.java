package me.IronCrystal.VanillaDropletCommands.components;

import me.IronCrystal.VanillaDropletCommands.VanillaDropletCommands;
import me.IronCrystal.VanillaDropletCommands.commands.CommandMethods;
import me.IronCrystal.VanillaDropletCommands.data.FallingData;

import org.spout.api.Spout;
import org.spout.api.component.type.EntityComponent;
import org.spout.api.entity.Entity;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.vanilla.component.entity.misc.Head;
import org.spout.vanilla.component.entity.misc.Health;
import org.spout.vanilla.data.VanillaData;
import org.spout.vanilla.event.cause.HealthChangeCause;
import org.spout.vanilla.material.VanillaMaterials;

public class Falling extends EntityComponent {

	private Entity owner;
	private Health health;
	private Head head;
	//private int lastHeightInAir = getOwner().getData().get(FallingData.LASTHEIGHTINTHEAIR);
	
	VanillaDropletCommands plugin = new VanillaDropletCommands();

	@Override
	public void onAttached() {
		owner = getOwner();
		health = owner.add(Health.class);
		head = owner.add(Head.class);
		getOwner().getData().put(FallingData.LASTHEIGHTINTHEAIR, 0);
	}

	@Override
	public void onTick(float dt) {
		
		int lastHeightInAir = getOwner().getData().get(FallingData.LASTHEIGHTINTHEAIR);
		Entity entity = getOwner();
		Point point = head.getPosition();
		Point underFeetPoint = new Point(point.getWorld(), point.getBlockX(), (point.getBlockY() - 2), point.getBlockZ());
		
		if (!getOwner().getData().get(VanillaData.IS_ON_GROUND)) {
			if (lastHeightInAir == 0) {
				owner.getData().put(FallingData.LASTHEIGHTINTHEAIR, underFeetPoint.getBlockY());
			}
		}
		else {
			if (lastHeightInAir != 0) {
				int damage = lastHeightInAir - underFeetPoint.getBlockY() - 3;
				health.damage(damage);
			}
		}
		//health.setHealth(1, HealthChangeCause.DAMAGE);
		//plugin.getLogger().info("" + underFeetPoint.getBlockY());

//		if (underFeetPoint.getBlock().getMaterial() == BlockMaterial.AIR) {
//			if (lastPositionInAir == 0) {
//				owner.getData().put(FallingData.LASTHEIGHTINTHEAIR, underFeetPoint.getBlockY());
//			}
//		}else{
//			if (lastPositionInAir != 0) {
//				int damage = lastPositionInAir - underFeetPoint.getBlockY() - 3;
//				if (damage > 0) {
//					health.damage(damage);
//					owner.getData().put(FallingData.LASTHEIGHTINTHEAIR, 0);
//				}
//			}else{
//
//			}
//		}
	}
}
