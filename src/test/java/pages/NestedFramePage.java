package pages;

import org.openqa.selenium.By;
import supports.Browser;

import static supports.Browser.getText;
import static supports.Browser.visit;

public class NestedFramePage {
    public void open() {
        visit("https://the-internet.herokuapp.com/nested_frames");
    }

    private void moveToFrame(String frameName) {
        Browser.moveToFrame(frameName);
    }

    private void moveBackToParentFrame() {
        Browser.moveBackToParentFrame();
    }

    private void moveToDefaultFrame() {
        Browser.moveToDefaultFrame();
    }

    public String getFrameContent() {
        return getText(By.xpath("//html/body"));
    }

    private void moveToTopFrame() {
        moveToDefaultFrame();
        moveToFrame("frame-top");
    }

    public String getLeftFrameContent() {
        moveToTopFrame();
        moveToFrame("frame-left");
        return getFrameContent();
    }

    public String getMiddleFrameContent() {
        moveToTopFrame();
        moveToFrame("frame-middle");
        return getFrameContent();
    }

    public String getRightFrameContent() {
        moveToTopFrame();
        moveToFrame("frame-right");
        return getFrameContent();
    }

    public String getBottomFrameContent() {
        moveToDefaultFrame();
        moveToFrame("frame-bottom");
        return getFrameContent();
    }
}
