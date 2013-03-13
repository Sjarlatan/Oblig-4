class Benjamin4 {
    public static void main(String args[]) {
	System.out.println("LOLOLOLOLOL");
	Test test = new Test();
    }
}

class Test {
    SELLbeholder<String, String> beholder = new SELLbeholder<String, String>();
    
    //String Benjamin = "Benjamin";
    //String Benjaminverdi = "10010101";
    
    //beholder.leggInn(N "Benjamin", V "Benjaminverdi");
}

class SELLbeholder<N extends Comparable<N> , V> implements INF1010samling<N,V> {
    int antall = 0;

    //Usikker om bruk.
    Lelem hode = new Lelem(null, null);
    Lelem hale = new Lelem(null, null);

    private Lelem forste;

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
	    return;
	}

	if (inneholder(n)) {
	    return;
	}

	Lelem lel = new Lelem(n, v);
	lel.neste = forste;
	forste = lel;
	antall++;
    }

    public int antall() {
	return antall;
    }

    public V hent(N n)  {
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

