
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
    private static String[] menuOptions = getMainMenuOptions();

    private static String[] planetNames = getPlanetNames();

    private static Double[] planetDistances = getPlanetDistances();

    private static String[] planetInformation = getPlanetInformation();

    // INITIALIZE ROCKET INFORMATION
    private static String[] rocketNames = getRocketNames();

    public static void main(String[] args) throws Exception {

        // Array creation test
        for (String rocketName : rocketNames) {
            System.out.println(rocketName + "\n");
        }

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
}
