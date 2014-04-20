package br.com.jsf1.controller;

import br.com.jsf1.model.dao.HibernateDAO;
import br.com.jsf1.model.dao.InterfaceDAO;
import br.com.jsf1.model.entities.Cidade;
import br.com.jsf1.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbCidade")
@SessionScoped
class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public MbCidade() {
    }

    //IterfaceDAO é generico;
    private InterfaceDAO<Cidade> cidadeDAO() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;

    }

    public String limparCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
    }

    public String editCidade() {
        return "/restrict/cadastrarcidade.faces";
    }

    public String addCidade() {
        if (cidade.getId() == 0) {
            insertCidade();
        } else {
            updateCidade();

        }
        limparCidade();
        return null;
    }

    private void insertCidade() {
        cidadeDAO().save(cidade);
        System.out.println("Inserido com sucesso!");
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        System.out.println("Atualizado com sucesso!");
    }
    
    public void deleteCidade(){
        cidadeDAO().remove(cidade);
        System.out.println("Deletado com sucesso!");
    
    
    }
    
    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
}
