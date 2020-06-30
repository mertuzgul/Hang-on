import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class MainMenu extends JFrame implements ActionListener
{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainMenu() 
	{	
		
		super("Hang on");
		JFrame Jframe = new JFrame("Hang on");
		Jframe.setLayout(null);
		setBounds(600,240,712,540);
		this.setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar(); 
	    setJMenuBar(menuBar);
	    
	    
	    JMenu game = new JMenu("Game"); 
	    JMenuItem start = new JMenuItem("Start"); 
	    JMenuItem pause = new JMenuItem("Pause");
	    JMenuItem restart = new JMenuItem("Restart");
	    start.addActionListener(this); 
	    pause.addActionListener(this);
	    restart.addActionListener(this);
	    game.add(start); 
	    game.add(pause);
	    game.add(restart);
	    menuBar.add(game);
	    
	    JMenu user = new JMenu("User"); 
	    JMenuItem login = new JMenuItem("Login");
	    JMenuItem registiration = new JMenuItem("Registiration");
	    JMenuItem registeredplayers = new JMenuItem("Registered players");
	    JMenuItem highscores = new JMenuItem("High Score");
	    JMenuItem playmusic = new JMenuItem("Play Music");
	    login.addActionListener(this);
	    registiration.addActionListener(this);
	    registeredplayers.addActionListener(this);
	    highscores.addActionListener(this);
	    playmusic.addActionListener(this);
	    
	    user.add(login);
	    user.add(registiration);
	    user.add(registeredplayers);
	    user.add(playmusic);
	    user.add(highscores);
	    menuBar.add(user);
	    
	    JMenu quit = new JMenu("Quit");
	    JMenuItem shutdown = new JMenuItem("Shutdown");
	    JMenuItem cancel = new JMenuItem("Cancel");
	    shutdown.addActionListener(this);
	    cancel.addActionListener(this);
	    shutdown.setActionCommand("Shutdown");
	    quit.add(shutdown);
	    quit.add(cancel);
	    menuBar.add(quit);
	    
	    this.add(menuBar);
	    
	    ImageIcon hangon1 = new ImageIcon(getClass().getResource("hangon1.png"));
	    JLabel Jlabel = new JLabel(hangon1);
	    
	    Jlabel.setBounds(100,80,1000,600);
	    this.add(Jlabel);        
	}
	private void playSound()
	 {
	   try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Mc Hush - Fired Up.wav").getAbsoluteFile( ));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    clip.start( );
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }

	public void actionPerformed(ActionEvent event)
	{
		String prefer = event.getActionCommand();
		if (prefer.equals("Start"))
		{
			if(Person.personArray.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"First you must login","Info",JOptionPane.WARNING_MESSAGE);
			}
			else if(Login.loginFlag==false)
			{
				JOptionPane.showMessageDialog(null,"First you must login","Info",JOptionPane.WARNING_MESSAGE);
			}
			else
				new Race();
				
		}
		if(prefer.equals("Pause"))
		{
			
		}
		if(prefer.equals("Restart"))
		{
			
		}
		if (prefer.equals("Login")) 
		{ 
			
			if(Person.personArray.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"No registered player yet","Info",JOptionPane.WARNING_MESSAGE);
			}
			else 
				new Login();
			
		}
		if (prefer.equals("Registiration"))
		{
			new Registiration();
		}
		if (prefer.equals("Registered players"))
		{
			if(Person.personArray.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"No registered player yet","Info",JOptionPane.WARNING_MESSAGE);
			}
			else
				RegisteredPlayers.displayRegisteredPlayers();
		}
		if(prefer.equals("Play Music"))
		{
			playSound();
		}
		if(prefer.equals("High Score"))
		{
			
		}
		if (prefer.equals("Shutdown"))
		{
			System.exit(0);
		}
		if(prefer.equals("Cancel"))
		{
			
		}
	}
}
