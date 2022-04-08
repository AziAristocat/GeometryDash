package com.githubaziaristocat.geometrydash;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;

import java.util.ArrayList;

public class PlaySound {
    public static void play(Slime slime, Location loc, Player player){
        World w = GeometryDash.w;
        if(w.getBlockAt(new Location(w,Math.round(slime.getLocation().getX()), loc.getY(),loc.getZ()-10)).getBlockData() instanceof NoteBlock noteB) {
            int X = (int) Math.round(slime.getLocation().getX());
            if (!GeometryDash.noteBlocks.get(player).contains(X)){
                GeometryDash.noteBlocks.get(player).add(X);
//                player.sendMessage(GeometryDash.noteBlocks.get(player).toString());

                player.playNote(player.getLocation(), noteB.getInstrument(), noteB.getNote());GeometryDash.noteBlocks.get(player).add(X);
            }
        }
    }
}
