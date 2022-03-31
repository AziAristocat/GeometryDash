package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Slime;

import static org.bukkit.Bukkit.getServer;

public class SlimeLauncher {

    public static void Launcher(Slime slime){
        World w = getServer().getWorld("GeoDash");
        Location loc = new Location(w,0,0,0);
        if(slime!=null) {
            loc = slime.getLocation().add(0,-0.6,0);
        }

        if(loc.getBlock().getType() == Material.SEA_LANTERN) {
            SlimeStatusChecker.gravity=1.2;
            SlimeStatusChecker.isJumpable=false;
        }
        }



    }

