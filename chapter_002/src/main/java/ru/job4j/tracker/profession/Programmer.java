package ru.job4j.tracker.profession;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
