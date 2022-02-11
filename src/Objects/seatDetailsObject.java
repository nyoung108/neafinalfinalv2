
package Objects;

public class seatDetailsObject {
    int seatID;
    int row;
    int column;
    int Stand;
    double price;

    public seatDetailsObject(int seatID, int row, int column, int Stand, double price) {
        this.seatID = seatID;
        this.row = row;
        this.column = column;
        this.Stand = Stand;
        this.price = price;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getStand() {
        return Stand;
    }

    public void setStand(int Stand) {
        this.Stand = Stand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return seatID + ", " + row + ", " + column + ", " + Stand + ", " + price;
    }
    
}
