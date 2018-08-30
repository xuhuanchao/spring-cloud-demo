package com.xhc.springcloud.demouser;

import com.xhc.springcloud.demouser.objwrap.entity.User;
import com.xhc.springcloud.demouser.objwrap.properties.TestListMapProperties;
import com.xhc.springcloud.demouser.objwrap.properties.WorkGroupProperties;
import com.xhc.springcloud.demouser.objwrap.properties.WorkGroupProperties3;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Created by xuhuanchao on 2018/8/26.
 */
@Configuration
@EnableConfigurationProperties({WorkGroupProperties3.class})
@PropertySource(value= "classpath:config/1.properties", encoding = "utf-8")
public class TestConfiguration {

    @Bean
    public WorkGroupProperties getWorkGroup(){
        return new WorkGroupProperties();
    }

    @Bean
    public TestListMapProperties testListMap(){
        return new TestListMapProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "user2")
    public User user2(){
        return new User();
    }
}
