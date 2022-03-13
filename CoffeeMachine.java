import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static int [][] cost = {{250,0,16,4},{350,75,20,7},{200,100,12,6}};

    public static void main(String[] args) {
        speak();
    }

    public static  void write() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", water, milk, beans, cups, money);
        speak();
    }

    public static  void speak() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();
        switch (order) {
            case "buy": buy();
                break;
            case "fill": fill();
                break;
            case "take": take();
                break;
            case "remaining": write();
                break;
            case "exit": System.exit(0);
                break;
        }
    }

    public static  void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String ord = scanner.nextLine();
        if (ord.equals("back")){
            speak();
        }
        else {
            int order = Integer.parseInt(ord);
            if (water - cost[order - 1][0] >= 0 && milk - cost[order - 1][1] >= 0 && beans - cost[order - 1][2] >= 0) {
                water -= cost[order - 1][0];
                milk -= cost[order - 1][1];
                beans -= cost[order - 1][2];
                money += cost[order - 1][3];
                cups --;
                System.out.println("I have enough resources, making you a coffee!");
            }
            else {
                if (water - cost[order - 1][0] < 0) {
                    System.out.println("Sorry, not enough water!");
                }
                else if (milk - cost[order - 1][1] < 0) {
                    System.out.println("Sorry, not enough milk!");
                }
                else if (beans - cost[order - 1][2] < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
            }
            speak();
        }
    }

    public static  void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        Scanner scanner = new Scanner(System.in);
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
        speak();
    }

    public static  void take() {
        System.out.printf("I gave you $%d", money);
        money = 0;
        speak();
    }
}
