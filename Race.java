import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Race extends JPanel implements KeyListener,ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private int delay=0;
	private ImageIcon start;
	private JLabel startlabel;
	protected static boolean leftArrowKey = false;
	protected static boolean rightArrowKey = false;
	protected static boolean upArrowKey = false;
	protected static boolean downArrowKey = false;
	protected static JLabel bikerlabel;
	protected static JLabel roadlabel;
	protected static JFrame Jframe;
	protected static int i=6;
	protected static int j=0;
	protected static int roadremember=-300;
	protected static ImageIcon[] bikers = new ImageIcon[13];
	protected static ImageIcon[] roads = new ImageIcon[2];
	final BikerThread t = new BikerThread();
	public Race()
	{
		
		
		
		
		bikers[0] = new ImageIcon(getClass().getResource("biker7 - Copy.png"));
		bikers[1] = new ImageIcon(getClass().getResource("biker6 - Copy.png"));
		bikers[2] = new ImageIcon(getClass().getResource("biker5 - Copy.png"));
		bikers[3] = new ImageIcon(getClass().getResource("biker4 - Copy.png"));
		bikers[4] = new ImageIcon(getClass().getResource("biker3 - Copy.png"));
		bikers[5] = new ImageIcon(getClass().getResource("biker2 - Copy.png"));
		bikers[6] = new ImageIcon(getClass().getResource("biker1.png")); //default biker 
		bikers[7] = new ImageIcon(getClass().getResource("biker2.png"));
		bikers[8] = new ImageIcon(getClass().getResource("biker3.png"));
		bikers[9] = new ImageIcon(getClass().getResource("biker4.png"));
		bikers[10] = new ImageIcon(getClass().getResource("biker5.png"));
		bikers[11] = new ImageIcon(getClass().getResource("biker6.png"));
		bikers[12] = new ImageIcon(getClass().getResource("biker7.png"));
		
		roads[0] = new ImageIcon(getClass().getResource("roadm1.png"));
		roads[1] = new ImageIcon(getClass().getResource("roadm2.png"));
		
		start =  new ImageIcon(getClass().getResource("starting.png"));
		
		roadlabel = new JLabel(roads[j]);
		roadlabel.setLayout(null);
		roadlabel.setBounds(-300,0,1500,700);
		roadlabel.setVisible(true);
		
		bikerlabel = new JLabel(bikers[i]);
		bikerlabel.setLayout(null);
		bikerlabel.setBounds(100,80,700,1000);
		bikerlabel.setVisible(true);
		
		startlabel = new JLabel(start);
		startlabel.setLayout(null);
		startlabel.setBounds(-300,0,1500,700);
		startlabel.setVisible(true);
		
		
		Jframe = new JFrame("Race");
		Jframe.setLayout(null);
		Jframe.setBounds(600,240,912,740);
		Jframe.setVisible(true);
		
		bikerlabel.addKeyListener(this);
		bikerlabel.setFocusable(true);
		
		timer = new Timer(delay,this);
		timer.start();
		
		Jframe.add(bikerlabel);
		Jframe.add(startlabel);
		Jframe.add(roadlabel);
		
		
		
		t.start();
	}
	
	public void bike(Graphics g)
	{
		
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		timer.start();
	}
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			rightArrowKey=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			leftArrowKey=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			moveBikerUp();
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			moveBikerDown();
			
		}
		if(e.getKeyCode()==KeyEvent.VK_P)
		{
			t.suspend();
		}
		if(e.getKeyCode()==KeyEvent.VK_C)
		{
			t.resume();
		}
	}
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			rightArrowKey=false;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			leftArrowKey=false;
		}	
	}
	
	public static void moveBikerUp()
	{
		
			if(j==0)
			{
				j++;
			}
			else if(j==1)
			{
				j--;
			}
		
				
	}
	public static void moveBikerDown()
	{
		
	}
	public static void moveBikerRight() 
	{
		roadremember-=20; //x azaldý
		RoadChange(roadremember);//x düzenlendi yol kaydý
		if(roadremember<-900)//out of track noktasý
		{
			JOptionPane.showMessageDialog(null,"Out of track","Game over",JOptionPane.PLAIN_MESSAGE);
			roadremember=-300; //oyun yeniden baþlayýnca ortaya koydu motorcuyu
			rightArrowKey=false; //oyun kapanýp açýlýnca tekrar saða saða kaymasýn diye false yaptým
			Jframe.dispose();
		}
		if(i>=6 && i<12)
		{
			i++; //bikers arrayini gezerek resimleri threadde deðiþtiriyor
			
		}
	}
	public static void moveBikerLeft() 
	{ 
		roadremember+=20;
		RoadChange(roadremember);
		if(roadremember>100)
		{
			JOptionPane.showMessageDialog(null,"Out of track","Game over",JOptionPane.PLAIN_MESSAGE);
			roadremember=-300;
			leftArrowKey=false;
			Jframe.dispose();
			
		}
		if(i>0 && i<=6)
		{
			i--;
			
			
		}
		
	}
	public static void moveBackBikerRight() //saða yatan motorcuyu asýl pozisyona döndürmek için
	{
		if(rightArrowKey==false)
		{
			if(i>6 && i<=12)
			{
				i--;
			}
		}
	}
	public static void moveBackBikerLeft()
	{
		if(leftArrowKey==false)
		{
			if(i>=0 && i<6)
			{
				i++;
			}
		}
	}
	public static void RoadChange(int x)
	{
		roadlabel.setBounds(x,0,1500,700);
	}
	
}