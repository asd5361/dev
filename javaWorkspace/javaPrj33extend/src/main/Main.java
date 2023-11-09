package main;

import java.nio.file.spi.FileSystemProvider;

import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;
import mob.Turtle;

public class Main {

	public static void main(String[] args) {

		System.out.println("상속======================");
		
		Pokemon pokemon = new Pokemon();
		
		pokemon.setName("파이리");
		pokemon.setHp(100);
		pokemon.setAtk(10);
		pokemon.setDef(5);
		
		
//		System.out.println(pokemon.toString());
		
		Pikachu pikachu = new Pikachu();
		System.out.println(pikachu.toString());
		
		Pairi pairi= new Pairi();
		System.out.println(pairi.toString());
		
		Turtle turtle = new Turtle();
		System.out.println(turtle.toString());
		
		
		
	}

}
