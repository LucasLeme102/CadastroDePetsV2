package Services;

import models.Pet;
import Repository.PetRepository;
import models.PetAtributos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PetService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void save(){
        Path path = Paths.get("/Users/lucasleme/java/DesafioCadastroPets2.0/src/main/java/utils/Formulario.txt");

        try{
            String nomeCompleto = "";
            String nome ="";
            String sobrenome="";
            String tipo = "";
            String sexo = "";
            String cidade = "";
            String rua = "";
            String numeroCasa = "";
            String idade = "";
            String peso = "";
            String raca = "";
            List<String> perguntas = Files.readAllLines(path);

            for(String linha : perguntas){
                if(linha.startsWith("1")){
                    System.out.println(linha);
                     nomeCompleto = PetAtributos.solicitarNome();
                     String[]partes = nomeCompleto.split(" ");
                     if(partes.length >=2 ){
                         nome=partes[0];
                         sobrenome=partes[1];
                     }

                } else if (linha.startsWith("2")) {
                    System.out.println(linha);
                    tipo = PetAtributos.solicitarTipoPet();
                }else if (linha.startsWith("3")) {
                    System.out.println(linha);
                    sexo = PetAtributos.solicitarSexo();
                }else if (linha.startsWith("4")) {
                    System.out.println(linha);
                    cidade = PetAtributos.solicitarCidade();
                    rua = PetAtributos.solicitarRua();
                    numeroCasa = PetAtributos.solicitarNumeroDeResidencia();
                }else if (linha.startsWith("5")) {
                    System.out.println(linha);
                    idade = PetAtributos.solicitarIdade();
                }else if (linha.startsWith("6")) {
                    System.out.println(linha);
                    peso = PetAtributos.solicitarPeso();
                }else if (linha.startsWith("7")) {
                    System.out.println(linha);
                    raca = PetAtributos.solicitarRaca();
                }
            }
            Pet build = Pet.builder()
                    .nome(nome)
                    .sobrenome(sobrenome)
                    .tipoPet(tipo)
                    .sexo(sexo)
                    .cidade(cidade)
                    .rua(rua)
                    .numeroResidencia(Integer.parseInt(numeroCasa))
                    .idade(Integer.parseInt(idade))
                    .peso(Double.parseDouble(peso))
                    .raca(raca)
                    .build();
            PetRepository.save(build);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(){
        findByAll();
        System.out.println("Digite o id do pet que seja deletar");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Deseja mesmo deletar? S/N");
        String choice = SCANNER.nextLine();
        if(choice.equalsIgnoreCase("s")){
            PetRepository.delete(id);
            System.out.println("Pet deletado");
        }else if(choice.equalsIgnoreCase("n")){
            System.out.println("nenhum pet deletado");

        }

    }
    public static void update(){
        findByAll();
        System.out.println("Digite o id que deseja alterar");
        Optional<Pet> petOptional = PetRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if(petOptional.isEmpty()){
            System.out.println("Id inválido");
            return;
        }
        Pet petFromDB = petOptional.get();
        System.out.println("pet "+petFromDB);
        System.out.println("Digite um novo nome: ");
        String neoNome = SCANNER.nextLine();
        neoNome = neoNome.isEmpty() ? petFromDB.getNome() : neoNome;
        System.out.println("Digite um novo Sobrenome: ");
        String neoSobrenome = SCANNER.nextLine();
        neoSobrenome = neoSobrenome.isEmpty() ? petFromDB.getNome() : neoSobrenome;
        System.out.println("Digite o nome da nova cidade: ");
        String neoCidade = SCANNER.nextLine();
        neoCidade = neoCidade.isEmpty() ? petFromDB.getNome() : neoCidade;
        System.out.println("Digite um novo peso: ");
        double neoPeso = SCANNER.nextDouble();
        System.out.println("Digite uma nova idade: ");
        int neoIdade = SCANNER.nextInt();
        Pet petUpdate = Pet.builder()
                .id(petFromDB.getId())
                .nome(neoNome)
                .sobrenome(neoSobrenome)
                .cidade(neoCidade)
                .idade(neoIdade)
                .peso(neoPeso)
                .build();
        PetRepository.update(petUpdate);

    }

    public static void findByName(){
        System.out.println("digite o nome/sobrenome que deseja procurar");
        String choice = SCANNER.nextLine();
        PetRepository.findByName(choice).forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));
    }

    public static void findBySexo(){
        System.out.println("digite o sexo que deseja procurar");
        String choice = SCANNER.nextLine();
        PetRepository.findBySexo(choice).forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));
    }

    public static void findByIdade(){
        System.out.println("digite o idade que deseja procurar");
        int choice = SCANNER.nextInt();
        PetRepository.findByIdade(choice).forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));
    }

    public static void findByPeso(){
        System.out.println("digite o nome/sobrenome que deseja procurar");
        float choice = SCANNER.nextFloat();
        PetRepository.findByPeso(choice).forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));

    }

    public static void findByRaca(){
        System.out.println("digite a raça que deseja procurar");
        String choice = SCANNER.nextLine();
       PetRepository.findByRaca(choice).forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));
    }


    public static void findByCidade(){
        System.out.println("digite a cidade que deseja procurar");
        String choice = SCANNER.nextLine();
       PetRepository.findByCidade(choice).forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));
    }


    public static void findByAll(){
        PetRepository.findByName("").forEach(p ->  System.out.printf("[%d] - %s%n",p.getId(),p.getNome()));
    }

}
