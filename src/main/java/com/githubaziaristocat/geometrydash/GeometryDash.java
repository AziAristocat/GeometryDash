package com.githubaziaristocat.geometrydash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


import static com.githubaziaristocat.geometrydash.GetPillarRoot.closestBlock;
import static org.bukkit.Bukkit.getServer;

public final class GeometryDash extends JavaPlugin implements CommandExecutor {


    public static Location loc;
    public static Location playerlocation;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().broadcastMessage( "Natto osuki???!!!" );
        getCommand("playgeod").setExecutor(this);
        BukkitTask SpawnPillar = new SpawnPillar(this).runTaskTimer(this, 1L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        //ここにコマンドが入力されたときの処理を書く
        if(!(sender instanceof Player)) return false;  //senderがプレイヤーのインスタンスでなければ実行失敗
        Player player = (Player) sender;  //senderをプレイヤーとしてキャスト
        playerlocation=player.getLocation();
        World w = getServer().getWorld("GeoDash");
        Location startlocation = new Location(w, 0,4,0);
        SpawnSlime.cube(startlocation);
        player.sendMessage("start!!");
        BukkitTask SpawnPillar = new SpawnPillar(this).runTaskTimer(this, 1L, 20L);

        return true;
    }


    }

