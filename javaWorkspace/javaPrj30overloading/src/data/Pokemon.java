package data;

public class Pokemon {
	
	public Pokemon() {

	}
	
	public Pokemon(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	private String name;
	private int hp;
	private int atk;
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
	
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + "]";
	}
	
	
}
