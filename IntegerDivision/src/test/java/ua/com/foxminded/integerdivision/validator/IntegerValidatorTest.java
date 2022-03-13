package ua.com.foxminded.integerdivision.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

class IntegerValidatorTest {
    
    private final DivisionValidator divisionValidator = new DivisionValidatorImpl();

    @Test
    void validateShouldReturnIllegalArgumentExceptionIfDivisorIsZero() {
        
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> divisionValidator.validate(2845, 0));
        
        String expected = "Divisor can not be 0";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateShouldReturnIllegalArgumentExceptionIfDivisionIsNegative() {
        
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> divisionValidator.validate(-2845, 25));
        
        String expected = "Division must be greater than 0";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateShouldReturnIllegalArgumentExceptionIfDivisorIsNegative() {
        
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> divisionValidator.validate(2845, -25));
        
        String expected = "Divisor must be greater than 0";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateShouldNotReturnException() {
        
        assertDoesNotThrow(() -> divisionValidator.validate(2845, 25));
    }  
}
