import java.util.Arrays;

public class Bear {
  private String family = "Ursidae";
  private String[] diet;
  private String color;
  private String name;

  public Bear(String name, String color, String[] diet) {
    this.name = name;
    this.color = color;
    this.diet = capitalizeDiet(diet); // autocapitalize diet string
  }

  public String toString() {
    return "{family: \"" +  this.family + "\", diet: " + this.dietToString() +
    ", name: \"" + this.name + "\", color: \"" + this.color + "}";
  }

  // array stringifier to be used in and only in toString()
  private String dietToString() {
    // handle 0 and len == 1 arrays
    if (this.diet.length == 0) {
      return "[]";
    } else if (this.diet.length == 1) {
      return "[" + this.diet[0] + "]";
    }

    String arrayString = "["; // initiate array
    // iterate through second to last element and add element with ','
    for (int i = 0; i < this.diet.length - 1; i++) {
      arrayString += this.diet[i] + ", ";
    }
    // append final element and closing braceket
    arrayString += this.diet[this.diet.length - 1] + "]";

    return arrayString;
  }
  // prints statement based on whether or not food is in ArrayLsit
  public void eat(String food) {
    if (Arrays.asList(this.diet).indexOf(food.toUpperCase()) == -1) {
      System.out.println(this.name + " can not eat " + food + ".");
    } else {
      System.out.println(this.name + " can eat " + food + ".");
    }

  }

  // private method to auto-caps diet array contents for constructor (for case insensitivity in )
  private static String[] capitalizeDiet(String[] diet) {
    String[] allCapsDiet = new String[diet.length]; // init empty array copying arg array length
    // iterate and captialize
    for (int i = 0; i < diet.length; i++) {
      allCapsDiet[i] = diet[i].toUpperCase();
    }
    return allCapsDiet;
  }
}
