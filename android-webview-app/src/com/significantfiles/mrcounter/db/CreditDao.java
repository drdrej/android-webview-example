package com.significantfiles.mrcounter.db;

import static com.significantfiles.android.sqlite.query.InsertTxChoice.ROLLBACK;

import java.util.Collection;

import com.significantfiles.android.provider.table.OrderBy;
import com.significantfiles.android.sqlite.query.Insert;
import com.significantfiles.android.sqlite.query.QueryType;
import com.significantfiles.android.sqlite.query.SQL;

@DaoConfig( order = OrderBy.ASC )
public interface CreditDao {

	@Insert(table=Credit.class, tx=ROLLBACK)
	public void insertNewCredit(final Credit credit);
	

	/**
	 * @param credit
	 */
	@SQL( type=QueryType.INSERT, query="INSERT INTO Credit ( CREDIT_BY, CREDIT_VALUE, CREATED_AT ) VALUES ( ?1, ?2, ?3 )", path="credit" )
	public void newCredit( final long contactId, final double value, final long createdAt );
	
	@SQL( type=QueryType.SELECT, query="SELECT * FROM Credit WHERE _ID=$id$", path="credit/#" )
	public Credit findCreditById(final long id);
	
	@SQL( type=QueryType.SELECT, query="", path="credit/#" )
	public Collection<Credit> findAllCredits();
	
	
}
