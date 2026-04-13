import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Coffee{
    public static void main(String args[]) throws IOException {
        // 1. Creamos el lector
        Scanner lector = new Scanner(System.in);
        int mesUsuario = 0;
        boolean mesValido = false;

        // 2. Solicitamos los datos iniciales, Con validación para el mes
        while (!mesValido) {
            System.out.print("Ingrese el número del mes (1-12): ");
            mesUsuario = lector.nextInt();

            if (mesUsuario >= 1 && mesUsuario <= 12) {
                mesValido = true;
            } else {
                System.out.println("Mes inválido. Por favor, ingrese un número entre 1 y 12.");
            }
        }

        // 3. Creamos el Ciclo de validación para el año
        boolean anioValido = false;
        int anioUsuario = 0;

        while (!anioValido) {
            System.out.print("Ingrese el año: ");
            anioUsuario = lector.nextInt();

            if (anioUsuario > 0) {
                anioValido = true;
            } else {
                System.out.println("Año inválido. Por favor, ingrese un número positivo.");
            }
        }

        // 4. Ahora creamos la bitácora con esos datos
        Logbook coffee = new Logbook(mesUsuario, anioUsuario);

        // 5. Solicitamos el menu de registro al usuario
        System.out.println("\n--- Menú de Registro ---");
        System.out.println("1. Día 1 y día 15");
        System.out.println("2. Primer y último día");
        System.out.println("3. Todos los viernes");
        System.out.println("4. Días específicos");
        System.out.print("Seleccione una opción: ");
        int opcion = lector.nextInt();

        // 6. Dependiendo de la opción, registramos las tazas correspondientes
        switch(opcion) {
            case 1:
                System.out.print("¿Cuántas tazas para el día 1? ");
                int tazas1 = lector.nextInt();
                coffee.putEntry(1, tazas1);

                System.out.print("¿Cuántas tazas para el día 15? ");
                int tazas15 = lector.nextInt();
                coffee.putEntry(15, tazas15);
                break;
            case 2:
                System.out.print("¿Cuántas tazas para el día 1? ");
                int tazasPrimero = lector.nextInt();
                coffee.putEntry(1, tazasPrimero);
                
                System.out.print("¿Cuántas tazas para el último día? ");
                int tazasUltimo = lector.nextInt();
                coffee.putEntry(coffee.daysInMonth(), tazasUltimo);
                break;
            case 3:
                // Aquí iría la lógica de los viernes 
                System.out.print("¿Cuántas tazas desea registrar para todos los viernes del mes? ");
                int tazasParaViernes = lector.nextInt(); // Se pide UNA sola vez

                for (int dia = 1; dia <= coffee.daysInMonth(); dia++) {
                    GregorianCalendar aux = new GregorianCalendar(coffee.year(), coffee.month() - 1, dia);
                    
                    if (aux.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        coffee.putEntry(dia, tazasParaViernes); // Se aplica la misma variable a todos los viernes
                    }
                }
                break;
            case 4:
                // Opción para registrar tazas en días específicos
                System.out.print("¿Que días desea registrar? ");
                String diasInput = lector.next(); // Ejemplo: "1,3,5"
                String[] diasArray = diasInput.split(","); 
                for (String diaStr : diasArray) {
                    try {
                        int dia = Integer.parseInt(diaStr.trim());
                        if (dia >= 1 && dia <= coffee.daysInMonth()) {
                            System.out.print("¿Cuántas tazas para el día " + dia + "? ");
                            int tazas = lector.nextInt();
                            coffee.putEntry(dia, tazas);
                        } else {
                            System.out.println("Día " + dia + " es inválido. Ignorando.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada '" + diaStr + "' no es un número válido. Ignorando.");
                    }
                }
                break;
            default:
                System.out.println("Opción no válida. No se registraron datos.");
        }

        // 3. Mostrar resultados
        System.out.println("\n======= BITÁCORA DE CONSUMO =======");
        System.out.println("Mes/Año : " + coffee.month() + "/" + coffee.year());

        for (int day = 1; day <= coffee.daysInMonth(); day++) {
            // %02d alinea a 2 dígitos con cero a la izquierda
            System.out.printf("%02d: %3d tazas (%02d/%02d/%d)\n", 
                              day, 
                              coffee.getEntry(day), 
                              day, 
                              coffee.month(), 
                              coffee.year());
        }
    }
}
