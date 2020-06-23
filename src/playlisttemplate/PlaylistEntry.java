package playlisttemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PlaylistEntry {
	public String title;
	public String artist;
	public int duration; //in seconds
	public Integer rating; //should be null if not rated
	public PlaylistEntry previous;
	public PlaylistEntry next;
        public String d;
	/**
	 * 
	 * @param t (title)
	 * @param a (artist)
	 * @param d (duration as either mm:ss or hh:mm:ss)
	 */
	public PlaylistEntry(String t, String a, String d) {
            this.title=t;
            this.artist=a;

            this.rating=null;
            this.previous=null;
            this.next=null;
            this.d = d;
            String time = d;
            String[] split = time.split(":"); 
            if(split.length == 3) { 
                long minutes = TimeUnit.HOURS.toMinutes(Integer.parseInt(split[0])) + 
                                 Integer.parseInt(split[1]);
                long sec = TimeUnit.MINUTES.toSeconds(minutes)+ Integer.parseInt(split[2]);
                this.duration = (int) sec ;
             }else{
                long sec = TimeUnit.MINUTES.toSeconds(Integer.parseInt(split[0]))+ Integer.parseInt(split[1]);
                this.duration = (int) sec ;
            }
            
            
            
	}

	/**
	 *
	 * @param t (title)
	 * @param a (artist)
	 * @param d (duration as either mm:ss or hh:mm:ss)
	 * @param r (rating)
	 */
	public PlaylistEntry(String t, String a, String d, Integer r) {
            this.title=t;
            this.artist=a;
            
            this.rating=r;
            this.previous=null;
            this.next=null;
            this.d =d;
            String time = d;
            String[] split = time.split(":"); 
            if(split.length == 3) { 
                long minutes = TimeUnit.HOURS.toMinutes(Integer.parseInt(split[0])) + 
                                 Integer.parseInt(split[1]);
                long sec = TimeUnit.MINUTES.toSeconds(minutes)+ Integer.parseInt(split[2]);
                this.duration = (int) sec ;
             }else{
                long sec = TimeUnit.MINUTES.toSeconds(Integer.parseInt(split[0]))+ Integer.parseInt(split[1]);
                this.duration = (int) sec ;
            }
	}

	/**
	 * 
	 * @param t (title)
	 * @param a (artist)
	 * @param d (duration) in seconds
	 * @param r (rating)
	 */
        
	public PlaylistEntry(String t, String a, int d, Integer r) {
            this.title=t;
            this.artist=a;
            this.duration =d;
            this.rating=r;
            this.previous=null;
            this.next=null;
	}
	
	/**
	 * update the rating of the calling object
	 * @param r: assign r to rating (constrained between 1 and 5)
	 */
	public void rate(Integer r) {
            this.rating=r;
	}
	
	/**
	 * 
	 * @param song
	 * add an instance copy (and not a reference copy) of the passed song to the end of the list
	 * for example,
	 * let the ID shown in Eclipse during debug mode 
	 * 		for p be 110, 
	 * 		for p.next be 115, 
	 * 		for song be 120 and 
	 * 		for song.next be 125
	 * if p.title = "a", p.next.title = "b"
	 * song.title = "c", song.next.title = "d"
	 * 
	 * p.addToEnd(song); 
	 * 
	 * should result in p.next.next.title = "c", p.title = "a", p.next.title = "b" 
	 * and p.next.next.next = null (not the song "d")
	 * also, the ID shown in Eclipse for p.next should NOT be 120. 
	 * (because we are adding an instance copy)
	 * 
	 * upon executing
	 * p.next.next.title = "e"
	 * should result in p.title = "a", p.next.title = "b", p.next.next.title = "e"
	 * 
	 * song.title should still remain "c" (that's what it means by instance copy)
	 */
	public void addToEnd(PlaylistEntry song) {
            
            this.next =song;
            this.next.previous=this;
	}

	/**
	 * 
	 * @param song
	 * add an instance copy (and not a reference copy) of the passed song to the front of the list
	 * for example,
	 * let the ID shown in Eclipse during debug mode 
	 * 		for p be 110, 
	 * 		for p.previous be 115, 
	 * 		for song be 120 and 
	 * 		for song.previous be 125
	 * if p.title = "a", p.previous.title = "b"
	 * song.title = "c", song.previous.title = "d"
	 * 
	 * p.addToFront(song); 
	 * 
	 * should result in p.previous.previous.title = "c", p.title = "a", p.previous.title = "b" and 
	 * p.previous.previous.previous = null (not the song "d")
	 * also, the ID shown in Eclipse for p.previous should NOT be 120. 
	 * (because we are adding an instance copy)
	 * 
	 * upon executing
	 * p.previous.previous.title = "e"
	 * should result in p.title = "a", p.previous.title = "b", p.previous.previous.title = "e"
	 * 
	 * song.title should still remain "c" (that's what it means by instance copy)
	 */
	public void addToFront(PlaylistEntry song) {
            this.previous=song;
            this.previous.next=this;
            //
	}

	/**
	 * 
	 * @return the total duration (in seconds) of the playlist in which the calling object exists
	 */
        
        
	public int totalDuration() {
            
            PlaylistEntry p =this;
            int t= p.duration;
            
            PlaylistEntry p1=p; 
            PlaylistEntry p2=p;
            while(p1.next!=null){
                t=p1.next.duration+t;
                p1=p1.next;
            }
            while(p2.previous!=null){
                t=p2.previous.duration+t;
                p2=p2.previous;
            }
            return t;
	}

	/**
	 * 
	 * @return the number of songs of the playlist in which the calling object exists
	 */

	public int countSongs() {
            PlaylistEntry p =this;
            int count=1;
            
            PlaylistEntry p1=p; 
            PlaylistEntry p2=p;
            while(p1.next!=null){
                count++;
                p1=p1.next;
            }
            while(p2.previous!=null){
                count++;
                p2=p2.previous;
            }
            return count;
	}

	/**
	 * 
	 * @return index of the calling object in the list.
	 * first song in the list is at index 0
	 */
	public int indexOf() {
            
            PlaylistEntry p =this;
            int count=0;
             
            PlaylistEntry p2=p;
            
            while(p2.previous!=null){
                count++;
                p2=p2.previous;
            }
            return count;
	}

	/**
	 * 
	 * @return the first song in the list in which the calling object exists
	 */
	public PlaylistEntry getFirstSong() {
            PlaylistEntry p =this;
            while(p.previous!=null){
                p=p.previous;
            }
            return p;
		
	}

	/**
	 * 
	 * @return the last song in the list in which the calling object exists
	 */
	public PlaylistEntry getLastSong() {
		PlaylistEntry p =this;
            while(p.next!=null){
                p=p.next;
            }
            return p;
	}

	/**
	 * 
	 * @param targetTitle
	 * @return index in the list (indices begin with 0) of the required song (-1 if it doesn't exist)
	 */
	public int indexOf(String targetTitle) {
            PlaylistEntry p =this;
            int count=0;
             
            PlaylistEntry p2=p;
            
            while(p.previous!=null){
                
                p=p.previous;
            }
            if(p.title.equals(targetTitle)){
                return count;
            }
            else{
                while(p.title!=targetTitle && p.next!=null){
                    p=p.next;
                    count++;
                }
                if(p.title.equals(targetTitle)){
                    return count;
                }
                else{
                    return -1;
                }
                
            }
            
            
            
            
		
	}

	/**
	 * 
	 * @param idx
	 * @return song at given index (null if index invalid)
	 */
	public PlaylistEntry get(int idx) {
		return null;
	}

	/**
	 * 
	 * @return string representation of the calling object only (not the whole list)
	 */
        
	public String toStringIndividual() { 
            String s=" - ";
            PlaylistEntry p=this;
            
            s= s.concat(p.title +" - "+ p.artist+ " (");
            s=s.concat(p.d);
            s=s.concat(") ");
            if(p.rating!=null){
                s=s.concat("Rated "+ p.rating );
            }else{
                s=s.concat("Not rated");
            }
		return s;
	}

	/**
         * @return
	 * get a string representation of the list in which the calling object exists
	 * see JUnit tests about structure of returned String required
      
	 */
        @Override
	public String toString() {
            String s=" - ";
            PlaylistEntry p=this;
            
            while(p.previous!=null){   
                p=p.previous;
            }
            s= s.concat(p.title +" - "+ p.artist+ " (");
            s=s.concat(p.d);
            s=s.concat(") ");
            if(p.rating!=null){
                s=s.concat("Rated "+ p.rating +"\n");
            }else{
                s=s.concat("Not rated\n");
            }
                    
            while(p.next!=null){
                s=s.concat(" - ");
               s= s.concat(p.next.title +" - "+ p.next.artist+ " (");
            s=s.concat(p.next.d);
            s=s.concat(") ");
            if(p.next.rating!=null){
                s=s.concat("Rated "+ p.next.rating +"\n");
            }else{
                s=s.concat("Not rated\n");
            } 
            p=p.next;
            }
            
		return s;
	}

	/**
	 * 
	 * @return top rated song in the list in which the calling object exists (null if all are unrated)
	 */
	public Integer topRating() {
            PlaylistEntry p=this;
            
            while(p.previous!=null){   
                p=p.previous;
            }
            
            Integer r=p.rating;
            
            while(p.next!=null){ 
                if(r!=null && p.next.rating!=null){
                    if(p.next.rating>r){
                        r=p.next.rating;
                    }
                    
                    
                }
                p=p.next;
            }
            if(r==null){
                return null;
            }else{
                return r;
            }
            
            
		
	}

	/**
	 * 
	 * @return string with list of all songs in the list in which the calling object exists that are top rated
	 */
	public String listFavouriteSongs() {
            PlaylistEntry p=this;
            String s="";
            
            while(p.previous!=null){   
                p=p.previous;
            }
            
            
            if(p.rating.equals(p.topRating()) && p.rating!=null){
                s= s.concat(p.title +" - "+ p.artist+ " (");
                s=s.concat(p.d);
                s=s.concat(") ");
                s=s.concat("Rated "+ p.rating +"\n");
            }
            
            
            while(p.next!=null){
                if(p.topRating().equals(p.next.rating) && p.next.rating!=null){
                    s=s.concat(" - ");
                    s= s.concat(p.next.title +" - "+ p.next.artist+ " (");
                    s=s.concat(p.next.d);
                    s=s.concat(") ");
                    s=s.concat("Rated "+ p.next.rating +"\n");
                }
           
            p=p.next;
            }
            
		return s;
	}

	/**
	 * 
	 * @param artist
	 * @return number of songs by specified artist in the list in which the calling object exists
	 */
	public int countSongsBy(String artist) {
            PlaylistEntry p=this;
            int count =0;
            
            while(p.previous!=null){   
                p=p.previous;
            }
            if(p.artist== artist){
                    count++;
                }
            while(p.next!=null){
                if(p.next.artist== artist){
                    count++;
                }
                p=p.next;
            }
            
		return count;
	}

	/**
	 * 
	 * @param artist
	 * @return an array containing the titles of all songs by given artist.
	 * return null if there are no songs by the artist
	 */
	public String[] getSongsBy(String artist) {
            int x= this.countSongsBy(artist);
            String[] song = new String[x];
            PlaylistEntry p=this;
            int count =0;
            
            while(p.previous!=null){   
                p=p.previous;
            }
            if(p.artist== artist){
                    song[count]=p.title;
                    count++;
                }
            while(p.next!=null){
                if(p.next.artist== artist){
                    song[count]=p.next.title;
                    
                    count++;
                }
                p=p.next;
            }
            if(song.length==0){
                return null;
            }
            return song;
	}

	/**
	 * 
	 * @param other
	 * @return a list containing all songs in the list containing the calling object followed by
	 * all songs in the list containing the parameter object. see JUnit tests to see more details
	 */
	public PlaylistEntry merge(PlaylistEntry other) {
            PlaylistEntry p=this;
            
            while(p.next!=null){
                p=p.next;
            }
            while(other.previous!=null){
                other = other.previous;
            }
            p.next = other;
            return p;
                
	}
}
