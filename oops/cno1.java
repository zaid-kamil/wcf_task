package oops;

/*
 * Create a class Box that uses a parameterized constructor to initialize the 
 * dimensions of a box.The dimensions of the Box are width, height, depth. 
 * The class should have a method that can return the volume of the box. 
 * Create an object of the Box class and test the functionalities.
 */

class Box {
    private final double width;
    private final double height;
    private final double depth;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getVolume() {
        return width * height * depth;
    }

    public static void main(String[] args) {
        Box box = new Box(10, 20, 30);
        System.out.println("Volume of the box is: " + box.getVolume());
    }

}
