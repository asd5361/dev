package main;

import car.Avante;
import car.Car;
import car.Lcid;
import car.Sonata;

public class Main {

	public static void main(String[] args) {

		System.out.println("추상화===========");
		
//		Avante avante = new Avante();
//		Sonata sonata= new Sonata();
//		Lcid lcid = new Lcid();
		
//		sonata.setPrice(1000000);
//		sonata.setSpeed(300);
//		sonata.setColor("black");
		
		int n = 5;
		Car[] sonataArr = new Car[n];
		for(int i=0; i<sonataArr.length; i++) {
			sonataArr[i] = new Sonata();
			System.out.println(sonataArr[i]);
		}
		
//		System.out.println(avante);

//		System.out.println(sonata.getPrice());
//		System.out.println(sonata.getSpeed());
//		System.out.println(sonata.getColor());
//		
//		System.out.println(sonata);
//		sonata.go();
//		avante.go();
//		lcid.go();
		
	}

}
