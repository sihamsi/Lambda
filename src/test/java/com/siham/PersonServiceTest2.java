package com.siham;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonServiceTest2 {

    // Méthode pour filtrer les personnes par adresse dans le test
    public static List<Person> findPeopleAtAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                new Person("Siham", "Benali", LocalDate.of(1995, 7, 15), "20 Avenue Al Massira"),
                new Person("Omar", "El Khoury", LocalDate.of(1988, 11, 3), "50 Rue des Palmiers"),
                new Person("Fatima", "Zahra", LocalDate.of(1978, 9, 25), "20 Avenue Al Massira"));
        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);
        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    @Test
    public void testFindPeopleAtAddress() {
        List<Person> peopleAt20AvenueAlMassira = findPeopleAtAddress("20 Avenue Al Massira");
        List<Person> expectedPeopleAt20AvenueAlMassira = Arrays.asList(
                new Person("Siham", "Benali", LocalDate.of(1995, 7, 15), "20 Avenue Al Massira"),
                new Person("Fatima", "Zahra", LocalDate.of(1978, 9, 25), "20 Avenue Al Massira"));
        assertThat(peopleAt20AvenueAlMassira).containsExactlyElementsOf(expectedPeopleAt20AvenueAlMassira);
    }

    @Test
    public void testGetAdultsOver21() {
        List<Person> adultsOver21 = PersonService2.getAdultsOver21();
        List<Person> expectedAdultPersons = Arrays.asList(
                new Person("Siham", "Benali", LocalDate.of(1995, 7, 15), "20 Avenue Al Massira"),
                new Person("Fatima", "Zahra", LocalDate.of(1978, 9, 25), "20 Avenue Al Massira"));
        assertThat(adultsOver21).containsExactlyElementsOf(expectedAdultPersons);
    }
}
