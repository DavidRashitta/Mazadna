package mazadna.dal.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItiMazadnaAuction.class)
public abstract class ItiMazadnaAuction_ {

	public static volatile SingularAttribute<ItiMazadnaAuction, Date> auctionStart;
	public static volatile SingularAttribute<ItiMazadnaAuction, Date> auctionEnd;
	public static volatile SingularAttribute<ItiMazadnaAuction, Long> approve;
	public static volatile SingularAttribute<ItiMazadnaAuction, Long> recid;
	public static volatile SetAttribute<ItiMazadnaAuction, ItiMazadnaAuctionitem> itiMazadnaAuctionitemSet;

}

