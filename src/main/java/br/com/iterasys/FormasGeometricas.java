package br.com.iterasys;

import static java.lang.Math.PI;

public class FormasGeometricas {
    public static double quadrado(double largura){
        double areaQuadrado = largura * largura;
        System.out.println("Area do quadrado largura " + largura + " é = " + areaQuadrado);
        return areaQuadrado;
    }

    public static double retangulo(double base, double altura){
        double areaRetangulo = base * altura;
        System.out.println("Area do retangulo base " + base + " e altura " + altura + " é = " + areaRetangulo);
        return areaRetangulo;
    }

    public static double triangulo(double baseTriangulo, double alturaTriangulo){
        double areaTriangulo = (baseTriangulo * alturaTriangulo)/2;
        System.out.println("Area do triangulo base " + baseTriangulo + " e altura " + alturaTriangulo + " é = " + areaTriangulo);
        return areaTriangulo;
    }

    public static double circulo(double raio){
        double pi = PI;
        double areaCirculo = pi * (raio * raio);
        System.out.println("Area do círculo raio " + raio + " é = " + areaCirculo);
        return areaCirculo;
    }
}
