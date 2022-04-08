package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class RepeatCast extends BukkitRunnable {
    GeometryDash plugin;
    public static Player player;
    public static Slime slime;
    public static Slime camera;
    public static Location startpoint;
    public static ArrayList<ItemStack> MapBlocks = new ArrayList<ItemStack>();
    public RepeatCast(GeometryDash plugin, Player sender, Slime slimed, Slime camerad, Location start, ArrayList<ItemStack> MB){

        this.plugin = plugin;
        startpoint = start;
        player = sender;
        slime = slimed;
        camera = camerad;
        MapBlocks = MB;
    }


    @Override
    public void run() {
        World w = getServer().getWorld("GeoDash");
        Player player = RepeatCast.player;
        Slime slime = RepeatCast.slime;
        Slime camera = RepeatCast.camera;
        Location startpoint = RepeatCast.startpoint;
        if(slime!=null) {
            SlimeStatusChecker.jumpable(slime);
            SpawnPillar.Spawn(slime.getLocation().add(15,0,0), MapBlocks);
            SpawnPillar.Spawn(slime.getLocation().add(15,-1,0), MapBlocks);
            MoveSlime.move(slime);

            SlimeLauncher.Launcher(slime, MapBlocks);
            BreakStuffBehind.Break(slime.getLocation().add(-10,0,0), MapBlocks);
            BreakStuffBehind.Break(slime.getLocation().add(-10,-1,0), MapBlocks);
            CameraMover.Mover(player, slime, camera);
                if(GameOver.Over(player, slime, camera, startpoint, MapBlocks)) {
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



