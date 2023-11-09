package main;

import car.Avante;
import car.Sonata;
import phon.SmartPhon;
import phon.TwogPhon;

public class Main {

	public static void main(String[] args) {

		System.out.println("상속============");
		
		Sonata sonata = new Sonata();
		sonata.accelerate();
		System.out.println(sonata.toString());
	
		
		Avante avante = new Avante();
		avante.accelerate();
		
		
		
//		SmartPhon smartPhon = new SmartPhon();
//		smartPhon.CallMesage();
//		smartPhon.SMS();
//		
//		TwogPhon twogPhon = new TwogPhon();
//		twogPhon.CallMesage();
//		twogPhon.SMS();
//		
		
	}

}
