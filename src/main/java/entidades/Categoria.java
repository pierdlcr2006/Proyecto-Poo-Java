package entidades;
import java.util.Objects;
public class Categoria {
    private int codCategoria;
    private String nomCategoria;
    public Categoria(){
    }
    public Categoria(int codCategoria){
        this.codCategoria=codCategoria;
    }
    public Categoria(int codCategoria,String nomCategoria){
        this(codCategoria);
        this.nomCategoria=nomCategoria;
    }
    public int getCodCategoria() {
        return codCategoria;
    }
    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Categoria categoria = (Categoria) object;
        return codCategoria == categoria.codCategoria && Objects.equals(nomCategoria, categoria.nomCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCategoria, nomCategoria);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "codCategoria=" + codCategoria +
                ", nomCategoria='" + nomCategoria + '\'' +
                '}';
    }
}
