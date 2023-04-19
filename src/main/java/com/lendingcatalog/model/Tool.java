package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.util.UUID;

public class Tool implements CatalogItem {
    private static final String FILE_BASE_PATH = "src/main/resources/";
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public String toString() {
        return "* " + type + System.lineSeparator()
                + " - Manufactured by: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return type.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return manufacturer.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() throws FileStorageException {
        id = UUID.randomUUID().toString();
        FileStorageService.writeContentsToFile
                (this.toString() + " was added to the catalog.",
                (FILE_BASE_PATH + "logs/ToolLog.txt"), true);
    }
}
