import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registiration extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Registiration()
	{
		
		JFrame Jframe=new JFrame("Registiration"); 
		Jframe.setResizable(false);
		Jframe.setBounds(600,350,800,400);
		Jframe.setLayout(null);
		Jframe.setVisible(true);
	    JLabel JLabel = new JLabel();
	    JLabel.setText("Registiration");
	    JLabel.setBounds(140,70, 200,20);
	    
	    
	    JLabel label1 = new JLabel();
	    JLabel label2 = new JLabel();
	    label1.setText("Username");
	    label1.setBounds(140,70,200,50);
	    label2.setText("Password");
	    label2.setBounds(140,140,200,50);
	    
	    JButton registirationbutton = new JButton("Registiration");
	    registirationbutton.setBounds(280, 250, 200, 50);
	    
	    JTextField text1 = new JTextField();
	    JPasswordField text2 = new JPasswordField();
	    
	    text1.setEditable(true);
	    text1.getText();
	    text1.setBounds(300,85,200,30);
	    
	    text2.setEditable(true);
	    text2.getText();
	    text2.setBounds(300,150,200,30);
	    
	    
	    Jframe.add(registirationbutton);
	    Jframe.add(label1);
	    Jframe.add(label2);
	    Jframe.add(text1);
	    Jframe.add(text2);
	    
	    
	    
	    registirationbutton.addActionListener(new ActionListener()
		{  
		    public void actionPerformed(ActionEvent e)
		    {  
		    	String x = text1.getText();
		    	if(x.isEmpty())
		    	{
		    		JOptionPane.showMessageDialog(null,"You have to create a username","Info",JOptionPane.PLAIN_MESSAGE);
		    	}
		    	String y = text2.getText();
		    	if(y.isEmpty())
		    	{
		    		JOptionPane.showMessageDialog(null,"You have to create a password","Info",JOptionPane.PLAIN_MESSAGE);
		    	}
		    	else if(!x.isEmpty() && !y.isEmpty())
		    	{
		    		Person person = new Person(x,y);
		    		Person.personArray.add(person);
		    		JOptionPane.showMessageDialog(null,"Player created","Info",JOptionPane.PLAIN_MESSAGE);
			    	Jframe.dispose();
		    	}
	    		
		    }  
		});
	}
}
