package es.iesjandula.instituto.models;

import java.util.Objects;

public class Matricula
{
	private String dniAlumno;
	private String idAsignatura;

	public Matricula()
	{

	}

	public String getDniAlumno()
	{
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno)
	{
		this.dniAlumno = dniAlumno;
	}

	public String getIdAsignatura()
	{
		return idAsignatura;
	}

	public void setIdAsignatura(String idAsignatura)
	{
		this.idAsignatura = idAsignatura;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(dniAlumno, idAsignatura);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Matricula))
			return false;
		Matricula matricula = (Matricula) obj;
		return Objects.equals(this.dniAlumno, matricula.dniAlumno)
				&& Objects.equals(this.idAsignatura, matricula.idAsignatura);
	}
}