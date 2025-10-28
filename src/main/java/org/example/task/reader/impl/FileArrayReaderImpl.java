package org.example.task.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.exception.FileReaderException;
import org.example.task.reader.FileArrayReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileArrayReaderImpl implements FileArrayReader {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFile(String path) throws FileReaderException {
        logger.info("Attempting to read file: {}", path);
        try {
            URL resource = getClass().getClassLoader().getResource(path);
            if (resource == null) {
                throw new FileReaderException("File not found: " + path);
            }

            Path filePath = Path.of(resource.toURI());
            List<String> lines = Files.readAllLines(filePath);
            logger.info("File readed");
            return lines;

        } catch (IOException e) {
            throw new FileReaderException(e,"IO problem while reading file "+path);
        } catch (URISyntaxException e) {
            throw new FileReaderException(e,"Uri problem for file "+path);
        }
    }
}
