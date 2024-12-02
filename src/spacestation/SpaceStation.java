package spacestation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SpaceStation {

    /*
     * INITIALIZE STATIC ATTRIBUTES
     * This is done to avoid code repetition when passing arguments to auxiliary
     * functions.
     */

    private static DecimalFormat fuelAndDistanceAmountFormatter = new DecimalFormat("#,###.##");

    private static DecimalFormat percentageFormatter = new DecimalFormat("#.##");

    private static Scanner sc = new Scanner(System.in);

    /*
     * WHY USE ARRAYS INSTEAD OF ARRAYLISTS?
     * Arrays are more space efficient than ArrayLists
     * No insertion or deletion will be required
     * We have fixed element amounts
     */

    // INITIALIZE PLANET INFORMATION
    private static final String[] menuOptions = getMainMenuOptions();

    private static final String[] planetNames = getPlanetNames();

    private static final Double[] planetDistances = getPlanetDistances();

    private static final String[] planetInformation = getPlanetInformation();

    // INITIALIZE ROCKET INFORMATION
    private static final String[] rocketNames = getRocketNames();

    // Speeds given in km/h
    private static final Double[] rocketSpeeds = getRocketSpeeds();

    // Rocket fuel consumption rates given in gal/h
    private static final Double[] rocketFuelConsumptionRates = getRocketFuelConsumptionRates();

    // Rocket fuel tank capacities given in gal
    private static final Double[] rocketFuelTankCapacities = getRocketFuelTankCapacities();

    /*
     * Fuel tanks start full.
     * getRocketFuelTankCapacities() also works to initialize this variable
     * Not final. Values will be modified.
     */
    private static Double[] rocketFuelTanks = getRocketFuelTankCapacities();

    MAIN
    public static void main(String[] args) throws Exception {

        runMainMenu();

    }

    // --- PLANET INFO INITIALIZATION ---
    // Store main menu options
    private static String[] getMainMenuOptions() {

        var mainMenuOptions = new String[] {
                "Explore destinations",
                "See our rockets",
                "Travel now",
                "Exit",
        };

        return mainMenuOptions;

    }

    // Store planet names
    private static String[] getPlanetNames() {

        var planetNames = new String[] {
                "Neptune",
                "Uranus",
                "Saturn",
                "Jupiter",
                "Mercury",
                "Mars",
                "Venus",
        };

        return planetNames;
    }

    // Store planet distances. Stored as doubles to facilitate future calculations
    private static Double[] getPlanetDistances() {

        var planetDistances = new Double[] {
                4_311_020_000D,
                2_586_880_000D,
                1_204_280_000D,
                591_970_000D,
                82_500_000D,
                55_650_000D,
                39_790_000D
        };

        return planetDistances;

    }

    // Store planet information
    private static String[] getPlanetInformation() {

        var planetInformation = new String[] {
                "Visitors may witness diamond rains in Neptune.",
                "Uranus was the first planet to be discovered by a telescope.",
                "Saturn has 146 moons in orbit, more than any other planet in our Solar System.",
                "Jupiter is the biggest planet in our Solar System.",
                "One day in Mercury is almost two-thirds of a year.",
                "Mars' shield volcano 'Olympus Mons' is about 2.5 times as high as Mt. Everest.",
                "A Venus day (243 days) lasts longer than a year (225 days)."
        };

        return planetInformation;

    }

    // --- ROCKET INFO INITIALIZATION ---
    // Store rocket names
    private static String[] getRocketNames() {

        var rocketNames = new String[] {
                "Stellar Voyager",
                "Eclipse Arrow",
                "Nebula Titan",
                "Aurora Striker",
        };

        return rocketNames;

    }

    // Store rocket speeds (km / h)
    private static Double[] getRocketSpeeds() {

        var rocketSpeeds = new Double[] {
                100_000D,
                140_000D,
                80_000D,
                120_000D,
        };

        return rocketSpeeds;

    }

    // Store rocket fuel consumption rates (gal / h)
    private static Double[] getRocketFuelConsumptionRates() {

        var rocketFuelConsumptionRates = new Double[] {
                80_000D,
                100_000D,
                70_000D,
                120_000D,
        };

        return rocketFuelConsumptionRates;

    }

    // Store rocket fuel tank capacities (gal)
    private static Double[] getRocketFuelTankCapacities() {

        var rocketFuelTankCapacities = new Double[] {
                9_200_000D,
                8_500_000D,
                7_000_000D,
                9_100_000D,
        };

        return rocketFuelTankCapacities;

    }

    // --- ROCKET METHODS ---
    // Consume fuel
    private static void drainRocketFuelTank(int rocketNumber, Double gallonsConsumed) {

        rocketFuelTanks[rocketNumber] -= gallonsConsumed;

    }

    // Charge rocket fuel tank
    private static void chargeRocketFuelTank(int rocketNumber) {

        rocketFuelTanks[rocketNumber] = rocketFuelTankCapacities[rocketNumber];

    }

    // Get rocket fuel tank level (as a %)
    private static double getRocketFuelTankLevel(int rocketNumber) {

        return rocketFuelTanks[rocketNumber] / rocketFuelTankCapacities[rocketNumber] * 100;

    }

    // --- PRINT INFORMATION IN CONSOLE ---
    // Print rockets information
    private static void getRocketsInfo() {

        System.out.printf("%n--- OUR ROCKETS ---%n");

        System.out.println();
        System.out.println(
                """
                        \s\s\s\s\s\s\s/\\            /\\            /\\            /\\\n      /  \\          /  \\          /  \\          /  \\\n     / || \\        / || \\        / || \\        / || \\\n    /  ||  \\      /  ||  \\      /  ||  \\      /  ||  \\\n   /___||___\\    /___||___\\    /___||___\\    /___||___\\\n      |  |          |  |          |  |          |  |\n     /_||_\\        /_||_\\        /_||_\\        /_||_\\\n    |______|      |______|      |______|      |______|\n      ||||          ||||          ||||          ||||\n      ||||          ||||          ||||          ||||\n     (----)        (----)        (----)        (----)\n      ====          ====          ====          ====\n     |    |        |    |        |    |        |    |\n    /______\\      /______\\      /______\\      /______\\\n
                                """);

        for (int i = 0; i < rocketNames.length; i++) {
            // Show rocket name
            System.out.printf("%n*** %d. %s ***%n", i + 1, rocketNames[i]);

            // Show rocket tank capacity
            System.out.printf("Total fuel tank capacity: %s gal%n",
                    fuelAndDistanceAmountFormatter.format(rocketFuelTankCapacities[i]));

            // Show rocket fuel tank level
            System.out.printf("Fuel tank level: %s%%%n", getRocketFuelTankLevel(i));

            // Show fuel consumption rate
            System.out.printf("Fuel consumption rate: %s gal/h%n",
                    fuelAndDistanceAmountFormatter.format(rocketFuelConsumptionRates[i]));
            System.out.printf("Speed: %s km/h%n", fuelAndDistanceAmountFormatter.format(rocketSpeeds[i]));
        }

        System.out.println("\n---------------------");

    }

    private static void getPlanetsInfo() {

        System.out.printf("%n--- DESTINATIONS ---%n");

        System.out.println("""
                                     .::.
                                  .:'  .:
                        ,MMM8&&&.:'   .:'
                       MMMMM88&&&&  .:'
                      MMMMM88&&&&&&:'
                      MMMMM88&&&&&&
                    .:MMMMM88&&&&&&
                  .:'  MMMMM88&&&&
                .:'   .:'MMM8&&&'
                :'  .:'
                '::'
                                """);

        for (int i = 0; i < planetNames.length; i++) {
            // Show planet name
            System.out.printf("%n*** %d. %s ***%n", i + 1, planetNames[i]);

            // Show distance from Earth
            System.out.printf("%s is %s km away from Earth.%n", planetNames[i],
                    fuelAndDistanceAmountFormatter.format(planetDistances[i]));

            // Show planet information
            System.out.println(planetInformation[i]);
        }

        System.out.println("\n---------------------");

    }

    // --- MAIN MENU IMPLEMENTATION ---
    // Run main menu
    private static void runMainMenu() {

        // Initiate flag
        var isExecutingMenu = true;

        while (isExecutingMenu) {

            // Welcome user
            System.out.println();
            System.out.println(
                    """
                            \s_____  ____  _____  ____   ____   _____  _____       \n/  ___>/    \\/   __\\/  _/  /  _/  /  _  \\/  _  \\      \n|___  |\\-  -/|   __||  |---|  |---|  _  ||  _  <      \n<_____/ |__| \\_____/\\_____/\\_____/\\__|__/\\__|\\_/      \n                                                      \n __ __  _____  _____  ___  _____  _____  _____  _____ \n/  |  \\/  _  \\/  _  \\/___\\|__   //  _  \\/  _  \\/  ___>\n|  _  ||  |  ||  _  <|   | /  _/ |  |  ||  |  ||___  |\n\\__|__/\\_____/\\__|\\_/\\___//_____|\\_____/\\__|__/<_____/
                                              """);

            var welcomeMessage = "Welcome to Stellar Horizons!\nPlease select an option:";

            // Ask for user input
            /*
             * TODO: Implement askMultipleChoiceQuestion()
             * Only integers are allowed
             * Only positive values are allowed
             * Handle non-numeric inputs
             */
            var mainMenuSelection = askMultipleChoiceQuestion(welcomeMessage,
                    menuOptions);

            // React to user input
            switch (mainMenuSelection) {
                case 1:
                    /*
                     * TODO: Implement exploreDestinations()
                     * Shows all the planets' information
                     * Asks user if they want to travel;
                     * executes travelNow() if they do.
                     */
                    exploreDestinations();
                    break;
                case 2:
                    getRocketsInfo();
                    break;
                case 3:
                    /*
                     * TODO: Implement travelNow()
                     */
                    travelNow();
                    break;
                case 4:
                    // Exits menu and ends aplication if user selects '4'
                    isExecutingMenu = false;
                    System.out.println("Until next time!\n");
                    break;
                default:
                    System.err.println("Invalid option.");
                    isExecutingMenu = false;
                    break;
            }

        }

    }

    // Explore destination menu option
    private static void exploreDestinations() {
        getPlanetsInfo();

        System.out.println();

        var travelNow = askYesOrNo("Would you like to travel now?");

        if (travelNow == 1) {
            travelNow();
        }

    }

    private static void travelNow() {

        // Select destination
        var destinationNumber = askMultipleChoiceQuestion("Select destination:", planetNames) - 1;

        // Select rocket
        getRocketsInfo(); // Show all rockets' info
        var rocketNumber = askMultipleChoiceQuestion("Select your rocket:, ",
                rocketNames) - 1;

        // Perform pre-launch rocket fuel level check
        performRocketFuelCheck(rocketNumber);

        // Request passenger number
        var numberOfPassengers = requestPositiveIntegerValue("\nHow many passengers will be on board?: ");

        // Calculate overall travel distance
        var travelDistance = planetDistances[destinationNumber] * 2; // Round trip (planet distance * 2)

        // Calculate estimated travel time

        var rocketSpeed = rocketSpeeds[rocketNumber];

        var estimatedTravelTime = travelDistance / rocketSpeed;

        // Display estimated travel time
        System.out.printf("%nEstimated travel time (round trip): %s.%n", processTime(estimatedTravelTime));

        // Show destination planet info

        // Store destiantion planet name
        var destinationPlanetName = planetNames[destinationNumber];

        // Store rocket name
        var spaceship = rocketNames[rocketNumber];

        // Store destination planet information
        var destinationPlanetInformation = planetInformation[destinationNumber];

        // Display launch message in console
        System.out.println(numberOfPassengers + " passengers are on board and ready.");
        System.out.println("Off we go!");
        System.out.println(
                """
                                                               _,\'/\n                                  _.-\'\'._:\n                          ,-:`-.-\'    .:.|\n                         ;-.\'\'       .::.|\n          _..------.._  / (:.       .:::.|\n       ,\'.   .. . .  .`/  : :.     .::::.|\n     ,\'. .    .  .   ./    \\ ::. .::::::.|\n   ,\'. .  .    .   . /      `.,,::::::::.;\\\n  /  .            . /       ,\',\';_::::::,:_:\n / . .  .   .      /      ,\',\',\'::`--\'\':;._;\n: .             . /     ,\',\',\':::::::_:\'_,\'\n|..  .   .   .   /    ,\',\',\'::::::_:\'_,\'\n|.              /,-. /,\',\':::::_:\'_,\'\n| ..    .    . /) /-:/,\'::::_:\',-\'\n: . .     .   // / ,\'):::_:\',\' ;\n \\ .   .     // /,\' /,-.\',\'  ./\n  \\ . .  `::./,// ,\'\' ,\'   . /\n   `. .   . `;;;,/_.\'\' . . ,\'\n    ,`. .   :;;\' `:.  .  ,\'\n   /   `-._,\'  ..  ` _.-\'\n  (     _,\'``------\'\' \n   `--\'\'
                        """);

        System.out.printf("%n%nDestination planet: %s%nSpaceship: %s%n%s%n", destinationPlanetName, spaceship,
                destinationPlanetInformation);

        // Initialize trackers
        var overallFuelConsumed = 0D;
        var overallTimeElapsed = 0D;
        var overallDistanceCovered = 0D;

        // Initialize week counter
        var weekCounter = 1;

        // Initialize rocket variables to avoid code duplication
        var rocketFuelTank = rocketFuelTanks[rocketNumber];
        var rocketFuelTankCapacity = rocketFuelTankCapacities[rocketNumber];
        var rocketFuelConsumptionRate = rocketFuelConsumptionRates[rocketNumber];

        var possibleDailyDistanceCoverage = 24 * rocketSpeed;

        // Implement journey loop
        while (overallDistanceCovered != travelDistance) {

            // Show week number
            System.out.printf("%nWEEK %d - PRELIMINARY REPORT%n", weekCounter);

            // Show journey percentage covered
            System.out.printf("Journey %% covered: %s%%%n",
                    overallTimeElapsed != 0 ? percentageFormatter.format(overallDistanceCovered / travelDistance * 100)
                            : "0%");
            // Show distance covered
            System.out.printf("Distance covered: %s%n", fuelAndDistanceAmountFormatter.format(overallDistanceCovered));

            // Show time elapsed
            System.out.printf("Time elapsed: %s%n", processTime(overallTimeElapsed));

            // Show fuel level
            System.out.printf("Fuel level: %s%%%n",
                    percentageFormatter.format(rocketFuelTankCapacity / rocketFuelTank * 100));

            // Create inner loop that represents days in a week
            for (int dayCounter = 1; dayCounter <= 7; dayCounter++) {

                var dailyFuelConsumption = 0D;
                var dailyDistanceCoverage = 0D;
                var dailyTimeTraveled = 0D;
                var missingTravelDistance = travelDistance - overallDistanceCovered;

                // Show day number
                System.out.printf("%n*** Day %d ***%n", dayCounter);

                // Check fuel tank value
                System.out.println("Fuel tank: " + fuelAndDistanceAmountFormatter.format(rocketFuelTank) + " gal");

                // Check if fuel is enough for the next day
                if (isFuelEnoughForNextDay(rocketFuelConsumptionRate, rocketFuelTank)) {
                    // Evaluate if its the last journey day
                    if (missingTravelDistance <= possibleDailyDistanceCoverage) {
                        dailyTimeTraveled = missingTravelDistance / rocketSpeed;
                        dailyDistanceCoverage = missingTravelDistance;
                    } else {
                        dailyTimeTraveled = possibleDailyDistanceCoverage / rocketSpeed;
                        dailyDistanceCoverage = possibleDailyDistanceCoverage;
                    }
                    dailyFuelConsumption = rocketFuelConsumptionRate * dailyTimeTraveled;
                } else {
                    // Handle running out of fuel at the next day
                    // If there's not enough fuel to cover current and next day, go to fuel station
                    // Simulate spending 10% of remaining fuel going to closest fuel station.
                    dailyFuelConsumption = 0.1 * rocketFuelTank;
                    dailyTimeTraveled = 24;

                    // Print fuel spent going to the gas station
                    System.out.printf("%n%s gal were spent going to closest gas station.%n",
                            fuelAndDistanceAmountFormatter.format(dailyFuelConsumption));
                    goToGasStation(rocketNumber);
                    rocketFuelTank = rocketFuelTankCapacities[rocketNumber];
                }

                // Consume fuel each day and increase overall fuel consumed
                rocketFuelTank -= dailyFuelConsumption;
                overallFuelConsumed += dailyFuelConsumption;

                // Increase overall distance covered
                overallDistanceCovered += dailyDistanceCoverage;

                // Increase overall time elapsed each day
                overallTimeElapsed += dailyTimeTraveled;

                // Print daily information
                System.out.printf(
                        "%nDaily Report:%n- Fuel consumed: %s gal%n- Distance covered: %s km%n- Time traveled: %s h%n",
                        fuelAndDistanceAmountFormatter.format(dailyFuelConsumption),
                        fuelAndDistanceAmountFormatter.format(dailyDistanceCoverage), processTime(dailyTimeTraveled));

                // Finish journey if distance is covered
                if (overallDistanceCovered == travelDistance) {
                    break;
                }
            }

            weekCounter++;

        }

        // Print final report
        System.out.println("\n\n--- FINAL REPORT ---");
        // Show journey percentage covered
        System.out.printf("Journey %% covered: %s%%%n",
                overallTimeElapsed != 0 ? percentageFormatter.format(overallDistanceCovered / travelDistance * 100)
                        : "0%");
        // Show distance covered
        System.out.printf("Distance covered: %s%n", fuelAndDistanceAmountFormatter.format(overallDistanceCovered));

        // Show time elapsed
        System.out.printf("Time elapsed: %s%n", processTime(overallTimeElapsed));

        // Show fuel level
        System.out.printf("Fuel level: %s%%%n",
                percentageFormatter.format(rocketFuelTank / rocketFuelTankCapacity * 100));

        // Show total amount of fuel gallons consumed
        System.out.printf("Fuel gallons consumed: %s gal%n",
                fuelAndDistanceAmountFormatter.format(overallFuelConsumed));

        // Finish journey
        landOnEarth(rocketNumber);
    }

    // --- AUXILIARY FUNCTIONS ---
    private static void performRocketFuelCheck(int rocketNumber) {
        if (getRocketFuelTankLevel(rocketNumber) < 100) {

            // Refill fuel tank
            System.out.printf("Your rocket's fuel tank is at %s%%. We'll fill it up before you launch.%n",
                    percentageFormatter.format(getRocketFuelTankLevel(rocketNumber)));

            chargeRocketFuelTank(rocketNumber);
        } else {
            System.out.println("Your rocket's ready to launch.");
        }
    };

    // Format time based on number of hours given in a more readable way
    private static String processTime(double hours) {

        var days = 0;
        var minutes = 0D;
        var seconds = 0D;

        // Process minutes and seconds
        if (hours % 1 != 0) {
            minutes = (hours % 1) * 60;

            if (minutes % 1 != 0) {
                seconds = Math.floor((minutes % 1) * 60);
            }

        }

        hours = Math.floor(hours);

        // Process days
        if (hours >= 24) {
            days = (int) hours / 24;
            hours %= 24;
        }

        return String.format("%d days %02d hours %02d minutes and %02d seconds", days, (int) hours, (int) minutes,
                (int) seconds);

    }

    // Check if there's enough fuel for the next two days
    private static boolean isFuelEnoughForNextDay(double rocketFuelConsumptionRate, double fuelTank) {

        if (fuelTank > rocketFuelConsumptionRate * 48) {
            return true;
        }

        return false;

    }

    // Go to gas station (fill gas tank)

    private static double goToGasStation(int rocketNumber) {

        System.out.println(
                """
                        \s_____  __ __  _____  ____    _____  ____  _____  _____ \n/   __\\/  |  \\/   __\\/  _/   /  ___>/    \\/  _  \\/  _  \\\n|   __||  |  ||   __||  |--- |___  |\\-  -/|  |  ||   __/\n\\__/   \\_____/\\_____/\\_____/ <_____/ |__| \\_____/\\__/

                                        .-\"\"\"\"-.\n          |==  ==|-.\n          |~~ ~~~|`\\\\\n          |ST.   | ||\n          |HORIZ |//\n          |ONS   |/\n          |      |\n        __|______|__\n       [____________]
                              """);

        chargeRocketFuelTank(rocketNumber);

        System.out.printf("%nWe appreciate your patience. Your rocket's gas tank has been fully loaded.");

        return rocketFuelTanks[rocketNumber];

    }

    // Land on earth
    private static void landOnEarth(int rocketNumber) {
        System.out.println("\n*** WELCOME HOME! ***\n");
        System.out.println(
                """
                                     _-o#&&*\'\'\'\'?d:>b\\_\n          _o/\"`\'\'  \'\',, dMF9MMMMMHo_\n       .o&#\'        `\"MbHMMMMMMMMMMMHo.\n     .o\"\" \'         vodM*$&&HMMMMMMMMMM?.\n    ,\'              $M&ood,~\'`(&##MMMMMMH\\\n   /               ,MMMMMMM#b?#bobMMMMHMMML\n  &              ?MMMMMMMMMMMMMMMMM7MMM$R*Hk\n ?$.            :MMMMMMMMMMMMMMMMMMM/HMMM|`*L\n|               |MMMMMMMMMMMMMMMMMMMMbMH\'   T,\n$H#:            `*MMMMMMMMMMMMMMMMMMMMb#}\'  `?\n]MMH#             \"\"*\"\"\"\"*#MMMMMMMMMMMMM\'    -\nMMMMMb_                   |MMMMMMMMMMMP\'     :\nHMMMMMMMHo                 `MMMMMMMMMT       .\n?MMMMMMMMP                  9MMMMMMMM}       -\n-?MMMMMMM                  |MMMMMMMMM?,d-    \'\n :|MMMMMM-                 `MMMMMMMT .M|.   :\n  .9MMM[                    &MMMMM*\' `\'    .\n   :9MMk                    `MMM#\"        -\n     &M}                     `          .-\n      `&.                             .\n        `~,   .                     ./\n            . _                  .-\n              \'`--._,dd###pp=\"\"\'
                        """);

        System.out.println("\nThank you all for travelling with us! We hope you've had a wonderful experience.\n");

        chargeRocketFuelTank(rocketNumber);

        System.out.println(
                rocketNames[rocketNumber] + " was charged and is now ready for the next group of adventurers.");
    }

    // --- REQUEST USER INPUT ---
    // Mutliple choice question
    private static int askMultipleChoiceQuestion(String message, String[] options) {

        var answer = 0;
        var validAnswer = false;

        // Line break
        System.out.println();

        while (!validAnswer) {
            try {
                System.out.println(message);

                for (int i = 0; i < options.length; i++) {
                    System.out.printf("%d. %s%n", i + 1, options[i]);
                }

                answer = Integer.parseInt(sc.nextLine());

                if (answer < 1 || answer > options.length) {
                    throw new IllegalArgumentException(
                            "Invalid input. Please try again entering one of the numeric options displayed.\n");
                }

                validAnswer = true;

                // Integer validation (numeric data types)
            } catch (NumberFormatException ex) {
                System.err.println(
                        "Invalid input. Please try again entering one of the numeric options displayed.\n");
                // Integer validation (non-numeric data types)
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + "\n");
            }
        }

        return answer;

    }

    // Yes or no question
    private static int askYesOrNo(String message) {

        var answer = 0;
        var validAnswer = false;

        while (!validAnswer) {

            System.out.println(message);
            System.out.println("1. Yes\n2. No");

            try {
                answer = Integer.parseInt(sc.nextLine());

                if (answer < 1 || answer > 2) {
                    throw new IllegalArgumentException("Invalid choice. Please try again entering 1 or 2.\n");
                } else {
                    validAnswer = true;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please try again entering 1 or 2.");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + "\n");
            }
        }

        return answer;

    }

    // Request positive integer value
    private static int requestPositiveIntegerValue(String message) {

        int answer = 0;
        boolean validAnswer = false;

        while (!validAnswer) {
            System.out.println(message);
            try {
                answer = Integer.parseInt(sc.nextLine());

                if (answer < 1) {
                    throw new NumberFormatException("Invalid input. Please try again with a positive whole number.\n");
                }
                validAnswer = true;

            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Please try again with a positive whole number.\n");
            }
        }

        return answer;

    }

}