package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Slime;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import static com.githubaziaristocat.geometrydash.GetPillarRoot.closestBlock;
import static org.bukkit.Bukkit.getServer;

public class SpawnPillar extends BukkitRunnable {
    GeometryDash plugin;
    public SpawnPillar(GeometryDash plugin){
        this.plugin = plugin;


    }

    @Override
    public void run() {
        World w = getServer().getWorld("GeoDash");
        Location playerlocation = GeometryDash.playerlocation;
        Slime slime = SpawnSlime.slime;
        Location loc = slime.getLocation();
        loc.add(10,0,0);
        Location closest = closestBlock(loc, Material.DIAMOND_BLOCK);

//        getServer().broadcastMessage(slime.getName());



        for (int y = 1; y < 5; y++) {
            Location pillarroot = new Location(w, closest.getX(), closest.getY() + y, closest.getZ());
            pillarroot.getBlock().setType(Material.IRON_BLOCK);
        }

        String slimex = String.valueOf(closest.getX());
        getServer().broadcastMessage(slimex);

        if(w.getNearbyEntitiesByType(Slime.class,playerlocation, 10 )==null) {
            cancel();
        }
        }
    }


//        new GetPillarRoot();
//        World w = getServer().getWorld("GeoDash");
//        Location playerlocation = StartGame.loc;
//        Slime slime = (Slime) w.getNearbyEntities(playerlocation, 10, 10, 10);
//        Location loc = slime.getLocation();
////        Location closest = closestBlock(loc, new HashSet<Material>(Arrays.<Material>asList(Material.BARRIER.getData())));
//        Location closest = closestBlock(loc, Material.BARRIER);
//        for (int y = 1; y < 5; y++) {
//            Location pillarroot = new Location(w, closest.getX(), closest.getY() + y, closest.getZ());
//            pillarroot.getBlock().setType(Material.DIAMOND_BLOCK);
//        }
//        String slimex = String.valueOf(closest.getX());
//        getServer().broadcastMessage(slimex);



