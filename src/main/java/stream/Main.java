package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male");
        Person person2 = new Person("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male");
        Person person3 = new Person("Leia Organa", 150, 49, "brown", "light", "brown", "19BBY", "female");
        Person person4 = new Person("Owen Lars", 178, 120, "brown, grey", "light", "blue", "52BBY", "male");
        Person person5 = new Person("Beru Whitesun lars", 165, 75, "brown", "light", "blue", "47BBY", "female");
        Person person6 = new Person("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male");
        Person person7 = new Person("Obi-Wan Kenobi", 182, 77, "auburn, white", "fair", "blue-gray", "57BBY", "male");

        //Convert JSON ARRAY TO ARRAY OBJECT
        List<Person> characters = Arrays.asList(person1, person2, person3, person4, person5, person6, person7);
        characters.forEach(Person::showInfo);

        System.out.println("Person mass > 100");
        characters.stream().filter(person -> person.getMass() > 100).collect(Collectors.toList()).forEach(Person::showInfo);

        System.out.println("Sum mass");
        System.out.println(characters.stream().mapToInt(Person::getMass).sum());

        //Using Reduce
        System.out.println("Sum mass using reduce");
        Integer totalMass = characters.stream().reduce(0, (mass, person) -> mass + person.getMass(), Integer::sum);
        System.out.println(totalMass);

        //Get list name using map
        System.out.println("Get list name using map");
        List<String> names = characters.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);

        //Get the heaviest person
        System.out.println("Get the heaviest person using max");
        Person heaviestPerson = characters.stream().max(Comparator.comparingInt(Person::getMass)).get();
        heaviestPerson.showInfo();

        //Get the smallest person
        System.out.println("Get the smallest person using min");
        Person smallestPerson = characters.stream().min(Comparator.comparingInt(Person::getMass)).get();
        smallestPerson.showInfo();

        //Sort person by name descending
        System.out.println("Sort person by name descending");
        List<Person> sortPersonByName = characters.stream().sorted(Comparator.comparing(Person::getName).reversed()).collect(Collectors.toList());
        sortPersonByName.forEach(Person::showInfo);

        //Sort person by mass descending
        System.out.println("Sort person by mass descending");
        List<Person> sortPersonByMass = characters.stream().sorted(Comparator.comparingInt(Person::getMass).reversed()).collect(Collectors.toList());
        sortPersonByMass.forEach(Person::showInfo);
    }
}
