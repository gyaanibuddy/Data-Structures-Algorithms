import java.util.*;
class Scrambled
{
	HashMap<String, Boolean> hm;
	public Scrambled()
	{
		hm = new HashMap<String, Boolean>();
	}
	public boolean solve(String s1,String s2)
	{
		if(s1.equals(s2))
		{
			return true;
		}
		String key = s1+" "+s2;
		if(hm.containsKey(key))
		{
			boolean b = (boolean)hm.get(key);
			return b;
		}
		int n = s1.length();
		boolean flag = false;
		for(int i = 1;i<n;i++)
		{
			boolean cond1 = solve(s1.substring(0,i),s2.substring(n-i,n)) == true&&
					solve(s1.substring(i,n),s2.substring(0,n-i)) == true;
			boolean cond2 = solve(s1.substring(0,i),s2.substring(0,i)) == true&&
					solve(s1.substring(i,n),s2.substring(i,n)) == true;
			if(cond1||cond2)
			{
				flag = true;
				break;
			}
		}
		hm.put(key,flag);
		return flag;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Scrambled obj = new Scrambled();
		System.out.println("Enter first string");
		String s1 = sc.nextLine();
		System.out.println("Enter Second string");
		String s2 = sc.nextLine();
		if(s1.length()!=s2.length())
		{
			System.out.println("Strings are not scrambled");
		}
		else if(s1.isEmpty()&&s2.isEmpty())
		{
			System.out.println("Strings are Scrambled");
		}
		else
		{
			if(obj.solve(s1,s2))
			{
				System.out.println("Strings are scrambled");
			}
			else
			{
				System.out.println("Strings are not scrambled");
			}
		}		
	}
}
