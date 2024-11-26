
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

    private static String[] menuOptions = getMainMenuOptions();

    private static String[] planetNames = getPlanetNames();

    private static Double[] planetDistances = getPlanetDistances();

    public static void main(String[] args) throws Exception {

        // Array creation test
        System.out.printf("Planet distances: %s%n", Arrays.toString(planetDistances));

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
}
