package com.common.rain.stream;//package com.macro.mall.demo.stream;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @Description:
// * @Author: yfc
// * @Date: 2024/7/4 10:03
// */
//public class StreamTest {
//	public void  test(String[] args) {
//		MyObject obj1 = new MyObject();
//		List<MyObject> list1 = Arrays.asList(new MyObject(1, "obj1"), new MyObject(2, "obj2"));
//		List<MyObject> list2 = Arrays.asList(new MyObject(1, "obj3"), new MyObject(3, "obj4"));
//		// 使用Stream API将两个列表根据id合并
//		List<MyObject> combinedList = list1.stream()
//				.collect(Collectors.groupingBy(MyObject::getId))
//				.values()
//				.stream()
//				.flatMap(List::stream)
//				.distinct() // 如果不想有重复，可以添加这行
//				.collect(Collectors.toList());
//		System.out.println(combinedList);
//	}
//}
//
