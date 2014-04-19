package br.com.jsf1.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "idEndereco", length = 30, nullable = false)
    private Long idEndereco;
    @Column(name = "enderecoBairro", length = 80)
    private String Bairro;
    @Column(name = "enderecoCEP", length = 30)
    private String CEP;
    @Column(name = "enderecoComplemento", length = 60)
    private String complemento;
    @Column(name = "enderecoNomeLogradouro", length = 60)
    private String nomeLogradouro;
    @Column(name = "enderecoNumero")
    private Integer numero;

    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "pessoaEndereco")
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "enderecoTipoLogradouro")
    @JoinColumn(name = "idTipoLogradouro", referencedColumnName = "idTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "enderecoCidade")
    @JoinColumn(name = "idCidade", referencedColumnName = "idCidade")
    private Cidade cidade;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "enderecoTipoEndereco")
    @JoinColumn(name = "idTipoEndereco", referencedColumnName = "idTipoEndereco")
    private TipoEndereco tipoEndereco;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "enderecoEstado")
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    private Estado estado;

    
    // iniciar lado que tiver many
    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoEndereco = new TipoEndereco();
        this.tipoLogradouro = new TipoLogradouro();
        this.pessoa = new Pessoa();
        
    }

    
    
    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    
}
