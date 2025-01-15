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
      hasBuff = false;
    }
    other.applyDamage(dmg);
    return this + " channels a bolt of arcane energy, casting Arcane Bolt on " + other + " for "
    + dmg + " damage.";
  }

  public String specialAttack(ArrayList<Adventuer> enemies, ArrayList<Adventurer> allies) {
    if (mana >= 6) {
      setSpecial(mana - 6);
      String result = this + " harnesses immense magical energy and unleashes Arcane Nova!\n";
      result += " The explosion resonates across the battlefield, dealing 6 damage to all enemies and 1 damage to all allies.";
      for (Adventurer enemy : enemies) {
        int dmg = 6;
        enemy.applyDamage(dmg);
        if (Math.random() < 0.3) {
          enemy.setStunned(true);
          result += enemy + " is stunned by the following shockwave!\n";
        }
      }
      for (Adventurer ally : alies) {
        if (!ally.isDead()) {
          ally.applyDamage(1);
          result += ally + " is caught in the blast and takes 1 damage.\n";
        }
      }
      return result;
    } else {
      return this + " attempts to unleash Arcane Nova but lacks sufficient mana.";
    }
  }

  public String support(Adventurer other) {
    if (mana >= 4) {
      setSpecial(mana - 4);
      return this + " casts Arcane Shield on " + other + ", granting a shield that absorbs 6 dmg.";
    } else {
      return this + " attempted to Arcane Shield on " + other + " but had insufficient mana.";
    }
  }

  public String support() {
    int restored = restoreSpecial(2);
    hasBuff = true;
    return this + " (some word) Mana Surge, restoring " + restored + " Mana and gaining a +2 damage atk buff.";
  }

}
