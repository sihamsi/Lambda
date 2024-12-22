package com.siham;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService1 {

    // Méthode pour trouver les personnes par adresse
    public static List<Person> findByLocation(String location) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                new Person("siham", "Wazani", LocalDate.of(2003, 2, 15), "22, hay el farah"),
                new Person("meryem", "berrani", LocalDate.of(2001, 3, 20), "10 Rue des fleurs"),
                new Person("salma", "berrada", LocalDate.of(2004, 10, 31), "96 Avenue des arts"));
        Predicate<Person> hasLocation = person -> person.getAddress().equals(location);
        return mockPersonsDatabase.stream()
                .filter(hasLocation)
                .collect(Collectors.toList());
    }

    // Méthode pour trouver les adultes
    public static List<Person> getAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
                new Person("siham", "Wazani", LocalDate.of(2003, 2, 15), "22, hay el farah"),
                new Person("meryem", "berrani", LocalDate.of(2001, 3, 20), "10 Rue des fleurs"),
                new Person("salma", "berrada", LocalDate.of(2004, 10, 31), "96 Avenue des arts"));
        Predicate<Person> isAdult = person -> person.calculateAge() >= 18;
        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }
}
