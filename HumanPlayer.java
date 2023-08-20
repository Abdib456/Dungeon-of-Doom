import java.util.*;
/**
 * Runs the game with a human player and contains code needed to read inputs.
 *
 */
public class HumanPlayer extends Player {

   protected void startLocation(char[][] map/*, char playerChar*/) {
    // Creates a random number generator
    Random random = new Random();

    Xpos = random.nextInt(map.length);
    Ypos = random.nextInt(map[0].length);

    // Keep generating new positions until vaild one appears
    while(map[Xpos][Ypos] == '#' || map[Xpos][Ypos] == 'G' || map[Xpos][Ypos] == 'P'){
      Xpos = random.nextInt(map.length);
      Ypos = random.nextInt(map[0].length);
    }
    map[Xpos][Ypos] = 'P';   
  }

  public void getNextAction(GameLogic logic) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your commands here: ");
    String action = scanner.nextLine();

    // Checks which action the player wants and calls the appropiate method
    if(action.equals("HELLO")) {
      System.out.println(logic.hello());

    } else if (action.equals("GOLD")) {
      System.out.println(logic.gold());

    } else if (action.equals("PICKUP")) {
      System.out.println(logic.pickup());

    } else if (action.startsWith("MOVE")) {
      String[] actionSplit = action.split(" ");
      if(actionSplit.length != 2){
        System.out.println("INVALID MOVE COMMAND");
      } else {
        String direction = actionSplit[1];
        if (direction.equals("N") || direction.equals("S") || direction.equals("E") || direction.equals("W")) {
          System.out.println(logic.move(direction.charAt(0)));
      } else {
        System.out.println("INVALID MOVE DIRECTION");
        }
      }

    } else if (action.equals("LOOK")) {
      // Iterates through subarrays to print map as a 2D array
      for(char[] subarr : logic.look()){
        for (char c : subarr) {
          System.out.print(c);
        }
        System.out.println();
      }
    } else if (action.equals("QUIT")) {
      System.out.println(logic.quit());
    } else {
      System.out.println("INVALID COMMAND");
    }
  }
}