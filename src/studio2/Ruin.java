package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int startAmount;
		double winChance;
		int winLimit;
		int totalSimulations;
		int dailyamount;
		double didwin;
		int i = 0;
		int loss = 0;
		double expectedruin;
		double a;
		String outcome = "";
		System.out.println("what amount are you starting with");
		startAmount =in.nextInt();
		System.out.println("what is the probability that you win");
		winChance = in.nextDouble();
		System.out.println("what is the limit to win");
		winLimit = in.nextInt();
		System.out.println("what is the total amount of simulations");
		totalSimulations = in.nextInt();
	    System.out.println("what amount will you put in");
		dailyamount=in.nextInt();
		a = (1-winChance)/winChance;
		if(winChance == .5)
		{
		expectedruin = (1 - ((double)startAmount/(double)winLimit));
		}
		else
		{
		expectedruin = ((Math.pow((double)a, (double)startAmount)) - (Math.pow((double)a, (double)winLimit)))/(1-Math.pow((double)a, (double)winLimit));
		}
		while((startAmount < winLimit) && (i <= totalSimulations))
		{
		didwin = Math.random();
		if(didwin > winChance)
		{
		outcome = "LOSE";
		startAmount = startAmount - dailyamount;
		loss =loss + 1;
		}
		if(didwin < winChance)
		{
		outcome = "WIN";
		startAmount = startAmount + dailyamount;
		}
		System.out.println("Simulation " + i + ": " + dailyamount + " " + outcome);
		i = i + 1;
		}
		System.out.println("Losses: " + loss + " Simulations: " + i);
		System.out.println("Ruin rate from simulations: " + ((double)loss/(double)i) + " Expected ruin rate " + expectedruin);
	}

}
