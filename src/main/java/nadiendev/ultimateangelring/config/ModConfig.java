package nadiendev.ultimateangelring.config;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Configuracion del mod (tipo SERVER).
 *
 * Al ser SERVER, el archivo vive en {@code <instancia>/config/ultimateangelring-server.toml}
 * (un mundo puede sobreescribirlo con {@code <mundo>/serverconfig/}) y NeoForge
 * sincroniza sus valores con los clientes al conectarse, asi el servidor manda.
 */
public final class ModConfig {

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.DoubleValue MAX_HORIZONTAL_SPEED;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("flight");
        MAX_HORIZONTAL_SPEED = builder
                .comment(
                        "Maximum horizontal flight speed (blocks per second) while flying with the Angel Ring.",
                        "Only horizontal speed is limited: vertical speed is untouched, so players can still",
                        "build upwards comfortably. Elytra, creative mode and spectator are never affected.",
                        "0 = unlimited (default). For reference, vanilla creative flight is ~10.9 b/s, and ~21.6 b/s sprinting.")
                .translation("config.ultimateangelring.max_horizontal_speed")
                .defineInRange("maxHorizontalSpeed", 0.0D, 0.0D, 1000.0D);
        builder.pop();

        SPEC = builder.build();
    }

    private ModConfig() {
    }

    /** Limite en bloques/segundo; 0 o menos significa sin limite. Seguro de llamar antes de que cargue la config. */
    public static double maxHorizontalSpeed() {
        return SPEC.isLoaded() ? MAX_HORIZONTAL_SPEED.get() : 0.0D;
    }
}
