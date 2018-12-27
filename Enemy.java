//Enemy class
//Programmed By: William San
//Last Modified: 1/21/15
//Stores enemy's stats and modifies stats
public class Enemy
{
  private int lvl;    //Enemy's current level
  private int hp;     //Enemy's current health points (when reaches 0, enemy will die)
  private int mp;     //Enemy's current mana points (required for use of special moves)
  private int atk;    //Enemy's current attack stat (increases attack damage)
  private int mag;     //Enemy's current magic stat (increases magic damage)
  private int def;     //Enemy's current defense stat (reduces attack damage taken)
  private int res;     //Enemy's current resistance stat (reduces magic damage taken)
  private int spd;     //Enemy's current speed stat (determines who will act first in battle)
  private int exp;     //Experience points enemy will give player when defeated
  private int gold;    //Amount of gold enemy will drop when defeated
  private String type; //Type of damage enemy will deal
  
  //Creates enemy's character with base stats based on their class
  //difficulty - the difficulty level of the enemy
  public Enemy(int difficulty)
  {
    if (difficulty == 1) //Weak enemy
    {
      lvl = 5;
      hp = 50;
      mp = 20;
      atk = 7;
      mag = 7;
      def = 7;
      res = 7;
      spd = 7;
      //lck = 5;
      exp = 40;
      type = "ATK";
    }
    else if (difficulty == 2) //Intermediate enemy
    {
      lvl = 12;
      hp = 120;
      mp = 50;
      atk = 30;
      mag = 30;
      def = 27;
      res = 27;
      spd = 18;
      //lck = 10;
      exp = 60;
      type = "ATK";
    }
    else if (difficulty == 3) //Hard enemy
    {
      lvl = 25;
      hp = 275;
      mp = 100;
      atk = 75;
      mag = 75;
      def = 70;
      res = 70;
      spd = 40;
      //lck = 25;
      exp = 80;
      type = "ATK";
    }
    else if (difficulty == 4) //Mini-boss
    {
      lvl = 35;
      hp = 700;
      mp = 200;
      atk = 180;
      mag = 180;
      def = 130;
      res = 130;
      spd = 90;
      //lck = 100;
      exp = 100;
      type = "ATK";
    }
    else //Final boss
    {
      lvl = 50;
      hp = 1000;
      mp = 300;
      atk = 300;
      mag = 300;
      def = 250;
      res = 250;
      spd = 200;
      //lck = 150;
      exp = 100;
      type = "ATK";
    }
    
    atk += (int)(Math.random() * 10);
    mag += (int)(Math.random() * 10);
    def += (int)(Math.random() * 10);
    res += (int)(Math.random() * 10);
    spd += (int)(Math.random() * 10);
    //lck += (int)(Math.random() * 10);
    gold += (int)(Math.random() * 15);
    exp += (int)(Math.random() * 10);
  }
  
  //Returns enemy's level
  public int getLVL()
  {
    return lvl;
  }
  
  //Returns enemy's current HP
  public int getHP()
  {
    return hp;
  }
  
  //Returns enemy's current MP
  public int getMP()
  {
    return mp;
  }
  
  //Returns enemy's attack stat
  public int getATK()
  {
    return atk;
  }
  
  //Returns enemy's magic stat
  public int getMAG()
  {
    return mag;
  }
  
  //Returns enemy's defence stat
  public int getDEF()
  {
    return def;
  }
  
  //Returns enemy's resistance stat
  public int getRES()
  {
    return res;
  }
  
  //Returns enemy's speed stat
  public int getSPD()
  {
    return spd;
  }
  
  //Returns amount of experience points enemy gives when defeated
  public int getEXP()
  {
    return exp;
  }
  
  //Returns amount of gold enemy will drop
  public int getGold()
  {
    return gold;
  }
  
  //Returns type of damage enemy will deal
  public String getType()
  {
    return type;
  }
  
  //Lowers enemy's HP
  public void loseHP(int amount)
  {
    hp -= amount;
  }
  
  //Lowers enemy's MP
  public void loseMP(int amount)
  {
    mp -= amount;
  }
  
  //Changes type of damage enemy will deal
  public void changeType(String type2)
  {
    type = type2;
  }
} //Enemy class