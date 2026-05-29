package com.msg.combining_gears.crafting_recipe_types;

import com.msg.combining_gears.Constants;
import com.msg.combining_gears.crafting_recipe_types.WoolChanging;
import com.msg.combining_gears.enums.WoolColor;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class WoolChanging extends CustomRecipe {

    public WoolChanging(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return (width >= 1 && height >= 2) || (width >= 2 && height >= 1);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {

        ItemStack boots = null;
        ItemStack wool = null;
    
        if (input.size() != 2) return false;

        for(int i = 0; i < 2; ++i) {
            ItemStack itemStack = input.getItem(i);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(Constants.leathererBoots)) boots = itemStack;
                else if (itemStack.is(ItemTags.WOOL)) wool = itemStack;
                else return false;
            }
        }

        if (boots != null && wool != null) if (boots.get(Constants.LEATHERER_BOOTS_WOOL).getWoolItem() != wool.getItem()) return true;

        return false;
    }

    @Override
    public ItemStack assemble(CraftingInput input, Provider registries) {
        ItemStack bootsItem = null;
        WoolColor color = null;

        for(int i = 0; i < 2; ++i) {
            ItemStack itemStack = input.getItem(i);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(Constants.leathererBoots)) bootsItem = input.getItem(i).transmuteCopy(input.getItem(i).getItem(), 1);
                else color = WoolColor.byItem(itemStack.getItem());
            }
        }

        bootsItem.set(Constants.LEATHERER_BOOTS_WOOL, color);
        return bootsItem;
    }

    public RecipeSerializer<?> getSerializer() {
        return Constants.WOOL_CHANGING_RECIPE;
    }
}
