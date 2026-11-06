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
 * Generador de tags de items para Curios
 * By NadienDev
 * 
 * Agrega el Angel Ring al tag "curios:ring" para que Curios
 * lo reconozca como un item equipable en slots de tipo "ring".
 * 
 * Genera: data/curios/tags/items/ring.json
 */
public class CuriosTags extends ItemTagsProvider {
    
    /**
     * Tag de Curios para items tipo "ring"
     * Los items en este tag pueden ser equipados en slots de anillo
     */
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
        // Agregar el Angel Ring al tag "curios:ring"
        // Esto permite que el item se equipe en slots de tipo "ring"
        this.tag(CURIOS_RING)
            .add(ItemsDelMod.ANGEL_RING.get());
        
        UltimateAngelRings.LOGGER.info("Curios item tags generated - Angel Ring added to curios:ring");
    }
}