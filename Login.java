import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame
{
	
	/**
	 * 
	 */
	static ArrayList<Login> loginnerArray = new ArrayList<Login>();
	private static final long serialVersionUID = 1L;
	public static String loginner;
	public static boolean loginFlag = false;
	public static String a;
	public static String b;
	public Login()
	{
		JFrame Jframe=new JFrame("Login"); //login J frame
		Jframe.setBounds(600,350,800,400);
		Jframe.setLayout(null);
		Jframe.setResizable(false);
		Jframe.setVisible(true);
	    JLabel JLabel = new JLabel();
	    JLabel.setText("Login");
	    JLabel.setBounds(140,70, 200,20);
	    
	    
	    JLabel label1 = new JLabel();
	    JLabel label2 = new JLabel();
	    label1.setText("Username");
	    label1.setBounds(140,70,200,50);
	    label2.setText("Password");
	    label2.setBounds(140,140,200,50);
	    
	    JButton loginbutton = new JButton("Login");
	    loginbutton.setBounds(280, 250, 200, 50);
	    
	    JTextField text1 = new JTextField();
	    JPasswordField text2 = new JPasswordField();
	    
	    text1.setEditable(true);
	    text1.getText();
	    text1.setBounds(300,85,200,30);
	    
	    text2.setEditable(true);
	    text2.getText();
	    text2.setBounds(300,150,200,30);
	    
	    
	    Jframe.add(loginbutton);
	    Jframe.add(label1);
	    Jframe.add(label2);
	    Jframe.add(text1);
	    Jframe.add(text2);
	    
	    
	    
	    loginbutton.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e)
		    {  
		    	int flag=0;
		    	
		    	 a = text1.getText();
		    	 b = text2.getText();
		    	for(int i=0;i<Person.personArray.size();i++)
		    	{
		    		if(flag==0)//2 kiþi register ettikten sonra bir kiþi login olmaya çalýþýnca ilkine doðru ikinciye yanlýþ diyordu flag kullanarak düzelttim
		    		{
		    			if(a.equals(Person.personArray.get(i).username)  &&  b.equals(Person.personArray.get(i).password))
			    		{
		    				
		    				loginFlag=true;
			    			JOptionPane.showMessageDialog(null,Person.personArray.get(i).username,"Successfull login",JOptionPane.PLAIN_MESSAGE);
			    			flag=1;
			    		}
		    		}
		    	}
		    	if(flag==0)
		    	{
		    		JOptionPane.showMessageDialog(null,"Login error","Error",JOptionPane.PLAIN_MESSAGE);
		    	}
		    	Jframe.dispose();
		    }  
		});
	}
}
