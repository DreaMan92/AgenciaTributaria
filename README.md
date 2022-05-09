<center>
<h1> Documentación - Agencia Tributaria 
</center>
<center>
<h2> Gonzalo Alvarez
</center>
<br>
<br>

# Introducción
> A continuacion paso a explicar mi programa de implementación de colas y etidades graficas. Lo que en un principio parecia sencillo, se vio complicado por la ultilización de la libreria Swing y Awt. Ha sido un reto que me ha gustado resover. Añadir que durante el proceso de planificación del trabajo, me vi inspirado tras curiosear por internet, lo que me llevo a soñar un trabajo mas compicado de lo que nos planteabas, aun asi sin llegar a satisfacer todos mis sueños, puedo decir, que me he quedado agusto con mi desempeño. A continuación paso a explicar el programa.

<br>

# Desarrollo del programa
> En primer lugar me tocó responder a problemas de organización y estructura de codigo.  
Como resultado he obtenido:

<br>

<center>
1-Clases del Programa

<br>

![](Imagenes/Clases.png) 
<br>

</center>
<br>

> Voy a explicar brevemente mis paquetes y clases:
    > + Animación: engloba las clases para dibujar en pantalla objetos que simulan las ventanillas y los contriuyentes.
    > + Datos: recoge la clases que almacenan la iformación asi como la lectura y escritura de ficheros. 
    > + Entidades: recoge mis objetos asi como una enumeración para limitar la prioridad.
    > + GestorSys: es el cerebro del programa, la clase gestor recoge la mayoria de metodos que actuan en mi programa. Tambien decidí guardar aqui mi objeto de cola y su interfaz.
    > + Interfaz de usuario: engloba todo el código que refiere a la parte gráfica del programa. 

<br>
<br>
<br>
<br>


# Desarrollo de la ejecución
<center>

## Primeras Ventanas
</center>

---
<br>

>Una vez que se ejecuta el programa obtenemos la siguiente pantalla.

<br>
<center>
2-Ventana primer gestor

<br>

![](Imagenes/Gestor1.png) 
<br>

</center>
<br>

>Esta pantalla solo nos da dos opciones Iniciar o Finalizar. He decidido implementar dos constructores para la misma clase, lo que provoca tener dos pantallas diferentes. Una vez damos a iniciar se abren las siguientes pantallas:

<br>

<center>
3-Ventana segundo gestor

<br>

![](Imagenes/Gestor2.png) 
<br>

</center>
<br>

> En primer lugar hablare de mis gestor, esta pantalla se mantiene abierta a lo largo de la ejecución del programa. Ofrece ciertas ocpiones demandadas en el enunciado, y dos que he querido poner yo. Mas adelante entraré a profundizar sobre todas.

<br>

<center>
4-Ventana de puesto de información

<br>

![](Imagenes/PuestoDeInformacion.png) 
<br>

</center>
<br>

> Esta ventana tambien se mantiene abierta durante toda la ejecución del programa, con ella podemos registrarnos para asi poder ser atendidos. Si pulsamos aceptar nos introducira en la cola. Además si pulsamos reservar nos abrira otra pantalla que explicaré mas adelante.

<br>
<

<center>
5-Ventana de sala de espera/animación

<br>

![](Imagenes/AnimacionVentanillas.png) 
<br>

</center>
<br>

> Finalmente esta ventana tambien se mantiene abierta durante toda la ejecución del programa. En ella represento una animación de la sala de espera y el estado de las ventanillas. He agregado unos botones para liberar las ventanillas y asi poder controlar el flujo.

<br>
<center>

## Reservas
---

</center>
<br>

> Si desde la ventana de puesto de información pulsamos en el boton reservar, se nos abre esta nueva ventana. A continuación la rellenamos con nuestros datos y si pulsamos reservar se añadira al repositorio de reservas, para luego ser leido y escrito en un fichero que se abre cuando pulsamos desde el segundo gestor.

<br>

<center>
6-Ventana para hacer un reserva

<br>

![](Imagenes/Reserva1.png) 
<br>

</center>
<br>
<center>
7-Tras pulsar reservar nos sale un mensaje de confirmación y nuestra reserva ya estará en el sistema

<br>

![](Imagenes/Reserva2.png)
<br>
 
</center>

<br>

<center>
8-Fichero de reservas generadas hasta ahora

<br>

![](Imagenes/InformeReservas.png) 
<br>

</center>
<br>

>Para mantener un persistencia de datos en mi programa he recurrido a los ficheros CSV. Mi programa guarda la información en el fichero CSV y es este, al que mantiene actualizado. Cuando pulsamos en ver reservas generadas, el programa lee este fichero CSV y lo escribe con los datos actualizados en un txt que abre y muestra al usuario.

<br>

<center>

## Puesto de información
---

</center>
<br>

>Cuando se registra un nuevo contribuyente, primero rellena todos sus datos luego pulsaría aceptar.

<br>


<center>
9-Ventana de puesto de información - rellenando datos

<br>

![](Imagenes/ejecucionPuestoInfo1.png) 
<br>

</center>
<br>

>Tras pulsar aceptar saldrá un mensaje y se dibujará un ciculo en la Sala de espera. Este circulo simboliza a la persona que esta esperando. En función de su prioridad la pelota será coloreada de un color.
 + AZUL: prioridad UNO.
 + NARANJA: prioridad DOS.
 + CYAN: prioridad TRES.

 <br>

<center>
10-Ventana de puesto de información - confirmación para pasar a la sala de espera

<br>

![](Imagenes/ejecucionPuestoInfo2png.png) 
<br>

</center>
<br>

>Cuando pulsamos aceptar si hay alguna ventanilla libre, automaticamente nos atiende. La animación muestra como desaparece una bola de la sala de espera, para aparecer debajo del cuadrado verde que es la ventanilla. Eso si, ahora la ventanilla es roja, por que esta ocupada. Además la etiqueta de la ventanilla uno figura como ocupado.

<br>

<center>
11-Ventana de puesto de informacion - Tooltip del boton liberar ventanilla uno

<br>

![](Imagenes/ejecucionPuestoInfo3.png) 
<br>

</center>
<br>

>Si decidimos usar la opción de introducir 10 personas a la cola, automaticamente apareceran 10 circulos en la sala de espera, estos referencian a las mismas, en función de la prioridad de estas habrá mas circulos de un color o de otro. Además nos sale un mensaje informativo de lo que acaba de ocurrir.  
>Si pulsamos aceptar, si hay ventanillas libres, automaticamente estas se veran ocupadas por los contribuyentes de mayor prioridad, como se ve en la iamgen 13.

<br>


<center>
12-Ventana de puesto de información - Insertadas 10 personas

<br>

![](Imagenes/ejecucionPuestoInfo4.png) 
<br>

</center>
<br>


<center>
13-Ventana de puesto de información - atendiendo prioridad UNO

<br>

![](Imagenes/ejecucionPuestoInfo5.png) 
<br>

</center>
<br>

>Como se ve en la imagen anterior, se atiende primero a las personas de prioridad UNO representadas con el color AZUL.  
>En la imagen de abajo numero 14, se puede ver que al pulsar liberar ventanilla, nos sale un mensaje de siguiente. Además las etiquetas de Ventanilla cambian a libre y a siguiente.

<br>

<center>
14-Ventana de puesto de información - liberando ventanilla

<br>

![](Imagenes/ejecucionPuestoInfo6png.png) 
<br>

</center>
<br>

>Para terminar añadir que hay otra funcion en el gestor principal que nos libera las tres ventanillas de golpe. Esta opcion esta capada cuando las ventanillas ya estan libres, o cuando no se pueden liberar tres de golpe, saltando un mensaje como el que se ve en la imagen numeo 15.

<br>

<center>
15-Ventana de puesto de información - mensaje de información

<br>

![](Imagenes/ejecucionPuestoInfo7.png) 
<br>

</center>
<br>

>Acontinuación, ya para terminar, muestro una prueba del fichero que se genera cuando marcamos la opción en el menú principal de ver atendidos por ventanilla. Esta opción genera un fichero como se ve en la imagen numero 16.

<br>

<center>
16-Fichero generado de atendidos por ventanilla

<br>

![](Imagenes/informaVentnaillas.png) 
<br>

</center>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


# Conclusiones
<br>

>Este es el reultado del trabajo que he realizado. La verdad que como he dicho al inicio del documento, me siento realizado y veo mi progreso, uno que al principio de curso no podría haber imaginado.  
>He disfrutado mucho resolviendo los problemas que me surgían y ahora puedo decir que empiezo a enterarme un poco de que va este mundo de la programación, que sinceramente, me está fascinado.  
>Espero cumplir las espectativas y me encantaría recibir un feedback de mi trabajo, sobre todo de lo que encuentres inapropiado o redundante.  


> Gracias, Gonzalo ALvarez.
