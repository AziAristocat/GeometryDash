package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static com.githubaziaristocat.geometrydash.GetPillarRoot.closestRoot;
import static org.bukkit.Bukkit.getServer;

public class SpawnPillar {

    public static void Spawn(Location loc, ArrayList<ItemStack> MapBlocks) {


        World w = getServer().getWorld("GeoDash");

      if (closestRoot(loc, MapBlocks.get(0).getType()) != null) {

                Location closest = closestRoot(loc, MapBlocks.get(0).getType());
                for (int y = 1; y < 5; y++) {
                    if (y == 4) {
                        Location pillarroot = new Location(w, closest.getX(), closest.getY() + y, closest.getZ());
                        pillarroot.getBlock().setType(MapBlocks.get(3).getType());
                    } else {
                        Location pillarroot = new Location(w, closest.getX(), closest.getY() + y, closest.getZ());
                        pillarroot.getBlock().setType(MapBlocks.get(2).getType());

                    }
                }
            }
            if (closestRoot(loc, MapBlocks.get(1).getType()) != null) {
                Location closest = closestRoot(loc, MapBlocks.get(1).getType());
                for (int y = 1; y < 5; y++) {
                    Location pillarroot = new Location(w, closest.getX(), closest.getY() - y, closest.getZ());
                    pillarroot.getBlock().setType(MapBlocks.get(2).getType());


                }
            }
            //for map making

//        getServer().broadcastMessage(slime.getName());




    }
    public static void Maker(Location loc, ArrayList<ItemStack> MapBlocks){
        World w = getServer().getWorld("GeoDash");
        if (loc.getBlock().getType() == MapBlocks.get(0).getType()) {
            for (int y = 1; y < 5; y++) {
                if (y == 4) {
                    Location pillarroot = new Location(w, loc.getX(), loc.getY() + y, loc.getZ());
                    pillarroot.getBlock().setType(MapBlocks.get(3).getType());
                } else {
                    Location pillarroot = new Location(w, loc.getX(), loc.getY() + y, loc.getZ());
                    pillarroot.getBlock().setType(MapBlocks.get(2).getType());

                }
            }
        }

        else if (loc.getBlock().getType() == MapBlocks.get(1).getType()) {

            for (int y = 1; y < 5; y++) {
                Location pillarroot = new Location(w, loc.getX(), loc.getY() - y, loc.getZ());
                pillarroot.getBlock().setType(MapBlocks.get(2).getType());


            }
        }


    }
}
