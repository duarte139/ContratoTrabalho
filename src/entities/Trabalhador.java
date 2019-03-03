package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String name;
	private NivelTrabalhador nivel;
	private Double salary;

	private Departamento departamento;
	private List<ContratoHoras> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String name, NivelTrabalhador nivel, Double salary, Departamento departamento) {
		this.name = name;
		this.nivel = nivel;
		this.salary = salary;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHoras> getList() {
		return contratos;
	}

	public void adicionaContrato(ContratoHoras contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(ContratoHoras contrato) {
		contratos.remove(contrato);
	}

	public double renda(int ano, int mes) {
		double sum = salary;
		Calendar cal = Calendar.getInstance();
		for (ContratoHoras c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
