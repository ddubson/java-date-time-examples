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

public class DateTimeConverterTest {
	@DisplayName("UTC Date to Custom Format Conversion")
	@ParameterizedTest(name = "given UTC date: \"{0}\", it returns custom formatted date \"{1}\"")
	@CsvSource({
			"2018-11-30, November 30 2018",
			"1969-01-01, January 01 1969",
			"2015-03-20, March 20 2015",
			"1999-04-12, April 12 1999"
	})
	void test(String inputDate, String expectedOutputDate) {
		String outputFormat = "MMMM dd yyyy";

		DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat).withLocale(Locale.US);

		LocalDate parsedDate = LocalDate.from(inputFormatter.parse(inputDate));
		String outputDate = parsedDate.format(outputFormatter);

		assertThat(outputDate, equalTo(expectedOutputDate));
	}

	@DisplayName("Custom Date Format to UTC Date conversion")
	@ParameterizedTest(name = "given custom date: \"{0}\", it returns UTC date \"{1}\"")
	@CsvSource({
			"'August 29, 2018', 2018-08-29",
			"'September 02, 1984', 1984-09-02",
			"'March 15, 1873', 1873-03-15",
			"'January 01, 1800', 1800-01-01",
	})
	void test2(String inputDate, String expectedOutputDate) {
		String inputFormat = "MMMM dd, yyyy";

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat).withLocale(Locale.US);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ISO_DATE;

		LocalDate parsedDate = LocalDate.from(inputFormatter.parse(inputDate));
		String utcDate = parsedDate.format(outputFormatter);

		assertThat(utcDate, equalTo(expectedOutputDate));
	}

	@DisplayName("Current Date/Time in ISO 8601 UTC format")
	@Test
	void test3() {
		Instant instantNow = Instant.now();
		print(instantNow.toString());

		print(instantNow.atZone(ZoneId.of("America/New_York")).toString());

		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("+00:00"));
		print(now.toString());

		print(ZonedDateTime.now(ZoneId.of("America/New_York")).toString());
	}

	private void print(String message) {
		System.out.println(message);
	}
}
