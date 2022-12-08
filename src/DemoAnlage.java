public class DemoAnlage {

    public static void main(String[] args) {

        Anlage maschine = new Anlage("fraesmaschine", 5000000, 13);
        maschine.abschreiben();
        Anlage neu = maschine.renew(4000, 3);
        System.out.println(neu.toString());
    }
}
