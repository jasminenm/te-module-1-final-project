package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Movie implements CatalogItem {
    private static final String FILE_BASE_PATH = "src/main/resources/";
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public String toString() {
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }


    @Override
    public boolean matchesName(String searchStr) {
        return name.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return director.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return releaseDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() throws FileStorageException {
        id = UUID.randomUUID().toString();
        FileStorageService.writeContentsToFile
                (this.toString() + " was added to the catalog.",
                (FILE_BASE_PATH + "logs/MovieLog.txt"), true);
    }
}
