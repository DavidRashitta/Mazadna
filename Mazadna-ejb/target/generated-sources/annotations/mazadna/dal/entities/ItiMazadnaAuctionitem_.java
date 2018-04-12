package mazadna.dal.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItiMazadnaAuctionitem.class)
public abstract class ItiMazadnaAuctionitem_ {

	public static volatile SingularAttribute<ItiMazadnaAuctionitem, ItiMazadnaAuctionitemPK> itiMazadnaAuctionitemPK;
	public static volatile SingularAttribute<ItiMazadnaAuctionitem, Long> active;
	public static volatile SingularAttribute<ItiMazadnaAuctionitem, ItiMazadnaAuction> itiMazadnaAuction;
	public static volatile SingularAttribute<ItiMazadnaAuctionitem, ItiMazadnaItem> itiMazadnaItem;

}

