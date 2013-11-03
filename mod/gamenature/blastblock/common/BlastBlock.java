package mod.gamenature.blastblock.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "blastblock", name = "Blast Block", version = "1.6.4A")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, versionBounds = "[1.6.4A]")

public class BlastBlock {


	@Instance("blastblock")
	public static BlastBlock instance;

	// Proxy defs
	@SidedProxy(clientSide="mod.gamenature.blastblock.client.ClientProxy", serverSide="mod.gamenature.blastblock.common.CommonProxy")
	public static CommonProxy proxy;


	//Block Declarations
	public static Block blastblock;
	
	//Special/Technical Blocks
    //slabs
    public static BlockHalfSlab blastsingle;
    public static BlockHalfSlab blastdouble;

	@EventHandler
	public void init(FMLInitializationEvent event) {

		//Block Declares go here!
		blastblock = new BlockBlastBlock(3997, "blastblock").setUnlocalizedName("blastblock:blast").setCreativeTab(CreativeTabs.tabBlock).setTextureName("blastblock:concrete");
		
		blastdouble = (BlockHalfSlab)(new BlockBlastSlab(3998, true)).setHardness(20F).setResistance(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("rubydouble").setTextureName("blastblock:concrete");
        blastsingle = (BlockHalfSlab)(new BlockBlastSlab(3999, false)).setHardness(20F).setResistance(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("rubysingle").setCreativeTab(CreativeTabs.tabBlock).setTextureName("blastblock:concrete");
		
		//Block Registry
		GameRegistry.registerBlock(blastblock, "blastblock");

		//Language Registry
		LanguageRegistry.addName(blastblock, "Blast Resistant Stone");
		LanguageRegistry.addName(blastsingle, "Blast Resistant Slab");

		//Crafting Recipe
		GameRegistry.addRecipe(new ItemStack(blastblock), "xxx", "iii", "xxx" , 'x', Block.stone, 'i', Block.obsidian);
		
		//Slab Language
		LanguageRegistry.instance().addStringLocalization(((BlockHalfSlab)blastsingle).getFullSlabName(0)+".name", "Blast Resistant Slab");
		
	}
	@EventHandler
    public static void postInit( FMLPostInitializationEvent event ) {

            Item.itemsList[blastsingle.blockID] = (new ItemSlab(blastsingle.blockID - 256, (BlockHalfSlab)blastsingle, (BlockHalfSlab)blastdouble, false)).setUnlocalizedName("rubyMod:decor");
    }

}