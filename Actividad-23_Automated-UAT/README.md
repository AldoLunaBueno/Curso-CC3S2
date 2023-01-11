# Actividad 23. Pruebas de aceptación automatizadas (UAT)

Creamos una cuenta de Docker Hub:

![](imgs_n_gifs/2023-01-06-05-57-57.png)


## Docker Registry

```
docker run -d -p 443:443 --restart=always --name registry -v `pwd`/certs:/certs -e REGISTRY_HTTP_ADDR=0.0.0.0:443 -e REGISTRY_HTTP_TLS_CERTIFICATE=/certs/domain.crt -e REGISTRY_HTTP_TLS_KEY=/certs/domain.key registry:2
```
![](imgs_n_gifs/2023-01-06-06-36-55.png)

```
docker run --entrypoint htpasswd httpd:2 -Bbn username password > auth/htpasswd
```

![](imgs_n_gifs/2023-01-06-06-43-43.png)

```
docker ps
docker stop registry
docker rm registry
```

```
docker run -d -p 443:443 --restart=always --name registry -v `pwd`/auth:/auth -e "REGISTRY_AUTH=htpasswd" -e "REGISTRY_AUTH_HTPASSWD_REALM=Registry Realm" -e REGISTRY_AUTH_HTPASSWD_PATH=/auth/htpasswd -v `pwd`/certs:/certs -e REGISTRY_HTTP_ADDR=0.0.0.0:443 -e REGISTRY_HTTP_TLS_CERTIFICATE=/certs/domain.crt -e REGISTRY_HTTP_TLS_KEY=/certs/domain.key registry:2
```

![](imgs_n_gifs/2023-01-06-06-51-56.png)

> El comando, además de establecer los certificados, crea una restricción de acceso limitada a los usuarios especificados en el archivo auth/passwords. Como resultado, antes de usar el registro, el cliente debe especificar el nombre de usuario y la contraseña.

### Construyendo una imagen

![](imgs_n_gifs/2023-01-06-07-05-47.png)

![](imgs_n_gifs/2023-01-06-07-09-10.png)

### Realizamos un pushing de la imagen hacia el registro

```
docker login --username aldolunabueno --password *********
```

![](imgs_n_gifs/2023-01-06-07-20-26.png)

Ahora ya podemos hacer el push hacia el registro:

```
docker push aldolunabueno/ubuntu_with_python:1
```

![](imgs_n_gifs/2023-01-06-07-23-46.png)

Comprobamos en Docker Hub que efectivamente la imagen _ubuntu_with_python_ se publicó:

![](imgs_n_gifs/2023-01-06-07-25-34.png)

### Realizamos un pulling de la imagen desde el registro

Borramos la imagen:

![](imgs_n_gifs/2023-01-06-07-28-55.png)

![](imgs_n_gifs/2023-01-06-07-34-02.png)

Ahora la recuperamos del registro:

```
docker pull aldolunabueno/ubuntu_with_python:1
```

![](imgs_n_gifs/2023-01-06-07-30-14.png)

Confirmamos que la imagen está de vuelta:

![](imgs_n_gifs/2023-01-06-07-33-16.png)


## Pruebas de aceptación en el pipeline de Jenkins

