package quest01_Bruna;

public class Main {
	public static void main (String []args) {
		Company c = new Company("empresaLora");
		Employee e = new Employee("funcionarios");
		Truck t = new Truck("caminhao", 276);
		Car cr = new Car("fusca", "impala");
		System.out.println(c.getName());
	}

}
