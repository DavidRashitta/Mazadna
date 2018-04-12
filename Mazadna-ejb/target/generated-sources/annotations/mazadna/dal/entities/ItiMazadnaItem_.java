package mazadna.dal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItiMazadnaItem.class)
public abstract class ItiMazadnaItem_ {

	public static volatile SingularAttribute<ItiMazadnaItem, String> imgurl;
	public static volatile SingularAttribute<ItiMazadnaItem, Long> sold;
	public static volatile SingularAttribute<ItiMazadnaItem, ItiMazadnaUser> supplierid;
	public static volatile SingularAttribute<ItiMazadnaItem, Long> minprice;
	public static volatile SetAttribute<ItiMazadnaItem, ItiMazadnaBidderitem> itiMazadnaBidderitemSet;
	public static volatile SingularAttribute<ItiMazadnaItem, Long> bidincrement;
	public static volatile SingularAttribute<ItiMazadnaItem, String> name;
	public static volatile SingularAttribute<ItiMazadnaItem, String> description;
	public static volatile SingularAttribute<ItiMazadnaItem, ItiMazadnaUser> userid;
	public static volatile SingularAttribute<ItiMazadnaItem, Long> recid;
	public static volatile SetAttribute<ItiMazadnaItem, ItiMazadnaAuctionitem> itiMazadnaAuctionitemSet;

}

