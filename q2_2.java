/* наслідування класів відбувається зверху вниз по ієрархії. Похідні класи наслідують усі ознаки класа-батька. 
*/

public class Creatures(){
	Creatures()  {}

	public void breath(){
		System.out.println("Breathing");
	}
}


public class Plant extends Creatures(){
	Plant ()  {}

	public void makeOxygen(){
		System.out.println("photosynthesis");
	}
}


public class Animal extends Creatures(){
	Animal () {}

	public void run(){
		System.out.println("running");
	}
}

//Кіт являється твриною, тварина являється істотою, отже кіт також істота, і наслідує методи істоти
public class Cat extends Animal(){
	Cat() {}

	public void purr(){
		System.out.println("purr-purr");
	}
}

public class Main{

	public static int main(String[args]){
		Creatures creature = new Creatures();
		creature.breath(); // Output:Breathing

		Plant plant = new Plant();
		plant.makeOxygen(); // Output: photosynthesis

		Cat cat = new Cat();
		cat.purr(); //Output: purr-purr
		cat.breath(); //Output: Breathing
		cat.run(); //Output: running

	}

}

