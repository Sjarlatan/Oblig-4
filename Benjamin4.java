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

    public SELLbeholder() {
	System.out.println("TEST");
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
	for (Lelem en = forste; en!=null; en=en.neste) {
	    	Lelem lel = new Lelem(n, v);
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
		
		Lelem forste;
		Lelem neste;
		boolean ringForrige=false;
		
		SingelIterator() {
			neste=hode;
			forrige=hode;
		}
		
		
		public boolean hasNext() {
			
			return neste.neste != null;
		}

		
		public T next() {
			
			Node temp;
			ringForrige=true;
			if(forrige ==hode) {
				temp =neste.neste;
				neste= neste.neste;
			}else{
				temp=hode.neste.neste;
				forrige=neste;
				neste=neste.neste;
			}
			forrige=neste;
			neste=neste.neste;
			
			return temp.verdi;
		}

		
		public void remove() {
			if(ringForrige) {
				ringForrige=false;
				forrige.neste=forrige.neste.neste;
			}else{
				throw new IllegalStateException();
			}
		}
		
	}

}

class Person {
    String navn;

    Person(String navn) {
	this.navn = navn;
    }
}
