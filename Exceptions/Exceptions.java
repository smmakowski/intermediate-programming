public class Exceptions {
  public static main(String[] args) throws Exception {

  }

  public static boolean foo() throws Exception {
    try {
      bar(); // calls bar() will not throw expection becase bar can catch on it's own()
    } catch (Exception e) {
      System.out.println("Function foo() Caught _ exception.");
    }
  }

  public static int bar() throws Exception {
    try {
      // do something (should throw same error as foo() but catch it before foo does)
    } catch (Exception e) {
      System.out.println("Function bar() Caught _ exception.");
    }
  }

  public static double func() throws Exception {
    try {
    // should catch error thrown by tion()
    } catch (Exception e) {
      System.out.println("Function func() Caught _ Exception.");
    }
  }

  public static String tion() {
 // do something
  }
}
