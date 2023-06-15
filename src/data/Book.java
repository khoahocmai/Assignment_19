package data;

public class Book implements Comparable {

    public String bookID, bookName, status, pubName;
    public float bookPrice, subTotal;
    public int quantity;

    public Book() {       
    }

    public Book(String BookID, String BookName, float BookPrice, int Quantity, float SubTotal, String Status, String pubName) {
        this.bookID = BookID;
        this.bookName = BookName;
        this.bookPrice = BookPrice;
        this.quantity = Quantity;
        this.subTotal = SubTotal;
        this.status = Status;
        this.pubName = pubName;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String BookID) {
        this.bookID = BookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String BookName) {
        this.bookName = BookName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float BookPrice) {
        this.bookPrice = BookPrice;
    }

    public float getSubTotal() {
        return (this.bookPrice * this.quantity);
    }

    public void setSubTotal(float SubTotal) {
        this.subTotal = SubTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }
    
    @Override
    public int compareTo(Object o) {
        int quandif = this.quantity - ((Book) o).getQuantity();
        if (quandif < 0) {
            return 1;
        }
        if (quandif > 0) {
            return -1;
        } else {
            if (this.bookPrice >= ((Book) o).getBookPrice()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    
    public void outputBk() {
//        System.out.println(this.BookID + "\t|" + this.BookName + "\t|" + this.BookPrice + "\t|" + this.Quantity
//                + "\t| " + this.getSubTotal() + "\t\t|" + this.pubName + "\t|" + this.Status);
        String str = String.format("%-10s| %-20s| %-10.2f| %-8o| %-10.3f| %-20s| %-20s",
                this.bookID, this.bookName, this.bookPrice, this.quantity, this.getSubTotal(), this.pubName, this.status);
        System.out.println(str);
    }

    

}
