package me.IronCrystal.VanillaDropletCommands;

import me.IronCrystal.VanillaDropletCommands.components.Falling;

import org.spout.api.chat.ChatArguments;
import org.spout.api.entity.Player;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.add(Falling.class);
		player.sendMessage(new ChatArguments("Added Falling Component"));
	}

}
