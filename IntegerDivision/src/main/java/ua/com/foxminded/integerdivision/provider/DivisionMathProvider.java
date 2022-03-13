package ua.com.foxminded.integerdivision.provider;


import ua.com.foxminded.integerdivision.domain.DivisionResult;

public interface DivisionMathProvider {
    DivisionResult provideMathDivision(int division, int divisor);
}
