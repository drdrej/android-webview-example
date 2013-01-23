package com.significantfiles.android.sqlite.commands;

import com.significantfiles.android.provider.table.Authority;

import android.content.ContentProvider;
import android.util.Log;

public abstract class CommandBasedContentProvider extends ContentProvider {

	private final Authority authority;

	public CommandBasedContentProvider() {
		this.authority = this.loadAuthorityAnnotation();
	}
	
	private Authority loadAuthorityAnnotation() {
		final Class<? extends CommandBasedContentProvider> impl = this
				.getClass();

		final Authority authority = impl.getAnnotation(Authority.class);

		if (authority == null) {
			final String logMsg = "Couldn't create instance. Missing annotation [= "
					+ Authority.class.getName()
					+ "] in this ContentProvider [= "
					+ getClass().getName()
					+ "]";
			
			Log.e("sqleasy", logMsg);
			
			throw new IllegalStateException( logMsg );
		}
		
		return authority;
	}
	
	public Authority getAuthority( ) {
		return this.authority;
	}

}
