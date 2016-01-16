package team.chisel.common.integration.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ChiselRecipeCategory implements IRecipeCategory {

    private IDrawable background;

    public ChiselRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation location = new ResourceLocation("chisel", "textures/chiselJEI.png");
        this.background = guiHelper.createDrawable(location, 0, 0, 170, 166);
    }

    @Nonnull
    @Override
    public String getUid() {
        return "chisel.chiseling";
    }

    @Nonnull
    @Override
    public String getTitle() {
        return StatCollector.translateToLocal("chisel.jei.title");
    }

    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {

    }

    @Override
    public void drawAnimations(Minecraft minecraft) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper) {
        recipeLayout.getItemStacks().init(0, true, 73, 3);
        recipeLayout.getItemStacks().set(0, recipeWrapper.getInputs());

        int rowWidth = 9;

        int xStart = 2;
        int yStart = 36;

        for (int i = 0; i < recipeWrapper.getOutputs().size(); i++) {
            int x = xStart + (i % rowWidth) * 18;
            int y = yStart + (i / rowWidth) * 18;
            
            recipeLayout.getItemStacks().init(i + 1, false, x, y);
            recipeLayout.getItemStacks().set(i + 1, (ItemStack) recipeWrapper.getOutputs().get(i));
        }

    }
}
