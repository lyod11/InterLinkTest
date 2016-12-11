
public class Creatures(){
	Creatures()  {}

	public void breath(){
		System.out.println("Breathing");
	}
}


public class Plant extends Creatures(){
	Plant ()  {}

	@Overload
	public void breath(){
		System.out.println("photosynthesis");
	}
}


public class Animal extends Creatures(){
	Animal () {}

	@Overload
	public void breath(){
		System.out.println("exhale - inlale");
	}

	public void run(){
		System.out.println("running");
	}
}

public class Cat extends Animal(){
	Cat() {}

	public void purr(){
		System.out.println("purr-purr");
	}
}

public class Main{

	public static int main(String[args]){

		//виконується механізм пізнього зв'язування, компілятор викликає перегружені методи дочірніх класів
		Creatures creature = new Creatures();
		creature.breath(); // Output:Breathing

		Creatures plant = new Plant();
		plant.breath(); // Output: photosynthesis

		Creatures cat = new Cat();
		cat.purr(); //Output: purr-purr
		cat.breath(); //Output: exhale - inlale
		cat.run(); //Output: running

	}

}