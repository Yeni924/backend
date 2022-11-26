//package com.mococo.api.config.web;
//
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.HEAD;
//import static org.springframework.http.HttpMethod.OPTIONS;
//import static org.springframework.http.HttpMethod.POST;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
//import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Optional;
//
//@Configuration
//@RequiredArgsConstructor
//public class WebConfig implements WebMvcConfigurer {
//    private @Autowired Optional<PageableHandlerMethodArgumentResolverCustomizer> pageableResolverCustomizer;
//
//    //@Value("${origin.ip}")
//   // private String origin;
//
//    //TODO
////    @Value("${file.upload.path}")
////    private String uploadPath;
//
//    @Bean
//    public PageableHandlerMethodArgumentResolver pageableResolver() {
//
//        PageableHandlerMethodArgumentResolver pageableResolver = new PageableHandlerMethodArgumentResolver(sortResolver.get());
//        customizePageableResolver(pageableResolver);
//        return pageableResolver;
//    }
//
//    protected void customizePageableResolver(PageableHandlerMethodArgumentResolver pageableResolver) {
//        pageableResolverCustomizer.ifPresent(c -> c.customize(pageableResolver));
//    }
//
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedHeaders("Accept", "Host", "Origin", "Host", "Content-Type", "User-Agent")
////                .allowedMethods(GET.name(), POST.name(), OPTIONS.name(), HEAD.name())
////                .allowedOrigins(origin);
////    }
//
//    //TODO
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/images/**")
////                .addResourceLocations("file://" + uploadPath);
////    }
//
//}
