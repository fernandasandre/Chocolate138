package br.com.iterasys;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FormasGeometricasGPTTest {

        @Test
        public void testCalcularAreaQuadrado() {
            // Arrange
            double lado = 5.0;
            double areaEsperada = 25.0;

            // Act
            double areaCalculada = FormasGeometricas.quadrado(lado);

            // Assert
            Assert.assertEquals(areaCalculada, areaEsperada);
        }

        @Test
        public void testCalcularAreaRetangulo() {
            // Arrange
            double base = 5.0;
            double altura = 7.0;
            double areaEsperada = 35.0;

            // Act
            double areaCalculada = FormasGeometricas.retangulo(base, altura);

            // Assert
            Assert.assertEquals(areaCalculada, areaEsperada);
        }

        @Test
        public void testCalcularAreaTriangulo() {
            // Arrange
            double base = 5.0;
            double altura = 7.0;
            double areaEsperada = 17.5;

            // Act
            double areaCalculada = FormasGeometricas.triangulo(base, altura);

            // Assert
            Assert.assertEquals(areaCalculada, areaEsperada);
        }

        @Test
        public void testCalcularAreaCirculo() {
            // Arrange
            double raio = 2.5;
            double areaEsperada = 19.634954084936208;

            // Act
            double areaCalculada = FormasGeometricas.circulo(raio);

            // Assert
            Assert.assertEquals(areaCalculada, areaEsperada);
        }
    }



