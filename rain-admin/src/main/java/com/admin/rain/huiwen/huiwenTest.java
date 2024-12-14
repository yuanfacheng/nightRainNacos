package com.admin.rain.huiwen;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: yfc
 * @Date: 2024/11/21 14:07
 */
public class huiwenTest {
	public static void main(String[] args) {
		huiwenTest huiwenTest = new huiwenTest();
		//1.先判断整数的位数，如果是奇数位则继续判断，如果是偶数位返回false
		boolean flag = huiwenTest.isJishu(2364353);

		if (flag) {
			//2.如果是奇数位，判断位数，从位数的中间-1个长度将这个整数一分为二，按位分别放入两个数组中temp1，temp2
		}

	}


	//2.如果是奇数位，判断位数，从位数的中间-1个长度将这个整数一分为二，按位分别放入两个数组中temp1，temp2
	//3.将第二个数组中的数据倒序排列放入一个新数组temp3
	//4.按数组元素下标比较数据是否相等，如果相等则返回ture



	public boolean isJishu(Integer abc) {
		Integer a = abc % 2;
		boolean flag = (a == 0) ? true : false;
		return flag;
	}

	public List<Integer[]> fenArray(Integer abc) {
		ArrayList list = new ArrayList();
		String bigStr = String.valueOf(abc);
		String aStr = bigStr.substring(0, bigStr.length() / 2 - 1);
		String bStr = bigStr.substring(bigStr.length() / 2 - 1,bigStr.length());



		return list;
	}

	//3.垃圾回收
	//4.缓存和数据一致性
	//5.不重复消费
	//6.数据库四大特性
}
