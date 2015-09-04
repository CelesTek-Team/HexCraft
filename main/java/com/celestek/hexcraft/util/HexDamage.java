package com.celestek.hexcraft.util;

import net.minecraft.util.DamageSource;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 * @version 0.1.0
 * @since 2015-09-04
 */
public class HexDamage extends DamageSource {

    public static DamageSource teleport = (new DamageSource("hexTeleport")).setDamageBypassesArmor();
    public static DamageSource transposer = (new DamageSource("hexTransposer")).setDamageBypassesArmor();

    public HexDamage(String name) {
        super(name);
    }
}
