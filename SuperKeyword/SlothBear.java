public class SlothBear extends Bear {
  // properties unique to the SlothBear Class
  private int clawLength;
  private String genusSpecies = "Melursus Ursinus";

  // constructor
  public SlothBear(String name, String color, int clawLength) {
    super(name, color); // calls super constructor
    this.addToDiet("Termites"); // adds extra food types to base diet
    this.clawLength = clawLength; // assign unique field with argument
    // use public set method to reset color
    this.setColor(color + " with a White spot");

  }

  public String toString() {
    return super.toString() + "\b, genusSpecies: " + this.genusSpecies + "\b, clawLength: " +
    this.clawLength +  "}";
  }
}
