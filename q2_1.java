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

