package vzap.wandile;

import java.io.*;

public class WrittingBinaryFile
{
	public static void main(String[] args)
	{
		int outInt = 99;
		/*double outDouble = 23;
		long outLng = 57342L;
		float outF = 0.008F;*/
		char ch = 'w';
		String str = "W";
		
		File file = new File("C:\\Users\\Wandile Nxumalo\\Documents\\Sept 2018\\TestingIO.bin");
		
		FileOutputStream fos = null;
		DataOutputStream dos;
		try
		{
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			dos.writeInt(outInt);
			/*dos.writeDouble(outDouble);
			dos.writeLong(outLng);
			dos.writeFloat(outF);*/
			dos.writeChar(ch);
			dos.writeUTF(str);
			
			System.out.println("File saved...>>>");
			
			//NEVER EVER FORGET TO CLOSE FILE CONNECTIONS
			
			dos.close();
			fos.close();
		} catch (Exception e)
		{
			System.out.println("File NOT saved...>>>");
			e.printStackTrace();
		}
		
		
	}
}
