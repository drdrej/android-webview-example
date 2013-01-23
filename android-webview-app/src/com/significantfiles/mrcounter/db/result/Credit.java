package com.significantfiles.mrcounter.db.result;

public interface Credit {

	@QueryRef( field ="_ID", converter=DefautInteger2IntConverter.class )
	public int id();
	
	
	
	
	
	
}
