import java.util.*;

public class Priest extends Adventurer {
  int faith, faithMax;

  public Priest(String name, int hp){
    super(name,hp);
    faithMax = 12;
    faith = faithMax;
  }

  public Priest(String name){
    this(name,30);
  }

  public Priest(){
    this("Léopoldine Goyathlay");
  }

  public String getSpecialName(){
    return "Faith";
  }

  public int getSpecial(){
    return faith;
  }

  public void setSpecial(int n){
    faith = n;
  }

  public int getSpecialMax(){
    return faithMax;
  }

  public boolean isAoe(String move) {
    return move.equalsIgnoreCase("attack") || move.equalsIgnoreCase("a");
  }

  // Deals 2 points of damage to all enemies -- > requires an ArrayList of foes
  public String attack(ArrayList<Adventurer> enemies){
    String result = this + " casts Light Arrows, raining light from the sky and dealing 2 damage to each enemy.";
    for (int x = 0; x < enemies.size(); x++) {
      if (!enemies.get(x).isDead()) {
        result += enemies.get(x).applyStatusEffects(2,this);
      }
    }
    return result;
  }

  public String attack(Adventurer other) {
    return attack(enemies);
  }

// Maybe put the insufficient special in game.java instead, prompting the player to put in a new input
  public String specialAttack(ArrayList<Adventurer> enemies, Adventurer other){
    int dmg = 2 * enemies.size();
    if (getSpecial() >= 4) {
      String result = this + " casts Divine Judgement, harnessing the flames of judgement to burn opponents, dealing "
        + dmg + " dmg to " + other + " and inflicts them with Burning.";
      result += other.applyStatusEffects(dmg,this);
      other.setBurning(true);
      setSpecial(getSpecial() - 4);
      return result;
    }
    else {
      return this + " attempted to cast Divine Judgement on " + other + " but has insufficient faith!";
    }
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies, other);
  }

  public String support(Adventurer other){
    if (getSpecial() >= 8) {
      if (other.isDead()) {
        setSpecial(getSpecial() - 8);
        other.setHP(getmaxHP() / 2);
        setWeakened(true);
        return this + " resurrects " + other + ", bringing back the ally in a weakened state! A debuff has been applied, taking 2x damage, for interfering with the order of life.";
      }
      return other + " is still alive and cannot be resurrected!";
    }
    else {
      return this + " attempted to resurrect " + other + " but has insufficient faith!";
    }
  }

  public String support(){
    restoreSpecial(3);
    return this + " uses Prayer, gaining 3 Faith!";
  }
}
