public abstract class Persona {

    // protected permite que las clases hijas accedan
    protected String nombre;
    protected String id;
    protected String email;

    // Constructor
    public Persona(String nombre, String id, String email) {

        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    // Método abstracto
    // Obliga a las clases hijas a implementarlo
    public abstract void mostrarInformacion();

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}