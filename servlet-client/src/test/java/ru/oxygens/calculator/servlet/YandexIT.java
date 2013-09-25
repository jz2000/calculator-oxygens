package ru.oxygens.calculator.servlet;

import com.thoughtworks.selenium.SeleneseTestCase;
import org.openqa.selenium.Keys;
import org.junit.Before;
import org.junit.Test;

public class YandexIT extends SeleneseTestCase {
// We create our Selenium test case

    @Before
    public void setUp() throws Exception {
        setUp("http://www.yandex.ru/", "*firefox");
        // We instantiate and start the browser
    }

    @Test
    public void testNew() throws Exception {
        selenium.open("/");
        selenium.type("text", "Oksana Lobysheva");
        selenium.click("//input[@value='Найти']");
        //selenium.keyPressNative(Keys.ENTER + "");
        selenium.waitForPageToLoad("30000");
        assertTrue(selenium.isTextPresent("Наращивание ногтей"));
        // These are the real test steps
    }
}
