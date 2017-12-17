package com.mod.minicraft;

import com.mod.minicraft.item.ChatItems;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MinicraftMod.MODID, version = MinicraftMod.VERSION, name = MinicraftMod.NAME)
public class MinicraftMod
{
    public static final String MODID = "minicraftmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Minicraft Mod";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
        MinecraftForge.EVENT_BUS.register(new ChatItems());
    }
}
