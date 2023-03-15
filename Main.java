import java.util.Date;
import java.util.TimeZone;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;
import java.time.LocalDate;
import java.util.TimeZone;
// import org.joda.time.DateTime;
// import org.joda.time.DateTimeZone;
// import org.joda.time.ReadableInstant;
// import org.joda.time.format.DateTimeFormat;
// import org.joda.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.Instant;
import java.time.Clock;
import java.time.temporal.ChronoUnit;

class Main {
  // public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String DATE_TIMEZONE = "UTC";
  public static Clock clock;

  public Clock testClock;

  public static void main(String[] args) {
    Main m = new Main();
    Clock implementationClock = m.clock;
    Clock testClock = m.testClock;
    // DateTimeFormatter dtf =
    // DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssX");

    String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
        .withZone(ZoneOffset.UTC);

    Instant instant = ZonedDateTime.now(ZoneOffset.UTC).toInstant();
    // Instant testInstant = LocalDateTime.of(2010, 12, 31, 0, 0, 0,
    // 0).toInstant(ZoneOffset.UTC).format(dtf);
    Instant testInstant = ZonedDateTime.of(2010, 12, 12, 10, 0, 0, 100, ZoneOffset.UTC).toInstant();

    implementationClock = Clock.fixed(instant, ZoneOffset.UTC);
    testClock = Clock.fixed(testInstant, ZoneOffset.UTC);

    Instant timestamp = Instant.now(implementationClock);
    Instant testTimestamp = Instant.now(testClock);

    Instant isodate = Instant.ofEpochMilli(timestamp.toEpochMilli());
    Instant testIsodate = testTimestamp.truncatedTo(ChronoUnit.NANOS);
    String testIsodateString = formatter.format(testTimestamp);
    System.out.println("implementation");
    System.out.println(isodate);
    System.out.println("test");
    System.out.println(testIsodateString);
    // System.out.println(testIsodate);
  }
}