package scouterclient;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class NetworkUtilities
{
	public static String getInterfaces()
	{
		String result = "";
		try{
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while(interfaces.hasMoreElements())
		{
			NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
			Enumeration<InetAddress> addresses = ni.getInetAddresses();
			
			while(addresses.hasMoreElements())
			{
				InetAddress inetAddress = (InetAddress) addresses.nextElement();
				if(inetAddress instanceof Inet4Address)
				{
					String hostaddress = inetAddress.getHostAddress();
					if(hostaddress.startsWith("127.") == false)
					{
						result += inetAddress.getHostAddress() + "\n";
					}
				}
			}
		}
		
		}
		catch(Exception e)
		{
			
		}
		return result;
	}
	public static boolean InterfaceExists(String ipprefix)
	{
		boolean result = false;
		try{
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while(interfaces.hasMoreElements())
		{
			NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
			Enumeration<InetAddress> addresses = ni.getInetAddresses();
			
			while(addresses.hasMoreElements())
			{
				InetAddress inetAddress = (InetAddress) addresses.nextElement();
				if(inetAddress instanceof Inet4Address)
				{
					String hostaddress = inetAddress.getHostAddress();
					if(hostaddress.startsWith(ipprefix) == true)
					{
						result = true;
					}
				}
			}
		}
		
		}
		catch(Exception e)
		{
			
		}
		return result;
	}
}
