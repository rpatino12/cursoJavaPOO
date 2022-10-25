package model;

// Composición de Interfaces en Clases: abstraer todos los métodos/comportamientos de una clase para modularizarlos (comprimirlos, encapsularlos) en una interfaz y reutilizar su código en diferentes clases.

// Las interfaces se crean utilizando la palabra reservada 'interface' y se implementan en nuestras clases con 'implements'

import java.util.Date;

public interface IScheduleable {
    // Los metodos de una interfaz que no son definidos bajo el modificador de acceso 'private' o 'default', siempre van a ser abstractos, por lo tanto siempre deben ser implementados por las clases que implementan la interfaz
    void schedule(Date date, String time);
}
