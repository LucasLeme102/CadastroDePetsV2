package Repository;

import ConnectionDb.ConnectionFactory;
import models.Pet;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class PetRepository {


    public static void save(Pet pet){
        log.info("Salvando Pet '{}'",pet);
        try(Connection conn = ConnectionFactory.getConnectiob();
        PreparedStatement ps = savePetPrepared(conn,pet)){

            ps.execute();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static PreparedStatement savePetPrepared(Connection connection,Pet pet) throws SQLException {
        String sql = """
    INSERT INTO pets (nome, tipopet, sexo, raca, peso, cidade, rua, numerodaresidencia, idade,sobrenome)
    VALUES (?,?,?,?,?,?,?,?,?,?);
""";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,pet.getNome());

        ps.setString(2,pet.getTipoPet());
        ps.setString(3,pet.getSexo());
        ps.setString(4,pet.getRaca());
        ps.setDouble(5,pet.getPeso());
        ps.setString(6,pet.getCidade());
        ps.setString(7,pet.getRua());
        ps.setInt(8,pet.getNumeroResidencia());
        ps.setInt(9,pet.getIdade());
        ps.setString(10,pet.getSobrenome());


        return ps;
    }
    public static void update(Pet pet){
        log.info("Atualizando Pet '{}'",pet);
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedStatementUpdate(connection,pet)){
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static PreparedStatement PreparedStatementUpdate(Connection connection,Pet pet) throws SQLException {
        String sql = """
                UPDATE pets
                SET nome=?,
                sobrenome=?,
                tipopet=?,
                sexo = ?,
                raca= ?,
                peso= ?,
                cidade= ?,
                rua= ?,
                numerodaresidencia=?,
                idade= ?
                WHERE idPet= ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,pet.getNome());
        ps.setString(2,pet.getSobrenome());
        ps.setString(3,pet.getTipoPet());
        ps.setString(4,pet.getSexo());
        ps.setString(5,pet.getRaca());
        ps.setDouble(6,pet.getPeso());
        ps.setString(7,pet.getCidade());
        ps.setString(8,pet.getRua());
        ps.setInt(9,pet.getNumeroResidencia());
        ps.setInt(10,pet.getIdade());
        ps.setInt(11,pet.getId());
        return ps;
    }
    public static void delete(int id){

        try(Connection conn = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedStatementDelete(conn,id)){
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static PreparedStatement PreparedStatementDelete(Connection connection,int id) throws SQLException {
        String sql = """
                DELETE FROM pets
                WHERE idPet = ?;
                """;
        PreparedStatement preparedStatement =  connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        return preparedStatement;
    }
    public static List<Pet> findByName(String nome){
        log.info("Buscando por '{}';",nome);
        List<Pet> petList2 = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedStatementFindByName(connection,nome);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pet pet = Pet.builder()
                        .id(rs.getInt("idpet"))
                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .build();
                petList2.add(pet);
            }

        }catch (SQLException e){

        }
        return petList2;

    }
    private static PreparedStatement PreparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM pets WHERE nome like ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,String.format("%%%s%%",name));
        return preparedStatement;
    }
    public static List<Pet> findBySexo(String sexo){
        log.info("buscando pelo sexo: '{}'",sexo);
        List<Pet> petList = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedeStatementSexo(connection,sexo);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pet pet = Pet.builder()
                        .id(rs.getInt("idpet"))
                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .build();
                petList.add(pet);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return petList;
    }
    public static List<Pet> findByIdade(int idade){
        log.info("buscando pela idade: '{}'",idade);
        List<Pet> petList = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedeStatementIdade(connection,idade);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pet pet = Pet.builder()
                        .id(rs.getInt("idpet"))
                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .build();
                petList.add(pet);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return petList;
    }public static List<Pet> findByPeso(float peso){
        log.info("buscando pelo peso: '{}'",peso);
        List<Pet> petList = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedeStatementPeso(connection,peso);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pet pet = Pet.builder()
                        .id(rs.getInt("idpet"))
                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .build();
                petList.add(pet);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return petList;
    }public static List<Pet> findByRaca(String raca){
        log.info("buscando pela raca: '{}'",raca);
        List<Pet> petList = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedeStatementSexo(connection,raca);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pet pet = Pet.builder()

                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .id(rs.getInt("idpet"))
                        .build();
                petList.add(pet);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return petList;
    }public static List<Pet> findByCidade(String cidade){
        log.info("buscando pelo ciade: '{}'",cidade);
        List<Pet> petList = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedeStatementCidade(connection,cidade);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Pet pet = Pet.builder()
                        .id(rs.getInt("idpet"))
                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .build();
                petList.add(pet);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return petList;
    }
    private static PreparedStatement PreparedeStatementSexo(Connection connection,String sexo) throws SQLException {
        String sql = "select * from pets where sexo ilike ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",sexo));
        return ps;
    }
    private static PreparedStatement PreparedeStatementIdade(Connection connection,int idade) throws SQLException {
        String sql = """
                select * from pets where idade = ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,idade);
        return ps;
    }
    private static PreparedStatement PreparedeStatementPeso(Connection connection,double peso) throws SQLException {
        String sql = """
                select * from pets where peso = ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1,peso);
        return ps;
    } private static PreparedStatement PreparedeStatementRaca(Connection connection,String raca) throws SQLException {
        String sql = """
                select * from pets where raca ilike ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",raca));
        return ps;
    }
    private static PreparedStatement PreparedeStatementCidade(Connection connection,String cidade) throws SQLException {
        String sql = """
                select * from pets where cidade ilike ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",cidade));
        return ps;
    }
    public static Optional<Pet> findById(int id){
        log.info("Buscando por id '{}'",id);
        try(Connection connection = ConnectionFactory.getConnectiob();
        PreparedStatement ps = PreparedStatementfindById(connection,id);
        ResultSet rs = ps.executeQuery();){
            if(!rs.next()){
                return Optional.empty();
            }
            return Optional.of(Pet.builder()
                        .id(rs.getInt("idpet"))
                        .nome(rs.getString("nome"))
                        .sobrenome(rs.getString("sobrenome"))
                        .tipoPet(rs.getString("tipopet"))
                        .sexo(rs.getString("sexo"))
                        .cidade(rs.getString("cidade"))
                        .rua(rs.getString("rua"))
                        .numeroResidencia(rs.getInt("numerodaresidencia"))
                        .idade(rs.getInt("idade"))
                        .peso(rs.getFloat("peso"))
                        .raca(rs.getString("raca"))
                        .build());
        }catch (Exception e){
            throw new RuntimeException(e);

        }
    }
    private static PreparedStatement PreparedStatementfindById(Connection connection,int id) throws SQLException {
        String sql = "SELECT * FROM pets WHERE idpet = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        return ps;
    }

}


