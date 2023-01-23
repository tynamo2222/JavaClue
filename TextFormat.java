class TextFormat {
  public static String BLACK = "\u001B[30m",
      RED = "\u001B[31m",
      GREEN = "\u001B[32m",
      YELLOW = "\u001B[33m",
      BLUE = "\u001B[34m",
      PURPLE = "\u001B[35m",
      CYAN = "\u001B[36m",
      WHITE = "\u001B[37m",
      RESET = "\u001B[0m";

  private static String[] lines = new String[22];

  public static void reset_line(String line, int pos) {
    lines[pos] = line;
  }

  public static void add_line(String line, int pos) {
    lines[pos] += line;
  }

  public static void display() {
    for (String i : lines) {
      System.out.println(i);
    }
  }

  public static void clear_screen() {
    for (int i = 0; i < 100; i++)
      System.out.println();
  }
} // close TextFormat
