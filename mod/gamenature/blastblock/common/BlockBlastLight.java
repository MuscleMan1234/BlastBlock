package mod.gamenature.blastblock.common;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockBlastLight extends Block {

	String texture;

	public BlockBlastLight(int par1, String texture) {
		super(par1, Material.rock);
		this.texture = texture;
		setHardness(5.0F);
		setResistance(2000.0F);
		setStepSound(soundStoneFootstep);
	}

	public int idDropped(int par1, Random par2Random, int three)
	{
		return this.blockID;
	}


}