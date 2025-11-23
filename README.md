# 🦸‍♂️ Gestor de Avengers – Proyecto Java (Swing + POO)

Este proyecto implementa un sistema de gestión de Avengers utilizando **Java**, **Programación Orientada a Objetos** y una interfaz gráfica construida con **Swing**.  
Permite registrar, editar, buscar y generar reportes completos sobre cada héroe ingresado en el sistema.

---

## 👥 Integrantes
- Emily Mullo  
- Luis Morales  
- Johan Gamboa  
- Lucas Karlsson  

---

## 🚀 Características principales

### ✔ Gestión de datos
- Registrar nuevos Avengers  
- Editar información existente  
- Mostrar lista completa de héroes en un `JList`  
- Generar un reporte detallado con cálculo de aporte, impuestos y pago neto  

### ✔ Cálculos automáticos
Cada Avenger implementa métodos que permiten:
- `calcularAporte()` → 8% del pago mensual  
- `calcularImpuesto()` → de acuerdo con tramos de pago anual  
- `pagoNeto()` → pago mensual real después de descuentos  

### ✔ Búsqueda parcial por ID (Naive String Matching)
La búsqueda de Avengers por ID utiliza un algoritmo simple de coincidencia parcial (`buscarDatos()`).

### ✔ Interfaz gráfica con Swing
Incluye:
- Formularios de registro y edición  
- Slider para nivel de peligrosidad  
- Lista dinámica (`JList`)  
- Listeners implementados mediante **clases anónimas**, por lo que la clase Ventana **no necesita** un método `actionPerformed()` propio  

---

## 📂 Estructura del proyecto

```
├── Avenger.java
├── Equipo.java
└── Ventana.java
```

## 🧩 Descripción de las clases

### 🦸 Avenger
Modelo base que contiene:
- id, nombre, misión  
- nivel de peligrosidad  
- pago mensual  
- métodos para cálculos y representación en texto  

---

### 🧩 Equipo
Administra un `ArrayList<Avenger>`:
- Impide IDs duplicadas  
- Permite editar registros  
- Busca IDs con coincidencia parcial  
- Expone la lista mediante `getLista()`  

---

### 🪟 Ventana
Interfaz gráfica del sistema:
- Manejo de eventos con ActionListeners   
- Método `llenarJList()` para actualizar la vista  
- Campos de texto, botones, sliders y áreas de reporte  

---
