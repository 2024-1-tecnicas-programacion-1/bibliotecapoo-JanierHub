package com.mycompany.bibliotecapoo;

import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Libro> libros;

    public Biblioteca() {
        libros = new LinkedList<>();
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("Libros disponibles:");
        for (Libro libro : libros) {
            System.out.println(libro.mostrarInformacion());
        }
    }

    public void mostrarLibrosNoLeidos() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("Libros no leídos:");
        for (Libro libro : libros) {
            if (!libro.isLeido()) {
                System.out.println(libro.mostrarInformacion());
            }
        }
    }

    public Libro buscarLibro(String palabraBusqueda) {
        for (Libro libro : libros) {
            if (libro.mostrarInformacion().toLowerCase().contains(palabraBusqueda.toLowerCase())) {
                return libro;
            }
        }
        return null;
    }

    public void marcarLibroLeido(String tituloLibro) {
        Libro libro = buscarLibro(tituloLibro);
        if (libro != null) {
            libro.marcarLeido();
            System.out.println("Libro marcado como leído: " + libro.mostrarInformacion());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}

