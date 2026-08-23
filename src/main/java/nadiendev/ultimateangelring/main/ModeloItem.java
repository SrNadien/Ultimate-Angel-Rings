package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

/**
 * 26.2: net.neoforged.neoforge.client.model.generators.ItemModelProvider ya no existe.
 * Los modelos de item se generan con ModelProvider + ItemModelGenerators, y cada item
 * ademas recibe su client item definition en assets/<ns>/items/.
 */
public class ModeloItem extends ModelProvider {

    public ModeloItem(PackOutput output) {
        super(output, UltimateAngelRings.MOD_ID);
    }

    @Override
    public String getName() {
        return "Item Model Definitions - " + this.modId;
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Stream.empty();   // el mod no tiene bloques
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return BuiltInRegistries.ITEM.listElements()
                .filter(holder -> holder.getKey().identifier().getNamespace().equals(this.modId))
                .filter(holder -> !(holder.value() instanceof BlockItem));
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Equivalente al viejo withExistingParent(name, "item/generated").texture("layer0", ...)
        itemModels.generateFlatItem(ItemsDelMod.ANGEL_RING.get(), ModelTemplates.FLAT_ITEM);
    }
}
