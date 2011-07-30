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
package com.l2jfree.loginserver.network.client.packets;

import com.l2jfree.loginserver.network.client.L2LoginClient;
import com.l2jfree.network.mmocore.MMOBuffer;
import com.l2jfree.network.mmocore.SendablePacket;

/**
 * Just a wrapper class for convenience.
 * @author savormix
 */
public abstract class L2ServerPacket extends SendablePacket<L2LoginClient, L2ClientPacket, L2ServerPacket>
{
	protected L2ServerPacket()
	{
		super();
	}
	
	/**
	 * Returns this packet's identifier.
	 * @return a number from the interval
	 * 			[{@link java.lang.Byte#MIN_VALUE}; {@link java.lang.Byte#MAX_VALUE}]
	 */
	protected abstract int getOpcode();
	
	/**
	 * Embed data into a packet.
	 * @param client packet receiver
	 * @param buf buffer for packet's data
	 */
	protected abstract void writeImpl(L2LoginClient client, MMOBuffer buf);
	
	@Override
	protected final void write(L2LoginClient client, MMOBuffer buf) throws RuntimeException
	{
		buf.writeC(getOpcode());
		writeImpl(client, buf);
	}
}
