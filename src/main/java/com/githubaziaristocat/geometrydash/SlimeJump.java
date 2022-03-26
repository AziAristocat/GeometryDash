package com.githubaziaristocat.geometrydash;


import net.md_5.bungee.api.chat.ItemTag;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

public class SlimeJump implements Listener {
    private GeometryDash plugin;
    public SlimeJump(GeometryDash plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public static void onEvent(PlayerInteractEvent event) {
        if(event.getAction() == Action.LEFT_CLICK_AIR){
            Player player = event.getPlayer();

            if (player.getUniqueId() == GeometryDash.PlayerID){
                //if command sender = left clicker
                if(SpawnSlime.slime != null && SlimeStatusChecker.isJumpable == true && player.getEquipment().getItemInMainHand().getType() == Material.SLIME_BALL) {
                  //  player.sendMessage("Jump!!!");
                    SlimeStatusChecker.gravity=0.73;  //jump height

                    SlimeStatusChecker.isJumpable = false;
                }

            }


        }
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public static void onFall(EntityDamageEvent falling){
        if(falling.getCause() == EntityDamageEvent.DamageCause.FALL){
            falling.setCancelled(true);

        }



    }
}