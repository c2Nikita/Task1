package org.example.task.reader;

import org.example.task.exception.ArrayException;

import java.util.List;

public interface FileArrayReader {

    List<String> readFile(String path) throws ArrayException;
}
