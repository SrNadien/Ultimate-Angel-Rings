package nadiendev.ultimateangelring.recetas;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.concurrent.CompletableFuture;

public class RecetasDelMod extends RecipeProvider {

    public RecetasDelMod(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    // Wrapper para evitar generar advancements automáticos
    @Override
    protected void buildRecipes(RecipeOutput writer) {
       
        RecipeOutput recipeOutput = new RecipeOutput() {
            @Override
            public void accept(ResourceLocation id, net.minecraft.world.item.crafting.Recipe<?> recipe, 
                             AdvancementHolder advancement) {
                // Solo guardamos la receta, ignoramos el advancement
                writer.accept(id, recipe, null);
            }
            
            @Override
            public net.minecraft.advancements.Advancement.Builder advancement() {
                return writer.advancement();
            }

            @Override
            public void accept(ResourceLocation id, net.minecraft.world.item.crafting.Recipe<?> recipe, 
                             AdvancementHolder advancement, ICondition... conditions) {
                // Solo guardamos la receta, ignoramos el advancement
                writer.accept(id, recipe, null, conditions);
            }
        };
          
        // ==========================================
        // RECETA ANGEL RING
        // ==========================================
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemsDelMod.ANGEL_RING.get(), 1)
                .pattern("ada")
                .pattern("bcb")
                .pattern("ada")
                .define('a', Items.NETHERITE_INGOT)
                .define('b', Items.SHULKER_BOX)
                .define('c', Items.NETHER_STAR)
                .define('d', Items.EMERALD_BLOCK)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(UltimateAngelRings.MOD_ID, "angel_ring"));
    }
}