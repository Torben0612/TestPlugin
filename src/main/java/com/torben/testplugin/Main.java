package com.torben.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("testboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.WHITE.toString() + ChatColor.BOLD + "Test Server");


        Score website = obj.getScore(ChatColor.YELLOW + "www.test.com");
        website.setScore(1);


        player.setScoreboard(board);

    }


}
