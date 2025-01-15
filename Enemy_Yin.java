public class Enemy_Yin extends Adventurer {
  int moonEnergy, moonEnergyMax;
  boolean hasBuff, allyHasBuff;

  public Boss1(String name, int hp){
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
    return "moonEnergy";
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
    other.applyDamage(dmg);
    if (hasBuff) {
      int recovered = dmg / 2;
      setHP(getHP() + recovered);
      hasBuff = false;
      return this + "";
    }
    return this + "";
  }

  public String specialAttack(ArrayList<Adventuer> enemies) {
    if (moonEnergy >= 5) {
      setSpecial(moonEnergy - 5);
      for (Adventurer enemy : enemies) {
        int dmg = 5;
        enemy.applyDamage(dmg);
      }
      return this + "";
    } else {
      return this + "";
    }
  }

  public String support(Adventurer other) {
    if (moonEnergy >= 3) {
      setSpecial(moonEnergy - 3);
      other.set
    }
  }

  public String support(){
    hasBuff = true;
    return this + "";
  }

}
