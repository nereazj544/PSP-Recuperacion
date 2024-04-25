>[!NOTE]
> Tener en cuenta la arquitectura del TCP/Ip (No confundir con la OSI _Esa es para redes_)

Arquitectura:
5. Aplicacines
4. _Transporte  > UDP, TCP_ (Puerto 80 > HTTP/Apache)
3. _Red > IP_
2. Enlace
1. Fisica

Desarollo con Java: 
    Socket (UDP, TCP)
Cliente --- Servidor

 - Siguiendo el modelo ⤴️ TCP

_Se debe de especificar con el puerto y la ip._
Cuando se crean los scoket se especifica en el puerto, y la ip en un string o con 