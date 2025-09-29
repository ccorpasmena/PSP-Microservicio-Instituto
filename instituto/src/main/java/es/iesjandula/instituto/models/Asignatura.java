package es.iesjandula.instituto.models;

public class Asignatura
{
	private String idAsignatura;
	private String nombre;
	private int numeroCreditos;
	private int horas;

	public Asignatura()
	{

	}

	public String getIdAsignatura()
	{
		return idAsignatura;
	}

	public void setIdAsignatura(String idAsignatura)
	{
		this.idAsignatura = idAsignatura;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public int getNumeroCreditos()
	{
		return numeroCreditos;
	}

	public void setNumeroCreditos(int numeroCreditos)
	{
		this.numeroCreditos = numeroCreditos;
	}

	public int getHoras()
	{
		return horas;
	}

	public void setHoras(int horas)
	{
		this.horas = horas;
	}
}