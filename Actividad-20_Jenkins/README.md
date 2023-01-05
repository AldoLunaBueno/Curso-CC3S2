# Actividad 20. Configuración de Jenkins

## Instalación a partir de una imagen Docker

> En esta parte nos aseguraremos de que Jenkins sea tan fácil de usar como se muestra en el siguiente gif:

![](imgs_n_gifs/jenkins_easy_access.gif)

Primero instalamos la imagen de Jenkins en un directorio especialmente creado para este propósito:

![](imgs_n_gifs/2023-01-04-23-19-05.png)

Pedimos logs para verificar que se instaló correctamente:

![](imgs_n_gifs/2023-01-04-23-24-06.png)

## Configuración inicial

Entramos a la dirección <http://localhost:8080>. Nos pide una contraseña de administrador. Copiamos y pegamos la que salió en los logs:

![](imgs_n_gifs/2023-01-04-23-31-16.png)

Instalamos los plugins sugeridos de Jenkins:

![](imgs_n_gifs/2023-01-04-23-32-16.png)

![](imgs_n_gifs/2023-01-04-23-33-31.png)

Configuramos la cuenta con la que se accederá a Jenkins:

![](imgs_n_gifs/2023-01-04-23-53-53.png)

Muestra la URL de Jenkins:

![](imgs_n_gifs/2023-01-04-23-55-18.png)

Se muestra el Dashboard de Jenkins, con lo cual ya podemos usar la herramienta:

![](imgs_n_gifs/2023-01-04-23-56-31.png)

## El «Hola, mundo» de Jenkins

