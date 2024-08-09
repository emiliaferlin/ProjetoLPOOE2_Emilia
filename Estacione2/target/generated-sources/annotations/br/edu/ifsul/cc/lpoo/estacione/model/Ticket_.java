package br.edu.ifsul.cc.lpoo.estacione.model;

import br.edu.ifsul.cc.lpoo.estacione.model.Carro;
import br.edu.ifsul.cc.lpoo.estacione.model.Vaga;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-08T21:38:05", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Carro> carro;
    public static volatile SingularAttribute<Ticket, Vaga> vaga;
    public static volatile SingularAttribute<Ticket, Integer> numero;
    public static volatile SingularAttribute<Ticket, Integer> horaEntrada;
    public static volatile SingularAttribute<Ticket, Double> valorTotal;
    public static volatile SingularAttribute<Ticket, Integer> horaSaida;
    public static volatile SingularAttribute<Ticket, Double> valorHora;
    public static volatile SingularAttribute<Ticket, Integer> id;

}