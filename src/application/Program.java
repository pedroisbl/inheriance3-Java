package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> payer = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.printf("Tax payer #%d data:\n", i);
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(type == 'i') {
				System.out.println("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				payer.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.println("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				payer.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println("\nTAXES PAID:");
		
		double sum = 0;
		for(TaxPayer tx : payer) {
			System.out.println(tx.getName() + ": $" + String.format("%.2f", tx.tax()));
			sum += tx.tax();
		}
		
		System.out.println("\nTOTAL TAXE: $" + sum);
		
		sc.close();

	}

}
