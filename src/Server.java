

public class Server {
		public static void main(String[] args) {
			UDPClient udpClient=new UDPClient();
			String result="{" +
                "    'device': {" +
                "        'devNum': '14319630'," +
                "        'IPV4': '192.168.200.12'," +
                "        'Category': '1'," +
                "        'homeId': '1122'" +
                "    }" +
                "}";
			while(true){
				udpClient.send(result);
				try {
					Thread.sleep(2000);
					System.out.println("开始发送广播信息"+result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
//			DataRecvListener listener=new DataRecvListener() {
//				@Override
//				public void onRecv(MsgInfo info) {
//					// TODO Auto-generated method stub
//					//接收到消息
//					
//					
//				}
//			};
//			UDPServer udpServer=new UDPServer(listener);
//			udpServer.run();
			
		}
}
