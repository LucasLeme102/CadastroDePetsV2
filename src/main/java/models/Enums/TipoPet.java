package models.Enums;

public enum TipoPet {
    CACHORRO("Cachorro"),GATO("Gato");
    private String tipo;

    TipoPet(String tipo) {
        this.tipo = tipo;
    }
    public static TipoPet tipoDoPet(String tipo){
        for (TipoPet x : values()){
            if(x.getTipo().equalsIgnoreCase(tipo)){
                return x;
            }
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }
}
