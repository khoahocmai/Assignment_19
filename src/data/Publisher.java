package data;

import java.lang.Comparable;

public class Publisher implements Comparable{

    public String pubID, pubName, pubPhone;

    public Publisher() {
    }

    public Publisher(String pubName, String pubID, String pubPhone) {
        this.pubID = pubID;
        this.pubName = pubName;
        this.pubPhone = pubPhone;
    }

    public String getPubID() {
        return pubID;
    }

    public void setPubID(String pubID) {
        this.pubID = pubID;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getPubPhone() {
        return pubPhone;
    }

    public void setPubPhone(String pubPhone) {
        this.pubPhone = pubPhone;
    }

    @Override
    public final int compareTo(Object pub) {
        return this.getPubName().compareTo(((Publisher) pub).getPubName());
    }
    
    public void output() {
//        System.out.println("Publisher Name: " + this.pubName + "\t|Publisher ID: " + this.pubID + "\t|Publisher Phone: " + this.pubPhone);
        String str = String.format("%-10s| %-20s| %-15s", 
                this.pubID, this.pubName, this.pubPhone);       
        System.out.println(str);
    }

}
