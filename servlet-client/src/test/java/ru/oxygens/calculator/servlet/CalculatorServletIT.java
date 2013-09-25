package ru.oxygens.calculator.servlet;

import com.thoughtworks.selenium.SeleneseTestCase;
import static junit.framework.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.junit.Before;
import org.junit.Test;

public class CalculatorServletIT extends SeleneseTestCase {
// We create our Selenium test case

    @Before
    public void setUp() throws Exception {
        setUp("http://localhost:8080/", "*firefox");
        // We instantiate and start the browser
    }

    @Test
    public void testNew() throws Exception {
        selenium.open("/");
        selenium.click("link=C");
        selenium.waitForPageToLoad("300");
        selenium.click("link=1");
        selenium.waitForPageToLoad("300");
        selenium.click("link=2");
        selenium.waitForPageToLoad("300");
        selenium.click("link=3");
        selenium.waitForPageToLoad("300");
        selenium.click("link=+");
        selenium.waitForPageToLoad("300");
        selenium.click("link=1");
        selenium.waitForPageToLoad("300");
        selenium.click("link=2");
        selenium.waitForPageToLoad("300");
        selenium.click("link=3");
        selenium.waitForPageToLoad("300");
        selenium.click("link==");
        assertTrue(selenium.isTextPresent("246"));
        // These are the real test steps
    }
}
