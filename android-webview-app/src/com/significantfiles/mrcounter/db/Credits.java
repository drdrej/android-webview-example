package com.significantfiles.mrcounter.db;

import com.significantfiles.mrcounter.Constants;

import android.net.Uri;
import android.provider.BaseColumns;

public class Credits implements BaseColumns {

	public static final String TABLE_NAME = "CREDIT";
	
	public static final String AUTHORITY = Constants.AUTHORITY;
	
    // This class cannot be instantiated
    private Credits() {}

    /**
     * The content:// style URL for this table
     */
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/database");

    /**
     * The MIME type of {@link #CONTENT_URI} providing a directory of notes.
     */
    public static final String CONTENT_TYPE = "mrcounter://";

    /**
     * The MIME type of a {@link #CONTENT_URI} sub-directory of a single note.
     */
    public static final String CONTENT_ITEM_TYPE = "mrcounter://credit";

    /**
     * The default sort order for this table
     */
    public static final String DEFAULT_SORT_ORDER = "modified DESC";

    
    /**
     * 
     * <P>Type: TEXT</P>
     */
    public static final String CREDIT_BY = "creditBy";
    
    /**
     * Reference of Contact (by ID) to have sync with contact.
     * <P>Type: TEXT</P>
     */
    public static final String CREDIT_BY_ID = "creditById";
    
    
    /**
     * <P>Type: REAL</P>
     */
    public static final String CREDIT_VALUE = "creditValue";

    
    /**
     * The timestamp for when the note was created
     * <P>Type: INTEGER (long from System.curentTimeMillis())</P>
     */
    public static final String CREATED_DATE = "createdAt";

    /**
     * The timestamp for when the note was last modified
     * <P>Type: INTEGER (long from System.curentTimeMillis())</P>
     */
    public static final String MODIFIED_DATE = "modifiedAt";
    
    /**
     * The timestamp for when the last payment should be done.
     * <P>Type: INTEGER</P>
     */
    public static final String CREDIT_UNTIL = "creditUntil";
    
    /**
     * The timestamp for when the last payment should be done.
     * <P>Type: INTEGER</P>
     */
    public static final String NR_OF_PAYMENTS = "nrOfPayments";
    
    
}
