
public class BikerThread extends Thread implements Runnable
{
	public void run()
	{
		while(true)
		{
			if(Race.leftArrowKey==false)
			{
				Race.moveBackBikerLeft();
			}
			if(Race.rightArrowKey==false)
			{
				Race.moveBackBikerRight();
			}
			if(Race.leftArrowKey==true)
			{
				Race.moveBikerLeft();
			}
			if(Race.rightArrowKey==true)
			{
				Race.moveBikerRight();
			}
			
			Race.bikerlabel.setIcon(Race.bikers[Race.i]);
			
			Race.Jframe.repaint();
			try
			{
				Thread.sleep(20);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if(Race.upArrowKey==false)
			{
				Race.moveBikerUp();
			
				Race.roadlabel.setIcon(Race.roads[Race.j]);
				try
				{
					Thread.sleep(0);
				}
				catch (InterruptedException e)
				{
				e.printStackTrace();
				}
			}
		}
		
		
	}
}
