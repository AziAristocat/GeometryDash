package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Slime;

import static com.githubaziaristocat.geometrydash.GetPillarRoot.closestRoot;
import static org.bukkit.Bukkit.getServer;

public class SpawnPillar {

    public static void Spawn(Location loc) {


        World w = getServer().getWorld("GeoDash");

      if (closestRoot(loc, Material.DIAMOND_BLOCK) != null) {

                Location closest = closestRoot(loc, Material.DIAMOND_BLOCK);
                for (int y = 1; y < 5; y++) {
                    if (y == 4) {
                        Location pillarroot = new Location(w, closest.getX(), closest.getY() + y, closest.getZ());
                        pillarroot.getBlock().setType(Material.OBSIDIAN);
                    } else {
                        Location pillarroot = new Location(w, closest.getX(), closest.getY() + y, closest.getZ());
                        pillarroot.getBlock().setType(Material.IRON_BLOCK);

                    }
                }
            }
            if (closestRoot(loc, Material.PRISMARINE_BRICKS) != null) {
                Location closest = closestRoot(loc, Material.PRISMARINE_BRICKS);
                for (int y = 1; y < 5; y++) {
                    Location pillarroot = new Location(w, closest.getX(), closest.getY() - y, closest.getZ());
                    pillarroot.getBlock().setType(Material.IRON_BLOCK);


                }
            }
            //for map making

//        getServer().broadcastMessage(slime.getName());




    }
    public static void Maker(Location loc){
        World w = getServer().getWorld("GeoDash");
        if (loc.getBlock().getType() == Material.DIAMOND_BLOCK) {
            for (int y = 1; y < 5; y++) {
                if (y == 4) {
                    Location pillarroot = new Location(w, loc.getX(), loc.getY() + y, loc.getZ());
                    pillarroot.getBlock().setType(Material.OBSIDIAN);
                } else {
                    Location pillarroot = new Location(w, loc.getX(), loc.getY() + y, loc.getZ());
                    pillarroot.getBlock().setType(Material.IRON_BLOCK);

                }
            }
        }

        else if (loc.getBlock().getType() == Material.PRISMARINE_BRICKS) {

            for (int y = 1; y < 5; y++) {
                Location pillarroot = new Location(w, loc.getX(), loc.getY() - y, loc.getZ());
                pillarroot.getBlock().setType(Material.IRON_BLOCK);


            }
        }


    }
}
