package educing.tech.customer.network;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class InternetConnectionDetector 
{

	private Context _context;
	
	public InternetConnectionDetector(Context context)
	{
		this._context = context;
	}

	
	public boolean isConnectingToInternet()
	{
	
		ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (connectivity != null)   
		{
			  
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
		
			if (info != null) 
			{
				 for (int i = 0; i < info.length; i++)
				 {
					 if (info[i].getState() == NetworkInfo.State.CONNECTED)
					 {
						 return true;
					 }
				 }
			}
		}
		
		return false;
	}
	
	
	public boolean isConnected()
	{
		
		// flag for Internet connection status
		Boolean isInternetPresent = false;
						
		// get Internet status
		isInternetPresent = isConnectingToInternet();
		
		if(isInternetPresent)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}