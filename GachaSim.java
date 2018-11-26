package stuffage;

import java.util.Scanner;

public class GachaSim{
	static void test()
	{
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.println("What rank is your skill?");
		int level = scanner1.nextInt();
		System.out.println("How many Tier 3 books do you have?");
		int t3 = scanner1.nextInt();
		System.out.println("How many Tier 2 books do you have?");
		int t2 = scanner1.nextInt();
		System.out.println("How many Tier 1 books do you have?");
		int t1 = scanner1.nextInt();
		
		calcSkill(level, t3, t2, t1);
		return;
	}
	
	static void calcSkill(int l, int n3, int n2, int n1)
	{
		int cumulativeXP = 18500;
		int t3 = 0;
		int t2 = 0;
		int t1 = 0;
		
		if (l == 1)
		{
			cumulativeXP = cumulativeXP - 0;
		}
		else if(l == 2)
		{
			cumulativeXP = cumulativeXP - 100;
		}
		else if(l == 3)
		{
			cumulativeXP = cumulativeXP - 300;
		}
		else if(l == 4)
		{
			cumulativeXP = cumulativeXP - 700;
		}
		else if(l == 5)
		{
			cumulativeXP = cumulativeXP - 1500;
		}
		else if(l == 6)
		{
			cumulativeXP = cumulativeXP - 2900;
		}
		else if(l == 7)
		{
			cumulativeXP = cumulativeXP - 5100;
		}
		else if(l == 8)
		{
			cumulativeXP = cumulativeXP - 8300;
		}
		else if(l == 9)
		{
			cumulativeXP = cumulativeXP - 12700;
		}
		
		while (cumulativeXP > 1200 && n3 > 0)
		{
			cumulativeXP = (cumulativeXP - 1200);
			t3++;
			n3--;
		}
		while(cumulativeXP > 450 && n2 > 0)
		{
			cumulativeXP = (cumulativeXP - 450);
			t2++;
			n2--;
		}
		while(cumulativeXP > 0 && n1 > 0)
		{
			cumulativeXP = (cumulativeXP - 150);
			t1++;
			n1--;
		}
		if (cumulativeXP > 0)
		{
			System.out.println("You cannot reach level 10 with your skillbooks.\n");
		}
		else
		{
			System.out.println("It will take " + t3 + " T3 books, " +  t2 + " T2 books, and " +  t1 + " T1 books.");
			int numHours = (t3*8 + t2*4 + t1*1);
			System.out.println("It will take " + numHours + " hours to finish skilling to max level.");
		}
		return;
	}
	
	static void test2()
	{
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("How much oil does your main fleet consume?");
		int oil1 = scanner2.nextInt();
		
		System.out.println("How much oil does your boss fleet consume?");
		int oil2 = scanner2.nextInt();
		
		System.out.println("How many nodes before the boss?");
		int boss = scanner2.nextInt();
		
		calcOil(boss,oil1,oil2);
		return;
	}
	
	static void calcOil(int Node, int mainF, int bossF)
	{
		int totalOil = Node*mainF+bossF;
		System.out.println("It will take a total of " + totalOil + " total oil to complete a run. ");
	}
	
	static void test3()
	{
		System.out.println("Enter the number of rolls you would like to make: ");
		Scanner scanner3 = new Scanner(System.in);
		int rolls = scanner3.nextInt();
		calcRolls(rolls);
		return;
	}
	
	static void calcRolls(int timesRolled)
	{
		int SR = 0;
		int E = 0;
		int R = 0;
		int C = 0;
		int totalCubes = 2*timesRolled;
		int totalGold = 1500*timesRolled;
		double probability = (1-Math.pow(0.93,timesRolled))*100.0;
		
		while(timesRolled > 0)
		{
			double Roll = Math.random();
			if (Roll > 0.93)
			{
				try
				{
					Thread.sleep(25);
					SR++;
					System.out.println("ROLLS: ");
					System.out.println(SR + " SR Ships");
					System.out.println(E + " E Ships");
					System.out.println(R + " R Ships");
					System.out.println(C + " C Ships");
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else if ((Roll <= 0.93) && (Roll > 0.81))
			{
				try
				{
					Thread.sleep(25);
					E++;
					System.out.println("ROLLS: ");
					System.out.println(SR + " SR Ships");
					System.out.println(E + " E Ships");
					System.out.println(R + " R Ships");
					System.out.println(C + " C Ships");
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else if ((Roll <= 0.81) && (Roll > 0.30))
			{
				try
				{
					Thread.sleep(25);
					R++;
					System.out.println("ROLLS: ");
					System.out.println(SR + " SR Ships");
					System.out.println(E + " E Ships");
					System.out.println(R + " R Ships");
					System.out.println(C + " C Ships");
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					Thread.sleep(25);
					C++;
					System.out.println("ROLLS: ");
					System.out.println(SR + " SR Ships");
					System.out.println(E + " E Ships");
					System.out.println(R + " R Ships");
					System.out.println(C + " C Ships");
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			timesRolled--;
		}
		System.out.println("Probability of rolling an SR ship is: " + probability + " percent.");
		System.out.println("Total cubes spent: " + totalCubes);
		System.out.println("Total gold spent: " + totalGold);
	}
	
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		
		do
		{
			System.out.println("_AZURE LANE OPTIMIZER_");
			System.out.println("1: Skillbook Calculation");
			System.out.println("2: Oil Optimizer");
			System.out.println("3: Gacha Sim");
			System.out.println("4: Quit");
			
			System.out.println("Insert selection:");
			selection = scanner.nextInt();
			
			switch (selection)
			{
				case 1: 
					test();
					break;
				case 2: 
					test2();
					break;
				case 3: 
					test3();
					break;
				case 4: 
					System.out.println("Lmao desperate nerd");
					System.out.println("-----------------");
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}while(selection != 4);
		scanner.close();
	}
}
