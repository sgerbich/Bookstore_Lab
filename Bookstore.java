import java.time.*;
import java.util.*;
import java.io.IOException;
import java.text.*;
import java.util.ArrayList;


public class Bookstore {
    public static void main(final String[] args) {
        final Bookstore bigBooks = new Bookstore("Big Ol Bookstore", "102 bookstore lane", 3000, true);
        bigBooks.printName();
        bigBooks.printAddr();
        bigBooks.openDay();
        bigBooks.getSize();
        bigBooks.hasUsedBooks();
        bigBooks.loadTitles();
        bigBooks.getTitles();
    }

    private final String name;
    private final String address;
    private final int sqft;
    private final boolean usedBooks;
    private ArrayList<String> titles;

    public Bookstore(final String nameMe, final String addressMe, final int sqftMe, final boolean usedBooksMe) {
        name = nameMe;
        address = addressMe;
        sqft = sqftMe;
        usedBooks = usedBooksMe;
        titles = new ArrayList<String>();
        loadTitles();
    }

    private void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles);
        } catch (final IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();
            
        }
    }

    public void getTitles(){
        for(int i = 0; i < titles.size(); i++){
            System.out.println(titles.get(i));
        }
    }

    public void printName() {
        System.out.println(name);
    }

    public void printAddr() {
        System.out.println(address);
    }

    public void openDay() {
        final Date now = new Date();
        final SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        if (simpleDateformat.format(now).equals("Sunday")) {
            System.out.println("sorry were not open on weekends");
        } else if (simpleDateformat.format(now).equals("Sunday")) {
            System.out.println("sorry were not open on weekends");
        } else {
            openHours();
        }
    }

    public void openHours() {
        final LocalTime time = LocalTime.now();
        // System.out.println(time.getHour());
        // System.out.println(time.getMinute());
        if (time.getHour() >= 8 && time.getHour() < 17) {
            System.out.print("hey were Open! Our hours are 8-5 Weekdays");
        } else {
            System.out.print("sorry were closed.Our hours are 8-5 Weekdays");
        }
    }

    public void getSize() {
        System.out.printf("%nthe store is %d square feet", sqft);
    }

    public void hasUsedBooks() {
        if (usedBooks) {
            System.out.printf("%nWe sell used books%n");
        } else {
            System.out.printf("%nWe only sell new books%n");
        }
    }

    
}
