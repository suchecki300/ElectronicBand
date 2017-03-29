package pl.wat.wel.projekt.pumo.electronicband;

/**
 * Created by Damian-Ja on 2017-03-29.
 */

public class List {

    //========     Zmienne do przechowywania danych o konkretnym elemencie z listy.    =============

    private String wordText;
    private int pictureID;

    //==============================================================================================

    /**
     * Konstruktor tworzący obiekt, przyjmujący pojedynczy parametr. Ustawia tekst, który zostanie
     * wyświetlony w liście.
     *
     * @param wordText Tekst, który ma być wyświetlony.
     */
    public List(String wordText) {
        this.wordText = wordText;
    }

    /**
     * Konstruktor tworzący obiekt, przyjmujący dwa parametry. Ustawia tekst oraz charakterystyczne
     * zdjęcie, które zostaną wyświetlone w liście.
     *
     * @param wordText   Tekst, który ma być wyświetlony.
     * @param id_zdjecia Nazwa zdjęcia z folderu res np. R.raw.przykladowe_zdjecie
     */
    public List(String wordText, int id_zdjecia) {
        this.wordText = wordText;
        this.pictureID = id_zdjecia;
    }

    /**
     * Getter zwracający zawartość pola wordText
     *
     * @return Zwracana zmienna typu String
     */
    public String getWordText() {
        return wordText;
    }

    /**
     * Getter zwracający zawartość pola pictureID.
     *
     * @return Zwaracana zmienna typu int.
     */
    public int getPictureID() {
        return pictureID;
    }
}
