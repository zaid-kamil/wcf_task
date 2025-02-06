package java_fundamentals;

/*
 * Write a program to receive a color code from the user (an Alphabhet). 
 * The program should then print the color name, based on the color code given. 
 * 
 * The following are the color codes and their corresponding color names.
 * R->Red, B->Blue, G->Green, O->Orange, Y->Yellow, W->White. 
 * 
 * If color code provided by the user is not valid then print "Invalid Code".
 */

public class Fcs8 {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No arguments provided");
            return;
        }
        // Map<String, String> colorMap = Map.of(
        //     "R", "Red",
        //     "B", "Blue",
        //     "G", "Green",
        //     "O", "Orange",
        //     "Y", "Yellow",
        //     "W", "White"
        // );
        // String colorCode = args[0];
        // if (colorMap.containsKey(colorCode)){
        //     System.out.println(colorMap.get(colorCode));
        // }else{
        //     System.out.println("Invalid Code");
        // }
        
        // switch
        String colorCode = args[0];
        switch (colorCode) {
            case "R" -> System.out.println("Red");
            case "B" -> System.out.println("Blue");
            case "G" -> System.out.println("Green");
            case "O" -> System.out.println("Orange");
            case "Y" -> System.out.println("Yellow");
            case "W" -> System.out.println("White");
            default -> System.out.println("Invalid Code");
        }
    }
}
