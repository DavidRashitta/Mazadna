package mazadna.dal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItiMazadnaBidderitem.class)
public abstract class ItiMazadnaBidderitem_ {

	public static volatile SingularAttribute<ItiMazadnaBidderitem, ItiMazadnaBidderitemPK> itiMazadnaBidderitemPK;
	public static volatile SingularAttribute<ItiMazadnaBidderitem, Long> bidamount;
	public static volatile SingularAttribute<ItiMazadnaBidderitem, Long> winner;
	public static volatile SingularAttribute<ItiMazadnaBidderitem, ItiMazadnaUser> itiMazadnaUser;
	public static volatile SingularAttribute<ItiMazadnaBidderitem, ItiMazadnaItem> itiMazadnaItem;

}

