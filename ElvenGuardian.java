public class ElvenGuardian extends Adventurer{
  int elementEnergy, EEMax;
  boolean hasBuff;

  public ElvenGuardian(String name, int hp){
    super(name,hp);
    EEMax = 6;
    elementEnergy = EEMax;
  }

  public ElvenGuardian(String name){
    this(name,45);
  }

  public ElvenGuardian(){
    this("Thalindor Aegisheart");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Elemental Energy";
  }

  public int getSpecial(){
    return elementEnergy;
  }

  public void setSpecial(int n){
    elementEnergy = n;
  }

  public int getSpecialMax(){
    return EEMax;
  }

  public String attack(Adventurer other){
    int damage = 2 + (2*(3-allies.size()));
    String result;
    if (hasBuff) {
      result = this + " slashes at " + other + " in a strengthend state with their broadsword, dealing " + damage + " damage!";
      result += other.applyStatusEffects(damage*2, this);
      hasBuff = false;
      return result;
    }
    else {
      result = this + " slashes at " + other + " with their broadsword, dealing " + damage + " damage!"
      result += other.applyStatusEffects(damage, this);
      return result;
    }
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 4) {
      other.hasElvenDebuff = true;
      setSpecial(getSpecial() - 4);
      return this + " casts Nature's Illusions, muddying " + other + "\'s judgement and decreasing their accuracy, causing a 30% chance of missing their next attack!";
    }
    else {
      return this + " attempted to cast Nature's Illusions on " + other + " but has insufficient Elemental Energy!";
    }
  }


  public String support(Adventurer other){
    if (elementEnergy >= 2) {
      setSpecial(elementEnergy - 2);
      int amount = 2;
      if (getHP() + 3 > getmaxHP()) {
        setHP(getmaxHP());
      }
      else {
        setHP(getHP() + 3);
      }
      return this + " grants " + other + " Nature's Elixir, filling them with power and allowing them to reover 2 HP.";
    }
    else {
      return this + " attempted to provide " + other + " with Nature's Elixer, but has insufficient Elemental Energy!";
    }
  }

  public String support(){
    if (getSpecial() >= 2) {
      hasBuff = true;
      setSpecial(getSpecial() - 2);
      return this + " is filled with the will to protect their allies, becoming strengthened and dealing 2x damage in the next turn!";
    }
    else {
      return this + " is unable to become strengthened, lacking sufficient Elemental Energy.";
    }
  }
}
