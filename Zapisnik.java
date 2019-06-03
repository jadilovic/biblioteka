package Biblioteka;

import java.util.Date;

public class Zapisnik {

	public char sym;
	public int brRacuna;
	public int brKnjige;
	public String transName;
	public Date transDate;
	

	public Zapisnik(){
		
	}
	
	public Zapisnik(char sym, int brRacuna, int brKnjige, String transName){
		transDate = new Date();
		this.sym = sym;
		this.brRacuna = brRacuna;
		this.brKnjige = brKnjige;
		this.transName = transName;
	}
	
	public String toString(){
		return "\nDatum posudjivanja ili vracanja " + transDate + " broj Racuna: " + brRacuna 
				+ " broj knjige " + brKnjige 
				+ " vrsta transakcije: " + transName;
	}
}
