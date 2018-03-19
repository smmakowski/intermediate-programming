public class CompoundBowTest {
  public static void main(String[] args) {
    CompoundBow.about();
    System.out.println("");
    // made instances with CompoundBow(int cams, float ataLength,  float weight, float drawLength);
    CompoundBow bow1 = new CompoundBow(2, 32.0, 60.0, 27.0);
    CompoundBow bow2 = new CompoundBow(2, 38.0, 55.0, 28.5);

    System.out.println("Bows Created after round 1 = " + Integer.toString(CompoundBow.numCreated)); // 2; access static variable

    CompoundBow bow3 = new CompoundBow(1, 40.0, 40.0, 29.25);
    CompoundBow bow4 = new CompoundBow(0, 36.0, 70.0, 25.4); // should have a serial number of BOW3N70.0 (see static call of .isValidSerial() below)
    CompoundBow bow5 = new CompoundBow(0, 36.0, 35.0, 25.4);
    CompoundBow bow6 = new CompoundBow(0, 36.0, 70.0, 25.4);

    System.out.println("Bows Created after round 2 = " + Integer.toString(CompoundBow.numCreated)); // 6; access static variable again after more instances created

    System.out.println("");

    System.out.println("BOW3N70.0 " + (CompoundBow.isValidSerial("BOW3N70.0") == true ? "IS" : "IS NOT") + " a valid serial."); // should say 'IS' (static method return true)
    System.out.println("BOW6D70.0 " + (CompoundBow.isValidSerial("BOW6DDDD70.0") == true ? "IS" : "IS NOT") + " a valid serial."); // should say 'IS' (static method return true)

    System.out.println("");

    // test instance method .getWeight()
    System.out.println("bow1.weight = " + Double.toString(bow1.getWeight())); // should be 60
    System.out.println("bow2.weight = " + Double.toString(bow5.getWeight())); // should be 35

  }
}
