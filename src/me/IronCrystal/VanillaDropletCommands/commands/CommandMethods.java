package me.IronCrystal.VanillaDropletCommands.commands;

import org.spout.api.Spout;
import org.spout.api.chat.ChatArguments;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.entity.Player;
import org.spout.vanilla.component.entity.misc.Hunger;

public class CommandMethods {

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
}
