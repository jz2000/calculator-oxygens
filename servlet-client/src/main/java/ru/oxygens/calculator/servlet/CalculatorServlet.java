package ru.oxygens.calculator.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import ru.oxygens.calculator.service.CalculatorService;



/**
 *
 * @author sergey.zheznyakovskiy
 */
@WebServlet(urlPatterns = {"/"})
public class CalculatorServlet extends HttpServlet {

    private static final String P_ACTION = "action";
    
    private static final String ACT_0 = "input0";
    private static final String ACT_1 = "input1";
    private static final String ACT_2 = "input2";
    private static final String ACT_3 = "input3";
    private static final String ACT_4 = "input4";
    private static final String ACT_5 = "input5";
    private static final String ACT_6 = "input6";
    private static final String ACT_7 = "input7";
    private static final String ACT_8 = "input8";
    private static final String ACT_9 = "input9";
    private static final String ACT_DEC = "dec";
    private static final String ACT_EQUAL = "equal";
    private static final String ACT_PLUS = "plus";
    private static final String ACT_MINUS = "minus";
    private static final String ACT_MULT = "mult";
    private static final String ACT_DIV = "div";
    private static final String ACT_BACK = "back";
    private static final String ACT_RESET = "reset";
    
    private CalculatorService calculatorService = new CalculatorService();
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* Get the output writer */
        PrintWriter writer = res.getWriter();
        Map<String, String[]> parameters = req.getParameterMap();
        /* If there is an action in the command line */
        if (parameters.containsKey(P_ACTION)) {
            /* Take up the action */
            String action = parameters.get(P_ACTION)[0];
            /* Perform the action */
            if (ACT_0.equals(action)) { calculatorService.input0(); }
            if (ACT_1.equals(action)) { calculatorService.input1(); }
            if (ACT_2.equals(action)) { calculatorService.input2(); }
            if (ACT_3.equals(action)) { calculatorService.input3(); }
            if (ACT_4.equals(action)) { calculatorService.input4(); }
            if (ACT_5.equals(action)) { calculatorService.input5(); }
            if (ACT_6.equals(action)) { calculatorService.input6(); }
            if (ACT_7.equals(action)) { calculatorService.input7(); }
            if (ACT_8.equals(action)) { calculatorService.input8(); }
            if (ACT_9.equals(action)) { calculatorService.input9(); }
            if (ACT_DEC.equals(action)) { calculatorService.inputDecimalSeparator();}
            if (ACT_EQUAL.equals(action)) { calculatorService.equal();}
            if (ACT_PLUS.equals(action)) { calculatorService.add();}
            if (ACT_MINUS.equals(action)) { calculatorService.subtract();}
            if (ACT_MULT.equals(action)) { calculatorService.multiply();}
            if (ACT_DIV.equals(action)) { calculatorService.divide();}
            if (ACT_BACK.equals(action)) { calculatorService.backspace();}
            if (ACT_RESET.equals(action)) { calculatorService.reset();}
        }
        /* Output the page header */
        writer.append("<html>");
        writer.append("<title>Oxigens-Calculator</title>");
        writer.append("<body>");
        /* Display the indicator string */
        writer.append("<h1><p align=center>");
        writer.append(calculatorService.getDisplayString());
        writer.append("</p></h1>");
        /* Display the buttons table */
        writer.append("<table border cellpadding=20 align=center>");
          writer.append("<tr>");
              writer.append("<td>").append("</td>");
              writer.append("<td>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_BACK + "\">back</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_RESET + "\">C</a>").append("</td>");
          writer.append("</tr>");
          writer.append("<tr>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_7 + "\">7</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_8 + "\">8</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_9 + "\">9</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_DIV + "\">/</a>").append("</td>");
          writer.append("</tr>");
          writer.append("<tr>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_4 + "\">4</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_5 + "\">5</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_6 + "\">6</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_MULT + "\">*</a>").append("</td>");
          writer.append("</tr>");
          writer.append("<tr>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_1 + "\">1</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_2 + "\">2</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_3 + "\">3</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_MINUS + "\">-</a>").append("</td>");
          writer.append("</tr>");
          writer.append("<tr>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_0 + "\">0</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_DEC + "\">,</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_EQUAL + "\">=</a>").append("</td>");
              writer.append("<td>").append("<a href=\"?" + P_ACTION + "=" + ACT_PLUS + "\">+</a>").append("</td>");
          writer.append("</tr>");
        writer.append("</table>");
        /* Ouput the page footer */
        writer.append("</body>");
        writer.append("</html>");
        writer.flush();
    }
    
}
