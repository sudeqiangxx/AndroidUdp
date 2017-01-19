

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 *UDP服务器类
 */
public class UDPServer implements Runnable {
	private static final int PORT = 7001;
	private byte[] msg = new byte[1024];
	private boolean life = true;
	private DataRecvListener listener;

	public UDPServer(DataRecvListener listener) {
		this.listener = listener;
	}

	/**
	 * @return the life
	 */
	public boolean isLife() {
		return life;
	}

	/**
	 * @param life
	 *            the life to set
	 */
	public void setLife(boolean life) {
		this.life = life;
	}

	public void run() {
		DatagramSocket dSocket = null;
		DatagramPacket dPacket = new DatagramPacket(msg, msg.length);
		try {
			dSocket = new DatagramSocket(PORT);
			while (life) {
				try {
					dSocket.receive(dPacket);
					System.out.println("msg sever received"+ new String(dPacket.getData(), 0, dPacket.getLength()));
					MsgInfo info = new MsgInfo(new String(dPacket.getData(), 0, dPacket.getLength()));
					info.setName(dPacket.getAddress().getHostAddress());
					listener.onRecv(info);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	
}