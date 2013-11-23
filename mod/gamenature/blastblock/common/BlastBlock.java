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

@Mod(modid = "blastblock", name = "Blast Block", version = "1.6.4B")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, versionBounds = "[1.6.4B]")

public class BlastBlock {


	@Instance("blastblock")
	public static BlastBlock instance;

	// Proxy defs
	@SidedProxy(clientSide="mod.gamenature.blastblock.client.ClientProxy", serverSide="mod.gamenature.blastblock.common.CommonProxy")
	public static CommonProxy proxy;


	//Block Declarations
	public static Block blastblock;
	public static Block blastlight;
	public static Block blastLampOn;
	public static Block blastLampOff;

	//Special/Technical Blocks
	//slabs
	public static BlockHalfSlab blastsingle;
	public static BlockHalfSlab blastdouble;

	//Creative Tab
	public static CreativeTabs tabBlastBlock = new CreativeTabs("tabCustom") {
		public ItemStack getIconItemStack() {
			return new ItemStack(blastblock, 1, 0);
		}
	};

	@EventHandler
	public void init(FMLInitializationEvent event) {

		//Block Declares go here!
		blastblock = new BlockBlastBlock(3974, "blastblock").setUnlocalizedName("blastblock:blast").setCreativeTab(tabBlastBlock).setTextureName("blastblock:concrete");
		blastlight = new BlockBlastLight(3975, "blastblock").setUnlocalizedName("blastblock:blastlight").setCreativeTab(tabBlastBlock).setLightValue(1.0F).setTextureName("blastblock:light");

		blastdouble = (BlockHalfSlab)(new BlockBlastSlab(3976, true)).setHardness(5.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("rubydouble").setTextureName("blastblock:concrete");
		blastsingle = (BlockHalfSlab)(new BlockBlastSlab(3977, false)).setHardness(5.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("rubysingle").setCreativeTab(tabBlastBlock).setTextureName("blastblock:concrete");

		blastLampOn = new BlockBlastLamp(3978, true).setHardness(5.0F).setResistance(2000.0F).setLightValue(1.0F).setUnlocalizedName("blastblock:blastlampActive").setTextureName("blastblock:lampActive");
		blastLampOff = new BlockBlastLamp(3979, false).setHardness(5.0F).setResistance(2000.0F).setCreativeTab(tabBlastBlock).setUnlocalizedName("blastblock:blastlampIdle").setTextureName("blastblock:lampIdle");

		//Block Registry
		GameRegistry.registerBlock(blastblock, "blastblock");
		GameRegistry.registerBlock(blastlight, "blastlight");
		GameRegistry.registerBlock(blastLampOn, "blastLampOn");
		GameRegistry.registerBlock(blastLampOff, "blastLampOff");

		//Language Registry
		LanguageRegistry.addName(blastblock, "Blast Resistant Stone");
		LanguageRegistry.addName(blastlight, "Blast Resistant Light");
		LanguageRegistry.addName(blastLampOff, "Blast Resistant Powered Light");
		LanguageRegistry.addName(blastLampOn, "Blast Resistant Powered Light");
		
		//Non-Block/Item Related Language Registry
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabCustom", "en_US", "BlastBlock");

		//Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(blastblock), "xxx", "iii", "xxx" , 'x', Block.stone, 'i', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(blastlight, 8), "xxx", "xix", "xxx" , 'x', Block.glowStone, 'i', blastblock);

		//Slab Recipe
		GameRegistry.addRecipe(new ItemStack(blastsingle,6), "xxx" , 'x', blastblock);

		//Slab Language
		LanguageRegistry.instance().addStringLocalization(((BlockHalfSlab)blastsingle).getFullSlabName(0)+".name", "Blast Resistant Slab");

	}
	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {

		Item.itemsList[blastsingle.blockID] = (new ItemSlab(blastsingle.blockID - 256, (BlockHalfSlab)blastsingle, (BlockHalfSlab)blastdouble, false)).setUnlocalizedName("rubyMod:decor");
	}

}