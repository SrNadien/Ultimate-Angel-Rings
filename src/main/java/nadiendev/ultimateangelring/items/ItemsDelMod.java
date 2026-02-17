package nadiendev.ultimateangelring.items;

import nadiendev.ultimateangelring.UltimateAngelRings;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.Unbreakable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsDelMod {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltimateAngelRings.MOD_ID);

    // Angel Rings
    public static final DeferredItem<Item> ANGEL_RING = ITEMS.register("angel_ring",
            () -> new AngelRingItem(new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.UNBREAKABLE, new Unbreakable(true))));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        UltimateAngelRings.LOGGER.info("Registrando items de Ultimate Angel Ring");
    }
}
