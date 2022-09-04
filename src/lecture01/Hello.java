package lecture01;

import java.util.ArrayList;
import java.util.List;

import lecture02.review.Administrator;

public class Hello {
    
    public static void main(String[] args) {
        System.out.println("Hello CPIT305");
        float x = 0.5e7f;
        long q = 1000_000; // 1000000
        char copy = '\u00A9';
        System.out.println(copy);

        int[] nums = {5, 8, 6, 7, 3};

        for (int i : nums) {
            System.out.println(i);
        }
        System.out.println();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(7);

        for (int i : list) {
            System.out.println(i);
        }


        System.out.println("---------------------------");

        System.out.println();

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();

        System.out.println("emp1: " + emp1.id);
        System.out.println("emp2: " + emp2.id);
        System.out.println("emp3: " + emp3.id);

        System.out.println(Employee.nextId);

        Administrator admin = new Administrator();

        admin.name = "Khalid";

        System.out.println("Admin id: " + admin.id);
        System.out.println("Admin name: " + admin.name);
    
        System.out.println(Administrator.nextId);
    }
}