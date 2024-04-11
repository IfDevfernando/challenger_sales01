package challenger_sale01.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import challenger_sale01.entities.Sale;
import challenger_sale01.reportings.SaleReporting;

public class Main {

	public static void main(String[] args)   {
		
		
		System.out.println("============= CHALLENGER SALE 01 ==============");
		
		String path ="C:\\Users\\usedo\\OneDrive\\Documentos\\curso_devSuperiro_spring\\Java_Devsuperiror_expert\\un.csv";
		
		
		try (BufferedReader br= new BufferedReader(new FileReader (path))){
			
			SaleReporting report = new SaleReporting();
			
			List<Sale> sales = new ArrayList<>();
			
			String line;
				while((line = br.readLine()) != null) {
					
					
					String[] parts = line.split(",");
					
					if(parts.length == 5) {
					String seller = parts[2];
					int month = Integer.parseInt(parts[0]);
					int year = Integer.parseInt(parts[1]);
					int items = Integer.parseInt(parts[3]);
					double total = Double.parseDouble(parts[4]);
					Sale sale = new Sale(month, year, seller, items, total);
					sales.add(sale);
					}
				}
				
				List<Sale> top5 = report.top5Sales(sales);
				
				System.out.println("top 5:");
				
				for(Sale sal: top5) {
					System.out.println(sal.toString());
					
				}
				double total = report.totalSale(sales, "Logan", 1,7);
				
				System.out.println("Total value sold by seller Logan in months 1 and 7: "+total);
					
		}
		catch(IOException e) {
			System.out.println("ERROR "+e.getMessage());
			
		}
		
		
		
		

	}

}
