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
    int dmg = (int)(Math.random() * 4) + 5;
    String result = other.applyStatusEffects(dmg, this);
    if (other.hasCheeseMark == true) {
      other.setSpecial((int)(getSpecial() * 0.5));
      result += other + " has lost 50% of their special due to a curse!";
      other.hasCheeseMark = false;
    }
    return this + " chucks a colossally large chunk of cheese, dealing " + dmg + " damage to " + other + "!" + result;
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 5) {
      String result = this + " uses Mark of Vengeance, leaving a curse on " + other
        + " that will consume 50% of their special on the next attack and dealing 5 dmg.";
      result += other.applyStatusEffects(5, this);
      other.hasCheeseMark = true;
      setSpecial(getSpecial() - 5);
      return result;
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
      return this + " devours their secret cheese stash, recovering 10 HP but loses 2 Evil Dairy!";
    }
    else {
      restoreSpecial(2);
      return this + " devours their secret cheese stash and discovers there is even more cheese, recovering 10 HP and 2 Evil Dairy!";
    }
  }

  public String support(Adventurer other){
    return "";
  }
}
