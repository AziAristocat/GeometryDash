package com.githubaziaristocat.geometrydash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CameraMover {
    public static double ay = 0;
    public static double y = 5;
    public static void Mover(){
        Player player = Bukkit.getPlayer(GeometryDash.PlayerID);
        if(player.getEquipment().getItemInMainHand().getType() == Material.SLIME_BALL){
            if(player.getLocation().getY()>SpawnSlime.slime.getLocation().getY() && ay>=-0.1){
                ay-=0.01;
            }else if(ay<=0.1) {
                ay+=0.01;
            }
            if(y!=SpawnSlime.slime.getLocation().getY()){
                y+=ay;
            }}
            World w = getServer().getWorld("GeoDash");;
            Location loc = new Location(w,SpawnSlime.slime.getLocation().getX(), y, -15, 0,0);
            player.teleport(loc);



        }





    }
