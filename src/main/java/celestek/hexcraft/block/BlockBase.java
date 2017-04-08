package celestek.hexcraft.block;

import celestek.hexcraft.HEXCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public class BlockBase extends Block {
    public BlockBase(Material material, MapColor mapColor, String blockName) {
        super(material, mapColor);
        setBlockName(this, blockName);
    }

    public BlockBase(Material materialIn, String blockName) {
        this(materialIn, materialIn.getMaterialMapColor(), blockName);
    }

    /**
     * Set the registry name of {@code block} to {@code blockName} and the unlocalised name to the full registry name.
     *
     * @param block     The block
     * @param blockName The block's name
     */
    public static void setBlockName(Block block, String blockName) {
        block.setRegistryName(HEXCraft.MODID, blockName);
        block.setUnlocalizedName(block.getRegistryName().toString());
    }
}
