import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // introduction
    System.out.print("Welcome to Java Clue, how many players are there (2-6): ");
    PlayerClass.player_amount = scan.nextInt();
    scan.nextLine();

    // create and store the different players
    PlayerClass[] player_list = new PlayerClass[PlayerClass.player_amount];
    for (int i = 0; i < PlayerClass.player_amount; i++) {
      player_list[i] = new PlayerClass(i);
    } // close for i

    // setup and display board
    Board.setup_board();
    Board.load_board();
    TextFormat.display();

    // main loop
    while (true) {
      //loop through player actions
      for (PlayerClass player: player_list) {
        player.set_equipment(new int[] {0, 1}, 1);
        player.load_card(1);
        TextFormat.display();
        scan.nextLine();
      } // closer player for
    } // close while

  } // close main
} // close Main
