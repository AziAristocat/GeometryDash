//package com.githubaziaristocat.geometrydash;
//
//import org.bukkit.Location;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//import org.bukkit.scheduler.BukkitTask;
//
//public class StartGame implements CommandExecutor {
//    public static Location loc;
//    GeometryDash plugin;
//     void GeometryDash(GeometryDash plugin){
//        GeometryDash JavaPlugin = plugin;
//
//
//    }
//
//
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
//
//        //ここにコマンドが入力されたときの処理を書く
//        if(!(sender instanceof Player)) return false;  //senderがプレイヤーのインスタンスでなければ実行失敗
//        Player player = (Player) sender;  //senderをプレイヤーとしてキャスト
//        Location loc=player.getLocation();
//        SpawnSlime geo = new SpawnSlime();
//        geo.cube(loc);
//        player.sendMessage("start!!");
//        BukkitTask SpawnPillar = new SpawnPillar(plugin).runTaskTimer(plugin, 1L, 20L);
//
//        return true;
//    }
//}
