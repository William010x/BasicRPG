//Inventory class
//Programmed By: William San
//Last Modified: 1/21/16
//Stores and accesses all items that player has
import hsa.Console;
public class Inventory
{
  private int potionsHP;
  private int potionsMP;
  private int keys;
  private int gold;
  
  //Creates inventory with starting items
  public Inventory ()
  {
    potionsHP = 20;
    potionsMP = 15;
    keys = 3;
    gold = 100;
  }
  
  //Returns player's current # of HP potions
  public int getHPPotions()
  {
    return potionsHP;
  }
  
  //Returns player's current # of MP potions
  public int getMPPotions()
  {
    return potionsMP;
  }
  
  //Returns player's current # of keys
  public int getKeys()
  {
    return keys;
  }
  
  //Returns player's current gold
  public int getGold()
  {
    return gold;
  }
  
  //Purchasing items, spending gold to gain items
  //item - type of item to purchase (HP pot, MP pot or keys)
  //quantity - amount of item being purchased
  //c - Console/window to tell player info about purchase
  public void purchase (int item, int quantity, Console c)
  {
    if (item == 1) //Buying HP potions
    {
      //Check if they can afford potions
      if (gold > (quantity*30))
      {
        potionsHP += quantity;
        gold -= quantity*30;
        c.println("You got " + quantity + " HP potions");
      }
      else
      {
        c.println("You can't afford that.");
      }
    }
    
    else if (item == 2) //Buying MP potions
    {
      //Check if they can afford potions
      if (gold > (quantity*20))
      {
        potionsMP += quantity;
        gold -= quantity*20;
        c.println("You got " + quantity + " MP potions");
      }
      else
      {
        c.println("You can't afford that.");
      }
    }
    
    else //Buying keys
    {
      //Check if they can afford keys
      if (gold > (quantity*30))
      {
        c.println("You got " + quantity + " keys");
      }
      else
      {
        c.println("You can't afford that");
      }
    }
  } //purchase method
  
  //Player uses their potion, returns true if action failed (from not having enough potions)
  //item - which item being used (HP potion or MP potion)
  //c - console/window to tell player result of action
  public boolean usePotion (int item, Console c)
  {
    if (item == 1) //Use HP potion
    {
      //Check if they have enough potions
      if (potionsHP > 0)
      {
        potionsHP--;
        Overworld.player.gainHP(50);
        return false;
      }
      else
      {
        c.println("You don't have any more HP potions.");
        return true;
      }
    }
    
    else //Use MP Potion
    {
      //Check if they have enough potions
      if (potionsMP > 0)
      {
        potionsHP--;
        Overworld.player.gainMP(35);
        return false;
      }
      else
      {
        c.println("You don't have any more MP potions.");
        return true;
      }
    }
  } //use potion method
  
  //Increases player's gold based on amount of gold found
  //goldFound - amount of gold to increase player's gold by
  public void goldFound(int goldFound)
  {
    gold += goldFound;
  }
  
  //Opening treasure chests
  //c - console/window to tell info about chest
  public void openChest(Console c)
  {
    //Checks if user has enough keyss
    if (keys > 0)
    {
      int goldFound, expFound; //Gold and experience found in chest
      double random = Math.random(); //Randomly determines if items are in chest
      
      //Chest rewards
      keys--;
      goldFound = 15 + (int)(Math.random()*10 + 1);
      expFound = 50 + (int)(Math.random()*25 + 1);
      gold += goldFound;
      Overworld.player.expUp(expFound);
      
      c.println("You found " + goldFound + " gold.");
      c.println("You found " + expFound + " experience.");
      
      if (random < 0.33)
      {
        potionsHP++;
        c.println("You found 1 HP potion.");
      }
      else if (random >= 0.33 && random < 0.66)
      {
        potionsHP++;
        potionsMP++;
        c.println("You found 1 HP potion.");
        c.println("You found 1 MP potion.");
      }
      
      c.readChar();
    }
    else
    {
      c.println("You don't have any more keys");
    }
  } //open chests method
} //Inventory class