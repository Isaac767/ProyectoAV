package Clases;

import Clases.Empleado;
import Clases.Paquete;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T17:55:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Entrega.class)
public class Entrega_ { 

    public static volatile SingularAttribute<Entrega, String> fecha;
    public static volatile SingularAttribute<Entrega, String> codigo;
    public static volatile SingularAttribute<Entrega, Empleado> empleado;
    public static volatile SingularAttribute<Entrega, String> observacion;
    public static volatile SingularAttribute<Entrega, Paquete> paquete;

}