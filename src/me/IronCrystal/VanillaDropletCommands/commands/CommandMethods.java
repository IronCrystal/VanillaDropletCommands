package me.IronCrystal.VanillaDropletCommands.commands;

import org.spout.api.Spout;
import org.spout.api.chat.ChatArguments;
import org.spout.api.chat.style.ChatStyle;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.entity.Player;
import org.spout.api.geo.discrete.Point;
import org.spout.vanilla.component.entity.misc.Burn;
import org.spout.vanilla.component.entity.misc.Health;
import org.spout.vanilla.component.entity.misc.Hunger;
import org.spout.vanilla.event.cause.HealthChangeCause;

public class CommandMethods {

	/**
	 * Used for starving the player.
	 * @param args
	 * @param source
	 */
	public void starve(CommandContext args, CommandSource source) {
		if (args.length() == 0) {
			
			try {
			Spout.getEngine().getPlayer(source.getName(), false).get(Hunger.class).setHunger(0);
			source.sendMessage(new ChatArguments("Succesfully set your hunger to zero"));
			} catch (Exception e) {
				source.sendMessage("You are not a player!");
			}
		}
		else if (args.length() == 1) {
			Player player = null;

			try {
				player = Spout.getEngine().getPlayer(args.get(0).getPlainString(), false);
				player.get(Hunger.class).setHunger(0);
				source.sendMessage(new ChatArguments("Succesfully set ", player.getName(), "'s hunger to zero"));
			} catch (NullPointerException e) {
				source.sendMessage(args.get(0).toString(), " is not a player!");
			}
		}
		else if (args.length() == 2) {
			Player player = null;
			int hungerLevel;

			try {
				player = Spout.getEngine().getPlayer(args.get(0).getPlainString(), false);
			} catch (NullPointerException e) {
				source.sendMessage(args.get(0).toString(), " is not a player!");
			}

			try {
				hungerLevel = args.getInteger(1);
				player.get(Hunger.class).setHunger(hungerLevel);
				source.sendMessage(new ChatArguments("Succesfully set ", player.getName(), "'s hunger to ", hungerLevel));
			} catch (Exception e) {
				source.sendMessage(args.get(1), " is not a valid hunger level!");
			}
		}
	}
	
	/**
	 * Used for setting the health of the player.
	 * @param args
	 * @param source
	 */
	public void hurt(CommandContext args, CommandSource source) {
		if (args.length() == 0) {			
			try {
			Spout.getEngine().getPlayer(source.getName(), false).get(Health.class).setHealth(1, HealthChangeCause.COMMAND);
			source.sendMessage(new ChatArguments("Succesfully set your health to one"));
			} catch (Exception e) {
				source.sendMessage("You are not a player!");
			}
		}
		else if (args.length() == 1) {
			Player player = null;

			try {
				player = Spout.getEngine().getPlayer(args.get(0).getPlainString(), false);
				player.get(Health.class).setHealth(1, HealthChangeCause.COMMAND);
				source.sendMessage(new ChatArguments("Succesfully set ", player.getName(), "'s health to one"));
			} catch (NullPointerException e) {
				source.sendMessage(args.get(0).toString(), " is not a player!");
			}
		}
		else if (args.length() == 2) {
			Player player = null;
			int healthLevel;

			try {
				player = Spout.getEngine().getPlayer(args.get(0).getPlainString(), false);
			} catch (NullPointerException e) {
				source.sendMessage(args.get(0).toString(), " is not a player!");
			}

			try {
				healthLevel = args.getInteger(1);
				player.get(Health.class).setHealth(healthLevel, HealthChangeCause.COMMAND);
				source.sendMessage(new ChatArguments("Succesfully set ", player.getName(), "'s health to ", healthLevel));
			} catch (Exception e) {
				source.sendMessage(args.get(1), " is not a valid health level!");
			}
		}
	}
	
	public void ignite(CommandContext args, CommandSource source) {
		if (args.length() == 0) {
			try {
			Player player = Spout.getEngine().getPlayer(source.getName(), false);
			player.get(Burn.class).setOnFire(20, true);
			source.sendMessage(new ChatArguments("Succesfully set you on fire!"));
			} catch (Exception e) {
				source.sendMessage("You are not a player!");
			}
		}
		else if (args.length() == 1) {
			Player player = null;

			try {
				player = Spout.getEngine().getPlayer(args.get(0).getPlainString(), false);
				player.get(Burn.class).setOnFire(20, true);
				source.sendMessage(new ChatArguments("Succesfully set ", player.getName(), " on fire!"));
			} catch (NullPointerException e) {
				source.sendMessage(args.get(0).toString(), " is not a player!");
			}
		}
	}
	
	public void fall(CommandContext args, CommandSource source) {
		if (args.length() == 0) {
			try {
				Player player = Spout.getEngine().getPlayer(source.getName(), false);
				Point point = player.getScene().getPosition();
				Point newPoint = new Point(point.getWorld(), point.getBlockX(), (point.getBlockY() + 60), point.getBlockZ());
				player.teleport(newPoint);
				source.sendMessage(new ChatArguments("Succesfully fell!"));
			} catch (Exception e) {
				source.sendMessage(new ChatArguments("You must be a player!"));
				source.sendMessage(new ChatArguments(ChatStyle.RED, "Or use /c fall <player>"));
			}
		}
		else if (args.length() == 1) {
			Player player = null;

			try {
				player = Spout.getEngine().getPlayer(args.get(0).getPlainString(), false);
				Point point = player.getScene().getPosition();
				Point newPoint = new Point(point.getWorld(), point.getBlockX(), (point.getBlockY() + 60), point.getBlockZ());
				player.teleport(newPoint);
				source.sendMessage(new ChatArguments("Succesfully made ", player.getName(), " fall!"));
			} catch (NullPointerException e) {
				source.sendMessage(args.get(0).toString(), " is not a player!");
			}
		}
	}
}
