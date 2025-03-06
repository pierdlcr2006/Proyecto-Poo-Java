package entidades;
import java.util.Objects;
public class Provedor {
    private int codProvedor;
    private String nomProvedor;
    private String ruc;
    public Provedor(){

    }
    public Provedor(int codProvedor){
        this.codProvedor = codProvedor;
    }
    public Provedor(int codProvedor,String nomProvedor,String ruc){
        this(codProvedor);
        this.nomProvedor=nomProvedor;
        this.ruc=ruc;
    }

    public int getCodProvedor() {
        return codProvedor;
    }

    public void setCodProvedor(int codProvedor) {
        this.codProvedor = codProvedor;
    }

    public String getNomProvedor() {
        return nomProvedor;
    }

    public void setNomProvedor(String nomProvedor) {
        this.nomProvedor = nomProvedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Provedor provedor = (Provedor) object;
        return codProvedor == provedor.codProvedor && Objects.equals(nomProvedor, provedor.nomProvedor)
                && Objects.equals(ruc, provedor.ruc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProvedor, nomProvedor, ruc);
    }
    @Override
    public String toString() {
        return "Provedor{" +
                "codProvedor=" + codProvedor +
                ", nomProvedor='" + nomProvedor + '\'' +
                ", ruc='" + ruc + '\'' +
                '}';
    }
}
