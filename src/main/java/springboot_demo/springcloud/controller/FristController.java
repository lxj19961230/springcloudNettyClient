package springboot_demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot_demo.springcloud.controller.req.UserInfo;
import springboot_demo.springcloud.handler.NettyClient;
import springboot_demo.springcloud.utils.MethodInvokeMeta;

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
    	NettyClient client = new NettyClient("127.0.0.1", 8090);
    	UserInfo user = new UserInfo(1,"小明","男");
    	MethodInvokeMeta data = new MethodInvokeMeta(user);
    	client.remoteCall(data, 3);
    	return "success";
    }
}
