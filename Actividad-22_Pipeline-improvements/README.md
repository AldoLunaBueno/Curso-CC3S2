# Actividad 22. Mejoras al pipeline de integración continua (CI)

## Etapas de calidad de código

### Cobertura de código

Agregamos JaCoCo a Gradle en el archivo build.gradle y cargamos el nuevo plugin dando clic en el ícono de Gradle que emerge arriba a la derecha:

![](imgs_n_gifs/2023-01-11-21-19-39.png)

También agregamos la siguiente configuración de verificación de los tests:

![](imgs_n_gifs/2023-01-11-21-43-08.png)

Para probar la cobertura del código con JaCoCo ejecutamos el comando `./gradlew test jacocoTestCoverageVerification`. Nos sale que no hay ningún error, pero queremos saber más.

Inspeccionamos el reporte completo en _build/reports/jacoco/test/html/index.html_ y vemos que la covertura es del 100 %:

![](imgs_n_gifs/2023-01-11-22-00-51.png)

Ahora, si comento todo el código de los tests, JaCoCo debería lanzar un mensaje de error, pero no lo hace:

![](imgs_n_gifs/2023-01-11-21-42-02.png)

Inspeccionamos el reporte completo como antes y nos damos cuenta de que, según JaCoCo, el código tiene una covertura del 33 %:

![](imgs_n_gifs/2023-01-11-21-52-33.png)

No tiene mucho sentido sentido, pero al aumentar el límite mínimo a 0.4 ya nos sale el mensaje de error «covered ratio is 0.3, but expected minimum is 0.4»:

![](imgs_n_gifs/2023-01-11-21-56-30.png)

Y ahora vamos a ver que esto mismo ocurre cuando lo construimos con Jenkins. 

Primero añadimos la nueva etapa de covertura:

![](imgs_n_gifs/2023-01-11-22-19-49.png)

Hacemos un push de estos cambios a nuestro repositorio y construimos el pipeline desde Jenkins. Debe fallar en la etapa de covertura de ćodigo:

![](imgs_n_gifs/2023-01-11-22-17-45.png)

No pudimos ver un enlace para abrir el reporte en el navegador, pero se puede consultar los logs de la etapa de covetura:

![](imgs_n_gifs/2023-01-11-22-36-36.png)

Nos falta este plugin:

![](imgs_n_gifs/2023-01-11-22-39-21.png)

Reiniciamos Jenkins y ahora sí se muestra un botón que permite visualizar el reporte en el mismo navegador. Se encuentra en el panel de la izquierda que se muestra al hacer clic en la construcción:

![](imgs_n_gifs/2023-01-11-22-49-44.png)

Y así se ve:

![](imgs_n_gifs/2023-01-11-22-52-44.png)

### Analisis de código estático

