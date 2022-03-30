package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class RepeatCast extends BukkitRunnable {
    GeometryDash plugin;
    public static Player player;
    public static Slime slime;
    public static Slime camera;
    public RepeatCast(GeometryDash plugin, Player sender, Slime slimed, Slime camerad){
        this.plugin = plugin;
        player = sender;
        slime = slimed;
        camera = camerad;
    }


    @Override
    public void run() {
        World w = getServer().getWorld("GeoDash");
        Player player = RepeatCast.player;
        Slime slime = RepeatCast.slime;
        Slime camera = RepeatCast.camera;
        if(slime!=null) {
            SlimeStatusChecker.jumpable(slime);
            SpawnPillar.Spawn(slime.getLocation().add(15,0,0));
            MoveSlime.move(slime);

            SlimeLauncher.Launcher(slime);
            BreakStuffBehind.Break(slime);
            CameraMover.Mover(player, slime, camera);
                if(GameOver.Over(player, slime, camera)) {
                cancel();
                }
            }





// If cancel is needed
//        Slime slime = SpawnSlime.slime;
//        if(slime==null) {
//            cancel();
//        }
        }
    }



