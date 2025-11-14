package com.celestek.hexcraft.init;

import com.celestek.hexcraft.tileentity.TileCrystalSeparator;
import com.celestek.hexcraft.tileentity.TileEnergyNodePortEU;
import com.celestek.hexcraft.tileentity.TileEnergyNodePortHEX;
import com.celestek.hexcraft.tileentity.TileEnergyNodePortLU;
import com.celestek.hexcraft.tileentity.TileEnergyNodePortRF;
import com.celestek.hexcraft.tileentity.TileEnergyPylon;
import com.celestek.hexcraft.tileentity.TileHexoriumFurnace;
import com.celestek.hexcraft.tileentity.TileHexoriumGenerator;
import com.celestek.hexcraft.tileentity.TileMatrixReconstructor;
import com.celestek.hexcraft.tileentity.TilePersonalTeleportationPad;
import com.celestek.hexcraft.tileentity.TileQuantumObserver;
import com.celestek.hexcraft.tileentity.TileSoundProjector;
import com.celestek.hexcraft.tileentity.TileTankRender;
import com.celestek.hexcraft.tileentity.TileTankValve;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class HexTileEntities {
    /**
     * Initializes the Tile Entities.
     */
    public static void initializeTileEntities() {
        GameRegistry.registerTileEntity(TileHexoriumGenerator.class, TileHexoriumGenerator.ID);

        if (HexConfig.cfgFurnaceEnable)
            GameRegistry.registerTileEntity(TileHexoriumFurnace.class, TileHexoriumFurnace.ID);

        if (HexConfig.cfgSeparatorEnable)
            GameRegistry.registerTileEntity(TileCrystalSeparator.class, TileCrystalSeparator.ID);

        GameRegistry.registerTileEntity(TileMatrixReconstructor.class, TileMatrixReconstructor.ID);

        if (HexConfig.cfgTeleportEnable)
            GameRegistry.registerTileEntity(TilePersonalTeleportationPad.class, TilePersonalTeleportationPad.ID);

        if (HexConfig.cfgObserverEnable)
            GameRegistry.registerTileEntity(TileQuantumObserver.class, TileQuantumObserver.ID);

        GameRegistry.registerTileEntity(TileEnergyPylon.class, TileEnergyPylon.ID);

        if (HexConfig.cfgTankEnable) {
            GameRegistry.registerTileEntity(TileTankValve.class, TileTankValve.ID);
            GameRegistry.registerTileEntity(TileTankRender.class, TileTankRender.ID);
        }

        if (HexConfig.cfgEnergyNodeEnable) {
            GameRegistry.registerTileEntity(TileEnergyNodePortHEX.class, TileEnergyNodePortHEX.ID);
            if (HexConfig.cfgEnergyNodePortsRFEnable)
                GameRegistry.registerTileEntity(TileEnergyNodePortRF.class, TileEnergyNodePortRF.ID);
            if (Loader.isModLoaded("IC2") && HexConfig.cfgEnergyNodePortsEUEnable)
                GameRegistry.registerTileEntity(TileEnergyNodePortEU.class, TileEnergyNodePortEU.ID);
            if (Loader.isModLoaded("gregapi") && HexConfig.cfgEnergyNodePortsLUEnable)
                GameRegistry.registerTileEntity(TileEnergyNodePortLU.class, TileEnergyNodePortLU.ID);
        }

        GameRegistry.registerTileEntity(TileSoundProjector.class, TileSoundProjector.ID);
    }
}
