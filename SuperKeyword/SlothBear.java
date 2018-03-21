public class SlothBear extends Bear {
  // properties unique to the SlothBear Class
  private int clawLength;
  private String genusSpecies = "Melursus Ursinus";

  // constructor
  public SlothBear(String name, String color, String[] diet, int clawLength) {
    super(name, color + " with a white spot", diet); // calls super constructor
    this.clawLength = clawLength; // assign unique field with argument
  }
  // toString() method oversides superclasses version
  public String toString() {
    return super.toString() + "\b, genusSpecies: " + this.genusSpecies + "\b, clawLength: " +
    this.clawLength +  "}"; // calls superclasses method and then augments it's return with info unique to subclass
  }
}
