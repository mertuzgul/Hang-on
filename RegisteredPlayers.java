import javax.swing.JOptionPane;

public class RegisteredPlayers
{
	public static void displayRegisteredPlayers()
	{
		String Details = " ";
    	for(int i=0;i<Person.personArray.size();i++)
    	{
    		Details += Person.personArray.get(i).username + "\n";	
    	}
    	JOptionPane.showMessageDialog(null,Details,"Registered Players",JOptionPane.PLAIN_MESSAGE);
	}
}
