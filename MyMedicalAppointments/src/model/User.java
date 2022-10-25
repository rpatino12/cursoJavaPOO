package model;
// Como no se van a instanciar objetos de la clase 'User', ya que no hacen parte de la logica de nuestro programa, la clase 'User' seria una clase abstracta
// Por esto utilizo la palabra reservada 'abstract'
public abstract class User {
    // Attributes
    static int id = 0;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // Constructor methods
    public User() {
        System.out.println("Nuevo usuario");
        id++;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        id++;
    }

    // Methods
    public void showName(){
        System.out.println("Mi nombre es: " + getName());
    }

    public void showId(){
        System.out.println("El ID correspondiente es: " + getId());
    }

    // Getters and setters
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 10){
            System.out.println("El numero de telefono debe ser maximo de 10 digitos");
        } else if (phoneNumber.length() < 10) {
            System.out.println("El numero de telefono debe ser minimo de 10 digitos");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    // Aqui estamos aplicando la sobreescritura de metodos, lo cual tambien se conoce como 'Polimorfismo'
    // Este metodo toString pertenece a la clase padre 'Object' que por defecto es la clase padre de todos las clases y lo que este metodo devuelve originalmente es el nombre de la clase hija + @ + la direccion donde se encuentra guardado el objeto en memoria
    @Override
    public String toString() {
        return "User: " + name + "\n" + "Email: " + email + "\n" + "Address: " + address + ", Phone: " + phoneNumber;
    }

    // Al ser un método abstracto la clase a la cual pertenece el metodo también debe ser abstracta
    // Además no debe llevar llaves, solamente dejamos el metodo declarado, ademas un metodo sin comportamiento por defecto es un metodo abstracto, ya que unicamente se define su comportamiento en la implementacion del mismo en las clases hijas
    public abstract void showDataUser();
}
