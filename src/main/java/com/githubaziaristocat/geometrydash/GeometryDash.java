package com.githubaziaristocat.geometrydash;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class GeometryDash extends JavaPlugin implements CommandExecutor, Listener {
    private static GeometryDash instance;
    public GeometryDash (){
        instance = this;
    }

    public static GeometryDash getInstance() {
        return instance;
    }

    public static Location loc;
    public static Location playerlocation;

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

       registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(player.getEquipment().getItemInOffHand().getType() != Material.SLIME_BALL){
        event.setCancelled(true);
        Block block = event.getBlock();
        event.getPlayer().sendMessage("Wrong sign or location");
        if(block.getState() instanceof Sign) {
            Sign sign = (Sign) block.getState();
            if(sign.line(0)== Component.text("Left Click to Start")) {
                PluginManager pm = getServer().getPluginManager();
                World w = getServer().getWorld("GeoDash");
                Location startlocation = new Location(w, 0, 5, 0);
                startlocation = block.getLocation();
                SpawnSlime slimy = new SpawnSlime();
                Slime slime = slimy.cube(startlocation);
                player.sendMessage("start!!");
                BukkitTask repeat = new RepeatCast(this, player, slime).runTaskTimer(this, 1L, 1L);
                pm.registerEvents(new SlimeJump(this, player, slime), this);
                player.getInventory().setHeldItemSlot(1);
                player.getInventory().setItem(1, new ItemStack(Material.SLIME_BALL, 1));
            }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        //Spawns slime and starts game
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        ItemStack sign = new ItemStack(Material.ACACIA_SIGN);
        sign.getItemMeta().setDisplayName("Start Point");
        player.getInventory().setItem(0, sign);
        player.sendMessage("その看板を置いたX座標がスタート地点となります");
//        PluginManager pm = getServer().getPluginManager();
//        World w = getServer().getWorld("GeoDash");
//        Location startlocation = new Location(w, 0,5,0); //change startlocation later
//        SpawnSlime slimy = new SpawnSlime();
//        Slime slime = slimy.cube(startlocation);
//        player.sendMessage("start!!");
//        BukkitTask repeat = new RepeatCast(this, player, slime).runTaskTimer(this, 1L, 1L);
//        pm.registerEvents(new SlimeJump(this, player, slime), this);
//        pm.registerEvents(new  MapMaking(this), this);
//        player.getInventory().setHeldItemSlot(1);
//        player.getInventory().setItem(1, new ItemStack(Material.SLIME_BALL,1));

        return true;
    }
    public void registerEvents(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(this, this);
        pm.registerEvents(new MapMaking(this), this); //change this later so that this runs only for a
        //player who presses a minecraft button. Make pillar root blocks customizable.
    }


    }

