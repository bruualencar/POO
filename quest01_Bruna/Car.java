package quest01_Bruna;

public class Car {
	private String transmission;
	public Car(String registrationnumber, String transmission) {
		super(registrationnumber);
		this.transmission = transmission;
	}

	

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

}
