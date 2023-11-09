package mob;

import util.MyUtil;

public class Pokemon {
	
	public static final String NAME01 = "피카츄";
	public static final String NAME02 = "파이리";
	public static final String NAME03 = "꼬부기";
	private static final int MIN_ATK = 20;
	private static final int MAX_DEF = 10;
	
		
	private String name;
	private int hp;
	private int atk;
	private int def;
	
	public void bodyAttack() {
		System.out.println(name +" 의 몸통 박치기!!\n");
	}
	
	public void skill() {
		System.out.println(name +" 의 스킬 사용!!! \n");
//		switch(name) {
//		case "꼬부기":
//			System.out.println("물대포~\n"); break;
//		case "피카츄":
//			System.out.println("백만 볼트!!!!\n"); break;
//		case "파이리":
//			System.out.println("불꽃 발사~!\n"); break;
//		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public Pokemon(String name) {
		this.name = name;
		this.hp = 100;
		this.atk = MyUtil.getRandomInt(MIN_ATK, 30);
		this.def = MyUtil.getRandomInt(1, MAX_DEF);
	}

	public Pokemon(String name, int hp, int atk, int def) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}

	public Pokemon() {

	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
	}

	
	
}
