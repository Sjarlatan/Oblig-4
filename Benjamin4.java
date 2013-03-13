class Benjamin4 {
    public static void main(String args[]) {
	System.out.println("LOLOLOLOLOL");
	Test test = new Test();
    }
}

class Test {
    Test () {
	SELLbeholder<String, Person> testbeholder = new SELLbeholder<String, Person>();
	//INF1010samling <String, Person> minBeholder;
	Person a = new Person("Benjamin");
	testbeholder.leggInn(a.navn, a);
    
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
    //private Lelem siste;

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
	    lel.neste = forste;
	    forste = lel;
	    antall++;
	    return;
	}

	if (inneholder(n)) {
	    return;
	}
	//beholder disse - pilhode
	Lelem lel = new Lelem(n, v);
	if (antall==1) {
	    if (lel.nokkel.compareTo(forste.nokkel) > 0) {
		forste.neste = lel;
		lel.neste = forste;
		antall++;
		return;
	    } else {
		lel.neste = forste;
		forste = lel;
		forste.neste = lel;
		return;
	    }
	} else {//Hvis antall er storre enn 1...
	   for (Lelem en = forste; en!=null; en=en.neste) {

	       if (lel.nokkel.compareTo(en.nokkel) > 0 && lel.nokkel.compareTo(en.neste.nokkel < 0) {

		       Lelem tmp1 = en.neste;
		       en.neste = lel;
		       lel.neste = tmp1;

		   }

	   }
	}
    }

    public int antall() {
	return antall;
    }

    public V hent(N n)  {
	for (Lelem en = forste; en!=null; en=en.neste) {
	    if (en.nokkel.compareTo(n) != 0) {
		return en.verdi;//Eller nokkel?
	    } 
	}
	return null;
    }

    public V hent(int nr) {
	return null;
    }

    public V hentMinste() {
	return null;
    }

    public V hentStorste() {
	return null;
    }

    public boolean inneholder(N n) {
	for (Lelem en = forste; en!=null; en=en.neste) {
	    if (en.nokkel.compareTo(n) != 0) {
		return true;
	    } 
	}
	return false;//....
    }

    public boolean fjernElement(N n) {
	return false;
    }

    public void fjernAlle() {
	return;
    }

    public V[] tilArray(V[] a) {
	return null;
    }
}

class Person {
    String navn;

    Person(String navn) {
	this.navn = navn;
    }
}
