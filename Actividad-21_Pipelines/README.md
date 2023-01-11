# Actividad 21. Pipelines de integración continua (CI)

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

Creamos el proyecto Spring Boot en https://start.spring.io/ como sigue:

![](imgs_n_gifs/2023-01-10-22-14-37.png)

Hacemos push al código a GitHub




