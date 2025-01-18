public class Enemy_DrunkGoblin extends Adventurer {
  int Booze, BoozeMax;

  public Enemy_DrunkGoblin(String name, int hp){
    super(name,hp);
    BoozeMax = 5;
    Booze = BoozeMax;
  }

  public Enemy_DrunkGoblin(String name){
    this(name, 15);
  }

  public Enemy_DrunkGoblin(){
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
    other.setWeakened(true);
    return this + " applies Alcohol Poisoning on " + other + ", causing them to take 2x damage on the next hit.";
  }

  public String specialAttack(Adventurer other) {
    if (Booze >= 4) {
      setSpecial(Booze - 4);
      other.setPoisoned(true);
      // need to set number of turns as 2
      return this + " forces " + other + " to drink their Special Blend, leaving them poisioned for 2 turns.";
    } else {
      return this + " tried to force feed " + other + " with their Special Blend, but doesn't have enough Booze.";
    }
  }

  public String support(Adventurer other) {
    if (Booze >= 1) {
      other.setHasDGStrengthed(true);
      setSpecial(Booze - 1);
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
          if (getHP() + 2 > getmaxHP()) {
            setHP(getmaxHP());
          }
          else {
            setHP(getHP() + 2);
          }
        return this + " takes a swig of their Drink, recovering " + amount + " HP.";
      } else {
        applyDamage(2);
        return this + " takes a swig of their Drink, losing " + amount + " HP.";
      }
    } else {
      return this + " wanted to Drink, but didn't have enough booze.";
    }
  }

}
