# Changelog

## 1.0.2 

### Added

- **Server config to limit horizontal flight speed.** New `ultimateangelring-server.toml` with
  `maxHorizontalSpeed` (blocks per second, `0` = unlimited, the default). It only limits horizontal
  speed while flying with the Angel Ring, so vertical speed is untouched and players can still build
  upwards comfortably. Elytra, creative and spectator are never affected. The value is synced from the
  server to every client.

### Changed

- Flight now uses the `neoforge:creative_flight` attribute instead of a custom "Flying" effect.
- The Angel Ring has its own Curios `ring` slot with a custom slot icon, and a new item texture.

### Removed

- The custom "Flying" mob effect and its texture.

## 1.0.2 (Español)

### Añadido

- **Configuración de servidor para limitar la velocidad horizontal de vuelo.** Nuevo archivo
  `ultimateangelring-server.toml` con `maxHorizontalSpeed` (bloques por segundo, `0` = sin límite, el
  valor por defecto). Solo limita la velocidad horizontal al volar con el Angel Ring, así que la
  vertical no cambia y se puede seguir construyendo hacia arriba. Los élitros, el creativo y el
  espectador nunca se ven afectados. El valor se sincroniza del servidor a todos los clientes.

### Cambiado

- El vuelo ahora usa el atributo `neoforge:creative_flight` en vez de un efecto "Volando" propio.
- El Angel Ring tiene su propio slot `ring` de Curios con un icono propio, y una textura nueva.

### Eliminado

- El efecto "Volando" y su textura.
