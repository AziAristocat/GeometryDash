package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class RepeatCast extends BukkitRunnable {
    GeometryDash plugin;
    public static Player player;
    public static Slime slime;
    public RepeatCast(GeometryDash plugin, Player sender, Slime slimed){
        this.plugin = plugin;
        player = sender;
        slime = slimed;
    }


    @Override
    public void run() {
        World w = getServer().getWorld("GeoDash");
        Player player = RepeatCast.player;
        Slime slime = RepeatCast.slime;
        if(slime!=null) {
            SlimeStatusChecker.jumpable(slime);
            SpawnPillar.Spawn(SpawnSlime.slime.getLocation().add(10,0,0));
            MoveSlime.move(slime);
            CameraMover.Mover(player, slime);
            SlimeLauncher.Launcher(slime);
            BreakStuffBehind.Break(slime);
                if(GameOver.Over(player, slime)) {
                cancel();
                }
            }
        if(player!=null) {
            MapMaking.placer(player);
        }




// If cancel is needed
//        Slime slime = SpawnSlime.slime;
//        if(slime==null) {
//            cancel();
//        }
        }
    }



