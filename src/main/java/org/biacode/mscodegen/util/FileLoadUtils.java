package org.biacode.mscodegen.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

/**
 * Created by Arthur Asatryan.
 * Date: 3/12/18
 * Time: 12:42 PM
 * <p>
 * Copied from https://github.com/Biacode/bia-engine/blob/master/src/main/java/engine/util/FileLoadUtils.java
 */
public final class FileLoadUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileLoadUtils.class);

    private FileLoadUtils() {
    }

    //region Public API
    public static String loadFileSource(final String file) {
        LOGGER.debug("Loading file - {}", file);
        final StringBuilder shaderSource = new StringBuilder();
        try (
                final FileReader fileReader = new FileReader(file);
                final BufferedReader reader = new BufferedReader(fileReader)
        ) {
            reader.lines().forEach(line -> shaderSource.append(line).append("\n"));
        } catch (final IOException ex) {
            LOGGER.error("Exception occurred - {} while loading file - {}", ex, file);
            throw new IllegalArgumentException("Can not load source for file - " + file);
        }
        final String shaderSourceString = shaderSource.toString();
        LOGGER.debug("Loaded source:\n{}", shaderSourceString);
        return shaderSourceString;
    }

    public static String getResourcePath(final String resource) {
        return Optional.ofNullable(FileLoadUtils.class.getClassLoader().getResource(resource)).map(URL::getFile).orElseThrow(() -> {
            LOGGER.error("Can not find resource - {}", resource);
            return new IllegalArgumentException("Can not find resource - " + resource);
        });
    }
    //endregion
}
