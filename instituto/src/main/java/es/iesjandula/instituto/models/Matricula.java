package es.iesjandula.instituto.models;

import java.util.Objects;

public class Matricula
{
	private String dniAlumno;
	private String idAsignatura;

	/**
	 * 
	 */
	public Matricula()
	{

	}

	/**
	 * @return the dniAlumno
	 */
	public String getDniAlumno()
	{
		return dniAlumno;
	}

	/**
	 * @param dniAlumno the dniAlumno to set
	 */
	public void setDniAlumno(String dniAlumno)
	{
		this.dniAlumno = dniAlumno;
	}

	/**
	 * @return the idAsignatura
	 */
	public String getIdAsignatura()
	{
		return idAsignatura;
	}

	/**
	 * @param idAsignatura the idAsignatura to set
	 */
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
	public boolean equals(Object objetc)
	{
		if (this == objetc)
			return true;
		if (objetc == null)
			return false;
		if (!(objetc instanceof Matricula))
			return false;
		Matricula matricula = (Matricula) objetc;

		return this.dniAlumno == matricula.dniAlumno && this.idAsignatura == matricula.idAsignatura;
	}
}
