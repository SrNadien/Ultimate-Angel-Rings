# Ultimate Angel Ring Mod para Minecraft 1.21.1 NeoForge

## Descripción
Este mod añade un **Anillo de Ángel** que otorga vuelo creativo cuando está equipado en el inventario o en un slot de Curios.

## Características
- ✈️ **Vuelo Creativo**: El anillo otorga la habilidad de volar como en modo creativo
- 🎒 **Funciona en Inventario**: Solo necesitas tenerlo en tu inventario para volar
- 💍 **Compatible con Curios**: También puedes equiparlo en slots de Curios (ring o charm)
- 🌟 **Receta Balanceada**: Requiere materiales end-game para craftear

## Requisitos
- Minecraft 1.21.1
- NeoForge 21.1.215 o superior
- Curios API (opcional pero recomendado)

## Instalación
1. Descarga e instala NeoForge 1.21.1
2. Coloca el archivo .jar del mod en la carpeta `mods`
3. (Opcional) Instala Curios API para funcionalidad adicional
4. ¡Inicia el juego y disfruta!

## Receta de Crafteo
```
F G F
E D E
F N F

F = Pluma (Feather)
G = Lingote de Oro (Gold Ingot)
E = Élitros (Elytra)
D = Estrella del Nether (Nether Star)
N = Lingote de Netherita (Netherite Ingot)
```

## Compilación del Mod

### Prerrequisitos
- Java 21 JDK
- Gradle (incluido con el wrapper)

### Pasos para compilar
1. Abre una terminal en la carpeta del proyecto
2. En Windows ejecuta:
   ```
   gradlew.bat build
   ```
3. En Linux/Mac ejecuta:
   ```
   ./gradlew build
   ```
4. El archivo .jar compilado estará en `build/libs/`

## Uso
1. Craftea o obtén el Anillo de Ángel
2. Colócalo en tu inventario o equípalo en un slot de Curios
3. ¡Ahora puedes volar! Presiona espacio dos veces para empezar a volar

## Compatibilidad con Curios
Si tienes Curios instalado, puedes equipar el anillo en los siguientes slots:
- Ring (Anillo)
- Charm (Amuleto)

## Características Técnicas
- Sistema de vuelo basado en el creative flight de NeoForge
- Detección automática en inventario mediante eventos de tick
- Integración completa con Curios API
- Textura personalizable (coloca tu propia textura en `assets/ultimateangelring/textures/item/angel_ring.png`)

## Personalización
Para cambiar la textura del anillo, reemplaza el archivo:
`src/main/resources/assets/ultimateangelring/textures/item/angel_ring.png`

La textura debe ser de 16x16 píxeles en formato PNG.

## Licencia
MIT License

## Créditos
Creado para Minecraft 1.21.1 con NeoForge 21.1.215
