import java.lang.Math;
public class Vector2D {

	public double x;
	public double y;
		
	
//Konstruktory
public Vector2D() {										//Konstruktor domyslny
		x=0;
		y=0;
    }
public Vector2D(double x1, double y1) {					//Konstruktor z parametrem (2 długości składowe)
	x=x1;
	y=y1;	
}
	

//Metody



public Vector2D SumV(Vector2D vect){	//Suma 2 wektorów
	Vector2D AB=new Vector2D();
    AB.x=this.x+vect.x;
    AB.y=this.y+vect.y;
    return AB;
}

public Vector2D RozV(Vector2D vect){	//Różnica 2 wektorów
	Vector2D CD=new Vector2D();
    CD.x=this.x-vect.x;
    CD.y=this.y-vect.y;
    return CD;
}
	
public Vector2D PowieV(double k){		//Przemnozenie wektora przez stałą
	 Vector2D EF=new Vector2D();
     EF.x=k*x;
     EF.y=k*y;
     return EF;
}

public Vector2D NormV(){				//Normalizacja wektorów
	Vector2D GH = new Vector2D();
    double dlug;
    dlug= Math.sqrt(x*x+y*y);
	GH.x=1/dlug;
    GH.y=1/dlug;
    return GH;
}
	
public double DlugV(){					//Długość wektora
	double dlug= Math.sqrt(x*x+y*y);
	return dlug;
	}
	
public void Opis() {					//Opis wektora
	System.out.println("Współrzędna x: " + x+ " y: " + y + "\n");
}

	
}
