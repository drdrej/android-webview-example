package com.significantfiles.android.sqlite.commands;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import android.database.sqlite.SQLiteOpenHelper;

import com.significantfiles.android.sqlite.DaoInvocationHandler;

public class DaoManager {

	
	private final SQLiteOpenHelper dbManager;

	public DaoManager(final SQLiteOpenHelper dbManager) {
		this.dbManager = dbManager;
	}

	public <T> T build(final Class<T> daoType) {
		// TODO: Impl. Caching
		final T dao = createInvocationHandler(daoType);
		
		return dao;
	}

	@SuppressWarnings( "unchecked" )
	private <T> T createInvocationHandler(final Class<T> daoType) {
		  final InvocationHandler logger = new DaoInvocationHandler(daoType, this.dbManager);

		  final Class<?>[] daoInterfaces = new Class[] {
				  daoType
		  };

		  final ClassLoader classLoader = getClass().getClassLoader();
		  
		  return (T) Proxy.newProxyInstance(
		    classLoader,
		    daoInterfaces, logger);
	}
	
	
}
