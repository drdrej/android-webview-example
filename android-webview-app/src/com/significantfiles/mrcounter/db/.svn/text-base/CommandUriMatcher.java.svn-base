package com.significantfiles.mrcounter.db;

import java.util.ArrayList;
import java.util.List;

import com.significantfiles.android.provider.table.Authority;
import com.significantfiles.android.provider.table.UriPathExt;
import com.significantfiles.android.sqlite.commands.CommandBasedContentProvider;

import android.content.ContentProvider;
import android.content.UriMatcher;
import android.net.Uri;
import android.util.Log;


public class CommandUriMatcher {

	private final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

	private final List<ContentProviderCmd> providerList = new ArrayList<ContentProviderCmd>(
			10);

	private final String authorityStr;

	public CommandUriMatcher(final Class<? extends CommandBasedContentProvider> provider) {
		final Authority authority = extractContentUri(provider);
		this.authorityStr = authority.uri();
	}

	private Authority extractContentUri(
			final Class<? extends ContentProvider> provider) {
		final Authority authority = provider.getAnnotation(Authority.class);

		if (authority == null) {
			final String logMsg = "Couldn't create Instance. No annotation found in passed ContentProvider.class [= "
					+ provider.getName() + "]";
			Log.e("sqleasy", logMsg);

			throw new IllegalStateException(logMsg);
		}

		return authority;
	}

	public void register( final ContentProviderCmd command ) {
		if( command == null ) {
			final String logMsg = "Couldn't register new command, because passed reference is NULL." ;
			Log.e( "sqleasy", logMsg);
			throw new IllegalArgumentException( logMsg );
		}
		
		final Class<? extends ContentProviderCmd> commandType = command.getClass();
		
		final int code = this.providerList.size();
		
		final UriPathExt pathExt = commandType.getAnnotation( UriPathExt.class );
		final String path = pathExt.uri();
		
		this.matcher.addURI(this.authorityStr, path, code);

		this.providerList.add( command );
	}

	public ContentProviderCmd match(final Uri uri) {
		final int cmdIdx = this.matcher.match(uri);

		if( cmdIdx < 0 ) {
			final String logMsg = "Couldn't match command for passed uri [= " + uri + "]";
			Log.e("sqleasy", logMsg );
			
			throw new IllegalArgumentException(logMsg);
		}
		
		return this.providerList.get(cmdIdx);
	}

	public ContentProviderCmd match(final String uriStr) {
		final Uri uri = Uri.parse(uriStr);
		
		return match(uri);
	}

	public String getUriPath(final Class<? extends ContentProviderCmd> commandType) {
		final UriPathExt path = commandType.getAnnotation( UriPathExt.class );
		
		if( path == null ) return "";
		
		return path.uri();
	}

}
