package com.yuansong.tools.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerBean {

	private static final String defaultTitel = "API";
	private static final String defaultDescription = "";
	private static final String defaultVersion = "";
	
	@Autowired
	private ISwaggerConfig swaggerConfig;
	
	@Bean
	public Docket createAdminRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.enable(this.swaggerConfig == null ? false :
				this.swaggerConfig.getEnable() == null ? false : this.swaggerConfig.getEnable())
			.apiInfo(this.apiInfo())
			.select()
			.apis(RequestHandlerSelectors.basePackage(this.swaggerConfig.getBasePackage()))
			.paths(PathSelectors.any())
			.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title(this.swaggerConfig == null ? SwaggerBean.defaultTitel :
				this.swaggerConfig.getTitle() == null ? SwaggerBean.defaultTitel : this.swaggerConfig.getTitle())
			.description(this.swaggerConfig == null ? SwaggerBean.defaultDescription :
				this.swaggerConfig.getDescription() == null ? SwaggerBean.defaultDescription : this.swaggerConfig.getDescription())
			.version(this.swaggerConfig == null ? SwaggerBean.defaultVersion : 
				this.swaggerConfig.getVersion() == null ? SwaggerBean.defaultVersion : this.swaggerConfig.getVersion())
			.build();
	}
	
}
