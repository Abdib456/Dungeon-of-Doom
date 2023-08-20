// The Main class is the entry pint of the program
public class Main {
  public static void main(String[] args) {
    // Creates instance of Gamelogic and BotPlayer classes
    GameLogic logic = new GameLogic();
    BotPlayer bot = new BotPlayer();

    // Get the Humanplayer object from the Gamelogic object
    HumanPlayer player = logic.getPlayer();
    
    System.out.println(logic.hello());
    // Keeps looping as long as game is running
    while (logic.gameRunning()) {
      player.getNextAction(logic);
      bot.move();
    }
   }
  }