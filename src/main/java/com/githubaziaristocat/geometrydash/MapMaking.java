package com.githubaziaristocat.geometrydash;


import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class MapMaking extends BukkitRunnable implements Listener {
    World w = getServer().getWorld("GeoDash");
    public static Player player;
    public static Double z;
    GeometryDash plugin;
    public static ArrayList<ItemStack> MapBlocks = new ArrayList<ItemStack>();

    public MapMaking(GeometryDash plugin, Player sender, double startz, ArrayList<ItemStack> MB) {
        player = sender;
        this.plugin = plugin;
        z = startz;
        MapBlocks = MB;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlace(BlockPlaceEvent event1) {
        Player player = event1.getPlayer();
        if (player.getEquipment().getItemInOffHand().getType() == Material.SLIME_BALL && player == MapMaking.player && player.getWorld() == GeometryDash.w)
        {
            if (event1.getBlockPlaced().getType() == MapBlocks.get(0).getType() || event1.getBlockPlaced().getType() == MapBlocks.get(1).getType()) {
                Location root1 = event1.getBlockPlaced().getLocation();
                SpawnPillar.Maker(root1, MapBlocks);
            }
        }

    }


    @EventHandler(priority = EventPriority.NORMAL)
    public void onBreak(BlockBreakEvent event2) {
        Player player = event2.getPlayer();
        if (player.getEquipment().getItemInOffHand().getType() == Material.SLIME_BALL && player == MapMaking.player && player.getWorld() == GeometryDash.w) {
            if (event2.getBlock().getType() == MapBlocks.get(0).getType()) {


                for (int y = 1; y < 5; y++) {
                    Location root2 = event2.getBlock().getLocation().add(0, y, 0);
                    root2.getBlock().setType(Material.AIR);
                }

            } else if (event2.getBlock().getType() == MapBlocks.get(1).getType()) {
                for (int y = 1; y < 5; y++) {
                    Location root2 = event2.getBlock().getLocation().add(0, -y, 0);
                    root2.getBlock().setType(Material.AIR);
                }

            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public static void BreakAll(PlayerInteractEvent event) {
        Player player =  MapMaking.player;

        if (event.getAction() == Action.LEFT_CLICK_AIR && event.getPlayer() == MapMaking.player && player.getWorld() == GeometryDash.w) {



                if (player.getEquipment().getItemInMainHand().getType() == Material.MAGMA_CREAM) {
                    ConsoleCommandSender console = getServer().getConsoleSender();
                    //couldn't find an easy "replace block in area" command so using commands
                    String playerX1 = Integer.toString((int)(Math.round(player.getLocation().getX())));
                    String playerX2 = Integer.toString((int)(Math.round(player.getLocation().getX()-50)));
                    int y1 = (int)(Math.round(player.getLocation().getY()+25));
                    int y2 = (int)(Math.round(player.getLocation().getY()-25));
                    int z = (int)(Math.round(MapMaking.z + 1));
                    if (y1<0){
                        y1 = 0;
                    }else if(y2<0){
                        y2 = 0;
                    }
                    String name = player.getName();
                    String playerY1 = Integer.toString(y1);
                    String playerY2 = Integer.toString(y2);
                    String playerZ = Integer.toString(z);
                    String block1 = MapBlocks.get(2).getType().toString();

                    String block2 = MapBlocks.get(3).getType().toString();
                    String command1 = "execute at " + name + " run fill "+ playerX1 +" " + playerY1 +" " + playerZ + " " + playerX2 + " " + playerY2 + " " + playerZ + " air replace minecraft:" + block1.toLowerCase();
                    String command2 = "execute at " + name + " run fill "+ playerX1 +" " + playerY1 +" " + playerZ + " " + playerX2 + " " + playerY2 + " " + playerZ + " air replace minecraft:" + block2.toLowerCase();

                    Bukkit.dispatchCommand(console, command1);
                    Bukkit.dispatchCommand(console, command2);
                }





        }


    }
   public void run(){
        Player player = MapMaking.player;

        Double z = MapMaking.z;

        World w = getServer().getWorld("GeoDash");
        if(player!=null && player.getWorld() == GeometryDash.w) {
            if (player.getEquipment().getItemInMainHand().getType() == Material.SLIME_BLOCK) {
                Location loc = new Location(w, player.getLocation().getX(), player.getLocation().getY(), z+1);

                    SpawnPillar.Spawn(loc, MapBlocks);

                }
                }
            }
        }







