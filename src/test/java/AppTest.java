import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {
    @Test
    public void test() {
        String inputDate = "2018-11-30";
        String expectedOutputDate = "November 30 2018";

        String inputFormat = "yyyy-MM-dd";
        String outputFormat = "MMMM dd yyyy";

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat).withLocale(Locale.US);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat).withLocale(Locale.US);

        LocalDate transformedDate = LocalDate.from(inputFormatter.parse(inputDate));

        assertThat(transformedDate.format(outputFormatter), equalTo(expectedOutputDate));
    }
}
