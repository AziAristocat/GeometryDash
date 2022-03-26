package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

public final class GeometryDash extends JavaPlugin implements CommandExecutor {
    private static GeometryDash instance;

    public GeometryDash (){
        instance = this;
    }

    public static GeometryDash getInstance() {
        return instance;
    }

    public static Location loc;
    public static Location playerlocation;
    public static UUID PlayerID;

    @Override
    public void onEnable() {

        registerEvents();
        // Plugin startup logic
        getServer().broadcastMessage( "Natto osuki???!!!" );
        getCommand("playgeod").setExecutor(this);
        BukkitTask SpawnPillar = new RepeatCast(this).runTaskTimer(this, 1L, 1L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        //Spawns slime and starts game
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        playerlocation=player.getLocation();
        PlayerID= player.getUniqueId();
        World w = getServer().getWorld("GeoDash");
        Location startlocation = new Location(w, 0,4,0);
        SpawnSlime.cube(startlocation);
        player.sendMessage("start!!");
        BukkitTask SpawnPillar = new RepeatCast(this).runTaskTimer(this, 1L, 20L);
        player.getInventory().setHeldItemSlot(1);
        player.getInventory().setItem(1, new ItemStack(Material.SLIME_BALL,1));
        return true;
    }
    public void registerEvents(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new SlimeJump(this), this);
        pm.registerEvents(new  MapMaking(this), this);
    }


    }

