package nadiendev.ultimateangelring;

import nadiendev.ultimateangelring.items.ItemsDelMod;
import nadiendev.ultimateangelring.main.EventosMod;
import nadiendev.ultimateangelring.main.TabCreativa;
import nadiendev.ultimateangelring.recetas.RecetasDelMod;
import nadiendev.ultimateangelring.compatibilidad.curios.CuriosCompat;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(UltimateAngelRings.MOD_ID)
public class UltimateAngelRings {
    public static final String MOD_ID = "ultimateangelring";
    public static final Logger LOGGER = LoggerFactory.getLogger(UltimateAngelRings.class);

    public UltimateAngelRings(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Iniciando Ultimate Angel Ring Mod");

        // Registrar items
        ItemsDelMod.register(modEventBus);

        // Registrar tab creativa
        TabCreativa.register(modEventBus);

        // Integración con Curios 
        CuriosCompat.register(modEventBus);
        LOGGER.info("Compatibilidad con Curios registrada");

        // Registrar eventos
        modEventBus.addListener(this::commonSetup);
        EventosMod.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Configuración común de Ultimate Angel Ring completada");
    }

    public static net.minecraft.resources.ResourceLocation loc(String path) {
        return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}