package org.example.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exception.FileReaderException;
import org.example.service.FileArrayReader;
import org.example.service.LineValidator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileArrayReaderService implements FileArrayReader {

    private final LineValidator lineValidator;
    public static final Logger logger = LogManager.getLogger(FileArrayReaderService.class);
    public static final String REGEX = "[,;\\s]+";

    public FileArrayReaderService(LineValidator lineValidator) {
        this.lineValidator = lineValidator;
    }

    @Override
    public int[] readFile(String path) throws FileReaderException {
        List<Integer> numbers = new ArrayList<>();

        try {
            var resource = getClass().getClassLoader().getResource(path);
            if (resource == null) {
                throw new FileReaderException("File not found: " + path);
            }

            Path filePath = Path.of(resource.toURI());
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                if (lineValidator.isValid(line)) {
                    String[] tokens = line.trim().split(REGEX);

                    for (String token : tokens) {
                        if (!token.isEmpty()) {
                            numbers.add(Integer.parseInt(token));
                        }
                    }

                    logger.info("Valid line processed: " + line);
                } else {
                    logger.info("Invalid line skipped: " + line);
                }
            }

            return numbers.stream().mapToInt(Integer::intValue).toArray();

        } catch (IOException e) {
            throw new FileReaderException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
