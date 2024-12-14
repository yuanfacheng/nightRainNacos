package com.admin.rain.model.po;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 订单表
* @TableName oms_order
*/
public class OmsOrder implements Serializable {

    /**
    * 订单id
    */
    @NotNull(message="[订单id]不能为空")
    @ApiModelProperty("订单id")
    private Long id;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long memberId;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long couponId;
    /**
    * 订单编号
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("订单编号")
    @Length(max= 64,message="编码长度不能超过64")
    private String orderSn;
    /**
    * 提交时间
    */
    @ApiModelProperty("提交时间")
    private Date createTime;
    /**
    * 用户帐号
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("用户帐号")
    @Length(max= 64,message="编码长度不能超过64")
    private String memberUsername;
    /**
    * 订单总金额
    */
    @ApiModelProperty("订单总金额")
    private BigDecimal totalAmount;
    /**
    * 应付金额（实际支付金额）
    */
    @ApiModelProperty("应付金额（实际支付金额）")
    private BigDecimal payAmount;
    /**
    * 运费金额
    */
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;
    /**
    * 促销优化金额（促销价、满减、阶梯价）
    */
    @ApiModelProperty("促销优化金额（促销价、满减、阶梯价）")
    private BigDecimal promotionAmount;
    /**
    * 积分抵扣金额
    */
    @ApiModelProperty("积分抵扣金额")
    private BigDecimal integrationAmount;
    /**
    * 优惠券抵扣金额
    */
    @ApiModelProperty("优惠券抵扣金额")
    private BigDecimal couponAmount;
    /**
    * 管理员后台调整订单使用的折扣金额
    */
    @ApiModelProperty("管理员后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;
    /**
    * 支付方式：0->未支付；1->支付宝；2->微信
    */
    @ApiModelProperty("支付方式：0->未支付；1->支付宝；2->微信")
    private Integer payType;
    /**
    * 订单来源：0->PC订单；1->app订单
    */
    @ApiModelProperty("订单来源：0->PC订单；1->app订单")
    private Integer sourceType;
    /**
    * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    */
    @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;
    /**
    * 订单类型：0->正常订单；1->秒杀订单
    */
    @ApiModelProperty("订单类型：0->正常订单；1->秒杀订单")
    private Integer orderType;
    /**
    * 物流公司(配送方式)
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("物流公司(配送方式)")
    @Length(max= 64,message="编码长度不能超过64")
    private String deliveryCompany;
    /**
    * 物流单号
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("物流单号")
    @Length(max= 64,message="编码长度不能超过64")
    private String deliverySn;
    /**
    * 自动确认时间（天）
    */
    @ApiModelProperty("自动确认时间（天）")
    private Integer autoConfirmDay;
    /**
    * 可以获得的积分
    */
    @ApiModelProperty("可以获得的积分")
    private Integer integration;
    /**
    * 可以活动的成长值
    */
    @ApiModelProperty("可以活动的成长值")
    private Integer growth;
    /**
    * 活动信息
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("活动信息")
    @Length(max= 100,message="编码长度不能超过100")
    private String promotionInfo;
    /**
    * 发票类型：0->不开发票；1->电子发票；2->纸质发票
    */
    @ApiModelProperty("发票类型：0->不开发票；1->电子发票；2->纸质发票")
    private Integer billType;
    /**
    * 发票抬头
    */
    @Size(max= 200,message="编码长度不能超过200")
    @ApiModelProperty("发票抬头")
    @Length(max= 200,message="编码长度不能超过200")
    private String billHeader;
    /**
    * 发票内容
    */
    @Size(max= 200,message="编码长度不能超过200")
    @ApiModelProperty("发票内容")
    @Length(max= 200,message="编码长度不能超过200")
    private String billContent;
    /**
    * 收票人电话
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("收票人电话")
    @Length(max= 32,message="编码长度不能超过32")
    private String billReceiverPhone;
    /**
    * 收票人邮箱
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("收票人邮箱")
    @Length(max= 64,message="编码长度不能超过64")
    private String billReceiverEmail;
    /**
    * 收货人姓名
    */
    @NotBlank(message="[收货人姓名]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("收货人姓名")
    @Length(max= 100,message="编码长度不能超过100")
    private String receiverName;
    /**
    * 收货人电话
    */
    @NotBlank(message="[收货人电话]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("收货人电话")
    @Length(max= 32,message="编码长度不能超过32")
    private String receiverPhone;
    /**
    * 收货人邮编
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("收货人邮编")
    @Length(max= 32,message="编码长度不能超过32")
    private String receiverPostCode;
    /**
    * 省份/直辖市
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("省份/直辖市")
    @Length(max= 32,message="编码长度不能超过32")
    private String receiverProvince;
    /**
    * 城市
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("城市")
    @Length(max= 32,message="编码长度不能超过32")
    private String receiverCity;
    /**
    * 区
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("区")
    @Length(max= 32,message="编码长度不能超过32")
    private String receiverRegion;
    /**
    * 详细地址
    */
    @Size(max= 200,message="编码长度不能超过200")
    @ApiModelProperty("详细地址")
    @Length(max= 200,message="编码长度不能超过200")
    private String receiverDetailAddress;
    /**
    * 订单备注
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("订单备注")
    @Length(max= 500,message="编码长度不能超过500")
    private String note;
    /**
    * 确认收货状态：0->未确认；1->已确认
    */
    @ApiModelProperty("确认收货状态：0->未确认；1->已确认")
    private Integer confirmStatus;
    /**
    * 删除状态：0->未删除；1->已删除
    */
    @NotNull(message="[删除状态：0->未删除；1->已删除]不能为空")
    @ApiModelProperty("删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;
    /**
    * 下单时使用的积分
    */
    @ApiModelProperty("下单时使用的积分")
    private Integer useIntegration;
    /**
    * 支付时间
    */
    @ApiModelProperty("支付时间")
    private Date paymentTime;
    /**
    * 发货时间
    */
    @ApiModelProperty("发货时间")
    private Date deliveryTime;
    /**
    * 确认收货时间
    */
    @ApiModelProperty("确认收货时间")
    private Date receiveTime;
    /**
    * 评价时间
    */
    @ApiModelProperty("评价时间")
    private Date commentTime;
    /**
    * 修改时间
    */
    @ApiModelProperty("修改时间")
    private Date modifyTime;

    /**
    * 订单id
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 
    */
    private void setMemberId(Long memberId){
    this.memberId = memberId;
    }

    /**
    * 
    */
    private void setCouponId(Long couponId){
    this.couponId = couponId;
    }

    /**
    * 订单编号
    */
    private void setOrderSn(String orderSn){
    this.orderSn = orderSn;
    }

    /**
    * 提交时间
    */
    private void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 用户帐号
    */
    private void setMemberUsername(String memberUsername){
    this.memberUsername = memberUsername;
    }

    /**
    * 订单总金额
    */
    private void setTotalAmount(BigDecimal totalAmount){
    this.totalAmount = totalAmount;
    }

    /**
    * 应付金额（实际支付金额）
    */
    private void setPayAmount(BigDecimal payAmount){
    this.payAmount = payAmount;
    }

    /**
    * 运费金额
    */
    private void setFreightAmount(BigDecimal freightAmount){
    this.freightAmount = freightAmount;
    }

    /**
    * 促销优化金额（促销价、满减、阶梯价）
    */
    private void setPromotionAmount(BigDecimal promotionAmount){
    this.promotionAmount = promotionAmount;
    }

    /**
    * 积分抵扣金额
    */
    private void setIntegrationAmount(BigDecimal integrationAmount){
    this.integrationAmount = integrationAmount;
    }

    /**
    * 优惠券抵扣金额
    */
    private void setCouponAmount(BigDecimal couponAmount){
    this.couponAmount = couponAmount;
    }

    /**
    * 管理员后台调整订单使用的折扣金额
    */
    private void setDiscountAmount(BigDecimal discountAmount){
    this.discountAmount = discountAmount;
    }

    /**
    * 支付方式：0->未支付；1->支付宝；2->微信
    */
    private void setPayType(Integer payType){
    this.payType = payType;
    }

    /**
    * 订单来源：0->PC订单；1->app订单
    */
    private void setSourceType(Integer sourceType){
    this.sourceType = sourceType;
    }

    /**
    * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    */
    private void setStatus(Integer status){
    this.status = status;
    }

    /**
    * 订单类型：0->正常订单；1->秒杀订单
    */
    private void setOrderType(Integer orderType){
    this.orderType = orderType;
    }

    /**
    * 物流公司(配送方式)
    */
    private void setDeliveryCompany(String deliveryCompany){
    this.deliveryCompany = deliveryCompany;
    }

    /**
    * 物流单号
    */
    private void setDeliverySn(String deliverySn){
    this.deliverySn = deliverySn;
    }

    /**
    * 自动确认时间（天）
    */
    private void setAutoConfirmDay(Integer autoConfirmDay){
    this.autoConfirmDay = autoConfirmDay;
    }

    /**
    * 可以获得的积分
    */
    private void setIntegration(Integer integration){
    this.integration = integration;
    }

    /**
    * 可以活动的成长值
    */
    private void setGrowth(Integer growth){
    this.growth = growth;
    }

    /**
    * 活动信息
    */
    private void setPromotionInfo(String promotionInfo){
    this.promotionInfo = promotionInfo;
    }

    /**
    * 发票类型：0->不开发票；1->电子发票；2->纸质发票
    */
    private void setBillType(Integer billType){
    this.billType = billType;
    }

    /**
    * 发票抬头
    */
    private void setBillHeader(String billHeader){
    this.billHeader = billHeader;
    }

    /**
    * 发票内容
    */
    private void setBillContent(String billContent){
    this.billContent = billContent;
    }

    /**
    * 收票人电话
    */
    private void setBillReceiverPhone(String billReceiverPhone){
    this.billReceiverPhone = billReceiverPhone;
    }

    /**
    * 收票人邮箱
    */
    private void setBillReceiverEmail(String billReceiverEmail){
    this.billReceiverEmail = billReceiverEmail;
    }

    /**
    * 收货人姓名
    */
    private void setReceiverName(String receiverName){
    this.receiverName = receiverName;
    }

    /**
    * 收货人电话
    */
    private void setReceiverPhone(String receiverPhone){
    this.receiverPhone = receiverPhone;
    }

    /**
    * 收货人邮编
    */
    private void setReceiverPostCode(String receiverPostCode){
    this.receiverPostCode = receiverPostCode;
    }

    /**
    * 省份/直辖市
    */
    private void setReceiverProvince(String receiverProvince){
    this.receiverProvince = receiverProvince;
    }

    /**
    * 城市
    */
    private void setReceiverCity(String receiverCity){
    this.receiverCity = receiverCity;
    }

    /**
    * 区
    */
    private void setReceiverRegion(String receiverRegion){
    this.receiverRegion = receiverRegion;
    }

    /**
    * 详细地址
    */
    private void setReceiverDetailAddress(String receiverDetailAddress){
    this.receiverDetailAddress = receiverDetailAddress;
    }

    /**
    * 订单备注
    */
    private void setNote(String note){
    this.note = note;
    }

    /**
    * 确认收货状态：0->未确认；1->已确认
    */
    private void setConfirmStatus(Integer confirmStatus){
    this.confirmStatus = confirmStatus;
    }

    /**
    * 删除状态：0->未删除；1->已删除
    */
    private void setDeleteStatus(Integer deleteStatus){
    this.deleteStatus = deleteStatus;
    }

    /**
    * 下单时使用的积分
    */
    private void setUseIntegration(Integer useIntegration){
    this.useIntegration = useIntegration;
    }

    /**
    * 支付时间
    */
    private void setPaymentTime(Date paymentTime){
    this.paymentTime = paymentTime;
    }

    /**
    * 发货时间
    */
    private void setDeliveryTime(Date deliveryTime){
    this.deliveryTime = deliveryTime;
    }

    /**
    * 确认收货时间
    */
    private void setReceiveTime(Date receiveTime){
    this.receiveTime = receiveTime;
    }

    /**
    * 评价时间
    */
    private void setCommentTime(Date commentTime){
    this.commentTime = commentTime;
    }

    /**
    * 修改时间
    */
    private void setModifyTime(Date modifyTime){
    this.modifyTime = modifyTime;
    }


    /**
    * 订单id
    */
	public Long getId(){
    return this.id;
    }

    /**
    * 
    */
    private Long getMemberId(){
    return this.memberId;
    }

    /**
    * 
    */
    private Long getCouponId(){
    return this.couponId;
    }

    /**
    * 订单编号
    */
    private String getOrderSn(){
    return this.orderSn;
    }

    /**
    * 提交时间
    */
    private Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 用户帐号
    */
    private String getMemberUsername(){
    return this.memberUsername;
    }

    /**
    * 订单总金额
    */
    private BigDecimal getTotalAmount(){
    return this.totalAmount;
    }

    /**
    * 应付金额（实际支付金额）
    */
    private BigDecimal getPayAmount(){
    return this.payAmount;
    }

    /**
    * 运费金额
    */
    private BigDecimal getFreightAmount(){
    return this.freightAmount;
    }

    /**
    * 促销优化金额（促销价、满减、阶梯价）
    */
    private BigDecimal getPromotionAmount(){
    return this.promotionAmount;
    }

    /**
    * 积分抵扣金额
    */
    private BigDecimal getIntegrationAmount(){
    return this.integrationAmount;
    }

    /**
    * 优惠券抵扣金额
    */
    private BigDecimal getCouponAmount(){
    return this.couponAmount;
    }

    /**
    * 管理员后台调整订单使用的折扣金额
    */
    private BigDecimal getDiscountAmount(){
    return this.discountAmount;
    }

    /**
    * 支付方式：0->未支付；1->支付宝；2->微信
    */
    private Integer getPayType(){
    return this.payType;
    }

    /**
    * 订单来源：0->PC订单；1->app订单
    */
    private Integer getSourceType(){
    return this.sourceType;
    }

    /**
    * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    */
    private Integer getStatus(){
    return this.status;
    }

    /**
    * 订单类型：0->正常订单；1->秒杀订单
    */
    private Integer getOrderType(){
    return this.orderType;
    }

    /**
    * 物流公司(配送方式)
    */
    private String getDeliveryCompany(){
    return this.deliveryCompany;
    }

    /**
    * 物流单号
    */
    private String getDeliverySn(){
    return this.deliverySn;
    }

    /**
    * 自动确认时间（天）
    */
    private Integer getAutoConfirmDay(){
    return this.autoConfirmDay;
    }

    /**
    * 可以获得的积分
    */
    private Integer getIntegration(){
    return this.integration;
    }

    /**
    * 可以活动的成长值
    */
    private Integer getGrowth(){
    return this.growth;
    }

    /**
    * 活动信息
    */
    private String getPromotionInfo(){
    return this.promotionInfo;
    }

    /**
    * 发票类型：0->不开发票；1->电子发票；2->纸质发票
    */
    private Integer getBillType(){
    return this.billType;
    }

    /**
    * 发票抬头
    */
    private String getBillHeader(){
    return this.billHeader;
    }

    /**
    * 发票内容
    */
    private String getBillContent(){
    return this.billContent;
    }

    /**
    * 收票人电话
    */
    private String getBillReceiverPhone(){
    return this.billReceiverPhone;
    }

    /**
    * 收票人邮箱
    */
    private String getBillReceiverEmail(){
    return this.billReceiverEmail;
    }

    /**
    * 收货人姓名
    */
    private String getReceiverName(){
    return this.receiverName;
    }

    /**
    * 收货人电话
    */
    private String getReceiverPhone(){
    return this.receiverPhone;
    }

    /**
    * 收货人邮编
    */
    private String getReceiverPostCode(){
    return this.receiverPostCode;
    }

    /**
    * 省份/直辖市
    */
    private String getReceiverProvince(){
    return this.receiverProvince;
    }

    /**
    * 城市
    */
    private String getReceiverCity(){
    return this.receiverCity;
    }

    /**
    * 区
    */
    private String getReceiverRegion(){
    return this.receiverRegion;
    }

    /**
    * 详细地址
    */
    private String getReceiverDetailAddress(){
    return this.receiverDetailAddress;
    }

    /**
    * 订单备注
    */
    private String getNote(){
    return this.note;
    }

    /**
    * 确认收货状态：0->未确认；1->已确认
    */
    private Integer getConfirmStatus(){
    return this.confirmStatus;
    }

    /**
    * 删除状态：0->未删除；1->已删除
    */
    private Integer getDeleteStatus(){
    return this.deleteStatus;
    }

    /**
    * 下单时使用的积分
    */
    private Integer getUseIntegration(){
    return this.useIntegration;
    }

    /**
    * 支付时间
    */
    private Date getPaymentTime(){
    return this.paymentTime;
    }

    /**
    * 发货时间
    */
    private Date getDeliveryTime(){
    return this.deliveryTime;
    }

    /**
    * 确认收货时间
    */
    private Date getReceiveTime(){
    return this.receiveTime;
    }

    /**
    * 评价时间
    */
    private Date getCommentTime(){
    return this.commentTime;
    }

    /**
    * 修改时间
    */
    private Date getModifyTime(){
    return this.modifyTime;
    }

}
