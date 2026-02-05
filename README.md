# Kotlin-Research
Objetivo: Investigar y evaluar el lenguaje Kotlin para su posible integración en el ecosistema de trabajo dentro de la arteria I+D. Lo referente al lenguaje 
Nota: se agregará todo en el repositorio por si quieren revisarlo
Estado: Es una investigación en curso no una propuesta final.
Sección de Hallazgos: No solo será código; Sección de "Puntos Clave para el Equipo" donde resume por qué conviene (o no) integrarlo.


En esta primera etapa, la investigación se centró en la sintaxis base y la seguridad del sistema de tipos. Los puntos clave para el equipo de I+D son:

1. Inferencia de Tipos y Mutabilidad Estricta 
- Seguridad por Defecto: El uso de val (inmutable) fomenta la programación funcional y reduce efectos secundarios. En I+D, esto es vital para evitar errores de estado en procesos concurrentes.
- Inferencia: El compilador es lo suficientemente inteligente para deducir tipos, lo que reduce el boilerplate (código repetitivo)

2. Operaciones Seguras y el Operador Elvis 

- Eliminación del NPE: Kotlin trata la nulidad como parte de su sistema de tipos (ej. String?).
- Operador Elvis (?:): Permite definir valores por defecto de forma elegante en una sola línea (como hiciste con miNombre ?: "Anonimo"), eliminando bloques if-else innecesarios para validar nulos.
- Safe Calls (?.): Garantiza que la ejecución no se detenga si un objeto es nulo, devolviendo nulo en lugar de lanzar una excepción catastrófica.

3. Sintaxis , Métodos  
- Análisis Predictivo: Métodos como .contains() o .trim() son nativos y directos, facilitando la limpieza de datos de entrada sin librerías externas.
- Comparativa de Verbosidad: kotlin val nombreMostrar = miNombre ?: "Anonimo"  vs  String nombreMostrar = (miNombre != null) ? miNombre : "Anonimo";
