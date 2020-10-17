package lesson1310;

import java.util.Scanner;

public class Main {
    /**
     * prints formatted string what shows if the chosen song can be played on the chosen player
     * @param player the Object Player you want to check.
     * @param song the Object Song you want to check if it can be played on the Player
     * @author kelogub
     */
    public static void canPlay(Player player, Song song) {
        if ((player.getStorage().toLowerCase().equals(song.getStorage().toLowerCase())) || player.getStorage().toLowerCase().equals("universal")) {
            System.out.printf("%16s %12s %s by %s from %s %n",player.getName(),"PLAYS", song.getName(), song.getPerformer(), song.getStorage());
        } else
            System.out.printf("%16s %.14s %s by %s from %s %n",player.getName(),"CAN NOT PLAY" ,song.getName(), song.getPerformer(), song.getStorage());
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player[] players = new Player[5];
        players[0] = new Player("cd Player", "CD");
        players[1] = new Player("Universal Player", "universal");
        players[2] = new Player("MP3 Player", "Flash_card");
        players[3] = new Player("USB PLAYER", "USB_FLASH");
        players[4] = new Player("Vinyl Reel", "Vinyl_disk");

        Song[] songs = new Song[20];

        songs[0] = new Song("Normandie", "White_Flag", "USB_FLASH");
        songs[1] = new Song("Normandie", "Awakening", "FlAsH_CaRd");
        songs[2] = new Song("916frosty", "enough", "FLASH_CARD");
        songs[3] = new Song("BONES", "The Road Less Traveled", "Vinyl_disk");
        songs[4] = new Song("Paris Shadows", "Enough's Enough", "USB_FLASH");
        songs[5] = new Song("$uicideboy$", "Sour Grapes", "CD");
        songs[6] = new Song("Lil Peep", "Runaway", "Vinyl_disk");
        songs[7] = new Song("Brennan Savage", "Look at Me Now", "cd");
        songs[8] = new Song("Killstation", "VENGEANCE", "Flash_card");
        songs[9] = new Song("BONES", "Rocks", "Vinyl_disk");
        songs[10] = new Song("Brennan Savage", "To The Moon", "USB_FLASH");
        songs[11] = new Song("Paris Shadows", "Bones", "Vinyl_disk");
        songs[12] = new Song("Lil Peep feat. Xavier Wulf", "drive by", "cd");
        songs[13] = new Song("BONES", "RestInPeace", "Vinyl_disk");
        songs[14] = new Song("Killstation", "Premonition", "Flash_card");
        songs[15] = new Song("Brennan Savage", "Dreams of You", "Vinyl_disk");
        songs[16] = new Song("$uicideboy$", "My Flaws Burn Through...", "Vinyl_disk");
        songs[17] = new Song("Lil Peep", "Star Shopping", "Flash_card");
        songs[18] = new Song("Killstation", "Extinction", "cd");
        songs[19] = new Song("Lil Peep", "Problems", "USB_FLASH");

        for (Song song : songs) {
//            if (song.getStorage() == "") System.out.println(song.toString());
            for (Player player : players) {
                canPlay(player, song);
            }
            System.out.printf("%s%n","--------------------------------------------------------------------------------------");
        }

    }
}
