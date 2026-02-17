package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.compatibilidad.curios.CuriosTags;
import nadiendev.ultimateangelring.datagen.ModCuriosProvider;
import nadiendev.ultimateangelring.recetas.RecetasDelMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"removal", "deprecation"})
@EventBusSubscriber(modid = UltimateAngelRings.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class GenerarDatos {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Proveedores de datos del lado del servidor
        if (event.includeServer()) {
            generator.addProvider(true, new RecetasDelMod(packOutput, lookupProvider));
            UltimateAngelRings.LOGGER.info("Provider de recetas registrado");
            
            // Provider de Curios (slots y entities)
            generator.addProvider(true, new ModCuriosProvider(packOutput, existingFileHelper, lookupProvider));
            UltimateAngelRings.LOGGER.info("Provider de Curios (slots/entities) registrado");
            
            // Provider de tags de Curios
            generator.addProvider(true, new CuriosTags(
                packOutput, 
                lookupProvider,
                CompletableFuture.completedFuture(net.minecraft.data.tags.TagsProvider.TagLookup.empty()),
                existingFileHelper
            ));
            UltimateAngelRings.LOGGER.info("Provider de tags de Curios registrado");
        }

        // Proveedores de datos del lado del cliente
        if (event.includeClient()) {
            generator.addProvider(true, new ModeloItem(packOutput, existingFileHelper));
            UltimateAngelRings.LOGGER.info("Provider de modelos de items registrado");
        }

        UltimateAngelRings.LOGGER.info("Generando datos de Ultimate Angel Ring");
    }
}