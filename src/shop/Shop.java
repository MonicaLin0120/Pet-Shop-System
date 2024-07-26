package shop;

import people.Manager;
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

    public boolean addStaff(Staff staff) {
        // todo 檢查員工身份

        staffList.add(staff);

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
