package com.admin.rain.mq.provider;

import com.admin.rain.feign.ConsumerClient;
import jdk.nashorn.internal.objects.annotations.Property;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@RefreshScope
public class ProducerController {

//	@Value("${rocketmq.send.nameSrv}")
////	@Value("${useLocalCache}")
//	private String nameSrv;
//
//	@Value("${rocketmq.send.topic}")
//	private String topic;
//
//	@Value("${rocketmq.send.producer}")
//	private String producer;

	@Autowired
	private ConsumerClient consumerClient;


	@RequestMapping("/sendMsg")
	public String sendMsg() throws MQClientException {
		String res = consumerClient.showConsumer();
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
		return res;
	}

}