package com.lupus;

import net.md_5.bungee.api.plugin.Plugin;

public class LobbyCommand extends Plugin {
	@Override
	public void onEnable() {
		getLogger().info("Turned on LobbyCommand");
		getProxy().getPluginManager().registerCommand(this, new CommandLobby());
	}
}
