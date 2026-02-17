package nadiendev.ultimateangelring.datagen;

import nadiendev.ultimateangelring.UltimateAngelRings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

/**
 * Provider para generar slots y entities de Curios con datagen
 */
public class ModCuriosProvider extends CuriosDataProvider {

    public ModCuriosProvider(PackOutput output, 
                            ExistingFileHelper fileHelper,
                            CompletableFuture<HolderLookup.Provider> registries) {
        super(UltimateAngelRings.MOD_ID, output, fileHelper, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
        // Crear el slot "ring"
        this.createSlot("ring")
            .size(1)  // 1 slot
            .order(100);  // Orden en el GUI

        // Asignar el slot "ring" a los jugadores
        this.createEntities("player")
            .addSlots("ring");
        
        UltimateAngelRings.LOGGER.info("Slots y entities de Curios generados con datagen");
    }
}