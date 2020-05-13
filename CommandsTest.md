# Commands Unit Test

Este sistema cuenta con la implementación de **Test Unitarios** para los métodos *ejecutar* de todos los comandos. Tener en consideración que si se realizan modificaciones sobre estos métodos los test pueden verse afectados.  
  
A continuación se detallan todos los test disponibles en el sistema:

## Test de Usuario

### Login
- Realizar el test correctamente (**testLogin_Correcto()**).
- Introduciendo mal las credenciales (**testLogin_MalasCredenciales()**) para hacer la prueba se introducirá una contraseña incorrecta.
- Realizar login estando ya logueado (**testLogin_EstandoLogeado()**).

### Logout
- Realizar el test correctamente (**testLogout_Correcto()**).
- Realizar logout habiendo hecho ya previamente logout (**testLogout_EstandoLogout()**).

### Nuevo Usuario
- Realizar el test correctamente (**testNuevoUsuario_Correcto()**).
- Crear un usuario que ya exista, es decir, con los mimos datos, (**testNuevoUsuario_UsuarioRepetido()**).
- Crear un usuario con un correo no perteneciente a la URJC, por ejemplo correo@google.com, (**testNuevoUsuario_CorreoMal()**).

## Test de SubForo

### NuevoSubForo
- Realizar el test correctamente (**testNuevoSubForo_Correcto()**).
- Intentar crear nuevo un subforo sin un usuario logueado (**testNuevoSubForo_SinUsuarioLogeado()**).
- Intentar crear un  nuevo subforo que ya existe en el foro (**testNuevoSubForo_Repetido()**).

## Test de Entrada

### NuevaEntrada
- Realizar el test correctamente (**testNuevaEntrada_Correctamente()**).
- Crear una entrada sin un usuario logeado (**testNuevaEntrada_SinUsuario()**).
- Crear una nueva entrada con el tipo de entrada mal introducido, por ejemplo “texto”, (**testNuevaEntrada_TipoEntradaIncorrecto()**).
- Crear una nueva entrada con el tipo Ejercicio sin ser un usuario profesor, por ejemplo: siendo alumno, (**testNuevaEntrada_EjercicioSiendoAlumno()**).

### ValidarEntrada
- Realizar el test correctamente (**testValidarEntrada_Correcto()**).
- Intentar validar entradas sin un usuario administrador creado en el sistema (**testValidarEntrada_SinAdmin()**).
- Intentar ejecutar el validar entradas sin tener ninguna entrada creada (**testValidarEntrada_SinEntradas()**).

## Test de Comentarios

### ComentarEntrada
- Realizar el test correctamente (**testComentarEntrada_Correcto()**).
- Intentar realizar un comentario sin un usuario logueado (**testComentarEntrada_SinUsuarioLogeado()**).
- Comentar una entrada que no ha sido validada aún por un usuario administrador (**testComentarEntrada_SinValidar()**).

### ComentarComentario
- Realizar el test correctamente (**testComentarComentario_Correcto()**).
- Realizar un comentario que incluya alguna palabra no permitida o insultos, por lo que se penalizará al usuario y el la palabra será sustituida por asteriscos (**testComentarComentario_Penalizacion()**).
- Intentar realizar un comentario que no se encuentra, el motivo es haber introducido un número de comentario que no existe en la lista de comentarios (**testComentarComentario_NoEncuentraComentario()**).

## Test de Subscripciones

### NuevaSubscripcion
- Realizar el test correctamente (**testNuevaSubscripcion_Correcto()**).
- Intentar realizar una subscripción sin un usuario logueado (**testNuevaSubscripcion_SinUsuarioLogeado()**).
- Intentar realizar una subscripción en la que el usuario ya está subscrito (**testNuevaSubscripcion_Repetido()**) 
- Intentar realizar una subscripción sin que el subforo exista (**testNuevaSubscripcion_SubforoNoExiste()**)

### EliminarSubscripcion
- Realizar el test correctamente (**testEliminarSubscripcion_Correcto()**).
- Intentar eliminar una subscripción sin un usuario logueado (**testEliminarSubscripcion_SinUsuarioLogeado()**).
- Intentar eliminar una subscripción en la que el usuario ya está subscrito (**testEliminarSubscripcion_Repetido()**).
- Intentar eliminar una subscripción sin que el subforo exista (**testEliminarSubscripcion_SubforoNoExiste()**).

## Test de Votaciones

### VotarEntrada
- Realizar el test correctamente (**testVotarEntrada_Correcto()**).
- Intentar realizar una votación a una entrada no existente o que el número se excede en el tamaño del numero de entradas existentes (**testVotarEntrada_NoEncuentraEntrada()**).
- Intentar realizar una votación en una entrada pero introduciendo mal el tipo de voto, es decir, ni “like” ni “dislike”, (**testVotarEntrada_NiLikeNiDislike()**).

### VotarComentario
- Realizar el test correctamente (**testVotarComentario_Correcto()**).
- Intentar realizar una votación a un comentario que no existe o que el número se excede en el tamaño del número de comentarios existentes (**testVotarComentario_NoEncuentraComentario()**).
- Intentar realizar una votación en un comentario pero introduciendo mal el tipo de voto, es decir, ni “like” ni “dislike”, (**testVotarComentario_NiLikeNiDislike()**).
