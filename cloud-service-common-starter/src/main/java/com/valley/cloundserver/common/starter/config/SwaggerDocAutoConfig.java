package com.valley.cloundserver.common.starter.config;

import com.valley.cloundserver.common.starter.property.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author valley
 * @version 1.0 2020/1/15
 * @description：swagger文档配置类
 */
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnClass(Docket.class)
@ConditionalOnProperty(prefix = "application.swagger", value = "enable",havingValue = "true")
@Configuration
@EnableSwagger2
public class SwaggerDocAutoConfig {

	@Autowired
	private SwaggerProperties properties;

	@Bean
	public Docket basicApi() {
		return new Docket(DocumentationType.SWAGGER_2).genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("/").select()
				.apis(p -> p.findControllerAnnotation(RestController.class).isPresent()).paths(PathSelectors.any())
				.build().apiInfo(apiInfo(properties.getTitle() + "API"));
	}

	private ApiInfo apiInfo(String title) {
		return new ApiInfoBuilder().title(title).termsOfServiceUrl("/")
				.contact(new Contact(properties.getAuthor(), "", "")).version(properties.getVersion()).build();
	}
}
