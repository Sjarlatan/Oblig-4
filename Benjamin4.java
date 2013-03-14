import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.Scanner;

class Filleser {

    void filNr1 () {

    	Scanner f;
	try{
	    f = new Scanner(new File("EierOgRepData"));
	} catch (Exception e) { 
	    System.out.println("Noe er galt.");
	    f = null;}

	//if f equals personer read nextline as number, nextline as new person
	//Repeat lignende for resten.

    }

    Filleser() {
	Scanner sc = new Scanner(System.in);
    }
}

class Benjamin4 {
    public static void main(String args[]) {
	System.out.println("LOLOLOLOLOL");
	Test test = new Test();
    }
}

class Test {
    Test () {
	INF1010samling<String, Person> testbeholder = new SELLbeholder<String, Person>();
	//SELLbeholder<String, Person> testbeholder = new SELLbeholder<String, Person>();
	//INF1010samling <String, Person> minBeholder;
	Person a = new Person("Benjamin");
	testbeholder.leggInn(a.hentNavn(), a);
    
	//String Benjamin = "Benjamin";
	//String Benjaminverdi = "10010101";
    
	//beholder.leggInn(N "Benjamin", V "Benjaminverdi");
	//git add .
	//git commit -am "My first test"
	//git push origin master
    }
}

class SELLbeholder<N extends Comparable<N> , V> implements INF1010samling<N,V> {
    int antall = 0;

    private Lelem forste;

    public SELLbeholder() {
	System.out.println("TEST");//Fikk en kompileringsfeil uten.
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
	    return (neste.neste != null);
	}

	public void remove() {
	    if (fjernet == false) {
		fjernElement(neste.nokkel);
	    }
	    fjernet = true;

	}
    }

}

class Person {
    private String navn;

    Person(String navn) {
	this.navn = navn;
    }

    public String hentNavn() {
	return navn;
    }

    public Boolean eierJegBil () {
	if (1==1){
	    System.out.println("Jepp.");
	    return true;
	} return false;
    }
}

class Eier extends Person {

        Eier(String navn) {
	    super(navn);
        SELLbeholder<String, Kjoretoy> mineBiler = new SELLbeholder<String, Kjoretoy>();
    }
    
}

class Mekaniker extends Person {
    Mekaniker(String navn) {
	super(navn);
SELLbeholder<String, Kjoretoy> gjennomforteReperasjoner = new SELLbeholder<String, Kjoretoy>();
    }
}

class Reperasjoner {
    String test;
    int vanligRep = 0;
    int mekanikerRep = 0;
    Reperasjoner () {
	System.out.println("Reperasjoner gjennomfort!");
    }
}

abstract class Kjoretoy {
    String regNr;
    double takst;
    double avgift = 0.5;
    Kjoretoy(String regNr, double takst) {
	SELLbeholder<String, Kjoretoy> kjoretoyetsReperasjoner = new SELLbeholder<String, Kjoretoy>();
	this.regNr = regNr;
	this.takst = takst;
    }
}

class Bil extends Kjoretoy {
    Bil(String regNr, double takst) {
	super(regNr, takst);
	//Biler 7,5% hvis bare mekanikere over halvparten av gangene, 10% hvis ikke
    }
}

class Lastebil extends Kjoretoy {
    Lastebil(String regNr, double takst) {
	super(regNr, takst);
	//3,4% av taksten hvis bare mekanikere, hvis ikke, 12%.
    }
}

class Buss extends Kjoretoy {
    Buss(String regNr, double takst) {
	super(regNr, takst);
	//3,4% av taksten hvis bare mekanikere, hvis ikke, 12%.
    }
}
