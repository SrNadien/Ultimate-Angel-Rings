package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings({"removal", "deprecation"})
public class TabCreativa {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UltimateAngelRings.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ULTIMATE_ANGEL_RING_TAB =
            CREATIVE_MODE_TABS.register("ultimate_angel_ring_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultimateangelring"))
                    .icon(() -> new ItemStack(ItemsDelMod.ANGEL_RING.get()))
                    .displayItems((parameters, output) -> {
                        // Anillos angelicales
                        output.accept(ItemsDelMod.ANGEL_RING.get());
                        // output.accept(ItemsDelMod.ANGEL_RING_RED.get());
                        // output.accept(ItemsDelMod.ANGEL_RING_BLUE.get());
                        // output.accept(ItemsDelMod.ANGEL_RING_GREEN.get());
                        // output.accept(ItemsDelMod.ANGEL_RING_GOLD.get());
                        // output.accept(ItemsDelMod.ANGEL_RING_DIAMOND.get());
                        // output.accept(ItemsDelMod.ANGEL_RING_NETHERITE.get());
                        
                        // Componentes de crafteo
                        // output.accept(ItemsDelMod.ANGEL_FEATHER.get());
                        // output.accept(ItemsDelMod.HEAVENLY_ESSENCE.get());
                        // output.accept(ItemsDelMod.CELESTIAL_CRYSTAL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        UltimateAngelRings.LOGGER.info("Registrando tab creativa de Ultimate Angel Ring");
    }
}
