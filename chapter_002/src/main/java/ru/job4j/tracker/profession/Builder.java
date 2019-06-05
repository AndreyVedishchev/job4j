package ru.job4j.tracker.profession;

public class Builder extends Engineer {
    private String whatBuilds;

    public Builder(String whatBuilds) {
        this.whatBuilds = whatBuilds;
    }

    public String getWhatBuilds() {
        return whatBuilds;
    }
}
