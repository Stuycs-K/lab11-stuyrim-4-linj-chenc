public class Enemy_DrunkGoblin extends Adventurer {
  int Booze, BoozeMax;
  boolean hasBuff, allyHasBuff;

  public Boss1(String name, int hp){
    super(name,hp);
    BoozeMax = 5;
    Booze = BoozeMax;
    hasBuff = false;
    allyHasBuff = false;
  }

  public Enemy_Yin(String name){
    this(name, 15);
  }

  public Enemy_Yin(){
    this("Drunk Goblin");
  }

  public String getSpecialName(){
    return "Booze";
  }

  public int getSpecial(){
    return Booze;
  }

  public int getSpecialMax(){
    return BoozeMax;
  }

  public void setSpecial(int n){
    Booze = Math.min(n, BoozeMax);
  }

  public String attack(Adventurer other) {
    other.hasBuff = true;
    return this + " applies Alcohol Poisoning on " + other + ", causing them to take 2x damage on the next hit.";
  }

  public String specialAttack(Adventurer other) {
    if (Booze >= 4) {
      setSpecial(Booze - 4);
      other.isPoisioned = true;
      // need to set number of turns as 2
      return this + " forces " + other + " to drink their Special Blend, leaving them poisioned for 2 turns.";
    } else {
      return this + " tried to force feed " + other + " with their Special Blend, but doesn't have enough Booze.";
    }
  }

  public String support(Adventurer other) {
    if (Booze >= 1) {
      setSpecial(Booze - 1);
      other.allyHasBuff = true;
      return this + " offers Encouraging Words and a bottle of booze to " + other + ", buffing their next attack to deal 1.5x damage.";
    } else {
      return this + " tried to offer Encouraging Words and a drink to " + other + " but doesn't have enough Booze.";
    }
  }

  public String support(){
    if (Booze >= 1) {
      setSpecial(Booze - 1);
      int amount = 2;
      if (Math.random() < 0.5) {
        setHP(getHP() + amount);
        return this + " takes a swig of their Drink, recovering " + amount + " HP.";
      } else {
        setHP(getHP() - amount);
        return this + " takes a swig of their Drink, losing " + amount + " HP.";
      }
    } else {
      return this + " wanted to Drink, but didn't have enough booze.";
    }
  }

}
