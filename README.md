shareyourdreams
===============

Ejemplo de aplicación completa para Android. Más información en http://blog.findemor.es/2012/12/ejemplo-desarrollo-aplicacion-android-completa/

La aplicación permite geolocalizar sueños y pesadillas, mostrar los cercanos en un mapa, utilizar una base de datos para identificar los sueños propios, y otras funciones divertidas.

Aplicación desarrollada por www.devergence.com

Si bien es de codigo abierto, es necesario mencionar al autor en los trabajos derivados de este proyecto.

La aplicación se ha construido sobre la plataforma de servicios basados en localización www.topoos.com.

Puedes ver como destripamos el código en el siguiente enlace:

 * [`Codigo fuente descrito y destripado`][URI_SOURCECODE_BLOG]

## Building

### Eclipse
 * This project has to be build with Google APIs Level 8 or higher!

### topoos APPTOKEN_ADMIN for Access
 * You must write your own app APPTOKEN_ADMIN (which you got when you registered your app) for get it working (Replace XXXXXXXXXXX)
  
```java
public class AccessInterface {
  
	////Must get your tokens from topoos developer panel https://developers.topoos.com
	private static final String TOPOOS_ADMIN_APP_TOKEN = "XXXXXXXXXXXXXXXXXXXXXXXXX";
```

### Libs
 * You must include topoos SDK in your project libs folder
 * [`topoos Android SDK`][URI_TOPOOS_ANDROID_SDK]

## Descripción completa para ponerla en marcha (destripamos el código)

 * [`Codigo fuente descrito y destripado`][URI_SOURCECODE_BLOG]

## Related documentation

 * [`Register your own topoos app`][URI_TOPOOS_REGISTER_APP]
 * [`topoos Android SDK`][URI_TOPOOS_ANDROID_SDK]


[URI_TOPOOS_REGISTER_APP]: http://docs.topoos.com/api-guides/registering-your-app/
[URI_TOPOOS_ANDROID_SDK]: http://docs.topoos.com/tools/sdks/android/
[URI_SOURCECODE_BLOG]: http://blog.findemor.es/2012/12/ejemplo-desarrollo-aplicacion-android-completa/
