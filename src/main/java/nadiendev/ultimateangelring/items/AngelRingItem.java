package nadiendev.ultimateangelring.items;

import nadiendev.ultimateangelring.main.EventosMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

/**
 * Angel Ring Item - Otorga vuelo permanente
 * By NadienDev
 */
public class AngelRingItem extends Item implements ICurioItem {
    
    public AngelRingItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.ultimateangelring.angel_ring.line1"));
        tooltipComponents.add(Component.translatable("tooltip.ultimateangelring.angel_ring.line2"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide() && entity instanceof Player player) {
            // Aplicar efecto de vuelo
            applyFlightEffect(player);
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Entity entity = slotContext.entity();
        if (!entity.level().isClientSide() && entity instanceof Player player) {
            applyFlightEffect(player);
        }
    }

    /**
     * Aplica el efecto de vuelo al jugador
     * Igual que la pechera de Nadienite
     */
    private void applyFlightEffect(Player player) {
        player.addEffect(new MobEffectInstance(
            EventosMod.FLYING, 
            60,  // 3 segundos 
            0,   // Nivel 1
            false,
            false,
            true
        ));
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        Entity entity = slotContext.entity();
        if (entity instanceof Player player) {
            // Remover el efecto de vuelo cuando se desequipa
            player.removeEffect(EventosMod.FLYING);
        }
    }
}