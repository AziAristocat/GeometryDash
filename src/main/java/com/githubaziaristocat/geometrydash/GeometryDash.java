package com.githubaziaristocat.geometrydash;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.*;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public final class GeometryDash extends JavaPlugin implements CommandExecutor, Listener {
    private static GeometryDash instance;
    public static HashMap<Sign, UUID> Editors = new HashMap<Sign, UUID>();
    public static List<Player> playing = new ArrayList<>();
    public GeometryDash (){
        instance = this;
    }

    public static GeometryDash getInstance() {
        return instance;
    }
    public static Location loc;
    public static Location playerlocation;
    public static World w = getWorld("GeoDash");
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

       registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBreak(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getEquipment().getItemInOffHand().getType() != Material.SLIME_BALL && player.getWorld().equals(w)){
        Block block = event.getClickedBlock();
        if(block.getState() instanceof Sign sign) {
            if(sign.line(0).equals(Component.text("Start"))) {
                playing.add(player);
                PluginManager pm = getServer().getPluginManager();
                World w = getServer().getWorld("GeoDash");
                Location startlocation = new Location(w, 0, 5, 0);
                startlocation = block.getLocation();
                SpawnSlime slimy = new SpawnSlime();
                Slime slime = slimy.cube(startlocation);
                player.sendMessage("start!!");
                Slime camera = (Slime) w.spawnEntity(startlocation.add(2,3,-15), EntityType.SLIME);
                camera.setSize(2);
                camera.setInvisible(true);
                camera.setWander(false);
                camera.addPassenger(player);

                BukkitTask repeat = new RepeatCast(this, player, slime, camera, block.getLocation()).runTaskTimer(this, 0, 1);
                pm.registerEvents(new SlimeJump(this, player, slime, camera), this);
                player.getInventory().setHeldItemSlot(1);
                player.getInventory().setItem(1, new ItemStack(Material.SLIME_BALL));
            }else if(sign.line(0).equals(Component.text("Editor"))){
                player.sendMessage("スライムボールを左手持ちしながらダイヤかプリズマリンブロックを置くとそこから柱が生えてくる。そして根元壊すと全部壊れる。ネザーブロックは鉄同様当たったら死ぬ。マグマクリームで左クリックで鉄と黒曜石だけ壊す。スライムブロックを持ってると同じX座標のダイヤブロックから柱が生える");
                PluginManager pm = getServer().getPluginManager();
                event.setCancelled(true);
                if(Editors == null){
                    Editors.put(sign, player.getUniqueId());

                }

                else if(Editors.get(sign)!=player.getUniqueId()) {
                    //make editors a hashmap with uuid as key and list as output. list contains block materials
                    pm.registerEvents(new MapMaking(this, player, sign.getZ()), this); //change this later so that this runs only for a
                    //player who presses a minecraft button. Make pillar root blocks customizable. Do so by refactoring Material.DIAMOND...
                    //and stuff to a variable
                    BukkitTask placer = new MapMaking(this, player, sign.getZ()).runTaskTimer(this, 0, 1);
                    Editors.replace(sign, player.getUniqueId());

                    player.getInventory().setItem(2, new ItemStack(Material.DIAMOND_BLOCK, 1));
                    player.getInventory().setItem(3, new ItemStack(Material.PRISMARINE_BRICKS, 1));
                    player.getInventory().setItem(4, new ItemStack(Material.NETHER_BRICKS, 1));
                    player.getInventory().setItem(5, new ItemStack(Material.MAGMA_CREAM, 1));
                    player.getInventory().setItem(6, new ItemStack(Material.SEA_LANTERN, 1));
                    player.getInventory().setItem(7, new ItemStack(Material.SLIME_BLOCK, 1));

                }
            }
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event1){
        if(event1.getBlockPlaced().getState() instanceof Sign
                && event1.getPlayer().getEquipment().getItemInMainHand().getItemMeta().displayName().equals(Component.text("Start Point")) && event1.getPlayer().getWorld() == GeometryDash.w)
        {
            //https://www.spigotmc.org/threads/how-to-read-a-signs-lines.38741/
            Block block = event1.getBlock();
            Sign sign = (Sign) block.getState();
            sign.setEditable(false);

            sign.line(0, Component.text("Start"));
            sign.update();
            Location loc  = new Location(w, 0, 0, -1);
            loc = sign.getLocation().add(0,0,-1);
            w.setType(loc, Material.OAK_SIGN);
            Sign sign2 = (Sign) loc.getBlock().getState();
            sign2.setEditable(false);

            sign2.line(0, Component.text("Editor"));
            sign2.update();

        }




    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        //Spawns slime and starts game
        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        if(player.getWorld() != GeometryDash.w){
            player.sendMessage("ワールド名：GeoDashでのみ作動");
            return false;
        }
        ItemStack sign = new ItemStack(Material.ACACIA_SIGN);
        player.getInventory().setItem(0, sign);
        ItemMeta signMeta = sign.getItemMeta();
        signMeta.displayName(Component.text("Start Point"));
        player.getInventory().getItem(0).setItemMeta(signMeta);
        player.sendMessage("その看板を置いたら出てくるStartを左クリックで、そこからXの+方向にスライムが進む。Editで色々ツールが出てくる");
//        PluginManager pm = getServer().getPluginManager();
//        World w = getServer().getWorld("GeoDash");
//        Location startlocation = new Location(w, 0,5,0); //change startlocation later
//        SpawnSlime slimy = new SpawnSlime();
//        Slime slime = slimy.cube(startlocation);
//        player.sendMessage("start!!");
//        BukkitTask repeat = new RepeatCast(this, player, slime).runTaskTimer(this, 1L, 1L);
//        pm.registerEvents(new SlimeJump(this, player, slime), this);
//        pm.registerEvents(new  MapMaking(this), this);
//        player.getInventory().setHeldItemSlot(1);
//        player.getInventory().setItem(1, new ItemStack(Material.SLIME_BALL,1));

        return true;
    }
    public void registerEvents(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(this, this);

    }


    }

