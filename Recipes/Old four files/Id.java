package recipes;

import javax.persistence.Entity;


public class Id {


    private int id;

    public Id(int id) {
        this.id = id;
        // id++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Id{" +
                "id=" + this.id +
                '}';
    }

}


