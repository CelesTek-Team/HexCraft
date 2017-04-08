package celestek.hexcraft.config;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public interface ICustomRender {
    /**
     * Use this to register a custom renderer for the block.
     */
    @SideOnly(Side.CLIENT)
    void registerRenderer(Feature feature);

    /**
     * Return true if the normal json model should still be registered for the item
     */
    boolean registerNormal(Feature feature);
}
