package juntos;

public class CalculadoraAreas {

        public static void main(String[] args) {
            FormasGeometricas formas = new FormasGeometricas();

            double ladoQuadrado = 5.0;
            double areaQuadrado = formas.calcularAreaQuadrado(ladoQuadrado);
            System.out.println("Area do quadrado: " + areaQuadrado);

            double baseRetangulo = 5.0;
            double alturaRetangulo = 7.0;
            double areaRetangulo = formas.calcularAreaRetangulo(baseRetangulo, alturaRetangulo);
            System.out.println("Area do retângulo: " + areaRetangulo);

            double baseTriangulo = 5.0;
            double alturaTriangulo = 7.0;
            double areaTriangulo = formas.calcularAreaTriangulo(baseTriangulo, alturaTriangulo);
            System.out.println("Area do triângulo: " + areaTriangulo);

            double raioCirculo = 2.5;
            double areaCirculo = formas.calcularAreaCirculo(raioCirculo);
            System.out.println("Area do círculo: " + areaCirculo);
        }
    }


