package com.siham;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService2 {

    // Nouvelle méthode pour filtrer les adultes
    public static List<Person> getAdultsOver21() {
        List<Person> mockPersonsDatabase = Arrays.asList(
                new Person("siham", "Wazani", LocalDate.of(2003, 2, 15), "22, hay el farah"),
                new Person("meryem", "berrani", LocalDate.of(2001, 3, 20), "10 Rue des fleurs"),
                new Person("salma", "berrada", LocalDate.of(2004, 10, 31), "96 Avenue des arts"));
        Predicate<Person> isAdult = person -> person.calculateAge() >= 21;
        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }
}