package com.nanjing.gulimall.zhouyimo.manager.factory;

import com.nanjing.gulimall.zhouyimo.entity.SysOperLog;
import com.nanjing.gulimall.zhouyimo.service.ISysOperLogService;
import com.nanjing.gulimall.zhouyimo.utils.SpringUtils;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 * 
 * @author liuhulu
 *
 */
public class AsyncFactory {



    /**
     * 操作日志记录
     * 
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                // 远程查询操作地点
                //operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }


}
