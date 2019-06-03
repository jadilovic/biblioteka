package Biblioteka;

import java.util.ArrayList;
import java.util.Date;

import Exercise11_3.Transaction;

public class Biblioteka {
	
	private ArrayList<Integer> brojeviRacuna = new ArrayList<>();
	private int brojRacuna;
	private ArrayList<Integer> brojeviKnjiga = new ArrayList<>();
	private int brojKnjige;
	private Date datumPosVra;
	private ArrayList<Zapisnik> logZapisnik = new ArrayList<>();
	

	
	public Biblioteka(){
	}
	
	
	public void podizanje(int brojRacuna, int brojKnjige){
		logZapisnik.add(new Zapisnik('P', brojRacuna, brojKnjige, "podizanje"));
		this.datumPosVra = new java.util.Date();
	}
	
	public void vracanje(int brRacuna, int brKnjige){
		logZapisnik.add(new Zapisnik('V', brRacuna, brKnjige, "vracanje"));
		this.datumPosVra = new java.util.Date();
	}

	/**
	 * @return the brojeviRacuna
	 */
	public ArrayList<Integer> getBrojeviRacuna() {
		return brojeviRacuna;
	}

	/**
	 * @param brojeviRacuna the brojeviRacuna to set
	 */
	public void setBrojeviRacuna(int brojRacuna) {
		if(!brojeviRacuna.contains(brojRacuna)){
			this.brojRacuna = brojRacuna;
			brojeviRacuna.add(brojRacuna);
		}else {
			System.out.println("Broj racuna vec postoji. Unesite novi broj");
		}
	}

	/**
	 * @return the brojeviKnjiga
	 */
	public ArrayList<Integer> getBrojeviKnjiga() {
		return brojeviKnjiga;
	}

	/**
	 * @param brojeviKnjiga the brojeviKnjiga to set
	 */
	public void setBrojeviKnjiga(int brojKnjige) {
		if(!brojeviKnjiga.contains(brojKnjige)){
			this.brojKnjige = brojKnjige;
			brojeviKnjiga.add(brojKnjige);
		} else {
			System.out.println("Broj knjige vec postoji. Unesite novi broj");
		}
	}
	
    public ArrayList<Zapisnik> getZapisnik() {
        return new ArrayList<>(logZapisnik);
    }
	
    public void printZapisnik(){
        System.out.print(logZapisnik); 
}

	/**
	 * @return the datumPosVra
	 */
	public Date getDatumPosVra() {
		return datumPosVra;
	}


	/**
	 * @return the brojRacuna
	 */
	public int getBrojRacuna() {
		return brojRacuna;
	}


	/**
	 * @return the brojKnjige
	 */
	public int getBrojKnjige() {
		return brojKnjige;
	}
	
	public boolean testBrojRacuna(int unosBrojaRacuna){
		if(brojeviRacuna.contains(unosBrojaRacuna)){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean testBrojKnjige(int unosBrojaKnjige){
		if(brojeviKnjiga.contains(unosBrojaKnjige)){
			return true;
		} else {
			return false;
		}
	}

}