package com.hgy.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hgy.springcloud.entities.CommonResult;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/21 17:50
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }
}
