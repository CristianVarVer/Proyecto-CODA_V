<p align="right">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/e0e59307f3dad8654486b3b71cba306509095f8d/Logo%20CODA-V.jpg?token=BTCBO4JTADR2KJC7MFL2HELIJDIHM" width="150">
</p>

# CODA-V
## Sistema de Gestión de Inventario
### Fundamentos de Programación 2.025

**Autores:**  
- Daniela Ortiz  
- Cristian Vargas  
- Frank Valderrama  
- Roberth López

---

## Tabla de Contenido
[TOCM]

[Indice de contenidos]

1. [Ficha Técnica del Equipo](#ficha-técnica-del-equipo)
2. [Descripción del Proyecto](#descripción-del-proyecto)
3. [Objetivos](#objetivos)
4. [Metas a Alcanzar](#metas-a-alcanzar)
5. [Organización Plan de Trabajo - Sprints](#organización-plan-de-trabajo---sprints)
   - [Sprint 1](#sprint-1)
   - [Sprint 2](#sprint-2)
   - [Sprint 3](#sprint-3)
6. [Contacto](#contacto)
7. [Estructura del Código en Java](#estructura-del-código-en-java)
8. [Diseño del Código en Java](#diseño-del-código-en-java)
---

## Ficha Técnica del Equipo

**Nombre del Proyecto:** CODA-V

**Logo:**

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/e0e59307f3dad8654486b3b71cba306509095f8d/Logo%20CODA-V.jpg?token=BTCBO4JTADR2KJC7MFL2HELIJDIHM">
</p>

**Eslogan del Proyecto:** “Ordena, controla, evoluciona”


**Integrantes y roles:**
- Cristian Alberto Vargas – *Product Owner*
- Daniela Ximena Ortiz – *Scrum Master*
- Frank Sebastián Valderrama – *Development Team*
- Roberth Arley López – *Development Team*

Somos un equipo de cuatro estudiantes que trabajamos en conjunto para desarrollar el proyecto **CODA-V**, un programa pensado para ayudar a tiendas o pequeños negocios a llevar el control de su inventario de manera sencilla, clara y actualizada.

**Tecnología principal:** Java

**Funcionalidades principales:**
- Registrar productos
- Consultar inventario
- Actualizar información
- Eliminar registros
- Calcular valor total del inventario
- Opción "Acerca de" con ficha técnica

---

## Descripción del proyecto

CODA-V es un sistema de gestión de inventario desarrollado en Java, pensado para pequeñas y medianas tiendas. Permite registrar productos, consultar el inventario, actualizar información y eliminar registros desde un menú en consola. Incluye funciones como cálculo del valor total del inventario y una sección informativa sobre el equipo desarrollador.

El programa es claro, funcional y fácil de usar desde cualquier ordenador, sin necesidad de conocimientos técnicos avanzados.

---

## Objetivos

### Objetivo general

Desarrollar un programa moderno, funcional y accesible que permita a las tiendas administrar su inventario de forma eficiente mediante listas, estructuras de control, validación de datos y una interfaz amigable.

---

## Metas a alcanzar

- Crear un sistema que ayude a mantener actualizado el inventario.
- Evitar pérdidas por desorganización o falta de registros.
- Proporcionar un menú sencillo con opciones para:
  - Añadir productos
  - Ver inventario
  - Modificar productos
  - Eliminar productos
  - Consultar valor total del stock
- Aplicar conocimientos adquiridos en programación, bases de datos y documentación.
- Automatizar la gestión de entradas, salidas, actualizaciones y seguimiento.
- Reducir errores humanos y pérdidas.
- Ofrecer una solución para usuarios sin conocimientos técnicos.

---

## Organización plan de trabajo - Sprints

### Sprint 1

- Formación oficial del equipo y asignación de roles.
- Elección del nombre del proyecto y creación del logo.
- Organización del repositorio en GitHub.
- Revisión de requisitos del proyecto.
- Avance en el archivo README.
- Estructura inicial de clases en Java.
- Diseño preliminar del modelo del proyecto.

### Sprint 2

- Programación completa de clases con métodos (agregar, actualizar, eliminar, consultar).
- Validación de entradas del usuario.
- Implementación del cálculo del valor total del inventario.
- Desarrollo del menú completo y funcional.
- Incorporación de diseño visual: menú, separadores, colores.
- Pruebas funcionales de CRUD.
- Revisión y ajustes del modelo.
- Avance en documentación técnica: manuales y diccionario de datos.

### Sprint 3

- Preparación de documentos para entrega final.
- Grabación de videos explicativos en español e inglés.
- Integración completa del CRUD.
- Verificación y validación del funcionamiento del proyecto.
- Entrega en GitHub: README completo, carpetas organizadas, documentación subida.

---

## Estructura Inicial del Código en Java

## Estructura del Código en Java

### 1. Clase Main

Este es el archivo que inicia todo. Es como el botón de encendido del programa.

- Cuando ejecutas el programa, `Main.java` crea una "pantalla" para que interactúes (la `InterfazUsuario`).
- Luego, le dice a esa "pantalla" que comience a funcionar (`interfaz.ejecutar()`).

**Paquete:** Raíz del proyecto  
**Propósito:** Es el punto de entrada del programa.  
**Método:**
- `main(String[] args)`: crea un objeto de la clase `InterfazUsuario` y ejecuta el sistema con el método `ejecutar()`.

💡 **Funcionalidad principal:**
- Iniciar la ejecución del programa.
- Es la puerta de entrada del sistema en Java y se ejecuta automáticamente al iniciar el programa.

---

### 2. Clase InterfazUsuario

Es la **Pantalla Amigable**, este archivo se encarga de todo lo que ves y cómo interactúas con el programa.

- Muestra un menú con opciones como:
  - Agregar un nuevo producto.
  - Ver todos los productos que tienes.
  - Cambiar la información de un producto (ej. el precio o la cantidad).
  - Quitar un producto del inventario.
  - Calcular cuánto dinero valen todos tus productos juntos.
  - Ver información sobre quién hizo el programa.
  - Salir del programa.
- Pide información: cuando eliges una opción como "Agregar producto", te pregunta cosas como el nombre del producto, cuántos tienes y su precio.
- Muestra resultados: te enseña la lista de tus productos, te dice si un producto se agregó bien o si hubo un error.
- Usa un `Scanner` para leer lo que escribes con el teclado.
- Tiene una conexión a la lógica del inventario (`Inventario inventario = new Inventario();`).

**Paquete:** `ui`  
**Atributos:**
- `scanner`: objeto que permite leer datos desde el teclado.
- `inventario`: objeto de la clase `Inventario` que se usa para realizar operaciones.

**Constructor:** Inicializa el objeto `scanner` y el objeto `inventario`.

**Métodos:**
- `mostrarMenu()`: presenta las opciones disponibles al usuario.
- `ejecutar()`: contiene el ciclo principal que mantiene el programa en funcionamiento.
- `agregarProducto()`, `consultarInventario()`, `actualizarProducto()`, `eliminarProducto()`
- `calcularValorTotal()`: muestra el valor total del inventario.
- `mostrarAcercaDe()`: presenta la información del equipo.
- `obtenerNumeroEntero()`, `obtenerNumeroDouble()`: validan y reciben datos numéricos.
- `esperarEnter()`: hace una pausa antes de volver al menú.

💡 **Funcionalidad principal:**
- Mostrar el menú y recibir acciones del usuario desde consola.
- Es el puente entre el usuario y la lógica del sistema (`Inventario`).
- Controla la entrada de datos, muestra resultados y valida que la información sea correcta.

---

### 3. Clase Inventario

Es el **Cerebro del Almacén**, este archivo maneja la lista de productos y hace todas las operaciones importantes. No lo ves directamente, pero la `InterfazUsuario` habla con él.

- Guarda los productos en una lista (`List<Producto> productos`) donde se almacenan todos los productos que vas agregando.

**Paquete:** `negocio`  
**Atributo:**
- `productos`: lista de tipo `ArrayList<Producto>` que almacena todos los productos registrados.

**Constructor:** Inicializa la lista `productos` como un nuevo `ArrayList`.

**Métodos:**
- `agregarProducto()`: añade un producto si el ID no está repetido.
- `consultarInventario()`: devuelve todos los productos.
- `actualizarProducto(id, nuevoNombre, nuevaCantidad, nuevoPrecio)`: cambia los datos de un producto existente.
- `eliminarProducto(id)`: elimina el producto con ese ID.
- `obtenerProductoPorId(id)`: busca y devuelve un producto por su ID.
- `calcularValorTotal()`: multiplica cantidad × precio por producto y devuelve el total.

💡 **Funcionalidad principal:**
- Administrar la lista completa de productos del inventario.
- Gestiona todas las operaciones básicas: agregar, consultar, actualizar y eliminar productos.
- Verifica duplicados y calcula el valor total del inventario.

---

### 4. Clase Producto

Es la **Plantilla del Producto**, este archivo es como una ficha que define cómo es un producto.

Cada producto tiene:
- Un ID: código único para identificarlo (ej. `"A001"`).
- Un nombre: como `"Leche"` o `"Pan"`.
- Una cantidad: cuántas unidades tienes (ej. `10`).
- Un precio: cuánto cuesta cada unidad (ej. `2.50`).

También incluye funciones (`getters` y `setters`) para ver o cambiar estos datos.  
Ejemplo: `getNombre()` te da el nombre del producto, `setPrecio()` te permite cambiar su precio.

**Paquete:** `modelo`  
**Atributos:**
- `id`: identificador único del producto (tipo `String`).
- `nombre`: nombre del producto.
- `cantidad`: cantidad disponible en stock.
- `precio`: precio por unidad.

**Constructor:** Crea un nuevo objeto `Producto`, inicializando sus valores.

**Métodos:**
- **Getters:** permiten acceder a los valores privados desde fuera de la clase.
- **Setters:** permiten modificar los atributos `nombre`, `cantidad` y `precio`.

💡 **Funcionalidad principal:**
- Almacenar y gestionar información básica sobre los productos.
- Define la estructura que deben tener los productos en la aplicación.
- Solo se pueden acceder o modificar mediante los métodos `get` y `set`.

---

##  Diseño del Código en Java

**¿Cómo funciona todo junto?**

1. Ejecutas `Main.java`.
2. `Main` crea y muestra la `InterfazUsuario`.
3. La `InterfazUsuario` te muestra el menú. Tú eliges una opción (por ejemplo, "Agregar producto").
4. La `InterfazUsuario` te pide los datos del producto (ID, nombre, cantidad, precio).


---
## Contacto

**Teléfono:** 3125860277  
**Correo electrónico:** cristian.vargasver@unipamplona.edu.co
