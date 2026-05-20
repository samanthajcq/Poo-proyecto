
public class Curso {

    private int        idCurso;
    private String     nombre;
    private String     descripcion;
    private int        duracion;     // en horas
    private int        cupoMaximo;
    private Instructor instructor;  // referencia al instructor asignado

    private String[] contenidos;
    private int      totalContenidos;


    private Estudiante[] estudiantes;
    private int          totalEstudiantes;

    public Curso(int idCurso, String nombre, String descripcion,
                 int duracion, int cupoMaximo) {
        this.idCurso          = idCurso;
        this.nombre           = nombre;
        this.descripcion      = descripcion;
        this.duracion         = duracion;
        this.cupoMaximo       = cupoMaximo;
        this.instructor       = null;
        this.contenidos       = new String[30];
        this.totalContenidos  = 0;
        this.estudiantes      = new Estudiante[cupoMaximo];
        this.totalEstudiantes = 0;
    }

    public void agregarContenido(String tema) {
        if (totalContenidos >= 30) {
            System.out.println("No se pueden agregar mas contenidos.");
            return;
        }
        contenidos[totalContenidos] = tema;
        totalContenidos++;
        System.out.println("  Contenido agregado a '" + nombre + "': " + tema);
    }

    public void mostrarEstudiantes() {
        System.out.println("\nEstudiantes en '" + nombre
                + "' (" + totalEstudiantes + "/" + cupoMaximo + "):");
        if (totalEstudiantes == 0) {
            System.out.println("  (ninguno inscrito)");
            return;
        }
        for (int i = 0; i < totalEstudiantes; i++) {
            System.out.println("  - " + estudiantes[i].getNombre()
                    + " | " + estudiantes[i].getCorreo());
        }
    }


    public void asignarInstructor(Instructor inst) {
        this.instructor = inst;
        System.out.println("  Instructor '" + inst.getNombre()
                + "' asignado a '" + nombre + "'");
    }


    public boolean agregarEstudiante(Estudiante e) {
        if (totalEstudiantes >= cupoMaximo) {
            return false; // sin cupo
        }
        estudiantes[totalEstudiantes] = e;
        totalEstudiantes++;
        return true;
    }

    public int     getCupoDisponible()  { return cupoMaximo - totalEstudiantes; }
    public boolean tieneCupo()          { return totalEstudiantes < cupoMaximo; }

    public int        getIdCurso()      { return idCurso; }
    public String     getNombre()       { return nombre; }
    public String     getDescripcion()  { return descripcion; }
    public int        getDuracion()     { return duracion; }
    public int        getCupoMaximo()   { return cupoMaximo; }
    public Instructor getInstructor()   { return instructor; }

    public void setNombre(String nombre)            { this.nombre      = nombre; }
    public void setDescripcion(String descripcion)  { this.descripcion = descripcion; }
    public void setDuracion(int duracion)           { this.duracion    = duracion; }
    public void setInstructor(Instructor inst)      { this.instructor  = inst; }

    @Override
    public String toString() {
        return "Curso[" + idCurso + "] " + nombre
                + " | Duracion: " + duracion + "h"
                + " | Cupo: " + totalEstudiantes + "/" + cupoMaximo;
    }
}
