package ua.com.foxminded.integerdivision.provider;

import java.util.List;
import java.util.ArrayList;

import ua.com.foxminded.integerdivision.domain.DivisionResult;
import ua.com.foxminded.integerdivision.domain.DivisionStep;

public class DivisionMathImpl implements DivisionMathProvider{
    private static final int DECIMAL_BASE = 10;

    @Override
    public DivisionResult provideMathDivision(int division, int divisor) {
        List<DivisionStep> steps = new ArrayList<>();   
        
        DivisionResult result = new DivisionResult(steps, divisor, division);
        
        int[] divisionDigits = splitDivision(division); 
        
        if (division < divisor) {
            steps.add(new DivisionStep(division, division, 0));
            return result;
        }
        
        int remainder = 0;
        
        for (int digit : divisionDigits) {
            int quotient = remainder * 10 + digit;
            int multiply = quotient - (quotient % divisor);
            
            if (digit < divisor) {
                remainder = quotient;
            }
            
            if (quotient >= divisor) {
                remainder = quotient - multiply;
                steps.add(new DivisionStep(multiply, quotient, remainder));
            } 
        }
        return result;
    }
    
    private int[] splitDivision (int division) {
        int divisionLength = String.valueOf(division).length();
        int[] divisionDigits = new int[divisionLength];
        
        for (int i = divisionLength-1; i >= 0; i--) {
            divisionDigits[i] = division % DECIMAL_BASE;
            division /= DECIMAL_BASE;
        }
        return divisionDigits;
    }   
}
