import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*; 


public class Game 
{ 
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();
		
		//Enemies
		String enemy = "Monster";
		int maxMonsterHealth = 100;
		int maxMonsterDamage = 25;
		
		
		//Player
		int playerHealth = 100;
		int maxPlayerDamage = 50;
		int healthpotioncount= 3;
		int healthpotion = 35;
		int specialattack= 50;
		int specialattackcharge=3;
		
		int wins= 0;
		boolean running = true;
		int skill = 0;
		
		System.out.println("Welcome to the game!");
		
		
		GAME:
		while(running)
		{
			System.out.println("-------------------------------------------------------------------------");
			
			int monsterHealth = rand.nextInt(maxMonsterHealth);
			
			
			System.out.println("You are fighting a "+enemy);
			
			while (monsterHealth>0)
			{
				System.out.println("Your health is: "+playerHealth);
				System.out.println("Monster health is: "+monsterHealth);
				System.out.println("Here are your options: ");
				System.out.println("1.Attack");
				System.out.println("2.Run");
				System.out.println("3.Use Health Potion. You have "+healthpotioncount+" health potions left.");
				if(skill==1)
				{
					System.out.println("4.SPECIAL ATTACK--"+specialattackcharge+" charges left.");
				}
				
				String input = keyboard.nextLine();
				if(input.equals("1"))
				{
					int playerDamage = rand.nextInt(maxPlayerDamage);
					int damageTaken = rand.nextInt(maxMonsterDamage);
					monsterHealth = monsterHealth-playerDamage;
					playerHealth= playerHealth-damageTaken;
					
					System.out.println("You hit the enemy for "+playerDamage+", it now has "+monsterHealth+" health.");
					System.out.println("The enemy hit you for  "+damageTaken+", you now have "+playerHealth+" health.");
					
					if(playerHealth<=0)
					{
						System.out.println("You have died.");
						break;
					}
				}
				else if(input.equals("2"))
				{
					System.out.println("You have decided to run away from battle!");
					continue GAME;
				}
				else if(input.equals("3"))
				{
					if(healthpotioncount>=1)
					{
						System.out.println("You have decided to use a potion!");
						playerHealth = playerHealth+healthpotion;
						healthpotioncount= healthpotioncount-1;
					}
					else
					{
						System.out.println("You dont have enough health potions.");
						continue GAME;
					}
					
			
				}
				else if(input.equals("4"))
				{
					if(specialattackcharge>=1)
					{
						System.out.println("You have decided to use your special attack.");
						monsterHealth=monsterHealth-specialattack;
						specialattackcharge=specialattackcharge-1;
						int damageTaken = rand.nextInt(maxMonsterDamage);
						playerHealth= playerHealth-damageTaken;
						System.out.println("You hit the enemy for "+specialattack+", it now has "+monsterHealth+" health.");
						System.out.println("The enemy hit you for  "+damageTaken+", you now have "+playerHealth+" health.");
					}
					if(specialattackcharge<=0)
					{
						System.out.println("You dont have anymore charges!");
						continue GAME;
					}
					
					
				}
				else
				{
					System.out.println("Invalid input");
				}
			}
			if(playerHealth<=0)
			{
				System.out.println("You have died in battle.");
				break;
			}
			
			System.out.println("----------------------------------------------");
			System.out.println("You have now defeated a "+enemy);
			System.out.println("You have "+playerHealth+" health left.");
			healthpotioncount=healthpotioncount+1;
			System.out.println("You have earned 1 health potion. Your new count is "+healthpotioncount+" potions.");
			maxMonsterHealth+=30;
			maxMonsterDamage+=15;
			System.out.println("The monsters are now tougher");
			wins++;
			System.out.println("You have won "+wins+" times");
			if(wins==3)
			{
				skill+=1;
				maxPlayerDamage=maxPlayerDamage+25;
				
				System.out.println("----------------------------------------------");
				System.out.println("With all this fighting experience, you have unlocked a new skillset. The maximum damage you can do is now "+maxPlayerDamage+", and you now have a special attack that does 50 damage.");
				System.out.println("----------------------------------------------");
			}
			if(wins==6)
			{
				maxPlayerDamage=maxPlayerDamage+25;
				System.out.println("----------------------------------------------");
				System.out.println("With all this fighting experience, you have unlocked another new skillset. The maximum damage you can do is now "+maxPlayerDamage);
				System.out.println("----------------------------------------------");
			}
			System.out.println("----------------------------------------------");
			System.out.println("What now?");
			System.out.println("1.Continue on");
			System.out.println("2.Leave");
			
			String input = keyboard.nextLine();
			
			while(!input.equals("1")&&!input.equals("2"))
			{
				System.out.println("Invalid");
				input = keyboard.nextLine();
			}
			if(input.equals("1"))
			{
				System.out.println("Off to more adventures!");
			}
			else if (input.equals("2"))
			{
				System.out.println("Good job, hope you play again");
				break;
			}
			
			
			
			
	
			
		}
	}

}
