
// TODO:ALMACENAR INFORMACIÓN

// TODO:IMPLEMENTAR MENÚ PRINCIPAL:
// TODO:Opción 1:Seleccionar planeta 
// TODO:Opción 2:Elegir una nave 
// TODO:Opción 3:Iniciar viaje 
// TODO:Opción 4:Salir del programa

// TODO:IMPLEMENTAR SELECCIÓN DE PLANETA:
// TODO:Mostrar distancia 
// TODO:Mostrar breve descripción del planeta

// TODO:ADMINISTRAR RECURSOS DE LA NAVE

// TODO:IMPLEMENTAR EVENTOS ALEATORIOS EN EL VIAJE 
// TODO:Mostrar descripción del evento 
// TODO:Darle opciones al usuario de cómo afrontarlo

// TODO:IMPLEMENTAR SIMULACIÓN DEL VIAJE 
// TODO:Calcular duración del viaje estimada en días 
// TODO:Calcular progreso del viaje mediante bucles básicos 

// TODO:Mostrar etapas clave del viaje(inicio,mitad y llegada al destino)
// TODO:Generar un número aleatorio y contrastarlo con un una condición que signifique la ocurrencia de un evento inesperado

import java.util.Arrays;

public class SpaceStation {

    /*
     * INITIALIZE STATIC ATTRIBUTES
     * This is done to avoid code repetition when passing arguments to auxiliary
     * functions.
     */

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

    // ------ MAIN ------
    public static void main(String[] args) throws Exception {

        // Rocket fuel consumption test

        // In the actual rocket selection, this number will be reduced by one
        int rocketNumber = 1;

        System.out.printf("%nInitial fuel gallons: %f gal%n", rocketFuelTanks[rocketNumber]);

        double gallonsConsumed = 2_300_000D;
        drainRocketFuelTank(rocketNumber, gallonsConsumed);

        System.out.printf("%nUpdated fuel gallons: %f gal%n", rocketFuelTanks[rocketNumber]);

        // Rocket fuel tank refill test

        chargeRocketFuelTank(rocketNumber);

        System.out.printf("%nFuel gallons after refill: %f gal%n", rocketFuelTanks[rocketNumber]);

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
                "Visitors may witness diamond rains in Neptune",
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

    // TODO: (TEST) Charge rocket fuel tank
    private static void chargeRocketFuelTank(int rocketNumber) {

        rocketFuelTanks[rocketNumber] = rocketFuelTankCapacities[rocketNumber];

    }

}
