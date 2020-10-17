package lesson1310;

public class Song {
    /**
     * @param performer is the String Object, the Song performer.
     * @param name is the String Object, name of the Song.
     * @param storage is the String Object, keeps the storage of the Song.
     */
    private String performer;
    private String name;
    private String storage;

    Song(String performer, String name, String storage){
        this.performer = performer;
        this.name = name;
        this.storage = storage;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return name + " : " + performer;
    }
}
