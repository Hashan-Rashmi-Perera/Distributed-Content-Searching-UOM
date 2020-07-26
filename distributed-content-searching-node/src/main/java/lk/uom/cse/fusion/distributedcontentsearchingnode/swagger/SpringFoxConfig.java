package lk.uom.cse.fusion.distributedcontentsearchingnode.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

  @Bean
  public Docket Docket() {

    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(
            RequestHandlerSelectors.basePackage(
                "lk.uom.cse.fusion.distributedcontentsearchingnode.controllers"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfoDetails());
  }

  private ApiInfo apiInfoDetails() {

    return new ApiInfo(
        "Node",
        "This api handles the operations of node",
        "1.0",
        "",
        null,
        null,
        null,
        Collections.emptyList());
  }
}
