package celestek.hexcraft.client.model;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
interface MeshDefinitionFix extends ItemMeshDefinition {
    ModelResourceLocation getLocation(ItemStack stack);

    // Helper method to easily create lambda instances of this class
    static ItemMeshDefinition create(MeshDefinitionFix lambda) {
        return lambda;
    }

    default ModelResourceLocation getModelLocation(ItemStack stack) {
        return getLocation(stack);
    }
}
