import java.util.*;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  boolean isStunned, isBurning, isPoisoned, isPoisoned2, isWeakened, isStrengthened;
  boolean yangHasBuff, rageMode, hasDGStrengthed, hasElvenDebuff, hasCheeseMark, hasSecondPhase;
  int shieldStrength, burnDuration, poisonDuration;
  ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
  ArrayList<Adventurer> allies = new ArrayList<Adventurer>();

  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(Adventurer other);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);

  /*
  standard methods
  */

  public void setStunned(boolean stunned) {
    this.isStunned = stunned;
  }

  public boolean isStunned() {
    return isStunned;
  }

  public void setBurning(boolean burning) {
    this.isBurning = burning;
  }

  public boolean isBurning() {
    return isBurning;
  }

  public void setPoisoned(boolean poisoned) {
    this.isPoisoned = poisoned;
  }

  public void setPoisoned2(boolean poisoned) {
    this.isPoisoned2 = poisoned;
  }

  public boolean isPoisoned() {
    return isPoisoned;
  }

  public boolean isPoisoned2() {
    return isPoisoned2;
  }

  public void setWeakened(boolean weakened) {
    this.isWeakened = weakened;
  }

  public boolean isWeakened() {
    return isWeakened;
  }

  public void setStrengthened(boolean Strengthened) {
    this.isStrengthened = Strengthened;
  }

  public void setHasDGStrengthed(boolean strengthend) {
    this.hasDGStrengthed = strengthend;
  }

  public int getShieldStrength() {
    return shieldStrength;
  }

  public boolean isDead() {
    return HP <= 0;
  }

  public String applyDamage(int amount, Adventurer other){
    String result = "";
    if (this.shieldStrength > 0) {
      int shielded = Math.min(amount, this.shieldStrength);
      this.shieldStrength -= shielded;
      amount -= shielded;
      result = result + "\n" + getName() + "'s shield absorbed " + shielded + " damage.";
    }
    if (other.isStrengthened) {
      amount = amount *2;
      result = result + "\n" + getName() + " has received the Blessing of the Sun, dealing 2x the damage!";
      setStrengthened(false);
    }
    if (other.hasElvenDebuff) {
      if ((int)(Math.random() * 100) + 1 > 30) {
        amount = 0;
        result = result + "\n" + other.getName() + " has muddied judgement and misses, dealing no damage.";
      }
      hasElvenDebuff = false;
    }
    if (this.hasDGStrengthed) {
      amount = (int)(amount * 1.5);
      result = result + "\n" + getName() + " is bolstered by encouragement and alchohol, increasing their damage 1.5x!";
      setHasDGStrengthed(false);
    }
    if (amount > 0) {
      this.HP -= amount;
    }
    if (HP <= 0) {
      HP = 0;
    }
    return result;
  }

  public void applyDamage(int amount){
    if (amount > 0) {
      this.HP -= amount;
    }
    if (HP <= 0) {
      HP = 0;
    }
  }

  public String applyStatusEffects() {
    String result = "";
    if (isBurning()) {
      applyDamage(1);
      burnDuration++;
      result += "\n" + getName() + " takes 1 damage from burning.";
      if (burnDuration + 1 == 2) {
        result += "\n" + getName() + "\'s burning has lifted.";
        isBurning = false;
      }
    }
    if (isPoisoned()) {
      applyDamage(1);
      result += "\n" + getName() + " takes 1 damage from poison.";
      if (poisonDuration + 1 == 2) {
        result += "\n" + getName() + "\'s poisoning has lifted.";
        isPoisoned = false;
      }
      poisonDuration++;
    }
    if (isPoisoned2()) {
      applyDamage(1);
      result += "\n" + getName() + " takes 1 damage from poison.";
    }
    if (isStunned()) {
      result += "\n" + getName() + " is stunned and cannot act this turn.";
      setStunned(false);
    }
    if (isDead()) {
      result += "\n" + getName() + " cannot act, as they have already been defeated.";
    }
    return result;
  }

  public String applyStatusEffects(int dmg, Adventurer other) {
    String result = "";
    if (isWeakened()) {
      result = result + "\n" + getName() + " is weakened, taking 2x damage.";
      dmg = dmg * 2;
      setWeakened(false);
    }
    if (yangHasBuff) {
      if ((int)(Math.random() * 100) + 1 <= 30) {
        dmg = 0;
      }
      result = result + "\nYang has dodged the attack!";
      yangHasBuff = false;
    }
    if (rageMode) {
      dmg = (int)(dmg*0.7);
    }
    result = result + applyDamage(dmg, other);
    return result;
  }

  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

  //Set Methods
  public void setHP(int health){
    this.HP = health;
  }

  public void setName(String s){
    this.name = s;
  }
}
