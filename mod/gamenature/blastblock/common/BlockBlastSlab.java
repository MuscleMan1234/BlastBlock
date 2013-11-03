package mod.gamenature.blastblock.common;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBlastSlab extends BlockHalfSlab
{


	public BlockBlastSlab(int par1, boolean par2)
	{
		super(par1, par2, Material.rock);
		setBurnProperties(this.blockID, 5, 20);
		useNeighborBrightness[this.blockID] = true;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return BlastBlock.blastsingle.blockID;
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		if(par1World.getBlockId(par2, par3 - 1, par4) == BlastBlock.blastsingle.blockID)
		{
			par1World.setBlock(par2, par3, par4, 0);
			par1World.setBlock(par2, par3 - 1, par4, BlastBlock.blastdouble.blockID);
		}
		if(par1World.getBlockId(par2, par3 + 1, par4) == BlastBlock.blastsingle.blockID)
		{
			par1World.setBlock(par2, par3, par4, 0);
			par1World.setBlock(par2, par3 + 1, par4, BlastBlock.blastdouble.blockID);
		}
	}

	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(BlastBlock.blastsingle.blockID, 2, par1 & 7);
	}



	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par1 != BlastBlock.blastdouble.blockID)
		{
			par3List.add(new ItemStack(par1, 1, 0));
		}
	}

	@Override
	public String getFullSlabName(int i) {
		// TODO Auto-generated method stub
		return "BlastSlab";
	}
	public int idPicked (World world, int x, int y, int z) {
		return BlastBlock.blastsingle.blockID;

	}
}