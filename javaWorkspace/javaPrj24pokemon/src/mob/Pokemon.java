package mob;

public class Pokemon {
	
	private String name;
	private int atk;
	private int def;
	private int hp;
	
	public void bodyAttack() {
		System.out.println(name + "의 몸통박치기~~~!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String toString() {
		return "Pokemon [name=" + name + ", atk=" + atk + ", def=" + def + ", hp=" + hp + "]";
	}

	public Pokemon(String name, int atk, int def, int hp) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
	}

	public Pokemon() {
		
	}
	
	

}
