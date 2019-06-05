package ru.job4j.tracker.profession;

public class Dentist extends Doctor {
    private String specialization, nameClinic;

    public Dentist(String specialization, String nameClinic) {
        this.specialization = specialization;
        this.nameClinic = nameClinic;
    }

    public Diagnose heal(Pacient pacient) {
        return null;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getNameClinic() {
        return nameClinic;
    }
}
