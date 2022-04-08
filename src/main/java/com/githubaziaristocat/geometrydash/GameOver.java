package com.githubaziaristocat.geometrydash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class GameOver {
    public static boolean Over(Player player, Slime slime, Slime camera, Location startpoint, ArrayList<ItemStack> MapBlocks) {

        World w = getServer().getWorld("GeoDash");
        Location trap = slime.getLocation().add(0.8,0,0);
        if(slime != null && player.getEquipment().getItemInMainHand().getType() != Material.SLIME_BALL || w.getBlockAt(trap).getType()==MapBlocks.get(2).getType() || w.getBlockAt(trap).getType()==MapBlocks.get(5).getType()|| w.getBlockAt(trap.add(-1.6,-0.8,0)).getType()==MapBlocks.get(5).getType()) {
            //if unequip slime ball or slime touches iron then game over.
            Location loc = new Location(w, 0, 4, -5);
            loc = startpoint.add(-1,0,2);
            loc.setYaw(180);
            player.teleport(loc);
            slime.setSize(0);
            slime.setHealth(0);
            CameraMover.y = 5;
            CameraMover.ay = 0;
            camera.setSize(0);
            camera.setHealth(0);
            slime = null;
            camera = null;
            GeometryDash.playing.remove(player);
            return true;

        }
        return false;
        }


    }


