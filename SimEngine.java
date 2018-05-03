public class SimEngine {
	private double masa;	//masa sprezyny
	private double K;		//wspolczynnik sprezystosci
	private double C;		//wpolczynnik tlumiena
	private double L;		//dlugosc sprezyny
	private double x0m;		//polozenie poczatkowe masy
	private double y0m;	
	private double x0s;		//polozenie poczatkowe sprezyny
	private double y0s;		
	private double Vxm;		//predkosc poczatkowa masy
	private double Vym;
	public double t;
	public double a;
	private static double g=9.9;
	//czas symulacji
	public void setmasa(float m) {//konstruktory
		masa=m;
	}
	public void setK(float k) {
		K=k;
	}
	public void setC(float c) {
		C=c;
	}
	public void setL(float l) {
		L=l;
	}
	public void setx0m(float xm) {
		x0m=xm;
	}
	public void sety0m(float ym) {
		y0m=ym;
	}
	public void setx0s(float xs) {
		x0s=xs;
	}
	public void sety0s(float ys) {
		y0s=ys;
	}
	public void setVxm(float Vx) {
		Vxm=Vx;
	}
	public void setVym(float Vy) {
		Vym=Vy;
	}
	
	public double getmasa() {//Akcesory
		return masa;
		}
	public double getK() {
		return K;
	}
	public double getC() {
		return C;
	}
	public double getL() {
		return L;
	}
	public double getx0m() {
		return x0m;
	}
	public double gety0m() {
		return y0m;
	}
	public double getx0s() {
		return x0s;
	}
	public double gety0s() {
		return y0s;
	}
	public double getVxm() {
		return Vxm;
	}
	public double getVym() {
		return Vym;
	}
	
	public Vector2D polozenie;
	public SimEngine(float masa, float K, float C, float L,float x0m, float y0m, float x0s, float y0s) {
		this.masa=masa;
		this.K=K;
		this.C=C;
		this.L=L;
		this.x0m=x0m;
		this.y0m=y0m;
		this.x0s=x0s;
		this.y0s=y0s;
		this.a=0;			//		
		polozenie= new Vector2D(x0m,y0m);
	}
	
	
	public double getpolozeniex() {
		return polozenie.x;
	}
	public double getpolozeniey() {
		return polozenie.y;
	}
	public void setpolozenie(double x, double y) {
		this.polozenie=new Vector2D(x,y);
	}
	public void Simulate(double o) {		//metoda obliczająca przyspieszenie i polozenie y masy
		t=o;
		a=(1/masa)*(-K*polozenie.y+(Vym*t+a*t*t/2));
	}
	public void reset() {
		Vym=0;
		this.a=0;
	}
}
