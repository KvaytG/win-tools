package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;
import ru.kvaytg.wintools.api.WinTools;
import ru.kvaytg.wintools.util.HashUtils;
import ru.kvaytg.wintools.util.JvmUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Unstable
public final class wCore {

    private static final Path LIBRARY_PATH;

    private static final String LIBRARY_HASH;

    private wCore() {
        throw new AssertionError("No instances allowed");
    }

    static {
        boolean is64Bit = JvmUtils.is64Bit();
        String tempDir = System.getenv().getOrDefault("TEMP", System.getProperty("java.io.tmpdir"));
        String libDir = WinTools.NAME + "_" + HashUtils.sha256(
                System.getProperty("user.name", "unknown")
        );
        LIBRARY_PATH = Paths.get(tempDir, libDir).resolve("WTools" + (is64Bit ? "64" : "32") + ".dll");
        LIBRARY_HASH = is64Bit
                ? "66aba098b3b2e8b0113cc57d6bda71c1a3420f247ff3450348827cf6c5274ee8"
                : "dd0055ec88dcea7d94a038dde07fca8131abc6e65227fd1f0b69702782e65e96";
    }

    static synchronized void loadLibrary() {
        if (!Files.exists(LIBRARY_PATH)) {
            if (!JvmUtils.isWindows()) {
                throw new RuntimeException(WinTools.NAME + " only works on Windows");
            }
            try {
                copyLibraryFromResources();
            } catch (IOException ex) {
                throw new RuntimeException("Failed to copy native library", ex);
            }
        }
        try {
            String actualHash;
            try (InputStream is = Files.newInputStream(LIBRARY_PATH)) {
                actualHash = HashUtils.sha256(is);
            }
            if (!LIBRARY_HASH.equalsIgnoreCase(actualHash)) {
                throw new SecurityException("SHA-256 mismatch: expected " + LIBRARY_HASH + ", got " + actualHash);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read native library", ex);
        }
        try {
            System.load(LIBRARY_PATH.toAbsolutePath().toString());
        } catch (UnsatisfiedLinkError ex) {
            throw new RuntimeException("Failed to load native library", ex);
        }
    }

    private static void copyLibraryFromResources() throws IOException {
        String libraryName = LIBRARY_PATH.getFileName().toString();
        URL resource = Objects.requireNonNull(
                wCore.class.getResource("/" + libraryName),
                "Native library '" + libraryName + "' not found in resources"
        );
        Path parentDir = LIBRARY_PATH.getParent();
        if (!Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }
        try (InputStream in = resource.openStream()) {
            Files.copy(in, LIBRARY_PATH, StandardCopyOption.REPLACE_EXISTING);
        }
    }

}