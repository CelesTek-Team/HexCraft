package com.celestek.hexcraft.compat.nei;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.NEI_HexConfig;
import com.celestek.hexcraft.init.HexRecipes;
import com.celestek.hexcraft.tileentity.TileMatrixReconstructor;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.Rectangle;
import java.util.*;

public class NEI_MatrixReconstructor extends TemplateRecipeHandler {

    // GUI Sizes
    private static final int GUI_SIZE_X = 176;
    private static final int GUI_SIZE_Y = 166;

    // GUI Strings
    private static final String GUI_STRING_IN = "hexcraft.container.in";

    HashMap<ItemStack, ItemStack> hashMap;

    public static final int sOffsetX = 5, sOffsetY = 11;

    public NEI_MatrixReconstructor(HashMap<ItemStack, ItemStack> hashMap) {
        this.hashMap = hashMap;
        transferRects.add(new RecipeTransferRect(new Rectangle(71-sOffsetX, 26-sOffsetY, 34, 25), getOverlayIdentifier()));

        if (!NEI_HexConfig.added) {
            GuiCraftingRecipe.craftinghandlers.add(this);
            GuiUsageRecipe.usagehandlers.add(this);
        }
    }

    @Override
    public TemplateRecipeHandler newInstance() {
        return new NEI_MatrixReconstructor(hashMap);
    }

    public class CachedDefaultRecipe extends CachedRecipe {
        public final List<PositionedStack> outputs = new ArrayList<>();
        public final List<PositionedStack> inputs  = new ArrayList<>();

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 10, this.inputs);
        }

        @Override
        public PositionedStack getResult() {
            return null;
        }

        @Override
        public List<PositionedStack> getOtherStacks() {
            return this.outputs;
        }

        public CachedDefaultRecipe(ItemStack input, ItemStack output) {
            inputs.add(new PositionedStack (input, 43, 19, true));
            outputs.add(new PositionedStack (output, 111, 19, false));
        }
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(getOverlayIdentifier())) {
            for (Map.Entry<ItemStack, ItemStack> pair : hashMap.entrySet())
                arecipes.add(new CachedDefaultRecipe(pair.getKey(), pair.getValue()));
        }
        else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        if (result != null)
            for (Map.Entry<ItemStack, ItemStack> pair : hashMap.entrySet()) {
                if (HexRecipes.isStackEqual(result, pair.getValue()))
                    arecipes.add(new CachedDefaultRecipe(pair.getKey(), pair.getValue()));
            }
    }

    @Override
    public void loadUsageRecipes(ItemStack input) {
        if (input != null)
            for (Map.Entry<ItemStack, ItemStack> pair : hashMap.entrySet()) {
                if (HexRecipes.isStackEqual(input, pair.getKey()))
                    arecipes.add(new CachedDefaultRecipe(pair.getKey(), pair.getValue()));
            }
    }

    @Override
    public String getOverlayIdentifier() {
        return HexCraft.MODID + "." + TileMatrixReconstructor.ID;
    }

    @Override
    public void drawBackground(int recipe) {
        GL11.glColor4f(1, 1, 1, 1);
        GuiDraw.changeTexture(getGuiTexture());
        GuiDraw.drawTexturedModalRect(-5, -16, 0, 0, GUI_SIZE_X, GUI_SIZE_Y);
    }

    @Override
    public int recipiesPerPage() {
        return 1;
    }

    @Override
    public String getRecipeName() {
        return LanguageRegistry.instance().getStringLocalization(TileMatrixReconstructor.INVENTORY_NAME);
    }

    @Override
    public String getGuiTexture() {
        return HexCraft.MODID + ":textures/gui/nei/neiMatrixReconstructor.png";
    }

    @Override
    public void drawExtras(int aRecipeIndex) {
        drawText(I18n.format(GUI_STRING_IN) + ":", 106 - getTextWidth(I18n.format(GUI_STRING_IN) + ":"), GUI_SIZE_Y - 110, 0x404040);
        String out = TileMatrixReconstructor.ENERGY_PER_TICK + " HEX/t";
        drawText(out, 137 - getTextWidth(out) / 2, GUI_SIZE_Y - 110, 0x00FF00);}

    public static void drawText(String string, int x, int y, int color) {
        Minecraft.getMinecraft().fontRenderer.drawString(string, x, y, color);
    }

    public static int getTextWidth(String string) {
        return Minecraft.getMinecraft().fontRenderer.getStringWidth(string);
    }
}
