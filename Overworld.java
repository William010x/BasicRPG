//Overworld class
//Programmed By: William San
//Last Modified: 1/22/15
//Main game containing story, character creation, exploring the dungeon and battling enemies

import hsa.Console;      //Console Package
import java.awt.*;       //Graphics Package
import java.io.*;        //Package with code for working with files
import javax.imageio.*;  //Package with code to import an image

public class Overworld
{
  static Console c; //The main console, displaying main game, dungeon paths, menu and user prompts
  static Console v; //The console displaying all the visuals and images (the dungeon, overworld and battles)
  static Console b; //The battle log console, displaying results of each turn in battle and post battle stats
  
  static Character player;    //The player's character, storing all stats and specials
  static Inventory inventory; //The player's inventory, storing items and gold
  
  public static void main(String[] args)
  {
    c = new Console(20, 82, "Dungeon Crawler");
    
    inventory = new Inventory();
    int difficulty; //Difficulty level of enemies (more difficult for enemies deeper in dungeon and bosses)
    int charClass;  //Class that player chooses
    int paths;      //Number of possible paths/directions in current room
    
    //Story
    c.print("You live in a small village with your family.");
    c.readChar();
    c.print("However, this village is always getting attacked and pillaged by monsters.");
    c.readChar();
    c.print("One day, your father leaves with a group of villagers to go to the fight back.");
    c.readChar();
    c.print("They go to the monsters' lair, a deep dungeon, to exterminate all these monsters.");
    c.readChar();
    c.print("After several days, your father doesn't return and you decide to go find him.");
    c.readChar();
    
    c.clear();
    
    v = new Console("Dungeon");
    
    //Draw the classes
    Image classes;  //The image to draw
    
    //Try to import the image from the file
    try
    {
      classes = ImageIO.read(new File("warrior.png"));
    }
    catch(IOException e)  //File not found
    {
      classes = null;
    }
    //Draw the image (Image, x location, y location, null)
    v.drawImage(classes,1,10,null);
    
    //Try to import the image from the file
    try
    {
      classes = ImageIO.read(new File("mage.png"));
    }
    catch(IOException e)  //File not found
    {
      classes = null;
    }
    //Draw the image (Image, x location, y location, null)
    v.drawImage(classes,215,15,null);
    
    //Try to import the image from the file
    try
    {
      classes = ImageIO.read(new File("thief.png"));
    }
    catch(IOException e)  //File not found
    {
      classes = null;
    }
    //Draw the image (Image, x location, y location, null)
    v.drawImage(classes,425,10,null);
    
    //Character creation
    c.println("Select a class:");
    c.println("1 - Warrior");
    c.println("2 - Mage");
    c.println("3 - Rogue");
    charClass = c.readInt();
    player = new Character(charClass);
    c.clear();
    
    //Start of dungeon
    c.println("You enter the dungeon...");
    c.readChar();
    
    difficulty = 1; //easy enemies
    
    paths = 3;
    menu(difficulty, paths);
    paths = 2;
    menu(difficulty, paths);
    paths = 1;
    menu(difficulty, paths);
    paths = 4;
    menu(difficulty, paths);
    paths = 2;
    menu(difficulty, paths);
    
    difficulty = 2; //intermediate enemies
    
    paths = 3;
    menu(difficulty, paths);
    paths = 1;
    menu(difficulty, paths);
    paths = 4;
    menu(difficulty, paths);
    paths = 3;
    menu(difficulty, paths);
    paths = 1;
    menu(difficulty, paths);
    
    difficulty = 3; //hard enemies
    
    paths = 2;
    menu(difficulty, paths);
    paths = 1;
    menu(difficulty, paths);
    paths = 2;
    menu(difficulty, paths);
    paths = 3;
    menu(difficulty, paths);
    paths = 2;
    menu(difficulty, paths);
    
    difficulty = 4; //mini-boss fight
    
    paths = 3;
    menu(difficulty, paths);
    paths = 1;
    menu(difficulty, paths);
    paths = 3;
    menu(difficulty, paths);
    
    difficulty = 5; //final boss fight
    menu(difficulty, paths);
    
    //Ending
    c.println("You defeated the monsters' leader.");
    c.println("You returned home to live a peaceful life.");
    c.println("You brought peace to the land and your village was never attacked again.");
  } //main method
  
  //Shows user the main menu of game, allowing different actions in the overworld such as moving
  //difficulty - create enemy difficulty if battle occurs
  //paths - number of paths available
  public static void menu(int difficulty, int paths)
  {
    int option; //Action player wants to do
    int direction; //Direction player wants to move to
    int item; //Which item player wants to buy
    int quantity; //Amount of item player wants to buy
    
    v.clear();
    c.clear();
    
    Image room;  //The image to draw
    
    //Draw new room
    if (paths == 1)
    {
      //Try to import the image from the file
      try
      {
        room = ImageIO.read(new File("room.jpg"));
      }
      catch(IOException e)  //File not found
      {
        room = null;
      }
    }
    else if (paths == 2)
    {
      //Try to import the image from the file
      try
      {
        room = ImageIO.read(new File("room2.jpg"));
      }
      catch(IOException e)  //File not found
      {
        room = null;
      }
      //Draw the room (Image, x location, y location, null)
      v.drawImage(room,5,5,null);
    }
    else if (paths == 3)
    {
      //Try to import the image from the file
      try
      {
        room = ImageIO.read(new File("room3.jpg"));
      }
      catch(IOException e)  //File not found
      {
        room = null;
      }
    }
    else
    {
      //Try to import the image from the file
      try
      {
        room = ImageIO.read(new File("chest.jpg"));
      }
      catch(IOException e)  //File not found
      {
        room = null;
      }
    }
    //Draw the room (Image, x location, y location, null)
    v.drawImage(room,10,1,null);
    
    while (true)
    {
      //Overworld Menu
      c.println("Select an option:");
      c.println("1 - Move");
      c.println("2 - View Status");
      c.println("3 - Purchase Items");
      option = c.readInt();
      c.clear();
      
      if (option == 1) //Movement options
      {
        if (paths == 1)
        {
          c.println("You move forward");
        }
        else if (paths == 2)
        {
          c.println("Choose a direction to go:");
          c.println("1 - Forward");
          c.println("2 - Right");
          direction = c.readInt();
          c.clear();
          if (direction == 1)
          {
            c.println("You move forward");
          }
          else
          {
            c.println("You turn right");
          }
        }
        else if (paths == 3)
        {
          c.println("Choose a direction to go:");
          c.println("1 - Left");
          c.println("2 - Forward");
          c.println("3 - Right");
          direction = c.readInt();
          c.clear();
          if (direction == 1)
          {
            c.println("You turn left");
          }
          else if (direction == 2)
          {
            c.println("You move forward");
          }
          else
          {
            c.println("You turn right");
          }
        }
        else
        {
          c.println("You find a chest");
          c.println("Use a key to open it? Y/N: ");
          if (c.readLine().equalsIgnoreCase("Y"))
          {
            inventory.openChest(c);
          }
          c.clear();
          c.println("You move forward");
        }
        c.readChar();
        break;
      }
      else if (option == 2) //Display stats
      {
        c.clear();
        c.println("--------STATS--------");
        c.println("Class: " + player.getCharClass());
        c.println("  LVL: " + player.getLVL());
        c.println("   HP: " + player.getHP());
        c.println("   MP: " + player.getMP());
        c.println("  ATK: " + player.getATK());
        c.println("  MAG: " + player.getMAG());
        c.println("  DEF: " + player.getDEF());
        c.println("  RES: " + player.getRES());
        c.println("  SPD: " + player.getSPD());
        c.println("  EXP: " + player.getEXP());
        c.println("");
        c.println("------INVENTORY------");
        c.println("      Gold: " + inventory.getGold());
        c.println("HP Potions: " + inventory.getHPPotions());
        c.println("MP Potions: " + inventory.getMPPotions());
        c.println("      Keys: " + inventory.getKeys());
        c.readChar();
        c.clear();
      }
      else //Shop
      {
        c.clear();
        c.println("You have " + inventory.getGold() + " gold");
        c.println("What would you like to purchase?");
        c.println("1 - HP Potion = 30 Gold");
        c.println("2 - MP Potion = 20 Gold");
        c.println("3 - Keys = 30 Gold");
        c.println("4 - Nothing");
        item = c.readInt();
        if (item != 4)
        {
          c.println("How many would you like to purchase?");
          quantity = c.readInt();
          inventory.purchase(item, quantity, c);
        }
        c.readChar();
        c.clear();
      }
    }
    
    c.clear();
    
    //Randomly determine whether or not player will encounter an enemy
    if (Math.random() < 0.5 || difficulty == 5)
    {
      battle(difficulty);
    }
  } //move method
  
  //Draws the battle (player, enemy and health)
  //difficulty - creates harder/stronger enemies based on current difficulty
  public static void battleScreen(int difficulty, Enemy enemy)
  {
    v.clear();
    
    //Drawing battle screen
    c.println("You encounter an enemy!");
    
    //Draw player
    Image sprite;  //The image to draw
    
    if (player.getCharClass().equals("Warrior"))
    {
      //Try to import the image from the file
      try
      {
        sprite = ImageIO.read(new File("warrior-b.png"));
      }
      catch(IOException e)  //File not found
      {
        sprite = null;
      }
    }
    else if (player.getCharClass().equals("Mage"))
    {
      //Try to import the image from the file
      try
      {
        sprite = ImageIO.read(new File("mage-b.png"));
      }
      catch(IOException e)  //File not found
      {
        sprite = null;
      }
    }
    else
    {
      //Try to import the image from the file
      try
      {
        sprite = ImageIO.read(new File("thief-b.png"));
      }
      catch(IOException e)  //File not found
      {
        sprite = null;
      }
    }
    
    //Draw the player (Image, x location, y location, null)
    v.drawImage(sprite,10,50,null);
    
    //Draw enemy
    Image enemySprite;  //The image to draw
    
    if (difficulty == 1)
    {
      //Try to import the image from the file
      try
      {
        enemySprite = ImageIO.read(new File("easy.png"));
      }
      catch(IOException e)  //File not found
      {
        enemySprite = null;
      }
    }
    else if (difficulty == 2)
    {
      //Try to import the image from the file
      try
      {
        enemySprite = ImageIO.read(new File("intermediate.png"));
      }
      catch(IOException e)  //File not found
      {
        enemySprite = null;
      }
    }
    else if (difficulty == 3)
    {
      //Try to import the image from the file
      try
      {
        enemySprite = ImageIO.read(new File("hard.jpg"));
      }
      catch(IOException e)  //File not found
      {
        enemySprite = null;
      }
    }
    else if (difficulty == 4)
    {
      //Try to import the image from the file
      try
      {
        enemySprite = ImageIO.read(new File("miniboss.png"));
      }
      catch(IOException e)  //File not found
      {
        enemySprite = null;
      }
    }
    else
    {
      //Try to import the image from the file
      try
      {
        enemySprite = ImageIO.read(new File("boss.png"));
      }
      catch(IOException e)  //File not found
      {
        enemySprite = null;
      }
    }
    
    //Draw the enemy (Image, x location, y location, null)
    v.drawImage(enemySprite,400,50,null);
    
    
    //Draw HP and MP
    v.setCursor(1,1);
    v.println("Your HP: " + player.getHP());
    v.setCursor(1,50);
    v.println("Enemy HP: " + enemy.getHP());
    v.setCursor(2,1);
    v.println("Your MP: " + player.getMP());
    v.setCursor(2,50);
    v.println("Enemy MP: " + enemy.getMP());
    
    c.readChar();
    c.clear();
    
  } //Battle screen method
  
  //Battling against enemies, fighting until either dies
  //difficulty - determines difficulty level of enemy to create
  public static void battle(int difficulty)
  {
    //Variable and object declarations/creation
    b = new Console(25, 35, "Battle Log"); //Create console where all battle info is displayed
    Enemy enemy = new Enemy(difficulty); //Creates enemy
    int action; //Which action player wants to do
    int damage; //Damage dealt that turn
    int move = -1; //Which Special move player wants to use
    int item = -1; //Which item player wants to use
    boolean fail; //Checks if player's action failed
    
    //Determines what type of damage enemy deals
    if (player.getDEF() < player.getRES())
    {
      enemy.changeType("MAG");
    }
    else
    {
      enemy.changeType("ATK");
    }
    
    //Entering battle screen
    battleScreen(difficulty, enemy);
    
    while (enemy.getHP() > 0 || player.getHP() > 0) //Battle continues until someone dies
    {
      //Start of turn
      
      //Battling
      if (player.getSPD() > enemy.getSPD()) //Player acts first
      {
        do //Continues player's action until valid option is used
        {
          //Battle menu
          c.println("Select an action:");
          c.println("1 - Attack");
          c.println("2 - Use Special");
          c.println("3 - Use Item");
          action = c.readInt();
          
          c.clear();
          
          //Player's turn
          if (action == 1) //Player attacks
          {
            if (player.getType().equals("ATK")) //Player will deal ATK damage with Attack
            {
              damage = player.getATK() - enemy.getDEF();
            }
            else //Player will deal MAG damage with Attack
            {
              damage = player.getMAG() - enemy.getRES();
            }
            
            if (damage > 0)
            {
              enemy.loseHP(damage);
            }
            else
            {
              damage = 0;
            }
            fail = false;
          }
          
          else if (action == 2) //Player uses a Special
          {
            //Special move list/menu
            c.println("Choose a Special:");
            for (int x = 0; x < player.getMoves().length; x++)
            {
              c.println(x+1 + " - " + player.getMoves()[x].getName() + " (Costs " + player.getMoves()[x].getCost() + "MP)");
            }
            move = c.readInt();
            
            if (player.getMP() > player.getMoves()[move-1].getCost()) //Player can afford to use Special
            {
              player.loseMP(player.getMoves()[move-1].getCost());
              if (player.getMoves()[move-1].getType().equals("ATK")) //Special deals ATK damage
              {
                damage = player.getMoves()[move-1].getDMG() - enemy.getDEF();
              }
              else //Special deal MAG damage
              {
                damage = player.getMoves()[move-1].getDMG() - enemy.getRES();
              }
              
              if (damage > 0)
              {
                enemy.loseHP(damage);
              }
              else
              {
                damage = 0;
              }
              fail = false;
            }
            else //Player can't afford to use Special
            {
              c.println("You don't have enough MP");
              damage = 0;
              fail = true;
            }
          }
          
          else  //Player uses potion
          {
            //Item list/menu
            c.println("Select an item to use:");
            c.println("1 - HP Potion");
            c.println("2 - MP Potion");
            damage = -1;
            item = c.readInt();
            fail = inventory.usePotion(item, c);
          }
        } while (fail == true);
        
        battleLog(damage, "P", action, move, item, player.getHP(), enemy.getHP(), player.getMP(), enemy.getMP());
        
        //Death check (if enemy died and battle ended)
        if (enemy.getHP() < 0)
        {
          break;
        }
        
        //Enemy's turn
        if (enemy.getMP() > 25) //Enemy uses Special
        {
          enemy.loseMP(25);
          if (enemy.getType().equals("ATK"))
          {
            damage = (int)(enemy.getATK()*1.2) - player.getDEF();
          }
          else
          {
            damage = (int)(enemy.getMAG()*1.2) - player.getRES();
          }
        }
        else //Enemy attacks
        {
          if (enemy.getType().equals("ATK"))
          {
            damage = enemy.getATK() - player.getDEF();
          }
          else
          {
            damage = enemy.getMAG() - player.getRES();
          }
        }
        
        if (damage > 0)
        {
          player.loseHP(damage);
        }
        else
        {
          damage = 0;
        }
        
        battleLog(damage, "E", action, move, item, player.getHP(), enemy.getHP(), player.getMP(), enemy.getMP());
        
        //Death check (if player died and battle ended)
        if (player.getHP() < 0)
        {
          break;
        }
      }
      
      else //Enemy acts first
      {
        //Enemy's turn
        if (enemy.getMP() > 25) //Enemy uses Special
        {
          action = 2;
          enemy.loseMP(25);
          if (enemy.getType().equals("ATK"))
          {
            damage = (int)(enemy.getATK()*1.2) - player.getDEF();
          }
          else
          {
            damage = (int)(enemy.getMAG()*1.2) - player.getRES();
          }
        }
        else //Enemy attacks
        {
          action = 1;
          if (enemy.getType().equals("ATK"))
          {
            damage = enemy.getATK() - player.getDEF();
          }
          else
          {
            damage = enemy.getMAG() - player.getRES();
          }
        }
        if (damage > 0)
        {
          player.loseHP(damage);
        }
        else
        {
          damage = 0;
        }
        
        battleLog(damage, "E", action, move, item, player.getHP(), enemy.getHP(), player.getMP(), enemy.getMP());
        
        //Death check (if player died and battle ended)
        if (player.getHP() < 0)
        {
          break;
        }
        
        do //Continues player's action until valid option is used
        {
          //Battle menu
          c.println("Select an action:");
          c.println("1 - Attack");
          c.println("2 - Use Special");
          c.println("3 - Use Item");
          action = c.readInt();
          
          c.clear();
          
          //Player's turn
          if (action == 1) //Player attacks
          {
            if (player.getType().equals("ATK")) //Player will deal ATK damage with Attack
            {
              damage = player.getATK() - enemy.getDEF();
            }
            else //Player will deal MAG damage with Attack
            {
              damage = player.getMAG() - enemy.getRES();
            }
            
            if (damage > 0)
            {
              enemy.loseHP(damage);
            }
            else
            {
              damage = 0;
            }
            fail = false;
          }
          
          else if (action == 2) //Player uses Special
          {
            //Special move list/menu
            c.println("Choose a Special:");
            for (int x = 0; x < player.getMoves().length; x++)
            {
              c.println(x+1 + " - " + player.getMoves()[x].getName() + " (Costs " + player.getMoves()[x].getCost() + "MP)");
            }
            move = c.readInt();
            
            if (player.getMP() > player.getMoves()[move-1].getCost()) //Player can afford to use Special
            {
              player.loseMP(player.getMoves()[move-1].getCost());
              if (player.getMoves()[move-1].getType().equals("ATK")) //Special deals ATK damage
              {
                damage = player.getMoves()[move-1].getDMG() - enemy.getDEF();
              }
              else //Special deals MAG damage
              {
                damage = player.getMoves()[move-1].getDMG() - enemy.getRES();
              }
              
              if (damage > 0)
              {
                enemy.loseHP(damage);
              }
              else
              {
                damage = 0;
              }
              fail = false;
            }
            else //Player can't afford to use Special
            {
              c.println("You don't have enough MP");
              damage = 0;
              fail = true;
            }
          }
          
          else //Player uses items
          {
            //Item list/menu
            c.println("Select an item to use:");
            c.println("1 - HP Potion");
            c.println("2 - MP Potion");
            damage = -1;
            item = c.readInt();
            fail = inventory.usePotion(item, c);
          }
        } while (fail == true);
        
        battleLog(damage, "P", action, move, item, player.getHP(), enemy.getHP(), player.getMP(), enemy.getMP());
        
        //Death check (if enemy died and battle ended)
        if (enemy.getHP() < 0)
        {
          break;
        }
      }
    } //End of battle
    
    b.close();
    
    if (player.getHP() < 0) //Game over screen
    {
      c.clear();
      c.println("YOU DIED! GAME OVER");
      c.readChar();
      c.close();
    }
    else //Post battle screen
    {
      postBattle(enemy.getEXP(), enemy.getGold());
    }
  } //Battle method
  
  //Displays info on results of turn and lowers Health
  //damage - damage dealt that turn
  //turn - turn to determine who did action (E = enemy's turn/action, P = player's turn/action)
  //action - action done in turn
  //move - which special move player used
  //item - which item player used
  //playerHP - player's HP after damage
  //enemyHP - enemy's HP after damage
  //playerMP - player's MP after turn
  //enemyMP - player's MP after damage
  public static void battleLog(int damage, String turn, int action, int move, int item, int playerHP, int enemyHP, int playerMP, int enemyMP)
  {
    v.setCursor(1,1);
    v.println("Your HP: " + playerHP);
    v.setCursor(1,50);
    v.println("Enemy HP: " + enemyHP);
    v.setCursor(2,1);
    v.println("Your MP: " + playerMP);
    v.setCursor(2,50);
    v.println("Enemy MP: " + enemyMP);
    
    //Player's turn log
    if (turn.equals("P"))
    {
      if (action == 1)
      {
        b.println("You attacked the enemy");
        b.println("You dealt " + damage + " damage to the enemy");
      }
      else if (action == 2)
      {
        b.println("You used " + player.getMoves()[move-1].getName());
        b.println("You dealt " + damage + " damage to the enemy");
      }
      else
      {
        if (item == 1)
        {
          b.println("You used a HP Potion");
          b.println("You recovered 50 HP");
        }
        else
        {
          b.println("You used a MP Potion");
          b.println("You recovered 35 MP");
        }
      }
      b.println();
    }
    //Enemy's turn log
    else
    {
      if (action == 1)
      {
        b.println("Enemy attacked you");
        b.println("Enemy dealt " + damage + " damage to you");
      }
      else
      {
        b.println("Enemy used Slash");
        b.println("Enemy dealt " + damage + " damage to you");
      }
      b.println();
    }
    
    c.println("Press ENTER to continue");
    c.readChar();
    c.clear();
  }
  
  //Displays info on results of battle (experience gained and gold found)
  public static void postBattle(int exp, int gold)
  {
    c.clear();
    c.println("You defeated the enemy");
    player.expUp(exp);
    inventory.goldFound(gold);
    c.println("You got " + exp + " experience.");
    c.println("You got " + gold + " experience.");
    c.readChar();
  }
} //Overworld class
