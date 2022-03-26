package com.githubaziaristocat.geometrydash;
import org.bukkit.util.Vector;
import org.bukkit.entity.Slime;
public class MoveSlime {


    public static void move() {
        Slime slime = SpawnSlime.slime;
        double vectX = 0.2;
        if (slime != null) {

            slime.setVelocity(new Vector(vectX, SlimeStatusChecker.gravity, 0));
        }
    }

}

