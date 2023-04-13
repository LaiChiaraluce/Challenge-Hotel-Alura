# <h1 align="center">Hotel Alura</h1>
   Este proyecto consiste en una aplicación que podrá ser utilizada para realizar reservas en un hotel, así como también para introducir modificaciones en las mismas o eliminarlas.
   
   <h4>* Tecnología utilizada: Java y MySql ☕🐬</h4>
   <h4>* Desarrollador: Estanislao Chiaraluce 👨🏽‍💻</h4>
 
   <h2>Hotel Alura 🏨🛎️</h2> 
   <p>La aplicación trabaja en conexión con una base de datos mysql llamada "hotel_alura", la cual cuenta con tres tablas: user, huespedes y reservas. 
   El programa del hotel cuenta con diferentes ventanas, las cuales cumplen distintas funciones:</p>
   <br>
   <h3 align="center">🔶 Menú Principal 🔶</h3>
   <p>Es la primera ventana del programa, la cual nos muestra una primera imagen de la misma a modo de bienvenida, cuenta con un botón para acceder a la sección de login</p>
   <img src="https://user-images.githubusercontent.com/105081652/193459254-a804b682-70a0-4725-996e-90f00394fecd.png" heigth=500px width=800px>>
   <br>
 <p>
    <h3 align="center">🔶 Login 🔶</h3>
    Aquí el usuario tendrá la posiblidad de loguearse en la aplicación, para lo cual deberá ingresar su usuario y su contraseña. Para tal validación se hace uso de la tabla user, la cual cuenta con tres cuentas ficticias para el ingreso al hotel.</p>
    <img src="https://user-images.githubusercontent.com/105081652/193459265-4762d15c-fbd3-4675-a885-5510d385661b.png" heigth=500px width=800px>>
    <img src ="https://user-images.githubusercontent.com/105081652/193460090-1b73a19f-f504-45c3-92ac-ab89c7c69bce.png" heigth=500px width=800px>>
    <br>
<p>
    <h3 align="center">🔶 Menú Usuario 🔶</h3>
    En esta sección encontramos un pequeño mensaje referido a las funcionalidades del programa; a su vez la persona que esté utilizando la aplicación podrá elegir entre cargar una nueva reserva con su correspondiente huesped (en la sección registro de reservas) o revisar las reservas ya cargadas en el programa (en la sección búsqueda).</p>
    <img src="https://user-images.githubusercontent.com/105081652/193459298-7daf1556-1e1e-49db-8f78-946aeb2f2cca.png" heigth=500px width=800px>>
    <br>
 <p>
    <h3 align="center">🔶 Reservas View 🔶</h3>
    Aquí el usuario deberá cargar los datos referidos a la reserva, es decir, fecha de check-in, fecha de check-out y forma de pago (dinero en efectivo, tarjeta de débito o crédito); lo interesante en este punto es que el valor de la reserva se calcula de forma automática en base a la cantidad de días que dure la reserva. En este caso y para fines prácticos, se asignó un precio de $1000 pesos por día para calcular dicho importe. Por cada reserva se genera automática un id.</p>
    <img src="https://user-images.githubusercontent.com/105081652/193459364-081f40c1-5210-42a8-b892-ea16970c3066.png" heigth=500px width=800px>>
    <br>
<p>
    <h3 align="center">🔶 Registro Huesped 🔶</h3>
    Solo una vez que hayamos cargado completa y correctamente todos los datos de la reserva, pasamos a la sección siguiente, donde deberemos cargar los datos del huésped. A dicho huésped se le asignará de forma automática el id de la reserva correspondiente. De esta forma, la tabla huesped y reservas se encuentran relacionadas entre sí por medio de una foreign-key.</p>
    <img src="https://user-images.githubusercontent.com/105081652/193459440-1e4d91e9-a37d-4799-9338-b256133b21f6.png" heigth=500px width=800px>>
    <br>
   <p> 
    <h3 align="center">🔶 Búsqueda 🔶</h3>
    Aquí el usuario será capaz de ver las reservas ya almacenadas en la base de datos así como también los datos de los huéspedes relacionados a dichas reservas; por ello se cuenta con dos secciones diferenciadas (una para reservas y otra para huéspedes) a las cuales se accede por medio de una botonera ubicada en la parte superior. En este menú se podrán realizar las siguientes acciones:</p>
    <p>
     ✅ Filtrar búsquedas: buscar reservas por id de reserva o buscar huéspedes por el apellido. Para volver a ver la tabla completa con todos los datos almacenados, el usuario contará con el botón "mostrar todo", para limpiar los filtros antes usados.</p>
     <p>✅ Editar datos: tanto de los huéspedes como de las reservas, con la salvedad de que en el caso de las reservas no se podrá editar el id de las mismas ni tampoco el monto (este se modifica automáticamente en función de los cambios de fecha que introduzca el usuario, manteniendo un precio de $1000 pesos por día), mientras que en el caso de los huéspedes no se podrá modificar el id ni tampoco el id de reserva que corresponda a cada uno.</p>
     <p>✅ Eliminar datos: se podrá eliminar tanto reservas como huéspedes, con la particularidad de que si se elimina un huésped, se eliminará al mismo tiempo la reserva que corresponde al mismo y viceversa.</p>
     <img src="https://user-images.githubusercontent.com/105081652/193459491-3aa0886d-78c1-4c70-9cf0-5a595905dbe9.png" heigth=500px width=800px>>
     <img src="https://user-images.githubusercontent.com/105081652/193459560-8762b9cf-1a36-470a-a8b7-6ab9900c3739.png" heigth=500px width=800px>>

     

    


