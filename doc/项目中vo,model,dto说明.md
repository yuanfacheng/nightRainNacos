## 关于项目中 vo,model,dto 说明 张晓龙

保存入参的时候 使用的模块下的dto实体类

修改同上.........................
删除同上.........................


## 着重注意查询
关于查询入参是使用的模块下的dto实体类  
返回的实体类 ServerResponseEntity<PageVO<SpuVO>> platformPage(PageDTO pageDTO, SpuPageSearchDTO spuDTO) 
其中PageVO跟PageDTO是com.mall4j.cloud.common.database.vo 包下通用的，
SpuVO是com.mall4j.cloud.api.你的模块名称.vo下的实体类 (Feign)
SpuPageSearchDTO 入参是你开发模块的dto下的实体类

在mapper中返回的resultType实体是com.mall4j.cloud.api.你的模块名称.vo下的实体类
<select id="list" resultType="com.mall4j.cloud.api.product.vo.SpuVO">
<select>


开发模块下的model是跟数据库一样的实体类
......dto是入参用到的实体类
......VO暂时不清楚

查询返回的实体类是com.mall4j.cloud.api.你的模块名称.vo 下的实体类



如果在店铺模块中引用商品的实体类 引用api模块中的vo实体类






