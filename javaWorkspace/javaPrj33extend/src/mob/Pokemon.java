package mob;

public class Pokemon {
	
	public Pokemon(String t) {
		super();
		// TODO Auto-generated constructor stub
	}

	protected String name;
	protected int hp=100;		
	protected int atk = (int)(Math.random()*3*+5);
	protected int def = (int)(Math.random()*5+1);;
	
	public void bodyAttack() {
		System.out.println(name + "의 몸통박치기!");
	}
	
	public void skill() {
		
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

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
	}
	
	
}

