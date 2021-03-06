package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.ClasseColaborador;

public class Colaborador {

	private String nome;
	private ClasseColaborador classeColaborador;
	private Double salarioBase;

	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();

	public Colaborador() {

	}

	public Colaborador(String nome, ClasseColaborador classeColaborador, Double salarioBase,
			Departamento departamento) {
		this.nome = nome;
		this.classeColaborador = classeColaborador;
		this.salarioBase = salarioBase;
		this.departamento = departamento;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ClasseColaborador getClasseColaborador() {
		return classeColaborador;
	}

	public void setClasseColaborador(ClasseColaborador classeColaborador) {
		this.classeColaborador = classeColaborador;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<HoraContrato> contratos) {
		this.contratos = contratos;
	}

	public Double rendimento(int ano, int mes) {
		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance();
		for (HoraContrato c : contratos) {
			calendario.setTime(c.getData());
			int c_ano = calendario.get(Calendar.YEAR);
			int c_mes = 1 + calendario.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.totalContratos();
			}
		}

		return soma;
	}

}
