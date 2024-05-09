package Clases;

import Clases.Paquete;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T17:55:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, Date> fecha;
    public static volatile SingularAttribute<Estado, Integer> tipo;
    public static volatile SingularAttribute<Estado, String> estado;
    public static volatile SingularAttribute<Estado, Integer> id;
    public static volatile SingularAttribute<Estado, String> observacion;
    public static volatile SingularAttribute<Estado, Paquete> paquete;

}