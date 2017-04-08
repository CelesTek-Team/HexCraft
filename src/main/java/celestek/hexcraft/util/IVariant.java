package celestek.hexcraft.util;

import net.minecraft.util.IStringSerializable;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */
public interface IVariant extends IStringSerializable {

    /**
     * Get the metadata value of this variant.
     *
     * @return The metadata value
     */
    int getMeta();
}