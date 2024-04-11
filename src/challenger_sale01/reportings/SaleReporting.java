package challenger_sale01.reportings;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import challenger_sale01.entities.Sale;

public class SaleReporting {
	
	
	public List<Sale> top5Sales(List<Sale> sales){
		
		return sales.stream()
				.filter(sale -> sale.getYear() == 2016)
				.sorted(Comparator.comparingDouble(Sale::averagePrice).reversed()).limit(5)
				.collect(Collectors.toList());
	}
	
	public double totalSale(List<Sale> sales,String seller,int... months) {
		return sales.stream()
		.filter(sale -> sale.getSeller().equals(seller) && containsMoth(sale.getMonth(),months ))
		.mapToDouble(Sale :: getTotal)
		.sum();
	}
	
	private boolean containsMoth(int month,int[] months) {
		
		for(int m : months) {
			if(month == m) {
				return true;
			}
		}
		return false;
	}

}
