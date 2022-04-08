package com.githubaziaristocat.geometrydash;


import net.md_5.bungee.api.chat.ItemTag;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

public class SlimeJump implements Listener {
    private GeometryDash plugin;
    public static Slime slime;
    public static Player player;
    public static Slime camera;

    public SlimeJump(GeometryDash plugin, Player sender, Slime slimer, Slime camerad) {
        this.plugin = plugin;
        player = sender;
        slime = slimer;
        camera = camerad;

    }

    @EventHandler(priority = EventPriority.NORMAL)
    public static void onEvent(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR) {


            //if command sender = left clicker
            if (slime != null && SlimeStatusChecker.isJumpable && player.getEquipment().getItemInMainHand().getType() == Material.SLIME_BALL
                    && event.getPlayer() == player && player.getWorld() == GeometryDash.w) {
                //  player.sendMessage("Jump!!!");
                Location loc = slime.getLocation().add(-2, 4, -15);


                SlimeStatusChecker.gravity = 0.8;  //jump height

                SlimeStatusChecker.isJumpable = false;
            }


        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public static void onFall(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL && event.getEntity().getWorld().equals(GeometryDash.w)
                && (event.getEntity() == slime
                || event.getEntity() == camera)) {

            event.setCancelled(true);

        }
        if (event.getEntity().getWorld().equals(GeometryDash.w)
        && event.getEntity() == player){
            event.setCancelled((true));

        }


    }
    @EventHandler(priority = EventPriority.NORMAL)
    public static void onBreak(BlockBreakEvent event) {

        if (event.getPlayer().getWorld().equals(GeometryDash.w)
                && GeometryDash.playing.contains(player)){
            event.setCancelled((true));

        }


    }
}