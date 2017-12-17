package com.mod.minicraft.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatItems {

	@SubscribeEvent
	public void giveItems(ServerChatEvent event) {
		if (event.getMessage().toLowerCase().contains("iron")) {
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(
					Items.IRON_INGOT, 2));
		}
		if (event.getMessage().toLowerCase().contains("diamond")) {
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(
					Items.DIAMOND, 1));
		}
		if (event.getMessage().toLowerCase().contains("cookie")) {
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(
					Items.COOKIE, 10));
		}
	}
}