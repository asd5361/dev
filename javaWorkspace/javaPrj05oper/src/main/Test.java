package main;

public class Test {

	public static void main(String[] args) {
        System.out.println("연산자  ~~~");
        
        System.out.println( false || true );
        System.out.println( true && false );
        System.out.println( !(10!=20 && 10==20) );
        System.out.println(  13*2<26 || 20*3>=50 );
        
        int age = 25;
        
        boolean isAdult = age >=20 ;
        
        System.out.println(age + "살이면, 성인이 맞는지?" + isAdult);
        
        System.out.println("================");
        
        
       byte x = (byte)130;
       System.out.println(x);
        
        
	}

}
