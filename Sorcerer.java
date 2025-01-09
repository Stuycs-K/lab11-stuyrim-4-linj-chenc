public class Sorcerer extends Adventurer {
  int mana, manaMax;
  boolean hasBuff;

  public Sorcerer(String name, int hp) {
    super(name, hp);
    manaMax = 10;
    mana = manaMax;
    hasBuff = false;
  }

  public Sorcerer(String name) {
    this(name, 25);
  }

  public Sorcerer() {
    this("Veca Anouk");
  }

  public String getSpecialName() {
    return "Mana";
  }

  public int getSpecial() {
    return mana;
  }

  public int getSpecialMax() {
    return manaMax;
  }

  public void setSpecial(int n) {
    this.mana = Math.min(n, manaMax);
  }

  public String attack(Adventuer other) {
    int dmg = 4;
    if (hasBuff) {
      dmg += 2;
    }
    other.applyDamage(dmg);
    hasBuff = false;
    return this + " unleashes an arcane bolt on " + other + " dealing "
    + dmg +
  }

}
