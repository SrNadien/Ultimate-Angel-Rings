package nadiendev.ultimateangelring.recetas;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

/**
 * 26.3: las recetas ya no son un DataProvider. Se generan como entradas de un
 * RegistrySetBuilder (ver {@code GenerarDatos}) mediante {@link #create()}.
 */
public class RecetasDelMod extends RecipeProvider {

    private final HolderGetter<Item> items;

    protected RecetasDelMod(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
        this.items = recipeOutput.lookup(Registries.ITEM);
    }

    public static MultiRegistryBootstrap create() {
        return RecipeProvider.asBootstrap(RecetasDelMod::new);
    }

    @Override
    protected void buildRecipes() {
        // ==========================================
        // RECETA ANGEL RING
        // ==========================================
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, ItemsDelMod.ANGEL_RING.get(), 1)
                .pattern("ada")
                .pattern("bcb")
                .pattern("ada")
                .define('a', Items.NETHERITE_INGOT)
                .define('b', Items.SHULKER_BOX)
                .define('c', Items.NETHER_STAR)
                .define('d', Items.EMERALD_BLOCK)
                .unlockedBy("has_nether_star", this.has(Items.NETHER_STAR))
                .save(this.output, ResourceKey.create(Registries.RECIPE, UltimateAngelRings.loc("angel_ring")));
    }
}
