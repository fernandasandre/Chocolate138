package juntos;

public class FormasGeometricas {

        public double calcularAreaQuadrado(double lado) {
            double area = lado * lado;
            return area;
        }

        public double calcularAreaRetangulo(double base, double altura) {
            double area = base * altura;
            return area;
        }

        public double calcularAreaTriangulo(double base, double altura) {
            double area = (base * altura) / 2;
            return area;
        }

        public double calcularAreaCirculo(double raio) {
            double area = Math.PI * raio * raio;
            return area;
        }
    }


