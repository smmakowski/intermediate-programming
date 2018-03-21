public class BearTest {
  public static void main(String[] args) {
    // instantiate objs
    Bear fuzzy = new Bear("Fuzzy", "Brown", new String[]{"honey"});
    SlothBear wuzzy = new SlothBear("Wuzzy", "Black", new String[]{"honey", "termites"}, 10);
    //print toString()
    System.out.println(fuzzy.toString());
    System.out.println(wuzzy.toString());
    // call eat methods
    fuzzy.eat("honey");
    fuzzy.eat("termites");
    wuzzy.eat("honey");
    wuzzy.eat("termites");
  }
}
