package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreasAulaTest {
    @Test
    public void calcularQuadrado(){
        double lado = 3;
        double resultadoEsperado = 9;

        double resultadoAtual = AreasAula.calcularQuadrado(lado);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
}

   @Test
    public void testCalcularRetangulo() {
        double largura = 4;
        double comprimento = 6;
        double resultadoEsperado = 24;


        double resultadoAtual = AreasAula.calcularRetangulo(largura, comprimento);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testCalcularTriangulo() {
        double base = 3;
        double altura = 8;
        double resultadoEsperado = 12;


        double resultadoAtual = AreasAula.calcularTriangulo(base, altura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testCalcularCirculo() {
        double raio = 2;
        double resultadoEsperado = 12.566370614359172;


        double resultadoAtual = AreasAula.calcularCirculo(raio);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }
}


