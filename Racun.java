package Biblioteka;

import java.util.ArrayList;

public class Racun extends Biblioteka{

	private String imeMusterije;
	private int brPosKnjiga;
	
	public Racun(){
	}
	
	public Racun(int brRacuna, String imeMusterije, int brPosKnjiga){
			setBrojeviRacuna(brRacuna);
			this.imeMusterije = imeMusterije;
			this.brPosKnjiga = brPosKnjiga;
	}
	
	public void dodajKnjigu(){
		brPosKnjiga++;
	}
	
	public void vratiKnjigu(){
		brPosKnjiga--;
	}
	
	
	public void podizanje(int brRacuna){
	dodajKnjigu();
	}
	
	@Override
	public void vracanje(int brRacuna, int brKnjige){
		vratiKnjigu();
	}
	
	
	@Override
	public String toString(){
		return "Broj racuna: " + getBrojRacuna() +
				"\nIme musterije: " + imeMusterije +
				"\nBroj posudjenih knjiga: " + brPosKnjiga +
				"\n";
		
	}
	
	public int getBrojPosudjenihKnjiga(){
		return brPosKnjiga;
	}
	
	public String getImeMusterije(){
		return imeMusterije;
	}
}
