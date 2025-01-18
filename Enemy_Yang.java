import java.util.*;
public class Enemy_Yang extends Adventurer {
  int sunEnergy, sEMax;

  public Enemy_Yang(String name, int hp){
    super(name,hp);
    sEMax = 8;
    sunEnergy = sEMax;
  }

  public Enemy_Yang(String name){
    this(name,18);
  }

  public Enemy_Yang(){
    this("Yang");
  }

  public String getSpecialName(){
    return "Sun Energy";
  }

  public int getSpecial(){
    return sunEnergy;
  }

  public void setSpecial(int n){
    sunEnergy = n;
  }

  public int getSpecialMax(){
    return sEMax;
  }

  public String attack(Adventurer other) {
    other.applyStatusEffects(2,this);
    return this + " manifests a blade of light, stabbing " + other + " and dealing 2 dmg.";
  }

// Maybe put the insufficient special in game.java instead, prompting the player to put in a new input
  public String specialAttack(ArrayList<Adventurer> enemies){
    if (getSpecial() >= 4) {
      for (int x = 0; x < enemies.size(); x++) {
        enemies.get(x).setWeakened(true);
      }
      setSpecial(getSpecial() - 4);
      return this + " casts Heavenly Jurisdiction, entering all enemies in the field of effect into a weakened state, now taking 2x the damage on the next hit!";
    }
    else {
      return this + " attempted to cast Heavenly Jurisdiction but has insufficient Sun Energy!";
    }
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies);
  }

  public String support(Adventurer other){
    if (getSpecial() >= 4) {
      other.setStrengthened(true);
      setSpecial(getSpecial() - 4);
      return this + " bestows the Sun's blessing upon " + other + ", imbuing them with Sun Energy and allowing their next attack to deal 2x damage!";
    }
    else {
      return this + " attempted to apply the Sun's blessing on " + other + " but has insufficient Sun Energy!";
    }
  }

  public String support(){
    yangHasBuff = true;
    return this + " is imbued with the energy of the heavens, increasing their speed, now having a 30% chance to dodge the next enemy attack!";
  }
}
