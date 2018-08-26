package com.xhc.springcloud.demouser;

import com.xhc.springcloud.demouser.objwrap.TestListMap;
import com.xhc.springcloud.demouser.objwrap.WorkGroupProperties;
import com.xhc.springcloud.demouser.objwrap.WorkGroupProperties2;
import com.xhc.springcloud.demouser.objwrap.WorkGroupProperties3;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

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
    Duration
    @Bean
    public TestListMap testListMap(){
        return new TestListMap();
    }
}
