package Clases;

import Clases.Entrega;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T17:55:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, String> descripcion;
    public static volatile SingularAttribute<Paquete, String> codigo;
    public static volatile SingularAttribute<Paquete, Integer> idpaq;
    public static volatile SingularAttribute<Paquete, Integer> peso;
    public static volatile SingularAttribute<Paquete, Entrega> entrega;
    public static volatile SingularAttribute<Paquete, Integer> alto;
    public static volatile ListAttribute<Paquete, String> estados;

}