package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.config.ModConfig;
import nadiendev.ultimateangelring.items.ItemsDelMod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import top.theillusivec4.curios.api.CuriosApi;

/**
 * Limita la velocidad horizontal de vuelo con el Angel Ring segun la config del servidor.
 *
 * El movimiento del jugador lo calcula el cliente, asi que el recorte se hace en el cliente
 * del propio jugador usando el valor sincronizado desde el servidor. Solo toca X/Z: la velocidad
 * vertical no se modifica.
 */
@EventBusSubscriber(modid = UltimateAngelRings.MOD_ID)
public class LimitadorVelocidad {

    /** Rozamiento horizontal del aire que aplica vanilla al final de cada tick. */
    private static final double AIR_DRAG = 0.91D;

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (!player.level().isClientSide() || !player.isLocalPlayer()) {
            return;
        }

        double limiteBps = ModConfig.maxHorizontalSpeed();
        if (limiteBps <= 0.0D) {
            return;
        }

        if (!volandoConAnillo(player)) {
            return;
        }

        // Al final del tick deltaMovement ya tiene el rozamiento aplicado; el siguiente tick suma
        // la aceleracion de vuelo (x2 si corre) y se mueve. Descontandola, el desplazamiento por
        // tick nunca supera el limite.
        double limiteTick = limiteBps / 20.0D;
        double aceleracion = player.getAbilities().getFlyingSpeed() * (player.isSprinting() ? 2.0D : 1.0D);
        double maxAlmacenado = Math.max(0.0D, limiteTick - aceleracion);

        Vec3 v = player.getDeltaMovement();
        double horizontal = Math.sqrt(v.x * v.x + v.z * v.z);
        if (horizontal > maxAlmacenado && horizontal > 1.0E-6D) {
            double f = maxAlmacenado / horizontal;
            player.setDeltaMovement(v.x * f, v.y, v.z * f);
        }
    }

    private static boolean volandoConAnillo(Player player) {
        if (!player.getAbilities().flying || player.isCreative() || player.isSpectator()
                || player.isFallFlying() || player.isPassenger()) {
            return false;
        }
        return tieneAnillo(player);
    }

    private static boolean tieneAnillo(Player player) {
        if (player.getInventory().contains(stack -> stack.is(ItemsDelMod.ANGEL_RING.get()))) {
            return true;
        }
        return CuriosApi.getCuriosInventory(player)
                .map(inv -> inv.findFirstCurio(ItemsDelMod.ANGEL_RING.get()).isPresent())
                .orElse(false);
    }
}
