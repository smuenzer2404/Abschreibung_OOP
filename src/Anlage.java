import javax.management.MBeanTrustPermission;

public class Anlage {

    public String bezeichnung;
    public double initialWert;
    public int nutzungsdauer;
    public double restWert;
    public int alter;


    public void abschreiben() {
        alter++;
        if (alter <= nutzungsdauer) {
            restWert = Math.floor(initialWert / nutzungsdauer * (nutzungsdauer - alter));
        }

    }


    public void simulate(int maxJahre, int minWert) {
        System.out.println(restWert);
        for (int i = 0; i <= maxJahre; i++) {
            System.out.println("Vorher > Jahr " + i + " " + toString());
            abschreiben();
            System.out.println("Nachher > Jahr " + i + " " + toString());


            if (restWert == 0 || restWert < minWert) {
                break;
            }
        }
    }

    public Anlage renew (int zusatzWert, int zusatzJahre) {
        double neuInitialWert = restWert + zusatzWert;
        int neuNutzungsdauer = (nutzungsdauer - alter) + zusatzJahre;
        Anlage neu = new Anlage(this.bezeichnung, neuInitialWert,
                neuNutzungsdauer);

        return neu;
    }


    public String getBezeichnung() {
        return bezeichnung;
    }

    public double getInitialWert() {
        return initialWert;
    }

    public int getNutzungsdauer() {
        return nutzungsdauer;
    }

    public double getRestWert() {
        return restWert;
    }

    public int getAlter() {
        return alter;
    }

    public Anlage(String bezeichnung, double initialWert, int nutzungsdauer) {
        this.bezeichnung = bezeichnung;
        this.initialWert = initialWert;
        this.nutzungsdauer = nutzungsdauer;
        this.restWert = initialWert;
        this.alter = 0;
    }

    @Override
    public String toString() {
        return "Anlage{" +
                "bezeichnung='" + bezeichnung + '\'' +
                ", initialWert=" + initialWert +
                ", nutzungsdauer=" + nutzungsdauer +
                ", restWert=" + restWert +
                ", alter=" + alter +
                '}';
    }
}