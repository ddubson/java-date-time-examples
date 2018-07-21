import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class DateTimeConverterTest {
	@DisplayName("UTC Date to Custom Format Conversion")
	@ParameterizedTest(name = "given UTC date: {0}, it returns custom formatted date {1}")
	@CsvSource({
			"2018-11-30, November 30 2018",
			"1969-01-01, January 01 1969"
	})
	void test(String inputDate, String expectedOutputDate) {
		String inputFormat = "yyyy-MM-dd";
		String outputFormat = "MMMM dd yyyy";

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat).withLocale(Locale.US);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat).withLocale(Locale.US);

		LocalDate transformedDate = LocalDate.from(inputFormatter.parse(inputDate));

		assertThat(transformedDate.format(outputFormatter), equalTo(expectedOutputDate));
	}

	@DisplayName("Current Date/Time in ISO 8601 UTC format")
	@Test
	void test2() {
		Instant instantNow = Instant.now();
		log.info(instantNow.toString());

		log.info(instantNow.atZone(ZoneId.of("America/New_York")).toString());

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("+00:00"));
		log.info(now.toString());

		log.info(ZonedDateTime.now(ZoneId.of("America/New_York")).toString());
	}


}
