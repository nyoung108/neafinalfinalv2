
package Objects;

import java.time.LocalDate;
import java.time.LocalTime;

public class musicObject extends eventDetailsObject{
    int musicID;
    String musicType;
    String performerName;
    String warmupAct;
  

    public musicObject(int musicID, String musicType, String performerName, String warmupAct, int eventID, String eventName, String eventType, LocalDate date, LocalTime time, double eventPrice) {
        super(eventID, eventName, eventType, date, time, eventPrice);
        this.musicID = musicID;
        this.musicType = musicType;
        this.performerName = performerName;
        this.warmupAct = warmupAct;
   
    }

    

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getWarmupAct() {
        return warmupAct;
    }

    public void setWarmupAct(String warmupAct) {
        this.warmupAct = warmupAct;
    }

    @Override
    public String toString() {
        return musicID + ", " + musicType + ", " + performerName + ", " + warmupAct;
    }
    
}
