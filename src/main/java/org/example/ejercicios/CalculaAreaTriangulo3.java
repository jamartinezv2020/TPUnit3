package org.example.ejercicios;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class CalculaAreaTriangulo3 {
	public static void main (String[] args) {
		SolicitarBaseAlturaTringulo entradaBaseAltura = new SolicitarBaseAlturaTringulo ();
        Triangulo triangulo = new Triangulo(entradaBaseAltura.base, entradaBaseAltura.altura);
		new CalculadoraAreaTriangulo ();
		new MostraResultadosCalcularAreaTriangulo (triangulo);

	}

	record Triangulo(double base, double altura) {}

	public static class SolicitarBaseAlturaTringulo{
		Scanner entrants = new Scanner (System.in);
		double base;
		double altura;
		public SolicitarBaseAlturaTringulo () {

			System.out.println("Cálculo del área de un triángulo");
			System.out.print("Ingrese la longitud de la base: ");
			this.base = entrants.nextDouble ();
			System.out.print("Ingrese la longitud de la altura: ");
			this.altura = entrants.nextDouble ();

			if ((base < 0) || (altura < 0)) {
				throw new IllegalArgumentException("Para la base y la altura no se permiten cantidades negaativas.");
			}
		}
	}

	static class CalculadoraAreaTriangulo {

		public double calcularArea(double base, double altura) {
            return 0.5 * base * altura;
		}
	}

	static class MostraResultadosCalcularAreaTriangulo{
		public MostraResultadosCalcularAreaTriangulo(Triangulo triangulo){
			CalculadoraAreaTriangulo calculaArea = new CalculadoraAreaTriangulo ();
			double valor_area_triangulo = calculaArea.calcularArea (triangulo.base(), triangulo.altura());
			System.out.println("Altura del triángulo: " + triangulo.base());
			System.out.println("Base del triángulo: " + triangulo.altura());
			System.out.println("Área del triángulo: " + valor_area_triangulo);
		}
	}

}
