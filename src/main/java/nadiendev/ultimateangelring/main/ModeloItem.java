package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

@SuppressWarnings({"removal", "deprecation"})
public class ModeloItem extends ItemModelProvider {

    public ModeloItem(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UltimateAngelRings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Registrar modelos de los Angel Rings
        simpleItem(ItemsDelMod.ANGEL_RING);
        // simpleItem(ItemsDelMod.ANGEL_RING_RED);
        // simpleItem(ItemsDelMod.ANGEL_RING_BLUE);
        // simpleItem(ItemsDelMod.ANGEL_RING_GREEN);
        // simpleItem(ItemsDelMod.ANGEL_RING_GOLD);
        // simpleItem(ItemsDelMod.ANGEL_RING_DIAMOND);
        // simpleItem(ItemsDelMod.ANGEL_RING_NETHERITE);
        
        // Registrar modelos de componentes
        // simpleItem(ItemsDelMod.ANGEL_FEATHER);
        // simpleItem(ItemsDelMod.HEAVENLY_ESSENCE);
        // simpleItem(ItemsDelMod.CELESTIAL_CRYSTAL);
    }

    /**
     * Crea un modelo simple de item
     */
    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(UltimateAngelRings.MOD_ID, "item/" + item.getId().getPath()));
    }

    /**
     * Crea un modelo de item con textura personalizada
     */
    private ItemModelBuilder handheldItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(UltimateAngelRings.MOD_ID, "item/" + item.getId().getPath()));
    }
}
