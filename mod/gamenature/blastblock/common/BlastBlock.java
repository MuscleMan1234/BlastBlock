package mod.gamenature.blastblock.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "blastblock", name = "Blast Block", version = "1.6.4A")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, versionBounds = "[1.6.4A]")

public class BlastBlock {


	@Instance("easygunpowder")
	public static BlastBlock instance;

	// Proxy defs
	@SidedProxy(clientSide="mod.gamenature.blastblock.client.ClientProxy", serverSide="mod.gamenature.blastblock.common.CommonProxy")
	public static CommonProxy proxy;


	//Block Declarations
	public static Block blastblock;

	@EventHandler
	public void init(FMLInitializationEvent event) {

		//Block Declares go here!
		blastblock = new BlockBlastBlock(1092, "blastblock").setUnlocalizedName("blastblock:blast").setCreativeTab(CreativeTabs.tabBlock);

		//Block Registry
		GameRegistry.registerBlock(blastblock, "Sulfir");

		//Language Registry
		LanguageRegistry.addName(blastblock, "Blastproof Stone");

		//Crafting Recipe
		GameRegistry.addRecipe(new ItemStack(blastblock), "xxx", "xxx", "xxx" , 'x', Item.gunpowder);
		
		
		
	}

}