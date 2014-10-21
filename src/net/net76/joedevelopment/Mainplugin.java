package net.net76.joedevelopment;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.*;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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
	private static ItemStack shop_FENCE = new ItemStack(Material.FENCE);
	private static ItemStack shop_BONE = new ItemStack(Material.BONE);
	private static ArrayList<Player> team1players = new ArrayList<Player>();
	/*
	 * Team 1: RED
	 * Team 2: BLUE
	 * 
	 * (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 */
	public void onEnable() {
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
						if(ShopKeeper.contains(e.getClickedBlock().getLocation().getBlockX(),e.getClickedBlock().getLocation().getBlockY(),e.getClickedBlock().getLocation().getBlockZ())) {
							shop.clear();
							ItemMeta meta = shop_CANNON.getItemMeta();
							meta.setDisplayName(ChatColor.DARK_AQUA+"[25 Coins] "+ChatColor.GREEN+"Buy 1 Cannon");
							List<String> list3 = new ArrayList<String>();
							list3.add(ChatColor.RESET+"This will spawn in 1 cannon");
							list3.add(ChatColor.RESET+"so you can fire at the other");
							list3.add(ChatColor.RESET+"team");
							meta.setLore(list3);
							shop_CANNON.setItemMeta(meta);
							ItemMeta meta2 = shop_FENCE.getItemMeta();
							meta2.setDisplayName(ChatColor.DARK_AQUA+"[3 Coins] "+ChatColor.GREEN+"Buy 1 Fence Layer");
							List<String> list2 = new ArrayList<String>();
							list2.add(ChatColor.RESET+"This will spawn in 1 fence");
							list2.add(ChatColor.RESET+"layer for extra protection.");
							meta2.setLore(list2);
							shop_FENCE.setItemMeta(meta2);
							ItemMeta meta3 = shop_BONE.getItemMeta();
							meta3.setDisplayName(ChatColor.DARK_AQUA+"[15 Coins] "+ChatColor.GREEN+"Spawn 5 Skeletons");
							List<String> list = new ArrayList<String>();
							list.add(ChatColor.RESET+"The skeletons will attack a");
							list.add(ChatColor.RESET+"specific player that is not");
							list.add(ChatColor.RESET+"on your team.");
							meta3.setLore(list);
							shop_BONE.setItemMeta(meta3);
							shop.setItem(0, shop_CANNON);
							shop.setItem(4, shop_FENCE);
							shop.setItem(8, shop_BONE);
							e.getPlayer().openInventory(shop);
						}
					}
				}
				DataDecoder.DecodeAndInsert();
			}
			
			@EventHandler
			public void onInventoryClick(InventoryClickEvent e) {
				if(e.getCurrentItem() != null && e.getInventory() != null && e.getWhoClicked() != null) {
					if(e.getCurrentItem().equals(shop_CANNON) && e.getInventory().equals(shop)) {
						((Player)e.getWhoClicked()).sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"This has not been implemented yet.");
						e.setCancelled(true);
					} else if(e.getCurrentItem().equals(shop_BONE) && e.getInventory().equals(shop)) {
						((Player)e.getWhoClicked()).sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"This has not been implemented yet.");
						e.setCancelled(true);
					} else if(e.getCurrentItem().equals(shop_FENCE) && e.getInventory().equals(shop)) {
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
			
			@EventHandler
			public void onPlayerJoin(PlayerJoinEvent e) {
				e.setJoinMessage(ChatColor.YELLOW+e.getPlayer().getName()+ChatColor.GRAY+" joined the game. "+ChatColor.DARK_GRAY+Bukkit.getServer().getOnlinePlayers().toArray().length+"/"+Bukkit.getServer().getMaxPlayers());
				getServer().broadcastMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.GREEN+"A player has joined the game. A total of 6 players in the lobby are needed to start the game.");
				if(teamint == 1) {
					if(Team1.addPlayer(e.getPlayer())) {
						teamint++;
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
				if(Team1.length() == 3 && Team2.length() == 3) {
					ActiveGame.startGame();
				}
			}
			
			@EventHandler
			public void onPlayerPreProcessCommand(PlayerCommandPreprocessEvent e) {
				if(Team1.inTeam(e.getPlayer()) || Team2.inTeam(e.getPlayer())) {
					if(e.getMessage().equalsIgnoreCase("/spawn")) {
						e.getPlayer().sendMessage(ChatColor.DARK_AQUA+"[CastleClash] "+ChatColor.RED+"You cannot run that command while you are in the game.");
						e.setCancelled(true);
					}
				}
			}
		}, this);
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player sender = (Player)s;
		if(c.getName().equalsIgnoreCase("addshopblock")) {
			if(sender.getWorld().getBlockAt(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ()).getType().equals(Material.OBSIDIAN)) {
				if(ShopKeeper.contains(sender.getLocation().getBlockX(),sender.getLocation().getBlockY()-1,sender.getLocation().getBlockZ())) {
					sender.sendMessage("§3[CastleClash: ADMIN] §cA shop is already registered here.");
				} else {
					ShopKeeper.addToList(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ());
					sender.sendMessage("§3[CastleClash: ADMIN] §aShop registered.");
				}
			} else {
				sender.sendMessage("§3[CastleClash: ADMIN] §cThere must be obsidian under you to register a shop.");
			}
		} else if(c.getName().equalsIgnoreCase("removeshopblock")) {
			if(ShopKeeper.contains(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ())) {
				ShopKeeper.remove(sender.getLocation().getBlockX(), sender.getLocation().getBlockY()-1, sender.getLocation().getBlockZ());
				sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"Shop was removed.");
			} else {
				sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.RED+"There is no shop under you!");
			}
		} else if(c.getName().equalsIgnoreCase("removeallshops")) {
			ShopKeeper.removeALL();
			sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"All shops were removed.");
		} else if(c.getName().equalsIgnoreCase("setteamspawn")) {
			if(args.length < 1) {
				sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.RED+"Wrong syntax: Not enough arguments.");
				return false;
			} else if(args.length > 1) {
				sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.RED+"Wrong syntax: Too many arguments.");
				return false;
			} else {
				if(args[0].equalsIgnoreCase("1")) {
					Team1.setSpawn(sender.getLocation().getBlockX(), sender.getLocation().getBlockY(), sender.getLocation().getBlockZ());
					sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"Set spawn for team 1.");
				} else if(args[0].equalsIgnoreCase("2")) {
					Team2.setSpawn(sender.getLocation().getBlockX(), sender.getLocation().getBlockY(), sender.getLocation().getBlockZ());
					sender.sendMessage(ChatColor.DARK_AQUA+"[CastleClash: ADMIN] "+ChatColor.GREEN+"Set spawn for team 2.");
				}
			}
		} else if(c.getName().equalsIgnoreCase("nogame")) {
			ActiveGame.nogame(sender);
		} else if(c.getName().equalsIgnoreCase("spawnoverride")) {
			getServer().dispatchCommand(getServer().getConsoleSender(), "spawn "+sender.getName());
		}
		DataEncoder.Encode();
		return true;
	}
}
