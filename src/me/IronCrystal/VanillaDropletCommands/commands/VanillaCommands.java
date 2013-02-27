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
	
	@Command(aliases = {"hurt", "damage"}, usage = "<player> <health level>", desc = "Sets the health level of the player.")
	@CommandPermissions("vanillacommands.hurt")
	public void hurt(CommandContext args, CommandSource source) {
		CM.hurt(args, source);		
	}
	
	@Command(aliases = {"ignite"}, usage = "<player>", desc = "Sets the player on fire.")
	@CommandPermissions("vanillacommands.ignite")
	public void ignite(CommandContext args, CommandSource source) {
		CM.ignite(args, source);		
	}
	
	@Command(aliases = {"fall"}, usage = "<player>", desc = "Makes the player fall.")
	@CommandPermissions("vanillacommands.fall")
	public void fall(CommandContext args, CommandSource source) {
		CM.fall(args, source);		
	}
	
	@Command(aliases = {"explode"}, usage = "<player>", desc = "Makes the player explode.")
	@CommandPermissions("vanillacommands.explode")
	public void explode(CommandContext args, CommandSource source) {
		CM.explode(args, source);		
	}
	
	@Command(aliases = {"blind"}, usage = "<player>", desc = "Makes the player blind.")
	@CommandPermissions("vanillacommands.blind")
	public void blind(CommandContext args, CommandSource source) {
		CM.blind(args, source);		
	}
	
	@Command(aliases = {"ill"}, usage = "<player>", desc = "Makes the player ill.")
	@CommandPermissions("vanillacommands.ill")
	public void ill(CommandContext args, CommandSource source) {
		CM.ill(args, source);		
	}
	
	@Command(aliases = {"hungry"}, usage = "<player>", desc = "Makes the player hungry.")
	@CommandPermissions("vanillacommands.hungry")
	public void hungry(CommandContext args, CommandSource source) {
		CM.hungry(args, source);		
	}

}
