package de.elicis.lom.champions.skills;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.elicis.lom.api.LoM_API;

public abstract class Skill {
	Player player;
	int manaCost;
	ItemStack iconItem;
	int slot;
	int cooldown;
	
	public Skill(Player player2, int mana, ItemStack iconItem, int slot, int cooldown) {
		player = player2;
		manaCost = mana;
		this.iconItem = iconItem;
		this.slot = slot;
		if(this.slot > 8){
			this.slot = 8;
		}
		if(this.slot < 0){
			this.slot = 0;
		}
		this.cooldown = cooldown;
	}

	public abstract void useSkill();
	
	
	public void setItemSlot(String displayName){
		ItemMeta im = iconItem.getItemMeta();
		im.setDisplayName(displayName);
		iconItem.setItemMeta(im);
		player.getInventory().setItem(slot, iconItem);
	}
	
	public boolean hasMana(){
		if(LoM_API.isInArena(player)){
			if(LoM_API.getArenaP(player).getChamps().get(player.getName()).getMana() >= manaCost){
				return true;
			}
		}
		return false;
	}
	
	public int getSlot(){
		return slot;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public int getCooldown(){
		return cooldown;
	}
	
	public ItemStack getIconItem(){
		return iconItem;
	}
}
