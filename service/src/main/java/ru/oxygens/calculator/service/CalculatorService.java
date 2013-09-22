package ru.oxygens.calculator.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class CalculatorService implements Serializable
{
    private String displayString = ""; 
    private BigDecimal lastResult = BigDecimal.ZERO;
    private char lastOperation = '0';
    
    public void input0()
    {
        displayString = displayString + "0";
    }
    
    public void input1()
    {
            displayString = displayString + "1";
    }
    
    public void input2()
    {
            displayString = displayString + "2";
    }

    public void input3()
    {
            displayString = displayString + "3";
    }

    public void input4()
    {
            displayString = displayString + "4";
    }

    public void input5()
    {
            displayString = displayString + "5";
    }

    public void input6()
    {
            displayString = displayString + "6";
    }

    public void input7()
    {
            displayString = displayString + "7";
    }

    public void input8()
    {
            displayString = displayString + "8";
    }

    public void input9()
    {
            displayString = displayString + "9";
    }
    
    public void inputDecimalSeparator()
    {
        if (displayString.contains(","))
        {
        }
        else
        {
            displayString = displayString + ",";
        }
    }
    
    public void reset()
    {
            displayString = "";
    }
    
    public void add()
    {
        lastResult = getDisplayNumber();
        displayString = "";
        lastOperation = '+';
    }
    
    public void subtract()
    {
        lastResult = getDisplayNumber();
        displayString = "";
        lastOperation = '-';
    }
    
    /**
     * N????????¶?µ?????µ
     */
    public void multiply()
    {
        lastResult = getDisplayNumber();
        displayString = "";
        lastOperation = '*';
    }
    
    public void divide()
    {
        lastResult = getDisplayNumber();
        displayString = "";
        lastOperation = '/';
    }
    
    public void equal()
    {
        BigDecimal operand = getDisplayNumber();
        if (lastOperation == '+') 
        {
            lastResult = lastResult.add(operand);
        }
        if (lastOperation == '-')
        {
            lastResult = lastResult.subtract(operand);
        }
        if (lastOperation == '*')
        {
            lastResult = lastResult.multiply(operand);
        }
        if (lastOperation == '/')
        {
            lastResult = lastResult.divide(operand,10, RoundingMode.HALF_UP);
        }
        displayString = lastResult.toPlainString();
        while (displayString.contains(getDecimalSeparator()) && displayString.endsWith("0"))
        {
            displayString = displayString.substring(0, displayString.length() - 1);
        }
        if (displayString.endsWith(getDecimalSeparator()))
        {
            displayString = displayString.substring(0, displayString.length() - 1);
        }
    }
    
    public void backspace()
    {
        if (!displayString.isEmpty()) 
        {
            displayString = displayString.substring(0,displayString.length()-1);
        }
    }
    
    public String getDisplayString()
    {
        if (displayString.isEmpty())
        {
            return lastResult.toPlainString();
        }
        else
        {
            return displayString;
        }
    }
    
    public boolean hasError()
    {
        return false;
    }

    private BigDecimal getDisplayNumber()
    {
        return new BigDecimal(displayString.replace(",", getDecimalSeparator()));
    }

    private String getDecimalSeparator()
    {
        return DecimalFormatSymbols.getInstance().getDecimalSeparator()+"";
    }

}