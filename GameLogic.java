/**
 * Contains the main logic part of the game, as it processes.
 *
 */
public class GameLogic {

	// Reference to the map being used 
	private Map map;

  // Player objects
  private HumanPlayer player;
  private BotPlayer bot;

  // Counter for gold retrieved
  private int goldRetrieved;

  // Tracks if player has quit game
  private boolean playerQuit = false;
  
	/**
	 * Default constructor
	 */
	public GameLogic() {
		map = new Map();
    player = new HumanPlayer();
    bot = new BotPlayer();

    // Set the starting loaction of the human and bot player on the map
    player.startLocation(map.getMap());
    bot.startLocation(map.getMap());
    System.out.println("Welcome to: " + map.getMapName()); 
	}

  // Getter method for the player object
  public HumanPlayer getPlayer() {
    return player;
  }

    /**
	   * Checks if the game is running. The game is running if the bot and player are
	   * not in the same position on the map, and if the player has not quit the game.
     *
     * @return if the game is running, false otherwise
     */
    public boolean gameRunning() {
      boolean playerBotInDiffPos = ! (player.getXpos() == bot.getXpos() && player.getYpos() == bot.getYpos());
      if (!playerBotInDiffPos) {
        System.out.println("The bot caught you! You lose");
      }
        return playerBotInDiffPos && !playerQuit;
    }
    /* To Update the map each time a move is made */
    public void updateMap(int oldX, int oldY, int newX, int newY){
      char oldValue = map.getValueAt(oldX, oldY);
      char newValue = map.getValueAt(newX, newY);
      if (oldValue != 'E' && oldValue != 'G') {
        map.setValueAt(oldX, oldY, '.');
      }
      if (newValue != 'G' && newValue != 'E') {
        map.setValueAt(newX, newY,'P');
      }
    }

    /**
	   * Returns the gold required to win the game.
	   *
     * @return : Gold required to win the game.
     */
    protected String hello() {
        return "Gold Required to win is: " + map.getGoldRequired();
    }
    /**
	  * Returns the amount of gold retrieved by the player.
	  *
    * @return : the amount of gold retrieved by the player.
    */
    protected String gold() {
      return "Amount of Gold retrieved: " + goldRetrieved;
    }
  
    /**
	  * Moves the player in a direction chosen by humanplayer
	  *
    * @return : Success or fail depending on if the move is allowed.
    */
    protected String move(char direction) {
      // Get current position of player on the map
      int oldX = player.getXpos();
      int oldY = player.getYpos();
      int newX = oldX;
      int newY = oldY;
      char[][] mapArray = map.getMap();
      if(direction == 'W'){
        if(oldY > 0 && mapArray[oldX][oldY - 1] != '#') {
          newY = oldY - 1;
        }
      } else if (direction == 'E') {
        if (oldY < mapArray[0].length - 1 && mapArray[oldX][oldY + 1] != '#'){
          newY = oldY + 1;
        }
      } else if (direction == 'N') {
        if (oldX > 0 && mapArray[oldX - 1][oldY] != '#'){
          newX = oldX - 1;
        }
      } else if (direction == 'S') {
        if (oldX < mapArray.length - 1 && mapArray[oldX + 1][oldY] != '#'){
         newX = oldX + 1;
        }
      }
      if(newX != oldX || newY != oldY) {
        this.updateMap(oldX, oldY, newX, newY);
        player.setXpos(newX);
        player.setYpos(newY);
        return "SUCCESS";
      }
      else {
        return "FAIL";
      }
    }

    /**
	  * Gets the 5x5 array centered around the humanplayer
	  *
    * @return : Part of the map thats printed around the player.
    */
    protected char[][] look() {
      char[][] printedMap = new char[5][5];

      for (int i = 0; i < printedMap.length; i++) {
        for (int j = 0; j < printedMap[i].length; j++){
          // Set the element to '#' if its at the edge of the map
          if (i == 0 || i ==4 || j == 0 || j == 4) {
            printedMap[i][j] = '#';
          } else {
            printedMap[i][j] = ' ';
          }
        }
      }
      int Xpos = player.getXpos() ;
      int Ypos = player.getYpos() ;
      char[][] mapArray = map.getMap();
      for (int i = Xpos - 2; i <= Xpos + 2;i++){
        for (int j = Ypos - 2; j <= Ypos + 2;j++){
          if (i >= 0 && i < mapArray.length && j >= 0 && j < mapArray[i].length) {
            printedMap[i - (Xpos - 2)][j - (Ypos -2)] = mapArray[i][j];
          }
        }
      }
      return printedMap;
    }

    /**
	  * Picks up Gold and increases the gold count.
	  *
    * @return : Succes or fail along with gold owned by player.
    */
    protected String pickup() {
      String result;
      // Get the value at the player's position on the map
      char value = map.getValueAt(player.getXpos(), player.getYpos());
      if (value == 'G') { 
        // Update map to remove the gold piece
        map.setValueAt(player.getXpos(), player.getYpos(), '.');
        goldRetrieved ++;
        result = "SUCCESS. Gold owned:" + goldRetrieved;
        int oldX = player.getXpos();
        int oldY = player.getYpos();
        updateMap(oldX, oldY, oldX, oldY);
      } else {
        result = "FAIL. Gold owned:" + goldRetrieved;
      }
      return result;
    }

    /**
	  * Lets humanplayer quit game if it on 'E' and outputs the result of the game.
	  *
    * @return : Win or lose depending if player has got the right amount of gold.
    */
    protected String quit(){
      if (map.getMap()[player.getXpos()][player.getYpos()] == 'E' && goldRetrieved >= map.getGoldRequired()) {
        playerQuit = true;
        return "WIN";
        } else if (map.getMap()[player.getXpos()][player.getYpos()] == 'E') {
        playerQuit = true;
        return "LOSE";
        } else {
        return "NEED TO BE ON 'E' TO QUIT GAME";
        }
    }
}