package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BreakStuffBehind {
    public static void Break(Location CheckPos, ArrayList<ItemStack> MapBlocks){

        Location BreakUp = GetPillarRoot.closestRoot(CheckPos, MapBlocks.get(0).getType());
        Location BreakDown = GetPillarRoot.closestRoot(CheckPos, MapBlocks.get(1).getType());
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
