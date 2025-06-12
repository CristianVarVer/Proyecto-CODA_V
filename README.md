<p align="right">
  <img src="https://github.com/CristianVarVer/Proyecto-CODA_V/blob/master/Logo%20CODA-V.jpg">
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
6. [Estructura del Código en Java](#estructura-del-código-en-java)
7. [Diseño del Código en Java](#diseño-del-código-en-java)
8. [Tecnologías Utilizadas](#tecnologías-utilizadas)
9. [¿Cómo Ejecutar el Proyecto?](#¡cómo-ejecutar-el-proyecto)
10. [Contacto](#contacto)
---

## Ficha Técnica del Equipo

**Nombre del Proyecto:** CODA-V

**Logo:**

<p align="center">
  <img src="https://github.com/CristianVarVer/Proyecto-CODA_V/blob/master/Logo%20CODA-V.jpg">
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

## Estructura del Código en Java

---

### 1. Clase Main

Es el punto de partida del programa, donde todo comienza.

- Lanza primero una ventana de login (`DialogoLogin`) para validar al usuario.
- Si el usuario se autentica correctamente, carga el inventario guardado y muestra la interfaz principal (`InterfazGrafica`).
- Si falla el login o se cancela, el programa finaliza automáticamente.

**Paquete:** Raíz del proyecto  
**Propósito:** Iniciar la ejecución del sistema de gestión de inventario.  
**Método:**
- `main(String[] args)`: Muestra la ventana de inicio de sesión. Si el usuario se autentica correctamente, muestra la interfaz principal con el inventario cargado.

💡 **Funcionalidad principal:**
- Es el punto de entrada de todo el sistema.
- Controla si se muestra o no la aplicación según el resultado del login.
  
<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Main.png?token=BTCBO4LJRCS5VJRTB7NTN3LIJGT7W">
</p>

---

### 2. Clase DialogoLogin

Es la ventana emergente que permite iniciar sesión en el sistema.

- Muestra un formulario para ingresar usuario y contraseña.
- Compara con los datos guardados en el archivo de usuarios.
- Si las credenciales son válidas, permite el acceso.
- También ofrece un botón para registrar un nuevo usuario.

**Paquete:** `ui`  
**Atributos:**
- `campoUsuario`, `campoContrasena`: campos para ingresar datos.
- `usuarios`: mapa de usuarios registrados.
- `usuarioAutenticado`: guarda el usuario que inicia sesión correctamente.

**Constructor:** Configura la interfaz visual del login y carga los usuarios.  
**Métodos:**
- `intentarLogin()`: verifica las credenciales ingresadas.
- `abrirRegistro()`: abre la ventana de registro de usuario.
- `getUsuarioAutenticado()`: devuelve el usuario si el login fue exitoso.

💡 **Funcionalidad principal:**
- Controlar el acceso al sistema.
- Permitir tanto login como registro de nuevos usuarios.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Dialogo%20Login.png?token=BTCBO4IU5O6TGCUYKTYCVJLIJGT7W">
</p>
---

### 3. Clase DialogoRegistro

Es la ventana que se abre desde el login para crear un nuevo usuario.

- Permite ingresar un nombre de usuario y contraseña.
- Verifica que no se repita el nombre de usuario y que las contraseñas coincidan.
- Si todo es correcto, guarda el nuevo usuario en el mapa y lo retorna al login.

**Paquete:** `ui`  
**Atributos:**
- `campoUsuario`, `campoContrasena`, `campoConfirmarContrasena`
- `usuarios`: mapa con los usuarios existentes.
- `usuarioNuevo`: guarda el usuario recién creado.

**Métodos:**
- `registrarUsuario()`: valida los datos y crea el nuevo usuario.
- `getUsuariosActualizados()`: devuelve el mapa de usuarios modificado.
- `getUsuarioNuevo()`: devuelve el nuevo usuario registrado.
- `isRegistrado()`: indica si se completó el registro.

💡 **Funcionalidad principal:**
- Registrar nuevos usuarios de forma segura y validada.
- Actualizar los datos de usuarios disponibles.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Dialogo%20Registro.png?token=BTCBO4OBI5A5BVYPQ5PXGQDIJGT7W">
</p>
---

### 4. Clase Usuario

Es la plantilla base para los usuarios del sistema.

- Cada usuario tiene un nombre y una contraseña.
- Es utilizado por el sistema para autenticar el acceso.

**Paquete:** `modelo`  
**Atributos:**
- `nombreUsuario`, `contrasena`

**Constructor:** Inicializa un nuevo usuario con los datos ingresados.  
**Métodos:**
- `getNombreUsuario()`, `getContrasena()`

💡 **Funcionalidad principal:**
- Representar a un usuario del sistema.
- Ser utilizado para validar el acceso mediante login.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Usuario.png?token=BTCBO4KSW6VFD56ON6FMEZ3IJGT7W">
</p>

---

### 5. Clase InterfazGrafica

Es la ventana principal del sistema, donde se muestra y gestiona todo el inventario.

- Muestra una tabla con todos los productos registrados.
- Tiene botones para agregar, actualizar, eliminar y ver el valor total del inventario.
- También permite abrir un diálogo con información sobre el sistema.

**Paquete:** `ui`  
**Atributos:**
- `inventario`: lógica de productos.
- `tabla`: tabla visual de productos.
- `modeloTabla`: modelo de datos para la tabla.

**Métodos:**
- `abrirDialogoAgregar()`, `abrirDialogoActualizar()`, `eliminarProducto()`
- `mostrarValorTotal()`, `mostrarAcercaDe()`
- `refrescarTabla()`

💡 **Funcionalidad principal:**
- Es la interfaz visual central del programa.
- Permite al usuario gestionar fácilmente los productos desde una tabla interactiva.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Interfaz%20Grafica.png?token=BTCBO4OOMZ5YVLHER47JCWLIJGT7W">
</p>

---

### 6. Clase DialogoAgregarProducto

Es la ventana que se abre para agregar un nuevo producto.

- Pide ID, nombre, cantidad y precio.
- Valida que los datos sean correctos y no estén duplicados.
- Si todo va bien, crea y guarda el nuevo producto en el inventario.

**Paquete:** `ui`  
**Atributos:**
- Campos de entrada para los datos del producto.
- `inventario`: referencia para agregar el producto.
- `agregado`: indica si el producto fue añadido.

**Métodos:**
- `agregarProducto()`: realiza las validaciones y añade el producto.
- `isAgregado()`, `getProducto()`

💡 **Funcionalidad principal:**
- Permitir añadir productos nuevos de forma segura y validada.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Dialogo%20Agregar%20Producto.png?token=BTCBO4IWXQLDXPGJ7YB4AIDIJGT7W">
</p>

---

### 7. Clase DialogoActualizarProducto

Ventana emergente para editar un producto ya existente.

- Muestra los datos del producto (ID, nombre, cantidad, precio).
- Permite cambiar nombre, cantidad y precio (el ID no se puede modificar).
- Valida los datos antes de aplicar los cambios.

**Paquete:** `ui`  
**Atributos:**
- Campos de entrada con los datos del producto.
- `productoOriginal`, `productoActualizado`

**Métodos:**
- `actualizarProducto()`: valida y actualiza el producto.
- `isActualizado()`, `getProductoActualizado()`

💡 **Funcionalidad principal:**
- Facilitar la edición de un producto del inventario de forma controlada.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Diaologo%20Actualizar%20Producto.png?token=BTCBO4OBADKS5F33GPN4F63IJGT7W">
</p>

---

### 8. Clase Producto

Es la ficha técnica de cada producto.

- Contiene el ID, nombre, cantidad y precio de cada producto.
- Se utiliza para representar y mostrar cada producto del inventario.

**Paquete:** `modelo`  
**Atributos:**
- `id`, `nombre`, `cantidad`, `precio`

**Constructor:** Inicializa un nuevo producto con los datos ingresados.  
**Métodos:**
- Getters y Setters para todos los atributos (excepto el ID que no cambia)

💡 **Funcionalidad principal:**
- Representar cada producto como objeto independiente.
- Ser utilizado por las interfaces para mostrar y modificar datos.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Producto.png?token=BTCBO4JKHTYEFGJXXZG3TCLIJGT7W">
</p>

---

### 9. Clase Inventario

Es el motor lógico del sistema que gestiona todos los productos.

- Usa una lista para guardar todos los productos.
- Permite agregar, buscar, actualizar, eliminar y calcular el valor total.

**Paquete:** `negocio`  
**Atributo:**
- `productos`: lista `ArrayList<Producto>`

**Constructor:** Crea la lista de productos vacía.  
**Métodos:**
- `agregarProducto()`, `consultarInventario()`
- `actualizarProducto()`, `eliminarProducto()`
- `obtenerProductoPorId()`, `calcularValorTotal()`

💡 **Funcionalidad principal:**
- Gestionar internamente el inventario y sus operaciones.
- Servir de puente entre la interfaz y los datos reales.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Inventario.png?token=BTCBO4OP5M3FFBZGVICQXADIJGT7W">
</p>

---

### 10. Clase ManejadorDatos

Es el encargado de guardar y cargar datos desde archivos.

- Usa la serialización para almacenar el inventario y los usuarios.
- Guarda los datos en archivos `.dat` y los recupera cuando se necesita.

**Paquete:** `negocio`  
**Constantes:**
- `ARCHIVO_INVENTARIO`, `ARCHIVO_USUARIOS`

**Métodos:**
- `guardarInventario()`, `cargarInventario()`
- `guardarUsuarios()`, `cargarUsuarios()`

💡 **Funcionalidad principal:**
- Hacer que los datos persistan entre sesiones del programa.
- Facilitar el almacenamiento automático de usuarios y productos.

<p align="center">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Clase%20Manejador%20Datos.png?token=BTCBO4P6YFKHA2OEFAUB5D3IJGT7W">
</p>

---

##  Diseño del Código en Java

**¿Cómo funciona todo junto?**

1. Ejecutas `Main.java`.
2. Se abre la ventana de login (`DialogoLogin`).
3. Si te autenticas correctamente, se carga el inventario guardado y aparece la ventana principal (`InterfazGrafica`).
4. Desde allí puedes:
   - Agregar productos (`DialogoAgregarProducto`)
   - Modificar productos (`DialogoActualizarProducto`)
   - Eliminar, consultar o ver el valor total del inventario.
5. Todo lo que haces se gestiona con la lógica de `Inventario` y se guarda gracias a `ManejadorDatos`.

<p align="left">
  <img src="https://raw.githubusercontent.com/CristianVarVer/Proyecto-CODA_V/fc09204107dc56b66670faec1f124a87e4c56316/Diagrama%20UML-%20CODA-V.png?token=BTCBO4JAR66RCCPNGBBVSQTIJGT7W">
</p>

---

## Tecnologías Utilizadas

- **Java 8+**
- **Java Swing**: Para la interfaz gráfica de usuario.
- **POO (Programación Orientada a Objetos)**: Modelo de diseño basado en clases.
- **Serialización de Objetos**: Para guardar y cargar datos de usuarios e inventario.
- **Manejo de archivos binarios (.dat)**: Persistencia de datos.
- **NetBeans / IntelliJ IDEA / Eclipse**: Recomendado para desarrollo y pruebas.
- **Sistema de control de versiones Git** (repositorio en GitHub).

---

## Cómo Ejecutar el Proyecto

### 🖥️ Requisitos previos

- Tener instalado **Java JDK 8 o superior**
- Tener un IDE como **NetBeans**, **IntelliJ IDEA** o **Eclipse**
- Descargar o clonar el repositorio de GitHub


### 🚀 Cómo Ejecutar el Proyecto

**Pasos para usar el sistema**

1. Abre el proyecto en tu editor o entorno de desarrollo favorito (como **NetBeans**, **IntelliJ** o **Eclipse**).
2. Asegúrate de que los archivos `inventario.dat` y `usuarios.dat` estén en la carpeta del proyecto.  
   - No te preocupes si no están: el sistema los crea automáticamente la primera vez que se ejecuta.
3. Busca y ejecuta la clase `Main.java`.
4. Aparecerá una ventana para iniciar sesión.
5. Puedes:
   - Iniciar sesión si ya tienes un usuario.
   - Registrar un usuario nuevo si aún no tienes uno.
6. Una vez inicies sesión correctamente, verás la ventana principal con el inventario.

### 💡 Nota Importante
  
El sistema guarda automáticamente todos los cambios (productos y usuarios) cuando cierras la ventana principal.

### 🧪 Notas útiles

- Puedes probar el programa agregando, modificando o eliminando productos, así como creando nuevos usuarios.
- Toda la información se guarda en dos archivos:
  - `inventario.dat` → productos
  - `usuarios.dat` → usuarios registrados
- Si cierras el programa y lo vuelves a abrir, ¡los datos seguirán allí!

---

## Contacto

**Teléfono:** 3125860277  
**Correo electrónico:** cristian.vargasver@unipamplona.edu.co
