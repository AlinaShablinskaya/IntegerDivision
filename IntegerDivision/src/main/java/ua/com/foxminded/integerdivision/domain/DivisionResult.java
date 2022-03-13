package ua.com.foxminded.integerdivision.domain;

import java.util.List;
import java.util.Objects;

public class DivisionResult {
    private final List<DivisionStep> steps;
    private final int divisor;
    private final int division;

    public DivisionResult(List<DivisionStep> steps, int divisor, int division) {
        this.steps = steps;
        this.divisor = divisor;
        this.division = division;
    }

    public List<DivisionStep> getSteps() {
        return steps;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getDivision() {
        return division;
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps, divisor, division);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DivisionResult other = (DivisionResult) obj;
        return Objects.equals(steps, other.steps) &&
                Objects.equals(divisor, other.divisor) &&
                Objects.equals(division, other.division); 
    }

    @Override
    public String toString() {
        return "DivisionResult [steps=" + steps + ", divisor=" + divisor + ", division=" + division + "]";
    }
}
