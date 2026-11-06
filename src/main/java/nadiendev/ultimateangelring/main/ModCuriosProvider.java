package nadiendev.ultimateangelring.datagen;

import nadiendev.ultimateangelring.UltimateAngelRings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.concurrent.CompletableFuture;

/**
 * Provider para generar slots y entities de Curios con datagen
 * By NadienDev
 * 
 * Genera automáticamente:
 * - data/ultimateangelring/curios/slots/ring.json
 * - data/ultimateangelring/curios/entities/player_rings.json
 */
public class ModCuriosProvider extends CuriosDataProvider {

    public ModCuriosProvider(PackOutput output, 
                            ExistingFileHelper fileHelper,
                            CompletableFuture<HolderLookup.Provider> registries) {
        super(UltimateAngelRings.MOD_ID, output, fileHelper, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
        // ============================================
        // CREAR SLOT TYPE "RING"
        // ============================================
        this.createSlot("ring")
            .size(1)                                          // 2 slots de anillo por defecto
            .order(10)                                        // Aparece temprano en el GUI (orden bajo = más arriba)
            .icon(ResourceLocation.fromNamespaceAndPath(     // Icono personalizado del slot
                UltimateAngelRings.MOD_ID, 
                "slot/angel_ring"
            ))
            .addCosmetic(true)                                // Agrega slot cosmético adicional
            .dropRule(ICurio.DropRule.DEFAULT)                // Sigue la config de keepCurios al morir
            .renderToggle(true);                              // Permite toggle de renderizado
        
        // ============================================
        // ASIGNAR SLOT "RING" A JUGADORES
        // ============================================
        this.createEntities("player_rings")
            .addPlayer()                                      // Agrega minecraft:player
            .addSlots("ring");                                // Le da el slot "ring"
        
        UltimateAngelRings.LOGGER.info("Curios data generation completed: slot 'ring' created and assigned to players");
    }
}