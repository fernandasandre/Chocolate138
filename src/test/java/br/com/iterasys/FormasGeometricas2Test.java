package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FormasGeometricas2Test {

    @Test
    public void testeQuadrado() {
        // Arrange
        double largura = 5.0;
        double resultadoEsperado = 25.0;

        // Act
        double resultadoAtual = FormasGeometricas.quadrado(largura);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeRetangulo() {
        // Arrange
        double base = 5.0;
        double altura = 7.0;
        double resultadoEsperado = 35.0;

        // Act
        double resultadoAtual = FormasGeometricas.retangulo(base, altura);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeTriangulo() {
        // Arrange
        double baseTriangulo = 5.0;
        double alturaTriangulo = 7.0;
        double resultadoEsperado = 17.5;

        // Act
        double resultadoAtual = FormasGeometricas.triangulo(baseTriangulo, alturaTriangulo);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeCirculo() {
        // Arrange
        double raio = 2.5;
        double resultadoEsperado = 19.634954084936208;

        // Act
        double resultadoAtual = FormasGeometricas.circulo(raio);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

}
