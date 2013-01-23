package com.significantfiles.mrcounter;



/**
 * Wie arbeitet man mit Datenbanken unter Android?
 * 
 * http://www.higherpass.com/Android/Tutorials/Accessing-Data-With-Android-Cursors/
 * @author asiebert
 *
 */
// https://freekeywords.wordtracker.com/searches/loveletter%20app?adult=1
public class IndexActivity {
	
//
//extends Activity {
//
//	private static final int PICK_CONTACT = 3;
//
//	/** Called when the activity is first created. */
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		final Window window = getWindow();
//		window.setFormat(PixelFormat.RGBA_8888);
//		super.onCreate(savedInstanceState);
//
//		setContentView(R.layout.main);
//
//		prepareContactView();
//		prepareValueView();
//		prepareSaveCreditButton();
//		// search provider widget
//		// create credit contract
//		// credit-request
//	}
//
//	private void prepareSaveCreditButton() {
//		final Button view = (Button) this.findViewById(R.id.credit);
//		
//		view.setOnTouchListener( new View.OnTouchListener() {
//
//			@Override
//			public boolean onTouch(final View arg0, final MotionEvent arg1) {
//				final ContentValues values = new ContentValues();
//				
//				ContentResolverUtil.insert(getContentResolver(), Uris.INSERT_CREDIT, values);
//				
//				launchCreditListActivity();
//				return true;
//			}
//			
//			protected void launchCreditListActivity() {
//		        final Intent i = new Intent(IndexActivity.this, ManageCreditsActivity.class);
//		        
//		        try {
//		        	startActivity(i);
//		        } catch (final Throwable e) {
//					// TODO: handle exception
//		        	System.out.println(e);
//				}
//		    }
//		});
//		
////		view.setOnClickListener( new View.OnClickListener() {
////			
////			@Override
////			public void onClick(View v) {
////				final ContentValues values = new ContentValues();
////				
////				ContentResolverUtil.insert(getContentResolver(), Uris.INSERT_CREDIT, values);	
////				
////				launchCreditListActivity();
////			}
////			
////			protected void launchCreditListActivity() {
////		        final Intent i = new Intent(IndexActivity.this, CreditsListActivity.class);
////		        startActivity(i);
////		    }
////		});
//			
//	}
//
//	// @Override
//	// public void onAttachedToWindow() {
//	// super.onAttachedToWindow();
//	//
//	// }
//
//	private void prepareValueView() {
//		// TODO Auto-generated method stub
//	}
//
//	private void prepareContactView() {
//		View view = this.findViewById(R.id.contact);
//		final EditText contactView = (EditText) view;
//
//		if (contactView == null) {
//			System.out.println("<<<ERROR:>>> " + contactView);
//			return;
//		}
//
//		contactView.setFocusable(true);
//
//		contactView.setOnTouchListener(new View.OnTouchListener() {
//
//			// private
//
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// final Cursor cursor = getContacts();
//				// while (cursor.moveToNext()) {
//				// DatabaseUtils.dumpCurrentRow(cursor);
//				// }
//				//
//				// // TODO Auto-generated method stub
//				// return true;
//
//				// event nicht direkt behandeln (zu schnelle clicks.)
//				long eventTime = event.getEventTime();
//
//				final Uri uri = People.CONTENT_URI;
//				final Intent intent = new Intent(Intent.ACTION_PICK, uri);
//				startActivityForResult(intent, PICK_CONTACT);
//				
//
//				return true;
//			}
//		});
//	}
//
//	@Override
//	public void onActivityResult(int reqCode, int resultCode, Intent data) {
//		super.onActivityResult(reqCode, resultCode, data);
//
//		switch (reqCode) {
//		case (PICK_CONTACT):
//			if (resultCode == Activity.RESULT_OK) {
//				Uri contactData = data.getData();
//				Cursor c = managedQuery(contactData, null, null, null, null);
//				//
//				if (c.moveToFirst()) {
//					// // other data is available for the Contact. I have
//					// decided
//					// // to only get the name of the Contact.
//					final int columnIdx = c
//							.getColumnIndexOrThrow(People.DISPLAY_NAME);
//					String name = c.getString(columnIdx);
//
//					View view = this.findViewById(R.id.contact);
//					final EditText contactView = (EditText) view;
//
//					// TODO: store into credit-db
//					// credit-reminder
//					contactView.setText(name);
//				}
//			}
//		}
//
//	}
//
//	private Cursor getContacts() {
//		// Run query
//		final Uri uri = Contacts.CONTENT_URI;
//		final String[] projection = new String[] { ContactMethods._ID,
//				ContactMethods.DISPLAY_NAME };
//		final String selection = ContactMethods.DISPLAY_NAME + " <> 'Andrej'";
//		String[] selectionArgs = null;
//		String sortOrder = ContactMethods.DISPLAY_NAME
//				+ " COLLATE LOCALIZED ASC";
//
//		return managedQuery(uri, projection, selection, selectionArgs,
//				sortOrder);
//	}

}