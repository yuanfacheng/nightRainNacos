//package com.admin.rain.old;
//
//import java.util.List;
//import java.util.Optional;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.mall4j.cloud.api.leaf.feign.SegmentFeignClient;
//import com.mall4j.cloud.api.order.dto.OrderItemsDTO;
//import com.mall4j.cloud.api.product.feign.SkuFeignClient;
//import com.mall4j.cloud.api.product.vo.PurchInfoVO;
//import com.mall4j.cloud.api.product.vo.SkuVO;
//import com.mall4j.cloud.common.exception.Mall4cloudException;
//import com.mall4j.cloud.common.response.ServerResponseEntity;
//import com.mall4j.cloud.order.enums.OrderDeliveryEnum;
//import com.mall4j.cloud.order.mapper.OrderItemMapper;
//import com.mall4j.cloud.order.mapper.OrderMapper;
//import com.mall4j.cloud.order.mapper.OrderOutboundMapper;
//import com.mall4j.cloud.order.model.OrderInfo;
//import com.mall4j.cloud.order.model.OrderItem;
//import com.mall4j.cloud.order.model.OrderOutbound;
//import com.mall4j.cloud.order.service.OrderOutboundService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @author yuanfacheng
// * @description 针对表【order_outbound(出库单信息)】的数据库操作Service实现
// * @createDate 2024-12-03 09:53:40
// */
//@Service
//public class OrderOutboundServiceImpl extends ServiceImpl<OrderOutboundMapper, OrderOutbound>
//		implements OrderOutboundService {
//
//	@Autowired
//	private SegmentFeignClient segmentFeignClient;
//
//	@Autowired
//	private OrderMapper orderMapper;
//
//	@Autowired
//	private OrderItemMapper orderItemMapper;
//
//	@Autowired
//	private OrderOutboundMapper orderOutboundMapper;
//
//	@Autowired
//	private SkuFeignClient skuFeignClient;
//
//
//	@Override
//	@Transactional(rollbackFor = Exception.class)
//	public void createOutboundOrder(String orderId) {
//		//判断订单是否是已送达状态
//		OrderItemsDTO orderItemsDTO = new OrderItemsDTO();
//		orderItemsDTO.setOrderId(orderId);
//		Optional.ofNullable(orderMapper.getOrderDelivery(orderItemsDTO)).ifPresent(e -> {
//			//已送达后生成出库单
//			if (OrderDeliveryEnum.YISONGDA.getCode().equals(e.getStatus())) {
//				//查询当前订单是否已经生成出库单
//				LambdaQueryWrapper<OrderOutbound> obdWarpper = new LambdaQueryWrapper<>();
//				obdWarpper.eq(OrderOutbound::getOrderId, orderId);
//				Optional.ofNullable(orderOutboundMapper.selectOne(obdWarpper)).orElseGet(() -> {
//					OrderInfo order = orderMapper.getOrderById(Long.valueOf(orderId));
//					//生成出库单id
//					ServerResponseEntity<Long> segmentIdResponse = segmentFeignClient.getSegmentId(OrderOutbound.DISTRIBUTED_ID_KEY);
//					if (!segmentIdResponse.isSuccess()) {
//						throw new Mall4cloudException("生成出库单id失败");
//					}
//					List<OrderItem> orderItem = orderItemMapper.listOrderItemsByOrderId(Long.valueOf(orderId));
//					orderItem.stream().forEach(oderItem->{
//						ServerResponseEntity<PurchInfoVO> purchInfo = skuFeignClient.getSkuPurchInfoById(oderItem.getOrderId());
//						OrderOutbound orderOutbound = new OrderOutbound();
//						orderOutbound.setOutboundId(segmentIdResponse.getData());
//						orderOutbound.setOrderThreeid(order.getOrderThreeid());
//						orderOutbound.setShopId(order.getShopId());
//						orderOutbound.setUnit("");
//						orderOutbound.setNum(1);
//						orderOutbound.setOrderSource(order.getOrderSource());
//						orderOutbound.setStatus(0);
//						orderOutbound.setOrderId(Long.valueOf(orderId));
//						orderOutbound.setPartyCode("");
//						orderOutbound.setShopId(order.getShopId());
//						orderOutbound.setShopIdMember(order.getShopId());
//						orderOutbound.setDefeatReason("");
//						if (purchInfo.getData()!=null){
//							orderOutbound.setPurchSkuId("");
//							orderOutbound.setPurchSkuName("");
//							orderOutbound.setPurchSkuCode("");
//							orderOutbound.setPurchUnit("");
//							orderOutbound.setPurchUnitId("");
//						}
//						orderOutbound.setPushFlag(0);
//						orderOutbound.setCancelPushType(0);
//						this.save(orderOutbound);
//					});
//					skuFeignClient.getSkuPurchInfoById();
//					OrderOutbound orderOutbound = new OrderOutbound();
//					orderOutbound.setOutboundId(segmentIdResponse.getData());
//					orderOutbound.setOrderThreeid(order.getOrderThreeid());
//					orderOutbound.setShopId(order.getShopId());
//					orderOutbound.setUnit("");
//					orderOutbound.setNum(1);
//					orderOutbound.setOrderSource(order.getOrderSource());
//					orderOutbound.setStatus(0);
//					orderOutbound.setOrderId(Long.valueOf(orderId));
//					orderOutbound.setPartyCode("");
//					orderOutbound.setShopId(order.getShopId());
//					orderOutbound.setShopIdMember(order.getShopId());
//					orderOutbound.setDefeatReason("");
//					orderOutbound.setPurchSkuId("");
//					orderOutbound.setPurchSkuName("");
//					orderOutbound.setPurchSkuCode("");
//					orderOutbound.setPurchUnit("");
//					orderOutbound.setPurchUnitId("");
//					orderOutbound.setPushFlag(0);
//					orderOutbound.setCancelPushType(0);
//					this.save(orderOutbound);
//					return orderOutbound;
//				});
//			}
//		});
//	}
//}
//
//
//
//
