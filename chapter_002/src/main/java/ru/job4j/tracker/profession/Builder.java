package ru.job4j.tracker.profession;

public class Builder extends Engineer {
    private String whatBuilds;

    public Builder(String name, String surname, String education, String birthday, String whatBuilds) {
        super(name, surname, education, birthday);
        this.whatBuilds = whatBuilds;
    }

    public String getWhatBuilds() {
        return whatBuilds;
    }
}
