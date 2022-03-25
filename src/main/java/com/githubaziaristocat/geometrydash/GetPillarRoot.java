package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Set;

public class GetPillarRoot {
    //    /**
//     * Finds the closest block in a vertical column.
//     * @param origin The location around which to search.
//     *               This location will NOT be included in the search, but all other locations in the column will.
//     * @param types  A Set (preferably a HashSet) that contains the type IDs of blocks to search for
//     * @return The closest block, or null if one was not found in the column.
//     *         In the case of a tie, the higher block wins.
//     */
    public static Location closestBlock(Location origin, Material mat) {
        int x = origin.getBlockX();
        int y = origin.getBlockY();
        int z = origin.getBlockZ();
        World w = origin.getWorld();

        for (int cy = 2; cy < 512; cy++) {
            
            int testY;
            if ((cy & 1) == 0) //if even
            {
                testY = y + cy / 2;
                if (testY > 255)
                    continue;
            } else {
                testY = y - cy / 2;
                if (testY < 0)
                    continue;
            }

            Location loc = new Location(w, x, testY,z);
            Material examined = (w.getBlockAt(x, testY, z)).getType();
            if (examined == mat) {
//
                return (loc);
            }
//            if (types.contains(w.getBlockAt(x, testY, z))) {
//
//                return (loc);
//            }
        }

        return null;
    }
}


//...
//example usage
       // Block closest = closestBlock(loc, new HashSet<Integer>(Arrays.asList(Material.WOOD.getId())));