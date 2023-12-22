# Recetas

Esta aplicación te permite descubrir recetas auténticas de Perú y Colombia, con información detallada sobre su lugar de origen para sumergirte en la cultura culinaria de estos dos países.

## Características Principales

- **Arquitectura DDD (Domain Driven Design):** La aplicación sigue una arquitectura DDD para organizar y estructurar el código de manera clara y modular.
  
- **Patrones de Diseño Utilizados:**
  - Repository: Para gestionar el acceso a datos.
  - ModelMapper: Para mapear modelos entre capas.
  - Translator: Para traducir modelos entre la capa de datos y la capa de dominio.
  - MVVM (Model-View-ViewModel): Para separar las capas de presentación y lógica de negocio.

- **Tecnologías y Bibliotecas Utilizadas:**
  - Jetpack Compose: Para la creación de interfaces de usuario modernas.
  - Coil: Biblioteca de carga de imágenes para la carga eficiente de imágenes.
  - Espresso y JUnit: Para realizar pruebas en la interfaz de usuario y pruebas unitarias.
  - Retrofit y Gson: Para realizar conexiones HTTP REST y manejar la deserialización de JSON.
  - Coroutines: Para el manejo de hilos y ejecución asíncrona.
  - Google Maps: Integración de mapas para mostrar la ubicación de las recetas.
  - Hilt: Para la inyección de dependencias.
  - Flow: Para el manejo reactivo de datos.

## Requisitos de Compilación

- **SDK Version:**
  - Mínima: 34
  - Target: 34
 
  - **Android Studio Version:**
  - Hedgehog | 2023.1.1

## Servidores

- **Servidor de Imágenes:** [ImgBB](https://mona15.imgbb.com/)
- **Servidor de Endpoints:** [Mockable](https://www.mockable.io/)

