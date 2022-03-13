package ua.com.foxminded.integerdivision.provider;

import ua.com.foxminded.integerdivision.domain.DivisionResult;

public interface DivisionViewProvider {
    String provideView(DivisionResult divisionResult);
}
