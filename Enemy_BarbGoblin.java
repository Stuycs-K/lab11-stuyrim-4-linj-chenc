public class Enemy_BarbGoblin extends Adventurer {
  int roastMeat, rMMax;

  public Enemy_BarbGoblin(String name, int hp){
    super(name,hp);
    rMMax = 4;
    roastMeat = rMMax;
  }

  public Enemy_BarbGoblin(String name){
    this(name,15);
  }

  public Enemy_BarbGoblin(){
    this("Barbarian Goblin");
  }

  public String getSpecialName(){
    return "Roast Meat";
  }

  public int getSpecial(){
    return roastMeat;
  }

  public void setSpecial(int n){
    roastMeat = n;
  }

  public int getSpecialMax(){
    return rMMax;
  }

  public String attack(Adventurer other) {
    if (rageMode && (int)(Math.random() * 2) == 1) {
      other.applyStatusEffects(6);
      return "Enraged, " + this + " swings a wooden club at " + other + " with fury, dealing 6 dmg!";
    }
    else {
      other.applyStatusEffects(4);
      return this + " attacks " + other + " with a wooden club, dealing 4 dmg!";
    }
    rageMode = false;
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() == 0) {
      rageMode = true;
      return this + " realizes that they are out of roast meat, enraging them, taking 30% less damage and now having a 50% chance to deal 1.5x damage on next turn.";
    }
    else {
      return this + " checks their supply of roast meat and is satisfied to find it not empty, failing to enter an enraged state.";
    }
  }

  public String support(Adventurer other){
    if (getSpecial() >= 1) {
      setSpecial(getSpecial - 1);
      if (other.getHP() + 2 >= other.getmaxHP()) {
        other.setHP(other.getmaxHP());
      }
      else {
        other.setHP(other.getHP() + 2);
      }
      return this + " shares a herbal roast with " + other + ", allowing them to gain 2 hp!";
    }
    else {
      return this + " attempted to share some herbal roast with " + other + " but is out of roast meat!";
    }
  }

  public String support(){
    if (getSpecial() >= 1) {
      setSpecial(getSpecial - 1);
      if (getHP() + 2 >= getmaxHP()) {
        setHP(getmaxHP());
      }
      else {
        setHP(getHP() + 2);
      }
      return this + " eats a piece herbal roast with delight, gaining 2 hp!";
    }
    else {
      return this + " attempted to eat some herbal roast but is out of roast meat!";
    }
  }
}
