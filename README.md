# Conversor de Monedas

Este es un proyecto desarrollado como parte del reto de certificación de **Oracle ONE Education**. El objetivo del proyecto es implementar un conversor de monedas que permita al usuario convertir entre distintas divisas utilizando datos actualizados de una API de tasas de cambio. El programa también registra las conversiones realizadas en un archivo JSON para llevar un historial de las transacciones.

## Funcionalidades

1. **Interfaz de Menú**: El programa presenta un menú interactivo donde el usuario puede seleccionar la conversión deseada entre varias monedas:
   - Dólar estadounidense (USD) a otras monedas como:
     - Peso argentino (ARS)
     - Real brasileño (BRL)
     - Peso colombiano (COP)
     - Peso chileno (CLP)
     - Peso boliviano (BOB)
   - También es posible realizar la conversión en la dirección opuesta (de cada una de estas monedas a USD).
   
2. **Conversión en tiempo real**: El programa utiliza la API de Exchange Rate para obtener el tipo de cambio actualizado para la moneda seleccionada. Los resultados de la conversión se calculan con precisión y se muestran al usuario.

3. **Registro de conversiones**: Todas las conversiones realizadas se almacenan en un archivo JSON llamado `logs.json`. Este archivo incluye:
   - Moneda de origen y moneda destino.
   - Valor original y el valor convertido.
   - Fecha y hora en que se realizó la conversión.

## Uso del programa

Para ejecutar el programa, sigue estos pasos:

1. Clonar el repositorio del proyecto o descargar los archivos de código fuente.
2. Asegurarse de tener la librería **Gson** incluida en el proyecto para el manejo de archivos JSON.
3. Ejecutar la clase principal `ChallengeCurrencyConverter`, que iniciará el menú interactivo.
4. Seleccionar una de las opciones del menú y seguir las instrucciones para ingresar la cantidad a convertir.
5. Los resultados aparecerán en la consola, y los detalles de la conversión se almacenarán en el archivo `logs.json`.

## Requisitos del Proyecto

- **Java**: Este proyecto está escrito en Java y usa las siguientes librerías:
  - `HttpClient` para hacer solicitudes a la API.
  - **Gson** para serialización y deserialización de archivos JSON.
  
- **API de tasas de cambio**: El proyecto utiliza la API de Exchange Rate (`https://v6.exchangerate-api.com`) para obtener los valores actuales de conversión entre monedas.

## Clases Principales

- **ChallengeCurrencyConverter**: La clase principal que ejecuta el programa y despliega el menú.
- **Menu**: Controla la interacción con el usuario, ofreciendo las opciones de conversión y recibiendo los valores a convertir.
- **GetInformation**: Realiza las solicitudes a la API, calcula el valor convertido, y registra la información en un archivo JSON.
- **Data**: Modelo de datos que representa la estructura de la respuesta de la API y contiene las tasas de conversión.

## Proyecto para Oracle ONE Education

Este proyecto forma parte del reto de certificación de **Oracle ONE Education**, cuyo propósito es demostrar habilidades en el uso de Java para desarrollar aplicaciones útiles que se integran con APIs y manejan datos de manera eficiente. El conversor de monedas refleja estas habilidades al implementar una solución que realiza conversiones en tiempo real y gestiona el almacenamiento de las conversiones.

## Autor

Desarrollado por Gabriel Angeles, participante del programa de certificación de **Oracle ONE Education**.
