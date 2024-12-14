package com.admin.rain.mq.provider;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SendRocketMqProducer {
//	@Value("${rocketmq.send.nameSrv}")
////	@Value("${useLocalCache}")
//	private String nameSrv;
//
//	@Value("${rocketmq.send.topic}")
//	private String topic;
//
//	@Value("${rocketmq.send.producer}")
//	private String producer;


	public void sendMsg() throws MQClientException {

		// 创建生产者，并指定生产者组名
		DefaultMQProducer producer = new DefaultMQProducer("consumer");
		// 指定Namesrv地址，分号分隔
		producer.setNamesrvAddr("localhost:9876");
		// 启动生产者
		producer.start();

		try {
			// 创建消息，指定主题、标签和消息体
			Message msg = new Message("TestTopic" /* Topic */, "TagA" /* Tag */,
					("Hello RocketMQ ").getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
			);
			// 发送消息
			SendResult sendResult = producer.send(msg);
			// 打印发送结果
			System.out.printf("%s%n", sendResult);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 关闭生产者
			producer.shutdown();
		}
	}
}
