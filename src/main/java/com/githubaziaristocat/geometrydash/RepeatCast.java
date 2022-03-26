package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Slime;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class RepeatCast extends BukkitRunnable {
    GeometryDash plugin;
    public RepeatCast(GeometryDash plugin){
        this.plugin = plugin;


    }

    @Override
    public void run() {
        World w = getServer().getWorld("GeoDash");
        Location playerlocation = GeometryDash.playerlocation;
        if(SpawnSlime.slime!=null) {
            SlimeStatusChecker.jumpable();
            SpawnPillar.Spawn(SpawnSlime.slime.getLocation().add(10,0,0));
            MoveSlime.move();
            CameraMover.Mover();
            GameOver.Over();
            AutoPiston.Launcher();
            BreakBehindStuff.Break();
        }
        if(GeometryDash.PlayerID!=null) {
            MapMaking.placer();
        }




// If cancel is needed
//        Slime slime = SpawnSlime.slime;
//        if(slime==null) {
//            cancel();
//        }
        }
    }



