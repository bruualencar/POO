package quest01_Bruna;

public class Truck {
	private int mass;
	public Truck(String registrationnumber, int mass) {
		super(registrationnumber);
		this.mass = mass;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

}