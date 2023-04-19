package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Book implements CatalogItem {
    private static final String FILE_BASE_PATH = "src/main/resources/";
    //Declare variables
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    // Constructor
    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
    //toString method to display title, author, publish date and ID
    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }

    //CatalogItem interface methods
    @Override
    public boolean matchesName(String searchStr) {

        return title.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {

        return author.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {

        return publishDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() throws FileStorageException {
        id = UUID.randomUUID().toString();
        FileStorageService.writeContentsToFile
                (this.toString() + " was added to the catalog.",
                (FILE_BASE_PATH + "logs/BookLog.txt"), true);
    }
}
