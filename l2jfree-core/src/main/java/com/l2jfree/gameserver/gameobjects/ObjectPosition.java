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
package com.l2jfree.gameserver.gameobjects;

import com.l2jfree.gameserver.world.L2World;
import com.l2jfree.gameserver.world.L2WorldRegion;
import com.l2jfree.lang.L2Math;

/**
 * @author NB4L1
 */
public final class ObjectPosition
{
	private final L2Object _activeChar;
	
	private volatile int _x;
	private volatile int _y;
	private volatile int _z;
	
	private volatile int _heading;
	
	private volatile L2WorldRegion _worldRegion;
	
	public ObjectPosition(L2Object activeChar)
	{
		_activeChar = activeChar;
	}
	
	public final L2Object getActiveChar()
	{
		return _activeChar;
	}
	
	public final int getX()
	{
		return _x;
	}
	
	public final int getY()
	{
		return _y;
	}
	
	public final int getZ()
	{
		return _z;
	}
	
	public final int getHeading()
	{
		return _heading;
	}
	
	public final L2WorldRegion getWorldRegion()
	{
		return _worldRegion;
	}
	
	public final synchronized void setXYZ(int x, int y, int z)
	{
		_x = L2Math.limit(L2World.MAP_MIN_X + 500, x, L2World.MAP_MAX_X - 500);
		_y = L2Math.limit(L2World.MAP_MIN_Y + 500, y, L2World.MAP_MAX_Y - 500);
		_z = L2Math.limit(L2World.MAP_MIN_Z + 500, z, L2World.MAP_MAX_Z - 500);
	}
	
	public final synchronized void setHeading(int heading)
	{
		_heading = heading;
	}
	
	public final boolean isVisible()
	{
		return _worldRegion != null;
	}
	
	private final synchronized void setVisible(boolean visible)
	{
		final L2WorldRegion oldRegion = _worldRegion;
		final L2WorldRegion newRegion = visible ? L2World.getRegion(_x, _y) : null;
		
		if (oldRegion == newRegion)
			return;
		
		if (oldRegion != null)
			oldRegion.removeObject(_activeChar);
		
		_worldRegion = newRegion;
		
		if (newRegion != null)
			newRegion.addObject(_activeChar);
	}
	
	public final synchronized void update(int x, int y, int z)
	{
		setXYZ(x, y, z);
		
		setVisible(isVisible());
	}
	
	public final synchronized void spawn()
	{
		spawn(_x, _y, _z);
	}
	
	public final synchronized void spawn(int x, int y, int z)
	{
		if (_worldRegion != null)
			throw new IllegalStateException("There must be no region assocatied!");
		
		setXYZ(x, y, z);
		
		setVisible(true);
	}
	
	public final synchronized void decay()
	{
		decay(_x, _y, _z);
	}
	
	public final synchronized void decay(int x, int y, int z)
	{
		if (_worldRegion == null)
			throw new IllegalStateException("There must be a region assocatied!");
		
		setXYZ(x, y, z);
		
		setVisible(false);
	}
	
	/**
	 * @see L2WorldRegion#addObject(L2Object)
	 * @see ObjectPosition#setVisible(boolean)
	 * @see ObjectPosition#update(int, int, int)
	 * @see ObjectPosition#spawn(int, int, int)
	 */
	public final void worldRegionActivated()
	{
		// do nothing at default
	}
	
	/**
	 * @see L2WorldRegion#removeObject(L2Object)
	 * @see ObjectPosition#setVisible(boolean)
	 * @see ObjectPosition#update(int, int, int)
	 * @see ObjectPosition#decay(int, int, int)
	 */
	public final void worldRegionDeactivated()
	{
		// do nothing at default
	}
}
