package ua.com.foxminded.integerdivision.provider;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.integerdivision.domain.DivisionStep;
import ua.com.foxminded.integerdivision.domain.DivisionResult;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class IntegerDivisionMathTest {
    
    private final DivisionMathProvider divisionMathProvider = new DivisionMathImpl();

    @Test
    void provideMathDivisionShouldReturnResultIfDivionIsGreaterThanDivisor() {
        
        List<DivisionStep> steps = new ArrayList<>();
 
        steps.add(new DivisionStep(4, 7, 3));
        steps.add(new DivisionStep(36, 38, 2));
        steps.add(new DivisionStep(28, 29, 1));
        steps.add(new DivisionStep(12, 14, 2));
        steps.add(new DivisionStep(24, 25, 1));
        
        DivisionResult expected = new DivisionResult(steps, 4, 78945);
        DivisionResult actual = divisionMathProvider.provideMathDivision(78945, 4);
    
        assertThat(actual, is(equalTo(expected)));      
    }
    
    @Test
    void provideMathDivisionShouldReturnResultIfDivisorContainsZeroes() {
        
        List<DivisionStep> steps = new ArrayList<>();
 
        steps.add(new DivisionStep(10, 10, 0));
     
        DivisionResult expected = new DivisionResult(steps, 10, 100003);
        DivisionResult actual = divisionMathProvider.provideMathDivision(100003, 10);
    
        assertThat(actual, is(equalTo(expected)));      
    }
    
    @Test
    void provideMathDivisionShouldReturnResultIfDivisionEqualsZero() {
        
        List<DivisionStep> steps = new ArrayList<>();
 
        steps.add(new DivisionStep(0, 0, 0));
     
        DivisionResult expected = new DivisionResult(steps, 10, 0);
        DivisionResult actual = divisionMathProvider.provideMathDivision(0, 10);
    
        assertThat(actual, is(equalTo(expected)));      
    }
    
    @Test
    void provideMathDivisionShouldReturnResultIfDivionIsSmallerThenDivisor() {
        
        List<DivisionStep> steps = new ArrayList<>();
 
        steps.add(new DivisionStep(110, 110, 0));
        
        DivisionResult expected = new DivisionResult(steps, 320, 110);
        DivisionResult actual = divisionMathProvider.provideMathDivision(110, 320);
    
        assertThat(actual, is(equalTo(expected)));      
    }    
}
