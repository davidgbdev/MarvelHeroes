# MarvelHeroes
App de Superheroes de Marvel Creada con Android, Kotlin, MVVM y JetpackCompose. Este proyecto tiene como objetivo proporcionar una aplicación de muestra que muestra una lista de superhéroes de Marvel y su información detallada utilizando la API de Marvel.

El proyecto está construido utilizando la arquitectura MVVM (Modelo-Vista-Modelo de Vista), que se centra en separar la lógica empresarial de la interfaz de usuario. La implementación de MVVM en este proyecto ayuda a garantizar que el código sea fácilmente mantenible y escalable.

Además, el proyecto utiliza Clean Architecture, que se enfoca en dividir el proyecto en capas separadas de responsabilidades, para garantizar la separación adecuada de las capas y mejorar la escalabilidad.

Para consumir la API de Marvel, se utiliza Retrofit, una biblioteca de cliente HTTP que simplifica el consumo de API. Además, para la gestión de los datos, se utiliza un patrón de repositorio para separar la capa de datos de la capa de presentación.

Finalmente, la interfaz de usuario se crea utilizando Jetpack Compose, una biblioteca moderna de IU de Android que simplifica el desarrollo de interfaces de usuario dinámicas y atractivas.


## Claves de la API de Marvel

Las peticiones a la API se autentican con una clave pública y una clave privada. Esas claves no están en el repositorio: Gradle las lee de un archivo local y las expone en `BuildConfig`. En cada petición la app genera un timestamp y el hash `md5(timestamp + clavePrivada + clavePublica)`.

1. Crea una cuenta en el [portal de desarrolladores de Marvel](https://developer.marvel.com/) y genera una clave pública y una privada (My Developer Account).
2. En la raíz del proyecto, copia el archivo de ejemplo:

   ```bash
   cp secrets.properties.example secrets.properties
   ```

3. Abre `secrets.properties` y sustituye los valores de ejemplo por tus claves:

   ```properties
   MARVEL_PUBLIC_KEY=tu_clave_publica
   MARVEL_PRIVATE_KEY=tu_clave_privada
   ```

4. Compila con `./gradlew :app:assembleDebug`. Si falta `secrets.properties`, alguna clave está vacía o sigue el texto de ejemplo, la compilación se detiene e indica qué falta.

`secrets.properties` está en `.gitignore`. No lo subas al repositorio. La clave privada queda dentro del APK compilado; no publiques ese APK.

El APK de demostración que estaba en `Apk/` se eliminó del repositorio porque incluía las credenciales. Las claves antiguas siguen en el historial de Git y hay que revocarlas en el portal de Marvel.

## Tecnologías utilizadas

 - [Android Kotlin](https://developer.android.com/kotlin)
 - [MVVM Architecture](https://developer.android.com/jetpack/guide?gclsrc=aw.ds&gclid=CjwKCAjw_ISWBhBkEiwAdqxb9up3VFjuEbls5467JIVkyOdTgg-z-_NntWqaSFgkJr5qt6EmGsb7vxoCj9kQAvD_BwE)
 - [Retrofit](https://square.github.io/retrofit/)
 - [Room Database](https://developer.android.com/jetpack/androidx/releases/room?gclsrc=aw.ds&gclid=CjwKCAjw_ISWBhBkEiwAdqxb9r5eN7phvDex2hZ5gGRkm1GckeBjkR8LNm3GwDU_4EC8OdDDtDxt_xoCH8QQAvD_BwE)
 - [Dagger Hilt](https://dagger.dev/hilt/)
 - [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjw3a2iBhCFARIsAD4jQB0ZoNAPErTRKbgbNQ6vVw0C33Tb7pWoWwluRTMZoUfuupn9XbTunyYaAjFwEALw_wcB&gclsrc=aw.ds&hl=es-419)


