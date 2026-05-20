
public class Inscripcion {

    private String  fechaInscripcion; // Simplificado: String en lugar de Date
    private String  estado;           // Pendiente, Activa, Aprobado, Reprobado
    private double  calificacion;

    private Estudiante estudiante;    // a quien pertenece
    private Curso      curso;         // en que curso esta

    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.estudiante       = estudiante;
        this.curso            = curso;
        this.fechaInscripcion = java.time.LocalDate.now().toString(); // fecha actual
        this.estado           = "Pendiente";
        this.calificacion     = 0.0;
    }

    public void registrarInscripcion() {
        if (curso.tieneCupo()) {
            curso.agregarEstudiante(estudiante);
            this.estado = "Activa";
            System.out.println("  [OK] " + estudiante.getNombre()
                    + " inscrito en '" + curso.getNombre()
                    + "' (cupo restante: " + curso.getCupoDisponible() + ")");
        } else {
            this.estado = "Rechazada";
            System.out.println("  [X] Sin cupo: " + estudiante.getNombre()
                    + " no pudo inscribirse en '" + curso.getNombre() + "'");
        }
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void mostrarDetalle() {
        System.out.println("  --- Detalle de Inscripcion ---");
        System.out.println("  Estudiante   : " + estudiante.getNombre());
        System.out.println("  Curso        : " + curso.getNombre());
        System.out.println("  Instructor   : "
                + (curso.getInstructor() != null
                   ? curso.getInstructor().getNombre()
                   : "Sin asignar"));
        System.out.println("  Fecha        : " + fechaInscripcion);
        System.out.println("  Estado       : " + estado);
        System.out.println("  Calificacion : " + calificacion);
        System.out.println("  ------------------------------");
    }

    public String     getFechaInscripcion() { return fechaInscripcion; }
    public String     getEstado()           { return estado; }
    public double     getCalificacion()     { return calificacion; }
    public Estudiante getEstudiante()       { return estudiante; }
    public Curso      getCurso()            { return curso; }

    public void setCalificacion(double calificacion) {

        if (calificacion < 0 || calificacion > 10) {
            System.out.println("  [!] Nota invalida. Debe estar entre 0 y 10.");
            return;
        }
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Inscripcion: " + estudiante.getNombre()
                + " -> " + curso.getNombre()
                + " | " + estado
                + " | Nota: " + calificacion;
    }
}
