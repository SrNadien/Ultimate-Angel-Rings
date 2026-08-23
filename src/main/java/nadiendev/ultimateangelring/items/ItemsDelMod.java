package nadiendev.ultimateangelring.items;

import nadiendev.ultimateangelring.UltimateAngelRings;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsDelMod {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltimateAngelRings.MOD_ID);

    // 26.2: Item.Properties tiene que llevar su id de registro (setId), asi que hay que pasar
    // por registerItem(...). Con register(Supplier) el item revienta con NPE al construirse.
    // DataComponents.UNBREAKABLE ahora es DataComponentType<Unit>, no <Unbreakable>.
    public static final DeferredItem<Item> ANGEL_RING = ITEMS.<Item>registerItem("angel_ring",
            AngelRingItem::new,
            () -> new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        UltimateAngelRings.LOGGER.info("Registrando items de Ultimate Angel Ring");
    }
}
