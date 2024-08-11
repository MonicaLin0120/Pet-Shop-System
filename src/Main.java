import biology.animal.Animal;
import biology.animal.Cat;
import biology.animal.Dog;
import people.*;
import shop.PetShop;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("001", "Jenny", new int[]{1995, 1, 15}, "Female");
        PetShop petShop = new PetShop(manager, 100);

        // 加入員工
        Staff staff01 = new Staff("002", "Alice", new int[]{1999,10, 15}, "Female");
        petShop.addStaff(staff01);
        Staff staff02 = new Staff("003", "Curry", new int[]{1998, 12, 18}, "Male");
        petShop.addStaff(staff02);

        // todo 加入動物
        Animal animal01 = new Cat("Kitty", 1, 1.5);
        petShop.addPet(animal01, 30000);
        Animal animal02 = new Dog("Den", 3, 6.5);
        petShop.addPet(animal02, 15000);
        Animal animal03 = new Cat("Yu", 5, 4.5);
        petShop.addPet(animal03, 40000);

        petShop.runSystem();
    }
}