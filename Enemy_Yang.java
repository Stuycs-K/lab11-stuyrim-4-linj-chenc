public class Enemy_Yang extends Adventurer {
  int TBD, TBDMax;

  public EnemyYang(String name, int hp){
    super(name,hp);
    TBDMax = 8;
    TBD = TBDMax;
  }

  public EnemyYang(String name){
    this(name,18);
  }

  public EnemyYang(){
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
    other.applyDamage(2);
    return this + " uses TBD, dealing 2 dmg to " + other + "!";
  }

// Maybe put the insufficient special in game.java instead, prompting the player to put in a new input
  public String specialAttack(ArrayList<Adventurer> enemies, Adventurer other){
    int dmg = 2 * enemies.size();
    if (getSpecial() >= 4) {
      other.isBurning = true;
      setSpecial(getSpecial() - 4);
      return this + " casts Divine Judgement, harnessing the flames of judgement to burn opponents, dealing "
        + dmg + " to " + other + " and inflicts them with Burning.";
    }
    else {
      return this + " attempted to cast TBD but has insufficient TBD!";
    }
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies, other);
  }

  public String support(Adventurer other){
    if (getSpecial() >= 8) {
      other.isDead = false;
      setSpecial(getSpecial() - 8);
      other.setHP(getmaxHP() / 2);
      hasDebuff = true;
      return this + " resurrects " + other + ", bringing back the ally in a weakened state! A debuff has been applied, taking 2x damage, for interfering with the order of life.";
    }
    else {
      return this + " attempted to resurrect " + other + " but has insufficient faith!";
    }
  }

  public String support(){
    restoreSpecial(3);
    return this + " uses Prayer, gaining 3 Faith!";
  }
}
