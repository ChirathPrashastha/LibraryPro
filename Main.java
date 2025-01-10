import com.sun.jdi.IntegerValue;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.text.View;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LibraryPro {

    public static final String RESET = "\u001B[0m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String BLACK = "\u001B[30m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void header(){
        System.out.println(CYAN_BACKGROUND + BLACK + "-".repeat(40) + RESET);
        System.out.println(CYAN_BACKGROUND + BLACK + "\t\t\tLibrary Pro\t\t\t\t\t" + RESET);
        System.out.println(CYAN_BACKGROUND + BLACK +  "-".repeat(40) + RESET);
    }

    private final static void clearConsole() {
        try {
            // Print 50 empty lines to simulate clearing the console
            System.out.print("\n".repeat(50));
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error while clearing console: " + e.getMessage());
        }
    }

    public static boolean emailChecker(String email) {
            // Simple regex for email validation
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

            // Compile the regex into a pattern
            Pattern pattern = Pattern.compile(emailRegex);

            // Return false if email is null
            if (email == null) {
                return false;
            }

            // Match the email against the pattern
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
    }

    public static String[][] extendArray(String[][] bookAr){ // Extending Book Array Method

        String[][] tempBook = new String[bookAr.length + 1][5];

        for(int i = 0; i < bookAr.length; i++){
            for(int j = 0; j < bookAr[i].length; j++){
                tempBook[i][j] = bookAr[i][j];
            }
        }

        return tempBook;
    }

    public static String[][] shrinkArray(String[][] bookAr){ // Shrinking Book Array Method

        String[][] tempBook = new String[bookAr.length - 1][5];
        for(int i = 0; i < bookAr.length - 1; i++){
            for(int j = 0; j < 5; j++){
                tempBook[i][j] = bookAr[i][j];
            }
        }
        return tempBook;
    }

    public static int bookCount = 10;

    private static String[][] books = new String[bookCount][5]; // Book Array
    static{

        books[0][0] = "B001";books[0][1] = "Harry Potter and the Philosopher's Stone";books[0][2] = "J.K. Rowling";books[0][3] = "Fantasy Fiction / Novel";books[0][4] = "2";
        books[1][0] = "B002"; books[1][1] = "The Hobbit"; books[1][2] = "J.R.R. Tolkien"; books[1][3] = "Fantasy Fiction"; books[1][4] = "5";
        books[2][0] = "B003"; books[2][1] = "1984"; books[2][2] = "George Orwell"; books[2][3] = "Dystopian Fiction"; books[2][4] = "5";
        books[3][0] = "B004"; books[3][1] = "Pride and Prejudice"; books[3][2] = "Jane Austen"; books[3][3] = "Romantic Novel"; books[3][4] = "8";
        books[4][0] = "B005"; books[4][1] = "To Kill a Mockingbird"; books[4][2] = "Harper Lee"; books[4][3] = "Classic Fiction"; books[4][4] = "2";
        books[5][0] = "B006"; books[5][1] = "The Great Gatsby"; books[5][2] = "F. Scott Fitzgerald"; books[5][3] = "Classic Fiction"; books[5][4] = "2";
        books[6][0] = "B007"; books[6][1] = "Moby Dick"; books[6][2] = "Herman Melville"; books[6][3] = "Adventure Fiction"; books[6][4] = "1";
        books[7][0] = "B008"; books[7][1] = "War and Peace"; books[7][2] = "Leo Tolstoy"; books[7][3] = "Historical Fiction"; books[7][4] = "3";
        books[8][0] = "B009"; books[8][1] = "Crime and Punishment"; books[8][2] = "Fyodor Dostoevsky"; books[8][3] = "Philosophical Fiction"; books[8][4] = "5";
        books[9][0] = "B010"; books[9][1] = "The Catcher in the Rye"; books[9][2] = "J.D. Salinger"; books[9][3] = "Literary Fiction"; books[9][4] = "3";

    }

    private static int overDueBookCount = 4;

    private static String[][] overDueBooks = new String[overDueBookCount][5]; // OverDue Books Array
    static {

        overDueBooks[0][0] = "B001"; overDueBooks[0][1] = "M003"; overDueBooks[0][2] = "2024-12-02"; overDueBooks[0][3] = "5"; overDueBooks[0][4] = "250.0";
        overDueBooks[1][0] = "B009"; overDueBooks[1][1] = "M001"; overDueBooks[1][2] = "2024-12-08"; overDueBooks[1][3] = "3"; overDueBooks[1][4] = "150.0";
        overDueBooks[2][0] = "B003"; overDueBooks[2][1] = "M003"; overDueBooks[2][2] = "2024-12-02"; overDueBooks[2][3] = "5"; overDueBooks[2][4] = "250.0";
        overDueBooks[3][0] = "B006"; overDueBooks[3][1] = "M004"; overDueBooks[3][2] = "2024-12-05"; overDueBooks[3][3] = "1"; overDueBooks[3][4] = "50.0";

    }

    public static String[][] extendOverDueBooks(String[][] overDBooks){ // Extending Overdue Books Array Method

        String[][] tempOverdueBooks = new String[overDBooks.length + 1][5];

        for(int i = 0; i < overDBooks.length; i++){
            for(int j = 0; j < 5; j++){
                tempOverdueBooks[i][j] = overDBooks[i][j];
            }
        }
        return tempOverdueBooks;
    }

    private static int issueBookCount = 5;

    private static String[][] issuedBooks = new String[issueBookCount][3]; // Issued Books Array
    static{

        issuedBooks[0][0] = "B005"; issuedBooks[0][1] = "M002"; issuedBooks[0][2] = "2025-01-02";
        issuedBooks[1][0] = "B007"; issuedBooks[1][1] = "M005"; issuedBooks[1][2] = "2024-12-31";
        issuedBooks[2][0] = "B002"; issuedBooks[2][1] = "M009"; issuedBooks[2][2] = "2025-01-05";
        issuedBooks[3][0] = "B002"; issuedBooks[3][1] = "M001"; issuedBooks[3][2] = "2025-01-01";
        issuedBooks[4][0] = "B006"; issuedBooks[4][1] = "M002"; issuedBooks[4][2] = "2024-12-30";

    }

    private static String[][] extendedIssueBooks(String[][] issueB){ // Extending Issued Books Array Method

        String[][] tempIssue = new String[issueB.length + 1][3];

        for(int i = 0; i < issueB.length; i++){
            for(int j = 0; j < 3; j++){
                tempIssue[i][j] = issueB[i][j];
            }
        }

        return tempIssue;
    }

    private static String[][] shrinkIssueBooks(String[][] issueB){ // Shrinking Issued Books Array Method
        String[][] tempIssue = new String[issueB.length - 1][3];
            for(int i = 0; i < issueB.length - 1; i++){
                for(int j = 0; j < 3; j++){
                    tempIssue[i][j] = issueB[i][j];
                }
            }

        return tempIssue;
    }


    private static int memberCount = 10;

    private static String[][] members = new String[memberCount][4]; // Members Array
    static{

        members[0][0] = "M001"; members[0][1] = "David Liam"; members[0][2] = "774567890"; members[0][3] = "davidliam1998@gmail.com";
        members[1][0] = "M002"; members[1][1] = "Sophia Johnson"; members[1][2] = "711234567"; members[1][3] = "sophiajohnson@gmail.com";
        members[2][0] = "M003"; members[2][1] = "James Williams"; members[2][2] = "912345678"; members[2][3] = "jamesw1990@yahoo.com";
        members[3][0] = "M004"; members[3][1] = "Olivia Brown"; members[3][2] = "773456789"; members[3][3] = "oliviab@gmail.com";
        members[4][0] = "M005"; members[4][1] = "Michael Smith"; members[4][2] = "919876543"; members[4][3] = "michaelsmith@hotmail.com";
        members[5][0] = "M006"; members[5][1] = "Emma Davis"; members[5][2] = "778765432"; members[5][3] = "emmad1995@gmail.com";
        members[6][0] = "M007"; members[6][1] = "William Martinez"; members[6][2] = "777654321"; members[6][3] = "williamm@yahoo.com";
        members[7][0] = "M008"; members[7][1] = "Isabella Garcia"; members[7][2] = "726543210"; members[7][3] = "isabellag@gmail.com";
        members[8][0] = "M009"; members[8][1] = "Ethan Thomas"; members[8][2] = "915432109"; members[8][3] = "ethant1998@gmail.com";
        members[9][0] = "M010"; members[9][1] = "Ava Hernandez"; members[9][2] = "914321098"; members[9][3] = "avah@gmail.com";

    }

    public static String[][] extendMembers(String[][] memberArr){ // Extending the Members Array Method

        String[][] tempMembers = new String[memberArr.length + 1][4];

        for(int i = 0; i < memberArr.length; i++){
            for(int j = 0; j < 4; j++){
                tempMembers[i][j] = memberArr[i][j];
            }
        }

        return tempMembers;
    }

    public static String[][] shrinkMembers(String[][] memberArr){ // Shrinking Members Array Method
        String[][] tempMembers = new String[memberArr.length - 1][4];
            for(int i = 0; i < memberArr.length - 1; i++){
                for(int j = 0; j < 4; j++){
                    tempMembers[i][j] = memberArr[i][j];
                }
            }

        return tempMembers;
    }

    public static void calculateFine(Date returnedDate, String memberID, String bookID){ // Calculating Fine (Overdue) Method

        Date dDate = null; // Due date
        Date rDate = returnedDate; // returned date

        double overDueFine = 0.0;

        for (int i = 0; i < issuedBooks.length; i++){
            if(issuedBooks[i][0].equals(bookID) && issuedBooks[i][1].equals(memberID)){
                dDate = Date.valueOf(issuedBooks[i][2]);

                break;
            }
        }

        LocalDate returnedLocalDate = rDate.toLocalDate(); // Converting sql dates to local dates
        LocalDate dueLocalDate = dDate.toLocalDate();

        long overDueDates = ChronoUnit.DAYS.between(dueLocalDate, returnedLocalDate);

        if (overDueDates > 0){
            overDueFine = overDueDates * 50.0;

        }else if(overDueDates < 0){
            overDueFine -= 0.0;
        }

        if (overDueFine > 0){
            overDueBooks = extendOverDueBooks(overDueBooks);

            overDueBooks[overDueBooks.length - 1][0] = bookID;
            overDueBooks[overDueBooks.length - 1][1] = memberID;
            overDueBooks[overDueBooks.length - 1][2] = String.valueOf(dDate);
            overDueBooks[overDueBooks.length - 1][3] = String.valueOf(overDueDates);
            overDueBooks[overDueBooks.length - 1][4] = String.valueOf(overDueFine);

            overDueBookCount++;
        }

    }

    public static void authority(String[] credentials){ // Authorized Personals

        Scanner input = new Scanner(System.in);

        final String USERNAME = "admin" , PASSWORD = "admin123";

        if (credentials[0].equals(USERNAME) && credentials[1].equals(PASSWORD)) {
            homePage();
        }else{
            header();

            System.out.println(RED + "Invalid Username or Password" + RESET);
            System.out.print("(1) Try Again : "); // Go back to login menu

            int op = input.nextInt();

            clearConsole();

            if (op == 1) {
                clearConsole();
                loginMenu();
            }else {
                System.out.println("Invalid Entry");
            }
        }
    }

    public static void loginMenu(){ // Login menu

        header();
        System.out.println(PURPLE + "------------ LOGIN MENU --------------" + RESET);
        Scanner input = new Scanner(System.in);

            System.out.print("Enter Username : ");
            String username = input.next();
            System.out.print("Enter Password : ");
            String password = input.next();

        clearConsole();

            String[] credentials = {username , password};
            authority(credentials);
    }

    public static void homePage(){ // Home page

        header();
        System.out.println(PURPLE + "------------ HOME PAGE --------------" + RESET);
        Scanner input = new Scanner(System.in);

            System.out.println("(1) Manage Books");
            System.out.println("(2) Manage Members");
            System.out.println("(3) Issue Books");
            System.out.println("(4) Return Books");
            System.out.println("(5) View Reports");
            System.out.println("(6) Log out");

            System.out.print("Enter the Option : ");
            int op = input.nextInt();

        clearConsole();

        switch (op) {
            case 1 -> manageBooks();
            case 2 -> manageMembers();
            case 3 -> issueBooks();
            case 4 -> returnBooks();
            case 5 -> viewReports();
            case 6 -> loginMenu();
            default -> System.out.println(RED + "Invalid Option" + RESET);
        }
    }

    public static void manageBooks(){

        header();
        System.out.println(PURPLE + "------------ MANAGE BOOKS --------------" + RESET);
        Scanner input = new Scanner(System.in);

            System.out.println("(1) Add Books");
            System.out.println("(2) Update Books");
            System.out.println("(3) Delete Books");
            System.out.println("(4) Search Books");
            System.out.println("(5) View All Books");
            System.out.println("(6) Exit");

        System.out.print("Enter the Option : ");
        int op = input.nextInt();

        clearConsole();

            switch (op) {
                case 1 -> addBooks();
                case 2 -> updateBooks();
                case 3 -> deleteBooks();
                case 4 -> searchBooks();
                case 5 -> viweAllBooks();
                case 6 -> homePage();
                default -> System.out.println(RED + "Invalid Option" + RESET);
            }
    }

    public static void addBooks(){

        header();
        System.out.println(BLACK + "------------ ADD BOOKS --------------" + RESET);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Book ID : ");
        String bookID = input.next();

        boolean duplication = false;

        for(int i = 0; i < books.length; i++){
            if (books[i][0].equals(bookID)) {
                duplication = true;

                break;

            }else {
                duplication = false;
            }
        }

            if (duplication == false) {

                bookCount++;

                books = extendArray(books); // Extending Array for the adding book

                        books[books.length - 1][0] = bookID;
                    System.out.print("Enter Book Title : ");
                        input.nextLine();
                        books[books.length - 1][1] = input.nextLine();
                    System.out.print("Enter the Author : ");
                        books[books.length - 1][2] = input.nextLine();
                    System.out.print("Enter Genre : ");
                        books[books.length - 1][3] = input.nextLine();
                    System.out.print("Enter Quantity : ");
                            int qty = input.nextInt();
                                if (qty > 0){
                                    books[books.length - 1][4] = String.valueOf(qty); // Int value for quantity
                                }else {
                                    System.out.println(RED + "Quantity must be Positive" + RESET);
                                    return;
                                }

                clearConsole();
                header();

                    System.out.println(GREEN + bookID + " is Added to the Library" + RESET);

                    System.out.print("(1) Exit : ");
                    int op = input.nextInt();

                clearConsole();

                    if (op == 1) {
                        manageBooks();
                    }else{
                        System.out.println("Invalid Option");
                    }

            } else{

                clearConsole();
                header();

                    System.out.println(RED + "Duplicated Book ID" + RESET);

                    System.out.print("(1) Try Again \t (2) Exit : ");
                    int op = input.nextInt();

                clearConsole();

                    if (op == 1) {
                        addBooks();
                    }else if (op == 2) {
                        manageBooks();
                    }else{
                        System.out.println("Invalid Option");
                    }
            }
    }

    public static void updateBooks(){ // Update Book

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK+ "------------ UPDATE BOOKS --------------" + RESET);

        System.out.print("Enter Book ID Want to Update : ");
        String bookID = input.next();

            for(int i = 0; i < books.length; i++){
                if (!books[i][0].equals(bookID)) {
                    continue;

                }else{

                    clearConsole();
                    header();

                    for(int j = 0; j < 5; j++){ // Prints the details of the book that wanted to update
                        System.out.print(books[i][j] + " | ");
                    }
                    System.out.println();

                        System.out.print("Rename the Title : ");
                            input.nextLine();
                            books[i][1] = input.nextLine();
                        System.out.print("Rename the Author : ");
                            books[i][2] = input.nextLine();
                        System.out.print("Enter the Genre : ");
                            books[i][3] = input.nextLine();
                        System.out.print("Set the Quantity : ");
                            int qty = input.nextInt();
                                if (qty > 0){
                                    books[i][4] = String.valueOf(qty);
                                }else {
                                    System.out.println(RED + "Quantity must be Positive" + RESET);
                                    return;
                                }

                    clearConsole();
                    header();

                        System.out.println(GREEN + bookID + " is Updated" + RESET);

                        System.out.print("(1) Exit : ");
                        int op = input.nextInt();

                    clearConsole();

                        if (op == 1) {
                            manageBooks();
                        }

                        break;
                }
            }

            System.out.println(RED + "Unavailable Book ID" + RESET);
                System.out.print("(1) Exit : ");
                int op = input.nextInt();

        clearConsole();

                if (op == 1) {
                    manageBooks();
                }
    }

    public static void deleteBooks(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ DELETE BOOKS --------------" + RESET);

            System.out.print("Enter Book ID : ");
            String bookID = input.next();

            boolean found = false;

            for(int i = 0; i < books.length; i++){
                if (books[i][0].equals(bookID)) {

                    found = true;

                    for(int j = i; j < bookCount - 1; j++){ // Shifting indexes
                        books[j] = books[j + 1];
                    }

                    books[bookCount - 1] = null; // Set null the last index

                    books = shrinkArray(books); // Deleting the last index and shrinks the book array

                    bookCount--;

                clearConsole();
                header();

                    System.out.println(GREEN + bookID + " is Deleted" + RESET);

                    System.out.print("(1) Exit : ");
                        int op = input.nextInt();
                clearConsole();
                        if(op == 1){
                            manageBooks();
                        }
                    break;
                }
            }

            if(found == false){

                clearConsole();
                header();

                System.out.println(RED + "Book ID " + bookID + " is not found" + RESET);
            }

        System.out.print("(1) Try Again \t (2) Exit : ");
            int op = input.nextInt();

        clearConsole();

                if(op == 1){
                    deleteBooks();
                }else if (op == 2){
                    manageBooks();
                }

    }

    public static void searchBooks(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ SEARCH BOOKS --------------" + RESET);

            System.out.print("Enter Book ID : ");
            String bookID = input.next();

            boolean found = false;

            for(int i = 0; i < books.length; i++){
                if (books[i][0].equals(bookID)) {
                    found = true;

                clearConsole();
                header();

                    for(int j = 0; j < 5; j++){
                        System.out.print(books[i][j] + " | ");
                    }
                    System.out.println();

                    break;
                }
            }

            if(found == false){

                clearConsole();
                header();

                System.out.println(RED + "Book ID " + bookID + " is not found" + RESET);
            }

                System.out.print("(1) Try Again \t (2) Exit : ");
                    int op = input.nextInt();

            clearConsole();

                        if(op == 1){
                            searchBooks();
                        }else if (op == 2) {
                            manageBooks();
                        }
    }

    public static void viweAllBooks(){ // View all books

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ ALL BOOKS --------------" + RESET);

        System.out.println("BookID \t|\t Title \t|\t Author \t|\t Genre \t|\t Quantity ");
        System.out.println("-".repeat(70));

        for(int i = 0; i < books.length; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(books[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.print("(1) Exit : ");
        int op = input.nextInt();

        clearConsole();

        if (op == 1) {
            manageBooks();
        }else{
            System.out.println("Invalid Option");
        }
    }

    // ------------------------ End of Manage Books ---------------------------

    public static void manageMembers(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(PURPLE + "------------ MANAGE MEMBERS --------------" + RESET);

            System.out.println("(1) Add Member");
            System.out.println("(2) Update Member");
            System.out.println("(3) Remove Member");
            System.out.println("(4) Search Member");
            System.out.println("(5) View All Members");
            System.out.println("(6) Exit");

        System.out.print("Enter the Option : ");
            int op = input.nextInt();

        clearConsole();

                switch(op){
                    case 1 -> addMember();
                    case 2 -> updateMember();
                    case 3 -> removeMember();
                    case 4 -> searchMember();
                    case 5 -> viewAllMembers();
                    case 6 -> homePage();
                    default -> System.out.println("Invalid Option");
                }
    }

    public static void addMember(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ ADD MEMBERS --------------" + RESET);

            System.out.print("Enter Member ID : ");
            String memberID = input.next();

            boolean found = false;
            int foundIndex = 0;

                for(int i = 0; i < members.length; i++){

                    if (members[i][0].equals(memberID)) {
                        found = true;
                        foundIndex = i;

                        break;

                    }else {

                        found = false;
                    }
                }

                if(found == false){

                        memberCount++;

                        members = extendMembers(members);

                            members[members.length - 1][0] = memberID;
                        System.out.print("Enter Name : ");
                            input.nextLine();
                            members[members.length - 1][1] = input.nextLine();
                        System.out.print("Enter Phone Number : ");
                            int phone = input.nextInt();

                                int numberCount = 0; // Checking the validation of the phone number
                                int temp = phone;

                                while (temp > 0){
                                    temp /= 10;
                                    numberCount++;
                                }

                                if (numberCount == 9) {
                                    members[members.length - 1][2] = String.valueOf(phone);
                                }else {
                                    System.out.println(RED + "Invalid Phone Number" + RESET);
                                    return;
                                }

                            input.nextLine();

                        System.out.print("Enter Email : ");
                            String email = input.nextLine();

                                boolean validEmail = false;

                                validEmail = emailChecker(email); // Checking the validation of the email

                                if (validEmail == true){
                                    members[members.length - 1][3] = email;
                                }else {
                                    System.out.println(RED + "Invalid Email" + RESET);
                                    return;
                                }

                    clearConsole();
                    header();

                        System.out.println(GREEN + "( " + memberID + " ) " + "New Member is Added" + RESET);
                }else {
                    clearConsole();
                    header();

                    System.out.println(RED + "Duplicated Member ID" + RESET);
                }

            System.out.print("(1) Try Again \t (2) Exit : ");
                int op = input.nextInt();

                clearConsole();

                    if(op == 1){
                        addMember();
                    }else if (op == 2){
                        manageMembers();
                    }

    }

    public static void viewAllMembers(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ ALL MEMBERS --------------" + RESET);

        System.out.println("MemberID | \tName\t\t |\tContact\t\t|\t\tEmail");
        System.out.println("-".repeat(67));

            for(int i = 0; i < members.length; i++){
                for(String m : members[i]){
                    System.out.print(m + "\t | \t");
                }
                System.out.println();
            }

                System.out.print("(1) Exit : ");
                int op = input.nextInt();

            clearConsole();

                if(op == 1){
                    manageMembers();
                }
    }

    public static void searchMember(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ SEARCH MEMBERS --------------" + RESET);

        System.out.print("Enter Member ID : ");
        String memberID = input.next();

        boolean found = false;
        int foundIndex = 0;

        for(int i = 0; i < members.length; i++){
            if (members[i][0].equals(memberID)) {
                found = true;
                foundIndex = i;
                break;
            }
        }

        if(found == false){
            clearConsole();
            header();

            System.out.println(RED + "Member ID " + memberID + " is not found" + RESET);
        }else {
            for(int i = 0; i < 4; i++){
                System.out.print(members[foundIndex][i] + " | ");
            }
            System.out.println();
        }

            System.out.print("(1) Try Again \t (2) Exit : ");
                int op = input.nextInt();

                clearConsole();

                if(op == 1){
                    searchMember();
                }else if (op == 2){
                    manageMembers();
                }

    }

    public static void updateMember(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ UPDATE MEMBERS --------------" + RESET);

        System.out.print("Enter Member ID : ");
        String memberID = input.next();

        boolean found = false;
        int foundIndex = 0;

            for(int i = 0; i < members.length; i++){
                if (members[i][0].equals(memberID)) {
                    found = true;
                    foundIndex = i;

                    break;
                }
            }

            if(found == true){

                clearConsole();
                header();

                System.out.println(Arrays.toString(members[foundIndex]));

                    System.out.print("Rename the Member : ");
                        input.nextLine();
                        members[foundIndex][1] = input.nextLine();
                    System.out.print("Change the Phone Number : ");
                        int phone = input.nextInt();

                            int numberCount = 0;
                            int temp = phone;

                            while (temp > 0){
                                temp /= 10;
                                numberCount++;
                            }

                            if (numberCount == 9) {
                                members[foundIndex][2] = String.valueOf(phone);
                            }else {
                                System.out.println(RED + "Invalid Phone Number" + RESET);
                            }

                        input.nextLine();

                    System.out.print("Change the Email : ");
                        String email = input.nextLine();

                            boolean validEmail = false;

                            validEmail = emailChecker(email);

                            if (validEmail == true){
                                members[foundIndex][3] = email;
                            }else {
                                System.out.println(RED + "Invalid Email" + RESET);
                                return;
                            }

                clearConsole();
                header();

                System.out.println(GREEN + "Member ID " + memberID + " is Updated" + RESET);
            }else {
                clearConsole();
                header();

                System.out.println(RED + "Member ID " + memberID + " is not found" + RESET);
            }

            System.out.print("(1) Try Again \t (2) Exit : ");
            int op = input.nextInt();

        clearConsole();

                if(op == 1){
                    updateMember();
                }else if (op == 2){
                    manageMembers();
                }
    }

    public static void removeMember(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ REMOVE MEMBERS --------------" + RESET);

        System.out.print("Enter Member ID : ");
        String memberID = input.next();

        boolean found = false;

            for(int i = 0; i < members.length; i++){
                if (members[i][0].equals(memberID)) {
                    found = true;

                    for (int j = i; j < memberCount - 1; j++) {
                        members[j] = members[j + 1];
                    }

                    members[members.length - 1] = null;

                    members = shrinkMembers(members);

                    memberCount--;

                clearConsole();
                header();

                    System.out.println(GREEN + "Member ID " + memberID + " is Removed" + RESET);

                    break;
                }
            }

            if(found == false){

                clearConsole();
                header();

                System.out.println(RED + "Member ID " + memberID + " is not found" + RESET);
            }

            System.out.print("(1) Try Again \t (2) Exit : ");
                int op = input.nextInt();

        clearConsole();

                if(op == 1){
                    removeMember();
                }else if (op == 2){
                    manageMembers();
                }
    }

    // ------------------------ End of Manage Members ----------------------------

    public static void issueBooks(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(PURPLE + "------------ ISSUE BOOKS --------------" + RESET);

            System.out.print("Enter Member ID : ");
            String memberID = input.next();

            boolean memberAvailability = false;

                for(int i = 0; i < members.length; i++){
                    if (members[i][0].equals(memberID)) {
                        memberAvailability = true;

                        break;
                    }
                }

            if(memberAvailability == true){

                clearConsole();
                header();

                System.out.println(GREEN + "Membership is Confirmed" + RESET);

                System.out.print("Enter Book ID Want to Issue: ");
                String bookID = input.next();

                boolean bookFound = false;
                int bookFoundIndex = 0;

                    for(int i = 0; i < books.length; i++){ // Searching the Book
                        if (books[i][0].equals(bookID)) {
                            bookFound = true;
                            bookFoundIndex = i;

                            break;
                        }
                    }

                if(bookFound == true){

                    int qty = Integer.valueOf(books[bookFoundIndex][4]);

                    if (qty > 0){
                        qty -= 1;

                        books[bookFoundIndex][4] = String.valueOf(qty);

                        issueBookCount++;

                        issuedBooks = extendedIssueBooks(issuedBooks); // Extendidng the Issued books Array

                            issuedBooks[issuedBooks.length - 1][0] = bookID;
                            issuedBooks[issuedBooks.length - 1][1] = memberID;

                        System.out.print("Enter the Due Date : ");
                        input.nextLine();
                        String dueDate = input.nextLine();

                        Date date = Date.valueOf(dueDate);

                            issuedBooks[issuedBooks.length - 1][2] = String.valueOf(date);

                            clearConsole();
                            header();

                            System.out.println(GREEN + "The Book ID (" + bookID + ") is Issued to the Member [" + memberID + "] Succesfully" + RESET);

                    }else {
                        clearConsole();
                        header();

                        System.out.println(RED + "Book ID " + bookID + " is out of stock" + RESET);
                    }
                }else {
                    clearConsole();
                    header();

                    System.out.println(RED + "Book ID " + bookID + " is not found" + RESET);
                }

            }else if (memberAvailability == false){
                clearConsole();
                header();

                System.out.println(RED + "Membership is not Confirmed" + RESET);
            }

        System.out.print("(1) Try Again \t (2) Exit : ");
            int op = input.nextInt();

            clearConsole();

            if(op == 1){
                issueBooks();
            }else if (op == 2){
                homePage();
            }
    }

    public static void returnBooks(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(PURPLE + "------------ RETURN BOOKS --------------" + RESET);

            System.out.print("Enter Member ID : ");
            String memberID = input.next();

        boolean memberAvailability = false;

            for(int i = 0; i < members.length; i++){ // Checking the membership
                if (members[i][0].equals(memberID)) {
                    memberAvailability = true;

                    break;
                }
            }

            if(memberAvailability == true){

                clearConsole();
                header();

                    System.out.println(GREEN + "Membership is Confirmed" + RESET);

                System.out.print("Enter Book ID Want to Return: ");
                String bookID = input.next();

                boolean bookFound = false;

                    for(int i = 0; i < issuedBooks.length; i++){
                        if (issuedBooks[i][0].equals(bookID) && issuedBooks[i][1].equals(memberID)) { // Checking whether the Book is issued to the exact member that returned
                            bookFound = true;

                                System.out.print("Enter the Returned Date : ");
                                input.nextLine();
                                String rDate = input.nextLine();
                                Date returneddate = Date.valueOf(rDate);

                            calculateFine(returneddate,memberID,bookID); // passing to calculate the overdue fine

                            for (int j = i; j < issuedBooks.length - 1; j++) {
                                issuedBooks[j] = issuedBooks[j + 1];
                            }

                            issuedBooks[issuedBooks.length - 1] = null;

                            issuedBooks = shrinkIssueBooks(issuedBooks); // Shrinking Issued Books Array

                            issueBookCount--;

                                for (int j = 0; j < books.length; j++) { // Changing the quantity after the returned book
                                    if (books[j][0].equals(bookID)) {

                                            int qty = Integer.valueOf(books[j][4]);

                                            qty += 1;

                                            books[j][4] = String.valueOf(qty);

                                        break;
                                    }
                                }

                        clearConsole();
                        header();

                                System.out.println(GREEN + "Member ID (" + memberID + ") is Returned the Book (" + bookID + ") Successfully" + RESET);

                            break;
                        }
                    }

                    if(bookFound == false){

                        clearConsole();
                        header();

                        System.out.println(RED + "The Book ID is not found or Conflict Between Book ID and Returned Member ID" + RESET);
                    }

            }else if (memberAvailability == false){

                clearConsole();
                header();

                    System.out.println(RED + "Membership is not Confirmed" + RESET);
            }

                System.out.print("(1) Try Again \t (2) Exit : ");
                int op = input.nextInt();

                clearConsole();

                    if(op == 1){
                        returnBooks();
                    }else if (op == 2){
                        homePage();
                    }

    }

    public static void viewReports(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(PURPLE + "------------ VIEW REPORTS --------------" + RESET);

        System.out.println("(1) View Over Due Books");
        System.out.println("(2) View Issued Books Per Member");
        System.out.println("(3) Exit");

        System.out.print("Enter the Option : ");
        int op = input.nextInt();

        clearConsole();

            switch(op){

                    case 1 -> viewOverDueBooks();
                    case 2 -> viewIssuedBooks();
                    case 3 -> homePage();
                    default -> System.out.println("Invalid Option");
            }
    }

    private static int uniqueMember = 0;

    private static String[][] viewIB = new String[uniqueMember][2];

    private static String[][] extenedViewIB(String[][] vib){ // Extending ViewIB

        String[][] tempViewIB = new String[vib.length + 1][2];

        for(int i = 0; i < vib.length; i++){
            for(int j = 0; j < 2; j++){
                tempViewIB[i][j] = vib[i][j];
            }
        }
        return tempViewIB;
    }

    public static void viewIssuedBooks() {

        header();
        System.out.println(BLACK + "------------ ISSUED BOOKS --------------" + RESET);
        Scanner input = new Scanner(System.in);

        for (String[] ib : issuedBooks){
            String memberID = ib[1];

            boolean memberAvailability = false;

            for (int i = 0; i < viewIB.length; i++) {
                if (viewIB[i][0].equals(memberID)) {
                    int count = Integer.valueOf(viewIB[i][1]);

                    count++;

                    viewIB[i][1] = String.valueOf(count);

                    memberAvailability = true;

                    break;
                }
            }

            if (memberAvailability == false){
                int count = 1;
                viewIB = extenedViewIB(viewIB);

                viewIB[viewIB.length - 1][0] = memberID;
                viewIB[viewIB.length - 1][1] = String.valueOf(count);
            }
        }

        System.out.println("Member ID | Books Count");
        System.out.println("-".repeat(24));

        for (int i = 0; i < viewIB.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(viewIB[i][j] + "  \t |  \t");
            }
            System.out.println();
        }

        System.out.print("(1) Exit : ");
            int op = input.nextInt();

        clearConsole();

                if(op == 1){
                    viewReports();
                }
    }

    public static void viewOverDueBooks(){

        Scanner input = new Scanner(System.in);
        header();
        System.out.println(BLACK + "------------ OVERDUE BOOKS --------------" + RESET);

        System.out.println("Book ID | Member ID |\tDue Date\t\t| OverDue Days | Fine ");
        System.out.println("-".repeat(60));

        for (int i = 0; i < overDueBooks.length; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(overDueBooks[i][j] + " \t|\t ");
            }
            System.out.println();
        }

            System.out.print("(1) Exit : ");
            int op = input.nextInt();

        clearConsole();

            if(op == 1){
                viewReports();
            }
    }

    public static void main(String[] args) {
        loginMenu();
    }
}