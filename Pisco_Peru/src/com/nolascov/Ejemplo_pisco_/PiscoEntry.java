package com.nolascov.Ejemplo_pisco_;
// esta clase es un registro que contiene los campos
public class PiscoEntry {
	
	 private final String nombre;
	    private final String descripcion;
	    private final String ingredientes;
	    private final String preparacion;
	    private final int    picture;
	    private final int    icon;

	    public PiscoEntry( final String nom, final String desc,
	                       final String ing, final String prep,
	                       final int pict, final int ico ) {
	        nombre = nom;
	        descripcion = desc;
	        ingredientes = ing;
	        preparacion = prep;
	        picture = pict;
	        icon = ico;
	    }
	    public String getTitle() {
	        return nombre;
	    }
	    public String getAuthor() {
	        return descripcion;
	    }
	    public int getIcon() {
	        return icon;
	    }
}
