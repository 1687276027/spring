package com.itgyl.cloud.controller;

import com.itgyl.cloud.resp.Result;
import com.itgyl.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return Result.success("扣减账户余额成功！");
    }
}