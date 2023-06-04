package entities;

public class Company extends TaxPayer{
	private Integer numberOfEmployees;

	public Company(String name, Double anualIncome) {
		super(name, anualIncome);
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		if(numberOfEmployees > 10) {
			return getAnualIncome() * 0.14;
		}
		return getAnualIncome() * 0.16;
	}
	
}
