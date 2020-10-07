package na.severinchik.listsample;

public class Purse {
    private String name;
    private String key;
    private boolean expanded;

    public Purse(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Purse{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}
