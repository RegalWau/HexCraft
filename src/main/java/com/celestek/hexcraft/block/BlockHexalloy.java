package com.celestek.hexcraft.block;

import com.celestek.hexcraft.HexCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockHexalloy extends Block implements IHexBlock{
    
    // Set default block name.
    public static final String ID = "blockHexalloy";
    
    public BlockHexalloy(String blockName){
        super(Material.iron);
        
        // Set all block parameters.
        this.setBlockName(blockName);
        this.setCreativeTab(HexCraft.tabDecorative);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5F);
        this.setResistance(10F);
        
        this.setStepSound(Block.soundTypeMetal);
        
    }
    
    // Prepare the icons.
    @SideOnly(Side.CLIENT)
    private IIcon icon;
    
    // Registers the icons.
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = iconRegister.registerIcon(HexCraft.MODID + ":" + ID);
    }
    
    // Fetches icon.
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon;
    }
    
    public static void registerBlock() {
        Block block = new BlockHexalloy(ID);
        GameRegistry.registerBlock(block, ID);
    }
    
    @Override
    public String getID() {
        return ID;
    }
}