import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){

        ArrayList<Book> books = new ArrayList<>();
        fillBookList(books);
        displayList(books);
        modifyBook(books);
        displayList(books);

    }

    public static String askString(String message,String paneTitle, int messageType){
        String answer;
        answer=JOptionPane.showInputDialog(null,message,paneTitle,messageType);


        return answer;
    }

    public static int askInt(String message,String paneTitle, int messageType){
        int answer;
        try{
            answer= Integer.parseInt(JOptionPane.showInputDialog(null,message,paneTitle,messageType));
        } catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Please provide integers only! Try again.");
            answer=askInt(message,paneTitle,messageType);
        }
        return answer;
    }

    public static double askDouble(String message,String paneTitle, int messageType){
        double answer;
        try{
            answer= Double.parseDouble(JOptionPane.showInputDialog(null,message,paneTitle,messageType));
        } catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Please provide integers only! Try again.");
            answer=askDouble(message,paneTitle,messageType);
        }
        return answer;
    }

    public static void displayList(List<Book> list){
        List<String> items = new ArrayList<String>();
        int i=1;
        for(Book book : list){

            System.out.println(book);
            items.add((i++)+book.toString());
        }
        String[] itemsArray = new String[items.size()];
        itemsArray= items.toArray(itemsArray);

        JList jList = new JList(itemsArray);
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(jList));
        JOptionPane.showMessageDialog(null, panel);
    }

    public static void fillBookList(List<Book> bookList){
        JOptionPane.showMessageDialog(null,"Create a list of Books");
        int answerBookType;
        boolean continuing=true;
        String[]bookOptions={"Science", "Children"};
        String title;
        String isbn;
        String publisher;
        double price;
        int year;

        while (continuing){

            answerBookType=JOptionPane.showOptionDialog(null, "Choose the type of book you'd like to create", "Select book type"
                    ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,bookOptions,bookOptions[0]);

            title = askString("Type the title of the book","Determining book title", JOptionPane.PLAIN_MESSAGE);
            isbn = askString("Type the ISBN", "Determining ISBN",JOptionPane.PLAIN_MESSAGE);
            publisher = askString("Type the publisher", "Determining publisher",JOptionPane.PLAIN_MESSAGE);
            price = askDouble("Type the price of the book","Determining the price",JOptionPane.PLAIN_MESSAGE);
            year = askInt("Type the year which the book was released", "Determining year", JOptionPane.PLAIN_MESSAGE);

            if(answerBookType==0)  bookList.add(new ScienceBook(title,isbn,publisher,price,year));
            else bookList.add(new ChildrenBook(title,isbn,publisher,price,year));

           JOptionPane.showMessageDialog(null,"You created the book:.\n"+
                    "Title:"+bookList.get(bookList.size()-1).getTitle()+
                    "\nISBN: "+bookList.get(bookList.size()-1).getISBN()+
                    "\nPublisher: "+bookList.get(bookList.size()-1).getPublisher()+
                    "\nPrice: "+bookList.get(bookList.size()-1).getPrice()+
                    "\nYear: "+bookList.get(bookList.size()-1).getYear());
           continuing=askYesNo("Would you like to keep adding books?","Continuing?");

        }
    }
    public static void modifyBook(List<Book> bookList){
        boolean toModify= askYesNo("Would you like to modify a specific book?","To modify");
        int i;
        int answerPositon;
        String[]messageOptions={"Title", "ISBN","Publisher","Price","Year"};
        String title, isbn, publisher;
        double price;
        int year;

        while (toModify){
            JOptionPane.showMessageDialog(null,"Select the index of the book you'd like to modify");
            displayList(bookList);
            i=askInt("Type the book index","Book index",JOptionPane.PLAIN_MESSAGE);
            answerPositon=JOptionPane.showOptionDialog(null,"Select the field you'd like to modify" , "Select field"
                    ,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,messageOptions,messageOptions[0]);
            switch (answerPositon){
                case 0: title=askString("Type the new title","New Title",JOptionPane.PLAIN_MESSAGE);
                        bookList.get(i-1).setTitle(title);
                        break;
                case 1: isbn=askString("Type the new ISBN","New ISBN",JOptionPane.PLAIN_MESSAGE);
                    bookList.get(i-1).setISBN(isbn);
                    break;
                case 2: publisher=askString("Type the new publisher","New publisher",JOptionPane.PLAIN_MESSAGE);
                    bookList.get(i-1).setPublisher(publisher);
                    break;
                case 3: price=askDouble("Type the new price","New price",JOptionPane.PLAIN_MESSAGE);
                    bookList.get(i-1).setPrice(price);
                    break;
                case 4: year=askInt("Type the new title","New Title",JOptionPane.PLAIN_MESSAGE);
                    bookList.get(i-1).setYear(year);
                    break;
            }

            toModify= askYesNo("Would you like to modify a specific book?","To modify");
        }


    }

    public static boolean askYesNo(String message, String title){
        boolean continuing;
        int answerPositon;
        String[]messageOptions={"Yes", "No"};
        answerPositon=JOptionPane.showOptionDialog(null,message , title
                ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,messageOptions,messageOptions[0]);
        if(answerPositon==0) continuing = true;
        else continuing=false;
        return continuing;
    }
}
