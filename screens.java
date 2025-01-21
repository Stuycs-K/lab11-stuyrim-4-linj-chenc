import java.util.*;

public class screens {
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void win () {
    Text.hideCursor();
    Text.clear();

    // Top Outer Corners
    Text.go(1,0);
    System.out.print("\u250F");
    Text.go(1,80);
    System.out.print("\u2513");

    // Left and Right Outer Borders
    for(int x = 2; x < 29; x++) {
      Text.go(x,0);
      System.out.print("\u2503");
      Text.go(x,80);
      System.out.print("\u2503");
    }

    // All Horizontal Border Lines
    for(int x = 2; x < 80; x++) {
      Text.go(1,x);
      System.out.print("\u2501");
      Text.go(29,x);
      System.out.print("\u2501");
    }

    // Bottom Outer Corners
    Text.go(29,0);
    System.out.print("\u2517");
    Text.go(29,80);
    System.out.print("\u251B");

    System.out.print("\033[;" + BORDER_COLOR + ";" + BORDER_BACKGROUND + "m");

    Text.go(6,23);
    System.out.print("  ");

    Text.go(7,23);
    System.out.print("  ");
    Text.go(7,13);
    System.out.print("  ");

    Text.go(8,53);
    System.out.print("  ");
    Text.go(8,43);
    System.out.print("  ");
    Text.go(8,29);
    System.out.print("  ");
    Text.go(8,27);
    System.out.print("  ");
    Text.go(8,23);
    System.out.print("  ");
    Text.go(8,21);
    System.out.print("  ");
    Text.go(8,15);
    System.out.print("  ");
    Text.go(8,13);
    System.out.print("  ");

    Text.go(9,53);
    System.out.print("  ");
    Text.go(9,43);
    System.out.print("  ");
    Text.go(9,35);
    System.out.print("  ");
    Text.go(9,33);
    System.out.print("  ");
    Text.go(9,31);
    System.out.print("  ");
    Text.go(9,29);
    System.out.print("  ");
    Text.go(9,27);
    System.out.print("  ");
    Text.go(9,25);
    System.out.print("  ");
    Text.go(9,21);
    System.out.print("  ");
    Text.go(9,17);
    System.out.print("  ");
    Text.go(9,15);
    System.out.print("  ");

    Text.go(10,53);
    System.out.print("  ");
    Text.go(10,43);
    System.out.print("  ");
    Text.go(10,35);
    System.out.print("  ");
    Text.go(10,25);
    System.out.print("  ");
    Text.go(10,19);
    System.out.print("  ");
    Text.go(10,17);
    System.out.print("  ");

    Text.go(11,53);
    System.out.print("  ");
    Text.go(11,43);
    System.out.print("  ");
    Text.go(11,35);
    System.out.print("  ");
    Text.go(11,25);
    System.out.print("  ");
    Text.go(11,19);
    System.out.print("  ");
    Text.go(11,17);
    System.out.print("  ");

    Text.go(12,53);
    System.out.print("  ");
    Text.go(12,43);
    System.out.print("  ");
    Text.go(12,35);
    System.out.print("  ");
    Text.go(12,25);
    System.out.print("  ");
    Text.go(12,17);
    System.out.print("  ");

    Text.go(13,53);
    System.out.print("  ");
    Text.go(13,45);
    System.out.print("  ");
    Text.go(13,35);
    System.out.print("  ");
    Text.go(13,33);
    System.out.print("  ");
    Text.go(13,27);
    System.out.print("  ");
    Text.go(13,25);
    System.out.print("  ");
    Text.go(13,17);
    System.out.print("  ");
    Text.go(13,15);
    System.out.print("  ");

    Text.go(14,69);
    System.out.print("  ");
    Text.go(14,53);
    System.out.print("  ");
    Text.go(14,51);
    System.out.print("  ");
    Text.go(14,49);
    System.out.print("  ");
    Text.go(14,47);
    System.out.print("  ");
    Text.go(14,45);
    System.out.print("  ");
    Text.go(14,33);
    System.out.print("  ");
    Text.go(14,31);
    System.out.print("  ");
    Text.go(14,29);
    System.out.print("  ");
    Text.go(14,27);
    System.out.print("  ");
    Text.go(14,15);
    System.out.print("  ");
    Text.go(14,13);
    System.out.print("  ");

    Text.go(15,69);
    System.out.print("  ");
    Text.go(15,13);
    System.out.print("  ");

    Text.go(16,69);
    System.out.print("  ");
    Text.go(16,41);
    System.out.print("  ");

    Text.go(17,69);
    System.out.print("  ");
    Text.go(17,45);
    System.out.print("  ");
    Text.go(17,33);
    System.out.print("  ");
    Text.go(17,19);
    System.out.print("  ");

    Text.go(18,69);
    System.out.print("  ");
    Text.go(18,57);
    System.out.print("  ");
    Text.go(18,55);
    System.out.print("  ");
    Text.go(18,53);
    System.out.print("  ");
    Text.go(18,51);
    System.out.print("  ");
    Text.go(18,49);
    System.out.print("  ");
    Text.go(18,45);
    System.out.print("  ");
    Text.go(18,41);
    System.out.print("  ");
    Text.go(18,33);
    System.out.print("  ");
    Text.go(18,19);
    System.out.print("  ");

    Text.go(19,69);
    System.out.print("  ");
    Text.go(19,57);
    System.out.print("  ");
    Text.go(19,49);
    System.out.print("  ");
    Text.go(19,47);
    System.out.print("  ");
    Text.go(19,45);
    System.out.print("  ");
    Text.go(19,41);
    System.out.print("  ");
    Text.go(19,33);
    System.out.print("  ");
    Text.go(19,19);
    System.out.print("  ");

    Text.go(20,69);
    System.out.print("  ");
    Text.go(20,59);
    System.out.print("  ");
    Text.go(20,47);
    System.out.print("  ");
    Text.go(20,45);
    System.out.print("  ");
    Text.go(20,41);
    System.out.print("  ");
    Text.go(20,33);
    System.out.print("  ");
    Text.go(20,27);
    System.out.print("  ");
    Text.go(20,25);
    System.out.print("  ");
    Text.go(20,19);
    System.out.print("  ");

    Text.go(21,69);
    System.out.print("  ");
    Text.go(21,59);
    System.out.print("  ");
    Text.go(21,45);
    System.out.print("  ");
    Text.go(21,41);
    System.out.print("  ");
    Text.go(21,33);
    System.out.print("  ");
    Text.go(21,29);
    System.out.print("  ");
    Text.go(21,27);
    System.out.print("  ");
    Text.go(21,25);
    System.out.print("  ");
    Text.go(21,21);
    System.out.print("  ");

    Text.go(22,69);
    System.out.print("  ");
    Text.go(22,59);
    System.out.print("  ");
    Text.go(22,45);
    System.out.print("  ");
    Text.go(22,41);
    System.out.print("  ");
    Text.go(22,33);
    System.out.print("  ");
    Text.go(22,29);
    System.out.print("  ");
    Text.go(22,25);
    System.out.print("  ");
    Text.go(22,21);
    System.out.print("  ");

    Text.go(23,59);
    System.out.print("  ");
    Text.go(23,45);
    System.out.print("  ");
    Text.go(23,41);
    System.out.print("  ");
    Text.go(23,33);
    System.out.print("  ");
    Text.go(23,31);
    System.out.print("  ");
    Text.go(23,25);
    System.out.print("  ");
    Text.go(23,23);
    System.out.print("  ");
    Text.go(23,21);
    System.out.print("  ");

    Text.go(24,59);
    System.out.print("  ");
    Text.go(24,45);
    System.out.print("  ");
    Text.go(24,41);
    System.out.print("  ");
    Text.go(24,23);
    System.out.print("  ");

    Text.go(25,69);
    System.out.print("  ");
  }

  public static void lose () {
    Text.hideCursor();
    Text.clear();
    System.out.print("\033[;" + BORDER_COLOR + ";" + BORDER_BACKGROUND + "m");

    // Top Outer Corners
    Text.go(1,0);
    System.out.print("\u250F");
    Text.go(1,80);
    System.out.print("\u2513");

    // Left and Right Outer Borders
    for(int x = 2; x < 29; x++) {
      Text.go(x,0);
      System.out.print("\u2503");
      Text.go(x,80);
      System.out.print("\u2503");
    }

    // All Horizontal Border Lines
    for(int x = 2; x < 80; x++) {
      Text.go(1,x);
      System.out.print("\u2501");
      Text.go(29,x);
      System.out.print("\u2501");
    }

    // Bottom Outer Corners
    Text.go(29,0);
    System.out.print("\u2517");
    Text.go(29,80);
    System.out.print("\u251B");

    System.out.print("\033[;" + BORDER_COLOR + ";" + BORDER_BACKGROUND + "m");

    Text.go(6,23);
    System.out.print("  ");

    Text.go(7,23);
    System.out.print("  ");
    Text.go(7,13);
    System.out.print("  ");

    Text.go(8,53);
    System.out.print("  ");
    Text.go(8,43);
    System.out.print("  ");
    Text.go(8,29);
    System.out.print("  ");
    Text.go(8,27);
    System.out.print("  ");
    Text.go(8,23);
    System.out.print("  ");
    Text.go(8,21);
    System.out.print("  ");
    Text.go(8,15);
    System.out.print("  ");
    Text.go(8,13);
    System.out.print("  ");

    Text.go(9,53);
    System.out.print("  ");
    Text.go(9,43);
    System.out.print("  ");
    Text.go(9,35);
    System.out.print("  ");
    Text.go(9,33);
    System.out.print("  ");
    Text.go(9,31);
    System.out.print("  ");
    Text.go(9,29);
    System.out.print("  ");
    Text.go(9,27);
    System.out.print("  ");
    Text.go(9,25);
    System.out.print("  ");
    Text.go(9,21);
    System.out.print("  ");
    Text.go(9,17);
    System.out.print("  ");
    Text.go(9,15);
    System.out.print("  ");

    Text.go(10,53);
    System.out.print("  ");
    Text.go(10,43);
    System.out.print("  ");
    Text.go(10,35);
    System.out.print("  ");
    Text.go(10,25);
    System.out.print("  ");
    Text.go(10,19);
    System.out.print("  ");
    Text.go(10,17);
    System.out.print("  ");

    Text.go(11,53);
    System.out.print("  ");
    Text.go(11,43);
    System.out.print("  ");
    Text.go(11,35);
    System.out.print("  ");
    Text.go(11,25);
    System.out.print("  ");
    Text.go(11,19);
    System.out.print("  ");
    Text.go(11,17);
    System.out.print("  ");

    Text.go(12,53);
    System.out.print("  ");
    Text.go(12,43);
    System.out.print("  ");
    Text.go(12,35);
    System.out.print("  ");
    Text.go(12,25);
    System.out.print("  ");
    Text.go(12,17);
    System.out.print("  ");

    Text.go(13,53);
    System.out.print("  ");
    Text.go(13,45);
    System.out.print("  ");
    Text.go(13,35);
    System.out.print("  ");
    Text.go(13,33);
    System.out.print("  ");
    Text.go(13,27);
    System.out.print("  ");
    Text.go(13,25);
    System.out.print("  ");
    Text.go(13,17);
    System.out.print("  ");
    Text.go(13,15);
    System.out.print("  ");

    Text.go(14,53);
    System.out.print("  ");
    Text.go(14,51);
    System.out.print("  ");
    Text.go(14,49);
    System.out.print("  ");
    Text.go(14,47);
    System.out.print("  ");
    Text.go(14,45);
    System.out.print("  ");
    Text.go(14,33);
    System.out.print("  ");
    Text.go(14,31);
    System.out.print("  ");
    Text.go(14,29);
    System.out.print("  ");
    Text.go(14,27);
    System.out.print("  ");
    Text.go(14,15);
    System.out.print("  ");
    Text.go(14,13);
    System.out.print("  ");

    Text.go(15,13);
    System.out.print("  ");

    Text.go(17,19);
    System.out.print("  ");

    Text.go(18,61);
    System.out.print("  ");
    Text.go(18,59);
    System.out.print("  ");
    Text.go(18,57);
    System.out.print("  ");
    Text.go(18,47);
    System.out.print("  ");
    Text.go(18,45);
    System.out.print("  ");
    Text.go(18,43);
    System.out.print("  ");
    Text.go(18,19);
    System.out.print("  ");

    Text.go(19,63);
    System.out.print("  ");
    Text.go(19,61);
    System.out.print("  ");
    Text.go(19,57);
    System.out.print("  ");
    Text.go(19,55);
    System.out.print("  ");
    Text.go(19,43);
    System.out.print("  ");
    Text.go(19,41);
    System.out.print("  ");
    Text.go(19,37);
    System.out.print("  ");
    Text.go(19,35);
    System.out.print("  ");
    Text.go(19,17);
    System.out.print("  ");

    Text.go(20,63);
    System.out.print("  ");
    Text.go(20,55);
    System.out.print("  ");
    Text.go(20,47);
    System.out.print("  ");
    Text.go(20,45);
    System.out.print("  ");
    Text.go(20,43);
    System.out.print("  ");
    Text.go(20,39);
    System.out.print("  ");
    Text.go(20,37);
    System.out.print("  ");
    Text.go(20,33);
    System.out.print("  ");
    Text.go(20,17);
    System.out.print("  ");

    Text.go(21,63);
    System.out.print("  ");
    Text.go(21,61);
    System.out.print("  ");
    Text.go(21,59);
    System.out.print("  ");
    Text.go(21,57);
    System.out.print("  ");
    Text.go(21,55);
    System.out.print("  ");
    Text.go(21,53);
    System.out.print("  ");
    Text.go(21,49);
    System.out.print("  ");
    Text.go(21,47);
    System.out.print("  ");
    Text.go(21,39);
    System.out.print("  ");
    Text.go(21,33);
    System.out.print("  ");
    Text.go(21,17);
    System.out.print("  ");

    Text.go(22,53);
    System.out.print("  ");
    Text.go(22,49);
    System.out.print("  ");
    Text.go(22,39);
    System.out.print("  ");
    Text.go(22,33);
    System.out.print("  ");
    Text.go(22,17);
    System.out.print("  ");

    Text.go(23,55);
    System.out.print("  ");
    Text.go(23,53);
    System.out.print("  ");
    Text.go(23,49);
    System.out.print("  ");
    Text.go(23,43);
    System.out.print("  ");
    Text.go(23,37);
    System.out.print("  ");
    Text.go(23,35);
    System.out.print("  ");
    Text.go(23,33);
    System.out.print("  ");
    Text.go(23,27);
    System.out.print("  ");
    Text.go(23,25);
    System.out.print("  ");
    Text.go(23,23);
    System.out.print("  ");
    Text.go(23,21);
    System.out.print("  ");
    Text.go(23,19);
    System.out.print("  ");
    Text.go(23,17);
    System.out.print("  ");

    Text.go(24,63);
    System.out.print("  ");
    Text.go(24,61);
    System.out.print("  ");
    Text.go(24,57);
    System.out.print("  ");
    Text.go(24,55);
    System.out.print("  ");
    Text.go(24,49);
    System.out.print("  ");
    Text.go(24,47);
    System.out.print("  ");
    Text.go(24,45);
    System.out.print("  ");
    Text.go(24,43);
    System.out.print("  ");

    Text.go(24,61);
    System.out.print("  ");
    Text.go(24,59);
    System.out.print("  ");
    Text.go(24,57);
    System.out.print("  ");
  }

  public static void main (String[] args) {}

}
