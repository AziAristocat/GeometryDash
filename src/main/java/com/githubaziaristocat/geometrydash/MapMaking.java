package com.githubaziaristocat.geometrydash;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.awt.*;

import static org.bukkit.Bukkit.getServer;

public class MapMaking implements Listener {
    World w = getServer().getWorld("GeoDash");
    private GeometryDash plugin;

    public MapMaking(GeometryDash plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlace(BlockPlaceEvent event1) {
        Player player = event1.getPlayer();
        if (player.getEquipment().getItemInOffHand().getType() == Material.SLIME_BALL) {
            if (event1.getBlockPlaced().getType() == Material.DIAMOND_BLOCK || event1.getBlockPlaced().getType() == Material.PRISMARINE_BRICKS) {
                Location root1 = event1.getBlockPlaced().getLocation();
                SpawnPillar.Spawn(root1);
            }
        }
        if(event1.getBlockPlaced().getState() instanceof Sign){
            //https://www.spigotmc.org/threads/how-to-read-a-signs-lines.38741/
            Sign sign = (Sign) event1.getBlockPlaced().getState();
            player.sendMessage("command didn't work");
            sign.line(0, Component.text("Left Click to Start"));



        }
    }


    @EventHandler(priority = EventPriority.NORMAL)
    public void onBreak(BlockBreakEvent event2) {
        Player player = event2.getPlayer();
        if (player.getEquipment().getItemInOffHand().getType() == Material.SLIME_BALL) {
            if (event2.getBlock().getType() == Material.DIAMOND_BLOCK) {


                for (int y = 1; y < 5; y++) {
                    Location root2 = event2.getBlock().getLocation().add(0, y, 0);
                    root2.getBlock().setType(Material.AIR);
                }

            } else if (event2.getBlock().getType() == Material.PRISMARINE_BRICKS) {
                for (int y = 1; y < 5; y++) {
                    Location root2 = event2.getBlock().getLocation().add(0, -y, 0);
                    root2.getBlock().setType(Material.AIR);
                }

            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public static void BreakAll(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = event.getPlayer();


                if (player.getEquipment().getItemInMainHand().getType() == Material.MAGMA_CREAM) {
                    ConsoleCommandSender console = getServer().getConsoleSender();
                    //couldn't find an easy "replace block in area" command so using commands
                    String playerX1 = Integer.toString((int)(Math.round(player.getLocation().getX())));
                    String playerX2 = Integer.toString((int)(Math.round(player.getLocation().getX()-50)));
                    int y1 = (int)(Math.round(player.getLocation().getY()+25));
                    int y2 = (int)(Math.round(player.getLocation().getY()-25));
                    if (y1<0){
                        y1 = 0;
                    }else if(y2<0){
                        y2 = 0;
                    }
                    String name = player.getName();
                    String playerY1 = Integer.toString(y1);
                    String playerY2 = Integer.toString(y2);
                    String command1 = "execute at " + name + " run fill "+ playerX1 +" " + playerY1 +" 0 " + playerX2 +" "+ playerY2 + " 0 air replace minecraft:iron_block";
                    String command2 = "execute at " + name + " run fill "+ playerX1 +" " + playerY1 +" 0 " + playerX2 +" "+playerY2+ " 0 air replace minecraft:obsidian";
                    Bukkit.dispatchCommand(console, command1);
                    Bukkit.dispatchCommand(console, command2);
                }





        }


    }
    public static void placer(Player player){
        World w = getServer().getWorld("GeoDash");
        if(player!=null) {
            if (player.getEquipment().getItemInMainHand().getType() == Material.SLIME_BLOCK) {
                Location loc = new Location(w, player.getLocation().getX(), player.getLocation().getY(), 0);
                SpawnPillar.Spawn(GetPillarRoot.closestRoot(loc, Material.DIAMOND_BLOCK));
                SpawnPillar.Spawn(GetPillarRoot.closestRoot(loc, Material.PRISMARINE_BRICKS));
            }
        }


    }
}



