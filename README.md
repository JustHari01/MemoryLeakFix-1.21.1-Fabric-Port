# Memory Leak Fix — Unofficial Fabric 1.21.1 Port

An independent, standalone Fabric port of [Memory Leak Fix by FX - PR0CESS](https://github.com/FxMorin/MemoryLeakFix) for Minecraft 1.21.1. The upstream repository targets Minecraft through 1.20.4 and is archived. This project is not affiliated with the upstream author.

## Included fixes

The port keeps the upstream fixes that are still enabled for Minecraft 1.21.1:

- Reuses the biome temperature cache across threads, reducing redundant cache allocation and work.
- Clears the crosshair entity and hit result while returning from a world to the main menu.
- Frees the huge-screenshot buffer when screenshot generation reports a failure.

The legacy upstream mixins for issues Mojang marked fixed are retained in the source archive for context, but are excluded from the 1.21.1 build and are not shipped in the runtime JAR.

## Requirements

- Minecraft 1.21.1
- Fabric Loader 0.16.14 or newer
- Java 21 or newer

This mod is client and server compatible. The included fixes that touch rendering and screen state run on the client.

## Build

Run `gradlew build`. The source bundle is produced under `build/distributions/`.

## License and attribution

The port is distributed under LGPL-2.1-only. The original license and this port notice are included in the binary and source bundle. Original project: [FxMorin/MemoryLeakFix](https://github.com/FxMorin/MemoryLeakFix).

This unofficial port and its release description were prepared with AI assistance.
