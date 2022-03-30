package com.githubaziaristocat.geometrydash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;

import static org.bukkit.Bukkit.getServer;

public class GameOver {
    public static boolean Over(Player player, Slime slime) {

        World w = getServer().getWorld("GeoDash");
        Location trap = slime.getLocation().add(0.8,0,0);
        if(slime != null && player.getEquipment().getItemInMainHand().getType() != Material.SLIME_BALL || w.getBlockAt(trap).getType()==Material.IRON_BLOCK || w.getBlockAt(trap).getType()==Material.NETHER_BRICK|| w.getBlockAt(trap.add(0,0.8,0)).getType()==Material.IRON_BLOCK) {
            //if unequip slime ball or slime touches iron then game over.
            Location loc = new Location(w, 0, 4, -5);
            player.teleport(loc);
            slime.setSize(0);
            slime.setHealth(0);
            CameraMover.y = 5;
            CameraMover.ay = 0;
            slime = null;
            return true;

        }
        return false;
        }


    }


