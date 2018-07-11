package springboot_demo.springcloud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot_demo.springcloud.handler.NettyClient;
import springboot_demo.springcloud.utils.MethodInvokeMeta;
import org.apache.commons.collections.CollectionUtils;

@RestController
public class FristController {

	@Value("${server.port}")
    String port;
	
	
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/netty")
    public String getDoc(){
    	List<Integer> list = new ArrayList<>();
    	NettyClient client = new NettyClient("127.0.0.1", 11111);
    	MethodInvokeMeta data = new MethodInvokeMeta();
    	client.remoteCall(data, 0);
    	return "success";
    }
}
