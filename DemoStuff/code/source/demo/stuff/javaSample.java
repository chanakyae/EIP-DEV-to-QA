package demo.stuff;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-04-01 09:39:53 EDT
// -----( ON-HOST: sagbase.eur.ad.sag

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
import java.util.Date;
import java.text.*;
import com.wm.app.b2b.server.Session;
import com.wm.app.b2b.server.User;
// --- <<IS-END-IMPORTS>> ---

public final class javaSample

{
	// ---( internal utility methods )---

	final static javaSample _instance = new javaSample();

	static javaSample _newInstance() { return new javaSample(); }

	static javaSample _cast(Object o) { return (javaSample)o; }

	// ---( server methods )---




	public static final void genPOAcceptID (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(genPOAcceptID)>> ---
		// @sigtype java 3.5
		// [i] field:0:required POReqDocID
		// [o] field:0:required POAcceptDocID
		// The POReqDocID is in the pipeline to start
		// Just generate a simple Date Time Stamp for output from the current date/time
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		String POReqDocID = IDataUtil.getString( pipelineCursor, "POReqDocID" );
		
		Date todaysDate = new Date ();
		SimpleDateFormat sdf = new SimpleDateFormat ();
		sdf.applyPattern ("yyMMddkkmmss");
		
		String POAcceptDateTime = sdf.format (todaysDate);
		String POAcceptDocID = POAcceptDateTime + "-" + POReqDocID;
		
		IDataUtil.put( pipelineCursor, "POAcceptDocID", POAcceptDocID );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void getUserName (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getUserName)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] record:0:required $session
		// [o] field:0:required User
		 
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		  	// $session
			IData	TheSession = IDataUtil.getIData( pipelineCursor, "$session" );
			if ( TheSession != null)
			{
		           Session mySession = (Session) TheSession;
		           User  myUser = mySession.getUser();
		           String myUserName = myUser.getName();
		           IDataUtil.put( pipelineCursor, "User", myUserName );
			}
		pipelineCursor.destroy();
		
		
		
		
		// --- <<IS-END>> ---

                
	}



	public static final void stringCompare (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringCompare)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required string1
		// [i] field:0:required string2
		// [o] field:0:required result
		  
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	string1 = IDataUtil.getString( pipelineCursor, "string1" );
			String	string2 = IDataUtil.getString( pipelineCursor, "string2" );
		pipelineCursor.destroy();
		
		int result = string1.compareTo(string2);
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "result", result+"" );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void stringCompareIDataMap (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringCompareIDataMap)>> ---
		// @sigtype java 3.5
		// [i] field:0:required string1
		// [i] field:0:required string2
		// [o] field:0:required result
	IDataMap idm = new IDataMap(pipeline);

	String	string1 = idm.getAsString("string1" );
	String	string2 = idm.getAsString("string2" );

	int result = string1.compareTo(string2);

	idm.put("result", result );

	
		// --- <<IS-END>> ---

                
	}
}

