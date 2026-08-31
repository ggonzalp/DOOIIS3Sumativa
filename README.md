#Speedfast

El encargo de esta semana consiste en complementar el sistema creado para la agencia de envíos SpeedFast, con el objetivo de gestionar pedidos 
con reglas de negocio particulares para su asignación y entrega. Además, de implementar interfaces con el fin de desacoplar la lógica de las 
operaciones funcionales y favorecer la mantenibilidad del sistema. 

#Descripción
SpeedFast ofrece tres tipos de servicio, y cada uno tiene un criterio distinto para asignar repartidor, además cada uno tiene un tiempo
base de tiempo estimado de entrega al que se le suman minutos por kilómetros de distancia del punto de entrega.
Para esta semana se incluye un registro para que el usuario pueda visualizar durante la ejecución cuando un pedido está siendo registrado, 
cancelado, despachado y también puede revisar el historial de pedidos en donde se obtiene el total de pedidos despachados.

#Estructura del proyecto
src/
├── Pedido.java                 Clase abstracta: atributos y comportamiento común
├── PedidoComida.java           Subclase: valida mochila térmica
├── PedidoEncomienda.java       Subclase: valida peso y embalaje
├── PedidoExpress.java          Subclase: valida cercanía del repartidor
├── DireccionEntrega.java       Dirección de entrega (número, calle, ciudad)
├── ControladorDeEnvios.java    Gestiona la lista de pedidos y el historial
├── Registrable.java            Interfaz: registrar()
├── Cancelable.java             Interfaz: cancelar()
├── Despachable.java            Interfaz: despachar()
├── Rastreable.java             Interfaz: verHistorial()
└── Main.java                   Clase principal con la simulación

# Implememtación de métodos
- registrar() registra pedidos en el historial.
- cancelar() cancelar el pedido. (Luego de hacer el pedido se dispone de un tiempo limitado para cancelar)
- despachar() despacha el pedido.
- verHistorial() permite visualizar el historial de pedidos registrados.


#Ejecución
1° Clonar el repositorio: https://github.com/ggonzalp/DOOIIS3Sumativa.git

2° Abrir el proyecto en IntelliJ IDEA

3° Ejecutar la clase principal: src/ui/Main.java

4° El programa cargará automáticamente los datos ingresados de forma local y manual.

Autoría Estudiante: Gabriela González Peirano 
Asignatura: Desarrollo Orientado a Objetos II
Instituto: DuocUC




