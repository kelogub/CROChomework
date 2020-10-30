package work;

import java.util.*;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static class Showtime{


        public final int rows = 9;

        public final int seats = 9;

        public volatile Set<Seat> seatSet;

        public int getRows() {
            return this.rows;
        }

        public int getSeats() {
            return this.seats;
        }

        public Showtime() {
            Set<Seat> a = new LinkedHashSet<Seat>();
            for (int i = 1; i <= this.getRows(); i++) {
                for (int j = 1; j <= this.getSeats(); j++) {
                    Seat seat = new Seat(i, j);
                    a.add(seat);
                }
            }
            this.seatSet = a;
        }


        public Set<Seat> getFreeSeats() {
            Set<Seat> set = new LinkedHashSet<Seat>();
            Iterator<Seat> iter = this.seatSet.iterator();
            Seat temp;
            while (iter.hasNext()) {
                temp = iter.next();
                if (!temp.isBooked()) set.add(temp);
            }
            return set;
        }

        public synchronized boolean bookSeat(Seat seat) {
            Iterator<Seat> iter = this.seatSet.iterator();
            Seat temp;
            boolean booked = false;
            while (iter.hasNext()) {
                temp = iter.next();
                if (temp.equals(seat) && !temp.isBooked()) {
                    temp.setBooked();
                    booked = true;
                    break;
                }
            }
            return booked;
        }
    }
    public static class MyThread extends Thread{
        public static final Object lock = new Object();

        private final Showtime showtime;

        private String user;

        public void setUser(String user){
            this.user = user;
        }

        MyThread(Showtime showtime, String user){
            this.showtime = showtime;
            this.user = user;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("Свободные места:");
                Set<Seat> set = this.showtime.getFreeSeats();
                Iterator<Seat> iter = set.iterator();
                Seat temp = new Seat();
                System.out.printf("%14s%n", "Место");
                System.out.println("Ряд");
                boolean miss = false;
                for (int i = 1; i <= this.showtime.getRows(); i++) {
                    System.out.print((i) + ":  ");
                    for (int j = 1; j <= this.showtime.getSeats(); j++) {
                        if (iter.hasNext()&&!miss) temp = iter.next();
                        if (temp.getRow() == i && temp.getSeat() == j && !temp.isBooked()) {
                            System.out.print((j) + " ");
                            miss = false;
                        }
                        else {
                            System.out.print("  ");
                            miss = true;
                        }
                    }
                    System.out.println();
                }

                System.out.println(this.user + ", Выберите место в формате \"ряд место\"");
                int row = in.nextInt();
                int seat = in.nextInt();
                Seat chosen = new Seat(row, seat);
                if (this.showtime.bookSeat(chosen)) System.out.println("Место " + row + "/" + seat + " успешно забронировано!");
                else {
                    System.out.println("Место " + row + "/" + seat + " не удалось забронировать," + this.user + ", попробуйте еще раз!");
                    this.run();
                }

            }
        }
    }

    public static void main(String[] args) {
        String user1 = "Пользователь 1";
        String user2 = "Пользователь 2";
        String user3 = "Пользователь 3";
        String user4 = "Пользователь 4";
        String user5 = "Пользователь 5";
        String user6 = "Пользователь 6";

        Showtime st = new Showtime();

        MyThread mt1 = new MyThread(st, user1);
        MyThread mt2 = new MyThread(st, user2);
        MyThread mt3 = new MyThread(st, user3);
        MyThread mt4 = new MyThread(st, user4);
        MyThread mt5 = new MyThread(st, user5);
        MyThread mt6 = new MyThread(st, user6);


        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
        mt6.start();

    }
}
