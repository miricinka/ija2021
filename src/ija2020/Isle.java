package ija2020;

import java.util.LinkedList;
import java.util.Objects;

import static java.lang.Math.abs;

/**
 * Class Isle represents one isle in warehouse with list of storeGoods
 * isle can be closed
 * @version 1.0
 * @author <a href="xkolar76@stud.fit.vutbr.cz">Mirka Kolarikova</a>
 * @author <a href="xzovin00@stud.fit.vutbr.cz">Martin Zovinec</a>
 */
public class Isle {
    private Coordinates start;
    private Coordinates end;
    private Boolean closed = false;
    private LinkedList<StoreGoods> storeGoodsList;
    private double cost;

    public Isle() {}

    public Isle(Coordinates start, Coordinates end) {
        this.start = start;
        this.end = end;
        this.closed = false;
        storeGoodsList = new LinkedList<>();
    }

    /**
     * Returns start coordinate
     * @return start coordinate
     */
    public Coordinates getStart() {
        return start;
    }

    /**
     * Sets coordinate start
     * @param start coordinate
     */
    public void setStart(Coordinates start) {
        this.start = start;
    }

    /**
     * Returns end coordinate
     * @return end coordinate
     */
    public Coordinates getEnd() {
        return end;
    }

    /**
     * Sets coordinate end
     * @param end coordinate
     */
    public void setEnd(Coordinates end) {
        this.end = end;
    }

    /**
     * Returns boolean closed
     * @return closed
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * Closes the isle
     */
    public void setClosed() {
        this.closed = true;
    }

    /**
     * Opens the isle
     */
    public void setOpen() {
        this.closed = false;
    }

    /**
     * Returns storeGoodsList
     * @return storeGoodsList list of storeGoods on Isle
     */
    public LinkedList<StoreGoods> getStoreGoodsList() {
        return storeGoodsList;
    }

    /**
     * Sets list of goods on isle
     * @param storeGoodsList on isle
     */
    public void setStoreGoodsList(LinkedList<StoreGoods> storeGoodsList) {
        this.storeGoodsList = storeGoodsList;
    }

    /**
     * Sets list of goods on isle
     * @return cost of this isle
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets costs of this isle
     */
    public void setCost() {
        this.cost = calculateIsleCost();
    }

    private double calculateIsleCost(){
        if(start.getX() == end.getX()){
            return abs(start.getY() - end.getY());
        }else{
            return abs(start.getX()-end.getX());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Isle)) return false;
        Isle isle = (Isle) o;
        return Objects.equals(start, isle.start) && Objects.equals(end, isle.end) && Objects.equals(storeGoodsList, isle.storeGoodsList) && Objects.equals(closed, isle.closed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, storeGoodsList, closed);
    }

    @Override
    public String toString() {
        return "Isle{" +
                "start=" + start +
                ", end=" + end +
                ", closed=" + closed +
                '}';
    }
}
