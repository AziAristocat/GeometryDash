package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Powerable;
import org.bukkit.block.data.type.Piston;

import static org.bukkit.Bukkit.getServer;

public class AutoPiston {

    public static void Launcher(){
        World w = getServer().getWorld("GeoDash");
        Location loc = new Location(w,0,0,0);
        if(SpawnSlime.slime!=null) {
            loc = SpawnSlime.slime.getLocation().add(0,-0.8,0);
        }

        if(loc.getBlock().getType() == Material.SEA_LANTERN) {
            SlimeStatusChecker.gravity=1.2;
        }
        }



    }

