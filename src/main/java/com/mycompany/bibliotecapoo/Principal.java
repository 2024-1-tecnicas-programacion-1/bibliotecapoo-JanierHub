package com.mycompany.bibliotecapoo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1) Ingresar libro");
            System.out.println("2) Mostrar todos los libros");
            System.out.println("3) Buscar libro");
            System.out.println("4) Marcar libro como leído");
            System.out.println("5) Mostrar libros no leídos");
            System.out.println("0) Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el género del libro: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del libro: ");
                    int anoPublicacion = scanner.nextInt();
                    biblioteca.registrarLibro(new Libro(titulo, autor, genero, anoPublicacion));
                    break;
                case 2:
                    biblioteca.mostrarLibros();
                    break;
                case 3:
                    System.out.print("Ingrese la palabra clave para buscar el libro: ");
                    String palabraBusqueda = scanner.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibro(palabraBusqueda);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado.mostrarInformacion());
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título del libro a marcar como leído: ");
                    String tituloLibro = scanner.nextLine();
                    biblioteca.marcarLibroLeido(tituloLibro);
                    break;
                case 5:
                    biblioteca.mostrarLibrosNoLeidos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
