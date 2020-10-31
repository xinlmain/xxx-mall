package com.xxx.mall.component;

import com.xxx.mall.service.OmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 * Created by macro on 2018/9/14.
 */
@Slf4j
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    private final OmsPortalOrderService portalOrderService;

    public CancelOrderReceiver(OmsPortalOrderService portalOrderService) {
        this.portalOrderService = portalOrderService;
    }

    @RabbitHandler
    public void handle(Long orderId){
        log.info("receive delay message orderId:{}",orderId);
        portalOrderService.cancelOrder(orderId);
    }
}
