package br.com.jsf1.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tipoLogradouro")
public class TipoLogradouro implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idTipoLogradouro", nullable = false)
    private long id;
    @Column(name = "descricaoTipoLogradouro", length = 60)
    private String descricao;
    @OneToMany(mappedBy = "tipoLogradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "enderecoTipoLogradouro")
    private List<Endereco> enderecos;

    public TipoLogradouro() {
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
        int hash = 5;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
