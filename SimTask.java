import java.util.TimerTask;// zaimportowanie klasy
public class SimTask extends TimerTask{//klasa pochodna
	private SimEngine simEngine;
	private SpringApplet springApplet;	
	private double odst_czas;
	public SimTask (SimEngine simEngine, SpringApplet springApplet, double odst_czas) {
		this.simEngine=simEngine;
		this.springApplet=springApplet;
		this.odst_czas=odst_czas;
		}
	
	public void run() {
	  simEngine.Simulate(odst_czas);
	  springApplet.repaint();
    }
	}
