package com.nanjing.gulimall.zhouyimo.controller;

import com.nanjing.common.utils.R;
import com.nanjing.gulimall.zhouyimo.annotation.Log;
import com.nanjing.gulimall.zhouyimo.enums.BusinessType;
import com.nanjing.gulimall.zhouyimo.enums.OperatorType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 日志信息
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-03-08 20:53:04
 */
@RestController
@RequestMapping("log/log")
public class LogController {

    @RequestMapping("/list")
    @Log(title = "查询日志信息", businessType = BusinessType.OTHER, operatorType = OperatorType.MANAGE)
    public R logs(){
        return R.ok();
    }


}
