package ru.job4j.tracker.profession;

public class Surgeon extends Doctor {
    private String specialization, nameClinic;

    public Surgeon(String specialization, String nameClinic) {
        this.specialization = specialization;
        this.nameClinic = nameClinic;
    }

    public boolean inspection(Pacient pacient) {
        return true;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getNameClinic() {
        return nameClinic;
    }
}
