package com.xhc.springcloud.demouser.objwrap.properties;

import com.xhc.springcloud.demouser.objwrap.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuhuanchao on 2018/8/26.
 */
@Component
@ConfigurationProperties(prefix = "workgroup2")
public class WorkGroupProperties2 {

    private String name;

    private User boss;

    private List<String> roles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
