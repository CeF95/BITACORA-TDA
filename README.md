# Bitácora de una Cafetería (Implementación TDA)

Este proyecto consiste en la implementación de un **Tipo de Dato Abstracto (TDA)** diseñado para gestionar y registrar la actividad diaria de una cafetería. Permite realizar un seguimiento preciso de eventos específicos, ventas o registros en fechas determinadas utilizando estructuras lógicas y validaciones de calendario.

## 📋 Descripción del Proyecto

El programa permite administrar una bitácora mensual y anual. A través de una interfaz de consola, el usuario puede registrar datos (como la cantidad de tazas de café vendidas) en días específicos, manejar errores de fecha y generar reportes ordenados.

### Características Principales:
- **Validaciones Robustas:** Control de años (mayores a 0) y meses (rango 1-12).
- **Lógica de Calendario:** Identificación automática de días de la semana (ej. registro automático de todos los viernes).
- **Menú Interactivo:** Sistema basado en `switch` para navegar entre las opciones de registro.
- **Flexibilidad:** Opción para actualizar registros específicos o realizar entradas masivas (quincenas, fines de mes, etc.).

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java
- **Librerías:** - `java.util.Scanner` para la entrada de datos.
  - `java.util.Calendar` para la gestión de fechas y validaciones de tiempo.
  - `java.io` para manejo de flujos.

## 🚀 Funcionalidades del Menú

El sistema incluye las siguientes capacidades de registro:

1. **Registro Quincenal:** Permite registrar datos para los días 1 y 15 de cada mes.
2. **Límites Mensuales:** Registro para el primer y el último día del mes.
3. **Registro por Día de la Semana:** Opción para aplicar un dato a todos los viernes del mes de forma automática.
4. **Actualización Individual:** Posibilidad de modificar el registro de cualquier día específico.
5. **Ordenación:** Presentación de resultados de forma estructurada.

## 📂 Estructura del Código

- `Bitacora.java`: Define la estructura del TDA, atributos y operaciones modificadoras.
- `Coffee.java`: Contiene la lógica principal (`main`), el menú de usuario y las implementaciones de los casos de uso.

## 📝 Ejemplo de Uso

Al ejecutar el programa, se presentará un menú donde podrás elegir el tipo de validación o registro que deseas realizar:

```text
1. Registro del día 1 y 15 del mes
2. Primer y último día del mes
3. Registro de todos los viernes
4. Actualizar registro de un día específico
.............................................................................................................................
Celeste Fuentes - Desarrollo e Implementación 
Universidad Da Vinci de Guatemala - Facultad de Ingeniería en Sistemas Computacionales.
