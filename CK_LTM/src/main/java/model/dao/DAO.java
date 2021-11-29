package model.dao;

import java.util.ArrayList;

public class DAO {
	public void calculate_exponent(int base,int exponent)
	{
		calculate_exponent_thread thread = new calculate_exponent_thread(base, exponent);
		thread.run();
	}
	
	public void caculate_factorial(int number)
	{
		calculate_factorial_thread thread = new calculate_factorial_thread(number);
		thread.run();
	}
}

class calculate_factorial_thread extends Thread
{
	int n;
	int i=0;
	String result = "";
	public calculate_factorial_thread(int n)
	{
		this.n = n;
	}
	public void run()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
	    long x =0;
	    a.add(1);
		for(int i = 2; i <= n; i++)
		{
			for(int j = 0; j < a.size(); j++)
			{
				long y = x;
				x = (a.get(j)*i + x)/10;
				int z = (int)(a.get(j)*i + y)%10;
				a.set(j,z); 
			}
			while(x != 0)
			{
				int z = (int)x%10;
				a.add(z);
				x/=10;
			}
		}
		for(int i = a.size() -1; i >= 0; i--)
		{
			result += a.get(i);
		}
		a.clear();
		System.out.println( n+": "+result.length());
	}
}

class calculate_exponent_thread extends Thread
{
	int base;
	int exponent;
	int i=0;
	String result = "";
	public calculate_exponent_thread(int base,int exponent)
	{
		this.base = base;
		this.exponent = exponent;
	}
	public void run()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
	    long x =0;
	    a.add(1);
		for(int i = 2; i <= exponent; i++)
		{
			for(int j = 0; j < a.size(); j++)
			{
				long y = x;
				x = (a.get(j)*base + x)/10;
				int z = (int)(a.get(j)*base + y)%10;
				a.set(j,z); 
			}
			while(x != 0)
			{
				int z = (int)x%10;
				a.add(z);
				x/=10;
			}
		}
		for(int i = a.size() -1; i >= 0; i--)
		{
			result += a.get(i);
		}
		a.clear();
		System.out.println( base + "vs" + exponent+": "+result.length());
	}
}
