import java.util.*;
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

  public String attack(Adventurer other) {
    int dmg = 4;
    if (hasBuff) {
      dmg += 2;
      hasBuff = false;
    }
    String result = this + " channels a bolt of arcane energy, casting Arcane Bolt on " + other + " for "
    + dmg + " damage.";
    result += other.applyStatusEffects(dmg, this);
    return result;
  }

  public boolean isAoe(String move) {
    return move.equalsIgnoreCase("special") || move.equalsIgnoreCase("sp");
  }

  public String specialAttack(ArrayList<Adventurer> enemies, ArrayList<Adventurer> allies) {
    if (this.getSpecial() < 6) {
      return this + " attempts to unleash Arcane Nova but lacks sufficient mana.";
    }
    setSpecial(mana - 6);
    String result = this + " harnesses immense magical power to unleash Arcane Nova!\n";
    result += "The explosion resonates across the battlefield, dealing 6 damage to all enemies and 1 damage to all other allies.\n";
    for (Adventurer enemy : enemies) {
      int dmg = 6;
      result += enemy.applyStatusEffects(dmg, this);
      if (Math.random() < 0.3) {
        enemy.setStunned(true);
        result += enemy + " is stunned by the following shockwave!\n";
      }
    }
    for (Adventurer ally : allies) {
      if (ally != this && !ally.isDead()) {
        ally.applyDamage(1);
        result += ally + " is caught in the blast and takes 1 damage.\n";
      }
    }
    return result;
  }

  public String specialAttack(Adventurer other) {
    return specialAttack(enemies, allies);
  }

  public String support(Adventurer other) {
    if (mana >= 4) {
      setSpecial(mana - 4);
      if (other.getShieldStrength() < 6) {
        other.shieldStrength = 6;
        return this + " weaves together magical currents to form an Arcane Shield, enveloping " + other + " in an opalescent barrier that absorbs 6 damage.";
      } else {
        return this + " casts Arcane Shield on " + other + ", but their existing shield is already at maximum strength.";
      }
    } else {
      return this + " attempted to Arcane Shield on " + other + " but had insufficient mana.";
    }
  }

  public String support() {
    int restored = restoreSpecial(2);
    hasBuff = true;
    return this + " channels Mana Surge, restoring " + restored + " Mana and gaining a +2 damage atk buff.";
  }

}
