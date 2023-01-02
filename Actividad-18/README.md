# Actividad 18 <!-- omit in toc -->

- [Instalación de Docker y su «hola mundo»](#instalación-de-docker-y-su-hola-mundo)
- [Ejecutando la aplicación Docker de MongoDB](#ejecutando-la-aplicación-docker-de-mongodb)



## Instalación de Docker y su «hola mundo»

> Instalar Docker significa instalar todos los componentes para que el demonio Docker se ejecute en un equipo todo el tiempo como un servicio.

Para installar Docker en mi VM de Ubuntu seguí la secuencia de pasos expuesta en [la documentación oficial de Docker](https://docs.docker.com/engine/install/ubuntu/#set-up-the-repository).

Una forma de verificar que la instalación de Docker ha sido exitosa es mediante el «hola mundo» de Docker. Véase el siguiente gif:

![](imgs_n_gifs/DockerInstalled.gif)

Como se puede apreciar en el gif, incluso un comando tan simple de Docker como su _hola mundo_ necesita anteponer la palabra clave _sudo_. De lo contrario se niega el permiso.

```
sudo docker run hello-world
```

Esto es así porque está configurado por defecto para que el único usuario que pueda usar estos comandos de Docker sea el root. Le damos el permiso a otro usuario con el siguiente comando:

```
sudo usermod -aG docker <username>
```

Para que tenga efecto se debe cerrar la sesión.

Otra forma de verificar que Docker se ha instalado exitosamente con el comando para pidiéndole información:

```
docker info
``` 

![](imgs_n_gifs/2023-01-01-22-06-27.png)

En mi caso figuran 3 contenedores porque ejecuté el _hola mundo_ tres veces.

## Ejecutando la aplicación Docker de MongoDB

> Una **imagen** es un bloque de construcción sin estado (stateless) en el mundo de Docker. Un **contenedor** es una instancia en ejecución de una imagen. Una **aplicación** se proporciona en forma de imagen que se puede descargar de Internet (al igual que el _hola mundo_) y se  ejecuta con Docker como un contenedor.

¿Cómo buscamos la aplicación Docker de MongoDB? Con el siguiente comando:

```
docker search mongo
```
![](imgs_n_gifs/2023-01-01-23-43-23.png)

A continuación, ejecutamos la primera aplicación que figura en la lista porque es oficial, tal como se puede ver en la penúltima columna. La operación es la misma que la del _hola mundo_:

```
docker run mongo
```

![](imgs_n_gifs/2023-01-01-23-49-31.png)

Eso es todo. La aplicación de MongoDB ya se ha ejecutado como un contendor Docker.