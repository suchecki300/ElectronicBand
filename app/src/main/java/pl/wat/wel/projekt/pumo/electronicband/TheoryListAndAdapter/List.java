package pl.wat.wel.projekt.pumo.electronicband.TheoryListAndAdapter;

/**
 * Created by Damian-Ja on 2017-03-29.
 */

public class List {
    private final int NO_IMAGE_PROVIDED = -1;
    private String wordText;
    private int pictureID = NO_IMAGE_PROVIDED;

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

    public boolean hasImage() {
        return pictureID != NO_IMAGE_PROVIDED;
    }

    //====   Gettery   =====
    public String getWordText() {
        return wordText;
    }

    public int getPictureID() {
        return pictureID;
    }
}
