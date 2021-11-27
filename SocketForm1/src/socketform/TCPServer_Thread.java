/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author duchi
 */
public class TCPServer_Thread extends Thread{
    ServerSocket mServer;
    JTextArea mTxaStatus; //JTextArea để lưu status của Server
    public TCPServer_Thread(JTextArea txaStatus)
        {
        mTxaStatus = txaStatus;
        }

    TCPServer_Thread(JScrollPane txaStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void run()
    {
        try
        {
            String so1,so2,so3,s;
            int tong,hieu,nhan;
            mServer = new ServerSocket(1234);
            mTxaStatus.append("Server đã sẵn sàng!\nĐang chờ dữ liệu...\n\n");
            while(true)
            {
                Socket connectionSocket = mServer.accept();
                DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                s=inFromClient.readLine();
                so1 = inFromClient.readLine();
                so2 = inFromClient.readLine();
                mTxaStatus.append("Đã nhận 2 số a = " + so1 +", b = "+ so2 +"\n");
                int a = Integer.parseInt(so1);
                int b = Integer.parseInt(so2);
                tong = a + b;
                hieu=a-b;
                nhan=a*b;
                double chia=(double) a/b;
                    if (s.equals("Cong"))
                    {
                        so3 = String.valueOf(tong);
                        mTxaStatus.append("Thực hiện phép tính a + b = "+so3+"\n");
                        outToClient.writeBytes(so3+'\n');
                        mTxaStatus.append("Đã gửi kết quả về cho Client thành công\n\n");
                    }
                    if (s.equals("Tru"))
                    {
                        so3 = String.valueOf(hieu);
                        mTxaStatus.append("Thực hiện phép tính a - b = "+so3+"\n");
                        outToClient.writeBytes(so3+'\n');
                        mTxaStatus.append("Đã gửi kết quả về cho Client thành công\n\n");
                    }
                    if (s.equals("Chia"))
                    {
                        so3 = String.valueOf(chia);
                        mTxaStatus.append("Thực hiện phép tính a / b = "+so3+"\n");
                        outToClient.writeBytes(so3+'\n');
                        mTxaStatus.append("Đã gửi kết quả về cho Client thành công\n\n");
                    }
                    if (s.equals("Nhan"))
                    {
                        so3 = String.valueOf(nhan);
                        mTxaStatus.append("Thực hiện phép tính a * b = "+so3+"\n");
                        outToClient.writeBytes(so3+'\n');
                        mTxaStatus.append("Đã gửi kết quả về cho Client thành công\n\n");
                    }
            }
        }
        catch(Exception ex)
        {
            mTxaStatus.append("Server đã xảy ra lỗi\n");
        }
    }
 public void StopServer()
 {
    super.stop();
    try {
        mServer.close();
    } catch (IOException ex) {
        mTxaStatus.append("Server stop đã xảy ra lỗi\n");
    }
 }
}
