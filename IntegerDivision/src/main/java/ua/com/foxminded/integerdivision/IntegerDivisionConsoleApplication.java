package ua.com.foxminded.integerdivision;

import ua.com.foxminded.integerdivision.provider.DivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.DivisionViewProvider;
import ua.com.foxminded.integerdivision.provider.DivisionViewImpl;
import ua.com.foxminded.integerdivision.provider.DivisionMathImpl;
import ua.com.foxminded.integerdivision.validator.DivisionValidator;
import ua.com.foxminded.integerdivision.validator.DivisionValidatorImpl;

public class IntegerDivisionConsoleApplication {
    
    public static void main( String[] args ) {
        DivisionValidator validator = new DivisionValidatorImpl();
        DivisionMathProvider mathProvider = new DivisionMathImpl();
        DivisionViewProvider viewProvider = new DivisionViewImpl();
        
        IntegerDivisionCalculator calculator = new IntegerDivisionCalculator(mathProvider, validator, viewProvider);
        
        System.out.println(calculator.calculateDivision(110, 320)); 
    }
}
