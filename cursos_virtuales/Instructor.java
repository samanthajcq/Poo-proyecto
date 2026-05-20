
public class Instructor {

    private int    idInstructor;
    private String nombre;
    private String especialidad;
    private String correo;

    private Curso[] cursos;
    private int     totalCursos;

    public Instructor(int idInstructor, String nombre,
                      String especialidad, String correo) {
        this.idInstructor = idInstructor;
        this.nombre       = nombre;
        this.especialidad = especialidad;
        this.correo       = correo;
        this.cursos       = new Curso[20]; // maximo 20 cursos
        this.totalCursos  = 0;
    }


    public void impartirCurso(Curso curso) {
        if (totalCursos >= 20) {
            System.out.println("El instructor no puede tomar mas cursos.");
            return;
        }
        curso.setInstructor(this);         // le dice al curso quien es su instructor
        cursos[totalCursos] = curso;
        totalCursos++;
        System.out.println("  " + nombre + " ahora imparte: " + curso.getNombre());
    }


    public Curso crearCurso(int id, String nombre, String descripcion,
                            int duracion, int cupoMaximo) {
        Curso nuevo = new Curso(id, nombre, descripcion, duracion, cupoMaximo);
        impartirCurso(nuevo);
        return nuevo;
    }

    public void evaluarEstudiante(Estudiante estudiante, Curso curso, double nota) {
        // Busca la inscripcion del estudiante en ese curso
        for (int i = 0; i < estudiante.getTotalInscripciones(); i++) {
            Inscripcion ins = estudiante.getInscripcion(i);
            if (ins.getCurso() == curso) {
                ins.setCalificacion(nota);
                if (nota >= 6.0) {
                    ins.actualizarEstado("Aprobado");
                } else {
                    ins.actualizarEstado("Reprobado");
                }
                System.out.println("  " + nombre + " evaluo a " + estudiante.getNombre()
                        + " en '" + curso.getNombre() + "': " + nota
                        + " -> " + ins.getEstado());
                return;
            }
        }
        System.out.println("  [!] " + estudiante.getNombre()
                + " no esta inscrito en '" + curso.getNombre() + "'");
    }

    public int    getIdInstructor() { return idInstructor; }
    public String getNombre()       { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getCorreo()       { return correo; }

    public void setNombre(String nombre)        { this.nombre       = nombre; }
    public void setEspecialidad(String esp)     { this.especialidad = esp; }
    public void setCorreo(String correo)        { this.correo       = correo; }

    @Override
    public String toString() {
        return "Instructor[" + idInstructor + "] " + nombre
                + " | Especialidad: " + especialidad;
    }
}
