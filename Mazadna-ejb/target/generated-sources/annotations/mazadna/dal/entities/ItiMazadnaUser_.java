package mazadna.dal.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItiMazadnaUser.class)
public abstract class ItiMazadnaUser_ {

	public static volatile SingularAttribute<ItiMazadnaUser, String> country;
	public static volatile SingularAttribute<ItiMazadnaUser, String> firstname;
	public static volatile SingularAttribute<ItiMazadnaUser, Date> creationdate;
	public static volatile SetAttribute<ItiMazadnaUser, ItiMazadnaItem> itiMazadnaItemSet;
	public static volatile SingularAttribute<ItiMazadnaUser, Long> role;
	public static volatile SingularAttribute<ItiMazadnaUser, Date> birthdate;
	public static volatile SingularAttribute<ItiMazadnaUser, String> city;
	public static volatile SetAttribute<ItiMazadnaUser, ItiMazadnaItem> itiMazadnaItemSet1;
	public static volatile SingularAttribute<ItiMazadnaUser, String> lastname;
	public static volatile SingularAttribute<ItiMazadnaUser, String> password;
	public static volatile SetAttribute<ItiMazadnaUser, ItiMazadnaBidderitem> itiMazadnaBidderitemSet;
	public static volatile SingularAttribute<ItiMazadnaUser, String> creditlimit;
	public static volatile SingularAttribute<ItiMazadnaUser, Long> recid;
	public static volatile SingularAttribute<ItiMazadnaUser, String> email;

}

