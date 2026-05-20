
public class Main {

    public static void main(String[] args) {

        linea("1. INSTRUCTORES");
        Instructor garcia   = new Instructor(1, "Prof. Garcia",
                                             "Programacion", "garcia@uni.edu");
        Instructor martinez = new Instructor(2, "Prof. Martinez",
                                             "Bases de Datos", "martinez@uni.edu");
        System.out.println("  " + garcia);
        System.out.println("  " + martinez);

        linea("2. CREACION DE CURSOS");
        Curso java  = garcia.crearCurso(101, "Java Basico",
                         "Introduccion a Java", 40, 3);
        Curso bd    = martinez.crearCurso(102, "Bases de Datos",
                         "SQL y modelado", 35, 2);
        Curso web   = garcia.crearCurso(103, "Desarrollo Web",
                         "HTML, CSS y JS", 30, 2);

        linea("3. CONTENIDO DE CURSOS");
        java.agregarContenido("Variables y tipos de datos");
        java.agregarContenido("Clases y objetos");
        java.agregarContenido("Herencia y polimorfismo");
        bd.agregarContenido("Modelo relacional");
        bd.agregarContenido("Consultas SQL basicas");
        web.agregarContenido("Estructura HTML5");

        linea("4. ESTUDIANTES");
        Estudiante ana    = new Estudiante(1, "Ana Lopez",
                                           "ana@mail.com",    "0991234567");
        Estudiante carlos = new Estudiante(2, "Carlos Ruiz",
                                           "carlos@mail.com", "0997654321");
        Estudiante marta  = new Estudiante(3, "Marta Diaz",
                                           "marta@mail.com",  "0993456789");
        Estudiante pedro  = new Estudiante(4, "Pedro Mora",
                                           "pedro@mail.com",  "0996543210");
        System.out.println("  " + ana);
        System.out.println("  " + carlos);
        System.out.println("  " + marta);
        System.out.println("  " + pedro);

        linea("5. INSCRIPCIONES");
        ana.inscribirseCurso(java);
        ana.inscribirseCurso(bd);
        carlos.inscribirseCurso(java);
        carlos.inscribirseCurso(web);
        marta.inscribirseCurso(bd);    // bd: cupo lleno aqui
        pedro.inscribirseCurso(bd);    // Pedro sera RECHAZADO por falta de cupo
        pedro.inscribirseCurso(web);

        linea("6. LISTA DE ESTUDIANTES POR CURSO");
        java.mostrarEstudiantes();
        bd.mostrarEstudiantes();
        web.mostrarEstudiantes();

        linea("7. EVALUACIONES");
        garcia.evaluarEstudiante(ana,    java, 9.0);
        martinez.evaluarEstudiante(ana,  bd,   7.5);
        garcia.evaluarEstudiante(carlos, java, 5.0);   // reprobado
        garcia.evaluarEstudiante(carlos, web,  8.5);
        martinez.evaluarEstudiante(marta,bd,   6.5);
        garcia.evaluarEstudiante(pedro,  web,  7.0);
        // Caso de error: Pedro no esta en bd
        martinez.evaluarEstudiante(pedro, bd,  8.0);

        linea("8. PROGRESO ACADEMICO");
        ana.consultarProgreso();
        carlos.consultarProgreso();
        marta.consultarProgreso();
        pedro.consultarProgreso();

        linea("9. CURSOS POR ESTUDIANTE");
        ana.verCurso();
        carlos.verCurso();

        linea("10. DETALLE DE INSCRIPCION");
        Inscripcion primeraDeAna = ana.getInscripcion(0);
        if (primeraDeAna != null) {
            primeraDeAna.mostrarDetalle();
        }
    }

    private static void linea(String titulo) {
        System.out.println("\n==========================================");
        System.out.println("  " + titulo);
        System.out.println("==========================================");
    }
}
