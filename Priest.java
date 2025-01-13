import java.util.*;

public class Priest extends Adventurer {
  int faith, faithMax;
  boolean hasDebuff;

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
    return "faith";
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

  // Deals 2 points of damage to all enemies -- > requires an ArrayList of foes
  public String attack(ArrayList<Adventurer> enemies){
    for (int x = 0; x < enemies.size(); x++) {
      enemies.get(x).applyDamage(2);
    }
    return this + " casts Light Arrows, raining light from the sky and dealing 2 damage to each enemy.";
  }

  public String attack(Adventurer other) {
    return attack(enemies);
  }

// Maybe put the insufficient special in game.java instead, prompting the player to put in a new input
  public String specialAttack(ArrayList<Adventurer> enemies, Adventurer other){
    int dmg = 2 * enemies.size();
    if (getSpecial() >= 4) {
      other.applyDamage(dmg);
      other.isBurning = true;
      setSpecial(getSpecial() - 4);
      return this + " casts Divine Judgement, harnessing the flames of judgement to burn opponents, dealing "
        + dmg + " to " + other + " and inflicts them with Burning.";
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
      other.isDead = false;
      setSpecial(getSpecial() - 8);
      other.setHP(getmaxHP() / 2);
      hasDebuff = true;
      return this + " resurrects " + other + ", bringing back the ally in a weakened state! A debuff has been applied, taking 2x damage, for interfering with the order of life.";
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
