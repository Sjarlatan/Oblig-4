public interface INF1010samling<N extends Comparable<N>, V> extends Iterable <V> {

    /**
     * Legger inn et objekt/element i beholderen
     * @param  n  n�kkelen som er knyttet til objektet v
     * @param  v  peker til objektet som skal inn i beholderen
     */
    public void leggInn(N n, V v);

    /**
     * Returnerer antall objekter i beholderen.
     * @return antall objekter i beholderen
     */ 
    public int antall();

    /**
     * Henter objektet knyttet til n�kkelen.
     * @param  n  n�kkelen 
     * @return objektet assosiert med n�kkel n
     */
    public V hent(N n);

    /**
     * Henter et objekt med et spesifikt nummer.
     * Forutsetter at objektene er ordnet i en rekkef�lge i beholderen
     * @param  nr  nummeret til objektet som skal returneres
     * @return objekt nummer nr dersom nr er st�rre enn 0 og
     *         mindre enn antall(), ellers null
     */
    public V hent(int nr);

    /**
     * Hent objektet med den minste n�kkelen i beholderen.
     * @return objektet med den minste n�kkelen
     */
    public V hentMinste();

    /**
     * Hent objektet med den st�rste n�kkelen i beholderen.
     * @return objektet med den st�rste n�kkelen
     */
    public V hentStorste();

    /**
     * Returnerer sant dersom beholderen inneholder et objekt
     * knyttet til n�kkelen n.
     * @param  n  n�kkelen som identifiserer objektet
     * @return true hvis det finnes et objekt med n�kkel nkl i
     *         beholderen slik at nkl.compareTo(n) == 0
     */
    public boolean inneholder(N n);

    /**
     * Fjerner objektet knyttet til n�kkelen n dersom det finnes.
     * @param  n  en n�kkel som identifiserer objektet som skal
     *            fjernes 
     * @return true hvis elementet fjernes
     */
    public boolean fjernElement(N n);

    /**
     * Fjerner alle objektene lagret i beholderen.
     */
    public void fjernAlle();

    /**
     * Fyller en array med alle objektene i beholderen,
     * i samme rekkef�lge som de ligger i beholderen
     * @param  a  peker til en array av typen V
     * @return en array med objektene i samme rekkef�lge
     */
    public V[] tilArray(V[] a);
}
