package com.abak.utility;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
@Component
public final class ApplicationSession implements Serializable {
	
	public static ApplicationSession getInstance()
	{
		return ApplicationContextProvider.getApplicationContext().getBean(ApplicationSession.class);
	}
	
	public String getMessage(String code)
	{
		return getMessage(code, code);
	}

	public String getMessage(String code, Object... args)
	{
		return getMessage(code, code, args);
	}

	public String getMessage(String code, String defaultMessage)
	{
		return getMessage(code, defaultMessage, (Object[]) null);
	}

	public String getMessage(String code, String defaultMessage, Object... args)
	{
		return getMessage(code, defaultMessage, LocaleContextHolder.getLocale(), args);
	}

	public String getMessage(String code, String defaultMessage, Locale locale, Object... args)
	{
		return ApplicationContextProvider.getApplicationContext().getMessage(code, args, defaultMessage, locale);
	}

}
