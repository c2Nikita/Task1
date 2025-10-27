package org.example.task.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.exception.FileReaderException;
import org.example.task.reader.FileArrayReader;
import org.example.task.validator.LineValidator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileArrayReaderService implements FileArrayReader {

    private final LineValidator lineValidator;
    public static final Logger logger = LogManager.getLogger();
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
                if (lineValidator.isLineFromFileValid(line)) {
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
            throw new FileReaderException(e,"IO problem");
        } catch (URISyntaxException e) {
            throw new FileReaderException(e,"Uri problem");
        }
    }
}
