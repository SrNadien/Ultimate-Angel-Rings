package nadiendev.ultimateangelring.recetas;

import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class RecetasDelMod extends RecipeProvider {

    protected RecetasDelMod(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // ==========================================
        // RECETA ANGEL RING
        // ==========================================
        this.shaped(RecipeCategory.TOOLS, ItemsDelMod.ANGEL_RING.get(), 1)
                .pattern("ada")
                .pattern("bcb")
                .pattern("ada")
                .define('a', Items.NETHERITE_INGOT)
                .define('b', Items.SHULKER_BOX)
                .define('c', Items.NETHER_STAR)
                .define('d', Items.EMERALD_BLOCK)
                .unlockedBy("has_nether_star", this.has(Items.NETHER_STAR))
                .save(this.output);
    }

    /**
     * 26.1.2: RecipeProvider ya no implementa DataProvider. Lo que se registra en el
     * DataGenerator es este Runner.
     */
    public static final class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new RecetasDelMod(registries, output);
        }

        @Override
        public String getName() {
            return "Ultimate Angel Ring Recipes";
        }
    }
}
