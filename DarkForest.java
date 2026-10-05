
import java.util.Scanner;

public class DarkForest {

    static Scanner input = new Scanner(System.in);

    static int health = 100;

    static boolean hasMap = false;
    static boolean hasChest = false;

    static boolean alive = true;
    static boolean playing = true;

    public static void main(String[] args) {

        while (playing) {

            // Reset the game
            health = 100;
            hasMap = false;
            hasChest = false;
            alive = true;

            System.out.println("\n================================");
            System.out.println("          THE DARK FOREST");
            System.out.println("================================\n");

            System.out.println("You wake up in the Dark Forest. You have no memory of how you got here.\n");
            System.out.println("You see a path in front of you.\n");
            System.out.println("Do you want to walk forward or turn back? (forward/back)\n");

            String choice = getChoice("forward", "back");

            if (choice.equals("forward")) {

                System.out.println("\nYou walk forward... it is very dark and you hear strange noises.\n");
                System.out.println("Suddenly, you see a cabin in the distance.\n");
                System.out.println("Do you want to go inside or keep walking? (inside/walk)\n");

                choice = getChoice("inside", "walk");

                if (choice.equals("inside")) {

                    cabin();

                } else if (choice.equals("walk")) {

                    forestEncounter();

                }

            } else if (choice.equals("bacFredrik Mikaelsson lade till 4 resurser
I går vid 14:28
ÖvningarFL2.docx
k")) {

                System.out.println("\nYou turn back and find yourself at the entrance of the Dark Forest.");
                System.out.println("You have survived, but you are now lost.\n");

            }

// End of game
if (alive) {

    System.out.println("\nYou survived this part of the forest.");

} else {

    System.out.println("\nGame over.");

}

System.out.println("\nFinal health: " + health);

showInventory();

System.out.println("\nRespawn? yes/no");

choice = getChoice("yes", "no");

if (choice.equals("no")) {
    playing = false;
}

}

System.out.println("\nGame over.");

input.close();
    }

    // Handles player input and validates choices
    public static String getChoice(String... options) {

        while (true) {

            String choice = input.nextLine().trim().toLowerCase();

            for (String option : options) {

                if (choice.equals(option)) {
                    return choice;
                }
            }

            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Displays the player's inventory
    public static void showInventory() {

        System.out.println("\nInventory:");

        if (hasMap) {
            System.out.println("- Map");
        }

        if (hasChest) {
            System.out.println("- Locked Chest");
        }

        if (!hasMap && !hasChest) {
            System.out.println("- Empty");
        }
    }

    // Reduces health
    public static void damage(int amount) {

        health -= amount;

        if (health < 0) {
            health = 0;
        }

        System.out.println("\nYou lost " + amount + " health.");
        System.out.println("Current health: " + health);

        if (health <= 0) {
            die();
        }
    }

    // Player death
    public static void die() {

        health = 0;
        alive = false;

        System.out.println("\nYou have died.");
    }

    // Cabin storyline
    public static void cabin() {

        System.out.println("\nYou enter the cabin and find a friendly old man who offers you food and shelter.");
        System.out.println("You have survived the night.\n");

        System.out.println("You wake up the next morning, share a meal with the old man, and he gives you a map to help you navigate the forest. He wishes you well on your journey.\n");

        hasMap = true;

        System.out.println("You obtained a map!");

        exploreForest();
    }

    // Bear encounter storyline
    public static void forestEncounter() {

        System.out.println("\nYou keep walking and hear something moving in the bushes.\n");
        System.out.println("Do you want to investigate or run away? (investigate/run)");

        String choice = getChoice("investigate", "run");

        if (choice.equals("investigate")) {

            System.out.println("\nYou investigate the bushes.\n");
            System.out.println("Before you can see what it is, you hear a growl.");
            System.out.println("A small bear jumps out and starts playfighting with you.\n");

            System.out.println("You survive the encounter, but you are now tired.");
            System.out.println("You decide to rest for a while before continuing your journey.\n");

            System.out.println("Do you want to build a fire to keep warm or rest in the open? (fire/rest)");

            choice = getChoice("fire", "rest");

            if (choice.equals("fire")) {

                System.out.println("\nYou build a fire and keep warm through the night. You wake up feeling refreshed and ready to continue your journey.");

            } else if (choice.equals("rest")) {

                System.out.println("\nYou rest in the open, but the cold night air makes you shiver. You wake up feeling tired and weak, but you continue your journey.");

                damage(20);

            }

        } else if (choice.equals("run")) {

            System.out.println("\nYou run away as fast as you can, but you trip and fall.");
            System.out.println("You have survived, but you are now injured.");

            damage(30);

        }

        if (alive) {
            exploreForest();
        }
    }

    // Main exploration loop
    public static void exploreForest() {

        boolean exploring = true;

        while (alive && exploring) {

            System.out.println("\n================================");
            System.out.println("          DARK FOREST");
            System.out.println("================================");

            System.out.println("\nHealth: " + health);

            showInventory();

            System.out.println("\nYou go out into the forest, what direction do you want to go? (north/south/east/west)");

            String direction = getChoice("north", "south", "east", "west");

            exploreDirection(direction);

            if (alive) {

                System.out.println("\nDo you want to continue exploring? (yes/no)");

                String choice = getChoice("yes", "no");

                if (choice.equals("no")) {
                    exploring = false;
                }
            }
        }
    }

    // Direction-based exploration
    public static void exploreDirection(String direction) {

        if (direction.equals("north")) {

            System.out.println("\nYou head north and find a beautiful waterfall. You take a moment to rest and enjoy the scenery.\n");

            System.out.println("You decide to jump into the water and swim for a while.\n");

            System.out.println("You dive and find a chest, but it is locked.\n");

            if (!hasChest) {

                hasChest = true;

                System.out.println("You decide to take the chest with you and continue your journey, hoping to find a way to open it later.");

                System.out.println("\nYou obtained a locked chest!");

            } else {

                System.out.println("You already have the chest.");

            }

        } else if (direction.equals("south")) {

            System.out.println("\nYou head south and find a hidden cave. Inside, you discover ancient drawings on the walls. You take a moment to study them and feel a sense of wonder at the history of the forest. ");

        } else if (direction.equals("east")) {

            System.out.println("\nYou head east and come across a field of wildflowers. You take a moment to appreciate the beauty of nature.");

        } else if (direction.equals("west")) {

            System.out.println("\nYou head west and find a small village. The villagers welcome you and offer you food and shelter.");

        }
    }
}