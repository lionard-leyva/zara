# Zara Catalog API

## Descripción

La API de Catálogo de Zara proporciona información sobre los precios de los productos. Los usuarios pueden buscar precios basándose en el ID del producto, el ID de la marca y la fecha y hora.

## Endpoints

- `GET /api/v1/prices/{productId}/{brandId}/{dateTime}`: Devuelve el precio de un producto para una marca y fecha específicos.

## Cómo ejecutar la aplicación

1. Clona el repositorio: `git clone https://github.com/lionard-leyva/zara.git`
2. Navega al directorio del proyecto: `cd zara-catalog-api`
3. Ejecuta la aplicación: `./gradlew bootRun`

## Pruebas

Para ejecutar las pruebas, usa el siguiente comando: `./gradlew test`

## Tecnologías utilizadas

- JDK 21
- Spring Boot
- SQL
- Gradle

## Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir lo que te gustaría cambiar.

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)
