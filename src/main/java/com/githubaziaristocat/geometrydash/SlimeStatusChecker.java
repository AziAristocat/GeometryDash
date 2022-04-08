package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Slime;

import static org.bukkit.Bukkit.getServer;

public class SlimeStatusChecker {
    public static boolean isJumpable = false;
    public static double gravity;

    public static void jumpable(Slime slime) {


        Location loc = slime.getLocation().add(0, -0.251, 0);
        World w = getServer().getWorld("GeoDash");
        if (slime != null && w.getBlockAt(loc).getType() != Material.AIR) {
            //checking whether the blokc under the slime is not air
            if(gravity!=0 && isJumpable) {
                gravity = 0;
            }
            isJumpable = true;

        } else {
            isJumpable = false;
            if (gravity >= -3.92) {
                gravity -= 0.0784;

            }

        }
    }
}


