package pl.wat.wel.projekt.pumo.electronicband.Courses;

/**
 * Created by Damian Bondaruk on 2017-05-24.
 */

public class CourseModel {
    private String tittle;
    private int imageId;
    private String urlAdres;

    public CourseModel(String tittle, int imageId, String urlAdres) {
        this.tittle = tittle;
        this.imageId = imageId;
        this.urlAdres = urlAdres;
    }

    public String getTittle() {
        return tittle;
    }

    public int getImageId() {
        return imageId;
    }

    public String getUrlAdres() {
        return urlAdres;
    }
}
