package pages;

import org.openqa.selenium.By;
import supports.Browser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebTablePage {
    List<Person> table1 = new ArrayList<>();

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/tables");
        Browser.getElementList(By.xpath("//*[@id='table1']/tbody/tr"))
                .stream()
                .forEach(row -> {
                    table1.add(new Person(row.getText()));
                });
    }

    public List<String> getMaxDuePerson() {
        Person maxDuePerson = table1.stream().max(Comparator.comparing(Person::getDue)).get();
        return table1.stream().filter(p -> p.getDue() == maxDuePerson.getDue()).map(Person::getFullName).collect(Collectors.toList());
    }

    public List<String> getMinDuePerson() {
        Person minDuePerson = table1.stream().min(Comparator.comparing(Person::getDue)).get();
        return table1.stream().filter(p -> p.getDue() == minDuePerson.getDue()).map(Person::getFullName).collect(Collectors.toList());
    }
}
