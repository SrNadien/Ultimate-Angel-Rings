package nadiendev.ultimateangelring.compatibilidad.curios;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

/**
 * CuriosTags 
 * By NadienDev
 */
public class CuriosTags extends ItemTagsProvider {
    public static final TagKey<Item> CURIOS_RING = ItemTags.create(
            ResourceLocation.fromNamespaceAndPath("curios", "ring")
    );

    public CuriosTags(PackOutput output, 
                                 CompletableFuture<HolderLookup.Provider> lookupProvider,
                                 CompletableFuture<TagLookup<Block>> blockTags,
                                 ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, UltimateAngelRings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(CURIOS_RING)
            .add(ItemsDelMod.ANGEL_RING.get());
        
        UltimateAngelRings.LOGGER.info("Tags de items de Curios generados");
    }
}