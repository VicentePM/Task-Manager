# Aplicación de Lista de Tareas con Room en Android

Este proyecto de Android, desarrollado en Kotlin, utiliza la librería Room para crear una lista de tareas por hacer. Cada tarea cuenta con una clave primaria autogenerada, título, descripción, prioridad (número) y fecha y hora.

## Requisitos de la Base de Datos

La base de datos implementa las siguientes funcionalidades:

- **Crear Tarea:**
  - Añade una nueva tarea a la tabla de la base de datos.

- **Obtener Lista de Tareas Ordenadas por Prioridad:**
  - La lista de tareas se presenta ordenada por prioridad.

- **Eliminar una Tarea:**
  - Permite eliminar una tarea específica, ya sea mediante un botón dentro de cada tarea, pulsación larga o arrastrando la celda.

- **Eliminar Todas las Tareas:**
  - Incluye un botón en la pantalla del listado para eliminar todas las tareas de la tabla.

- **Modificar Tarea:**
  - Permite editar una tarea existente, abriendo un nuevo fragment con la información de la tarea a editar. Se proporciona un botón guardar para actualizar la tarea con los nuevos cambios.

## Configuración del Proyecto

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/VicentePM/Task-Manager.git
   ```

2. **Configurar Base de Datos:**
   - Configurar Room en el proyecto.
   - Asegurarse de tener las dependencias necesarias en el archivo `build.gradle`.

3. **Ejecutar la Aplicación:**
   - Abrir el proyecto en Android Studio.
   - Conectar un dispositivo Android o utilizar un emulador.
   - Ejecutar la aplicación.

## Funcionalidades de la Aplicación

Al iniciar la aplicación, se mostrará la lista de tareas ordenadas por prioridad. Desde aquí, se pueden realizar las siguientes acciones:

1. **Crear Tarea:**
   - Abrir una nueva pantalla para crear una tarea.
   - Añadir una nueva tarea a la base de datos.
   - Volver a la pantalla anterior para mostrar el listado actualizado.

2. **Eliminar una Tarea:**
   - Realizar desde cada celda mediante un botón, pulsación larga o arrastre.
   - Eliminar la tarea seleccionada.

3. **Eliminar Todas las Tareas:**
   - Añadir un botón en la pantalla del listado para eliminar todas las tareas de la tabla.

4. **Editar una Tarea:**
   - Ejecutar desde un botón de editar en cada tarea.
   - Abrir un nuevo fragment con la información de la tarea a editar.
   - Guardar para actualizar la tarea con los nuevos cambios.

## Dependencias Principales

- [Room](https://developer.android.com/training/data-storage/room) - Librería de persistencia de Android.

## Contribuciones

¡Contribuciones son bienvenidas! Si encuentras algún problema o tienes sugerencias, por favor, abre un issue o envía un pull request.
