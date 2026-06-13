# Sistema Inteligente de Tráfico y Emergencias

### Nombre del proyecto:
Sistema Inteligente de Tráfico y Emergencias

### Integrantes del grupo:
- Romina Analía Colqui
- Nayla Dinara Granelli

### Alternativa elegida:
Alternativa B — Sistema Inteligente de Tráfico y Emergencias

### Estructuras de datos utilizadas:
- **Grafo Ponderado** (GrafoPonderado) : representa la red vial de la ciudad, con intersecciones como nodos y calles como aristas con peso (distancia/tiempo)
- **Cola de Prioridad** (ColaPrioridad) : gestiona el despacho de unidades de emergencia según nivel de urgencia
- **Diccionario** (Diccionario) : permite acceso rápido a dispositivos, intersecciones y vehículos por clave
- **Árbol General** (ArbolGeneral) : modela la jerarquía territorial: Ciudad → Comuna → Barrio → Manzana
- **Cola FIFO** (Cola) : administra la cola de vehículos en intersecciones con semáforo

### Funcionalidades implementadas en esta segunda etapa:

**Modelado de la ciudad** (ModeladoCiudad)
- Creación y conexión de intersecciones y calles
- Cálculo de rutas óptimas en la red vial mediante grafo ponderado

**Organización territorial** (OrganizacionTerritorial)
- Estructuración jerárquica del territorio: Ciudad → Comuna → Barrio → Manzana
- Consulta y navegación de la jerarquía mediante árbol general

**Flujo vehicular** (FlujoVehicular)
- Registro de vehículos y gestión de su circulación
- Administración de semáforos y colas de espera en intersecciones

**Despacho de emergencias** (DespachoEmergencias)
- Alta y gestión de emergencias con distintos niveles de prioridad
- Asignación y despacho de unidades de emergencia mediante cola de prioridad

**Gestión de dispositivos** (GestorDispositivos)
- Registro y consulta de dispositivos (cámaras, semáforos) distribuidos en la ciudad
- Acceso eficiente mediante diccionario/tabla hash

### SRC:
```
|modelo
  - Barrio, Calle, Camara, Ciudad, Comuna
  - Dispositivo, Emergencia, IGestionable
  - Interseccion, Manzana, Semaforo
  - UnidadEmergencia, Vehiculo
|modulos
  - DespachoEmergencias, FlujoVehicular
  - GestorDispositivos, ModeladoCiudad, OrganizacionTerritorial
|tda
  - ArbolGeneral, Cola, ColaPrioridad
  - Diccionario, GrafoPonderado
  - ICola, IDiccionario, IGrafoPonderado
Main
```

### Link del repositorio:
[https://github.com/LanieKo/Midnight_TPO_SitemaDeTrafico](https://github.com/LanieKo/Midnight_TPO_SitemaDeTrafico)

### Actividades realizadas por cada integrante:
- **Nayla Dinara Granelli:** se dedicó a armar el esqueleto del código
- **Romina Analía Colqui:** se dedicó a la resolución de los errores ,mejora de la salida por consola,  mejoró la organización de la información para facilitar la lectura. 
