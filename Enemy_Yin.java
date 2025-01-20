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
    String result = this + " converges the moonlight into a Lunar Blade, striking " + other + " for " + dmg + " damage.";
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
      result += this + "'s wounds mend as the Whispers of the Dead restore " + recovered + " HP from their attack.";
    }
    return result;
  }

  public String specialAttack(ArrayList<Adventurer> enemies) {
    if (moonEnergy >= 5) {
      int dmg = 5;
      String result = this + " invokes Moon's Descent, shrouding the battlefield in an ethereal darkness that deals " + dmg + " damage to all enemies.";
      setSpecial(moonEnergy - 5);
      for (Adventurer enemy : enemies) {
        result += enemy.applyStatusEffects(dmg,this);
      }
      return result;
    } else {
      return this + " calls upon the moon, attempting to unleash Moon's Descent, but lacks sufficient Moon Energy.";
    }
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies);
  }


  public String support(Adventurer other) {
    if (moonEnergy >= 3) {
      setSpecial(moonEnergy - 3);
      other.rageMode = true;
      return this + " channels the heavens' blessing into " + other + ", endowing them with Celestial Protection which reduces incoming damage by 30% for the next hit.";
    } else {
      return this + " attempts to grant Celestial Protection to " + other + " but lacks sufficient Moon Energy.";
    }
  }

  public String support(){
    hasBuff = true;
    return this + " attunes to the Whispers of the Dead, harnessing their energy to heal themselves for 50% of the damage dealt by their next attack.";
  }

}
