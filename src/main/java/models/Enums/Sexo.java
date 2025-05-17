package models.Enums;

public enum Sexo {
    MACHO("Macho"),FEMEA("Femea");
    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }
    public static Sexo sexoPet(String sexo){
        for(Sexo s : values()){
          if(s.getSexo().equalsIgnoreCase(sexo)){
              return s;
          }
        }
        return null;
    }

    public String getSexo() {
        return sexo;
    }
}
