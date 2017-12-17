package com.mod.minicraft;

import com.mod.minicraft.item.ChatItems;
import com.mod.minicraft.item.ModItems;
import com.mod.minicraft.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MinicraftMod.MODID, version = MinicraftMod.VERSION, name = MinicraftMod.NAME)
public class MinicraftMod
{
    public static final String MODID = "minicraftmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Minicraft Mod";

	@Mod.Instance(MODID)
	public static MinicraftMod instance;

	@SidedProxy(serverSide = "com.mod.minicraft.proxy.CommonProxy", clientSide = "com.mod.minicraft.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(NAME + " preInit ...");
		ModItems.init();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	System.out.println(NAME + " init ...");
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
        MinecraftForge.EVENT_BUS.register(new ChatItems());
    }

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(NAME + " postInit ...");
	}    
}
