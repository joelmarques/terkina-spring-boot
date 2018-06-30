package br.com.terkina.base.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	
	public static final Locale BRAZILIAN_LOCALE = new Locale("pt", "BR");
	public static final String BRAZILIAN_PATTERN = "dd/MM/yyyy";
	public static final String PATTERN_YYYY = "yyyy";
	
	public static String formatInFullBrazilianPattern(final Date date) {
		return date == null ? null : DateFormat.getDateInstance(DateFormat.FULL, BRAZILIAN_LOCALE).format(date);
	}
	
	public static Period getPeriod(final Date date) {
		return Period.between(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
	}
	
	public static String calculateAgeInFullBrazilianPattern(final Date dateOfBirth) {
		
		if (dateOfBirth != null) {
		
			Period period = getPeriod(dateOfBirth);
			
			StringBuilder description = new StringBuilder();
			
			if (period.getYears() == 1) {
				description.append(period.getYears() + " ano");
			}
			
			if (period.getYears() > 1) {
				description.append(period.getYears() + " anos");
			}
			
			if (period.getMonths() == 1) {
				if (StringUtils.isNotBlank(description)) {
					description.append(", ");
				}
				
				description.append(period.getMonths() + " mês");
			}
			
			if (period.getMonths() > 1) {
				if (StringUtils.isNotBlank(description)) {
					description.append(", ");
				}
				
				description.append(period.getMonths() + " meses");
			}
			
			if (period.getDays() == 1) {
				if (StringUtils.isNotBlank(description)) {
					description.append(" e ");
				}
				
				description.append(period.getDays() + " dia");
			}
			
			if (period.getDays() > 1) {
				if (StringUtils.isNotBlank(description)) {
					description.append(" e ");
				}
				
				description.append(period.getDays() + " dias");
			}
			
			return description.toString();
		}
		
		return null;
	}
	
	public static boolean isBirthday(final Date dateOfBirth) {
		
		if (dateOfBirth != null) {
			final Calendar cal1 = Calendar.getInstance();
	        cal1.setTime(dateOfBirth);
	        final Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(new Date());			
			return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
		}
		
		return false;
	}

	public static String format(final Date date) {
		
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(BRAZILIAN_PATTERN, BRAZILIAN_LOCALE);
			return formatter.format(date);
		}
		
		return null;
	}
	
	public static String formatYear(final Date date) {
		
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_YYYY, BRAZILIAN_LOCALE);
			return formatter.format(date);
		}
		
		return null;
	}
	
	public static Date parse(final String date) {
		
		if (StringUtils.isNotBlank(date)) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(BRAZILIAN_PATTERN, BRAZILIAN_LOCALE);
				return formatter.parse(date);
			} catch (ParseException e) {}
		}
		
		return null;
	}
	
	public static String calculateAge(final Date dateOfBirth) {
		
		if (dateOfBirth != null) {
			
			Period period = getPeriod(dateOfBirth);
			
			if (period.getYears() == 1) {
				return period.getYears() + " ano";
			}
			
			if (period.getYears() > 1) {
				return period.getYears() + " anos";
			}
			
			if (period.getMonths() == 1) {
				return period.getMonths() + " mês";
			}
			
			if (period.getMonths() > 1) {
				return period.getMonths() + " meses";
			}
			
			if (period.getDays() == 1) {
				return period.getDays() + " dia";
			}
			
			if (period.getDays() > 1) {
				return period.getDays() + " dias";
			}
		}
		
		return null;
	}

}