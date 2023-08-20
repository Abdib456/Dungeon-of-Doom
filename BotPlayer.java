import java.util.Random;

public class BotPlayer extends Player {


  protected void startLocation(char[][] map) {
    // Creates a random number generator
    Random random = new Random();

    int botXpos = random.nextInt(map.length);
    int botYpos = random.nextInt(map[0].length);

    // Keep generating new positions until vaild one appears
    while(map[botXpos][botYpos] == '#' || map[botXpos][Ypos] == 'G' || map[botXpos][botYpos] == 'P' || map[botXpos][botYpos] == 'B'){
      botXpos = random.nextInt(map.length);
      botYpos = random.nextInt(map[0].length);
    }
    setXpos(botXpos);
    setYpos(botYpos);
    map[botXpos][botYpos] = 'B';
  }

  // Overrides the move() method in the player
  public void move() {
    // Moves the bot in a random direction
    Random random = new Random();
    // Generates a random number between 0 and 3 (inclusive) then moves the bot correspondingly
    int direction = random.nextInt(4);
    switch (direction) {
      case 0:
        moveXpos(-1);
        break;
      case 1:
        moveXpos(1);
        break;
      case 2:
        moveYpos(-1);
        break;
      case 3:
        moveYpos(1);
        break;     
    }
  }
}