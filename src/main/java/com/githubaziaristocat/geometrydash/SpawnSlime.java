package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

import static org.bukkit.Bukkit.getServer;

public class SpawnSlime {
    public static Slime slime;



        public static void cube(Location loc){

            World w = getServer().getWorld("GeoDash");
            slime = (Slime) w.spawnEntity(loc, EntityType.SLIME);
            slime.setSize(2);
            slime.setWander(false);
            slime.setCustomName("GEODY");

    }
}


