import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();
        new Thread(new Customer(table, "burger"), "CUST3").start();
        new Thread(new Customer(table, "donut"), "CUST4").start();
        new Thread(new Customer(table, "donut"), "CUST5").start();
        new Thread(new Customer(table, "donut"), "CUST6").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}

        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            String name = Thread.currentThread().getName();

            if (eatFood()) {
                System.out.println(name + " eat a " + food);
            } else {
                System.out.println(name + " failed to eat. :(");
            }
        }
    }

    boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) { this.table = table; }

    @Override
    public void run() {
        while (true) {
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
        }
    }
}

class Table {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private List<String> dishes = new ArrayList<>();

    public void add(String dish) {
        if (dishes.size() >= MAX_FOOD) {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes: " + dishes.toString());
    }

    public boolean remove(String dishName) {
        for (int i = 0; i < dishes.size(); i++) {
            if (dishName.equals(dishes.get(i))) {
                dishes.remove(i);
                return true;
            }
        }

        return false;
    }

    public int dishNum() { return dishNames.length; }
}