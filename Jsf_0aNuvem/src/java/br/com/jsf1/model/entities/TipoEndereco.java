package br.com.jsf1.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tipoEndereco")
public class TipoEndereco implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idTipoEndereco", nullable = false)
    private long id;
    
     @Column(name = "descTipoEndereco", length = 60)
    private String descricao;
    @OneToMany
    @ForeignKey(name = "tipoEnderecoEndereco")
    private List<Endereco> enderecos;

    public TipoEndereco() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
