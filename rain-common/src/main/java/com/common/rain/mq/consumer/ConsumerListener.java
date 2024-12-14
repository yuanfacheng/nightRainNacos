package com.common.rain.mq.consumer;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * @author yfc
 * @describe
 * @date 2024/6/23 13:12
 */
@Component
@RocketMQMessageListener(
		topic = "${rain.rocketmq.topic}", consumerGroup = "${rain.rocketmq.group}", nameServer = "${rain.rocketmq.nameserv}",
		selectorExpression = "*",
		messageModel = MessageModel.CLUSTERING)
public class ConsumerListener implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {
	private final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

	@Override
	public void onMessage(MessageExt ext) {
		logger.info("FinProductBusinessListener监听到消息:{}", ext);
		if (ext == null || ext.getBody() == null) {
			logger.error("FinProductBusinessListener的参数为空");
			return;
		}
	}

	/**
	 * 设置当前实例的名称
	 */
	@Override
	public void prepareStart(DefaultMQPushConsumer consumer) {
		consumer.setInstanceName("finProductBusinessListener");
	}
}
