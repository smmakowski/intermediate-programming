import java.util.ArrayList;

public class CompoundBow {
  public static int numCreated = 0;
  private static ArrayList<String> serials = new ArrayList<String>();
  private String serial;
  private float ataLength;
  private int cams;
  private float weight;
  private float drawLength;
  private float speed;

  public CompoundBow(int cams, float ataLength,  float weight, float drawLength) {
    this.serial = "BOW" + numCreated +  (cams > 0 ? (cams > 1 ? "M" : "S") : "N") + // generic serial based off information
    serials.add(this.serial);
    this.ataLength = ataLength;
    this.cams = cams;
    this.weight = weight;
    this.drawLength = drawLength;
    this.speed = this.setSpeed(); // set as return value of speed calculations

    numCreated += 1; // increase num created by one
  }

  public float getWeight() { // instance method to return current weight of instance
    return this.weight;
  }

  public static boolean isValidSerial(String serial) { // class method to detect if an input serial number is valid
    return (serial.indexOf(serial) != -1 ? true : false);
  }
  // class method providing basic documentation
  public static void about() {
    System.out.println("This method provides basic information for the CompoundBow class, which is designed to emulate generic Compound bows as manufacuted by a .");
    System.out.println("1. Constructors and properties:");
    System.out.println("\t The CompoundBow constuctor takes 4 arguments... cams (int), ataLength, drawLength, and weight (float).");
    System.out.println("\t Class also includues additonal instance methods: speed (float), serial, and modelName (String)");
    System.out.println("2. Methods:");
    System.out.println("\t Class includes puclic instance method: instance.getWeight(), and static methods: CompountBow.isValidSerial()");
  }

  // private method for internal calcualtion of speed for constructor/set methods
  private float setSpeed() {
    // this is an arbitrary calculation
    return ((float)(this.ataLength / 2.0) + (float)(this.drawLength - 8.0)) * (float)(350.0 / this.weight);
  }
}
