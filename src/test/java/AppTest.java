import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {
    @DisplayName("utcDateToCustomFormat")
    @ParameterizedTest(name = "given UTC date: {0}, it returns custom formatted date {1}")
    @CsvSource({
            "2018-11-30, November 30 2018",
            "1969-01-01, January 01 1969"
    })
    public void test(String inputDate, String expectedOutputDate) {
        String inputFormat = "yyyy-MM-dd";
        String outputFormat = "MMMM dd yyyy";

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat).withLocale(Locale.US);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat).withLocale(Locale.US);

        LocalDate transformedDate = LocalDate.from(inputFormatter.parse(inputDate));

        assertThat(transformedDate.format(outputFormatter), equalTo(expectedOutputDate));
    }
}
