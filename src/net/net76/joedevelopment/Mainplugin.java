package net.net76.joedevelopment;

import java.util.ArrayList;

import org.bukkit.*;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Mainplugin extends JavaPlugin {
	
	private static int teamint = 1;
	private static int team1playeramount = 0;
	private static int team2playeramount = 0;
	private static Inventory shop = Bukkit.createInventory(null, 45, "Shop");
	private static ItemStack shop_CANNON = new ItemStack(Material.TNT);
	private static ArrayList<Player> team1players = new ArrayList<Player>();
	
	public void onEnable() {
		shop.addItem(shop_CANNON);
		getServer().getPluginManager().registerEvents(new Listener() {
			@EventHandler
			public void onPlayerInteract(PlayerInteractEvent e) {
				if(e.getClickedBlock() != null && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
					if(e.getClickedBlock().getType().equals(Material.SIGN_POST) || e.getClickedBlock().getType().equals(Material.WALL_SIGN)) {
						Sign s = (Sign)e.getClickedBlock().getState();
						if(s.getLine(0).equalsIgnoreCase(ChatColor.DARK_AQUA+"[CastleClash]") && s.getLine(1).equalsIgnoreCase("JOIN")) {
							if(teamint == 1) {
								if(Team1.addPlayer(e.getPlayer())) {
									teamint++;
									getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.GREEN+e.getPlayer().getName()+" joined the CastleClash game.");
									if(teamint >= 3) {
										teamint = 1;
									}
								} else {
									teamint++;
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"Failed to join:");
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+" - You may already be in the game");
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+" - The team that you were attempted to be put in is full in which case you can try clicking the sign again");
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+" - The game has already started");
									if(teamint >= 3) {
										teamint = 1;
									}
								}
							} else if(teamint == 2) {
								if(Team2.addPlayer(e.getPlayer())) {
									teamint++;
									getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.GREEN+e.getPlayer().getName()+" joined the CastleClash game.");
									if(teamint >= 3) {
										teamint = 1;
									}
								} else {
									teamint++;
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"Failed to join:");
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+" - You may already be in the game");
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+" - The team that you were attempted to be put in is full in which case you can try clicking the sign again");
									e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+" - The game has already started");
									if(teamint >= 3) {
										teamint = 1;
									}
								}
							}
						}
					} else if(e.getClickedBlock().getType().equals(Material.OBSIDIAN)) {
						if(ShopKeeper.contains(e.getClickedBlock().getLocation().getBlockX(),e.getClickedBlock().getLocation().getBlockY()-1,e.getClickedBlock().getLocation().getBlockZ())) {
							ItemMeta meta = shop_CANNON.getItemMeta();
							meta.setDisplayName(ChatColor.AQUA+"[Team] CANNON");
							e.getPlayer().openInventory(shop);
						}
					}
				}
			}
			
			@EventHandler
			public void onInventoryClick(InventoryClickEvent e) {
				if(e.getCurrentItem() != null && e.getInventory() != null && e.getWhoClicked() != null) {
					if(e.getCurrentItem().equals(shop_CANNON)) {
						((Player)e.getWhoClicked()).sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"This has not been implemented yet.");
						e.setCancelled(true);
					}
				}
			}
			
			@EventHandler
			public void onPlayerQuit(PlayerQuitEvent e) {
				Team1.removePlayer(e.getPlayer());
				Team2.removePlayer(e.getPlayer());
			}
		}, this);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player sender = (Player)s;
		if(c.getName().equalsIgnoreCase("addshopblock")) {
			if(sender.getWorld().getBlockAt(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ()).getType().equals(Material.OBSIDIAN)) {
				if(ShopKeeper.contains(sender.getLocation().getBlockX(),sender.getLocation().getBlockY()-1,sender.getLocation().getBlockZ())) {
					sender.sendMessage("�3[CastleClash: ADMIN] �cA shop is already registered here.");
				} else {
					ShopKeeper.addToList(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ());
				}
			} else {
				sender.sendMessage("�3[CastleClash: ADMIN] �cThere must be obsidian under you to register a shop.");
			}
		} else if(c.getName().equalsIgnoreCase("setTeamSpawnPoint")) {
			sender.sendMessage("�3[CastleClash: ADMIN] �cThis has not been implemented yet. Contact the owner of the server if you think this is a mistake.");
		}
		return false;
	}
}
