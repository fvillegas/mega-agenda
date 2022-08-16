package uy.edu.cei.megacalendar.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public interface UserTimezoneTransformerUtil {

    public static LocalDateTime fromEventTimezoneToUserTimezone(
            final String userTimezone,
            final LocalDateTime eventTimezone) {
        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();
        ZoneId userZoneId = TimeZone.getTimeZone(userTimezone).toZoneId();
        return eventTimezone.atZone(zoneId).withZoneSameInstant(userZoneId).toLocalDateTime();
    }

}
