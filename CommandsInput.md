#Commands Input Format

Las acciones permitidas en el sistemas son todas aquellas que permitan los comandos creados en el paquete [ComandosSistema](). Dichos comandos dederivan de una interfaz que establece el método ejecutar(parametro) para ejecutar sus acciones, en el que parámetro es un único string que contendrá el nombre del comando a ejecutar y sus parámetros; que así mismo dependerán de este.
