package es.iesjandula.instituto.models;

public class Alumno
{
	private String dni;
	private String nombre;
	private String apellidos;
	private String correo;
	private int telefono;

	public Alumno()
	{

	}

	public String getDni()
	{
		return dni;
	}

	public void setDNI(String dNI)
	{
		dni = dNI;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellidos()
	{
		return apellidos;
	}

	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}

	public String getCorreo()
	{
		return correo;
	}

	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	public int getTelefono()
	{
		return telefono;
	}

	public void setTelefono(int telefono)
	{
		this.telefono = telefono;
	}

}
