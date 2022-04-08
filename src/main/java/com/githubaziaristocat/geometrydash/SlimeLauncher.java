package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class SlimeLauncher {

    public static void Launcher(Slime slime, ArrayList<ItemStack> MapBlocks){
        World w = getServer().getWorld("GeoDash");
        Location loc = new Location(w,0,0,0);
        if(slime!=null) {
            loc = slime.getLocation().add(0,-0.6,0);
        }

        if(loc.getBlock().getType() == MapBlocks.get(4).getType()) {
            SlimeStatusChecker.gravity=1.2;
            SlimeStatusChecker.isJumpable=false;
        }
        }



    }

