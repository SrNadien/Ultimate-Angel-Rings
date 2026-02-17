package nadiendev.ultimateangelring.compatibilidad.curios;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.InterModComms;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = UltimateAngelRings.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CuriosCompat {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(CuriosCompat::registerCapabilities);
    }

    @SubscribeEvent
    public static void enqueueIMC(InterModEnqueueEvent event) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.RING.getMessageBuilder().build());
        
        UltimateAngelRings.LOGGER.info("Integración con Curios cargada");
    }

    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(
                CuriosCapability.ITEM,
                (stack, context) -> (top.theillusivec4.curios.api.type.capability.ICurio) stack.getItem(),
                ItemsDelMod.ANGEL_RING.get()
        );
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