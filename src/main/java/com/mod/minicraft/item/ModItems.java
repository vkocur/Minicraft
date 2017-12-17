package com.mod.minicraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

import com.mod.minicraft.MinicraftMod;

@ObjectHolder(MinicraftMod.MODID)
public class ModItems {

	public static ItemBase ingotCopper;

	public static void init() {
		ingotCopper = new ItemBase("ingotCopper").setCreativeTab(CreativeTabs.MATERIALS);
	}

	
	@Mod.EventBusSubscriber(modid = MinicraftMod.MODID)
	public static class RegistrationHandler {
		public static final Set<Item> ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] items = {
					ingotCopper,
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
				((ItemBase) item).registerItemModel();
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
