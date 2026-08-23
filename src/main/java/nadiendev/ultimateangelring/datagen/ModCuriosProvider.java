package nadiendev.ultimateangelring.datagen;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import top.theillusivec4.curios.api.CuriosDataProvider;
import top.theillusivec4.curios.api.common.DropRule;

import java.util.concurrent.CompletableFuture;

/**
 * Provider para generar slots, entities y el tag de Curios
 * By NadienDev
 *
 * Genera:
 * - data/ultimateangelring/curios/slots/ring.json
 * - data/ultimateangelring/curios/entities/player_rings.json
 * - data/curios/tags/item/ring.json
 *
 * 26.2 / Curios 16: el constructor ya no recibe ExistingFileHelper, generate() toma solo
 * el HolderLookup.Provider, y el propio provider expone tag(...), asi que CuriosTags.java
 * (el ItemTagsProvider aparte que habia en 1.21.1) desaparece.
 */
public class ModCuriosProvider extends CuriosDataProvider {

    public ModCuriosProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(UltimateAngelRings.MOD_ID, output, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries) {
        // ============================================
        // CREAR SLOT TYPE "RING"
        // ============================================
        this.createSlot("ring")
                .size(1)                                          // 1 slot de anillo por defecto
                .order(10)                                        // orden bajo = mas arriba en el GUI
                .icon(Identifier.fromNamespaceAndPath(            // icono personalizado del slot
                        UltimateAngelRings.MOD_ID,
                        "slot/angel_ring"
                ))
                .addCosmetic(true)                                // slot cosmetico adicional
                .dropRule(DropRule.DEFAULT)                       // sigue la config de keepCurios
                .renderToggle(true);                              // permite toggle de renderizado

        // ============================================
        // ASIGNAR SLOT "RING" A JUGADORES
        // ============================================
        this.createEntities("player_rings")
                .addPlayer()
                .addSlots("ring");

        // ============================================
        // TAG curios:ring -> Angel Ring
        // ============================================
        // 26.2: TagAppender<Item> acepta ResourceKey<Item>.
        // (En 26.1.2 era TagAppender<Item, Item> y aceptaba el Item directo.)
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("curios", "ring")))
                .add(ItemsDelMod.ANGEL_RING.getKey());

        UltimateAngelRings.LOGGER.info("Curios data generation completed: slot 'ring' creado y asignado a jugadores");
    }
}
