import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.Scanner;


// Benjamin A. Thomas. Benjamat
//OBS: Jeg skjonte ikke oppgaven for den uka her.
//OBS fortsetter: Dermed lite tid til kommentering og javadoc. Beklager.


class Benjamin4 {
    public static void main(String args[]) {
	System.out.println("*** VELKOMMEN TIL BENJAMINS 4. OBLIG ***");
	Test test = new Test();
	System.out.println("*** TAKK FOR BESOKET TIL BENJAMINS 4. OBLIG ***");
    }
}

class Test {
    INF1010samling<String, Person> personBeholder;
    INF1010samling<String, Kjoretoy> bilBeholder;

    Test () {
        personBeholder = new SELLbeholder<String, Person>();
        bilBeholder = new SELLbeholder<String, Kjoretoy>();

        fil();
	//eiere();
	//kjoretoy();


	//INF1010samling <String, Person> minBeholder;

    }

    void eiere () {
	int testeTell = 0;
	for (Person p: personBeholder) {
	    //  System.out.println(p.hentNavn());
	    testeTell++;
	    if (p.mineBiler.antall() > 0) {
		System.out.println(p.hentNavn());
		System.out.println("Mitt antall kjoretoy: " + p.mineBiler.antall());
	    }
	    System.out.println(testeTell);
	}
    }

    void kjoretoy () {
	int testeTell = 0;
	for (Kjoretoy k: bilBeholder) {
	    System.out.println(k.regNr);
	    testeTell++;
	    System.out.println(testeTell);
	}
    }

    // Folk og biler leses inn her.
    //og fil2 da. Blir det til.

    void fil () {
	File fil1 = new File("nyeData");
	File fil2 = new File("eierOgRepData");

	try {
	    Scanner f = new Scanner(fil1);

	    f.nextLine();
	    int listePersoner = f.nextInt();

	    String nyPerson = null;
	    String nyMekaniker = null;

	    String nyBil = null;
	    int nyBilTakst = 0;

	    String nyLastebil = null;
	    int nyLastebilTakst = 0;

	    String nyBuss = null;
	    int nyBussTakst = 0;	    

	    int antallPersoner = 0;
	    int antallMekanikere = 0;
	    int antallBiler = 0;
	    int antallLastebiler = 0;
	    int antallBusser = 0;

	    //Personer
	    while (antallPersoner <= listePersoner) {
		if (f.hasNextLine()) {
		    nyPerson = f.nextLine();
		    Person p = new Person(nyPerson);
		    personBeholder.leggInn(nyPerson, p);
		    //System.out.println(nyPerson);
		    antallPersoner++;
		}
	    }

	    f.nextLine();
	    int listeMekanikere = f.nextInt();

	    //Mekanikere
	    while (antallMekanikere <= listeMekanikere) {
		if (f.hasNextLine()) {

		    nyMekaniker = f.nextLine();
		    Mekaniker m = new Mekaniker(nyMekaniker);
		    personBeholder.leggInn(nyMekaniker, m);
		    antallMekanikere++;

		}
	    }	   

	    f.nextLine();
	    int listeBiler = f.nextInt();

	    //Biler
	    while (antallBiler < listeBiler) {
		if (f.hasNextLine()) {
		    nyBil = f.next();
		    nyBilTakst = f.nextInt();
		    Bil b = new Bil(nyBil, nyBilTakst);
		    bilBeholder.leggInn(nyBil, b);
		    //	    	    System.out.println(nyBil);
		    f.nextLine();
		    antallBiler++;
		}
	    }	

	    f.nextLine();
	    int listeLastebiler = f.nextInt();

	    //Lastebiler
	    while (antallLastebiler < listeLastebiler) {
		if (f.hasNext()) {
		    nyLastebil = f.next();
		    nyLastebilTakst = f.nextInt();
		    Lastebil b = new Lastebil(nyLastebil, nyLastebilTakst);
		    bilBeholder.leggInn(nyBil, b);
		    //	    	    System.out.println(nyLastebil);
		    f.nextLine();
		    antallLastebiler++;
		}
	    }	

	    
	    f.nextLine();
	    int listeBusser = f.nextInt();

	    //Busser
	    while (antallBusser < listeBusser) {
		if (f.hasNextLine()) {
		    nyBuss = f.next();
		    nyBussTakst = f.nextInt();
		    Buss b = new Buss(nyBuss, nyBussTakst);
		    bilBeholder.leggInn(nyBil, b);
		    //	    System.out.println(nyBuss);
		    //System.out.println("Denne takst: " + nyBussTakst);
		    f.nextLine();
		    antallBusser++;
		}
	    }

	    f.close();
	    //Lukker scanner.

	} catch (FileNotFoundException e) {
	    System.out.println("Fil 1 ikke funnet.");
	    e.printStackTrace();
	}
	catch (Exception e) {
	    System.out.println("Linje 1 ikke funnet.");
	}



	try {
	    Scanner b = new Scanner(fil2);

	    String nyEier = null;
	    String nyBilEid = null;
	    int antallEierskap = 0;

	    b.nextLine();

	    int eierListe = b.nextInt();
	    //  int testTeller = 390;

	    //Eierskap
	    while (antallEierskap < eierListe) {
		if (b.hasNextLine()) {

		    nyBilEid = b.next();
		    b.skip("  ");
		    nyEier = b.nextLine();

		    Person p = personBeholder.hent(nyEier);
		    Kjoretoy k = bilBeholder.hent(nyBilEid);

		    p.mineBiler.leggInn(nyBilEid, k);

		    //   b.nextLine();
		    //		    System.out.println("Bil:" + nyBilEid);
				    //	    System.out.println("Eier:" + nyEier);
		    antallEierskap++;
		    // testTeller++;
		}
	    }


	    String nyBilReparert = null;
	    String nyReparasjonAv = null;
	    int antallReparasjoner = 0;

	    b.nextLine();

	    int repListe = b.nextInt();
	    //	    int testTeller = 4990;

	    //Reparasjoner
	    while (antallReparasjoner < repListe) {
		if (b.hasNextLine()) {

		    nyBilReparert = b.next();
		    b.skip("  ");
		    nyReparasjonAv= b.nextLine();

		    Person p = personBeholder.hent(nyReparasjonAv);
		    Kjoretoy k = bilBeholder.hent(nyBilReparert);

		    k.kjoretoyetsReperasjoner.leggInn(nyReparasjonAv, p);
		    //kjoretoyetsReperasjoner;

		    //   b.nextLine();
		    	    System.out.println("Bil:" + nyBilReparert);
		    	    System.out.println("Reppist:" + nyReparasjonAv);
			    System.out.println("Replist:"+repListe);
		    antallReparasjoner++;
		    //	    testTeller++;
		}
	    }

	    b.close();



	} catch (FileNotFoundException e) {
	    System.out.println("Fil 2 ikke funnet.");
	    e.printStackTrace();
	}
	catch (Exception e) {
	    System.out.println("Linje 2 ikke funnet.");
	}


    }
}

class Filleser {

    //void fil (SELLbeholder personBeholder, SELLbeholder bilBeholder) 
    //Kan hende denne returnerer
    //	} catch (Exception e) { 
    //	    System.out.println("Noe er galt.");
    //	    f = null;}

    //if f equals personer read nextline as number, nextline as new person
    //Repeat lignende for resten.
    //f = new Scanner(new File("EierOgRepData"));
}

class SELLbeholder<N extends Comparable<N> , V> implements INF1010samling<N,V> {
    int antall = 0;

    private Lelem forste;

    public SELLbeholder() {
	//	System.out.println("TEST");//Fikk en kompileringsfeil uten.
    }

    private class Lelem {
	Lelem neste;
	V verdi;
	N nokkel;

	Lelem(N n, V v) {
	    nokkel = n;
	    verdi = v;
	}
    }

    public void leggInn(N n, V v) {

	if (forste == null) {
	    Lelem lel = new Lelem(n, v);
	    forste = lel;
	    antall++;
	    return;
	}

	if (inneholder(n)) {
	    return;
	}
	//beholder disse - pilhode
	if (antall==1) {
	    Lelem lel = new Lelem(n, v);
	    if (lel.nokkel.compareTo(forste.nokkel) > 0) {
		forste.neste = lel;
		antall++;
		return;
	    } else {
		Lelem tmp1 = forste;
		forste = lel;
		forste.neste = tmp1;
		antall++;
		return;
	    }
	} 

	//Hvis antall er storre enn 1...

	Lelem lel = new Lelem(n, v);//Mangler sjekk for forste her. Skrives om tid rekkes.
	//if mindre enn forste, if storre enn forste.neste er en mulighet?
	for (Lelem en = forste; en!=null; en=en.neste) {

	    //Legger inn denne for aa kontrollere forste bortsett fra ved forstelesing som skjer over naar antall er 1.
	    if(lel.nokkel.compareTo(forste.nokkel) == 0 && lel.nokkel.compareTo(forste.nokkel) < 0) {
		Lelem tmp1 = forste;
		forste = lel;
		lel.neste = tmp1;
		antall++;
		return;
	    }

	    if (en.neste != null) {

		if (lel.nokkel.compareTo(en.nokkel) > 0 && lel.nokkel.compareTo(en.neste.nokkel) < 0) {
		    Lelem tmp1 = en.neste;
		    en.neste = lel;
		    lel.neste = tmp1;
		    antall++;
		    return;

		}

	    } else {

		if (lel.nokkel.compareTo(en.nokkel) > 0) {
		    en.neste = lel;
		    antall++;
		}

	    }

	}

    }

    public int antall() {
	return antall;
    }

    public V hent(N n)  {
	for (Lelem en = forste; en!=null; en=en.neste) {
	    if (en.nokkel.compareTo(n) == 0) {
		return en.verdi;//Eller nokkel?
	    } 
	}
	return null;
    }

    public V hent(int nr) {
	int teller = 0;
	if (nr > antall) {
	    return null;
	}
	for (Lelem en = forste; en!=null; en=en.neste) {
	    teller++; 
	    if (teller == nr) {
		return en.verdi;
	    }
	}
	return null;
    }

    public V hentMinste() {
	if (forste != null) {
	    return forste.verdi;
	} else {
	    return null;
	}
    }

    public V hentStorste() {
	for (Lelem en = forste; en!=null; en=en.neste) {
	    if (en.neste == null) {
		return en.verdi;
	    }
	}
	return null;
    }

    public boolean inneholder(N n) {
	for (Lelem en = forste; en!=null; en=en.neste) {
	    if (en.nokkel.compareTo(n) == 0) {
		return true;
	    } 
	}
	return false;//....
    }

    public boolean fjernElement(N n) {
	if (inneholder(n)) {
	    //Hvis forste skal ut. Kast ut forste.
	    if (forste.nokkel.compareTo(n) == 0) {
		forste = forste.neste;
		antall--;
		return true;
	    }
	    //Hvis ikke...
	    for (Lelem en = forste; en!=null; en=en.neste) {
		if(en.neste.nokkel.compareTo(n) == 0) {
		    en.neste = en.neste.neste;//Hvis det er den siste som fjernes, resirkuleres dens null til den sistemann.
		    antall--;
		    return true;
		} 
	    }
	}
	return false;
    }

    public void fjernAlle() {

	if (forste==null) {
	    return;
	}

	forste=null;
	antall=0;

	return;
    }

    public V[] tilArray(V[] a) {
	if (forste==null) {
	    return null;
	}
	int aTeller=0;
	for (Lelem en = forste; en!=null; en=en.neste) {
	    a[aTeller] = en.verdi;
	    aTeller++;
	}
	return a;
    }

    public Iterator iterator() {
	return new SingelIterator();
    }

    //Iterator ferdig og fungerende.
    class SingelIterator implements Iterator<V> {

	Lelem neste;
	Lelem forrige;
	boolean fjernet = false;
	boolean start = true;

	SingelIterator() {
	    neste=null;
	}
	public V next() {
	    if (start) {
		start = false;
	        neste = forste.neste;
		return forste.verdi;
	    }

	    if (neste == null) {
		throw new NoSuchElementException();
	    }

	    fjernet = false;
	    forrige = neste;
	    neste = neste.neste;
	    return forrige.verdi;
	}

	public boolean hasNext() {
	    if (start) {
		return (forste != null);
	    }
	    return (neste != null);
	}

	public void remove() {
	    if (start) {
		throw new IllegalStateException();
	    }
	    
	    if (fjernet == false) {
		if (forrige==null) {
		    fjernElement(forste.nokkel);
		    fjernet = true;
		    return;
		}
		fjernElement(forrige.nokkel);
	    }
	    fjernet = true;

	}
    }

}

class Person {
    private String navn;
    boolean mekaniker = false;
    SELLbeholder<String, Kjoretoy> mineBiler;

    Person(String navn) {
	mineBiler = new SELLbeholder<String, Kjoretoy>();
	this.navn = navn;
    }

    public String hentNavn() {
	return navn;
    }

    public boolean eierJegBil () {
	return (mineBiler.antall() >= 1);
	//Jeg tror ikke dette er greit utifra oppgaveteksten, 
	//men med daarlig tid og litt usikkerhet maa jeg gjore dette i starten. 
	//Om jeg ikke rekker mer blir det saann som dette.
    }

    public boolean ulovligEgenReperasjon () {
	if (mekaniker) {
	    return false;
	} else {
	    for (Kjoretoy b: mineBiler) {

		for (Person p: b.kjoretoyetsReperasjoner) {

		    if (b.kjoretoyetsReperasjoner.inneholder(hentNavn())) {
			return true;
		    }

		}

	    }
	    return false;
	}
    }

}


class Mekaniker extends Person {

    SELLbeholder<String, Kjoretoy> gjennomforteReperasjoner;
    boolean mekaniker = true;

    Mekaniker(String navn) {
	super(navn);
	gjennomforteReperasjoner = new SELLbeholder<String, Kjoretoy>();
    }

    // public boolean erJegMekaniker () {
    // 	return (mekaniker);
    // }

}

// class Reperasjoner {
//     String test;
//     int vanligRep = 0;
//     int mekanikerRep = 0;
//     Reperasjoner () {
// 	System.out.println("Reperasjoner gjennomfort!");
//     }
// }

abstract class Kjoretoy {

    String regNr;
    double takst;
    double avgift = 0.5;
    SELLbeholder<String, Person> kjoretoyetsReperasjoner;

    Kjoretoy(String regNr, double takst) {
	this.regNr = regNr;
	this.takst = takst;
        kjoretoyetsReperasjoner = new SELLbeholder<String, Person>();
    }

    double avgift() {
	return takst*0.05;
    }
}

class Bil extends Kjoretoy {

    SELLbeholder<String, Person> kjoretoyetsReperasjoner;

    Bil(String regNr, double takst) {
	super(regNr, takst);
	kjoretoyetsReperasjoner = new SELLbeholder<String, Person>();
	//Biler 7,5% hvis bare mekanikere over halvparten av gangene, 10% hvis ikke
    }

    int antallReparasjoner() {
	return kjoretoyetsReperasjoner.antall();
    }

    boolean harMekGjortMest () {
	int mekTeller = 0;
	int pTeller = 0;
	for (Person p: kjoretoyetsReperasjoner) {
	    if (p.mekaniker) {
		mekTeller++;
	    }
	    if (!p.mekaniker) {
		pTeller++;
	    }
	}
	int totalDelt = mekTeller+pTeller/2;

	if (mekTeller > totalDelt) {
	    return true;
	} else {
	    return false;
	}
    }

    boolean harMekGjortAlt () {
	int mekTeller = 0;
	int pTeller = 0;
	for (Person p: kjoretoyetsReperasjoner) {
	    if (p.mekaniker) {
		mekTeller++;
	    }
	    if (!p.mekaniker) {
		pTeller++;
	    }
	}

	if (pTeller == 0) {
	    return true;
	} 
	return false;
    }

    double avgift() {
	if (kjoretoyetsReperasjoner.antall() == 0) {
	    return takst*0.05;
	}  
	if (harMekGjortAlt()) {
	    return takst*0.05;
	}
	if (harMekGjortMest()) {
	    return takst*0.075;
	}
	return takst*0.10;
    }
}

class Lastebil extends Kjoretoy {

    SELLbeholder<String, Person> kjoretoyetsReperasjoner;

    Lastebil(String regNr, double takst) {
	super(regNr, takst);
	kjoretoyetsReperasjoner = new SELLbeholder<String, Person>();
	//3,4% av taksten hvis bare mekanikere eller ikke, hvis ikke, 12%.
    }

    int antallReparasjoner() {
	return kjoretoyetsReperasjoner.antall();
    }

    boolean harMekGjortMest () {
	int mekTeller = 0;
	int pTeller = 0;
	for (Person p: kjoretoyetsReperasjoner) {
	    if (p.mekaniker) {
		mekTeller++;
	    }
	    if (!p.mekaniker) {
		pTeller++;
	    }
	}
	int totalDelt = mekTeller+pTeller/2;

	if (mekTeller > totalDelt) {
	    return true;
	} else {
	    return false;
	}
    }

    boolean harMekGjortAlt () {
	int mekTeller = 0;
	int pTeller = 0;
	for (Person p: kjoretoyetsReperasjoner) {
	    if (p.mekaniker) {
		mekTeller++;
	    }
	    if (!p.mekaniker) {
		pTeller++;
	    }
	}

	if (pTeller == 0) {
	    return true;
	} 
	return false;
    }

    double avgift() {
	if (kjoretoyetsReperasjoner.antall() == 0) {
	    return takst*0.034;
	}  
	if (harMekGjortAlt()) {
	    return takst*0.034;
	}
	// if (harMekGjortMest()) {
	//     return takst*0.075;
	// }
	return takst*0.12;
    }
}

class Buss extends Kjoretoy {

    SELLbeholder<String, Person> kjoretoyetsReperasjoner;

    Buss(String regNr, double takst) {	
	super(regNr, takst);
	
	kjoretoyetsReperasjoner = new SELLbeholder<String, Person>();
	//3,4% av taksten hvis bare mekanikere eller ikke, hvis ikke, 12%.
    }

    int antallReparasjoner() {
	return kjoretoyetsReperasjoner.antall();
    }

    boolean harMekGjortMest () {
	int mekTeller = 0;
	int pTeller = 0;
	for (Person p: kjoretoyetsReperasjoner) {
	    if (p.mekaniker) {
		mekTeller++;
	    }
	    if (!p.mekaniker) {
		pTeller++;
	    }
	}
	int totalDelt = mekTeller+pTeller/2;

	if (mekTeller > totalDelt) {
	    return true;
	} else {
	    return false;
	}
    }

    boolean harMekGjortAlt () {
	int mekTeller = 0;
	int pTeller = 0;
	for (Person p: kjoretoyetsReperasjoner) {
	    if (p.mekaniker) {
		mekTeller++;
	    }
	    if (!p.mekaniker) {
		pTeller++;
	    }
	}

	if (pTeller == 0) {
	    return true;
	} 
	return false;
    }

    double avgift() {
	if (kjoretoyetsReperasjoner.antall() == 0) {
	    return takst*0.034;
	}  
	if (harMekGjortAlt()) {
	    return takst*0.034;
	}
	// if (harMekGjortMest()) {
	//     return takst*0.075;
	// }
	return takst*0.12;
    }

}
