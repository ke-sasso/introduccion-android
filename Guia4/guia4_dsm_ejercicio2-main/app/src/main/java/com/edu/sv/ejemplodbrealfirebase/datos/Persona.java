package com.edu.sv.ejemplodbrealfirebase.datos;

public class Persona {
    private String dui;
    private String nombre;
    String key;

    //Added by sallanez to complete exercise 2.

    private String birthday;
    private String genre;

    public Persona() {
    }

    public Persona(String dui, String nombre, String birthday,String genre) {
        this.dui = dui;
        this.nombre = nombre;
        this.birthday = birthday;
        this.genre = genre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getBirtday() {return  birthday;};

    public void setBirtday(String birthday) {this.birthday = birthday;}

    public String getGenre() { return genre;}

    public  void setGenre(String genre){ this.genre = genre;}
}
