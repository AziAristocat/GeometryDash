package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;

public class BreakStuffBehind {
    public static void Break(){
        Location CheckPos = SpawnSlime.slime.getLocation().add(-10,0,0);
        Location BreakUp = GetPillarRoot.closestRoot(CheckPos, Material.DIAMOND_BLOCK);
        Location BreakDown = GetPillarRoot.closestRoot(CheckPos, Material.PRISMARINE_BRICKS);
        if (BreakUp!=null) {


            for (int y = 1; y < 5; y++) {
                Location root2 = BreakUp.getBlock().getLocation().add(0, y, 0);
                root2.getBlock().setType(Material.AIR);
            }

        }
        if (BreakDown!=null) {
            for (int y = 1; y < 5; y++) {
                Location root2 = BreakDown.getBlock().getLocation().add(0, -y, 0);
                root2.getBlock().setType(Material.AIR);
            }

        }





    }
}
