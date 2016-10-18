package com.example.common;

import javax.xml.bind.DatatypeConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DateTimeUtility {

    private final Logger log = LoggerFactory.getLogger(DateTimeUtility.class);

    public static final DateTimeUtility INSTANCE = new DateTimeUtility();

    public static final TimeZone NO_TIMEZONE = TimeZone.getTimeZone("Europe/Oslo");
    
    public Date retrieveLocalDateTime(String country) {
        return retrieveLocalDateTimeCalendar(country).getTime();
    }

    public String retrieveLocalDateTimeAsString(String country) {
        return DatatypeConverter.printDateTime(retrieveLocalDateTimeCalendar(country));
    }

    public String retrieveLocalDateAsString(String country) {
        return DatatypeConverter.printDate(retrieveLocalDateTimeCalendar(country));
    }

    public int retrieveLocalDateTimeYear(String country) {
        Calendar now = retrieveLocalDateTimeCalendar(country);
        return now.get(Calendar.YEAR);
    }

    public Calendar retrieveLocalDateTimeCalendar(String country) {
        TimeZone timeZone = findTimeZone(country);

        Calendar calendar = Calendar.getInstance(timeZone);

        log.debug("Local time in " + country + " is "
                + format(calendar.getTime(), timeZone) + " in time zone "
                + timeZone.getDisplayName(false, TimeZone.LONG, Locale.US)
                + "(" + timeZone.getDisplayName(false, TimeZone.SHORT)
                + ") " + (timeZone.inDaylightTime(calendar.getTime())
                ? "(summer time)" : "(winter time)"));
        return calendar;
    }

    public Boolean isInTimeFrame(Date date, String dayOfWeekClassifier,
            String startTime, String endTime, String country) {
        try {
            Calendar checkMe = Calendar.getInstance();
            checkMe.setTime(date);
            TimeZone timeZone = findTimeZone(country);
            int year = checkMe.get(Calendar.YEAR);
            int month = checkMe.get(Calendar.MONTH);
            int day = checkMe.get(Calendar.DAY_OF_MONTH);

            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

            Calendar start = Calendar.getInstance();
            start.setTime(format.parse(startTime));
            start.set(Calendar.YEAR, year);
            start.set(Calendar.MONTH, month);
            start.set(Calendar.DAY_OF_MONTH, day);
            start.setTimeZone(timeZone);

            Calendar end = Calendar.getInstance();
            end.setTime(format.parse(endTime));
            end.set(Calendar.YEAR, year);
            end.set(Calendar.MONTH, month);
            end.set(Calendar.DAY_OF_MONTH, day);
            end.setTimeZone(timeZone);

            boolean isPastMidnight = false;

            if (end.before(start)) {
                isPastMidnight = checkMe.before(end);

                if (isPastMidnight) {
                    start.add(Calendar.DATE, -1);
                } else {
                    end.add(Calendar.DATE, 1);
                }
            }

            log.debug("Checking if " + format(checkMe.getTime(), timeZone)
                    + " is a " + dayOfWeekClassifier
                    + (isPastMidnight ? " (past midnight)" : "")
                    + " between start time "
                    + format(start.getTime(), timeZone) + " and end time "
                    + format(end.getTime(), timeZone));

            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);

            log.debug("Time frame control: After start: "
                    + checkMe.after(start) + ", Before end: "
                    + checkMe.before(end) + ", Is day of week classifier: "
                    + isDayOfWeek(dayOfWeekClassifier, dayOfWeek, true));

            return checkMe.after(start) && checkMe.before(end)
                    && isDayOfWeek(dayOfWeekClassifier, dayOfWeek, false);
        } catch (ParseException e) {
            log.warn("Failure when detecting if date is in time frame", e);
            return Boolean.TRUE;
        }
    }

    public String convertDateTimeString(String dateTimeString,
            String inPattern, String outPattern)
            throws ParseException {
        DateFormat inFormat = new SimpleDateFormat(inPattern);
        DateFormat outFormat = new SimpleDateFormat(outPattern);
        return outFormat.format(inFormat.parse(dateTimeString));
    }

    public int calculateDiff(Calendar first, Calendar last, CalendarDiffUnit unit) {
        switch (unit) {
            case YEAR:
                int age = last.get(Calendar.YEAR) - first.get(Calendar.YEAR);

                if (age > 0 && (last.get(Calendar.MONTH) < first.get(Calendar.MONTH)
                        || (last.get(Calendar.MONTH) == first.get(Calendar.MONTH) && last.get(Calendar.DAY_OF_MONTH) < first.get(Calendar.DAY_OF_MONTH)))) {
                    age--;
                }
                if (age < 0 && (last.get(Calendar.MONTH) > first.get(Calendar.MONTH)
                        || (last.get(Calendar.MONTH) == first.get(Calendar.MONTH) && last.get(Calendar.DAY_OF_MONTH) > first.get(Calendar.DAY_OF_MONTH)))) {
                    age++;
                }
                return age;
            case MONTH:
                int years = last.get(Calendar.YEAR) - first.get(Calendar.YEAR);
                age = years * 12;

                age = age + last.get(Calendar.MONTH) - first.get(Calendar.MONTH);
                if (age > 0 && last.get(Calendar.DAY_OF_MONTH) < first.get(Calendar.DAY_OF_MONTH)) {
                    age--;
                } else if (age < 0 && last.get(Calendar.DAY_OF_MONTH) > first.get(Calendar.DAY_OF_MONTH)) {
                    age++;
                }
                return age;
            case WEEK:
                years = last.get(Calendar.YEAR) - first.get(Calendar.YEAR);
                age = years * 365;
                age = (age + last.get(Calendar.DAY_OF_YEAR) - first.get(Calendar.DAY_OF_YEAR)) / 7;
                return age;
            case DAY:
                years = last.get(Calendar.YEAR) - first.get(Calendar.YEAR);
                age = years * 365;
                age = age + last.get(Calendar.DAY_OF_YEAR) - first.get(Calendar.DAY_OF_YEAR);
                //we count the current day
                if (age >= 0) {
                    age++;
                } else if (age < 0) {
                    age--;
                }
                return age;
            case HOUR:
                // milliseconds in a hour = 60*60*1000
                age = Math.round((last.getTimeInMillis() - first.getTimeInMillis()) / 3600000);
                return age;
            case MINUTE:
                // milliseconds in a minute = 60*1000
                age = Math.round((last.getTimeInMillis() - first.getTimeInMillis()) / 60000);
                return age;
            case YEAR_FROM_AGE:
                age = last.get(Calendar.YEAR) - first.get(Calendar.YEAR);
                return age;
            default:
                return 0;
        }
    }

    public Date addToDate(Date date, int amount, DateUnit unit, String country) {
        Calendar input = retrieveLocalDateTimeCalendar(country);
        input.add(unit.getCalendarUnit(), amount);
        return input.getTime();
    }

    public enum CalendarDiffUnit {

        YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, YEAR_FROM_AGE;
    }

    @XmlType(name = "DateUnit", namespace = "http://webshop.no.ifint.biz/common/base/info")
    @XmlEnum
    public enum DateUnit {
        
        @XmlEnumValue("Year")
        YEAR(Calendar.YEAR), 
        @XmlEnumValue("Month")
        MONTH(Calendar.MONTH), 
        @XmlEnumValue("Week")
        WEEK(Calendar.WEEK_OF_YEAR), 
        @XmlEnumValue("Day")
        DAY(Calendar.DAY_OF_YEAR);

        private final int calendarUnit;

        private DateUnit(int calendarUnit) {
            this.calendarUnit = calendarUnit;
        }

        public int getCalendarUnit() {
            return calendarUnit;
        }
    }

    private boolean isDayOfWeek(String classifier, int dayOfWeek,
            boolean debugging) {
        if ("sunday".equals(classifier)) {
            log.debug("Checking day of week for sunday: " + dayOfWeek
                    + " == " + Calendar.SUNDAY);
            return dayOfWeek == Calendar.SUNDAY;
        } else if ("saturday".equals(classifier)) {
            log.debug("Checking day of week for saturday: " + dayOfWeek
                    + " == " + Calendar.SATURDAY);
            return dayOfWeek == Calendar.SATURDAY;
        } else {
            log.debug("Checking day of week for weekday: " + dayOfWeek
                    + " == [" + Calendar.MONDAY + ", " + Calendar.TUESDAY
                    + ", " + Calendar.WEDNESDAY + ", " + Calendar.THURSDAY
                    + ", " + Calendar.FRIDAY + "]");
            return dayOfWeek == Calendar.MONDAY
                    || dayOfWeek == Calendar.TUESDAY
                    || dayOfWeek == Calendar.WEDNESDAY
                    || dayOfWeek == Calendar.THURSDAY
                    || dayOfWeek == Calendar.FRIDAY;
        }
    }

    private String format(Date date, TimeZone timeZone) {
        SimpleDateFormat logFormat = new SimpleDateFormat(
                "E dd.MM.yyyy HH:mm.ss '(i tidssone:' Z ')'");
        logFormat.setTimeZone(timeZone);
        return logFormat.format(date);
    }

    public String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat logFormat = new SimpleDateFormat(
                    "yyyy-MM-dd");
            logFormat.setTimeZone(TimeZone.getTimeZone("Europe/Oslo"));
            return logFormat.format(date);
        }
        return null;
    }

    public String formatQuoteDate(Date date) {
        if (date != null) {
            SimpleDateFormat logFormat = new SimpleDateFormat(
                    "dd.MM.yyyy");
            logFormat.setTimeZone(TimeZone.getTimeZone("Europe/Oslo"));
            return logFormat.format(date);
        }
        return null;
    }

    protected TimeZone findTimeZone(String country) {
        TimeZone timeZone = (country.equalsIgnoreCase("FI") == true) ? TimeZone
                .getTimeZone("GMT+2") : NO_TIMEZONE;
        return timeZone;
    }

    public XMLGregorianCalendar getXMLGregorianCalendar(String country) {
        Calendar localCalendar = this.retrieveLocalDateTimeCalendar(country);
        GregorianCalendar gc = (GregorianCalendar) localCalendar;
        XMLGregorianCalendar currServTime;
        try {
            currServTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (Exception e) {
            log.warn("Failure getting DateTimeUtility.XMLGregorianCalendar. Sending null in return", e);
            currServTime = null;
        }
        return currServTime;
    }
    
    public XMLGregorianCalendar getXMLGregorianCalendarOnlyDate(String country) {
        return calendarToXMLGregorianCalendarWithOnlyDate(retrieveLocalDateTimeCalendar(country));
    }

    /**
     *
     *
     *
     * @param date_yyyy_MM_dd set to yyyy-MM-dd and your date will come truth..
     * @return
     * @throws ParseException
     * @throws DatatypeConfigurationException
     */
    public XMLGregorianCalendar stringToXMLGregorianCalendar(String date_yyyy_MM_dd) {
        XMLGregorianCalendar result = null;
        Date date;
        SimpleDateFormat simpleDateFormat;
        GregorianCalendar gregorianCalendar;
        try {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormat.parse(date_yyyy_MM_dd);
            gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
            gregorianCalendar.setTime(date);
            result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
    
    public XMLGregorianCalendar stringToXMLGregorianCalendarOnlyDate(String date_yyyy_MM_dd) {
        try {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            final Date date = dateFormat.parse(date_yyyy_MM_dd);
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendarToXMLGregorianCalendarWithOnlyDate(calendar);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public XMLGregorianCalendar dateToXMLGregorianCalendar(Date date, String country) {
        Calendar calendar = retrieveLocalDateTimeCalendar(country);
        calendar.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)calendar);
        } catch (DatatypeConfigurationException e) {
            log.warn("Failure getting DateTimeUtility.XMLGregorianCalendar. Sending null in return", e);
            return null;
        }
    }
    
    public XMLGregorianCalendar calendarToXMLGregorianCalendarWithOnlyDate(Calendar calendar) {
        XMLGregorianCalendar xmlCalendar;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            xmlCalendar.setYear(calendar.get(Calendar.YEAR));
            xmlCalendar.setMonth(calendar.get(Calendar.MONTH) + 1);
            xmlCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            log.warn("Failure getting DateTimeUtility.XMLGregorianCalendar. Sending null in return", e);
            xmlCalendar = null;
        }
        return xmlCalendar;
    }

    public Date retrieveLocalDate(String country) {
        return retrieveLocalDateTime(country);
    }

    public Integer calculateDiffFromNowInDays(Date date) {
        return calculateDiffInDays(retrieveLocalDate("NO"), date);
    }

    public Integer calculateDiffFromNowInMinutes(Date date) {
        return calculateDiff(date, retrieveLocalDate("NO"), CalendarDiffUnit.MINUTE);
    }

    private Integer calculateDiff(Date first, Date last, CalendarDiffUnit timeUnit) {
        Calendar firstCalendar = retrieveLocalDateTimeCalendar("NO");
        firstCalendar.setTime(first);
        Calendar lastCalendar = retrieveLocalDateTimeCalendar("NO");
        lastCalendar.setTime(last);
        return calculateDiff(firstCalendar, lastCalendar, timeUnit);
    }

    public Integer calculateDiffInDays(Date first, Date last) {
        return calculateDiff(first, last, CalendarDiffUnit.DAY);
    }
    
    public boolean isSameDay(Date first, Date second) {
        if (first != null && second != null) {
            Calendar firstCalendar = Calendar.getInstance();
            firstCalendar.setTime(first);
            Calendar secondCalendar = Calendar.getInstance();
            secondCalendar.setTime(second);

            return firstCalendar.get(Calendar.YEAR) == secondCalendar.get(Calendar.YEAR) &&
                    firstCalendar.get(Calendar.MONTH) == secondCalendar.get(Calendar.MONTH) &&
                    firstCalendar.get(Calendar.DAY_OF_MONTH) == secondCalendar.get(Calendar.DAY_OF_MONTH);
        }
        return false;
    }
    
    public boolean beforeDay(Date first, Date second) {
        if (!isSameDay(first, second)) {
            if (first != null && second != null) {
                Calendar firstCalendar = Calendar.getInstance();
                firstCalendar.setTime(first);
                Calendar secondCalendar = Calendar.getInstance();
                secondCalendar.setTime(second);

                return firstCalendar.before(secondCalendar);
            }
        }
        return false;
    }
    
    public boolean afterDay(Date first, Date second) {
        if (!isSameDay(first, second)) {
            if (first != null && second != null) {
                Calendar firstCalendar = Calendar.getInstance();
                firstCalendar.setTime(first);
                Calendar secondCalendar = Calendar.getInstance();
                secondCalendar.setTime(second);

                return firstCalendar.after(secondCalendar);
            }
        }
        return false;
    }
    
    public Calendar clearTimeOfDay(Calendar clearMe) {
        clearMe.set(Calendar.HOUR_OF_DAY, 0);
        clearMe.set(Calendar.MINUTE, 0);
        clearMe.set(Calendar.SECOND, 0);
        clearMe.set(Calendar.MILLISECOND, 0);
        
        return clearMe;
    }
    
    public int calculateMaxPossibleAge(int birthYear, String country) {
        return retrieveLocalDateTimeYear(country) - birthYear;
    }
    
    public int calculateMinPossibleAge(int birthYear, String country) {
        return calculateMaxPossibleAge(birthYear, country) - 1;
    }
    
    public Date calculatePastDate(int yearsAgo, int monthsAgo, int daysAgo, String country) {
        Calendar then = retrieveLocalDateTimeCalendar(country);
        then.add(Calendar.YEAR, -yearsAgo);
        then.add(Calendar.MONTH, -monthsAgo);
        then.add(Calendar.DAY_OF_MONTH, -daysAgo);
        
        return then.getTime();
    }
}
