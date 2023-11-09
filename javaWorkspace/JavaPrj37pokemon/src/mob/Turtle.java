package mob;

public class Turtle extends Pokemon{

	public Turtle(int hp, int atk, int def) {
		super("꼬부기", hp, atk, def);
	}

	@Override
	public void skill() {
		System.out.println(getName() + " 의 하이드로펌프!!");
	}
	
	
}
