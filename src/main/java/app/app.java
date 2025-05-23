package app;

import Services.PetService;

import java.util.Scanner;

public class app {
    static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        boolean optionValid = false;
        while(!optionValid){
            mostrarMenuPrincipal();
            int choice = SCANNER.nextInt();
            switch (choice){
                case 1 -> PetService.save();
                case 2 -> PetService.update();
                case 3 -> PetService.delete();
                case 4 -> PetService.findByAll();
                case 5 -> Buscas();

            }

        }
    }
    //menus de buscas
    public static void Buscas(){
        System.out.println("Digite o número para respectiva ação");
        menuDeBusca();
        int choice = SCANNER.nextInt();
        switch (choice){
            case 1 -> PetService.findByName();
            case 2 -> PetService.findBySexo();
            case 3 -> PetService.findByIdade();
            case 4 -> PetService.findByPeso();
            case 5 -> PetService.findByRaca();
            case 6 -> PetService.findByCidade();

        }

    }
    public static void mostrarMenuPrincipal(){
        System.out.println("1 - Cadastar Pet ");
        System.out.println("2 - Alterar dados de algum pet cadastrado ");
        System.out.println("3 - Deletar pet cadastrado ");
        System.out.println("4 - Listar todos os pets cadastrados ");
        System.out.println("5 - Buscar pets por algum critério ");

    }
    public static void menuDeBusca(){
        System.out.println("1 -  Nome e/ou Sobrenome");
        System.out.println("2 -  Sexo ");
        System.out.println("3 -  Idade");
        System.out.println("4 -  Peso");
        System.out.println("5 -  Raça");
        System.out.println("6 -  Cidade");

    }
}
