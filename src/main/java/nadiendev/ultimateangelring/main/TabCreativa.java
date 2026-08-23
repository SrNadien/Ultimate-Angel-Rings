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

public class TabCreativa {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UltimateAngelRings.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ULTIMATE_ANGEL_RING_TAB =
            CREATIVE_MODE_TABS.register("ultimate_angel_ring_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultimateangelring"))
                    .icon(() -> new ItemStack(ItemsDelMod.ANGEL_RING.get()))
                    .displayItems((parameters, output) -> output.accept(ItemsDelMod.ANGEL_RING.get()))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        UltimateAngelRings.LOGGER.info("Registrando tab creativa de Ultimate Angel Ring");
    }
}
