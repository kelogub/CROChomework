package work;

public class Seat {
    private final int row;

    private final int seat;

    private boolean booked;

    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
        this.booked = false;
    }

    public Seat() {
        this.row = 0;
        this.seat = 0;
        this.booked = false;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public void setBooked(){
        this.booked = true;
    }

    public boolean isBooked(){
        return this.booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat1 = (Seat) o;
        return row == seat1.row &&
                seat == seat1.seat;
    }
}
