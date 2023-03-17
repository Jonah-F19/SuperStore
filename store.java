import java.util.Scanner;
import java.util.ArrayList;
public class store {  
    static items[] watchs = new items[3];
     static  items[] vehicles = new items[4];
    static items[] groceries = new items[3];
   static  ArrayList<Integer> owned = new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    static player p;
    static boolean gameOver;
    public static void main(String[] args) throws Exception{
        watchs[0] = new items("Rose gold rolex", 65000, 100);
        watchs[1] = new items("Hublot", 10000, 95);
        watchs[2] = new items("Walmart watch", 15, 60);
       
        vehicles[0] = new items("Honda Accord", 30000, 75);
        vehicles[1] = new items("Hennessy venom f5", 3500000, 100);
        vehicles[2] = new items("inflatable boat", 1500, 65);
        vehicles[3] = new items("yacht", 2500000, 90);
       
        groceries[0] = new items("Egg", 8, 80);
        groceries[1] = new items("milk", 6, 80);
        groceries[2] = new items("apple", 2, 97);

    
        gameIntro();
        System.out.println("Great Choice, you have " + p.money + " dollars!!");
        System.out.println("Hello, welcome to the super store!");
        System.out.println("Today we have 10 items in stock ranging from cars, to watches, all the way to groceries.");
        store();
        if (p.money < 2){
            System.out.println("Your game has ended due to you not having enough money to buy the cheapest item, an egg.");
        }
        System.out.println("Thank you for playing. You bought a total of " + owned.size() + "items.");
        System.out.println("Including "); 
        for (int i: owned){
        items has = getItemAtIndex(i);
        System.out.println(has.name);
}

    }

public static void gameIntro(){
    System.out.println("Choose which celebrity would you like to be: ");
    System.out.println("1. Daniel Jones");
    System.out.println("2. Sterling Shepard");
    System.out.println("3. Lionel Messi");
    System.out.println("4. Landon Colins");
    int ans = 0;
    while (ans > 4 || ans < 1) {
        if (sc.hasNextInt()) {
            ans = sc.nextInt();
            if (ans > 4 || ans < 1) {
                System.out.println("You input a incorrect number, please input a number 1-4");
            }
        } else {
            System.out.println("You did not enter a number, please enter a number from 1-4");
            sc.next();
        }
    }
    p = new player(ans);

}

public static void store(){
    while (gameOver != true || p.money<2){
    System.out.println("Would you like to 1. buy or 2. sell items today?");
    int option = 0;
    int over = 0;
    while (option > 2 || option < 1) {
        if (sc.hasNextInt()) {
            option = sc.nextInt();
            if (option > 2 || option < 1) {
                System.out.println("You input a incorrect number, please input 1 or 2");
            }
        } else {
            System.out.println("You did not enter a number, please input 1 or 2");
            sc.next();
        }
    }
    if (option == 1){
        buy();
    }else{
        sell();
    }
    System.out.println("Thank you so much!!! You now own: ");
    for (int i: owned){
        items has = getItemAtIndex(i);
        System.out.println("A(n) " + has.name);
}
    System.out.println("Would you like to continue playing or do you want end here?");
    System.out.println("Enter 1 to continue and 2 to end");
    while (over > 2 || over < 1) {
        if (sc.hasNextInt()) {
            over = sc.nextInt();
            if (over > 2 || over < 1) {
                System.out.println("You input a incorrect number, please input 1 or 2");
            }
        } else {
            System.out.println("You did not enter a number, please input 1 or 2");
            sc.next();
        }
    }
    if (over == 2){
        gameOver = true;
    }
}
}

public static void buy(){
    System.out.println("Hello, today we have");
    for (int i = 0; i < 3; i++){
        System.out.println(i+1 + ". " + watchs[i].name + ". The price is " + watchs[i].price);
        watchs[i].indexvalue = i+1;
    }
    for (int i = 0; i < 4; i++){
        System.out.println(i+4 + ". " + vehicles[i].name + ". The price is " + vehicles[i].price);
        vehicles[i].indexvalue = i+4;
    }
    for (int i = 0; i < 3; i++){
        System.out.println(i+8 + ". " + groceries[i].name + ". The price is " + groceries[i].price);
        groceries[i].indexvalue = i+8;
    }
    System.out.println("which would you like to buy. If you have changed your mind and would like to sell please enter 11");
    int item = 0;
    while (item > 11 || item < 1) {
        if (sc.hasNextInt()) {
            item = sc.nextInt();
            if (item > 11 || item < 1) {
                System.out.println("You input a incorrect number, please input 1 or 2");
            }
        } else {
            System.out.println("You did not enter a number, please input 1 or 2");
            sc.next();
        }
    if (item == 11){
        sell();
    }else{
        items choice = getItemAtIndex(item);
        if (choice.price > p.money){
            System.out.println("sorry you do not have enough money to buy this item");
        }else {
        p.money = p.money - choice.price;
        owned.add(item);
        }
        System.out.println("Thank you for buying a(n) " + choice.name);
        System.out.println("You now have " + p.money + " left.");
     }
    }
}

public static items getItemAtIndex(int index) {
    for (int i = 0; i < 3; i++){
        if (watchs[i].indexvalue == index) {
            return watchs[i];
        }
    }
    for (int i = 0; i < 4; i++){
        if (vehicles[i].indexvalue == index){
            return vehicles[i];
        }
    }
    for (int i = 0; i < 3; i++){
        if (groceries[i].indexvalue == index){
            return groceries[i];
        }
    }
    return null;
}

public static void sell(){
//haven't done this yet
System.out.println("This function is a work in progress please just use the buy function for right now");
}
}