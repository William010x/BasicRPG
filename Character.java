//Character class
//Programmed By: William San
//Last Modified: 1/18/15
//Stores player's stats/specials, modifies stats and allows player to learn new special moves
public class Character
{
  //Attribute declarations
  private int charClass;                      //Class player chooses to be
  private int lvl;                            //Player's current level
  private int hp;                             //Player's current health points (when reaches 0, player will die)
  private int mp;                             //Player's current mana points (required for use of special moves)
  private int atk;                            //Player's current attack stat (increases attack damage)
  private int mag;                            //Player's current magic stat (increases magic damage)
  private int def;                            //Player's current defense stat (reduces attack damage taken)
  private int res;                            //Player's current resistance stat (reduces magic damage taken)
  private int spd;                            //Player's current speed stat (determines who will act first in battle)
  private int exp;                            //Player's current experince (player levels up when this reaches 100)
  private String type;                        //Type of damage player will deal with Attack
  private Specials[] moves = new Specials[2]; //Stores all of the player's special moves
  private Specials[] temp;                    //Temporary stores player's special moves so array size can be increased
  
  //Creates player's character with base stats based on their class
  //charClass - which class the player chose (1 is warrior, 2 is mage, 3 is rogue)
  public Character (int charClass2)
  {
    charClass = charClass2;
    
    if (charClass == 1) //Warrior base stats and special moves
    {
      lvl = 5;
      hp = 20;
      mp = 10;
      atk = 15;
      mag = 5;
      def = 15;
      res = 10;
      spd = 12;
      exp = 0;
      type = "ATK";
      moves[0] = new Specials("Cut", "ATK", 2, 20);
      moves[1] = new Specials("Slash", "ATK", 5, 45);
    }
    else if (charClass == 2) //Mage base stats and special moves
    {
      lvl = 5;
      hp = 15;
      mp = 15;
      atk = 5;
      mag = 15;
      def = 10;
      res = 15;
      spd = 15;
      exp = 0;
      type = "MAG";
      moves[0] = new Specials("Thunder", "MAG", 4, 25);
      moves[1] = new Specials("Fire", "MAG", 8, 55);
    }
    else //Rogue base stats and special moves
    {
      lvl = 5;
      hp = 15;
      mp = 12;
      atk = 12;
      mag = 12;
      def = 12;
      res = 12;
      spd = 20;
      exp = 0;
      type = "ATK";
      moves[0] = new Specials("Stab", "ATK", 3, 20);
      moves[1] = new Specials("Thunder", "MAG", 4, 23);
    }
  }
  
  //Returns player's class
  public String getCharClass()
  {
    if (charClass == 1)
    {
      return "Warrior";
    }
    else if (charClass == 2)
    {
      return "Mage";
    }
    else
    {
      return "Rogue";
    }
  }
  
  //Returns player's level
  public int getLVL()
  {
    return lvl;
  }
  
  //Returns player's current HP
  public int getHP()
  {
    return hp;
  }
  
  //Return player's current MP
  public int getMP()
  {
    return mp;
  }
  
  //Return player's attack stat
  public int getATK()
  {
    return atk;
  }
  
  //Return player's magic stat
  public int getMAG()
  {
    return mag;
  }
  
  //Returns player's defence stat
  public int getDEF()
  {
    return def;
  }
  
  //Returns player's resistance stat
  public int getRES()
  {
    return res;
  }
  
  //Returns player's speed stat
  public int getSPD()
  {
    return spd;
  }
  
  //Returns player's current experience points
  public int getEXP()
  {
    return exp;
  }
  
  //Returns type of damage player deals with Attack
  public String getType()
  {
    return type;
  }
  
  //Returns array of special moves
  public Specials[] getMoves()
  {
    return moves;
  }
  
  //Lowers player's HP
  public void loseHP(int amount)
  {
    hp -= amount;
  }
  
  //Lowers player's MP
  public void loseMP(int amount)
  {
    mp -= amount;
  }
  
  //Increases player's HP
  public void gainHP(int amount)
  {
    hp += amount;
  }
  
  //Increases player's MP
  public void gainMP(int amount)
  {
    mp += amount;
  }
  
  //Increases player's experience points, if player gets 100+ exp, levels up and resets exp to 0
  //amount - amount of experience points player is gaining
  public void expUp(int amount)
  {
    exp += amount;
    
    //Check if player leveled up
    if (exp >= 100)
    {
      exp = 0;
      lvlUp();
    }
  }
  
  //Levels up the player and boosts their stats
  private void lvlUp()
  {
    lvl++;
    
    //Stat boosts per level up
    hp += 1 + (int)(Math.random()*3);
    mp += 1 + (int)(Math.random()*3);
    atk += 1 + (int)(Math.random()*3);
    mag += 1 + (int)(Math.random()*3);
    def += 1 + (int)(Math.random()*3);
    res += 1 + (int)(Math.random()*3);
    spd += 1 + (int)(Math.random()*3);
    
    if (charClass == 1) //Warrior stat boosts per level up
    {
      hp += 3;
      atk += 3;
      def += 2;
    }
    else if (charClass == 2) //Mage stat boosts per level up
    {
      mp += 3;
      mag += 3;
      res += 2;
    }
    else //Rogue stat boosts per level
    {
      atk++;
      mag++;
      spd += 3;
    }
    
    //Learning new special moves
    if (lvl == 15)
    {
      //Increase Specials array to have room to store new special move
      temp = new Specials[moves.length];
      for (int x = 0; x < temp.length; x++) //Store all previous specials in temporary array
      {
        temp[x] = moves[x];
      }
      moves = new Specials[moves.length+1];
      for (int x = 0; x < moves.length; x++) //Copy all previous specials back to array
      {
        moves[x] = temp[x];
      }
      
      //New special moves
      if (charClass == 1) //Warrior special move
      {
        moves[2] = new Specials("Slice", "ATK", 15, 85);
      }
      else if (charClass == 2) //Mage special move
      {
        moves[2] = new Specials("Ice", "MAG", 25, 125);
      }
      else //Rogue special move
      {
        moves[2] = new Specials("Dark Bolt", "MAG", 18, 100);
      }
    }
    else if (lvl == 50)
    {
      //Increase Specials array to have room to store new special move
      temp = new Specials[moves.length];
      for (int x = 0; x < temp.length; x++) //Store all previous specials in temporary array
      {
        temp[x] = moves[x];
      }
      moves = new Specials[moves.length+1];
      for (int x = 0; x < moves.length; x++) //Copy all previous specials back to array
      {
        moves[x] = temp[x];
      }
      
      //New special moves
      if (charClass == 1) //Warrior special move
      {
        moves[3] = new Specials("Strike", "ATK", 35, (int)(atk*5));
      }
      else if (charClass == 2) //Mage special move
      {
        moves[3] = new Specials("Lightning", "MAG", 70, (int)(mag*2));
      }
      else //Rogue special move
      {
        moves[3] = new Specials("Assassinate", "ATK", 45, (int)(atk*1.75));
      }
    }
  } //Level up method
} //Character class