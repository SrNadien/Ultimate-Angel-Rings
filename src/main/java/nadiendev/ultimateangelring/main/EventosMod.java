package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Gestor del vuelo del Angel Ring
 * By NadienDev
 *
 * Ya no se usa un MobEffect propio: el vuelo se otorga con el atributo de NeoForge
 * {@code neoforge:creative_flight} ({@link NeoForgeMod#CREATIVE_FLIGHT}).
 *
 * Es un BooleanAttribute, asi que se activa con un modificador de valor 1.0 y
 * operacion ADD_VALUE, y se desactiva simplemente quitando el modificador.
 *
 * Esta clase cubre el caso de llevar el anillo suelto en el inventario. Cuando esta
 * equipado en el slot de Curios el modificador lo aplica Curios a traves de
 * {@code AngelRingItem#getAttributeModifiers}.
 */
@EventBusSubscriber(modid = UltimateAngelRings.MOD_ID)
public class EventosMod {

    /** Id del modificador que aplicamos cuando el anillo va suelto en el inventario. */
    public static final Identifier FLIGHT_MODIFIER_ID =
            Identifier.fromNamespaceAndPath(UltimateAngelRings.MOD_ID, "angel_ring_flight");

    private static final AttributeModifier FLIGHT_MODIFIER = new AttributeModifier(
            FLIGHT_MODIFIER_ID,
            1.0D,
            AttributeModifier.Operation.ADD_VALUE
    );

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) {
            return;
        }

        AttributeInstance creativeFlight = player.getAttribute(NeoForgeMod.CREATIVE_FLIGHT);

        if (creativeFlight == null) {
            return;
        }

        boolean tieneAnillo = player.getInventory().contains(
                stack -> stack.is(ItemsDelMod.ANGEL_RING.get())
        );
        boolean tieneModificador = creativeFlight.getModifier(FLIGHT_MODIFIER_ID) != null;

        if (tieneAnillo && !tieneModificador) {
            creativeFlight.addTransientModifier(FLIGHT_MODIFIER);
        } else if (!tieneAnillo && tieneModificador) {
            creativeFlight.removeModifier(FLIGHT_MODIFIER_ID);
            detenerVuelo(player);
        }
    }

    /**
     * Baja al jugador si se quedo sin permiso de vuelo mientras volaba.
     * Sin esto seguiria flotando hasta el siguiente updateAbilities.
     */
    public static void detenerVuelo(Player player) {
        if (!player.mayFly() && player.getAbilities().flying) {
            player.getAbilities().flying = false;
            player.onUpdateAbilities();
        }
    }
}
