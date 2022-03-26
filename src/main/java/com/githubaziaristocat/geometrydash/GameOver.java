package com.githubaziaristocat.geometrydash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class GameOver {
    public static void Over() {
        World w = getServer().getWorld("GeoDash");
        Player player = Bukkit.getPlayer(GeometryDash.PlayerID);
        Location trap = SpawnSlime.slime.getLocation().add(0.8,0,0);
        if(SpawnSlime.slime != null && player.getEquipment().getItemInMainHand().getType() != Material.SLIME_BALL || w.getBlockAt(trap).getType()==Material.IRON_BLOCK || w.getBlockAt(trap.add(0,0.8,0)).getType()==Material.IRON_BLOCK) {
            //if unequip slime ball or slime touches iron then game over.
            Location loc = new Location(w, 0, 4, -5);
            player.teleport(loc);
            SpawnSlime.slime.setSize(0);
            SpawnSlime.slime.setHealth(0);
            CameraMover.y = 5;
            CameraMover.ay = 0;
            SpawnSlime.slime = null;
        }
        }


    }


