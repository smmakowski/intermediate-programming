import java.util.ArrayList;

public class Bear {
  private String family = "Ursidae";
  private ArrayList<String> diet = new ArrayList<String>();
  private String color;
  private String name;

  public Bear(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public String toString() {
    return "{family: \"" +  this.family + "\", diet: \"" + this.dietToString() +
    "\", name: \"" + this.name + "\", color: \"" + this.color + "}";
  }

  private String dietToString() {
    String arrayString = "[";

    for (int i = 0; i < this.diet.size() - 1; i++) {
      arrayString += this.diet.get(i) + ", ";
    }

    arrayString += this.diet.get(diet.size() -1) + "]";

    return arrayString;
  }

  public void eat(String food) {
    if (diet.indexOf(food) == -1) {
      System.out.print(this.name + " ate the " + food + ".");
    } else {
      System.out.println(this.name + " cannot eat " + food + ".");
    }

  }

  public String roar() {
    return "Roar! I am a bear!";
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void addToDiet(String food) {
    this.diet.add(food);
  }
}
