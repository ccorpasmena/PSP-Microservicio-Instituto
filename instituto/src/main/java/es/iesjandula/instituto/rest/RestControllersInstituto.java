package es.iesjandula.instituto.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.instituto.models.Alumno;
import es.iesjandula.instituto.models.Asignatura;
import es.iesjandula.instituto.models.Matricula;
import es.iesjandula.instituto.utils.MiExcepcion;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/instituto")
public class RestControllersInstituto
{
	private List<Alumno> alumnos;
	private List<Asignatura> asignaturas;
	private List<Matricula> matriculas;
	{

	}

	@PostConstruct
	public void init()
	{
		this.alumnos = new ArrayList<Alumno>();
		this.asignaturas = new ArrayList<Asignatura>();
		this.matriculas = new ArrayList<Matricula>();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/asignaturas", consumes = "application/json")
	public ResponseEntity<?> crearAsignatura(@RequestBody(required = true) Asignatura asignatura)
	{
		try
		{
			if (this.asignaturas.contains(asignatura))
			{
				throw new MiExcepcion("Esta asignatura ya existe");
			}

			asignaturas.add(asignatura);

			return ResponseEntity.ok().build();

		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}

	}

	@RequestMapping(value = "/asignaturas", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> modificarAsignatura(@RequestBody(required = true) Asignatura asignatura)
	{
		try
		{
			int indice = this.asignaturas.indexOf(asignatura);

			if (indice == -1)
			{
				throw new MiExcepcion("No existe la asignatura");
			}

			Asignatura asignaturaLista = this.asignaturas.get(indice);

			asignaturaLista.setNombre(asignatura.getNombre());
			asignaturaLista.setHoras(asignatura.getHoras());
			asignaturaLista.setNumeroCreditos(asignatura.getNumeroCreditos());

			return ResponseEntity.ok().build();
		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	@RequestMapping(value = "/asignaturas/{identificador}", method = RequestMethod.DELETE)
	public ResponseEntity<?> borrarAsignatura(@PathVariable("identificador") String identificador)
	{
		try
		{
			int indiceEncontrado = -1;

			int i = 0;
			while (i < this.asignaturas.size() && indiceEncontrado == -1)
			{
				Asignatura asignatura = this.asignaturas.get(i);

				if (asignatura.getIdAsignatura().equals(identificador))
				{
					indiceEncontrado = i;
				}
				i++;
			}

			if (indiceEncontrado == -1)
			{
				throw new MiExcepcion("No existe la asignatura");
			}

			this.asignaturas.remove(indiceEncontrado);

			return ResponseEntity.ok().build();
		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/alumnos", consumes = "application/json")
	public ResponseEntity<?> crearAlumno(@RequestBody(required = true) Alumno alumno)
	{
		try
		{
			if (this.alumnos.contains(alumno))
			{
				throw new MiExcepcion("Este alumno ya existe");
			}

			alumnos.add(alumno);

			return ResponseEntity.ok().build();

		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}

	}

	@RequestMapping(value = "/alumnos", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> modificarAlumno(@RequestBody(required = true) Alumno alumno)
	{
		try
		{
			int indice = this.alumnos.indexOf(alumno);

			if (indice == -1)
			{
				throw new MiExcepcion("No existe el alumno");
			}

			Alumno alumnoLista = this.alumnos.get(indice);

			alumnoLista.setNombre(alumno.getNombre());
			alumnoLista.setApellidos(alumno.getApellidos());
			alumnoLista.setCorreo(alumno.getCorreo());
			alumnoLista.setTelefono(alumno.getTelefono());
			return ResponseEntity.ok().build();
		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	@RequestMapping(value = "/alumnos/{dni}", method = RequestMethod.DELETE)
	public ResponseEntity<?> borrarAlumno(@PathVariable("dni") String dni)
	{
		try
		{
			int indiceEncontrado = -1;

			int i = 0;
			while (i < this.alumnos.size() && indiceEncontrado == -1)
			{
				Alumno alumno = this.alumnos.get(i);

				if (alumno.getDni().equals(dni))
				{
					indiceEncontrado = i;
				}
				i++;
			}

			if (indiceEncontrado == -1)
			{
				throw new MiExcepcion("No existe el alumno");
			}

			this.alumnos.remove(indiceEncontrado);

			return ResponseEntity.ok().build();
		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/matriculas", consumes = "application/json")
	public ResponseEntity<?> crearMatricula(@RequestBody Matricula matricula)
	{
		try
		{
			if (this.matriculas.contains(matricula))
			{
				throw new MiExcepcion("Ya existe esta matrícula.");
			}
			this.matriculas.add(matricula);
			return ResponseEntity.ok().build();
		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	// eliminar matrícula
	@RequestMapping(value = "/matriculas/{dniAlumno}/{idAsignatura}", method = RequestMethod.DELETE)
	public ResponseEntity<?> elimiarMatricula(@PathVariable String dniAlumno, @PathVariable String idAsignatura)
	{
		try
		{
			int indice = -1;
			for (int i = 0; i < matriculas.size(); i++)

			{
				Matricula matricula = matriculas.get(i);
				if (matricula.getDniAlumno().equals(dniAlumno) && matricula.getIdAsignatura().equals(idAsignatura))
				{
					indice = i;
					break;
				}
			}
			if (indice == -1)
			{
				throw new MiExcepcion("Matricula no encontrada");
			}
			matriculas.remove(indice);
			return ResponseEntity.ok().build();

		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	// Asignaturas en las que esta matriculado un alumno
	@RequestMapping(value = "/alumnos/{dniAlumno}/asignaturas", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerAsignaturasDeAlumno(@PathVariable String dniAlumno)
	{
		try
		{
			List<Asignatura> resultadoAsignaturas = new ArrayList<>();
			for (Matricula matricula : matriculas)
			{
				if (matricula.getDniAlumno().equals(dniAlumno))
				{
					for (Asignatura asignatura : asignaturas)
					{
						if (asignatura.getIdAsignatura().equals(matricula.getIdAsignatura()))
						{
							resultadoAsignaturas.add(asignatura);
						}
					}
				}
			}
			if (resultadoAsignaturas.isEmpty())
			{
				throw new MiExcepcion("El alumno no esta matriculado en ninguna asignatura");
			}

			return ResponseEntity.ok(resultadoAsignaturas);
		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}

	// Alumnos matriculados en una asignatura
	@RequestMapping(value = "/asignaturas/{idAsignatura}/alumnos", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerAlumnosAsignatura(@PathVariable String idAsignatura)
	{
		try
		{
			List<Alumno> resultadoAlumnos = new ArrayList<>();
			for (Matricula matricula : matriculas)
			{
				if (matricula.getIdAsignatura().equals(idAsignatura))
				{
					for (Alumno alumno : alumnos)
					{
						if (alumno.getDni().equals(matricula.getDniAlumno()))
						{
							resultadoAlumnos.add(alumno);
						}
					}
				}
			}
			if (resultadoAlumnos.isEmpty())
			{
				throw new MiExcepcion("La asignatura consultada no tiene alumnos matriculados");
			}
			return ResponseEntity.ok(resultadoAlumnos);

		} catch (MiExcepcion miExcepcion)
		{
			return ResponseEntity.badRequest().body(miExcepcion.getMessage());
		}
	}
}
