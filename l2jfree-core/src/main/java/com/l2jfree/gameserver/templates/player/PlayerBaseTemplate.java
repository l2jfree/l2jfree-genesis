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
package com.l2jfree.gameserver.templates.player;

/**
 * @author NB4L1
 */
public final class PlayerBaseTemplate
{
	private final Race _race;
	private final ClassType _type;
	private final Gender _gender;
	
	private double _collisionRadius;
	private double _collisionHeight;
	private int _runSpeed;
	private int _walkSpeed;
	private int _runSpeedInWater;
	private int _walkSpeedInWater;
	private int _attackRange;
	private int _physicalAttack;
	private int _breath;
	private int _safeFallHeight;
	
	public PlayerBaseTemplate(Race race, ClassType type, Gender gender)
	{
		_race = race;
		_type = type;
		_gender = gender;
	}
	
	public Race getRace()
	{
		return _race;
	}
	
	public ClassType getType()
	{
		return _type;
	}
	
	public Gender getGender()
	{
		return _gender;
	}
	
	public double getCollisionRadius()
	{
		return _collisionRadius;
	}
	
	public void setCollisionRadius(double collisionRadius)
	{
		_collisionRadius = collisionRadius;
	}
	
	public double getCollisionHeight()
	{
		return _collisionHeight;
	}
	
	public void setCollisionHeight(double collisionHeight)
	{
		_collisionHeight = collisionHeight;
	}
	
	public int getRunSpeed()
	{
		return _runSpeed;
	}
	
	public void setRunSpeed(int runSpeed)
	{
		_runSpeed = runSpeed;
	}
	
	public int getWalkSpeed()
	{
		return _walkSpeed;
	}
	
	public void setWalkSpeed(int walkSpeed)
	{
		_walkSpeed = walkSpeed;
	}
	
	public int getRunSpeedInWater()
	{
		return _runSpeedInWater;
	}
	
	public void setRunSpeedInWater(int runSpeedInWater)
	{
		_runSpeedInWater = runSpeedInWater;
	}
	
	public int getWalkSpeedInWater()
	{
		return _walkSpeedInWater;
	}
	
	public void setWalkSpeedInWater(int walkSpeedInWater)
	{
		_walkSpeedInWater = walkSpeedInWater;
	}
	
	public int getAttackRange()
	{
		return _attackRange;
	}
	
	public void setAttackRange(int attackRange)
	{
		_attackRange = attackRange;
	}
	
	public int getPhysicalAttack()
	{
		return _physicalAttack;
	}
	
	public void setPhysicalAttack(int physicalAttack)
	{
		_physicalAttack = physicalAttack;
	}
	
	public int getBreath()
	{
		return _breath;
	}
	
	public void setBreath(int breath)
	{
		_breath = breath;
	}
	
	public int getSafeFallHeight()
	{
		return _safeFallHeight;
	}
	
	public void setSafeFallHeight(int safeFallHeight)
	{
		_safeFallHeight = safeFallHeight;
	}
}