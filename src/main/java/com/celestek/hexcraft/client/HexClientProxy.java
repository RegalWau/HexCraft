package com.celestek.hexcraft.client;

import com.celestek.hexcraft.HexCommonProxy;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.block.BlockAdvancedRainbowCore;
import com.celestek.hexcraft.block.BlockConcentricHexoriumBlock;
import com.celestek.hexcraft.block.BlockConversionComputer;
import com.celestek.hexcraft.block.BlockCrystalSeparator;
import com.celestek.hexcraft.block.BlockEnergizedHexorium;
import com.celestek.hexcraft.block.BlockEnergizedHexoriumMonolith;
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
import com.celestek.hexcraft.block.BlockHexoriumDoor;
import com.celestek.hexcraft.block.BlockHexoriumFurnace;
import com.celestek.hexcraft.block.BlockHexoriumGenerator;
import com.celestek.hexcraft.block.BlockHexoriumHatch;
import com.celestek.hexcraft.block.BlockHexoriumLamp;
import com.celestek.hexcraft.block.BlockHexoriumLampInv;
import com.celestek.hexcraft.block.BlockHexoriumMachineBlock;
import com.celestek.hexcraft.block.BlockHexoriumMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherMonolith;
import com.celestek.hexcraft.block.BlockHexoriumNetherOre;
import com.celestek.hexcraft.block.BlockHexoriumOre;
import com.celestek.hexcraft.block.BlockHexoriumPressurePlate;
import com.celestek.hexcraft.block.BlockHexoriumStructureCasing;
import com.celestek.hexcraft.block.BlockHexoriumSwitch;
import com.celestek.hexcraft.block.BlockMatrixReconstructor;
import com.celestek.hexcraft.block.BlockMiniEnergizedHexorium;
import com.celestek.hexcraft.block.BlockOfHexoriumCrystal;
import com.celestek.hexcraft.block.BlockPersonalTeleportationPad;
import com.celestek.hexcraft.block.BlockPlatedHexoriumBlock;
import com.celestek.hexcraft.block.BlockQuantumAnchor;
import com.celestek.hexcraft.block.BlockQuantumObserver;
import com.celestek.hexcraft.block.BlockTankRender;
import com.celestek.hexcraft.block.BlockTankValve;
import com.celestek.hexcraft.init.HexBlocks;
import com.celestek.hexcraft.init.HexConfig;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class HexClientProxy extends HexCommonProxy {

    // Minecraft's internal ID of a certain block. Length controlled in HexBlocks.
    public static int renderID[] = new int[HexBlocks.countBlocks];

    // Render pass for every block. Length controlled in HexBlocks.
    public static int renderPass[] = new int[HexBlocks.countBlocks];

    /**
     * Handles preInit.
     */
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        // Set up custom rendering.
        setCustomRenderers();
    }

    /**
     * Handles init.
     */
    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    /**
     * Handles postInit.
     */
    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    /**
     * Registers renderers for all block.
     */
    public static void setCustomRenderers() {
        // Prepare HexCraft's block ID counter.
        HexCraft.idCounter = 0;

        // Ores
        BlockHexoriumOre.registerRenders();
        BlockHexoriumMonolith.registerRenders();
        BlockHexoriumNetherOre.registerRenders();
        BlockHexoriumNetherMonolith.registerRenders();

        // Block of Hexorium Crystal
        BlockOfHexoriumCrystal.registerRenders();

        // Energized
        BlockEnergizedHexorium.registerRenders();
        BlockMiniEnergizedHexorium.registerRenders();
        BlockEnergizedHexoriumMonolith.registerRenders();

        // Decorative
        BlockEngineeredHexoriumBlock.registerRenders();
        BlockFramedHexoriumBlock.registerRenders();
        BlockPlatedHexoriumBlock.registerRenders();
        BlockConcentricHexoriumBlock.registerRenders();
        BlockHexoriumStructureCasing.registerRenders();
        BlockGlowingHexoriumCoatedStone.registerRenders();
        BlockGlowingHexoriumGlass.registerRenders();
        BlockHexoriumLamp.registerRenders();
        BlockHexoriumLampInv.registerRenders();
        BlockHexoriumDoor.registerRenders();
        BlockHexoriumHatch.registerRenders();

        // Machines
        BlockHexoriumMachineBlock.registerRenders();
        BlockAdvancedRainbowCore.registerRenders();
        BlockHexoriumGenerator.registerRenders();
        BlockHexoriumFurnace.registerRenders();
        BlockCrystalSeparator.registerRenders();
        BlockMatrixReconstructor.registerRenders();
        BlockPersonalTeleportationPad.registerRenders();
        BlockQuantumObserver.registerRenders();
        BlockQuantumAnchor.registerRenders();

        // Tank
        BlockTankValve.registerRenders();
        BlockTankRender.registerRenders();

        // Energy Node
        BlockEnergyNodeCore.registerRenders();
        BlockConversionComputer.registerRenders();
        BlockEnergyNodePortHEX.registerRenders();
        BlockEnergyNodePortRF.registerRenders();
        if (Loader.isModLoaded("IC2"))
            BlockEnergyNodePortEU.registerRenders();
        if (Loader.isModLoaded("gregapi"))
            BlockEnergyNodePortLU.registerRenders();

        // Cables
        BlockHexoriumCable.registerRenders();

        // Energy Pylon
        BlockEnergyPylon.registerRenders();

        // Redstone
        BlockHexoriumSwitch.registerRenders();
        BlockHexoriumButton.registerRenders();
        BlockHexoriumPressurePlate.registerRenders();
    }
}
