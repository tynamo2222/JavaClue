class Board {
  // board variables
  private static String[][] base_board = new String[22][22];
  private static String[][] feature_board = new String[22][22];
  // room variables
  private static int[][] room_locations = {
      { 0, 0, 5, 2 }, { 8, 0, 13, 5 }, { 16, 0, 21, 4 }, { 0, 5, 5, 9 }, { 0, 11, 4, 15 }, { 0, 18, 4, 21 },
      { 7, 16, 14, 21 }, { 17, 17, 21, 21 }, { 15, 7, 21, 13 }, { 8, 8, 12, 13 } }; // {x1,y1,x2,y2}
  private static String[] room_names = {
      "Study", "Hall", "Lounge", "Library", "Billiard room", "Conservatory", "Ballroom", "Kitchen", "Dining room",
      "Guessing Room" };
  private static String[] room_colors = {
      TextFormat.BLUE, TextFormat.RED, TextFormat.GREEN, TextFormat.GREEN, TextFormat.BLUE, TextFormat.RED,
      TextFormat.GREEN, TextFormat.RED, TextFormat.BLUE, TextFormat.PURPLE };

  // sets up the base_board array
  public static void setup_board() {
    // loops through all positions
    for (int y = 0; y < 22; y++) {
      for (int x = 0; x < 22; x++) {
        // sets correct room color
        for (int room = 0; room < room_locations.length; room++) {
          if (x >= room_locations[room][0] && x <= room_locations[room][2] && y >= room_locations[room][1]
              && y <= room_locations[room][3]) {
            base_board[y][x] = room_colors[room] + "#" + TextFormat.RESET;
            break;
          } else
            base_board[y][x] = "#";
        } // close room for
      } // close x for
    } // close y for
    // label rooms
    for (int room = 0; room < room_names.length; room++) {
      base_board[room_locations[room][1]][room_locations[room][0]] = room_colors[room]
          + String.valueOf(room_names[room].charAt(0)).toUpperCase() + TextFormat.RESET;
      base_board[room_locations[room][1]][room_locations[room][0] + 1] = room_colors[room]
          + String.valueOf(room_names[room].charAt(1)).toUpperCase() + TextFormat.RESET;
    } // close room for
    load_board();
  } // close setup_board

  // loads board into TextFormat lines
  public static void load_board() {
    for (int y = 0; y < 22; y++) {
      String board_line = "";
      for (int x = 0; x < 22; x++) {
        if (feature_board[y][x] != null)
          board_line += feature_board[y][x] + " ";
        else
          board_line += base_board[y][x] + " ";

      } // close x for
      TextFormat.reset_line(board_line, y);
    } // close y for
  } // close load_board

  // change feature board
  public static void change_board(int[] position, String character) {
    feature_board[position[1]][position[0]] = character;
  } // close change_board

  // gets current room
  public static String get_room(int[] position) {
    for (int room = 0; room < room_locations.length; room++) {
      if (position[0] >= room_locations[room][0] && position[0] <= room_locations[room][2]
          && position[1] >= room_locations[room][1] && position[1] <= room_locations[room][3])
        return room_names[room];
    } // close room for
    return "None";
  } // close get_room

} // close Board
