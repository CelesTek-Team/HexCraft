package com.celestek.hexcraft.util;

/**
 * @author Thorinair   <celestek@openmailbox.org>
 */

public class HexEnums {

    public enum Variants {
        BLACK(""),
        WHITE("White");

        public final String label;

        Variants(String label) {
            this.label = label;
        }
    }

    public enum Colors {
        RED(       "Red",       1.00F, 0.00F, 0.00F),
        ORANGE(    "Orange",    1.00F, 0.50F, 0.00F),
        YELLOW(    "Yellow",    1.00F, 1.00F, 0.00F),
        LIME(      "Lime",      0.50F, 1.00F, 0.00F),
        GREEN(     "Green",     0.00F, 1.00F, 0.00F),
        TURQUOISE( "Turquoise", 0.00F, 1.00F, 0.50F),
        CYAN(      "Cyan",      0.00F, 1.00F, 1.00F),
        SKY_BLUE(  "SkyBlue",   0.00F, 0.50F, 1.00F),
        BLUE(      "Blue",      0.00F, 0.00F, 1.00F),
        PURPLE(    "Purple",    0.50F, 0.00F, 1.00F),
        MAGENTA(   "Magenta",   1.00F, 0.00F, 1.00F),
        PINK(      "Pink",      1.00F, 0.00F, 0.50F),

        WHITE(     "White",     1.00F, 1.00F, 1.00F),
        LIGHT_GRAY("LightGray", 0.75F, 0.75F, 0.75F),
        GRAY(      "Gray",      0.50F, 0.50F, 0.50F),
        DARK_GRAY( "DarkGray",  0.25F, 0.25F, 0.25F),
        BLACK(     "Black",     0.10F, 0.10F, 0.10F),

        RAINBOW(   "Rainbow",   1.00F, 1.00F, 1.00F);

        public final String name;
        public final float r, g, b;

        Colors(String label, float r, float g, float b) {
            this.name = label;
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public enum Brightness {
        BRIGHT(0x00F000F0),
        CL(    0x000FFFFF);

        public final int value;

        Brightness(int value) {
            this.value = value;
        }
    }


    // Colors

    public static final float COLOR_RED_R = 1F;
    public static final float COLOR_RED_G = 0F;
    public static final float COLOR_RED_B = 0F;

    public static final float COLOR_ORANGE_R = 1F;
    public static final float COLOR_ORANGE_G = 0.5F;
    public static final float COLOR_ORANGE_B = 0F;

    public static final float COLOR_YELLOW_R = 1F;
    public static final float COLOR_YELLOW_G = 1F;
    public static final float COLOR_YELLOW_B = 0F;

    public static final float COLOR_LIME_R = 0.5F;
    public static final float COLOR_LIME_G = 1F;
    public static final float COLOR_LIME_B = 0F;

    public static final float COLOR_GREEN_R = 0F;
    public static final float COLOR_GREEN_G = 1F;
    public static final float COLOR_GREEN_B = 0F;

    public static final float COLOR_TORQUOISE_R = 0F;
    public static final float COLOR_TORQUOISE_G = 1F;
    public static final float COLOR_TORQUOISE_B = 0.5F;

    public static final float COLOR_CYAN_R = 0F;
    public static final float COLOR_CYAN_G = 1F;
    public static final float COLOR_CYAN_B = 1F;

    public static final float COLOR_SKY_BLUE_R = 0F;
    public static final float COLOR_SKY_BLUE_G = 0.5F;
    public static final float COLOR_SKY_BLUE_B = 1F;

    public static final float COLOR_BLUE_R = 0F;
    public static final float COLOR_BLUE_G = 0F;
    public static final float COLOR_BLUE_B = 1F;

    public static final float COLOR_PURPLE_R = 0.5F;
    public static final float COLOR_PURPLE_G = 0F;
    public static final float COLOR_PURPLE_B = 1F;

    public static final float COLOR_MAGENTA_R = 1F;
    public static final float COLOR_MAGENTA_G = 0F;
    public static final float COLOR_MAGENTA_B = 1F;

    public static final float COLOR_PINK_R = 1F;
    public static final float COLOR_PINK_G = 0F;
    public static final float COLOR_PINK_B = 0.5F;

    // Grayscale

    public static final float COLOR_WHITE_R = 1F;
    public static final float COLOR_WHITE_G = 1F;
    public static final float COLOR_WHITE_B = 1F;

    public static final float COLOR_LIGHT_GRAY_R = 0.75F;
    public static final float COLOR_LIGHT_GRAY_G = 0.75F;
    public static final float COLOR_LIGHT_GRAY_B = 0.75F;

    public static final float COLOR_GRAY_R = 0.5F;
    public static final float COLOR_GRAY_G = 0.5F;
    public static final float COLOR_GRAY_B = 0.5F;

    public static final float COLOR_DARK_GRAY_R = 0.25F;
    public static final float COLOR_DARK_GRAY_G = 0.25F;
    public static final float COLOR_DARK_GRAY_B = 0.25F;

    public static final float COLOR_BLACK_R = 0.10F;
    public static final float COLOR_BLACK_G = 0.10F;
    public static final float COLOR_BLACK_B = 0.10F;

    // Rainbow

    public static final float COLOR_RAINBOW_R = 1F;
    public static final float COLOR_RAINBOW_G = 1F;
    public static final float COLOR_RAINBOW_B = 1F;

    // Brightness

    public static final int BRIGHTNESS_BRIGHT = 0x00F000F0;
    public static final int BRIGHTNESS_CL = 0xFFFFF;

    // Opacity

    public static final float OPACITY_SLIGHT = 0.75F;

    // Multipliers

    public static final float MULTIPLIER_DARKEN = 0.15F;
}
