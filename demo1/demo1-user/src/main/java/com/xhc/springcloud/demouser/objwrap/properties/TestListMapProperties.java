package com.xhc.springcloud.demouser.objwrap.properties;

import com.xhc.springcloud.demouser.objwrap.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhuanchao on 2018/8/26.
 */
@ConfigurationProperties("test-list-map")
public class TestListMapProperties {

    private List<User> list = new ArrayList<>();

    private Map<String, User> map = new HashMap<>();



    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}
