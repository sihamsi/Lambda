package com.siham;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String familyName;
    private LocalDate birthDate;
    private String address;

    public Person(String firstName, String familyName, LocalDate birthDate, String address) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getAddress() {
        return address;
    }

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}