package com.xhc.springcloud.demouser;

import com.xhc.springcloud.demouser.objwrap.TestListMapProperties;
import com.xhc.springcloud.demouser.objwrap.WorkGroupProperties;
import com.xhc.springcloud.demouser.objwrap.WorkGroupProperties3;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by xuhuanchao on 2018/8/26.
 */
@Configuration
@EnableConfigurationProperties({WorkGroupProperties3.class})
public class TestConfiguration {

    @Bean
    public WorkGroupProperties getWorkGroup(){
        return new WorkGroupProperties();
    }

    @Bean
    public TestListMapProperties testListMap(){
        return new TestListMapProperties();
    }
}
