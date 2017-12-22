package com.mod.minicraft.block;

import java.util.HashSet;
import java.util.Set;

import com.mod.minicraft.MinicraftMod;
import com.mod.minicraft.item.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	public static BlockOre oreCopper;
	
	public static void init() {
		oreCopper = new BlockOre("oreCopper").setCreativeTab(CreativeTabs.MATERIALS);
	}

	@Mod.EventBusSubscriber(modid = MinicraftMod.MODID)
	public static class RegistrationHandler {
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Block[] blocks = {
					oreCopper,
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Block block : blocks) {
				ItemBlock itemBlock = new ItemBlock(block);
				itemBlock.setRegistryName(block.getRegistryName());
				registry.register(itemBlock);
				ITEM_BLOCKS.add(itemBlock);
				if (block instanceof BlockBase) {
					((BlockBase)block).registerItemModel(itemBlock);
				}
			}

			initializeItems();
		}
		
		/**
		 * Initialize items
		 */
		public static void initializeItems() {
		}
	}

}