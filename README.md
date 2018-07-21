# Java 8+ Date/Time Examples

[![Build Status](https://travis-ci.org/ddubson/java-date-time-examples.svg?branch=master)](https://travis-ci.org/ddubson/java-date-time-examples)

## Example 1: UTC Date to Custom Format

```java
String inputDate = "2018-11-30";
String expectedOutputDate = "November 30 2018";

String inputFormat = "yyyy-MM-dd";
String outputFormat = "MMMM dd yyyy";

DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat).withLocale(Locale.US);
DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat).withLocale(Locale.US);

LocalDate transformedDate = LocalDate.from(inputFormatter.parse(inputDate));
```