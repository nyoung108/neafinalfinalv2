
package Objects;

import java.time.LocalDate;
import java.time.LocalTime;


public class sportObject extends eventDetailsObject {
    int sportID;
    String sportType;
    String homeTeam;
    String awayTeam;
    

  public sportObject(int sportID, String sportType, String homeTeam, String awayTeam, int eventID, String eventName, String eventType, LocalDate date, LocalTime time, double eventPrice) {
        super(eventID, eventName, eventType, date, time, eventPrice);
        this.sportID = sportID;
        this.sportType = sportType;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        
    }

    

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return   sportID + ", " + sportType + ", " + homeTeam + ", " + awayTeam;
    }

      
}
