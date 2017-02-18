package sr.dispatch.api.config.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by catmosoerodjo on 2/18/17.
 */
@Configuration
public class UtilConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
