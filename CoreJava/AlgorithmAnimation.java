import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class AlgorithmAnimation
{
	public static void main(String[] args)
	{
		JFrame frame = new AnimationFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class AnimationFrame extends JFrame
{
	public AnimationFrame()
	{
		ArrayPanel panel = new ArrayPanel();
		add(panel, BorderLayout.CENTER);
		
		Double[] values = new Double[VALUES_LENGTH];
		final Sorter sorter = new Sorter(values, panel);
		
		JButton runButton = new JButton("Run");
		runButton.addActionListener(new
			ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					sorter.setRun();
				}
			});
		JButton stepButton = new JButton("Step");
		stepButton.addActionListener(new
			ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					sorter.setStep();
				}
			});
			
		JPanel buttons = new JPanel();
		buttons.add(runButton);
		buttons.add(stepButton);
		add(buttons, BorderLayout.NORTH);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		for (int i = 0; i < values.length; i++)
			values[i] = new Double(Math.random());
		
		Thread t = new Thread(sorter);
		t.start();
	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	private static final int VALUES_LENGTH = 30;
}


class Sorter implements Runnable
{
	public	Sorter(Double[] values, ArrayPanel panel)
	{
		this.values = values;
		this.panel = panel;
		this.gate = new Semaphore(1);
		this.run = false;
	}
	
	public void setRun()
	{
		run = true;
		gate.release();
	}
	
	public void setStep()
	{
		run = false;
		gate.release();
	}
	
	public void run()
	{
		Comparator<Double> comp = new Comparator<Double>()
		{
			public int compare(Double i1, Double i2)
			{
				panel.setValues(values, i1, i2);
				try
				{
					if(run)
						Thread.sleep(DELAY);
					else
						gate.acquire();
				}
				catch (InterruptedException exception)
				{
					Thread.currentThread().interrupt();
				}
				return i1.compareTo(i2);
			}
		};
		Arrays.sort(values, comp);
		panel.setValues(values, null, null);
	}
	private Double[] values;
	private ArrayPanel panel;
	private Semaphore gate;
	private static final int DELAY = 100;
	private boolean run;
}

class ArrayPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		if (values == null) return;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth() / values.length;
		for (int i = 0; i < values.length; i++)
		{
			double height = values[i] * getHeight();
			Rectangle2D bar = new Rectangle2D.Double(width * i, 0, width, height);
			if (values[i] == marked1 || values[i] == marked2)
				g2.fill(bar);
			else
				g2.draw(bar);
		}
	}
	
	public void setValues(Double[] values, Double marked1, Double marked2)
	{
		this.values = values;
		this.marked1 = marked1;
		this.marked2 = marked2;
		repaint();
	}
	
	private Double marked1;
	private Double marked2;
	private Double[] values;
}
	
			
				
		
		
		
			
		
		