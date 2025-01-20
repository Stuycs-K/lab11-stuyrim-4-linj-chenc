import java.util.*;
public class Enemy_Yin extends Adventurer {
  int moonEnergy, moonEnergyMax;
  boolean hasBuff, allyHasBuff;

  public Enemy_Yin(String name, int hp){
    super(name,hp);
    moonEnergyMax = 10;
    moonEnergy = moonEnergyMax;
    hasBuff = false;
    allyHasBuff = false;
  }

  public Enemy_Yin(String name){
    this(name, 30);
  }

  public Enemy_Yin(){
    this("Yin");
  }

  public String getSpecialName(){
    return "Moon Energy";
  }

  public int getSpecial(){
    return moonEnergy;
  }

  public int getSpecialMax(){
    return moonEnergyMax;
  }

  public void setSpecial(int n){
    moonEnergy = Math.min(n, moonEnergyMax);
  }

  public String attack(Adventurer other) {
    int dmg = 3;
    String result = this + " (text), striking " + other + " for " + dmg + " damage.";
    result += other.applyStatusEffects(dmg, this);
    if (hasBuff) {
      int recovered = dmg / 2;
      if (getHP() + recovered < getmaxHP()) {
        setHP(getHP() + recovered);
      }
      else {
        setHP(getmaxHP());
      }
      hasBuff = false;
      result += this + "(text), recovering " + recovered + " HP.";
    }
    return result;
  }

  public String specialAttack(ArrayList<Adventurer> enemies) {
    if (moonEnergy >= 5) {
      String result = this + " unleashes (name), dealing 5 damage to all enemies.";
      setSpecial(moonEnergy - 5);
      for (Adventurer enemy : enemies) {
        int dmg = 5;
        result += enemy.applyStatusEffects(dmg,this);
      }
      return result;
    } else {
      return this + " attemped to unleash (name) but lacks sufficient Moon Energy.";
    }
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies);
  }


  public String support(Adventurer other) {
    if (moonEnergy >= 3) {
      setSpecial(moonEnergy - 3);
      other.rageMode = true;
      return this + " weaves together the stars, endowing " + other + " with Celestial Protection, reducing incoming damage by 30% for the next attack.";
    } else {
      return this + " attempts to grant Celestial Protection to " + other + " but lacks sufficient Moon Energy.";
    }
  }

  public String support(){
    hasBuff = true;
    return this + " harnesses (text), healing themselves for 50% of the damage dealt by their next attack.";
  }

}
