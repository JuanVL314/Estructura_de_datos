public abstract class Persona {

    protected String nombre;
    protected String id;
    protected String email;

    public Persona(
            String nombre,
            String id,
            String email) {

        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    // Metodo abstracto
    public abstract void mostrarInformacion();

    // Getters

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