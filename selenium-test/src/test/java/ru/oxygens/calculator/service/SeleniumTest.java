package ru.oxygens.calculator.service;

import com.thoughtworks.selenium.SeleneseTestCase;
import org.openqa.selenium.Keys;
import org.junit.Before;
import org.junit.Test;

public class SeleniumTest  extends SeleneseTestCase {
// We create our Selenium test case

    @Before
        public void setUp() throws Exception {
	        setUp("http://www.yandex.ru/", "*firefox C:/Users/Sergey_Zheznyakovski/AppData/Local/Mozilla Firefox/FireFox.exe");
		        // We instantiate and start the browser
			    }

			        @Test
				    public void testNew() throws Exception {
				            selenium.open("/");
					            selenium.type("text", "Oksana Lobysheva");
						            selenium.click("//input[@value='ÎáÎíÎáÎáÎõÎİÎáÎõÎ÷ÎåÎåÎõÎáÎõÎı']");
							            //selenium.keyPressNative(Keys.ENTER + "");
								            selenium.waitForPageToLoad("30000");
									            assertTrue(selenium.isTextPresent("ÎáÎíÎáÎáÎõÎİÎåÎåÎíÎáÎõÎİÎåÎéÎéÎáÎõÎıÎáÎõÎåÎáÎõÎİÎáÎùÎéÎáÎõÎıÎáÎõÎñ ÎáÎùÎéÎáÎùÎíÎáÎõÎéÎåÎåÎõÎáÎõÎñÎáÎõÎ÷"));
										            // These are the real test steps
											        }
												}

