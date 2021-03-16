package com.xt.rabbitmq;

import cn.hutool.core.util.StrUtil;
import com.xt.dto.Email;
import com.xt.utils.BeanUtils;
import com.xt.utils.LogUtils;
import com.xt.utils.MailUtils;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * @ClassName: EmailConsumer
 * @Description: 邮件任务消费者
 * @author: 莫提
 * @date 2020/10/9 16:08
 * @Version: 1.0
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "email",durable = "true",autoDelete = "true"))
public class EmailConsumer {

    private Logger logger = LogUtils.getInstance(EmailConsumer.class);

    @Autowired
    protected JavaMailSenderImpl mailSender;

    protected MailUtils mailUtils;

    /**
     * 消费消息：发送回复邮件
     */
    @RabbitHandler
    public void sendEmail(String message){
        if (!StrUtil.isEmpty(message)){
            Email email = BeanUtils.stringToBean(message, Email.class);
            logger.warn("【RabbitMq】发送邮箱的消息，email："+email);
            // 发送回复邮件
            mailUtils = new MailUtils(mailSender);
            mailUtils.sendReplyEmail(email.getTitle(),email.getContent(),email.getUrl(),email.getTo());
            logger.warn("【RabbitMq】消费成功");
        }
    }
}
