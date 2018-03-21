import java.util.ArrayList;

public class Bear {
  private String family = "Ursidae";
  private ArrayList<String> diet = new ArrayList<String>();
  private String color;
  private String name;

  public Bear(String name, String color) {
    this.name = name;
    this.color = color;
    this.addToDiet("Honey");
  }

  public String toString() {
    return "{family: \"" +  this.family + "\", diet: \"" + this.dietToString() +
    "\", name: \"" + this.name + "\", color: \"" + this.color + "}";
  }

  // array stringifier to be used in and only in toString()
  private String dietToString() {
    // handle 0 and len == 1 arrays
    if (this.diet.size() == 0) {
      return "[]";
    } else if (this.diet.size() == 1) {
      return "[" + this.diet.get(0) + "]";
    }

    String arrayString = "["; // initiate array
    // iterate through second to last element and add element with ','
    for (int i = 0; i < this.diet.size() - 1; i++) {
      arrayString += this.diet.get(i) + ", ";
    }
    // append final element and closing braceket
    arrayString += this.diet.get(diet.size() -1) + "]";

    return arrayString;
  }
  // prints statement based on whether or not food is in ArrayLsit
  public void eat(String food) {
    if (diet.indexOf(food.toUpperCase()) == -1) {
      System.out.println(this.name + " can not eat " + food + ".");
    } else {
      System.out.println(this.name + " can eat " + food + ".");
    }

  }

  // public set method for color (used in subclass to reset color after super() called in constructor)
  public void setColor(String color) {
    this.color = color;
  }
  // public modifier method to allow for changes to private diet ArrayList from subclass
  public void addToDiet(String food) {
    this.diet.add(food.toUpperCase());
  }
}
