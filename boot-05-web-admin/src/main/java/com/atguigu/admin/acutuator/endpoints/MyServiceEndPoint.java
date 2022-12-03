package com.atguigu.admin.acutuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id="myService")
public class MyServiceEndPoint {

    @ReadOperation
    public Map getDocketInfo(){
        return Collections.singletonMap("dockerInfo","docker start");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stoped");
    }
}
