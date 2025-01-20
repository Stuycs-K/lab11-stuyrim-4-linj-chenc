public class Boss1 extends Adventurer {
  int dairy, dairyMax;

  public Boss1(String name, int hp){
    super(name,hp);
    dairyMax = 15;
    dairy = dairyMax - 2;
    hasSecondPhase = true;
  }

  public Boss1(String name){
    this(name, 30);
  }

  public Boss1(){
    this("Little Cheese");
  }

  public String getSpecialName(){
    return "Dairy";
  }

  public int getSpecial(){
    return dairy;
  }

  public int getSpecialMax(){
    return dairyMax;
  }

  public void setSpecial(int n){
    dairy = Math.min(n, dairyMax);
  }

  public String attack(Adventurer other) {
    int dmg = 1;
    String result = this + " uses Cheese Chuck, dealing " + dmg + " damage to " + other + ".";
    result += other.applyStatusEffects(dmg,this);
    return result;
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 5) {
      other.setPoisoned(true);
      setSpecial(getSpecial() - 5);
      return this + " used Spoiled Milk on " + other +
        ", poisioning them. The poision will deal 1 damage per turn.";
    }
    else {
      return this + " tried to use Spoiled Milk on " + other + " but lacked Dairy.";
    }
  }

  public String support(){
    int recovered = (int)(Math.random() * 4);
    setSpecial(dairy + recovered);
    return this + " ate some cheese and recovered " + recovered + " Dairy.";
  }

  public String support(Adventurer other){
    return "";
  }

}
