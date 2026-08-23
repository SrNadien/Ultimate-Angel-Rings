package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.datagen.ModCuriosProvider;
import nadiendev.ultimateangelring.recetas.RecetasDelMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

/**
 * 26.1.2: GatherDataEvent es abstracto y se parte en .Client / .Server.
 * NeoForge registra todo (datos de cliente Y de servidor) desde el evento .Client en
 * una unica run "clientData".
 *
 * Ya no existen includeClient() / includeServer() / getPackOutput() / getExistingFileHelper():
 * los providers se construyen con event.createProvider(...).
 */
@EventBusSubscriber(modid = UltimateAngelRings.MOD_ID)
public class GenerarDatos {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(RecetasDelMod.Runner::new);
        event.createProvider(ModCuriosProvider::new);
        event.createProvider(ModeloItem::new);

        UltimateAngelRings.LOGGER.info("Generando datos de Ultimate Angel Ring");
    }
}
