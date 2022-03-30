package com.githubaziaristocat.geometrydash;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.util.Vector;

import static org.bukkit.Bukkit.getServer;

public class CameraMover {
    public static double ay = 0;
    public static double y = 5;
    public static void Mover(Player player, Slime slime, Slime camera){
        if(player.getEquipment().getItemInMainHand().getType() == Material.SLIME_BALL){
//            if(player.getLocation().getY()>slime.getLocation().getY() && ay>=-0.1){
//                ay-=0.01;
//            }else if(ay<=0.1) {
//                ay+=0.01;
//            }
//            if(y!=slime.getLocation().getY()){
//                y+=ay;
//            }
            y = player.getLocation().getY();
        }
            World w = getServer().getWorld("GeoDash");;
            Location loc = new Location(w,slime.getLocation().getX(), slime.getLocation().getY(), -15, 0,0);
        if(SlimeStatusChecker.gravity>0.6 && slime.getLocation().getY()>camera.getLocation().getY()-3) {
            Vector addVect = new Vector(0,0.15,0);
            camera.setVelocity(slime.getVelocity().add(addVect));
        }else {
            camera.setVelocity(slime.getVelocity());
        }
        }
//            player.teleport(loc);



        }






