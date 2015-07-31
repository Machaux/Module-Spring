package com.bankonet;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@EnableWebMvc
@ComponentScan("com.bankonet.spring")
public class BankonetAppWebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver iRVR = new InternalResourceViewResolver();
		iRVR.setPrefix("/WEB-INF/views/");
		iRVR.setSuffix(".jsp");
		return iRVR;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
	public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource rRBM = new ReloadableResourceBundleMessageSource();
		rRBM.setBasename("classpath:messages");
		rRBM.setDefaultEncoding("ISO-8859-1");
		return rRBM;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lCI = new LocaleChangeInterceptor();
		lCI.setParamName("language");		
		return lCI;
	}

	@Bean
	public CookieLocaleResolver cookieLocaleResolver () {
		CookieLocaleResolver cLR = new CookieLocaleResolver();
		cLR.setDefaultLocale(new Locale("fr"));
		
		return cLR;
	}

//	<mvc:interceptors>
//		<beans:bean id="localeChangeInterceptor" class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
//			<beans:property name="paramName" value="language"></beans:property>
//		</beans:bean>
//	</mvc:interceptors>

	
}
