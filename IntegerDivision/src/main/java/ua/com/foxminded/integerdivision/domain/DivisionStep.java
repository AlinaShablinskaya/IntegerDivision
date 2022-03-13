package ua.com.foxminded.integerdivision.domain;

import java.util.Objects;

public class DivisionStep {
    private final int multiply;
    private final int quotient;
    private final int remainder;
    
    public DivisionStep(int multiply, int quotient, int remainder) {
        this.multiply = multiply;
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public int getMultiply() {
        return multiply;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(multiply, quotient, remainder);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DivisionStep other = (DivisionStep) obj;
        return Objects.equals(multiply, other.multiply) &&
               Objects.equals(quotient, other.quotient) &&
               Objects.equals(remainder, other.remainder);
    }

    @Override
    public String toString() {
        return "DivisionStep [multiply=" + multiply + ", quotient=" + quotient + ", remainder=" + remainder + "]";
    }
}
