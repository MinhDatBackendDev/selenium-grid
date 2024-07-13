package pages;

public class Person {
    private String firstName;
    private String lastName;
    private String due;

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public double getDue() {
        return Double.parseDouble(due.replace("$", ""));
    }

    public Person(String rowContent) {
        String[] cells = rowContent.split(" ");
        this.firstName = cells[0];
        this.lastName = cells[1];
        this.due = cells[3];
    }
}
