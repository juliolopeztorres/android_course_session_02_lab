package oob.fruitworld.models;

public class Fruit {
    private String name;
    private String origin;
    private int icon;

    public Fruit(String name, String origin, int icon) {
        this.name = name;
        this.origin = origin;
        this.icon = icon;
    }

    // ------------------ Getter & Setters ------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
