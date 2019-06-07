package com.dxc.examples.springbootwebjpathymeleaf;

import java.util.Locale;

import com.dxc.examples.springbootwebjpathymeleaf.util.DateFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Configuration class for Internationalization
 */
@Configuration
public class Internationalization implements WebMvcConfigurer {

	/**
	 * * @return default Locale set by the user
	 */
	@Bean(name = "localeResolver")
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	/**
	 * an interceptor bean that will switch to a new locale based on the value of
	 * the language parameter appended to a request:
	 *
	 * @param registry
	 * @language should be the name of the request param i.e
	 *           localhost:8010/api/get-greeting?language=fr
	 *           <p>
	 *           Note: All requests to the backend needing Internationalization
	 *           should have the "language" request param
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Override
	public void addFormatters(final FormatterRegistry registry) {
		registry.addFormatter(dateFormatter());
	}

	@Bean
	public DateFormatter dateFormatter() {
		return new DateFormatter();
	}

}
