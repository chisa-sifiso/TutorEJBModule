package za.ac.tut.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-06-12T13:55:15")
@StaticMetamodel(Tutor.class)
public class Tutor_ { 

    public static volatile SingularAttribute<Tutor, Date> date;
    public static volatile SingularAttribute<Tutor, String> gender;
    public static volatile ListAttribute<Tutor, String> subs;
    public static volatile SingularAttribute<Tutor, String> name;
    public static volatile SingularAttribute<Tutor, byte[]> photo;
    public static volatile SingularAttribute<Tutor, Long> id;
    public static volatile SingularAttribute<Tutor, Integer> age;

}