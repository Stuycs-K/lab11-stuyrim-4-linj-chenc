import java.util.*;
public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  boolean isStunned, isBurning, isPoisoned, isWeakened, isStrengthened;
  boolean yangHasBuff, rageMode, hasDGStrengthed, hasElvenDebuff, hasCheeseMark;
  int shieldStrength;
  ArrayList<Adventurer> enemies, allies;

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

  public boolean isPoisoned() {
    return isPoisoned;
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

  public void applyDamage(int amount, Adventurer other){
    if (other.shieldStrength > 0) {
      int shielded = Math.min(amount, shieldStrength);
      shieldStrength -= shielded;
      amount -= shielded;
      System.out.println(getName() + "'s shield absorbed " + shielded + " damage.");
    }
    if (other.isStrengthened) {
      amount = amount *2;
      System.out.println(getName() + " has received the Blessing of the Sun, dealing 2x the damage!");
      setStrengthened(false);
    }
    if (other.hasDGStrengthed) {
      amount = (int)(amount * 1.5);
      System.out.println(getName() + " is bolstered by encouragement and alchohol, increasing their damage 1.5x!");
      setHasDGStrengthed(false);
    }
    if (amount > 0) {
      this.HP -= amount;
    }
    if (HP <= 0) {
      HP = 0;
      System.out.println(getName() + " has been defeated.");
    }
  }

  public void applyDamage(int amount){
    if (amount > 0) {
      this.HP -= amount;
    }
    if (HP <= 0) {
      HP = 0;
      System.out.println(getName() + " has been defeated.");
    }
  }

  public void applyStatusEffects() {
    if (isBurning()) {
      applyDamage(1);
      System.out.println(getName() + " takes 1 damage from burning.");
    }
    if (isPoisoned()) {
      applyDamage(1);
      System.out.println(getName() + " takes 1 damage from poision.");
    }
    if (isStunned()) {
      System.out.println(getName() + " is stunned and cannot act this turn.");
      setStunned(false);
    }
    if (isDead()) {
      System.out.println(getName() + " cannot act, as they have already been defeated.");
    }
  }

  public void applyStatusEffects(int dmg, Adventurer other) {
    if (isWeakened()) {
      applyDamage(dmg * 2, other);
      System.out.println(getName() + " is weakened, taking 2x damage.");
    }
    if (yangHasBuff) {
      if ((int)(Math.random() * 100) + 1 > 30) {
        applyDamage(dmg, other);
      }
      yangHasBuff = false;
    }
    if (rageMode) {
      applyDamage((int)(dmg * 0.7), other);
    }
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
