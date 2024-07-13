package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class DragDropPage {

    By squareA = By.id("column-a");

    By squareB = By.id("column-b");

    public void open() {
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void dragAtoB() {
        dragAndDrop(squareA, squareB);
    }

    public void dragBtoA() {
        dragAndDrop(squareB, squareA);
    }

    public String getSquareAText() {
        return getText(By.cssSelector("#column-a header"));
    }

    public String getSquareBText() {
        return getText(By.cssSelector("#column-b header"));
    }
}
