package com.modak.fl.enums;

public enum EnumLessonType {

    ENGLISH(Long.valueOf(1), "E", "ENGLISH"),
	MATH(Long.valueOf(2), "M", "MATH");

    private Long id;
    private String name;
    private String descripcion;

    private EnumLessonType(Long id, String name, String descripcion) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}