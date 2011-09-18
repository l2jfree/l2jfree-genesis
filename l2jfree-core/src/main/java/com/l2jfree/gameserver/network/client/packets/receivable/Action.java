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
package com.l2jfree.gameserver.network.client.packets.receivable;

import java.nio.BufferUnderflowException;

import com.l2jfree.gameserver.gameobjects.L2Object;
import com.l2jfree.gameserver.gameobjects.L2Player;
import com.l2jfree.gameserver.network.client.packets.L2ClientPacket;
import com.l2jfree.gameserver.network.client.packets.sendable.ActionFail.InteractionFinished;
import com.l2jfree.gameserver.util.ObjectId;
import com.l2jfree.gameserver.world.L2World;
import com.l2jfree.network.mmocore.InvalidPacketException;
import com.l2jfree.network.mmocore.MMOBuffer;

/**
 * @author savormix (generated)
 */
public abstract class Action extends L2ClientPacket
{
	/**
	 * A nicer name for {@link Action}.
	 * 
	 * @author savormix (generated)
	 * @see Action
	 */
	public static final class RequestInteraction extends Action
	{
		// only for convenience
	}
	
	/** Packet's identifier */
	public static final int OPCODE = 0x1f;
	
	@Override
	protected int getMinimumLength()
	{
		return READ_D + READ_D + READ_D + READ_D + READ_C;
	}
	
	/* Fields for storing read data */
	private int _targetObjectId;
	private boolean _shiftPressed;
	
	@Override
	protected void read(MMOBuffer buf) throws BufferUnderflowException, RuntimeException
	{
		// TODO: when implementing, consult an up-to-date packets_game_server.xml and/or savormix
		_targetObjectId = buf.readD(); // Target OID
		buf.readD(); // Current client X
		buf.readD(); // Current client Y
		buf.readD(); // Current client Z
		_shiftPressed = (buf.readC() == 1); // Shift (do not move)
	}
	
	@Override
	protected void runImpl() throws InvalidPacketException, RuntimeException
	{
		// TODO: implement
		final L2Player activeChar = getClient().getActiveChar();
		if (activeChar == null)
			return;
		
		final L2Object target = L2World.findPlayer(new ObjectId(_targetObjectId));
		if (target == null)
			return;
		
		target.onAction(activeChar, _shiftPressed, false);
		
		sendPacket(InteractionFinished.PACKET);
	}
}
