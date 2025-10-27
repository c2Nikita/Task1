package org.example.task.reader;

import org.example.task.exception.FileReaderException;

public interface FileArrayReader {
    int[] readFile(String path) throws FileReaderException;
    //Add parser
}
