public class Exceptions {
  public static void main(String[] args) {
    foo();
    func();
  }

  public static void foo() throws IndexOutOfBoundsException {
    try {
      bar(); // calls bar() will not throw expection becase bar can catch on it's own()
    } catch (Exception e) {
      System.out.println("Function foo() Caught Exception thrown by Function bar().");
    }
  }

  public static void bar() throws IndexOutOfBoundsException {
    try {
      // do something (should throw same error as foo() but catch it before foo does)
      int[] arr = new int[] {4, 3, 2, 1};
      // for loop intentionally designed to go out of array bounds
      for (int i = 0; i < 5; i++) {
        System.out.println(arr[i]);
      }
    } catch (Exception e) {
      System.out.println("Function bar() Caught _ exception thrown by itself.");
    }
  }

  public static void func() throws ArithmeticException {
    try {
      int num = tion(); // tion() will throw an Exception
    } catch (Exception e) {
      System.out.println("Function func() Caught Exception thrown by Function tion().");
    }
  }

  public static int tion() {
    // division by zero should throw exception that is caught by func()
    return 100 / 0;
  }
}
