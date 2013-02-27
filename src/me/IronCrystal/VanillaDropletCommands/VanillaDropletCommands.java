package me.IronCrystal.VanillaDropletCommands;

import java.util.logging.Level;

import me.IronCrystal.VanillaDropletCommands.commands.VanillaCommand;

import org.spout.api.UnsafeMethod;
import org.spout.api.command.CommandRegistrationsFactory;
import org.spout.api.command.annotated.AnnotatedCommandRegistrationFactory;
import org.spout.api.command.annotated.SimpleAnnotatedCommandExecutorFactory;
import org.spout.api.command.annotated.SimpleInjector;
import org.spout.api.plugin.CommonPlugin;

public class VanillaDropletCommands extends CommonPlugin {

	@Override
	@UnsafeMethod
	public void onDisable() {
		getLogger().log(Level.INFO, getDescription().getVersion() + " disabled");
	}

	@Override
	@UnsafeMethod
	public void onEnable() {
		getLogger().log(Level.INFO, getDescription().getVersion() + " enabled");

		/**
		 * Commands
		 */
		CommandRegistrationsFactory<Class<?>> commandRegFactory = new AnnotatedCommandRegistrationFactory(new SimpleInjector(this), new SimpleAnnotatedCommandExecutorFactory());
		getEngine().getRootCommand().addSubCommands(this, VanillaCommand.class, commandRegFactory);		
	}

}
