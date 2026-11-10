# Técnicas de algoritmos

Este proyecto reúne tres técnicas de diseño de algoritmos implementadas en Java y ejecutadas desde `Main`.

| Técnica | Problema implementado | Idea principal | Eficiencia temporal | Memoria auxiliar | Criterio de uso |
|---|---|---|---|---|---|
| Divide y vencerás | Conteo de inversiones (`ContadorInversiones`) | Divide el arreglo en dos mitades, resuelve cada una y cuenta las inversiones durante la mezcla ordenada. | **O(n log n)** | **O(n)** para el arreglo auxiliar; la recursión usa O(log n). | Conveniente para problemas que se pueden separar en subproblemas independientes y combinar eficientemente. Es mucho más rápido que comparar cada par, que costaría O(n²). |
| Programación dinámica | Cambio mínimo con monedas 1, 3 y 4 (`CambioMonedas`) | Construye una tabla: para cada monto guarda el mínimo de monedas usando soluciones de montos menores. | **O(m · c)**; en este caso, como c = 3, es **O(m)**. | **O(m)** por la tabla `minCoins`. | Se usa cuando los subproblemas se repiten y se necesita una solución óptima. Intercambia memoria por evitar cálculos repetidos. |
| Voraz | Cambio con monedas 1, 5 y 10 (`CambioMonedasVoraz`) | Selecciona primero la moneda de mayor denominación posible y continúa con las menores. | **O(m)** en la versión iterativa actual, en el peor caso; la versión aritmética equivalente es **O(1)** con estas tres denominaciones fijas. | **O(1)**. | Adecuado cuando la elección local produce una solución óptima, como ocurre con las denominaciones 1, 5 y 10. Es la alternativa con menor consumo de memoria. |

## Resultados de la prueba de estrés

Los siguientes valores se obtuvieron al ejecutar la prueba de estrés desde `Main`. El tiempo y la memoria pueden variar entre ejecuciones según la JVM y los recursos disponibles del equipo. La memoria es una estimación del heap utilizado.

| Algoritmo | Datos mock evaluados | Tiempo de ejecución | Memoria aproximada | Resultado comparativo |
|---|---:|---:|---:|---|
| Divide y vencerás | 200.000 enteros | 169,359 ms | 2,22 MB | Mayor tiempo y memoria de la prueba, debido a la mezcla y al arreglo auxiliar. |
| Programación dinámica | Monto 300.000 | 39,474 ms | 2,01 MB | El más rápido en esta ejecución; usa una tabla de resultados para evitar cálculos repetidos. |
| Voraz | 250.000 montos mock | 104,654 ms | 1,72 MB | Menor consumo de memoria; procesa una gran cantidad de montos aplicando decisiones locales. |

## Ejecución

La clase `Main` ejecuta los tres ejercicios:

1. Cuenta las inversiones del arreglo `[2, 4, 1, 3, 5]`.
2. Calcula el mínimo de monedas para el monto `34` con denominaciones `1, 3, 4`.
3. Calcula el cambio para el monto `28` con denominaciones `1, 5, 10` mediante los enfoques aritmético y voraz.
