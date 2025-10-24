package org.example.service;

import org.example.exception.FileReaderException;

public interface FileArrayReader {
    public int[] readFile(String path) throws FileReaderException;
}
