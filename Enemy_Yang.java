public class Enemy_Yang extends Adventurer {
  int TBD, TBDMax;

  public Enemy_Yang(String name, int hp){
    super(name,hp);
    TBDMax = 8;
    TBD = TBDMax;
  }

  public Enemy_Yang(String name){
    this(name,18);
  }

  public Enemy_Yang(){
    this("Yang");
  }

  public String getSpecialName(){
    return "TBD";
  }

  public int getSpecial(){
    return TBD;
  }

  public void setSpecial(int n){
    TBD = n;
  }

  public int getSpecialMax(){
    return TBDMax;
  }

  public String attack(Adventurer other) {
    other.applyStatusEffects(2);
    return this + " uses TBD, dealing 2 dmg to " + other + "!";
  }

// Maybe put the insufficient special in game.java instead, prompting the player to put in a new input
  public String specialAttack(ArrayList<Adventurer> enemies){
    if (getSpecial() >= 4) {
      for (int x = 0; x < enemies.size(); x++) {
        enemies.get(x).setWeakened(true);
      }
      setSpecial(getSpecial() - 4);
      return this + " casts TBD, weakening the enemy team, now taking 2x the damage on the next hit!"
    }
    else {
      return this + " attempted to cast TBD but has insufficient TBD!";
    }
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies);
  }

  public String support(Adventurer other){
    if (getSpecial() >= 4) {
      // Implement method of making ally's attack deal 2x damage
      setSpecial(getSpecial() - 4);
      return this + " shares __ energy with " + other + ", strengthening them and allowing their next attack to deal 2x damage!";
    }
    else {
      return this + " attempted to share __ energy with " + other + " but has insufficient energy!";
    }
  }

  public String support(){
    yangHasBuff = true;
    return this + " has used on themselves, increasing their speed, now having a 30% chance to dodge the next enemy attack!";
  }
}
