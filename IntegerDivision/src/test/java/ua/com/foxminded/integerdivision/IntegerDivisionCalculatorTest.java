package ua.com.foxminded.integerdivision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ua.com.foxminded.integerdivision.domain.DivisionResult;
import ua.com.foxminded.integerdivision.domain.DivisionStep;
import ua.com.foxminded.integerdivision.provider.DivisionMathProvider;
import ua.com.foxminded.integerdivision.provider.DivisionViewProvider;
import ua.com.foxminded.integerdivision.validator.DivisionValidator;

@ExtendWith(MockitoExtension.class)
class IntegerDivisionCalculatorTest {
     
    @Mock
    private DivisionMathProvider divisionMathProvider;
    
    @Mock
    private DivisionViewProvider divisionviewProvider;
    
    @Mock
    private DivisionValidator divisionValidator;
    
    @InjectMocks
    private IntegerDivisionCalculator integerDivisionCalculator;   
    
    @Test
    void calculateDivisionShouldReturnResultIfDivionIsGreaterThanDivisor() {
        
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 12, 3877);
 
        divisionSteps.add(new DivisionStep(36, 38, 2));
        divisionSteps.add(new DivisionStep(24, 27, 3));
        divisionSteps.add(new DivisionStep(36, 37, 1));

        String expected =
                "_3877|12\n" + 
                " 36  |---\n" +
                " --  |323\n" +
                " _27\n" +
                "  24\n" +
                "  --\n" +
                "  _37\n" +
                "   36\n" +
                "   --\n" +
                "    1";
        
        when(divisionMathProvider.provideMathDivision(3877, 12)).thenReturn(divisionresult);
        when(divisionviewProvider.provideView(divisionresult)).thenReturn(expected);
        
        String actual = integerDivisionCalculator.calculateDivision(3877, 12);
        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void calculateDivisionShouldReturnResultIfDivisorContainsZeroes() {
        
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 12, 3877);
 
        divisionSteps.add(new DivisionStep(10, 10, 0));

        String expected =
                "_100003|10\n" + 
                " 10    |-----\n" +
                " --    |10000\n" +
                "  0";
        
        when(divisionMathProvider.provideMathDivision(100003, 10)).thenReturn(divisionresult);
        when(divisionviewProvider.provideView(divisionresult)).thenReturn(expected);
        
        String actual = integerDivisionCalculator.calculateDivision(100003, 10);
        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void calculateDivisionShouldReturnResultIfDivisionEqualsZero() {
        
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 12, 3877);
 
        divisionSteps.add(new DivisionStep(0, 0, 0));

        String expected =
                "_0|10\n" + 
                " 0|-\n" +
                " -|0\n" +
                " 0";
        
        when(divisionMathProvider.provideMathDivision(0, 10)).thenReturn(divisionresult);
        when(divisionviewProvider.provideView(divisionresult)).thenReturn(expected);
        
        String actual = integerDivisionCalculator.calculateDivision(0, 10);
        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void calculateDivisionShouldReturnResultIfDivionIsSmallerThenDivisor() {
        
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 12, 3877);
 
        divisionSteps.add(new DivisionStep(110, 110, 0));

        String expected =
                "_110|320\n" + 
                " 110|-\n" +
                " ---|0\n" +
                "   0";
        
        when(divisionMathProvider.provideMathDivision(110, 320)).thenReturn(divisionresult);
        when(divisionviewProvider.provideView(divisionresult)).thenReturn(expected);
        
        String actual = integerDivisionCalculator.calculateDivision(110, 320);
        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void calculateDivisionShouldReturnIllegalArgumentExceptionIfDivisorIsZero() {
        
        String expected = "Divisor can not be 0";
        
        doThrow(new IllegalArgumentException(expected)).when(divisionValidator).validate(2845, 0);
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> integerDivisionCalculator.calculateDivision(2845, 0));
        String actual = exeption.getMessage();
        
        assertThat(expected, is(equalTo(actual)));
    }
}
