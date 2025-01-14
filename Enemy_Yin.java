public class Enemy_Yin extends Adventurer {
  int TBD, TBDMax;
  boolean hasBuff, allyHasBuff;

  public Boss1(String name, int hp){
    super(name,hp);
    TBDMax = 10;
    TBD = TBDMax;
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
    return "TBD";
  }

  public int getSpecial(){
    return TBD;
  }

  public int getSpecialMax(){
    return TBDMax;
  }

  public void setSpecial(int n){
    TBD = Math.min(n, TBDMax);
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
    if (TBD >= 5) {
      setSpecial(TBD - 5);
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
    if (TBD >= 3) {
      setSpecial(TBD - 3);
      other.set
    }
  }

  public String support(){
    hasBuff = true;
    return this + "";
  }

}
