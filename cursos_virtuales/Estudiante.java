
public class Estudiante {


    private int    idEstudiante;
    private String nombre;
    private String correo;
    private String telefono;  

    private Inscripcion[] inscripciones;
    private int totalInscripciones;

    public Estudiante(int idEstudiante, String nombre, String correo, String telefono) {
        this.idEstudiante       = idEstudiante;
        this.nombre             = nombre;
        this.correo             = correo;
        this.telefono           = telefono;
        this.inscripciones      = new Inscripcion[10]; // maximo 10 inscripciones
        this.totalInscripciones = 0;
    }

    public void inscribirseCurso(Curso curso) {
        if (totalInscripciones >= 10) {
            System.out.println("No puedes inscribirte en mas cursos.");
            return;
        }

        Inscripcion nueva = new Inscripcion(this, curso);
        nueva.registrarInscripcion();
        inscripciones[totalInscripciones] = nueva;
        totalInscripciones++;
    }

    public void verCurso() {
        System.out.println("\nCursos de " + nombre + ":");
        if (totalInscripciones == 0) {
            System.out.println("  No tiene cursos.");
            return;
        }
        for (int i = 0; i < totalInscripciones; i++) {
            System.out.println("  - " + inscripciones[i].getCurso().getNombre()
                    + " | Estado: " + inscripciones[i].getEstado());
        }
    }


    public void consultarProgreso() {
        System.out.println("\nProgreso de " + nombre + ":");
        if (totalInscripciones == 0) {
            System.out.println("  Sin registros.");
            return;
        }
        for (int i = 0; i < totalInscripciones; i++) {
            System.out.println("  Curso: " + inscripciones[i].getCurso().getNombre()
                    + " | Nota: " + inscripciones[i].getCalificacion()
                    + " | Estado: " + inscripciones[i].getEstado());
        }
    }

    public Inscripcion getInscripcion(int index) {
        if (index >= 0 && index < totalInscripciones) {
            return inscripciones[index];
        }
        return null;
    }

    public int getTotalInscripciones() { return totalInscripciones; }

    // --- Getters y Setters ---
    public int    getIdEstudiante()  { return idEstudiante; }
    public String getNombre()        { return nombre; }
    public String getCorreo()        { return correo; }
    public String getTelefono()      { return telefono; }

    public void setNombre(String nombre)     { this.nombre    = nombre; }
    public void setCorreo(String correo)     { this.correo    = correo; }
    public void setTelefono(String telefono) { this.telefono  = telefono; }

    @Override
    public String toString() {
        return "Estudiante[" + idEstudiante + "] " + nombre + " | " + correo;
    }
}
