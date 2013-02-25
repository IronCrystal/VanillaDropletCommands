package me.IronCrystal.VanillaDropletCommands.commands;

import me.IronCrystal.VanillaDropletCommands.VanillaDropletCommands;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.CommandPermissions;

public class VanillaCommands {
	
	VanillaDropletCommands plugin;
	CommandMethods CM = new CommandMethods();

	public VanillaCommands(VanillaDropletCommands instance) {
		plugin = instance;
	}

	@Command(aliases = {"starve"}, usage = "<player> <hunger level>", desc = "Sets the hunger level of the player.")
	@CommandPermissions("vanillacommands.starve")
	public void starve(CommandContext args, CommandSource source) {
		CM.starve(args, source);		
	}

}
