# ADOO
Design Patterns project

Trabajo Práctico: Puppies 
Materia: Análisis y Diseño Orientado a Objetos

Consignas
• Primera entrega
o Realizar una iteración inicial del diagrama de clases del sistema, incluye la capa de dominio y 
controladores asociados.
• Entrega final
o Diagrama de clases del sistema completo (capa de dominio), aplicando patrones de diseño 
que crea pertinentes.
o Justificar utilización de patrones de diseño en el caso que se hayan utilizado.
o Implementar el diagrama de clases propuesto en Java, mostrando el correcto funcionamiento 
de los requerimientos principales a través de Tests.


Contexto general

Gud Boy es una cadena de refugio animal muy reconocida en todo el país. En esta ocasión nos han contratado 
para desarrollar un sistema para el seguimiento y control de los animales que ingresan al refugio; como así 
también el manejo de las adopciones y las visitas programadas con los nuevos dueños de las mascotas.
Cuando un animalito nuevo ingresa al refugio, se toman una serie de datos para conformar su ficha técnica:
- Tipo de animal: hay ciertos tipos de animales que son salvados por el refugio, pero que, por su 
naturaleza, no pueden ser adoptados. El refugio no solo salva mascotas, sino que también ayuda a la 
recuperación de animales salvajes
o Doméstico: perro, gato, canario, loro, tortuga, etc.
o Salvaje: zorro, pingüino, halcón, etc.
- Altura
- Peso
- Edad aproximada
- Condición médica: si el animal necesita atención médica o se encuentra en buen estado de salud.
En todo momento, la ficha médica podrá ser exportada a distintos formatos. Nuestro diseño deberá permitir 
la escalabilidad en la exportación de una manera sencilla y ágil. En principio, se permitirá exportar la ficha 
médica a PDF y Excel.
El sistema dispondrá de dos tipos de usuarios: veterinarios y visitadores. El manejo de los usuarios y sus datos 
estará a cargo del equipo de seguridad; con lo cual nosotros no tendremos que ocuparnos del login y registro 
de usuarios, pero si deberemos guardar una referencia a los mismos; razón por la cual deberemos interactuar 
con el módulo de autenticación. 
Una vez ingresado al sistema; se establecerán alarmas programadas por los veterinarios para el control 
periódico del animal como para el seguimiento de su tratamiento médico en caso de corresponder. El sistema 
deberá permitir la creación y actualización de alarmas configurables para cada animal en particular. Para cada 
alarma se debe configurar su periodicidad y el grupo de acciones que se deben ejecutar, las cuales pueden 
ser:
- Control de parásitos.
- Colocar antiparasitarios.
- Comprobar peso y tamaño.
- Chequear nutrición
- Colocar vacuna.
Las alarmas disparadas generarán una alerta para todos los veterinarios, siendo que cualquiera de ellos puede 
atender la misma. Cuando se atiende una alarma, se deberá marcar las acciones como completadas, indicando 
un registro de lo que se realizó a modo de comentario. En caso de tratarse de un tratamiento médico, deberá 
indicar si el mismo finalizó o no. Debemos llevar un historial del tratamiento médico y controles realizados 
para cada animal, como así también el registro del veterinario que lo atendió. Todo esto debe quedar 
organizado dentro de la ficha médica del animal atendido.
Asimismo, nuestro sistema permitirá hacer el seguimiento de las adopciones de los animales domésticos. 
Cuando un cliente interesado en adoptar un animal llega al refugio, se le toman sus datos, como así también 
los motivos de la adopción. Se pedirá:
- Nombre y apellido
- Estado civil
- Email
- Teléfono
- Ocupación: empleado, estudiante, otros.
- ¿Otras mascotas? Esto es necesario para saber si el animal a adoptar se llevará bien con otras 
mascotas.
- Motivo de adopción
- Tipo de animales interesados
Se debe tener presente que los animales que se encuentran bajo un tratamiento médico no pueden ser 
adoptados hasta que no finalice el mismo. Lo mismo ocurre con los animales salvajes, los cuales no pueden 
ser adoptados.
Cada cliente podrá adoptar un máximo de 2 animales domésticos. Luego de que se completen los papeles de 
la adopción, se procederá a cargar los datos del seguimiento del animal. Aquí se deberá indicar:
- Responsable del seguimiento: visitador asociado.
- Cadencia de las visitas: a convenir con el cliente, día y rango horario de visita.
- Preferencia de recordatorio: SMS, WhatsApp o email.
El sistema enviará recordatorios a las partes interesadas de acuerdo a las preferencias elegidas ‘N’ días antes 
de la misma; siendo ‘N’ un valor configurable y ajustable por parámetro.
Luego de finalizada la visita, el visitador procederá a responder una breve encuesta sobre el animal en nuestra 
app; y además deberá indicar si se debe continuar con las visitas o ya no es necesario.
A considerar:
• Debemos mantener un historial linkeado a la historia clínica del animal. Esto aplica para la evolución 
médica, chequeos de rutina o visitas a domicilio.
• La breve encuenta que deben contestar los visitadores incluye responder las siguientes preguntas:
o Estado general del animal: malo, regular, bueno
o Limpieza del lugar: malo, regular, bueno
o Ambiente: malo, regular, bueno
• Las alarmas envían una push notification a los veterinarios




