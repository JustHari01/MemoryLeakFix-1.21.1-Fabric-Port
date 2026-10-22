package ca.fxco.memoryleakfix;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;

/** Fabric-only platform services for the standalone 1.21.1 port. */
public final class MemoryLeakFixExpectPlatform {

    private MemoryLeakFixExpectPlatform() {
    }

    public static boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    public static int compareMinecraftToVersion(String version) {
        Version current = FabricLoader.getInstance()
                .getModContainer("minecraft")
                .orElseThrow(() -> new IllegalStateException("Minecraft mod metadata is unavailable"))
                .getMetadata()
                .getVersion();
        try {
            return current.compareTo(Version.parse(version));
        } catch (VersionParsingException exception) {
            throw new IllegalArgumentException("Invalid Minecraft version: " + version, exception);
        }
    }

    public static String getMappingType() {
        return "fabric";
    }

    public static boolean isDevEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
