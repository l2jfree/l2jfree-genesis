/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jfree.util.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author NB4L1
 * @param <K>
 * @param <V>
 */
public final class L2ReadWriteEntityMap<K, V> extends L2EntityMap<K, V>
{
	private final ReentrantReadWriteLock _lock = new ReentrantReadWriteLock();
	private final ReentrantReadWriteLock.ReadLock _read = _lock.readLock();
	private final ReentrantReadWriteLock.WriteLock _write = _lock.writeLock();
	
	public L2ReadWriteEntityMap()
	{
		super();
	}
	
	public L2ReadWriteEntityMap(int initialSize)
	{
		super(initialSize);
	}
	
	public L2ReadWriteEntityMap(L2EntityKeyRetriever<K, V> keyRetriever)
	{
		super(keyRetriever);
	}
	
	public L2ReadWriteEntityMap(int initialSize, L2EntityKeyRetriever<K, V> keyRetriever)
	{
		super(initialSize, keyRetriever);
	}
	
	@Override
	public int size()
	{
		_read.lock();
		try
		{
			return super.size();
		}
		finally
		{
			_read.unlock();
		}
	}
	
	@Override
	public boolean isEmpty()
	{
		_read.lock();
		try
		{
			return super.isEmpty();
		}
		finally
		{
			_read.unlock();
		}
	}
	
	@Override
	public boolean contains(V obj)
	{
		_read.lock();
		try
		{
			return super.contains(obj);
		}
		finally
		{
			_read.unlock();
		}
	}
	
	@Override
	public V get(K id)
	{
		_read.lock();
		try
		{
			return super.get(id);
		}
		finally
		{
			_read.unlock();
		}
	}
	
	@Override
	public void add(V obj)
	{
		_write.lock();
		try
		{
			super.add(obj);
		}
		finally
		{
			_write.unlock();
		}
	}
	
	@Override
	public void remove(V obj)
	{
		_write.lock();
		try
		{
			super.remove(obj);
		}
		finally
		{
			_write.unlock();
		}
	}
	
	@Override
	public void clear()
	{
		_write.lock();
		try
		{
			super.clear();
		}
		finally
		{
			_write.unlock();
		}
	}
	
	@Override
	public V[] toArray(V[] array)
	{
		_read.lock();
		try
		{
			return super.toArray(array);
		}
		finally
		{
			_read.unlock();
		}
	}
	
	@Override
	public V[] toArray(Class<V> clazz)
	{
		_read.lock();
		try
		{
			return super.toArray(clazz);
		}
		finally
		{
			_read.unlock();
		}
	}
}
