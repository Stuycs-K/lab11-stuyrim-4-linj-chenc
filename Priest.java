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

  public String attack(Adventurer other){

  }

  public String specialAttack(Adventurer other){

  }

  public String support(Adventurer other){

  }

  public String support(){

  }
  
}
