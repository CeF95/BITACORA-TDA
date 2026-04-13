import java.util.*; // For GregorianCalendar class

public class Logbook
{
// Atributos
private int logMonth; // Logbook month
private int logYear; // Logbook year
private int[] entry = new int[31]; // Arreglo para 31 dias
private GregorianCalendar logCalendar; // Java’s built-in Calendar class

// Constructor

public Logbook ( int month, int year ) // Create a logbook
{
    // Validación del mes (1-12)
        if (month >= 1 && month <= 12) {
            logMonth = month;
            logYear = year;
        } else {
            // Si es inválido, usa la fecha actual
            GregorianCalendar today = new GregorianCalendar();
            logMonth = today.get(Calendar.MONTH) + 1;
            logYear = today.get(Calendar.YEAR);
        }

        // Configura el calendario interno (Enero en Java es 0, por eso month - 1)
        logCalendar = new GregorianCalendar(logYear, logMonth - 1, 1);

        // Inicializa todas las entradas en 0
        for (int i = 0; i < 31; i++) {
            entry[i] = 0;
        }
 }

    // Operaciones Modificadoras

    public void putEntry ( int day, int value ) // Store entry for day
    { 
        if (day >= 1 && day <= daysInMonth()) {
                entry[day - 1] = value; // El arreglo usa índices 0 a 30
            }
    }
    public int getEntry ( int day ) // Return entry for day
    { 
        if (day >= 1 && day <= daysInMonth()) {
            return entry[day - 1];
        }
        return -1; // Valor de error si el día es inválido
    }

    // General operations/methods

    public int month ( ) // Return the month
    { 
        return logMonth; 
    }

    public int year ( ) // Return the year
    { 
        return logYear; 
    }

    public int daysInMonth ( ) // Retorna cuántos días tiene realmente el mes configurado
    { 
        return logCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); 
    }

    // Facilitator (helper) method
    private boolean leapYear ( )
    {
        return logCalendar.isLeapYear(logYear);
    } // Leap year

} // class Logbook
