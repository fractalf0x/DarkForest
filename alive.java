public class alive {

    public alive() {

        if (DarkForest.alive) {

            System.out.println("\n");

        } else {

            System.out.println("\nGame over.");
        }

        System.out.println("\nFinal health: " + DarkForest.health);

        DarkForest.showInventory();

        System.out.println("\nRespawn? yes/no");

        String choice = DarkForest.getChoice("yes", "no");

        if (choice.equals("no")) {
            DarkForest.playing = false;
        }
    }
}