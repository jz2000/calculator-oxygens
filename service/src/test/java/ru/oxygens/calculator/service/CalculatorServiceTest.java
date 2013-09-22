package ru.oxygens.calculator.service;

import java.text.DecimalFormatSymbols;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jz
 */
public class CalculatorServiceTest
{

    public CalculatorServiceTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testDisplay()
    {
        System.out.println("testDisplay");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        instance.input1();
        instance.input2();
        instance.input3();
        instance.input4();
        instance.input5();
        instance.input6();
        instance.input7();
        instance.input8();
        instance.input9();
        instance.input0();
        assertEquals("1234567890", instance.getDisplayString());
    }

    private void inputString(
            CalculatorService _CaculatorService,
            String _St)
    {
        for (char c : _St.toCharArray())
        {
            if (c == '0')
            {
                _CaculatorService.input0();
            }
            if (c == '1')
            {
                _CaculatorService.input1();
            }
            if (c == '2')
            {
                _CaculatorService.input2();
            }
            if (c == '3')
            {
                _CaculatorService.input3();
            }
            if (c == '4')
            {
                _CaculatorService.input4();
            }
            if (c == '5')
            {
                _CaculatorService.input5();
            }
            if (c == '6')
            {
                _CaculatorService.input6();
            }
            if (c == '7')
            {
                _CaculatorService.input7();
            }
            if (c == '8')
            {
                _CaculatorService.input8();
            }
            if (c == '9')
            {
                _CaculatorService.input9();
            }
            if (c == ',')
            {
                _CaculatorService.inputDecimalSeparator();
            }
            if (c == '.')
            {
                _CaculatorService.inputDecimalSeparator();
            }
        }
    }

    @Test
    public void testAdd()
    {
        System.out.println("testAdd");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "13");
        instance.add();
        inputString(instance, "5");
        instance.equal();

        assertEquals("18", instance.getDisplayString());
    }

    @Test
    public void testSubtract()
    {
        System.out.println("testSubtract");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "27");
        instance.subtract();
        inputString(instance, "6");
        instance.equal();

        assertEquals("21", instance.getDisplayString());
    }

    @Test
    public void testMulti()
    {
        System.out.println("testMulti");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "5");
        instance.multiply();
        inputString(instance, "11");
        instance.equal();

        assertEquals("55", instance.getDisplayString());
    }

    @Test
    public void testDivide()
    {
        System.out.println("testDivide");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "82");
        instance.divide();
        inputString(instance, "2");
        instance.equal();

        assertEquals("41", instance.getDisplayString());
    }

    @Test
    public void testBack()
    {
        System.out.println("testback");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "135798642");
        instance.backspace();
        instance.backspace();
        instance.backspace();
        assertEquals("135798", instance.getDisplayString());
    }

    @Test
    public void testDecimalSeparator()
    {
        System.out.println("testDecimalSeparator");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "5,2");
        instance.multiply();
        inputString(instance, "2,2");
        instance.equal();
        assertEquals("11"+DecimalFormatSymbols.getInstance().getDecimalSeparator()+"44", instance.getDisplayString());
    }

    @Test
    public void testDoubleDecimalSeparator()
    {
        System.out.println("testDoubleDecimalSeparator");
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "5,,2");
        assertEquals("5,2", instance.getDisplayString());
    }

    /**
     * Test of hasError method, of class CaculatorService.
     */
    @Test
    public void testHasError()
    {

    }

    @Test
    public void testDivErr()
    {
        CalculatorService instance = new CalculatorService();
        instance.reset();
        inputString(instance, "1");
        instance.divide();
        inputString(instance, "3");
        instance.equal();

        assertEquals("0.3333333333", instance.getDisplayString());
    }
    @Test
    public void testDisplayDefault()
    {
        CalculatorService instance = new CalculatorService();
        instance.reset();
        assertEquals("0", instance.getDisplayString());
        inputString(instance, "1");
        instance.divide();
        assertEquals("1", instance.getDisplayString());
        inputString(instance, "3");
        assertEquals("3", instance.getDisplayString());
        instance.equal();

        assertEquals("0.3333333333", instance.getDisplayString());
    }
}