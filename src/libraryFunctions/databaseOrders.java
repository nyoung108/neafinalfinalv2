package libraryFunctions;

import Objects.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class databaseOrders {

    private static userDetailsObject currentUser;

    public static boolean userLogIn(String email, String password) {
        boolean validUser = false;
        try {
            String hashedPassword = hash.hashedPassword(password);
            
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * from app.usertable where exists (SELECT userID FROM app.usertable WHERE email = '" + email + "' AND password = '" + hashedPassword + "')";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            validUser = rs.next();

            if (validUser == true) {
                currentUser = new userDetailsObject(rs.getInt("USERID"), rs.getString("email"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("dateOfBirth"));
            }

            rs.close();
            statement.close();
            con.close();
            return validUser;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public static int returnUserID() {
        int userID = currentUser.getUserID();
        return userID;
    }

    public static String returnEmail() {
        return currentUser.getEmail();
    }

    public static String returnFirstName() {
        return currentUser.getFirstName();
    }

    public static String returnLastName() {
        return currentUser.getLastName();
    }

    public static String returnDateOfBirth() {
        return currentUser.getDateOfBirth();
    }

    public static String returnPassword() {
        return currentUser.getPassword();
    }

    public static ArrayList<Integer> getTicketID() {
        try {
            System.out.println(currentUser.getUserID());
            ArrayList<Integer> ticketID = new ArrayList<>();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int userID = currentUser.getUserID();
            String sql = "Select ticketID from app.bookingtable where userID = " + userID;
            ResultSet rs = databaseManagement.executeQuery(sql);
            while (rs.next()) {
                int ticket = rs.getInt("ticketID");

                ticketID.add(ticket);
            }

            rs.close();
            con.close();
            statement.close();
            return ticketID;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("error in getTicket");
        }
        return null;
    }

    public static void updateEmail(String email) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update app.usertable set email = '" + email + "' where userID = " + currentUser.getUserID();
            statement.executeUpdate(sql);

            statement.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void updatePassword(String password) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update app.usertable set password = '" + password + "' where userID= " + currentUser.getUserID();
            statement.executeUpdate(sql);

            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void updateLastName(String password) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update app.usertable set password= '" + password + "' where userID= " + currentUser.getUserID();
            statement.executeUpdate(sql);

            statement.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void updateFirstName(String update) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update app.usertable set firstname= '" + update + "' where userID= " + currentUser.getUserID();
            statement.executeUpdate(sql);

            statement.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void updateDate(String update) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Update app.usertable set date= '" + update + "' where userID= " + currentUser.getUserID();
            statement.executeUpdate(sql);

            statement.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static int getTicketIDChosen(int ticketIDInt, int eventID) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "Select ticketID from app.tickettable where ticketID = " + ticketIDInt + " AND eventID= " + eventID;
            ResultSet rs = statement.executeQuery(sql);

            int ticketID = rs.getInt("ticketID");

            System.out.println("test");
            rs.close();
            con.close();
            return ticketID;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("why????");
        }
        return 0;
    }

    public static void addUser(userDetailsObject user) {
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO app.USERTABLE Values(" + user.getUserID() + ", '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getDateOfBirth() + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            
            currentUser = user;

            con.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }

    }

    public static void addBooking(bookingDetailsObject booking) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO app.BOOKINGTABLE VALUES (" + booking.getBookingID() + ", " + booking.getUserID() + ", " + booking.getTicketID() + ", '" + booking.getDateBooked() + "')";
            statement.executeUpdate(sql);

            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void addTicket(ticketDetailsObject ticket) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO app.tickettable values (" + ticket.getTicketID() + ", " + ticket.getEventID() + ", " + ticket.getSeatID() + ", '" + ticket.getType() + "', " + ticket.getPrice() + ")";
            statement.executeUpdate(sql);

            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void seatsBooked(String stand, int eventID) {
        ArrayList<String> seatsBooked = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT TICKETTABLE.seatID FROM app.ticketTABLE WHERE EXISTS (SELECT Untitled.seatID FROM app.untitled WHERE stand = '" + stand+ "') AND TICKETID.EVENTID =" + eventID;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                seatsBooked.add(rs.getString("seatID"));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static boolean isAdmin(String email, String password) {
        boolean admin = false;
        try {
            ArrayList<String> userList = new ArrayList<>();
            String hashedPassword = hash.hashedPassword(password);
            System.out.println(hashedPassword);
            hashedPassword = hashedPassword.toLowerCase();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select USERID from app.usertable where password= '" + hashedPassword + "' and email= '" + email + "'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String userID = rs.getString("USERID");
                userList.add(userID);
            }
            for (int i = 0; i < userList.size(); i++) {
                sql = "select adminID from app.admintable where userID ="+userList.get(i);
                rs = statement.executeQuery("ADMINID");
                admin = rs.next();
            }
            
           // System.out.println(sql);
            
            

            rs.close();
            statement.close();
            con.close();
            System.out.println(admin);
            return admin;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public static int getEventID(String name) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select eventID from app.eventtable where name = '" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int eventID = rs.getInt("eventID");
                return eventID;
            }
            rs.close();
            con.close();
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    public static String getEvent(String ticketID, String name) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select eventID from app.tickettable where ticketID = " + ticketID + " AND name = '" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            String eventID = rs.getString("eventID");
            rs.close();
            con.close();
            return eventID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static int getSeat(int ticketID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from app.tickettable where ticketID = " + ticketID;
            ResultSet rs = statement.executeQuery(sql);
            int seatID = rs.getInt("seatID");
            rs.close();
            con.close();
            return seatID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }

    public static String getEventName(int eventID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select name from app.eventtable where eventID = " + eventID;
            ResultSet rs = statement.executeQuery(sql);
            String name = rs.getString("name");
            rs.close();
            con.close();
            return name;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static String getStandName(int seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select stand from app.eventtable where seatID = " + seatID;
            ResultSet rs = statement.executeQuery(sql);
            String stand = rs.getString("stand");
            rs.close();
            con.close();
            return stand;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static int getSeatRow(int seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select row from app.untitled where seatID = " + seatID;
            ResultSet rs = statement.executeQuery(sql);
            int row = rs.getInt("row");
            rs.close();
            con.close();
            return row;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }

    public static int getSeatColumn(int seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select columnnumber from app.untitled where seatID = " + seatID;
            ResultSet rs = statement.executeQuery(sql);
            int column = rs.getInt("columnnumber");
            rs.close();
            con.close();
            return column;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }

    public static ArrayList<Integer> getTakenSeatID(int eventID, ArrayList<Integer> takenSeatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from app.ticketTable where eventID= " + eventID;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int seatID = rs.getInt("seatID");
                //String seatIDStr = String.valueOf(seatID);
                takenSeatID.add(seatID);
            }
            System.out.println(sql);
            rs.close();
            con.close();
            return takenSeatID;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("error here");
        }
        return null;
    }

    public static int getSeatRow(String stand, int seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "Select row from app.untitled where stand='" + stand + "' AND seatID= " + seatID;
            ResultSet rs = statement.executeQuery(sql);
            int row = rs.getInt("row");
            rs.close();
            con.close();
            return row;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }

    public static int getSeatColumn(String stand, int seatID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "Select columnnumber from app.untitled where stand='" + stand + "' AND seatID= " + seatID;
            ResultSet rs = statement.executeQuery(sql);

            int column = rs.getInt("coulmnnumber");
            rs.close();
            con.close();
            return column;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }

    public static ArrayList<String> getUpcomingEvents(ArrayList<String> events) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select name from app.eventTable";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                events.add(name);
            }
            rs.close();
            con.close();
            return events;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static double getEventPrice(int eventID) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select baseprice from app.eventTable where eventID =" + eventID;
            ResultSet rs = statement.executeQuery(sql);
            double eventPrice = rs.getDouble("basePrice");
            rs.close();
            con.close();
            return eventPrice;
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }

    public static String getSeatID(String stand, int row, int column) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "Select seatID from app.untitled where stand = '" + stand + "' AND row = " + row + " AND columnnumber = " + column;
            ResultSet rs = statement.executeQuery(sql);
            String seatID = rs.getString("seatID");
            rs.close();
            con.close();
            return seatID;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static void addMusic(musicObject music) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String sql = "INSERT INTO app.musicTABLE VALUES (" + music.getMusicID() + ", '" + music.getEventID() + "', '" + music.getMusicType() + "', '" + music.getPerformerName() + "', '" + music.getWarmupAct() + "')";
            statement.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void addMusicEvent(musicObject music) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "INSERT INTO app.eventTABLE VALUES (" + music.getMusicID() + ", '" + music.getEventName() + "', '" + music.getEventType() + "', '" + music.getDate() + "', '" + music.getTime() + "', " + music.getEventPrice() + ")";
            statement.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void addSport(sportObject sport) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String sql = "INSERT INTO app.sportTABLE VALUES (" + sport.getSportID() + ", '" + sport.getEventID() + "', '" + sport.getSportType() + "', '" + sport.getHomeTeam() + "', '" + sport.getAwayTeam() + "')";
            statement.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void addSportEvent(sportObject sport) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
          
            String sql = "INSERT INTO app.eventTABLE VALUES (" + sport.getSportID() + ", '" + sport.getEventName() + "', '" + sport.getEventType() + "', '" + sport.getDate() + "', '" + sport.getTime() + "', " + sport.getEventPrice() + ")";
            statement.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static int getNumberOfTickets() {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int userID = currentUser.getUserID();
            String sql = "Select count(bookingID) as ticketCount from app.bookingtable where userID = " + userID;
            ResultSet rs = statement.executeQuery(sql);
            int numberOfTickets = rs.getInt("ticketCount");
            rs.close();
            con.close();
            return numberOfTickets;
        } catch (Exception e) {
            System.out.println(e);

        }
        return 0;
    }

    public static LocalDate getDate(String name) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "Select date from app.eventTable where name = '" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            String dateStr = rs.getString("date");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateStr, dateFormatter);

            rs.close();
            con.close();
            return date;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static void addSeat(seatDetailsObject seat) {

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            String sql = "Select seatID from app.untitled where seatID= " + seat.getSeatID();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next() == true) {

            } else {
                sql = "Insert into app.untitled values (" + seat.getSeatID() + ", " + seat.getRow() + ", " + seat.getColumn() + ", '" + seat.getStand() + "', " + seat.getPrice() + ")";
                statement.executeUpdate(sql);
            }
            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static int generateUserID() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select MAX(userID) as idCount from app.usertable";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int id = rs.getInt("idCount") + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static int generateTicketID() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select MAX(ticketID) as idCount from app.tickettable";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int id = rs.getInt("idCount") + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static int generateBookingID() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select MAX(bookingID) as idCount from app.bookingtable";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int id = rs.getInt("idCount") + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static int generateEventID() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select MAX(eventID) as idCount from app.eventtable";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int id = rs.getInt("idCount") + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static int generateMusicID() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select MAX(musicID) as idCount from app.musictable";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int id = rs.getInt("idCount") + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static int generateSportID() {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/StadiumBookingDatabaseNea", "Noah", "password");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select MAX(sportID) as idCount from app.sporttable";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            int id = rs.getInt("idCount") + 1;
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
