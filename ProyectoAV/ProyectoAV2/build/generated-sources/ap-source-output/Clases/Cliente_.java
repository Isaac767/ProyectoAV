package Clases;

import Clases.Direccion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T17:55:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Persona_ {

    public static volatile ListAttribute<Cliente, Direccion> direcciones;
    public static volatile SingularAttribute<Cliente, String> celular;

}