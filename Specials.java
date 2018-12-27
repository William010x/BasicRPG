//Specials class
//Programmed By: William San
//Last Modified: 1/21/16
//Creates Special moves objects, which hold info on its properties
public class Specials
{
  private String name;            //name of the special move
  private String type;            //what type of damage the move deals (ATK or MAG)
  private int cost;               //MP cost to use special move
  private int damage;             //Amount of damage dealt by special move
  
  //Creates special move as an object
  //name2 - Name of special being learned
  //type2 - Damage type of special being learned
  //cost2 - MP cost of special being learned
  //damage2 - Damage dealt by special being learned
  public Specials (String name2, String type2, int cost2, int damage2)
  {
    name = name2;
    type = type2;
    cost = cost2;
    damage = damage2;
  }
  
  //Returns name of special
  public String getName()
  {
    return name;
  }
  
  //Returns type of special
  public String getType()
  {
    return type;
  }
  
  //Returns MP cost of special
  public int getCost()
  {
    return cost;
  }
  
  //Returns damage of special
  public int getDMG()
  {
    return damage;
  }
} //Specials class