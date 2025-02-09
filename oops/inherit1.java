package oops;

/*
 * Create a class named ‘Animal’ which includes methods like eat() and sleep().
 * 
 * Create a child class of Animal named ‘Bird’ and override the parent class methods. 
 * Add a new method named fly().
 * 
 * Create an instance of Animal class and invoke the eat and sleep methods using this object.
 * 
 * Create an instance of Bird class and invoke the eat, sleep and fly methods using this object.
 */

class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Bird extends Animal {
    @Override
    public void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class Inherit1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        animal.sleep();

        Bird bird = new Bird();
        bird.eat();
        bird.sleep();
        bird.fly();
    }
}
