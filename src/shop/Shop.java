package shop;

import people.Client;
import people.Manager;
import people.Person;
import people.Staff;
import java.util.Scanner;
import java.util.ArrayList;
public abstract class Shop {
    protected Manager manager;
    protected ArrayList<Staff> staffList;
    protected Scanner scanner;

    public Shop(Manager manager) {
        this.manager = manager;
        staffList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    protected Person createPerson() {
        //todo 具體功能
        return new Person();
    }

    protected Staff createStaff() {
        Person person = createPerson();
        return new Staff(person.getID(), person.getName(), person.getBirthday(), person.getGender());
    }

    protected Client createClient() {
        Person person = createPerson();
        return new Client(person.getID(), person.getName(), person.getBirthday(), person.getGender());
    }

    public boolean addStaff(Staff staff) {
        // todo 檢查員工身份

        staffList.add(staff);

        return true;
    }

    public boolean addStaff() {
        return addStaff(createStaff());
    }

    public boolean deleteStaff(String id) {
        //todo 刪除員工細節
        return true;
    }
    public abstract void runSystem();

    public String toString() {
        String str = "";

        str += "Manager is " + manager.toString() + "\n";

        for (int i = 0; i < staffList.size(); i++) {
            str += "Staff " + (i + 1) + " is " + staffList.get(i).toString() + "\n";
        }
        return str;
    }

}
