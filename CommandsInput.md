# Commands Input Format

Las acciones permitidas en el sistemas son todas aquellas que permitan los comandos creados en el paquete *[ComandosSistema](Reddit-MPURJC/src/reddit/mpurjc/ComandosSistema)*. Dichos comandos dederivan de una interfaz que establece el método **ejecutar(parametro)** para ejecutar sus acciones, en el que parámetro es un único string que contendrá el nombre del comando a ejecutar y sus parámetros; que así mismo dependerán de este.

## Nuevo Usuario

La estructura que se debe seguir para crear un nuevo usuario es la siguiente: **NuevoUsuario(parametro)** en el que parámetro es un string con los siguientes datos: *NombreUsuario,ApellidosUsuario,emailUsuario,contraseñaUsuario*.  
  
## Nuevo SubForo

La estructura para crear un nuevo SubForo es: **NuevoSubForo(parametro)** en el que parámetro es un string con el nombre del subforo.  
  
## Nueva Entrada

Para crear una nueva entrada se debe seguir la siguiente estructura: **NuevaEntrada(parametro)** en la que parámetro es un string con los siguientes datos: *NombreSubForo,NombreEntrada,TipoEntrada,parametrosEntrada*. El tipo de entrada debe elegirse entre los distintos diponibles: TextoPlano, Encuesta o Ejercicio; y los parámetros de la entrada son un string que depende del tipo de entrada deseado:  
- Texto plano: parámetros solo contiene el contenido del texto plano.
- Encuesta: parámetros contiene el enunciado de la encuesta y todas sus opciones separadas por comas según la siguiente estructura: *enunciadoEncuesta,opcion1,opcion2,…,opcionN*
- Ejercicio: parámetros tiene el enunciado del ejercicio y un sub enunciado separados por comas de la siguiente forma: *enunciado,subEnunciado*  
Si se desea crear una entrada mezclando varios tipos de entradas, debe realizarse de la siguiente forma: *parametrosTipoUno|parametrosTipoDos…* en el que cada parámetro será la estructura indicada anteriormente para cada tipo de entrada.  
  
## Nuevo Comentario

Para poder realizar un nuevo comentario en una entrada se debe seguir la siguiente estructura: **ComentarEntrada(parametro)** donde parámetro es un string con la siguiente estructura: *nombreSubForo.numeroEntrada-textoComentario*.  
De forma similar, para realizar un comentario a otro comentario ya existente la estructura es la siguiente: **ComentarComentario(parametro)** en el que parámetro es un string con la siguiente estructura: *nombreSubForo.numeroEntrada.numeroComentarioNivel1.numeroComentarioNivel2. ... .numeroComentarioNivelN-textoComentario*.  
  
## Votaciones

Para realizar una votación en una entrada la estructura es: **VotarEntrada(parametro)** en el que parámetro es un string con la siguiente *estructura: nombreSubForo.numeroEntrada-votacion*.  
De forma similar, para votar un comentario ya existente: **VotarComentario(parametro)** en el que parámetro es un string con la siguiente estructura: *nombreSubForo.numeroEntrada.numeroComentarioNivel1.numeroComentarioNivel2.….numeroComentarioNivelN-votacion*.  
En ambos dos últimos comandos, votación puede ser “like” o “dislike”.  
  
## Subscripciones

Si un usuario con sesión iniciada desea realizar una subscripción a un SubForo debe seguir la siguiente estructura: **NuevaSubscripcion(parametro)** en el que parámetro es un string que contiene el nombre del SubForo al que se desea subscribirse.  
De igual forma, para eliminar una subscripción a un SubForo previamente subscrito: **EliminarSubscripcion(parametro)**.  
  
## Sesión de usuario

Para poder realizar inicio de sesión se usa: **Login(parametro)** en el que parámetro es un string con la siguiente estructura: *nombreUsuario contraseñaUsuario*.  
Para poder cerrar sesión se utiliza: **Logout()**.  
  
## Persistencia de datos

Por último, los comandos destinados a la persistencia de datos del sistema son: **Salvar(parametro)** en el que parámetro es un string con la siguiente forma: *ruta,nombreArchivo* y **Cargar(parametro)* donde parámetro es la ruta del archivo con su extensión correspondiente.  
  
## Anotaciones

Destacar que las validaciones de las entradas, delegadas en un usuario administrador, se realizan simulando que existe una tercera persona con dicho usuario, en el demostrador implementado.  
Además, para mostrar el foro por la línea de comandos se utiliza el comando **MostrarForo**.
