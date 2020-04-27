package com.peas.cloud.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.annotation.AnnotationUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * RabbitMQ所有队列监听消费者的统一父类
 * Created by linyh on 2017/8/25.
 */
public abstract class AbstractMQListener {
    private static Logger log = LoggerFactory.getLogger(AbstractMQListener.class);


    private static long lastAlarm = 0L; //最后一次告警时间

    private String ruleId;
    private String queueName;
    private int threshold = 5;
    private String receiverName = "6214";
    private String receiverPhone = "13918702240";



    /**
     * 子类初始化时调用该方法
     */
    @PostConstruct
    public void init(){
        // 获取子类中的RabbitListener注解信息
        RabbitListener rl = AnnotationUtils.findAnnotation(getClass(), RabbitListener.class);
        if(rl != null) {
            this.queueName = rl.queues()[0];

        }
    }

    @RabbitHandler
    protected void process(String msg){
        log.info("收到MQ消息："+msg);
        try {
            doProcess(msg);
        }catch (RuntimeException e){
            log.error(queueName + " 发生异常：" + e);
        }
    }



    /**
     * 持久化
     */
    private void persistent(){

    }

    /**
     * 发送短信
     */
    private void sendSms(){
        log.info(queueName + " 队列消费的异常次数超过阀值, 短信发送....");
        Map<String,String> params = new HashMap();
        params.put("name",this.receiverName);
        params.put("queueName",this.queueName);
    }

    protected abstract void doProcess(String msg);
}
