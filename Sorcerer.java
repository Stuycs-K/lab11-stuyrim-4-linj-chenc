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
    return this + " casts an arcane bolt on " + other + ", dealing "
    + dmg + " damage.";
  }

  public String specialAttack(Adventurer other) {
    if (mana >= 6) {
      setSpecial(mana - 6);
      int dmg = 6;
      //arraylist later other.applyDamage(dmg);
      boolean isStunned = Math.random() < 0.3;
      String result = this + " unleashed Arcane Nova, dealing " + damage + ""
    }

  public String support(Adventurer other) {
    if (mana >= 4) {
      setSpecial(mana - 4);
      return this + " cast Arcane Shield on " + other + ", granting a shield that absorbs 6 dmg."
    } else {
      return this + " attempted to Arcane Shield on " + other + " but had insufficient mana.";
    }
  }

  public String support() {
    int restored = restoreSpecial(2);
    hasBuff = true;
    return this + " (some word) Mana Surge, restoring " + restored + " Mana and gaining a +2 dmg atk buff.";
  }

}
