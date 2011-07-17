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
package com.l2jfree.loginserver;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import com.l2jfree.util.concurrent.ThreadPoolInitializer;

/**
 * @author savormix
 *
 */
public class L2LoginThreadPools implements ThreadPoolInitializer
{
	private ScheduledThreadPoolExecutor[] _scheduledPools;
	private ThreadPoolExecutor[] _instantPools;
	private ThreadPoolExecutor[] _longRunningPools;
	
	/** Placeholder javadoc */
	public L2LoginThreadPools()
	{
		_scheduledPools = null;
		_instantPools = null;
		_longRunningPools = null;
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.util.concurrent.ThreadPoolInitializer#initThreadPool()
	 */
	@Override
	public void initThreadPool() throws Exception
	{
		_scheduledPools = new ScheduledThreadPoolExecutor[0];
		_instantPools = new ThreadPoolExecutor[0];
		_longRunningPools = new ThreadPoolExecutor[0];
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.util.concurrent.ThreadPoolInitializer#getScheduledPools()
	 */
	@Override
	public ScheduledThreadPoolExecutor[] getScheduledPools()
	{
		return _scheduledPools;
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.util.concurrent.ThreadPoolInitializer#getInstantPools()
	 */
	@Override
	public ThreadPoolExecutor[] getInstantPools()
	{
		return _instantPools;
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.util.concurrent.ThreadPoolInitializer#getLongRunningPools()
	 */
	@Override
	public ThreadPoolExecutor[] getLongRunningPools()
	{
		return _longRunningPools;
	}
}