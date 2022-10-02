# <h1 align="center">Hotel Alura</h1>
   Este proyecto consiste en una aplicación que podrá ser utilizada para realizar reservas en un hotel, así como también para introducir modificaciones en las mismas o eliminarlas.
   
   <h4>* Tecnología utilizada: Java y MySql ☕🐬</h4>
   <h4>* Desarrollador: Estanislao Chiaraluce 👨🏽‍💻</h4>
 
   <h2>Hotel Alura 🏨🛎️</h2> 
   La aplicación trabaja en conexión con una base de datos mysql llamada "hotel_alura", la cual cuenta con tres tablas: user, huespedes y reservas. 
   El programa del hotel cuenta con diferentes ventanas, las cuales cumplen distintas funciones:
   
   <h3>🔶 Menú Principal 🔶</h3>
   Es la primera ventana del programa, la cual nos muestra una primera imagen de la misma a modo de bienvenida, cuenta con un botón para acceder a la sección de login
   ![image](https://user-images.githubusercontent.com/105081652/193457286-2babc5ab-7a75-41be-ae41-ec7df5671051.png)

    <h3>🔶 Login 🔶</h3>
    Aquí el usuario tendrá la posiblidad de loguearse en la aplicación, para lo cual deberá ingresar su usuario y su contraseña. Para tal validación se hace uso de la tabla user, la cual cuenta con tres cuentas ficticias para el ingreso al hotel:
   
   ![image](https://user-images.githubusercontent.com/105081652/193456937-f2a4bce2-271b-4ef4-bcf2-28f7286ee4ff.png)
   
   ![image](https://user-images.githubusercontent.com/105081652/193457326-cd3488ed-907b-4e66-bf2e-e7afb8ff3f54.png)

    <h3>🔶 Menú Usuario 🔶</h3>
    En esta sección encontramos un pequeño mensaje referido a las funcionalidades del programa; a su vez la persona que esté utilizando la aplicación podrá elegir entre cargar una nueva reserva con su correspondiente huesped (en la sección registro de reservas) o revisar las reservas ya cargadas en el programa (en la sección búsqueda)
    
    ![image](https://user-images.githubusercontent.com/105081652/193457477-62555c94-2cc0-492a-b9fc-788e84f0899c.png)
    
    <h3>🔶 Reservas View 🔶</h3>
    Aquí el usuario deberá cargar los datos referidos a la reserva misma, es decir, fecha de check-in, fecha de check-out y forma de pago (dinero en efectivo, tarjeta de débito o crédito); lo interesante en este punto es que el valor de la reserva se calcula de forma automática en base a la cantidad de días que dure la reserva. En este caso y para fines prácticos, se asignó un precio de $1000 pesos por día para calcular dicho importe. Por cada reserva se genera automática un id que identifica a cada una.
    
    ![image](https://user-images.githubusercontent.com/105081652/193457609-806522d7-034e-405b-b123-4bcaee0d6141.png)
    
    <h3>🔶 Registro Huesped 🔶</h3>
    Solo una vez que hayamos cargado completa y correctamente todos los datos de la reserva, pasamos a la sección siguiente, donde deberemos cargar los datos del huésped. A dicho huésped se le asignará de forma automática el id de la reserva correspondiente. De esta forma, la tabla huesped y reservas se encuentran relacionadas entre sí por medio de una foreign-key.
    
    ![image](https://user-images.githubusercontent.com/105081652/193457890-e6ba3bbf-0e10-4804-a290-5032fe28148d.png)
    
    <h3>🔶 Búsqueda 🔶</h3>
    Aquí el usuario será capaz de ver las reservas ya almacenadas en la base de datos así como también los datos de los huéspedes relacionados a dichas reservas; por ello se cuenta con dos secciones diferenciadas (una para reservas y otra para huéspedes) a las cuales se accede por medio de una botonera ubicada en la parte superior. En este menú se podrá realizar las siguientes acciones:
    
     ✅ Filtrar búsquedas: buscar reservas por id de reserva o buscar huéspedes por el apellido. Para volver a ver la tabla completa con todos los datos almacenados, el usuario contará con el botón "mostrar todo", para limpiar los filtros antes usados.
     ✅ Editar datos: tanto de los huéspedes como de las reservas, con la salvedad de que en el caso de las reservas no se podrá editar el id de las mismas ni tampoco el monto (este se modifica automáticamente en función de los cambios de fecha que introduzca el usuario, manteniendo un precio de $1000 pesos por día), mientras que en el caso de los huéspedes no se podrá modificar el id ni tampoco el id de reserva que corresponda a cada uno
     ✅ Eliminar datos: se podrá eliminar tanto reservas como huéspedes, con la particularidad de que si se elimina un huésped, se eliminará al mismo tiempo la reserva que corresponde al mismo y viceversa.
     
    ![image](https://user-images.githubusercontent.com/105081652/193458268-b4c9c86a-579e-4d67-929f-5f78ae1ee20b.png)
    
    ![image](https://user-images.githubusercontent.com/105081652/193458314-999c7dd5-0ccd-41b8-99d6-7255ade6bfda.png)

    


