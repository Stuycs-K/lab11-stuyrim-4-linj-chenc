import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.WHITE;
  private static final int BORDER_BACKGROUND = Text.BLACK + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    System.out.print("\033[;" + BORDER_COLOR + ";" + BORDER_BACKGROUND + "m");

    // Top Outer Corners
    Text.go(1,0);
    System.out.print("\u250F");
    Text.go(1,80);
    System.out.print("\u2513");

    /* Fills in empty space -- blocks new text in center box for some reason
    for (int i = 2; i < 80; i++) {
      for (int x = 2; x < 29; x++) {
        if (x!= 5 && x!= 21 && x!= 25) {
          Text.go(x,i);
          System.out.print(" ");
        }
      }
    } */

    // Inner Vertical Borders (top)
    for(int x = 2; x < 6; x++) {
      Text.go(x,28);
      System.out.print("\u2503");
      Text.go(x,56);
      System.out.print("\u2503");
    }

    // Inner Vertical Borders (bottom)
    for(int x = 21; x < 26; x++) {
      Text.go(x,28);
      System.out.print("\u2503");
      Text.go(x,56);
      System.out.print("\u2503");
    }

    // Left and Right Outer Borders
    for(int x = 2; x < 29; x++) {
      Text.go(x,0);
      if(x != 5 && x!= 21 && x!=25) {
        System.out.print("\u2503");
      }
      else {
        System.out.print("\u2523");
      }
      Text.go(x,80);
      if(x != 5 && x!= 21 && x!=25) {
        System.out.print("\u2503");
      }
      else {
        System.out.print("\u252B");
      }
    }

    // All Horizontal Border Lines
    for(int x = 2; x < 80; x++) {
      Text.go(1,x);
      if(x != 28 && x != 56) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u2533");
      }
      Text.go(29,x);
      System.out.print("\u2501");
      Text.go(5,x);
      if(x != 28 && x != 56) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u253B");
      }
      Text.go(21,x);
      if(x != 28 && x != 56) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u2533");
      }
      Text.go(25,x);
      if(x != 28 && x != 56) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u253B");
      }
    }

    // Bottom Outer Corners
    Text.go(29,0);
    System.out.print("\u2517");
    Text.go(29,80);
    System.out.print("\u251B");
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(s);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    if (text.contains("\n")) {
      String[] texts = text.split("\n");
      for (String t : texts) {
        TextBox(row,col,width,height,t);
        row = row + 1 + t.length()/width;
      }
    }
    else {
      String temp = "";
      String temp2 = "";
      if(text.length() > width - 2) {
        temp = text.substring(width - 2);
        text = text.substring(0, width - 2);
      }
      drawText(text, row, col);
      height--;
      if (temp.length() > 0) {
        TextBox(row+1,col,width,height,temp);
      }
      else {
        for (int x = 0; x < width-2 && height > 0; x++) {
          temp = temp + " ";
        }
        for (int x = 0; x < width-2-text.length(); x++) {
          temp2 = temp2 + " ";
        }
        drawText(temp2,row,col+text.length());
        while (height > 0) {
          height--;
          row = row+1;
          drawText(temp, row, col);
        }
      }
      Text.go(29,0);
      System.out.print("\u2517");
      Text.go(29,80);
      System.out.print("\u251B");
    }
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int num = (int) (Math.random() * 2);
      if (num == 0) {
        // we can change or remove names/stats later
        return new Enemy_BarbGoblin("Barbarian Goblin"+(int)(Math.random()*100));
      } else {
        return new Enemy_DrunkGoblin("Drunk Goblin"+(int)(Math.random()*100));
      }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    /*public static void drawParty(ArrayList<Adventurer> party,int startRow){
      for (int i = 0; i < party.size(); i++) {
        Adventurer member = party.get(i);
        int startCol = (i * WIDTH) / party.size();
        drawText(member.getName(), startRow, startCol);
        String hp = "HP: " + colorByPercent(member.getHP(), member.getmaxHP());
        drawText(hp, startRow + 1, startCol);
        String special = member.getSpecialName() + ": " + colorByPercent(member.getSpecial(), member.getSpecialMax());
        drawText(special, startRow + 2, startCol);
      }
      drawText("", startRow + 3, 0);
    }*/

    // doesn't work when I use drawText???? Still not centered I :<<<<<<

    public static void drawParty(ArrayList<Adventurer> party, int startRow) {
      int colWidth = 26;
      for (int i = 0; i < party.size(); i++) {
        Adventurer member = party.get(i);
        int startCol = (i * colWidth) + 2 + i;
        drawText(member.getName(), startRow, startCol + ((colWidth - member.getName().length()) / 2));
        String hp = "HP: " + colorByPercent(member.getHP(), member.getmaxHP());
        drawText(hp, startRow + 1, startCol + i);
        String special = member.getSpecialName() + ": " + colorByPercent(member.getSpecial(), member.getSpecialMax());
        drawText(special, startRow + 2, startCol + i);
      }
    }



  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    double percent = (double) hp / maxHP;
    if (percent < 0.25) {
      return Text.colorize(output, Text.RED);
    } else if (percent < 0.75) {
      return Text.colorize(output, Text.YELLOW);
    } else {
      return Text.colorize(output, Text.WHITE);
    }
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();

    //draw player party
    drawParty(party, 22);

    //draw enemy party
    drawParty(enemies, 2);

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(27,2);
      System.out.print("> ");
      Text.go(27,4);
      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      //clear the text that was written
      TextBox(26,2,80,3," ");
      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();

    boolean partyTurn = true;
    boolean firstEntry = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);

    drawBackground();
    String prepreprompt = "How many enemies do you wish to fight: one(o) / two(t) / three(th)";
    while ((! (input.equalsIgnoreCase("o") || input.equalsIgnoreCase("one"))) &&
              (! (input.equalsIgnoreCase("t") || input.equalsIgnoreCase("two"))) &&
              (! (input.equalsIgnoreCase("th") || input.equalsIgnoreCase("three")))) {
      if (firstEntry) {
        TextBox(26,2,WIDTH,1,prepreprompt);
      }
      else {
        TextBox(26,2,WIDTH,1,"Invalid entry, please try again: one(o) / two(t) / three(th)");
      }
      input = userInput(in);
      firstEntry = false;
    }
    firstEntry = true;

    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    String num = input;
    //only 1 for now; int num = 1+(int)(Math.random()*3);
    if (input.equalsIgnoreCase("th") || input.equalsIgnoreCase("three")) {
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
      enemies.add(createRandomAdventurer());
    } else if (input.equalsIgnoreCase("t") || input.equalsIgnoreCase("two")) {
      enemies.add(new Enemy_Yin("Yin"));
      enemies.add(new Enemy_Yang("Yang"));
    } else {
      enemies.add(new Boss1("Little Cheese"));
    }
    addAllies(enemies);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    party.add(new ElvenGuardian("Thalindor Aegisheart"));
    party.add(new Sorcerer("Veca Anouk"));
    party.add(new Priest("Léopoldine Goyathlay"));
    addAllies(party);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    // Adding enemies
    addEnemies(party,enemies);
    addEnemies(enemies,party);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
      String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      TextBox(26,2,WIDTH,1,preprompt);

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(6,2,80,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(7, 2, WIDTH, 17, party.get(whichPlayer).attack(enemies.get(whichOpponent)));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(7, 2, WIDTH, 17, party.get(whichPlayer).specialAttack(enemies.get(whichOpponent)));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          String[] parts = input.split(" ");
          if (parts.length < 2) {
            TextBox(26, 2, WIDTH, 3, "Invalid command. Please properly specify who to support.");
          } else {
            int supported = Integer.parseInt(parts[1]);
            if (supported < 0 || supported >= party.size()) {
              TextBox(26, 2, WIDTH, 3, "Invalid target. Choose a valid party member index.");
            } else if (supported == whichPlayer) {
              // suport self
              TextBox(7, 2, WIDTH, 17, party.get(whichPlayer).support());
            } else {
              // support other
              TextBox(7, 2, WIDTH, 17, party.get(whichPlayer).support(party.get(supported)));
            }
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
          TextBox(26,2,WIDTH,1,prompt);


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";
          TextBox(26,2,WIDTH,1,prompt);
          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        int action = (int)(Math.random() * 3);
        int randIndex = (int)(Math.random() * enemies.size());
        Adventurer randEnemy = enemies.get(randIndex);
        Adventurer randParty = party.get((int)(Math.random() * party.size()));
        if (action == 0) {
          TextBox(7, 2, WIDTH, 17, randEnemy.attack(randParty));
        } else if (action == 1) {
          TextBox(7, 2, WIDTH, 17, randEnemy.specialAttack(randParty));
        } else if (action == 2) {
          int randInt = (int)(Math.random() * enemies.size());
          if (randIndex == randInt) {
            TextBox(7, 2, WIDTH, 17, randEnemy.support());
          } else {
            TextBox(7, 2, WIDTH, 17, randEnemy.support(enemies.get(randInt)));
          }
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";
        TextBox(26,2,WIDTH,1,prompt);
        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
  }

  public static void addAllies(ArrayList<Adventurer> team) {
    for (int x = 0; x < team.size(); x++) {
      for (int i = 0; i < team.size(); i++) {
        if (i != x) {
          (team.get(x)).allies.add(team.get(i));
        }
      }
    }
  }

  public static void addEnemies(ArrayList<Adventurer> team1, ArrayList<Adventurer> team2) {
    for (int x = 0; x < team1.size(); x++) {
      for (int i = 0; i < team2.size(); i++) {
        team1.get(x).enemies.add(team2.get(i));
      }
    }
  }

}
