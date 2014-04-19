package br.com.jsf1.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

public class PhaseListenerJsf1 implements PhaseListener {

    // antes da fase
    // Iniciar transação; obter sessao do hibernate; abrir sessao hibernate;
    // iniciar trasação e colocar no mapa da requisição a sessao do hibernate
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Antes da fase: " + getPhaseId());
        //Se tiver tentando restaurar a visão, vai abrir uma sessão do hibernate
        //   iniciar uma transação e vai setar na request uma sessão do hibernate
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            FacesContextUtil.setRequestSession(sessao);


        }

    }
    //depois da fase

    // comitar transação, caso erro rollback e fechar sessão;
    @Override
    public void beforePhase(PhaseEvent fase) {

        System.out.println("Depois da fase: " + getPhaseId());

        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session sessao = FacesContextUtil.getRequestSession();
            try {
                sessao.getTransaction().commit();

            } catch (Exception e) {

                if (sessao.getTransaction().isActive()) {

                    sessao.getTransaction().rollback();
                }
            } finally {
                sessao.close();

            }





        }

    }

    //Gerenciar fechamento de sessao com o banco de dados
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
