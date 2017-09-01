//package remote_call;
//
//import java.io.IOException;
//
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.gof.core.interfaces.ISerilizable;
//import org.gof.core.support.Param;
//
//public class Call implements ISerilizable {
//	//��������
//	public static final int TYPE_RPC = 1000;			//Զ�̵���
//	public static final int TYPE_RPC_RETURN = 2000;	//Զ�̵��÷���
//	public static final int TYPE_MIX = 3000;			//����ר��
//	public static final int TYPE_PING = 4000;			//�������
//
//	public long id;							//����ID
//	public int type;							//�������� 1000 2000 3000 4000
//	public String fromNodeId;					//���ͷ�NodeId
//	public String fromPortId;					//���ͷ�PortId(Call��������port���ͣ���ҵ��û��ȷ��service)
//	public CallPoint to = new CallPoint();		//���շ�
//	public int methodKey;					//���ú�������
//	public Object[] methodParam;				//���ú�������
//	public Param returns = new Param();			//����ֵ
//	public Param param = new Param();			//��չ����
//
//	/**
//	 * ����CallReturn
//	 * @return
//	 */
//	public CallReturn createCallReturn() {
//		return new CallReturn(id, fromNodeId, fromPortId);
//	}
//
//	@Override
//	public void writeTo(OutputStream stream) throws IOException {
//		stream.write(type);
//		stream.write(fromNodeId);
//		stream.write(fromPortId);
//		stream.write(to);
//		stream.write(id);
//		stream.write(methodKey);
//		stream.write(methodParam);
//		stream.write(returns);
//		stream.write(param);
//	}
//
//	@Override
//	public void readFrom(InputStream stream) throws IOException {
//		type = stream.read();
//		fromNodeId = stream.read();
//		fromPortId = stream.read();
//		to = stream.read();
//		id = stream.read();
//		methodKey = stream.read();
//		methodParam = stream.read();
//		returns = stream.read();
//		param = stream.read();
//	}
//
//	@Override
//	public String toString() {
//		return new ToStringBuilder(this)
//					.append("type", type)
//					.append("fromNodeId", fromNodeId)
//					.append("fromPortId", fromPortId)
//					.append("to", to)
//					.append("callId", id)
//					.append("methodKey", methodKey)
//					.append("methodParameters", methodParam)
//					.append("returnValues", returns)
//					.toString();
//	}
//}
