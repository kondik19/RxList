package co.iteo.rxlist;

/**
 * Created by konrad on 03.02.16.
 */
public class Item {
    int id;
    String name;

    Item(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}