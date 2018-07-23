# Java 8+ Date/Time Examples

[![Build Status](https://travis-ci.org/ddubson/java-date-time-examples.svg?branch=master)](https://travis-ci.org/ddubson/java-date-time-examples)

Current Date/Time in UTC

```java
// Path 1
Instant instantNow = Instant.now();

// Path 2
ZonedDateTime now = ZonedDateTime.now();
```

Current Date/Time in 'America/New_York' Timezone:

```java
ZoneId americaNewYork = ZoneId.of("America/New_York");

// Path 1
Instant.now().atZone(americaNewYork);

// Path 2
ZonedDateTime.now().atZone(americaNewYork);
```

## Example 1: UTC Date to Custom Format

```java
String outputFormat = "MMMM dd yyyy";

DateTimeFormatter inputFormatter = DateTimeFormatter.ISO_DATE;
DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat).withLocale(Locale.US);

LocalDate parsedDate = LocalDate.from(inputFormatter.parse(inputDate));
String outputDate = parsedDate.format(outputFormatter);
`````

Full list of Zone IDs: [Java Time Zone Ids](docs/java-time-zone-ids.md)

## Example 2: Custom Date Format to UTC Date

```java
String inputFormat = "MMMM dd, yyyy";

DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat).withLocale(Locale.US);
DateTimeFormatter outputFormatter = DateTimeFormatter.ISO_DATE;

LocalDate parsedDate = LocalDate.from(inputFormatter.parse(inputDate));
String utcDate = parsedDate.format(outputFormatter);
```