import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.WHITE;
  private static final int BORDER_BACKGROUND = Text.BLACK + Text.BACKGROUND;
  private static final ArrayList<String> history = new ArrayList<>();
  private static int recentAction = 0;


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
      Text.go(x,54);
      System.out.print("\u2503");
    }

    // Inner Vertical Borders (bottom)
    for(int x = 21; x < 26; x++) {
      Text.go(x,28);
      System.out.print("\u2503");
      Text.go(x,54);
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
      if(x != 28 && x != 54) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u2533");
      }
      Text.go(29,x);
      System.out.print("\u2501");
      Text.go(5,x);
      if(x != 28 && x != 54) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u253B");
      }
      Text.go(21,x);
      if(x != 28 && x != 54) {
        System.out.print("\u2501");
      }
      else {
        System.out.print("\u2533");
      }
      Text.go(25,x);
      if(x != 28 && x != 54) {
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

  public static void addHistory(String text) {
    int maxWidth = WIDTH - 3;
    ArrayList<String> wrapped = new ArrayList<>();
    String[] lines = text.split("\n");
    for (String line : lines) {
      String[] words = line.split(" ");
      String current = "";
      for (String word : words) {
        if (current.length() + word.length() + 1 > maxWidth) {
          wrapped.add(current);
          current = word;
        } else {
          if (!current.isEmpty()) {
            current += " ";
          }
          current += word;
        }
      }
      if (!current.isEmpty()) {
        wrapped.add(current);
      }
    }
    recentAction = wrapped.size();
    for (int i = wrapped.size() - 1; i >= 0; i--) {
      history.add(0, wrapped.get(i));
    }
    while (history.size() > 14) {
      history.remove(history.size() - 1);
    }
  }

  public static void displayHistory(int row, int col, int width, int height) {
    TextBox(row, col, width, height, "");
    int index = Math.max(0, history.size() - height);
    for (int i = index; i < history.size(); i++) {
      String line = history.get(i);
      String styled;
      if (i < recentAction) {
        styled = Text.colorize(line, Text.BOLD);
      } else {
        styled = Text.colorize(line, 90);
      }
      drawText(styled, row++, col);
    }
    recentAction = Math.max(0, recentAction - (history.size() - index));
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
        int split = text.lastIndexOf(" ", width - 2);
        if (split == -1) {
          split = width - 2;
        }
        temp = text.substring(split + 1);
        text = text.substring(0, split);
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

  public static void drawParty(ArrayList<Adventurer> party, int startRow) {
    int colWidth = (WIDTH - 2) / 3;
    for (int i = 0; i < party.size(); i++) {
      Adventurer member = party.get(i);
      int startCol = (i * colWidth) + 2;
      String name = member.getName();
      if (party.size() == 1) {
        drawText(name, startRow, (WIDTH - name.length()) / 2);
      } else {
        drawText(name, startRow, startCol + (colWidth - name.length()) / 2);
      }
      String hp = "HP: " + colorByPercent(member.getHP(), member.getmaxHP());
      String special = member.getSpecialName() + ": " + colorByPercent(member.getSpecial(), member.getSpecialMax());
      if (party.size() == 1) {
        drawText(hp, startRow + 1, (WIDTH / 2) - (colWidth / 2) + 3);
        drawText(special, startRow + 2, (WIDTH / 2) - (colWidth / 2) + 3);
      } else {
        drawText(hp, startRow + 1, startCol + 1 + i);
        drawText(special, startRow + 2, startCol + 1 + i);
      }
    }
  }

  // old one just in case
  /* public static void drawParty(ArrayList<Adventurer> party, int startRow) {
  int colWidth = 26;
  for (int i = 0; i < party.size(); i++) {
    Adventurer member = party.get(i);
    int startCol = (i * colWidth) + 2 + i; // Start column for this party member
    drawText(member.getName(), startRow, startCol + ((colWidth - member.getName().length()) / 2)); // Center the name
    String hp = "HP: " + colorByPercent(member.getHP(), member.getmaxHP());
    drawText(hp, startRow + 1, startCol + i); // Display HP
    String special = member.getSpecialName() + ": " + colorByPercent(member.getSpecial(), member.getSpecialMax());
    drawText(special, startRow + 2, startCol + i); // Display special
    }
  } */




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

    displayHistory(7, 2, WIDTH - 2, 14);

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(28,2);
      System.out.print("> ");
      Text.go(28,4);
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
    boolean hasWon = false;
    boolean hasLost = false;
    int deadEnemies = 0;
    int deadParty = 0;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int target = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    String action = "";
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
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack(a)/special(sp)/support(su #)/quit(q)";
    TextBox(26,2,WIDTH,1,preprompt);

    while (!(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) && !hasWon && !hasLost) {
      //Read user input

      input = userInput(in).toLowerCase();
      while ((! (input.equals("a") || input.equals("attack"))) &&
                (! (input.equals("sp") || input.equals("special"))) &&
                (! (input.startsWith("su ") || input.startsWith("support "))) &&
                (! (input.startsWith("q") || input.startsWith("quit"))) &&
                partyTurn) {
        TextBox(26,2,WIDTH,1,"Invalid entry, please try again: attack(a)/special(sp)/support(su #)/quit(q)");
        input = userInput(in).toLowerCase();
      }

      if (!(input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) && partyTurn) {
        if (input.startsWith("su ") || input.startsWith("support ")) {
          String[] parts = input.split(" ");
          if (parts.length < 2 || parts[1].isEmpty() || (parts[1].charAt(0) < 48 || parts[1].charAt(0) > 57)) {
            TextBox(26, 2, WIDTH, 3, "Invalid command. Please properly specify who to support: support # (su #)");
            continue;
          }
          target = Integer.parseInt(parts[1]);
          if (target < 0 || target >= party.size()) {
            TextBox(26, 2, WIDTH, 3, "Invalid target. Choose a valid party member index to support: support # (su #).");
            continue;
          } else if (party.get(target).isDead() && !(party.get(whichPlayer) instanceof Priest)) {
            TextBox(26, 2, WIDTH, 3, "The selected target is dead, " + party.get(whichPlayer).getName() + " is unable to support them: support # (su #).");
            continue;
          }
        }

        if (partyTurn && (input.equals("a") || input.equals("attack") || input.equals("sp") || input.equals("special"))) {
          TextBox(26,2,WIDTH,1,"Please select a target using a valid integer index");
          String input2 = userInput(in);
          while (input2.length() > 0 && (input2.charAt(0) < 48 || input2.charAt(0) > 57)) {
            TextBox(26, 2, WIDTH, 3, "Invalid command. Please properly specify target");
            input2 = userInput(in);
          }
          target = Integer.parseInt(input2);
          while (target >= enemies.size() || target < 0 || enemies.get(target).isDead()) {
            if (target >= enemies.size() || target < 0) {
              TextBox(26,2,WIDTH,1,"Invalid target. Choose a valid party member index.");
            }
            else {
              TextBox(26,2,WIDTH,1,"The selected target is dead, please reselect a target.");
            }
            input2 = userInput(in);
            while (input2.length() > 0 && (input2.charAt(0) < 48 || input2.charAt(0) > 57)) {
              TextBox(26, 2, WIDTH, 3, "Invalid command. Please properly specify target");
              input2 = userInput(in);
            }
            target = Integer.parseInt(input2);
          }
        }
      }


      //example debug statment
      TextBox(6,2,80,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          action = party.get(whichPlayer).attack(enemies.get(target)) + checkForDead(enemies,target);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          action = party.get(whichPlayer).specialAttack(enemies.get(target)) + checkForDead(enemies,target);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          if (target == whichPlayer) {
            action = party.get(whichPlayer).support();
          } else {
            action = party.get(whichPlayer).support(party.get(target));
          }
        }
        addHistory(action);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

        if (enemies.get(target).isDead()) {
          if (enemies.get(target).hasSecondPhase == true) {
            enemies.remove(0);
            enemies.add(new Boss2("Big Cheese, DoW"));
            for (Adventurer a : party) {
              a.setPoisoned2(false);
            }
          }
          else {
            deadEnemies++;
            if (deadEnemies == enemies.size()) {
              hasWon = true;
            }
          }
        }
        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack(a)/special(sp)/support(su #)/quit(q)";
          TextBox(26,2,WIDTH,1,prompt);


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "Press Enter to see enemy's turn: ";
          TextBox(26,2,WIDTH,1,prompt);
          partyTurn = false;
          whichPlayer = 0;
        }
        //done with one party member
      }else if(!partyTurn && whichOpponent < enemies.size()) {
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        Adventurer currentEnemy = enemies.get(whichOpponent);
        if (currentEnemy.isDead()) {
          addHistory(currentEnemy.getName() + " has been defeated and cannot act.");
        } else {
          int move = (int)(Math.random() * 3);
          if (move == 0 || move == 1) {
            Adventurer randParty = getValidTarget(party);
            if (move == 0) {
              action = currentEnemy.attack(randParty)+checkForDead(party,party.indexOf(randParty));
            } else {
              action = currentEnemy.specialAttack(randParty)+checkForDead(party,party.indexOf(randParty));
            }
            if (randParty.isDead()) {
              deadParty++;
              if (deadParty == party.size()) {
                hasLost = true;
              }
            }
          } else if (move == 2) {
            Adventurer randEnemy = getValidTarget(enemies);
            if (randEnemy == currentEnemy) {
              action = currentEnemy.support();
            } else {
              action = currentEnemy.support(randEnemy);
            }
          }
          addHistory(action);
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

        //Decide where to draw the following prompt:
        if (whichOpponent + 1 != enemies.size()) {
          String prompt = "Press Enter to see next enemy's turn: ";
          TextBox(26,2,WIDTH,1,prompt);
        }
        else {
          String prompt = "Press Enter to complete the turn: ";
          TextBox(26,2,WIDTH,1,prompt);
        }
        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      else {
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichOpponent = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String result = "";
        for (int x = 0; x < enemies.size(); x++) {
          Adventurer a = enemies.get(x);
          result += a.applyStatusEffects();
          if (!checkForDead(enemies, x).isEmpty()) {
            deadEnemies++;
          } else {
            a.restoreSpecial(1);
          }
          result += checkForDead(enemies, x);
        }

        if (deadEnemies == enemies.size()) {
          hasWon = true;
        }

        for (int x = 0; x < party.size(); x++) {
          Adventurer a = party.get(x);
          result += a.applyStatusEffects();
          if (!checkForDead(party, x).isEmpty()) {
            deadParty++;
          } else {
            a.restoreSpecial(1);
          }
          result += checkForDead(party, x);
        }

        if (deadParty == party.size()) {
          hasLost = true;
        }

        result += "\nAll players gain 1 special.";
        addHistory(result);

        String prompt = "Enter command for "+party.get(whichPlayer)+": attack(a)/special(sp)/support(su #)/quit(q)";
        TextBox(26, 2, WIDTH, 1, prompt);
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop

    if (hasWon == true) {
      screens.win();
      Text.wait(1000);
    }
    else if (hasLost == true) {
      screens.lose();
      Text.wait(1000);
    }
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

  private static Adventurer getValidTarget(ArrayList<Adventurer> team) {
    int randIndex = (int)(Math.random() * team.size());
    while (team.get(randIndex).isDead()) {
      randIndex = (int)(Math.random() * team.size());
    }
    return team.get(randIndex);
  }

  public static String checkForDead (ArrayList<Adventurer> team, int target) {
    Adventurer current = team.get(target);
    if (current.isDead() && !current.deathCounted) {
      current.deathCounted = true;
      if (current.hasSecondPhase) {
        return "\n" + current.getName() + " has been defeated, entering Phase 2!\nLittle Cheese's poison effects have been lifted.";
      }
      return "\n" + current.getName() + " has been defeated.";
    }
    return "";
  }

}
