package nadiendev.ultimateangelring;

import nadiendev.ultimateangelring.compatibilidad.curios.CuriosCompat;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import nadiendev.ultimateangelring.main.TabCreativa;
import net.minecraft.resources.Identifier;
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

        // Integracion con Curios
        CuriosCompat.register(modEventBus);
        LOGGER.info("Compatibilidad con Curios registrada");

        // El vuelo lo maneja EventosMod, que es @EventBusSubscriber del game bus:
        // ya no hay MobEffect que registrar en el mod bus.
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Configuracion comun de Ultimate Angel Ring completada");
    }

    public static Identifier loc(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
