package org.example.ejercicios;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Facturaciom3 {
	record Factura(String numeroFactura, String cliente, LocalDate fechaFactura, List<Double> precioProducto) {
	}

	public static void main(String[] args) {
		Factura factura1 = new Factura("1","Maria Sanabria", LocalDate.of(1999, Month.JULY, 1), List.of(4500.0D, 5000.0D, 2500.0D));
		Factura factura2 = new Factura("2","Juan Pérez", LocalDate.of(2000, Month.AUGUST, 15), List.of(3500.0D, 6000.0D, 2800.0D));
		Factura factura3 = new Factura("3","José Alfredo Martínez Valdés", LocalDate.of(2023, Month.OCTOBER, 23), List.of(10500.0D, 16000.0D, 12800.0D));
		new MostraFacturacion (factura1);
		new MostraFacturacion (factura2);
		new MostraFacturacion (factura3);

	}

		static class CalculadoraFactura {

		public double calcularTotal(Factura factura) {
			double totalValorFactura = 0.0D;
			for (Double precio : factura.precioProducto ()) {
				totalValorFactura += precio;
			}
			return totalValorFactura;
		}
	}


	static class MostraFacturacion{

		public MostraFacturacion (Factura factura) {
			CalculadoraFactura calculadoraFactura = new CalculadoraFactura ();
			System.out.println(" " );
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
			System.out.println("Factura " + factura.numeroFactura ());
			System.out.println("Fecha: " + factura.fechaFactura);
			System.out.println("Cliente: " + factura.cliente());
			System.out.println("Total: " + calculadoraFactura.calcularTotal (factura));
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
			
		}

	}


}
