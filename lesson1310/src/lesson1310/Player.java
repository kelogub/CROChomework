package lesson1310;

public class Player {
    /**
     * @param name is the String Object of name of the Song.
     * @param storage is the String Object of storage, keeps the Song.
     */
    private String name;
    private String storage;

    Player(String name, String storage){
        this.name = name;
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public String getStorage() {
        return storage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
