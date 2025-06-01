package org.testWork;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AssertsForTests {

    @Step("Check that form contains all required labels")
    public void assertLabelsPresent(List<String> actualLabels, List<String> expectedLabels) {
        List<String> missing = expectedLabels.stream()
                .filter(label -> !actualLabels.contains(label))
                .toList();

        Assertions.assertTrue(missing.isEmpty(), "Missing labels: " + missing);
    }

}
