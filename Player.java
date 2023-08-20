// Abstract class for the human player and bot to inherit from
public abstract class Player {
  
  // Coordinates of the player on the Map
  protected int Xpos;
  protected int Ypos;

  // Default constructor that sets the intial position to (0,0)
  public Player() {
    Xpos = 0;
    Ypos = 0;  
  }

  //Getter methods for the player's position
  public int getXpos() {
    return Xpos;
  }

  public int getYpos() {
    return Ypos;
  }

  // Settter methods for the player's position
  public void setXpos(int x){
    Xpos = x;
  }

  public void setYpos(int y){
    Ypos = y;
  }

  // Method for moving the player's position in the x and y direction
  public void moveXpos(int x) {
    Xpos = Xpos + x;
  }

  public void moveYpos(int y) {
    Ypos = Ypos + y;
  }
  // inheritance used here include super?
}