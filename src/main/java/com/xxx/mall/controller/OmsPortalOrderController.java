package com.xxx.mall.controller;

import com.xxx.mall.dto.OrderParam;
import com.xxx.mall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单管理Controller
 * Created by macro on 2018/8/30.
 */
@Controller
@Api(value = "OmsPortalOrderController", tags = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    private final OmsPortalOrderService portalOrderService;

    public OmsPortalOrderController(OmsPortalOrderService portalOrderService) {
        this.portalOrderService = portalOrderService;
    }

    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }
}
