package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class FormasGeometricas2TestDD {

    @DataProvider(name = "MassaTesteQuadrado")

    public Object[][] massaTesteQuadrado(){
        return new Object[][]{
                {5.0, 25.0},
                {2.0, 4.0},
                {20.0, 400.0}
        };
    }

    @Test(dataProvider = "MassaTesteQuadrado")
    public void testeQuadrado(double largura,double resultadoEsperado) {
        // Arrange
        //Os dados vem da lista

        // Act
        double resultadoAtual = FormasGeometricas.quadrado(largura);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @DataProvider(name = "MassaTesteRetangulo")

    public Object[][] massaTesteRetangulo(){
        return new Object[][]{
                {5.0, 7.0, 35.0},
                {2.0, 4.0, 8.0},
                {10.0, 20.0, 200.0}
        };
    }

    @Test(dataProvider = "MassaTesteRetangulo")
    public void testeRetangulo(double base, double altura, double resultadoEsperado) {
        // Arrange
        // Os dados vem da lista

        // Act
        double resultadoAtual = FormasGeometricas.retangulo(base, altura);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @DataProvider(name = "MassaTesteTriangulo")

    public Object[][] massaTesteTriangulo(){
        return new Object[][]{
                {5.0, 7.0, 17.5},
                {2.0, 4.0, 4.0},
                {10.0, 20.0, 100.0}
        };
    }

    @Test(dataProvider = "MassaTesteTriangulo")
    public void testeTriangulo(double baseTriangulo, double alturaTriangulo, double resultadoEsperado) {
        // Arrange
        // Os dados vem da lista

        // Act
        double resultadoAtual = FormasGeometricas.triangulo(baseTriangulo, alturaTriangulo);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @DataProvider(name = "MassaTesteCirculo")

    public Object[][] massaTesteCirculo(){
        return new Object[][]{
                {5.0, 78.53981633974483},
                {2.0, 12.566370614359172},
                {10.0, 314.1592653589793}
        };
    }
    @Test(dataProvider = "MassaTesteCirculo")
    public void testeCirculo(double raio, double resultadoEsperado) {
        // Arrange
        // Os dados vem da lista

        // Act
        double resultadoAtual = FormasGeometricas.circulo(raio);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

}
