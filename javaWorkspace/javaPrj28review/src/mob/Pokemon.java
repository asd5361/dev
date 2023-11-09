package mob;

public class Pokemon {
	
	private String name;
	private int hp;
	private int atk;
	
	public Pokemon(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	public Pokemon() {
		
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

	public void bodyAttack() {
		System.out.println(this.name+"의 몸통박치기 !");
	}

	public String getFieldInfo() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + "]";
	}
	
}
