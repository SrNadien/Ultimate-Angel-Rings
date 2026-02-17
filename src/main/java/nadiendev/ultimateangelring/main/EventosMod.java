package nadiendev.ultimateangelring.main;

import nadiendev.ultimateangelring.UltimateAngelRings;
import nadiendev.ultimateangelring.effects.FlyingEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* Effect Registry Provider
* By NadienDev
*/
public class EventosMod {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, UltimateAngelRings.MOD_ID);

    

    // Efecto de vuelo - adaptado de Apothic Attributes (ahora en archivo separado FlyingEffect.java)
    public static final DeferredHolder<MobEffect, MobEffect> FLYING = MOB_EFFECTS.register(
            "flying",
            () -> new FlyingEffect()
    );

 
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
