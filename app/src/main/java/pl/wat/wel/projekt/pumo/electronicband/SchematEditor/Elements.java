package pl.wat.wel.projekt.pumo.electronicband.SchematEditor;

import java.util.Date;

import static android.R.attr.author;
import static android.R.attr.value;

/**
 * Created by suchecki on 24.05.17.
 */

public class Elements {

    private String name;
    private String type;
    private int connection1;
    private int connection2;
    private float value;

    public Elements() {
        this.name = "unknown";
        this.connection1 = 0;
        this.connection2 = 0;
        this.value = 0;
    }


    public Elements(String name,String type, int connection1, int connection2, float value) {
        this.name = name;
        this.type = type;
        this.connection1 = connection1;
        this.connection2 = connection2;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConnection1() {
        return connection1;
    }

    public int getConnection2() {
        return connection2;
    }


    public void setConnection1(int connection1) {
       this.connection1= connection1;
    }

    public void setConnection2(int connection2) {
        this.connection2= connection2;
    }


    public float getValue(){
        return value;
    }

    public void setValue(float value){
        this.value=value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{" + type +
                "name='" + name + '\'' +
                ", connection1='" + connection1 + '\'' +
                ", connection2=" + connection2 + '\'' +
                ", wartosc=" +value +
                '}';
    }
}
