import java.util.Scanner;

public class practice {
    static int rows, seats;
    static String[][] seats_Show;
    static int ticket_counts;
    static double percentage;
    static int income;
    static int total_income;
    static Scanner sc = new Scanner(System.in);
    private static void notice() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int select = sc.nextInt();
        if(select==1) {
            show_The_Seats(seats_Show);
        }
        if(select==2) {
            buy_A_Ticket(rows, seats, seats_Show);
        }
        if(select==3) {
            statistics(ticket_counts, percentage, income, total_income);
        }
    }
    private static void buy_A_Ticket(int rows, int seats, String[][] seatsArray) {
        int ticket_Price;
        int row_num;
        int seat_num;

        while(true) {
            System.out.println();
            System.out.println("Enter a row number:");
            row_num = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat_num = sc.nextInt();
            if(row_num>rows || seat_num>seats) {
                System.out.println("Wrong input!");
            }
            else if(seatsArray[row_num][seat_num].equals("B ")) {
                System.out.println("That ticket has already been purchased!");
            }
            else break;
        }
        if(rows*seats>60) {
            if(row_num<=rows/2) {
                ticket_Price = 10;
            }
            else ticket_Price = 8;
        }
        else ticket_Price = 10;
        System.out.println("Ticket price: $"+ticket_Price);
        System.out.println();
        seatsArray[row_num][seat_num] = "B ";
        ticket_counts++;
        percentage = (double)ticket_counts/(rows*seats)*100;
        income = income+ticket_Price;
        if(rows*seats>60) {
            int high_price = rows/2;
            total_income = high_price*seats*10 + (rows-high_price)*seats*8;
        }
        else total_income = rows*seats*10;
        notice();
    }
    private static void show_The_Seats(String[][] seatsArray) {
        System.out.println();
        System.out.println("Cinema:");
        for (String[] strings : seatsArray) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println();
        notice();
    }
    private static void statistics(int ticket_counts, double percentage, int income, int total_income) {
        System.out.printf("Number of purchased tickets: %d%n", ticket_counts);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.print("%");
        System.out.println();
        System.out.printf("Current income: $%d%n", income);
        System.out.printf("Total income: $%d%n", total_income);
        System.out.println();
        notice();
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();
        System.out.println();
        seats_Show = new String[rows+1][seats+1];

        for(int i=0; i<=seats; i++) {
            seats_Show[0][i] = i+" ";
        }

        for(int i=1; i<=rows; i++) {
            seats_Show[i][0] = i + " ";
            for (int j = 1; j <= seats; j++) {
                seats_Show[i][j] = "S ";
            }
        }
        seats_Show[0][0] = "  ";

        notice();
    }
}