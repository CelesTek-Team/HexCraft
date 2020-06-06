package com.celestek.hexcraft.util;

public class HexEnums {

    public enum Variants {
        BLACK(""),
        WHITE("White");

        public final String name;

        Variants(String name) {
            this.name = name;
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

        Colors(String name, float r, float g, float b) {
            this.name = name;
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public enum Basics {
        RED(  "Red"),
        GREEN("Green"),
        BLUE( "Blue"),
        WHITE("White"),
        BLACK("Black");

        public final String name;

        Basics(String name) {
            this.name = name;
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

    // Opacity
    public static final float OPACITY_SLIGHT = 0.75F;

    // Multipliers
    public static final float MULTIPLIER_DARKEN = 0.15F;
}
