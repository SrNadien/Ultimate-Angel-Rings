package nadiendev.ultimateangelring.compatibilidad.curios;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

/**
 * Integracion con Curios
 * By NadienDev
 *
 * Curios 15 elimino SlotTypeMessage y SlotTypePreset, asi que ya no hay IMC:
 * el slot "ring" queda declarado unicamente por ModCuriosProvider (datagen).
 */
public class CuriosCompat {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(CuriosCompat::registerCapabilities);
    }

    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(
                CuriosCapability.ITEM,
                (stack, context) -> (ICurio) stack.getItem(),
                ItemsDelMod.ANGEL_RING.get()
        );
        UltimateAngelRings.LOGGER.info("Capability de Curios registrada para el Angel Ring");
    }

    public static boolean isCuriosLoaded() {
        try {
            Class.forName("top.theillusivec4.curios.api.CuriosApi");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
