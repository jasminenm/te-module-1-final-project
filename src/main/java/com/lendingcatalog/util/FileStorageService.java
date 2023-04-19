package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        File writeFile = new File(filename);
        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(writeFile, true))) {
          dataOutput.print(contents);
        }
        catch (FileNotFoundException e) {
            throw new FileStorageException("Unable to write to file.");
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        File fileToRead = new File(filename);
        try (Scanner fileReader = new Scanner(fileToRead)) {
            List<String> fileOutput = new ArrayList<>();
            while (fileReader.hasNext()) {
                String currentLine = fileReader.nextLine();
                fileOutput.add(currentLine);
            }
            return fileOutput;
        }
        catch (FileNotFoundException e) {
            throw new FileStorageException("File Not Found");
        }
    }
}
