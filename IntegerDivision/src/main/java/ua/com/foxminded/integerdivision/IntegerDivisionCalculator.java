package ua.com.foxminded.integerdivision;

import ua.com.foxminded.integerdivision.domain.DivisionResult;
import ua.com.foxminded.integerdivision.provider.DivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.DivisionViewProvider;
import ua.com.foxminded.integerdivision.validator.DivisionValidator;

public class IntegerDivisionCalculator {
    
    private final DivisionMathProvider divisionMathProvider;
    private final DivisionValidator divisionValidator;
    private final DivisionViewProvider divisionViewProvider;
    
    public IntegerDivisionCalculator(DivisionMathProvider divisionMathProvider, DivisionValidator divisionValidator,
            DivisionViewProvider divisionViewProvider) {
        this.divisionMathProvider = divisionMathProvider;
        this.divisionValidator = divisionValidator;
        this.divisionViewProvider = divisionViewProvider;
    }
    
    public String calculateDivision(int division, int divisor) {
        divisionValidator.validate(division, divisor);
        
        DivisionResult divisionResult = divisionMathProvider.provideMathDivision(division, divisor);
        
        return divisionViewProvider.provideView(divisionResult);  
    }
}
