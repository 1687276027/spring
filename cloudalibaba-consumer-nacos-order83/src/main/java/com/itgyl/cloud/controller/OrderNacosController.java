package com.itgyl.cloud.controller;

import com.itgyl.cloud.apis.PayFeignSentinelApi;
import com.itgyl.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController
{

    @Resource
    private PayFeignSentinelApi payFeignSentinelApi;

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id)
    {
        String result = restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
        return result+"\t"+"    我是OrderNacosController83调用者。。。。。。";
    }

    @GetMapping(value = "/consumer/pay/nacos/get/{orderNo}")
    public Result getPayByOrderNo(@PathVariable("orderNo") String orderNo)
    {
        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }
}