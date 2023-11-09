package mob;

public abstract class Pokemon {
	
	
	
	public Pokemon(String name,int hp, int atk, int def) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}

	protected String name;
	protected int hp;
	protected int atk;
	protected int def;
	
	public void bodyAttack() {
		System.out.println(name + " 의 몸통박치기");
	}
	
	public abstract void skill();
	

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

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
	};
	
	
	
}
