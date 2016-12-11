/* В інтерфейсі можуть описуватись тільки абстрактні публічні методи і статичні константи. Інтерфес визначає які елементи будуть 
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