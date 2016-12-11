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
/*
class ExamplePrivateConstructorClass {
	private ExamplePrivateConstructorClass() {}

	public static ExamplePrivateConstructorClass makeObject(){
		returtn new ExamplePrivateConstructorClass();
	}
}
*/