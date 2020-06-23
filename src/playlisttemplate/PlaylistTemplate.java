/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlisttemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author User
 */
public class PlaylistTemplate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
	PlaylistEntry playlist1, playlist2, playlist3;
        playlist1 = new PlaylistEntry("Song1", "Artist1", "3:01", 4);

        playlist1.next = new PlaylistEntry("Song2", "Artist2", "1:3:02", 2);
        playlist1.next.previous = playlist1;

        playlist1.next.next = new PlaylistEntry("Song3", "Artist1", "3:03", 5);
        playlist1.next.next.previous = playlist1.next;

        playlist1.next.next.next = new PlaylistEntry("Song4", "Artist2", "3:04", 5);
        playlist1.next.next.next.previous = playlist1.next.next;

        playlist1.next.next.next.next = new PlaylistEntry("Song5", "Artist1", "3:05", 3);
        playlist1.next.next.next.next.previous = playlist1.next.next.next;

        playlist2 = new PlaylistEntry("Song6", "Artist3", "4:01", 1);

        playlist2.next = new PlaylistEntry("Song7", "Artist3", "4:02", 1);
        playlist2.next.previous = playlist2;

        playlist2.next.next = new PlaylistEntry("Song8", "Artist3", "3:07", 1);
        playlist2.next.next.previous = playlist2.next;

        playlist2.next.next.next= new PlaylistEntry("Song9", "Artist3", "4:16", 1);
        playlist2.next.next.next.previous = playlist2.next.next;

        playlist2.next.next.next.next= new PlaylistEntry("Song10", "Artist3", "4:05", 1);
        playlist2.next.next.next.next.previous = playlist2.next.next.next;

        playlist2.next.next.next.next.next= new PlaylistEntry("Song11", "Artist3", "3:07", 1);
        playlist2.next.next.next.next.next.previous = playlist2.next.next.next.next;

        playlist2.next.next.next.next.next.next= new PlaylistEntry("Song12", "Artist3", "4:12", 1);
        playlist2.next.next.next.next.next.next.previous = playlist2.next.next.next.next.next;

        playlist2.next.next.next.next.next.next.next= new PlaylistEntry("Song13", "Artist3", "4:35", 1);
        playlist2.next.next.next.next.next.next.next.previous = playlist2.next.next.next.next.next.next;

        playlist3 = new PlaylistEntry("Song12", "Artist3", "4:01");

        playlist3.next = new PlaylistEntry("Song13", "Artist3", "4:02");
        playlist3.next.previous = playlist3;

        playlist3.next.next = new PlaylistEntry("Song14", "Artist3", "4:35");		
        playlist3.next.next.previous = playlist3.next;
        
        
        PlaylistEntry a = new PlaylistEntry("song", "artist", "3:05", 4);
        System.out.println(a.next);
        PlaylistEntry b = new PlaylistEntry("another", "newcomer", "2:53", 5);
        PlaylistEntry c = new PlaylistEntry("third", "eurovision", "3:37", 1);

        b.addToEnd(c);
        System.out.println("another" + b.title);
        System.out.println("newcomer" + b.artist);
        System.out.println("173"+  b.duration);
        System.out.println(b.rating);
        System.out.println(5 + b.rating);	
        System.out.println("third" + b.next.title);
        System.out.println("eurovision" + b.next.artist);
        System.out.println("217" + b.next.duration);
        System.out.println(b.next.rating);
        System.out.println("1" +b.next.rating);	
        System.out.println(b.next.previous.title);
        System.out.println("another" + b.next.previous.title);
        System.out.println(b.next.previous.artist);
        System.out.println("newcomer"+ b.next.previous.artist);


        a.addToEnd(b); //instance copy of b should be added and not a reference copy

        System.out.println("song"+ a.title);
        System.out.println("artist"+ a.artist);
        System.out.println("185"+ a.duration);
        System.out.println(a.previous);
        System.out.println(a.rating);
        System.out.println("4" + a.rating);

        System.out.println(a.next);

        System.out.println("another"+ a.next.title);
        System.out.println("newcomer"+ a.next.artist);
        System.out.println("173" +a.next.duration);
        System.out.println(a.next.rating);
        System.out.println("5"+ a.next.rating);	
        System.out.println(a.next.previous.title);
        System.out.println("song"+ a.next.previous.title);
        System.out.println(a.next.previous.artist);
        System.out.println("artist"+ a.next.previous.artist);

        System.out.println(a.next.next); 



        a.addToFront(b); 

        System.out.println("song"+ a.title);
        System.out.println("artist"+ a.artist);
        System.out.println(185+ a.duration);
        System.out.println(a.rating);
        System.out.println(4+ a.rating);

        System.out.println(a.previous);

        System.out.println("another"+ a.previous.title);
        System.out.println("newcomer"+ a.previous.artist);
        System.out.println("173"+ a.previous.duration);
        System.out.println(a.previous.rating);
        System.out.println(5+ a.previous.rating);	
        System.out.println(a.previous.next.title);
        System.out.println("song"+ a.previous.next.title);
        System.out.println(a.previous.next.artist);
        System.out.println("artist"+a.previous.next.artist);

        System.out.println(a.previous.previous);


        
        System.out.println(playlist1.next.next.totalDuration());
        System.out.println(playlist2.next.next.next.next.totalDuration());
        System.out.println(playlist3.next.totalDuration());
        PlaylistEntry empty = new PlaylistEntry("-","-","0:0");
        System.out.println(empty.totalDuration());
		
        System.out.println(playlist1.next.countSongs());
        System.out.println(playlist2.next.countSongs());
        System.out.println(playlist3.next.countSongs());
        System.out.println(playlist1.next.next.next.countSongs());
        System.out.println(playlist2.next.next.next.next.next.next.countSongs());
        System.out.println(playlist3.next.countSongs());
        
        System.out.println("0 " + playlist1.indexOf());
        System.out.println("2 "+ playlist1.next.next.indexOf());
        System.out.println("6 "+ playlist2.next.next.next.next.next.next.indexOf());
        System.out.println("1 "+ playlist3.next.indexOf());
        
        System.out.println(playlist1.title);
        System.out.println(playlist2.getFirstSong());
        System.out.println(playlist3.getFirstSong());
        
        
        System.out.println(playlist1.toStringIndividual());
        System.out.println(playlist2.next.next.next.next.next.next.next.toStringIndividual());
        System.out.println(playlist3.next.toStringIndividual());
        
        
        System.out.println("3 "+ playlist1.next.indexOf("Song4"));
        System.out.println("-1 "+ playlist2.next.next.next.next.indexOf("Song2"));
        System.out.println("-1 "+ playlist3.next.next.indexOf("Song3"));

        System.out.println(playlist1.next.next.next.listFavouriteSongs());
        System.out.println(playlist2.next.next.next.next.listFavouriteSongs());
        System.out.println(playlist3.topRating());
   
        
        System.out.println(3+ playlist1.countSongsBy("Artist1"));
        System.out.println("2 "+ playlist1.countSongsBy("Artist2"));
        System.out.println("0 "+ playlist1.countSongsBy("Artist3"));
        System.out.println("8 "+ playlist2.countSongsBy("Artist3"));
        System.out.println("3 "+ playlist3.countSongsBy("Artist3"));
        System.out.println("0 "+ playlist3.countSongsBy("Artist4"));


        System.out.println(Arrays.toString(playlist2.next.next.next.next.getSongsBy("Artist3")));
        System.out.println("[Song6, Song7, Song8, Song9, Song10, Song11, Song12, Song13]");
        System.out.println(Arrays.toString(playlist3.next.getSongsBy("Artist3")));
        System.out.println("[Song12, Song13, Song14]");
        System.out.println(Arrays.toString(playlist1.next.next.getSongsBy("Artist3")));
        System.out.println(Arrays.toString(playlist1.next.next.getSongsBy("Artist1")));
        System.out.println("[Song1, Song3, Song5]");

        PlaylistEntry merged = playlist1.next.next.merge(playlist2.next.next.next.next);
        System.out.println("6400 " + merged.totalDuration());	
        System.out.println(" - Song1 - Artist1 (3:01) Rated 4\n" + 
                        " - Song2 - Artist2 (1:03:02) Rated 2\n" + 
                        " - Song3 - Artist1 (3:03) Rated 5\n" + 
                        " - Song4 - Artist2 (3:04) Rated 5\n" + 
                        " - Song5 - Artist1 (3:05) Rated 3\n" + 
                        " - Song6 - Artist3 (4:01) Rated 1\n" + 
                        " - Song7 - Artist3 (4:02) Rated 1\n" + 
                        " - Song8 - Artist3 (3:07) Rated 1\n" + 
                        " - Song9 - Artist3 (4:16) Rated 1\n" + 
                        " - Song10 - Artist3 (4:05) Rated 1\n" + 
                        " - Song11 - Artist3 (3:07) Rated 1\n" + 
                        " - Song12 - Artist3 (4:12) Rated 1\n" + 
                        " - Song13 - Artist3 (4:35) Rated 1\n" + 
                        "" +merged.toString());

        System.out.println("Song1"+ playlist1.getLastSong().title);
	System.out.println("Song6"+ playlist2.getLastSong().title);
	System.out.println("Song12"+ playlist3.getLastSong().title);
        
        
    }
    
}
