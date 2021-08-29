package com.lupus;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandLobby extends Command {
	protected CommandLobby() {
		super("lobby");
	}


	@Override
	public void execute(CommandSender sender, String[] strings) {
		if (!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new ComponentBuilder("This command can only be run by a player!").color(ChatColor.RED).create());
			return;
		}
		ProxiedPlayer player = (ProxiedPlayer)sender;
		if (player.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {
			player.sendMessage(new ComponentBuilder("You are already in the lobby").color(ChatColor.RED).create());
			return;
		}
		ServerInfo target = ProxyServer.getInstance().getServerInfo("lobby");
		player.connect(target);
	}
}
