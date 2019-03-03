package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHoras;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(workerName, NivelTrabalhador.valueOf(workerLevel), baseSalary,
				new Departamento(departmentName));

		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.println("Date (dd/MM/yyyy: ");
			Date data = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			ContratoHoras contrato = new ContratoHoras(data, valuePerHour, hours);
			trabalhador.adicionaContrato(contrato);

		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int mes = Integer.parseInt(monthAndYear.substring(0,2));
		int ano = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome:  " + trabalhador.getName());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Renda para " + monthAndYear + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
		

		sc.close();
	}

}
