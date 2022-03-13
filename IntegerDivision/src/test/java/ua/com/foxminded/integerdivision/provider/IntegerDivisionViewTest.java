package ua.com.foxminded.integerdivision.provider;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.domain.DivisionResult;
import ua.com.foxminded.integerdivision.domain.DivisionStep;

class IntegerDivisionViewTest {
    
    private final DivisionViewProvider divisionViewProvider = new DivisionViewImpl();

    @Test
    void provideViewShouldReturnResultIfDivionIsGreaterThanDivisor() {
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
                
        String actual = divisionViewProvider.provideView(divisionresult);

        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void provideViewShouldReturnResultIfDivisorContainsZeroes() {
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 10, 100003);

        divisionSteps.add(new DivisionStep(10, 10, 0));

        String expected =
                "_100003|10\n" + 
                " 10    |-----\n" +
                " --    |10000\n" +
                "  0";
                
        String actual = divisionViewProvider.provideView(divisionresult);

        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void provideViewShouldReturnResultIfDivisionEqualsZero() {
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 10, 0);

        divisionSteps.add(new DivisionStep(0, 0, 0));

        String expected =
                "_0|10\n" + 
                " 0|-\n" +
                " -|0\n" +
                " 0";
                
        String actual = divisionViewProvider.provideView(divisionresult);

        assertThat(expected, is(equalTo(actual)));
    }
    
    @Test
    void provideViewShouldReturnResutIfDivionIsSmallerThenDivisor() {
        List<DivisionStep> divisionSteps = new ArrayList<>();
        DivisionResult divisionresult = new DivisionResult(divisionSteps, 320, 110);

        divisionSteps.add(new DivisionStep(110, 110, 0));

        String expected =
                "_110|320\n" + 
                " 110|-\n" +
                " ---|0\n" +
                "   0";
                
        String actual = divisionViewProvider.provideView(divisionresult);

        assertThat(expected, is(equalTo(actual)));
    }
}
