import java.util.ArrayList;

public class Person 
{
	static ArrayList<Person> personArray = new ArrayList<Person>();
	public String username;
	public String password;
	public Person(String x,String y)
	{
		username=x;
		password=y;
	}
}
