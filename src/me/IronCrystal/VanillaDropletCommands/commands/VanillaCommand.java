package me.IronCrystal.VanillaDropletCommands.commands;


import me.IronCrystal.VanillaDropletCommands.VanillaDropletCommands;

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.NestedCommand;
import org.spout.api.exception.CommandException;

public class VanillaCommand {

	private final VanillaDropletCommands plugin;

	/**
	 * We must pass in an instance of our plugin's object for the annotation to register under the factory.
	 * @param instance
	 */
	public VanillaCommand(VanillaDropletCommands instance) {
		plugin = instance;
	}

	// This is the command. Will detail all the options later.
	@Command(aliases = {"c", "command"}, usage = "", desc = "Access example vanilla commands")
	// This is the class with all subcommands under /config
	@NestedCommand(VanillaCommands.class)
	public void command(CommandContext args, CommandSource source) throws CommandException {
		
	}
}
