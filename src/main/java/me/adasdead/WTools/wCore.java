package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;
import ru.kvaytg.wintools.api.WinTools;
import ru.kvaytg.wintools.util.DirectoryName;

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

    private wCore() {
        throw new AssertionError("No instances allowed");
    }

    static {
        LIBRARY_PATH = getLibraryPath();
        loadLibrary();
    }

    static synchronized void loadLibrary() {
        if (!Files.exists(LIBRARY_PATH)) {
            if (!isWindowsOS()) {
                throw new RuntimeException(WinTools.NAME + " only works on Windows");
            }
            try {
                copyLibraryFromResources();
            } catch (IOException ex) {
                throw new RuntimeException("Failed to copy native library", ex);
            }
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

    private static Path getLibraryPath() {
        String tempDir = System.getenv().getOrDefault("TEMP", System.getProperty("java.io.tmpdir"));
        Path libraryDir = Paths.get(tempDir, DirectoryName.get());
        int bitDepth = System.getProperty("os.arch").contains("64") ? 64 : 32;
        String libraryName = String.format("WTools%d.dll", bitDepth);
        return libraryDir.resolve(libraryName);
    }

    public static boolean isWindowsOS() {
        final String osName = System.getProperty("os.name");
        if (osName == null) return false;
        return osName.toLowerCase().startsWith("windows");
    }

}