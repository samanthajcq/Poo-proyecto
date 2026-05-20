public class Curso {

    private int idCurso;
    private String nombre;
    private String descripcion;
    private int duracion;
    private int cupoMaximo;
    private Instructor instructor;
    private String[] contenidos;
    private int totalContenidos;
    private Estudiante[] estudiantes;
    private int totalEstudiantes;
    private String materia;

    public Curso(int idCurso, String nombre, String descripcion,
    int duracion, int cupoMaximo, String materia) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.cupoMaximo = cupoMaximo;
        this.instructor = null;
        this.contenidos = new String[30];
        this.totalContenidos = 0;
        this.estudiantes = new Estudiante[cupoMaximo];
        this.totalEstudiantes = 0;
        this.materia = materia;
    }

    public void agregarContenido(String tema) {
        if (totalContenidos >= 30) {
            System.out.println("No se pueden agregar más contenidos.");
            return;
        }

        contenidos[totalContenidos] = tema;
        totalContenidos++;

        System.out.println("Contenido agregado a '" + nombre + "': " + tema);
    }

    public void mostrarEstudiantes() {

        System.out.println("\nEstudiantes en '" + nombre + "' ("
                + totalEstudiantes + "/" + cupoMaximo + "):");

        if (totalEstudiantes == 0) {
            System.out.println("  (ninguno inscrito)");
            return;
        }

        for (int i = 0; i < totalEstudiantes; i++) {
            System.out.println("  - "
                    + estudiantes[i].getNombre()
                    + " | "
                    + estudiantes[i].getCorreo());
        }
    }

    public void asignarInstructor(Instructor inst) {

        if (inst == null) {
            System.out.println("Instructor no válido.");
            return;
        }

        this.instructor = inst;

        System.out.println("Instructor '" + inst.getNombre()
                + "' asignado a '" + nombre + "'");
    }

    public boolean agregarEstudiante(Estudiante e) {

        if (e == null) {
            return false;
        }

        if (totalEstudiantes >= cupoMaximo) {
            return false;
        }

        estudiantes[totalEstudiantes] = e;
        totalEstudiantes++;

        return true;
    }

    public int getCupoDisponible() {
        return cupoMaximo - totalEstudiantes;
    }

    public boolean tieneCupo() {
        return totalEstudiantes < cupoMaximo;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getMateria() {
        return materia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setInstructor(Instructor inst) {
        this.instructor = inst;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {

        String nombreInstructor =
                (instructor != null)
                        ? instructor.getNombre()
                        : "Sin instructor";

        return "Curso[" + idCurso + "] "+ nombre + " | Materia: " + materia+ " | Duración: " + duracion + "h"+ " | Instructor: " + nombreInstructor + " | Cupo: " + totalEstudiantes + "/" + cupoMaximo;
    }
}
