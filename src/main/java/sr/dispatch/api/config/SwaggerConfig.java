package sr.dispatch.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

/* * * @author Clint Atmosoerodjo #commander *  */

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)

            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET,
                    newArrayList(

                            new ResponseMessageBuilder()
                                    .code(500)
                                    .message("500 message")
                                    .responseModel(new ModelRef("Error"))
                                    .build(),
                            new ResponseMessageBuilder()
                                    .code(403)
                                    .message("Forbidden!")
                                    .build())
                    )
            .select()
            .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();
    }

}