# Actividad 21. Pipelines de integración continua (CI)

- [Actividad 21. Pipelines de integración continua (CI)](#actividad-21-pipelines-de-integración-continua-ci)
  - [Introducciones a los pipelines](#introducciones-a-los-pipelines)
  - [Compilación (compile)](#compilación-compile)
  - [Pruebas unitarias](#pruebas-unitarias)
    - [La lógica de negocios y su exposición como servicio web](#la-lógica-de-negocios-y-su-exposición-como-servicio-web)
    - [Escribiendo una prueba unitaria](#escribiendo-una-prueba-unitaria)
    - [Creación de una etapa de prueba unitaria](#creación-de-una-etapa-de-prueba-unitaria)
  - [Jenkinsfile](#jenkinsfile)


## Introducciones a los pipelines

Un pipeline consta de dos elementos: stage y step.

![](imgs_n_gifs/2023-01-10-20-34-26.png)

Creamos un pipeline _hello world 2_ de dos etapas y tres pasos usando la sintaxis declarativa:

![](imgs_n_gifs/2023-01-10-21-16-59.png)

Lo ejecutamos, y esta es su salida en consola:

![](imgs_n_gifs/2023-01-10-21-14-11.png)

## Commit pipeline de prueba: calculador

Creamos en nuestra cuenta de GitHub el repositorio _calculador_:

![](imgs_n_gifs/2023-01-10-21-35-34.png)

Creamos el pipeline _calculador_ cuyo objetivo es descargar el código del repositorio del mismo nombre (todavía no hay código ahí, pero la idea es esa).

![](imgs_n_gifs/2023-01-10-21-39-02.png)

Comprobamos que el pipeline _calculador_ se ejecutó con éxito en la salida de la consola:

![](imgs_n_gifs/2023-01-10-21-45-57.png)

## Compilación (compile)

Para compilar un proyecto, necesitamos hacer lo siguiente:
1. Crea un proyecto con el código fuente.
2. Push al repositorio.
3. Agrega la etapa compile al pipeline.

Creamos el proyecto Spring Boot en https://start.spring.io/

![](imgs_n_gifs/2023-01-11-13-29-25.png)

Escogemos la versión más antigua de Spring Boot, elegimos Java 8 y agregamos la depencencia Spring web.

Clonamos el repositorio _calculador_. Desplegamos el contenido del archivo del proyecto de Spring Boot en la carpeta correspondiente a este repositorio. Luego usamos InteliJ IDEA para construir los archivos Gradle (nos aparece una opción en la esquina inferior derecha).


![](imgs_n_gifs/2023-01-11-13-50-23.png)

Nuestro proyecto de Gradle compila localmente con el comando `./gradle compileJava`:

![](imgs_n_gifs/2023-01-11-14-03-16.png)

Aquí se ve que ya hicimos el push a través de InteliJ IDEA:

![](imgs_n_gifs/2023-01-11-14-20-54.png)

Vamos a Jenkins y creamos la etapa compile al pipeline calculator:

![](imgs_n_gifs/2023-01-10-22-38-09.png)

Ejecutamos el pipeline. Esta es su salida en consola:

![](imgs_n_gifs/2023-01-11-14-26-06.png)

![](imgs_n_gifs/2023-01-11-14-26-25.png)

Se demoró un poco en invocar al demonio de Gradle, pero al final la compilación fue exitosa.

## Pruebas unitarias

### La lógica de negocios y su exposición como servicio web

Agregamos dos clases: _Calculador.java_ y _CalculadorController.java_. La primer contiene la lógica empresarial y la segunda expone dicha lógica como un servicio web. 

![](imgs_n_gifs/2023-01-11-18-01-05.png)

No hubo ningún problema con la compilación del proyecto, pero sí al ejecutarlo con el comando `./gradlew bootRun`:

![](imgs_n_gifs/2023-01-11-17-39-00.png)

Esto se debió a que está usando el puerto 8080, mismo puerto que usa Jenkins, así que primero, si queremos ejecutarlo localmente, hay que parar el contenedor de Jenkins en el terminal con `docker stop jenkins`.

Ya podemos ir al navegador y hacer un request para usar la operación de suma. Con esta URL sumamos los números a=1 y b=2 y en la página nos sale un resultado de 3: http://localhost:8080/sum?a=1&b=2

![](imgs_n_gifs/2023-01-11-17-35-02.png)


### Escribiendo una prueba unitaria

Para agregar las dependencias nos ayudamos del buscador de dependencias de InteliJ IDEA:

![](imgs_n_gifs/2023-01-11-18-15-54.png)

Y ahora solo tenemos que cargar las dependencias dándole al ícono de Gradle que sale arriba a la derecha:

![](imgs_n_gifs/2023-01-11-18-19-33.png)

Al correr la prueba unitaria tuve el siguiente error:

![](imgs_n_gifs/2023-01-11-19-02-26.png)

Era porque la línea de código para importar de JUnit5 la anotación @Test era incorrecta, como explican aquí:

![](imgs_n_gifs/2023-01-11-19-01-13.png)

Ahora sí funciona:

![](imgs_n_gifs/2023-01-11-19-04-44.png)

Usamos el ícono de ejecución que nos ofrece InteliJ IDEA, pero también podemos usar en el terminal el comando `./gradlew test`:

![](imgs_n_gifs/2023-01-11-19-07-12.png)

Hacemos commit y push a nuestro repositorio a través de nuestro IDE:

![](imgs_n_gifs/2023-01-11-19-08-45.png)

### Creación de una etapa de prueba unitaria

Agregamos la etapa _Unit test_ al pipeline para ejecutar las pruebas unitarias:

![](imgs_n_gifs/2023-01-11-19-27-59.png)

Esta vez fue más rápido construir el pipeline a pesar de que ahora es un pipeline completo de integración continua:

![](imgs_n_gifs/2023-01-11-19-42-44.png)

## Jenkinsfile

> - La apariencia de un pipeline está estrictamente relacionada con el proyecto en sí.
> - Los pipelines deben ser
creados por las mismas personas que escriben el código: los desarrolladores.
> - La definición de pipeline debe estar junto con el código, en el repositorio.

Creando el archivo Jenkinsfile

![](imgs_n_gifs/2023-01-11-19-57-39.png)

Ahora ejecutamos el pipeline desde el Jenkinsfile. Para esto cambiamos en configuración la opción de _Pipeline script_ por la de _Pipeline script from **SCM**_ (Source Control Management):

![](imgs_n_gifs/2023-01-11-20-10-27.png)

Fnciona a la perfección a pesar de que ya no tenemos ningún script definido dentro de Jenkins:

![](imgs_n_gifs/2023-01-11-20-09-40.png)

Con esto concluimos con éxito nuestro primero commit pipeline completo de integración continua.
