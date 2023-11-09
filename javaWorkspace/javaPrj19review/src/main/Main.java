package main;

import practice.*;


public class Main {

	public static void main(String[] args) {
		
//		VarTest vt = new VarTest();
//		vt.test();
//		
//		OPeratorTest ot = new OPeratorTest();
//		ot.test();
//		
//		ControlTest ct = new ControlTest();
//		ct.test();
//		
//		ArrayTest at = new ArrayTest();
//		at.test();
		
		MethodTest mt = new MethodTest();
		mt.test();
		mt.test01(777);
		mt.test02(10,20);
		System.out.println(mt.test03());
		System.out.println(mt.test04(10, 20));
	}

}
