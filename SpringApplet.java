	import javax.swing.JApplet;
	import java.util.Timer;
	import java.awt.*;
	import javax.swing.JPanel;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseMotionListener;
	
public class SpringApplet extends JApplet implements MouseListener, MouseMotionListener,ActionListener{
	boolean przec; //wartosc przeciagania myszy
	int wys=500;
	int sze=500;
	float polx;
	float poly;
	//Utworzenie pol kolejnych klas
	private SimEngine simengine;
	private SimTask simtask;
	private Timer odstep;
	private Button buttonReset;
	private TextField masa,K,C,G,L;
	
	@Override
	public void init() {
		przec=false;//domyslna wartosc 0
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(sze,wys);
		simengine=new SimEngine(10,3,1,150,200,150,200,100);
		simtask=new SimTask(simengine,this,0.1);
		odstep=new Timer();
		odstep.scheduleAtFixedRate(simtask,0,15);
		buttonReset=new Button("RESET");
		buttonReset.addActionListener(this);
		add(buttonReset);
		masa=new TextField("50",1);
		K=new TextField("2",1);
		C=new TextField("2",1);
		G=new TextField("9,81",1);
		L=new TextField("100",1);
		add(masa);
		add(K);
		add(C);
		add(L);
		add(G);
	}
	public void mousePressed(MouseEvent e) {
		polx=e.getX();
		poly=e.getY();
		if((polx>=(int)simengine.getpolozeniex()-25 && polx<=(int)simengine.getpolozeniex() +25)&&(poly>=(int)simengine.getpolozeniey()&&poly<=(int)simengine.getpolozeniey()+50));{
			odstep.cancel();
			simengine.reset();
			przec=true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(przec==true) {
			simengine.reset();
			simtask=new SimTask(simengine,this,0.1);
			odstep=new Timer();
			odstep.scheduleAtFixedRate(simtask, 0, 15);
			przec=false;
		}
		e.consume();
		
	}
	
	public void mouseDragged(MouseEvent e) {
		if (przec==true) {
			int polxx=e.getX();
			int polyy=e.getY();
			simengine.setpolozenie(simengine.getpolozeniex(), simengine.getpolozeniey());
			repaint();
		}
		e.consume();
	}
	
	@Override
	public void paint(Graphics g) {
		Vector2D wychylenie=simengine.polozenie;
		g.setColor(Color.white);
		g.fillRect(0, 0,sze , wys);
		g.setColor(Color.BLACK);
		g.fillRect(50, 50, 400, 100);
		g.setColor(Color.BLACK);
		g.drawLine((int)simengine.getpolozeniex(),100,(int)simengine.getpolozeniex(),(int)((int)(wychylenie.y)+simengine.getL()));
		g.setColor(Color.BLUE);
		g.fillOval((int)simengine.getpolozeniex()-25,(int)(simengine.getpolozeniey()+simengine.getL()),50,50);
		g.setColor(Color.BLACK);
		g.drawString("masa", 10, 10);
		masa.setBounds(10, 20, 50, 20);
		
		g.drawString("K", 10, 50);
		K.setBounds(10, 50, 50, 20);
		
		g.drawString("C", 10, 80);
		C.setBounds(10, 80, 50, 20);
		
		g.drawString("L", 10, 110);
		L.setBounds(10, 110, 50, 20);
		
		g.drawString("G", 10, 140);
		G.setBounds(10, 140, 50, 20);
		buttonReset.setBounds(10, 160, 50, 20);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonReset) {
			odstep.cancel();
			double m=Double.parseDouble(masa.getText());
			double ks=Double.parseDouble(K.getText());
			double cs=Double.parseDouble(C.getText());
			double L0=Double.parseDouble(L.getText());
			double g=Double.parseDouble(G.getText());
			simengine =new SimEngine(m,ks,cs,10,100,100,100,10);
			simtask=new SimTask(simengine,this,0.1);
			odstep=new Timer();
			odstep.scheduleAtFixedRate(simtask,0,15);
		}
	}
	
	
	
}