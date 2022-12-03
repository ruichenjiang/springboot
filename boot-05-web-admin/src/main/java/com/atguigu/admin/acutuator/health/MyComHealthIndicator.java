package com.atguigu.admin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        Map<String,Object> map = new HashMap<>();
        if(1 == 1) {
            //builder.up();//健康
            builder.status(Status.UP);
            map.put("count",1);
            map.put("ms",100);
        }else{
            //builder.down();
            builder.status(Status.DOWN);
            map.put("err","链接超时");
            map.put("ms",300);
        }
        builder.withDetail("code",100).withDetails(map);


    }
}
