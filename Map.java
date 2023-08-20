import java.util.*;

/**
 * Reads and contains in memory the map of the game.
 *
 */
public class Map {

	/* Representation of the map */
	private char[][] map;

  /* Part of the map thats printed around the player */
  public char[][] printedMap = new char[5][5];

	/* Map name */
	private String mapName;
  public int numberOfRows;
  public int numberOfColumns;

	/* Gold required for the human player to win */
  private int goldRequired;

	/**
	 * Default constructor, creates the default map "Very small Labyrinth of doom".
	 */
	public Map() {
		mapName = "Very small Labyrinth of Doom";
		goldRequired = 2;
		map = new char[][]{
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','G','.','.','.','.','.','.','.','.','.','E','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','E','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','G','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
		};
    numberOfRows = map.length;
    numberOfColumns = map[0].length;
	}

  /*Return the map name*/
  public String getMapName() {
    return mapName;
  }
  
  /*Return the map name*/
  protected char[][] getMap() {
    return map;
  }
  
  /*Sets a value to a point on the map*/
  public void setValueAt(int x, int y, char value){
    map[x][y] = value;
  }

  /*Gets the value at a point on the map*/
  public char getValueAt(int x, int y){
    return map[x][y];
  }
  
  /*Return the gold required*/
  protected int getGoldRequired() {
    return goldRequired;
  }
  
	/**
	 * Constructor that accepts a map to read in from.
	 *
	 * @param : The filename of the map file.
	 */
	public Map(String fileName) {
		readMap(fileName);
	}

    /**
     * Reads the map from file.
     *
     * @param : Name of the map's file.
     */
    public void readMap(String fileName) {
      Scanner scanner = new Scanner(System.in);

      int rows = scanner.nextInt();
      int columns = scanner.nextInt();

      char[][] map = new char [rows][columns];
      
      for (int i = 0; i < numberOfRows; i++) {
        for (int j = 0; j < numberOfColumns; j++) {
          map[i][j] = scanner.next().charAt(0);
        }
      }

      for (int i = 0; i < numberOfRows; i++) {
        for (int j = 0; j < numberOfColumns; j++) {
          System.out.print(map[i][j] + "");
        }
        System.out.println();
        }
      }
    }