public class Boss2 extends Adventurer{
  int evilDairy, evilDairyMax;

  public Boss2(String name, int hp){
    super(name,hp);
    evilDairyMax = 15;
    evilDairy = evilDairyMax;
  }

  public Boss2(String name){
    this(name,60);
  }

  public Boss2(){
    this("Big Cheese the Destroyer of Worlds");
  }

  public String getSpecialName(){
    return "Evil Dairy";
  }

  public int getSpecial(){
    return evilDairy;
  }

  public void setSpecial(int n){
    evilDairy = n;
  }

  public int getSpecialMax(){
    return evilDairyMax;
  }

  public String attack(Adventurer other) {
    int dmg = (int)(Math.random() * 8) + 1;
    return this + "TBD, dealing " + dmg + " to " + other + "!";
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 5) {
      other.applyDamage(5);
      other.hasCheeseMark = true;
      setSpecial(getSpecial() - 5);
      return this + " uses Mark of Vengeance, leaving a curse on " + other
        + " that will consume 50% of their special on the next attack and dealing 5 dmg.";
    }
    else {
      return this + " attempted to use Mark of Vengeance on " + other + " but has insufficient Evil Dairy!";
    }
  }

  public String support(){
    if (getHP() + 10 < getmaxHP()) {
      setHP(getHP() + 10);
    }
    else {
      setHP(getmaxHP());
    }
    if ((int)(Math.random() * 2) == 1) {
      if (getSpecial() - 2 < 0) {
        setSpecial(0);
      }
      else {
        setSpecial(getSpecial() - 2);
      }
      return this + " uses TBD, recovering 10 HP but loses 2 Evil Dairy!";
    }
    else {
      restoreSpecial(2);
      return this + " uses TBD, recovering 10 HP and 2 Evil Dairy!";
    }
  }

  public String support(Adventurer other){
    return "";
  }
}
