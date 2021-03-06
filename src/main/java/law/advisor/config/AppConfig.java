package law.advisor.config;

import law.advisor.service.MessageResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    @Autowired
    private MessageResourceService messageResourceService;


    private static final String UTF8 = "UTF-8";

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine((ISpringTemplateEngine) templateEngine());
        resolver.setCharacterEncoding(UTF8);
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setCache(false);
        return resolver;
    }

    private TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();

        Set<IDialect> dialects = new HashSet<>();
        dialects.add(new SpringStandardDialect());


        engine.setTemplateResolver(templateResolver());
        engine.setMessageSource(getMessageSource());

        engine.setAdditionalDialects(dialects);
        return engine;
    }

    @Bean(name = "messageSource")
    public DatabaseDrivenMessageSource getMessageSource() {
        DatabaseDrivenMessageSource resource = new DatabaseDrivenMessageSource(messageResourceService);
        ReloadableResourceBundleMessageSource databaseDrivenMessageSourceProperties = new ReloadableResourceBundleMessageSource();
        databaseDrivenMessageSourceProperties.setBasename("classpath:/locales/messages");
        databaseDrivenMessageSourceProperties.setDefaultEncoding("UTF-8");
        databaseDrivenMessageSourceProperties.setCacheSeconds(0);
        databaseDrivenMessageSourceProperties.setFallbackToSystemLocale(false);
        resource.setParentMessageSource(databaseDrivenMessageSourceProperties);
        return resource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Bean(name = "localeResolver")
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        Locale defaultLocale = new Locale("ru");
        localeResolver.setDefaultLocale(defaultLocale);
        return localeResolver;
    }

    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/resources/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding(UTF8);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false);
        return resolver;
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver createMultipartResolver() {
        return new StandardServletMultipartResolver();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
//        registry.addResourceHandler("/assets/**").addResourceLocations("/static/assets/").setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
//        registry.addResourceHandler("/javascripts/**").addResourceLocations("/static/assets/javascripts/").setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
//        registry.addResourceHandler("/ajax/**").addResourceLocations("/static/assets/ajax/").setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
//        registry.addResourceHandler("/vendor/**").addResourceLocations("/static/assets/vendor/").setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
//        registry.addResourceHandler("/stylesheets/**").addResourceLocations("/static/assets/stylesheets/").setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
//    }



}
