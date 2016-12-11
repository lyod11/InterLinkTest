/*		Принципы ООП
		Инкапсуляция
	Сокрытие деталей реализации и поведение объекта от его клиентов
/*

/*
Через приховування деталей реалізації відбувається контроль над доступом до об'єкта, це називається інкапсуляція.
Програмісту, який використовує певні бібліотекти потрібно знати які класи і методи він може використовувати, а які є допоміжними.
Також зміни в бібліотеці закритих класів не потягнуть за собою негативних наслідків для програміста-клієнта
Приховування реалізації відбувається за допомогою специфікаторів public, private protected та доступом в межах пакету
*/


class Calculator{

	public String title = "Сума: ";
	private int a, b, c;

	Calculator() {}

	Calculator (int a, int b){
		this.a = a;
		this.b = b;
	} 

	public int calculate(){
		c = a + b;
		return c;
	}

	//доступ до змінних a i b здійснюється за допомогою get i set методів, доступу до змінної c не передбачено

	public int getA(){
		return a;
	}

	public void setA(int a){
		this.a = a;
	}

	public int getB(){
		return b;
	}

	public void setB(int b){
		this.b = b;
	}

	public static int main(String[args]){
		Calculator calc1 = new Calculator();
		Calculator calc2 = new Calculator(2, 3);
		calc1.setA(20);
		calc1.setB(30);
		System.out.println(calc1.title + calc1.calculate());
		System,out.println(calc2.title + calc2.calculate());
	}

}


//Клас може мати доступ в межах пакету або бути public, якщо э необхідність зробити його закритим, моожна оголосити конструктори класу
//як private, а його екземпляри створювати у статичному методі

class ExamplePrivateConstructorClass {
	private ExamplePrivateConstructorClass() {}

	public static ExamplePrivateConstructorClass makeObject(){
		returtn new ExamplePrivateConstructorClass();
	}
}



/* Наследование

	Устранение дублирования спецификации классов
*/

/* 
Під специфікацією я розумію інтерфейс класу. Тобто потрібно, щоб реалізація була різною з однаковими інтерфейсами. Для цього
служить перевизначення (Overriding)

*/

//так як кожен клас наслідується від класу Object, то можна перевизначити метод toString
public class SomeClass(){
	@Override
	public void toString(){
		System.out.println("Say something");
	}

	public static int main(String[args]){
		SomeClass cl = new SomeClass();
		cl.toString(); //Output: Say something
	}
}


/*
Отражение типа связи “является” (иерархии)

 наслідування класів відбувається зверху вниз по ієрархії. Похідні класи наслідують усі ознаки класа-батька. 
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

/*
Наследование интерфейса

 В інтерфейсі можуть описуватись тільки абстрактні публічні методи і статичні константи. Інтерфес визначає які елементи будуть 
взаємодіяти між собою
*/

interface PassangersTransportation {
    void transportPassangers();
}
interface CargoTransportation {
    void transportCargo();
}

//наслідування інтерфейса і перевизначення метода
class Truck implements CargoTransportation {
    public void transportCargo() {
        System.out.println("Перевезення вантажів");
    }
}
class Limuzin implements PassangersTransportation {
    public void transportPassangers() {
        System.out.println("Перевезення пасажирів");
    }
}

//multiple inheritance
class Pickup implements CargoTransportation, PassangersTransportation {
    public void transportCargo() {
        System.out.println("Перевезення вантажів");
    }
    public void transportPassangers() {
        System.out.println("Перевезення пасажирів");
    }
}

/*Полиморфизм
 	Разное поведение объектов поддерживающих общий интерфейс в зависимости от их реальных типов
*/

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

/*
Ключевым в использовании полиморфизма является работа клиентского кода с интерфейсом не имея информации о реально использованных
классах реализующих этот интерфейс

Наприклад: в Java є інтерфейс Map, програміст може не знати як саме він працює і реалізований, але користуватись ним.
В бібліотеці Java існує 2 реалізації інтерфейсу Map: класи HashMap i TreeMap.
Програміст і сам може імплементувати інтерфейс Мар у свій клас
*/

//приклад з інтернету. В ньому перевизначаються необхідні для роботи методи
public class MyMap implements Map {

  private ArrayList keys;
  private ArrayList values;

  public MyMap() {
    keys = new ArrayList();
    values = new ArrayList();
  }

  /** Return the number of mappings in this Map. */
  public int size() {
    return keys.size();
  }

  /** Return true if this map is empty. */
  public boolean isEmpty() {
    return size() == 0;
  }

  /** Return true if o is contained as a Key in this Map. */
  public boolean containsKey(Object o) {
    return keys.contains(o);
  }

  /** Return true if o is contained as a Value in this Map. */
  public boolean containsValue(Object o) {
    return keys.contains(o);
  }

  /** Get the object value corresponding to key k. */
  public Object get(Object k) {
    int i = keys.indexOf(k);
    if (i == -1)
      return null;
    return values.get(i);
  }

  /** Put the given pair (k, v) into this map, by maintaining "keys"
   * in sorted order.
   */
  public Object put(Object k, Object v) {
    for (int i=0; i < keys.size(); i++) {
      Object old = keys.get(i);

      /* Does the key already exist? */
      if (((Comparable)k).compareTo(keys.get(i)) == 0) {
        keys.set(i, v);
        return old;
      }

      /* Did we just go past where to put it?
       * i.e., keep keys in sorted order.
       */
      if (((Comparable)k).compareTo(keys.get(i)) == +1) {
        int where = i > 0 ? i -1 : 0;
        keys.add(where, k);
        values.add(where, v);
        return null;
      }
    }

    // Else it goes at the end.
    keys.add(k);
    values.add(v);
    return null;
  }

