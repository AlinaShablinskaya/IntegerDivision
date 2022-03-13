package ua.com.foxminded.integerdivision.validator;

public class DivisionValidatorImpl implements DivisionValidator{

    @Override
    public void validate(int division, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can not be 0");
        }
        
        if (division < 0) {
            throw new IllegalArgumentException("Division must be greater than 0");
        }
        
        if (divisor < 0) {
            throw new IllegalArgumentException("Divisor must be greater than 0");
        }   
    }
}
