public class BearTest {
  public static void main(String[] args) {
    Bear fuzzy = new Bear("Fuzzy", "Brown");
    SlothBear wuzzy = new SlothBear("Wuzzy", "Black", 10);

    System.out.println(fuzzy.toString());
    System.out.println(wuzzy.toString());

    fuzzy.eat("honey");
    fuzzy.eat("termites");
    wuzzy.eat("honey");
    wuzzy.eat("termites");
  }
}
