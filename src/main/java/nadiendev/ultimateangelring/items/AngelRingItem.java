package nadiendev.ultimateangelring.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import nadiendev.ultimateangelring.main.EventosMod;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.neoforge.common.NeoForgeMod;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.function.Consumer;

/**
 * Angel Ring Item - Otorga vuelo permanente
 * By NadienDev
 *
 * El vuelo se otorga con el atributo neoforge:creative_flight
 * ({@link NeoForgeMod#CREATIVE_FLIGHT}), no con un MobEffect propio.
 *
 * 26.2 tambien expone NeoForgeMod.GLIDING_FLIGHT, que aqui NO se usa a proposito:
 * el anillo da vuelo creativo completo, no planeo tipo elytra.
 */
public class AngelRingItem extends Item implements ICurioItem {

    public AngelRingItem(Properties properties) {
        super(properties);
    }

    // 26.2: appendHoverText recibe TooltipDisplay y un Consumer, ya no una List<Component>
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display,
                                Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
        tooltipAdder.accept(Component.translatable("tooltip.ultimateangelring.angel_ring.line1"));
        tooltipAdder.accept(Component.translatable("tooltip.ultimateangelring.angel_ring.line2"));
        super.appendHoverText(stack, context, display, tooltipAdder, tooltipFlag);
    }

    /**
     * Modificadores que Curios aplica mientras el anillo esta equipado.
     *
     * neoforge:creative_flight es un BooleanAttribute: se enciende con valor 1.0
     * y operacion ADD_VALUE. Curios agrega y quita el modificador al equipar y
     * desequipar, asi que no hace falta ningun tick.
     *
     * 26.2: el segundo parametro es Identifier, no ResourceLocation.
     */
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext,
                                                                                Identifier id,
                                                                                ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = HashMultimap.create();
        modifiers.put(
                NeoForgeMod.CREATIVE_FLIGHT,
                new AttributeModifier(id, 1.0D, AttributeModifier.Operation.ADD_VALUE)
        );
        return modifiers;
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        Entity entity = slotContext.entity();

        if (entity instanceof Player player && !player.level().isClientSide()) {
            // Curios ya quito el modificador; solo hay que bajar al jugador si seguia volando
            EventosMod.detenerVuelo(player);
        }
    }
}
