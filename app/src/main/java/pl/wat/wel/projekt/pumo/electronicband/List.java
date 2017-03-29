package pl.wat.wel.projekt.pumo.electronicband;

/**
 * Created by Damian-Ja on 2017-03-29.
 */

public class List {

    private String tekst;
    private int zdjecieID;

    public List(String tekst) {
        this.tekst = tekst;
    }

    public List(String tekst, int id_zdjecia) {
        this.tekst = tekst;
        this.zdjecieID = id_zdjecia;
    }

    public String getTekst() {
        return tekst;
    }

    public int getZdjecieID() {
        return zdjecieID;
    }
}
