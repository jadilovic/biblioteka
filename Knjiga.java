package Biblioteka;

import java.util.ArrayList;

public class Knjiga extends Biblioteka{
	
	public String imeKnjige;
	public boolean izdata;
	
	public Knjiga(){
	}
	
	public Knjiga(int brKnjige, String imeKnjige, boolean izdata){
			setBrojeviKnjiga(brKnjige);
			this.imeKnjige = imeKnjige;
			this.izdata = izdata;
	}
	
	public void izdajKnjigu(){
		this.izdata = true;
	}
	
	public void primiKnjigu(){
		this.izdata = false;
	}
	
	@Override
	public void podizanje(int brRacuna, int brKnjige){
		izdajKnjigu();
	}
	
	@Override
	public void vracanje(int brRacuna, int brKnjige){
		primiKnjigu();
	}
	
	@Override
	public String toString(){
		return "\nBroj knjige: " + getBrojKnjige() +
				"\nIme knjige: " + imeKnjige +
				"\nKnjga je izdata: " + izdata +
				"\n";
	}
}
