// ZADATAK: BIBLIOTEKA
// IZRADIO: JASMIN ADILOVIC
// DATUM: 18MAY2019

package Biblioteka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class testBiblioteka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Racun> racuni = new ArrayList<>();
		Racun r = new Racun();
		String imeMusterije;
		int brKnjiga;
		ArrayList<Knjiga> knjige = new ArrayList<>();
		Knjiga k = new Knjiga();
		String nazivKnjige;
		boolean izdataKnjiga;
		Biblioteka evidencija = new Biblioteka();

		int odabirUsluge = 0;
		Scanner input = new Scanner(System.in);
		
System.out.println("Dobro dosli u Biblioteku!");
do{
	System.out.println("Molim vas odaberite uslugu. "
			+ "\nZa kreiranje racuna unesite 1 \nZa kreiranje knjige unesite 2 "
			+ "\nZa podizanje unesite 3 \nZa vracanje unesite 4 "
			+ "\nZa ispis stanja racuna unesite 5 \nZa ispis stanja knjige unesite 6 "
			+ "\nZa ispis zapisnika unesite 7 \nZa izlaz iz programa unesite 8");
	odabirUsluge = input.nextInt();
			
	switch(odabirUsluge) {
		//KREIRANJE RACUNA
		case 1:
			System.out.println("Unesite broj racuna: ");
			int brojUnos = input.nextInt();
				if(evidencija.testBrojRacuna(brojUnos)){
					System.out.println("Racun sa ovim brojem vec postoji. Pokusajte ponovo.");
					break;
					}
				else if(brojUnos < 0){
					System.out.println("Nije moguce kreiranje RACUNA sa negativnim brojem. Pokusajte ponovo.");
					break;
					}
			System.out.println("Unesite ime musterije: ");
				imeMusterije = dodajImeMusterije();
			System.out.println("Unesite broj knjiga: ");
				brKnjiga = input.nextInt();
			
		// KREIRANJE OBJEKTA RACUNA
			r = new Racun(brojUnos, imeMusterije, brKnjiga);
			
		// KREIRANJE LISTE BROJEVA RACUNA
			evidencija.setBrojeviRacuna(brojUnos);
		
		// KREIRANJE LISTE OBJEKATA RACUNA
			racuni.add(r);
	
			System.out.println("Hvala na kreiranju RACUNA: \n" + r.toString() + "\n");
			break;
			
		//KREIRANJE KNJIGE
		case 2:
			System.out.println("Unesite broj knjige: ");
			    brojUnos = input.nextInt();
			    if(evidencija.testBrojKnjige(brojUnos)){
			    	System.out.println("Knjiga sa ovim brojem vec postoji. Pokusajte ponovo");
			    	break;
			    	}
				else if(brojUnos < 0){
					System.out.println("Nije moguce kreiranje KNJIGE sa negativnim brojem. Pokusajte ponovo.");
					break;
					}
			    
			System.out.println("Unesite naziv knjige: ");
				nazivKnjige = dodajNazivKnjige();
				
			System.out.println("Da li je knjiga izdata? Za DA unesite 1, za NE unesite 0: ");
				int izdata = input.nextInt();
					if(izdata == 1)
						izdataKnjiga = true;
					else if(izdata == 0)
						izdataKnjiga = false;
					else{
						System.out.println("Unijeli ste pogresan odgovor. Pokusajte ponovo");
						break;
					}
					
		// KREIRANJE OBJEKTA KNJIGE
			k = new Knjiga(brojUnos, nazivKnjige, izdataKnjiga);
			
		// KREIRANJE LISTE BROJEVA KNJIGA
			evidencija.setBrojeviKnjiga(brojUnos);
			
		// KREIRANJE LISTE OBJEKATA KNJIGA
			knjige.add(k);
			
			System.out.println("Hvala na kreiranju KNJIGE: \n" + k.toString() + "\n");
			break;
			
		// PODIZANJE KNJIGE
		case 3:
			System.out.println("Za podizanje knjige molim vas unesite vas broj racuna: ");
			int unosBrojaRacuna = input.nextInt();
			int brojPosKnjiga = 0;
				if(evidencija.testBrojRacuna(unosBrojaRacuna)){
					
					// PROVJERA STANJA BROJA IZNAJMLJENIH KNJIGA NA RACUNU
					for(Racun rList: racuni){
						if(rList.getBrojRacuna() == unosBrojaRacuna){
							brojPosKnjiga = rList.getBrojPosudjenihKnjiga();
							  	if(brojPosKnjiga >= 3){
							  		System.out.println("Racun broj " + unosBrojaRacuna + " vec ima posudjeno"
									+ " 3 ili vise knjiga");
						  			} 
							  	else {
				System.out.println("Molim vas unesite broj knjige koju zelite podici: ");
					int unosBrojaKnjige = input.nextInt();
					boolean knjigaIzdata = false;
						if(evidencija.testBrojKnjige(unosBrojaKnjige)){
							
						// PROVJERA DA LI JE KNJIGA IZDATA
							for(Knjiga kList: knjige){
								if(kList.getBrojKnjige() == unosBrojaKnjige){
								knjigaIzdata = kList.izdata;
									if(knjigaIzdata){
									System.out.println("Knjiga pod brojem " + unosBrojaKnjige + " je izdata"
											+ ". Pokusajte ponovo.\n");
										break;
										} 
									else {
				
				// IZDAVANJE KNJIGE, DODAVANJE NA RACUN I EVIDENCIJA U LISTU PODIZANJA
							kList.izdajKnjigu();
							rList.dodajKnjigu();
							evidencija.podizanje(unosBrojaRacuna, unosBrojaKnjige);
							
				// LOG / ZAPISNIK IZDAVANJA KNJIGE
							System.out.println("Musterija " + rList.getImeMusterije() + " sa brojem " 
								+ rList.getBrojRacuna() + " \nje iznajmio knjigu " + kList.imeKnjige 
								+ " sa brojem " + kList.getBrojKnjige() + " na dan " + evidencija.getDatumPosVra()
								+ "\n");
							break;
							}
						}
					}
				}else{
					System.out.println("Uneseni broj knjige je nepostojeci. Pokusajte ponovo\n");
					break;
					}
				break;
				}
			}
		}
	} else {
		System.out.println("Uneseni broj racuna je nepostojeci. Molim vas pokusajte ponovo\n");
		break;
	 }
	break;			
			// VRACANJE KNJIGE	
		case 4:
			System.out.println("Za vracanje knjige molim vas unesite vas broj racuna");
			unosBrojaRacuna = input.nextInt();
				if(evidencija.testBrojRacuna(unosBrojaRacuna)){
					
					// PROVJERA STANJA BROJA KNJIGA NA RACUNU
					for(Racun rLista: racuni){
						if(rLista.getBrojRacuna() == unosBrojaRacuna){
							brojPosKnjiga = rLista.getBrojPosudjenihKnjiga();
							if(brojPosKnjiga <= 0){
								System.out.println("Broj racuna koji ste unijeli nema posudjenih knjiga"
										+ ". Pokusajte pnovo sa drugim brojem racuna");
								break;
							} else {
								System.out.println("Unesite broj knjige koju vracate");
								int unosBrojaKnjige = input.nextInt();
								boolean knjigaIzdata = true;
									if(evidencija.testBrojKnjige(unosBrojaKnjige)){
										
									// PROVJERA DA LI JE KNJIGA IZDATA
										for(Knjiga kLista: knjige){
											if(kLista.getBrojKnjige() == unosBrojaKnjige){
												knjigaIzdata = kLista.izdata;
												if(knjigaIzdata == true){
													
									// VRACANJE KNJIGE
													rLista.vratiKnjigu();
													kLista.primiKnjigu();
													evidencija.vracanje(unosBrojaRacuna, unosBrojaKnjige);
									
								// LOG ZAPISNIK O VRACANJU KNJIGE
								System.out.println("Musterija " + rLista.getImeMusterije() + " sa brojem " 
									+ rLista.getBrojRacuna() + " \nje VRATIO knjigu " + kLista.imeKnjige 
									+ " sa brojem " + kLista.getBrojKnjige() + " na dan " + evidencija.getDatumPosVra()
									+ "\n");
									break;				
												} else {
													System.out.println("Uneseni broj knjige nije izdat"
															+ ". Pokusajte ponovo sa drugim brojem knjige");
													break;
												}
											}
										}
									} else {
										System.out.println("Broj knjige koju ste unijeli je nepostojeci"
												+ ". Pokusajte ponovo sa novim borjem knjige");
										break;
									}
							}
						}
					}
				} else {
					System.out.println("Uneseni broj racuna je nepostojeci. Pokusajte ponovo.\n");
					break;
				}
			break;
		
		// PREGLED STANJA RACUNA
		case 5:
			System.out.println("Unesite broj racuna za koji zelite listing stanja.");
			brojUnos = input.nextInt();
			if(evidencija.testBrojRacuna(brojUnos)){
				for(Racun rLista: racuni){
					if(rLista.getBrojRacuna() == brojUnos){
						System.out.println("Musterija " + rLista.getImeMusterije() + " sa brojem " 
							    + rLista.getBrojRacuna() + " ima iznajmljeno " 
								+ rLista.getBrojPosudjenihKnjiga() + " knjiga\n");
						break;
					}
				}
			} else {
				System.out.println("Unijeli ste nepostojeci broj. Pokusajte ponovo\n");
				break;
		}
			break;
		// PREGLED STANJA KNJIGE
		case 6:
			System.out.println("Unesite broj knjige za koju zelite listing stanja.");
			brojUnos = input.nextInt();
			if(evidencija.testBrojKnjige(brojUnos)){
				for(Knjiga kLista: knjige){
					if(kLista.getBrojKnjige() == brojUnos){
						System.out.println("Knjiga " + kLista.imeKnjige + " pod brojem " + kLista.getBrojKnjige()
						+ " je izdata " + kLista.izdata + "\n");
					}
				}
			} else {
				System.out.println("Unijeli ste nepostojeci broj knjige. Pokusajte ponovo\n");
				break;
			}
			break;
			
		// PREGLED EVIDENCIJE PODIZANJA I VRACANJA KNJIGA
		case 7:
			evidencija.printZapisnik();
			System.out.println();
			break;
			
		default:
			    // code block
			break;
			}
		}while(odabirUsluge != 8);


		System.out.println(racuni.toString());
		System.out.println(knjige.toString());
		System.out.println();
		
		evidencija.printZapisnik();
	
	}

	private static String dodajNazivKnjige() {
		Scanner input = new Scanner(System.in);
		String nazivKnjige = input.nextLine();
		return nazivKnjige;
	}

	public static String dodajImeMusterije() {
		Scanner input = new Scanner(System.in);
		String musterija = input.nextLine();
		return musterija;
	}

}
