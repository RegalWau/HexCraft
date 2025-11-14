package com.celestek.hexcraft.init;

import com.celestek.hexcraft.block.BlockAdvancedRainbowCore;
import com.celestek.hexcraft.block.BlockConcentricHexoriumBlock;
import com.celestek.hexcraft.block.BlockConversionComputer;
import com.celestek.hexcraft.block.BlockCrystalSeparator;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEnergyNodeCore;
import com.celestek.hexcraft.block.BlockEnergyNodePortEU;
import com.celestek.hexcraft.block.BlockEnergyNodePortHEX;
import com.celestek.hexcraft.block.BlockEnergyNodePortLU;
import com.celestek.hexcraft.block.BlockEnergyNodePortRF;
import com.celestek.hexcraft.block.BlockEnergyPylon;
import com.celestek.hexcraft.block.BlockEngineeredHexoriumBlock;
import com.celestek.hexcraft.block.BlockFramedHexoriumBlock;
import com.celestek.hexcraft.block.BlockGlowingHexoriumCoatedStone;
import com.celestek.hexcraft.block.BlockGlowingHexoriumGlass;
import com.celestek.hexcraft.block.BlockHexoriumButton;
import com.celestek.hexcraft.block.BlockHexoriumCable;
import com.celestek.hexcraft.block.BlockHexoriumCoatedStone;
import com.celestek.hexcraft.block.BlockHexoriumDoor;
import com.celestek.hexcraft.block.BlockHexoriumFurnace;
import com.celestek.hexcraft.block.BlockHexoriumGenerator;
import com.celestek.hexcraft.block.BlockHexoriumHatch;
import com.celestek.hexcraft.block.BlockHexoriumLamp;
import com.celestek.hexcraft.block.BlockHexoriumLampInv;
import com.celestek.hexcraft.block.BlockHexoriumMachineBlock;
import com.celestek.hexcraft.block.BlockHexoriumPressurePlate;
import com.celestek.hexcraft.block.BlockHexoriumStructureCasing;
import com.celestek.hexcraft.block.BlockHexoriumSwitch;
import com.celestek.hexcraft.block.BlockMatrixReconstructor;
import com.celestek.hexcraft.block.BlockMiniEnergizedHexorium;
import com.celestek.hexcraft.block.BlockOfHexoriumCrystal;
import com.celestek.hexcraft.block.BlockPersonalTeleportationPad;
import com.celestek.hexcraft.block.BlockPlatedHexoriumBlock;
import com.celestek.hexcraft.block.BlockPylonBase;
import com.celestek.hexcraft.block.BlockQuantumAnchor;
import com.celestek.hexcraft.block.BlockQuantumObserver;
import com.celestek.hexcraft.block.BlockSoundProjector;
import com.celestek.hexcraft.block.BlockTankValve;
import com.celestek.hexcraft.block.BlockTemperedHexoriumGlass;
import com.celestek.hexcraft.item.HexItemComponent;
import com.celestek.hexcraft.item.ItemHexoriumDye;
import com.celestek.hexcraft.item.ItemHexoriumManipulator;
import com.celestek.hexcraft.item.ItemHexoriumProbe;
import com.celestek.hexcraft.item.ItemHexoriumReinforcer;
import com.celestek.hexcraft.item.ItemHexoriumSaw;
import com.celestek.hexcraft.item.ItemMolecularTransposer;
import com.celestek.hexcraft.item.ItemMortarPestle;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class HexRecipes {

    /**
     * Initializes all recipes and adds them to GameRegistry.
     */
    public static void initializeRecipes() {

        /* Blocks */

        // Gem Blocks
        BlockOfHexoriumCrystal.registerRecipes();

        // Energized
        BlockEnergizedHexorium.registerRecipes();
        BlockMiniEnergizedHexorium.registerRecipes();

        // Decorative
        BlockEngineeredHexoriumBlock.registerRecipes();
        BlockFramedHexoriumBlock.registerRecipes();
        BlockPlatedHexoriumBlock.registerRecipes();
        BlockConcentricHexoriumBlock.registerRecipes();
        BlockHexoriumStructureCasing.registerRecipes();
        BlockGlowingHexoriumCoatedStone.registerRecipes();
        BlockGlowingHexoriumGlass.registerRecipes();
        BlockHexoriumLamp.registerRecipes();
        BlockHexoriumLampInv.registerRecipes();
        BlockHexoriumDoor.registerRecipes();
        BlockHexoriumHatch.registerRecipes();

        // Machines
        BlockHexoriumMachineBlock.registerRecipes();
        BlockAdvancedRainbowCore.registerRecipes();
        BlockHexoriumGenerator.registerRecipes();
        BlockHexoriumFurnace.registerRecipes();
        BlockCrystalSeparator.registerRecipes();
        BlockMatrixReconstructor.registerRecipes();
        BlockPersonalTeleportationPad.registerRecipes();
        BlockQuantumObserver.registerRecipes();
        BlockQuantumAnchor.registerRecipes();

        // Tank
        BlockTankValve.registerRecipes();

        // Energy Node
        BlockEnergyNodeCore.registerRecipes();
        BlockConversionComputer.registerRecipes();
        BlockEnergyNodePortHEX.registerRecipes();
        BlockEnergyNodePortRF.registerRecipes();
        if (Loader.isModLoaded("IC2"))
            BlockEnergyNodePortEU.registerRecipes();
        if (Loader.isModLoaded("gregapi"))
            BlockEnergyNodePortLU.registerRecipes();

        // Cables
        BlockHexoriumCable.registerRecipes();

        // Energy Pylon
        BlockEnergyPylon.registerRecipes();

        // Redstone
        BlockHexoriumSwitch.registerRecipes();
        BlockHexoriumButton.registerRecipes();
        BlockHexoriumPressurePlate.registerRecipes();

        // Regular Blocks
        BlockTemperedHexoriumGlass.registerRecipes();
        BlockHexoriumCoatedStone.registerRecipes();
        BlockPylonBase.registerRecipes();
        BlockSoundProjector.registerRecipes();

        /* Items */

        // Hex Components
        HexItemComponent.registerRecipes();

        // Tools
        ItemHexoriumManipulator.registerRecipes();
        ItemHexoriumProbe.registerRecipes();
        ItemMolecularTransposer.registerRecipes();
        ItemHexoriumReinforcer.registerRecipes();
        ItemMortarPestle.registerRecipes();
        ItemHexoriumSaw.registerRecipes();

        // Dyes
        ItemHexoriumDye.registerRecipes();
    }

    public static boolean isStackEqual(ItemStack itemstack1, ItemStack itemstack2) {
        return itemstack2.getItem() == itemstack1.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack1.getItemDamage());
    }
}