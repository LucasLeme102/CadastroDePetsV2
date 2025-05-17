package models;

import models.Enums.Sexo;
import models.Enums.TipoPet;
import models.Exceptions.*;

import java.util.Scanner;

public class PetAtributos {
    static final Scanner scanner = new Scanner(System.in);
    public static String solicitarNome()  {
        String nome;
        do{
            try {
                 nome = scanner.nextLine();
                if(nome.isEmpty()){
                    nome = "Não informado";
                    break;
                }
                if(!nome.matches("^[a-zA-Z\\s]+$")){
                    throw new CaracteresException();

                }
                if (!nome.contains(" ")){
                    throw new NomeInvalidException();


                }
                break;



            } catch (NomeInvalidException e) {
                System.out.println("Nome tem que conter nome e sobrenome");
            } catch (CaracteresException e) {
                System.out.println("Deve conter apenas letras");

            }


        }while(true);
        return nome;
    }

    public static String solicitarTipoPet() {
        String tipoPets;
        do{
            try{
                tipoPets = scanner.nextLine();
                TipoPet tipoDePets = TipoPet.tipoDoPet(tipoPets);
                if(tipoDePets == null ){
                    throw new TipoInvalidoException();
                }
                break;
            } catch (TipoInvalidoException e) {
                System.out.println("Apenas cachorro/gato e macho/femêa");
            }

        }while(true);
        return tipoPets;
    }
    public static String solicitarSexo() {
        String sexoPet;
        do {
            try {
                sexoPet = scanner.nextLine();
                Sexo sexoPet1 = Sexo.sexoPet(sexoPet);
                if(sexoPet1==null ){
                    throw new SexoException();
                }
                break;
            } catch (SexoException e) {
                System.out.println("Apenas macho/femea");
            }
        }while(true);
        return sexoPet;
    }
    public static String solicitarIdade()  {
        String idade;
        do {
            try{
                  idade = scanner.nextLine();
                double idadeEmNumero;
                if(idade.isEmpty()){
                    idade = "Não informado";
                    idadeEmNumero = -1;

                }else{
                    try{
                        idadeEmNumero = Double.parseDouble(idade);

                    }catch (NumberFormatException e){
                        System.out.println("Número inválido");
                        continue;
                    }
                }
                if(idadeEmNumero > 20){
                    throw new IdadeExeception();
                }else if(idadeEmNumero > 0 && idadeEmNumero < 1){
                    double calculo = idadeEmNumero * 10;
                    idade = String.format("%.1f mes(es)",calculo);

                }
                break;

            }catch (IdadeExeception e) {
                System.out.println("Idade até 20");
            }
        }while (true);
        return idade;
    }
    public static String solicitarCidade(){

        System.out.println("Cidade:");
        String cidade = scanner.nextLine();
        return cidade;


    }public static String solicitarRua(){
        System.out.println("Rua:");
        String rua = scanner.nextLine();
        return rua;


    }public static String solicitarNumeroDeResidencia(){
        System.out.println("Número da residência");
        String numero = scanner.nextLine();
        if(numero.isEmpty()){
            numero = "Não informado";
        }
        return numero;


    }
    public static String solicitarRaca()  {
        String raca;
        do {
            try{
                raca = scanner.nextLine();
                if(raca.isEmpty()){
                    raca = "Não informado";
                    break;
                }
                if(!raca.matches("[a-zA-Z\\s]+")){
                    throw new CaracteresException();
                }
                break;
            } catch (CaracteresException e) {
                System.out.println("Apenas letras");
            }
        }while (true);
        return raca;
    }
    public static String solicitarPeso() {
        String peso;
        do {
            try{
                peso = scanner.nextLine();
                double pesoEmKg;
                if(peso.isEmpty()){
                    peso = "Não informado";
                    pesoEmKg = -1;
                    break;
                }else{
                    try{
                        pesoEmKg = Double.parseDouble(peso);

                    }catch (NumberFormatException e){
                        System.out.println("Número inválido");
                        continue;
                    }
                }
                if(pesoEmKg > 60 || pesoEmKg <= 0.5){
                    throw new PesoException();

                }
                break;
            } catch (PesoException e) {
                System.out.println("Peso máximo permitido (60Kg)");
            }

        }while(true);
        return peso;
    }
}
