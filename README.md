# prisonCanEscape

Api para determinar si un prisionero puede escapar de una carcel. 

Instrucciones para Ejecutar
* Debe ejecutar la Url: http://54.226.147.184:8001/prisoner Modo -> POST en la aplicacion Postman ya sea escritorio o web.
* Debe Enviar en el Body como Json
  {
  "prison":["||||||S||","|P ||   |","||  | | |","|v| | < |","| |   | |","|   |   |","|||||||||"]
  }
* La prision debe tener la misma dimension. ejemplo 3x3 o 9x9. Si no, esta se dara porque no puede escapar
* Para consultar Estadisticas de la Prision, ejecute la siguiente Api:
  http://54.226.147.184:8001/stats Modo -> GET en la aplicacion Postman ya sea escritorio o web.
* La BD se maneja en H2 (en Memoria) Mientras el Api este arriba mantendra las estadisticas.  
  
  <img width="1421" alt="Captura de Pantalla 2022-07-17 a la(s) 10 35 52 p m" src="https://user-images.githubusercontent.com/39562093/179441936-f0f7474c-003f-49bb-8165-bfb2b90600ac.png">

<img width="1421" alt="Captura de Pantalla 2022-07-17 a la(s) 10 36 18 p m" src="https://user-images.githubusercontent.com/39562093/179441942-e2e16e4c-371e-409c-99df-93699b1f1c59.png">
<img width="1421" alt="Captura de Pantalla 2022-07-17 a la(s) 10 36 22 p m" src="https://user-images.githubusercontent.com/39562093/179441951-9863886a-4cc1-4921-8d2c-8a0552e0796e.png">
<img width="1421" alt="Captura de Pantalla 2022-07-17 a la(s) 10 36 44 p m" src="https://user-images.githubusercontent.com/39562093/179441955-66d9c243-4804-4081-993b-5fcc71db639e.png">

![Captura de Pantalla 2022-07-17 a la(s) 11 55 36 p m](https://user-images.githubusercontent.com/39562093/179626144-710fa6c7-cd73-4849-bff8-59ebaa8d2a79.png)