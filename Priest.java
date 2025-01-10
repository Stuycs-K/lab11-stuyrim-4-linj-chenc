public class Priest extends Adventurer {
  int faith, faithMax;

  public Priest(String name, int hp){
    super(name,hp);
    faithMax = 12;
    faith = faithMax;
  }

  public Priest(String name){
    this(name,30);
  }

  public Priest(){
    this("Léopoldine Goyathlay");
  }

  public String getSpecialName(){
    return "faith";
  }

  public int getSpecial(){
    return faith;
  }

  public void setSpecial(int n){
    faith = n;
  }

  public int getSpecialMax(){
    return faithMax;
  }

  // Deals 2 points of damage to all enemies -- > requires an ArrayList of foes
  public String attack(ArrayList<Adventurer> enemies){
    for (int x = 0; x < enemies.size(); x++) {
      enemies.get(x).applyDamage(2);
    }
    return this + " casts Light Arrows, raining light from the sky and dealing 2 damage to each enemy.";
  }

  public String specialAttack(Adventurer other){

  }

  public String support(Adventurer other){

  }

  public String support(){

  }

}
