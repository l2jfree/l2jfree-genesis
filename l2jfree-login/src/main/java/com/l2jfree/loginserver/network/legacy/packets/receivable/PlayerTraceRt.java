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
package com.l2jfree.loginserver.network.legacy.packets.receivable;

import java.nio.BufferUnderflowException;

import com.l2jfree.loginserver.network.legacy.packets.L2GameServerPacket;
import com.l2jfree.network.mmocore.InvalidPacketException;
import com.l2jfree.network.mmocore.MMOBuffer;

/**
 * @author savormix
 *
 */
public final class PlayerTraceRt extends L2GameServerPacket
{
	/** Packet's identifier */
	public static final int OPCODE = 0x07;
	
	private static final int HOPS = 4;
	
	private String _account;
	private String _ip;
	private final String[] _hops;
	
	/** Constructs this packet. */
	public PlayerTraceRt()
	{
		_hops = new String[HOPS];
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.network.mmocore.ReceivablePacket#getMinimumLength()
	 */
	@Override
	protected int getMinimumLength()
	{
		return 1;
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.network.mmocore.ReceivablePacket#read(com.l2jfree.network.mmocore.MMOBuffer)
	 */
	@Override
	protected void read(MMOBuffer buf) throws BufferUnderflowException,
			RuntimeException
	{
		_account = buf.readS();
		_ip = buf.readS();
		for (int i = 0; i < _hops.length; i++)
			_hops[i] = buf.readS();
	}
	
	/* (non-Javadoc)
	 * @see com.l2jfree.network.mmocore.ReceivablePacket#runImpl()
	 */
	@Override
	protected void runImpl() throws InvalidPacketException, RuntimeException
	{
		// TODO Auto-generated method stub
		
	}
}