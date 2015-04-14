package com.celestek.hexcraft;

import com.celestek.hexcraft.blocks.EnergizedHexoriumBlock;
import com.celestek.hexcraft.blocks.EngineeringBlock;
import com.celestek.hexcraft.client.RenderClientProxy;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = HexCraft.MODID, name = HexCraft.MODNAME, version = HexCraft.VERSION)
public class HexCraft
{
    public static final String MODID = "hexcraft";
    public static final String MODNAME = "HEXCraft";
    public static final String VERSION = "0.1.0";

    @Mod.Instance(value = HexCraft.MODID) //Tell Forge what instance to use.
    public static HexCraft instance;

    @SidedProxy(clientSide = "com.celestek.hexcraft.client.RenderClientProxy", serverSide = "com.celestek.hexcraft.RenderCommonProxy")
    public static RenderCommonProxy proxy;

    public static Block energizedHexoriumBlock;
    public static Block energizedHexoriumBlockGreen;
    public static Block engineeringBlock;
    public static Block engineeringBlockPurple;

    public static CreativeTabs hexCraftTab = new CreativeTabs("tabHexCraft") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.diamond; //TODO: Change this to a proper item!
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        RenderClientProxy.setCustomRenderers();

        energizedHexoriumBlock = new EnergizedHexoriumBlock(EnergizedHexoriumBlock.UNLOCALISEDNAME)
                .setHardness(0.5F)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName(EnergizedHexoriumBlock.UNLOCALISEDNAME)
                .setCreativeTab(CreativeTabs.tabBlock);

        energizedHexoriumBlockGreen = new EnergizedHexoriumBlock(EnergizedHexoriumBlock.UNLOCALISEDNAME + "Green")
                .setHardness(0.5F)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName(EnergizedHexoriumBlock.UNLOCALISEDNAME + "Green")
                .setCreativeTab(CreativeTabs.tabBlock);

        engineeringBlock = new EngineeringBlock(EngineeringBlock.UNLOCALISEDNAME)
                .setHardness(0.5F)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName(EngineeringBlock.UNLOCALISEDNAME)
                .setCreativeTab(CreativeTabs.tabBlock);

        engineeringBlockPurple = new EngineeringBlock(EngineeringBlock.UNLOCALISEDNAME + "Purple")
                .setHardness(0.5F)
                .setStepSound(Block.soundTypeMetal)
                .setBlockName(EngineeringBlock.UNLOCALISEDNAME + "Purple")
                        .setCreativeTab(CreativeTabs.tabBlock);

        GameRegistry.registerBlock(energizedHexoriumBlock, EnergizedHexoriumBlock.UNLOCALISEDNAME);
        GameRegistry.registerBlock(energizedHexoriumBlockGreen, EnergizedHexoriumBlock.UNLOCALISEDNAME + "Green");
        GameRegistry.registerBlock(engineeringBlock, EngineeringBlock.UNLOCALISEDNAME);
        GameRegistry.registerBlock(engineeringBlockPurple, EngineeringBlock.UNLOCALISEDNAME + "Purple");


        GameRegistry.addShapelessRecipe(new ItemStack(engineeringBlock), new ItemStack(energizedHexoriumBlock));

    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    /**
     * Returns the Block object based on unLocalisedName
     * @param unlocalisedName
     * @return Block
     */
    public static Block getBlock(String unlocalisedName)
    {
        if (unlocalisedName.equals(EnergizedHexoriumBlock.UNLOCALISEDNAME)) {
            return energizedHexoriumBlock;
        }
        else if (unlocalisedName.equals(EngineeringBlock.UNLOCALISEDNAME)) {
            return engineeringBlock;
        }
        else {
            return Blocks.stone;
        }
    }
}
