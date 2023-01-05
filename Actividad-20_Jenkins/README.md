# Actividad 20. Configuración de Jenkins <!-- omit in toc -->

- [Instalación y configuración de Jenkins](#instalación-y-configuración-de-jenkins)
  - [Instalación a partir de una imagen Docker](#instalación-a-partir-de-una-imagen-docker)
  - [Configuración inicial](#configuración-inicial)
- [El «Hola, mundo» de Jenkins](#el-hola-mundo-de-jenkins)
- [Arquitectura de Jenkins](#arquitectura-de-jenkins)


## Instalación y configuración de Jenkins

> En esta parte nos aseguraremos de que Jenkins sea tan fácil de usar como se muestra en el siguiente gif:

![](imgs_n_gifs/jenkins_easy_access.gif)

### Instalación a partir de una imagen Docker

Primero instalamos la imagen de Jenkins en un directorio especialmente creado para este propósito:

![](imgs_n_gifs/2023-01-04-23-19-05.png)

Pedimos logs para verificar que se instaló correctamente:

![](imgs_n_gifs/2023-01-04-23-24-06.png)

### Configuración inicial

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

![](imgs_n_gifs/2023-01-05-11-06-32.png)

![](imgs_n_gifs/2023-01-05-11-13-03.png)

![](imgs_n_gifs/2023-01-05-11-14-07.png)

## Arquitectura de Jenkins

Jenkins se sobrecarga rápido, así que a menos que que tu proyecto sea pequeños, no debe ejecutar ningún construcción de código fuente (como maestro), sino delegarlas a instancias del agente (esclavo).

