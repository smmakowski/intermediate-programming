import java.util.ArrayList;

public class CompoundBow {
  public static int numCreated = 0;
  private static ArrayList<String> serials = new ArrayList<String>();
  private String serial;
  private double ataLength;
  private int cams;
  private double weight;
  private double drawLength;
  private double speed;

  public CompoundBow(int cams, double ataLength, double weight, double drawLength) {
    // set from arguments
    this.ataLength = ataLength;
    this.cams = cams;
    this.weight = weight;
    this.drawLength = drawLength;

    this.speed = this.setSpeed(); // set as return value of speed calculations

    this.serial = "BOW" + Integer.toString(numCreated) + (cams > 0 ? (cams > 1 ? "M" : "S") : "N") + Double.toString(this.weight); // generic serial based off information
    serials.add(this.serial);
    numCreated += 1; // increase num created by one
  }

  public double getWeight() { // instance method to return current weight of instance
    return this.weight;
  }

  public static boolean isValidSerial(String serial) { // class method to detect if an input serial number is valid
    return (serial.indexOf(serial) != -1 ? true : false);
  }
  // class method providing basic documentation
  public static void about() {
    System.out.println("This method provides basic information for the CompoundBow class.");
    System.out.println("1. Constructors and properties:");
    System.out.println("\t The CompoundBow constuctor takes 4 arguments... cams (int), ataLength, drawLength, and weight (double).");
    System.out.println("\t Class also includues additonal instance methods: speed (double), serial, and modelName (String)");
    System.out.println("2. Methods:");
    System.out.println("\t Class includes puclic instance method: instance.getWeight(), and static methods: CompountBow.isValidSerial()");
  }

  // private method for internal calcualtion of speed for constructor/set methods
  private double setSpeed() {
    // this is an arbitrary calculation
    return ((this.ataLength / 2.0) + (this.drawLength - 8.0)) * (350.0 / this.weight);
  }
}
