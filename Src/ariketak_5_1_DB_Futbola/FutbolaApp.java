package ariketak_5_1_DB_Futbola;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ariketak_5_1_DB_FutbolaConnect.*;
import ariketak_5_1_DB_FutbolaModeloa.*;

public class FutbolaApp {

	public static void main(String[] args) throws SQLException {
//		1 - Jokalariak ikusi.
//		2- Taldeak ikusi.
//		3- Jokalari bat gehitu.
//		4- Talde bat gehitu.
//		5- Jokalaria erakutsi ID-a emanda.
//		6- Taldea ikusi ID-a emanda.
//		7- IRTEN.
		Scanner sc = new Scanner(System.in);
		FutbolariaConnect futcon = new FutbolariaConnect();
		TaldeaConnect talcon = new TaldeaConnect();
		int aukera = 0;
		do {
			System.out.println("Menua");
			System.out.println("1 Jokalariak ikusi");
			System.out.println("2 Taldeak ikusi");
			System.out.println("3 Jokalari bat gehitu");
			System.out.println("4 Talde bat gehitu");
			System.out.println("5 Jokalaria erakutsi ID-a emanda");
			System.out.println("6 Taldea ikusi ID-a emanda");
			System.out.println("7 IRTEN");
			aukera = sc.nextInt();

			switch (aukera) {
			case 1:
				ArrayList<Futbolaria> futbolariList = futcon.futbolariGuztiak();
				for (int i=0;i<futbolariList.size();i++) {
					System.out.println(futbolariList.get(i).toString());
				}
				break;
			case 2:
				ArrayList<Taldea> taldeList = talcon.taldeGuztiak();
				for (int i=0;i<taldeList.size();i++) {
					System.out.println(taldeList.get(i).toString());
				}
				break;
			case 3:
				futbolariaSortu(sc, futcon);
				break;
			case 4:
				taldeaSortu(sc, talcon);
				break;
			case 5:
				futbolariaIDtik(sc, futcon);
				break;
			case 6:
				taldeaIDtik(sc, talcon);
				break;
			case 7:
				System.out.println("Amaiera.");
				break;
			default:
				System.out.println("ADI! Sartutako aukera ez da baliozkoa");
			}
		} while (aukera != 7);
	}

	private static void taldeaSortu(Scanner sc, TaldeaConnect talcon) throws SQLException {
		Taldea talde = new Taldea();
		sc.nextLine();
		System.out.println("Sartu sortu nahi duzun taldearen izena:");
		talde.setIzena(sc.nextLine());
		System.out.println("Sartu sortu nahi duzun taldearen herria:");
		talde.setHerria(sc.nextLine());
		talcon.taldeaSortu(talde);
		System.out.println("Taldea zuzen sortu da.");
	}

	private static void futbolariaSortu(Scanner sc, FutbolariaConnect futcon) throws SQLException {
		Futbolaria futbolari = new Futbolaria();
		System.out.println("Sartu futbolariaren NAN zenbakia:");
		futbolari.setDni(sc.next());
		sc.nextLine();
		System.out.println("Sartu futbolariaren izena:");
		futbolari.setIzena(sc.nextLine());
		System.out.println("Sartu futbolariaren abizena:");
		futbolari.setAbizena(sc.nextLine());
		System.out.println("Sartu futbolariaren soldata:");
		futbolari.setSoldata(sc.nextInt());
		System.out.println("Sartu futbolariaren taldearen ID-a:");
		futbolari.setidTaldea(sc.nextInt());
		futcon.futbolariaSortu(futbolari);
		System.out.println("Futbolaria zuzen sortu da.");
	}

	private static void taldeaIDtik(Scanner sc, TaldeaConnect talcon) throws SQLException {
		System.out.println("Sartu bilatu nahi duzun taldearen ID-a:");
		int bilaketa = sc.nextInt();
		Taldea talde = talcon.taldeaIdtik(bilaketa);
		if (talde.getIzena() == null) {System.out.println("Talde hori ez da existitzen.");} else {
			System.out.println(talde.toString());
		}
	}

	private static void futbolariaIDtik(Scanner sc, FutbolariaConnect futcon) throws SQLException {
		System.out.println("Sartu bilatu nahi duzun taldearen ID-a:");
		int bilaketa = sc.nextInt();
		Futbolaria futbolari = futcon.futbolariaIDtik(bilaketa);
		if (futbolari.getDni() == null) {
			System.out.println("Futbolari hori ez da existitzen.");
		} else {
			System.out.println(futbolari.toString());
		}
	}

}
