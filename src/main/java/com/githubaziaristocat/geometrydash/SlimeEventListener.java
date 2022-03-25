//package com.githubaziaristocat.geometrydash;
//
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.EventPriority;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//
//public class SlimeEventListener implements Listener {
//
//    private GeometryDash plugin;
//    public SlimeEventListener(GeometryDash plugin){
//        this.plugin = plugin;
//    }
//
//    @EventHandler(priority = EventPriority.NORMAL)
//    //PLayerInteractEventなどを指定するとこが大事
//    public void onEvent(PlayerInteractEvent event) {
//        if(event.getAction() == Action.LEFT_CLICK_AIR){
//            Player player = event.getPlayer();
//            player.sendMessage("you've clicked!!!");
//
//        }
//    }
//}
