package oops;

/*
 * Create  a base class Fruit with name ,taste and size as its attributes. 
 * Create a method called eat() which describes the name of the fruit and its taste. 
 * Inherit the same in 2 other classes Apple and Orange and override the eat() method to represent each fruit taste.
 */

class Fruit {
    private final String name;
    private final String taste;
    private final String size;

    public Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    public void eat() {
        System.out.println("Name: " + name + ", Taste: " + taste);
    }

}

class Apple extends Fruit {
    public Apple(String name, String taste, String size) {
        super(name, taste, size);
    }

    @Override
    public void eat() {
        System.out.println("Name: " + "Apple" + ", Taste: " + "Sweet");
    }
}


class Orange extends Fruit {
    public Orange(String name, String taste, String size) {
        super(name, taste, size);
    }

    @Override
    public void eat() {
        System.out.println("Name: " + "Orange" + ", Taste: " + "Sour");
    }
}


public class polym1 {
    public static void main(String[] args) {
        Apple apple = new Apple("Apple", "Sweet", "Medium");
        apple.eat();

        Orange orange = new Orange("Orange", "Sour", "Medium");
        orange.eat();
    }
}

