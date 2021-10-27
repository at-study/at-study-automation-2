package at.study.redmine.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import at.study.redmine.allure.asserts.AllureAssert;
import io.qameta.allure.Step;

public class CompareUtils {

    // 20.10.2021 19:16
    private static final Comparator<String> DATE_DESC_COMPARATOR = (s1, s2) -> {
        LocalDateTime d1 = LocalDateTime.parse(s1, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        LocalDateTime d2 = LocalDateTime.parse(s2, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        return d2.compareTo(d1);
    };
    private static final Comparator<String> DATE_ASC_COMPARATOR = DATE_DESC_COMPARATOR.reversed();

    @Step("Проверка сортировки списка дат по убыванию")
    public static void assertListSortedByDateDesc(List<String> dates) {
        List<String> sortedDates = new ArrayList<>(dates);
        sortedDates.sort(DATE_DESC_COMPARATOR);
        AllureAssert.assertEquals(dates, sortedDates);
    }

    @Step("Проверка сортировки списка дат по возрастанию")
    public static void assertListSortedByDateAsc(List<String> dates) {
        List<String> sortedDates = new ArrayList<>(dates);
        sortedDates.sort(DATE_ASC_COMPARATOR);
        AllureAssert.assertEquals(dates, sortedDates);
    }


}
