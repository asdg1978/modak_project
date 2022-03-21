package com.modak.fl.enums;

public enum EnumPersonDocumentType {

    DNI(Long.valueOf(1), "DNI", "Identity national document");

    private Long id;
    private String name;
    private String descripcion;

    private EnumPersonDocumentType(Long id, String name, String descripcion) {
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