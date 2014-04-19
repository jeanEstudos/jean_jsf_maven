package br.com.jsf1.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    
    
    @OneToOne(optional = false)
    @ForeignKey(name = "pessoaEndereco")
  

    
}
