package ua.com.foxminded.integerdivision.provider;

import java.util.List;

import ua.com.foxminded.integerdivision.domain.DivisionResult;
import ua.com.foxminded.integerdivision.domain.DivisionStep;

public class DivisionViewImpl implements DivisionViewProvider{
        private static final String SPACE = " ";
        private static final String MINUS = "_";
        private static final String VERTICAL_LINE = "|";
        private static final String HORIZONTAL_LINE = "-";
        private static final String NEW_LINE = "\n";
    
    @Override
    public String provideView(DivisionResult divisionResult) {
        
        List<DivisionStep> steps = divisionResult.getSteps();
        StringBuilder output = new StringBuilder();
        DivisionStep initialDivisionSteps = steps.get(0);
        
        return output.append(divisionFormatter(divisionResult, initialDivisionSteps))
                .append(lastdivisionFormatter(steps))
                .toString();
        }
    
    private String divisionFormatter (DivisionResult divisionResult, DivisionStep firstDivisionStep) {
        StringBuilder firstStep = new StringBuilder();
        
        int result = divisionResult.getDivision() / divisionResult.getDivisor();
        int divisionLength = String.valueOf(divisionResult.getDivision()).length();
        int resultLength = String.valueOf(result).length();
        int firstMultiplyLength = String.valueOf(firstDivisionStep.getMultiply()).length();
        int countOfSpaces = divisionLength - firstMultiplyLength;
        
        return firstStep.append(MINUS)
                .append(divisionResult.getDivision())
                .append(VERTICAL_LINE)
                .append(divisionResult.getDivisor())
                .append(NEW_LINE)
                .append(SPACE)
                .append(firstDivisionStep.getMultiply())
                .append(repeatSymbol(countOfSpaces, SPACE))
                .append(VERTICAL_LINE)
                .append(repeatSymbol(resultLength, HORIZONTAL_LINE))
                .append(NEW_LINE)
                .append(SPACE)
                .append(repeatSymbol(firstMultiplyLength, HORIZONTAL_LINE))
                .append(repeatSymbol(countOfSpaces, SPACE))
                .append(VERTICAL_LINE)
                .append(result)
                .append(NEW_LINE)
                .toString();
    }
    
    private String lastdivisionFormatter (List<DivisionStep> divisionStep) {
        StringBuilder lastStep = new StringBuilder();
        
        int reminderLength = String.valueOf(divisionStep.get(0).getRemainder()).length();
        int lastmultiplyLength = String.valueOf(divisionStep.get(0).getMultiply()).length();
        int indent = lastmultiplyLength - reminderLength + 1;
        
        DivisionStep lastDivisionStep = divisionStep.get(divisionStep.size()-1);
        
        for (int i = 1; i < divisionStep.size(); i++) {
            
            DivisionStep step = divisionStep.get(i);
            int multiplierLength = String.valueOf(step.getMultiply()).length();
            
            lastStep.append(repeatSymbol(indent - 1, SPACE))
                    .append(MINUS)
                    .append(step.getQuotient())
                    .append(NEW_LINE)
                    .append(repeatSymbol(indent, SPACE))
                    .append(step.getMultiply()) 
                    .append(NEW_LINE)
                    .append(repeatSymbol(indent, SPACE))
                    .append(repeatSymbol(lastmultiplyLength, HORIZONTAL_LINE))
                    .append(NEW_LINE);
            
            indent = (repeatSymbol(indent, SPACE) + 
                    repeatSymbol(multiplierLength, HORIZONTAL_LINE)).length()
            - String.valueOf(step.getRemainder()).length();  
        }
        return lastStep.append(repeatSymbol(indent, SPACE))
                .append(lastDivisionStep.getRemainder()).toString();
    }
 
    private String repeatSymbol(int count, String symbol) {
        
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }
}
