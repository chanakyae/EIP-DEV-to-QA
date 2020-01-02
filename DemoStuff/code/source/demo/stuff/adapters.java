package demo.stuff;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-07-18 14:33:54 PDT
// -----( ON-HOST: sagbase.softwareag.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Date;
import java.util.GregorianCalendar;
// --- <<IS-END-IMPORTS>> ---

public final class adapters

{
	// ---( internal utility methods )---

	final static adapters _instance = new adapters();

	static adapters _newInstance() { return new adapters(); }

	static adapters _cast(Object o) { return (adapters)o; }

	// ---( server methods )---




	public static final void createDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createDate)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required Day
		// [i] field:0:required Month
		// [i] field:0:required Year
		// [o] object:0:required JavaDate
		
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	Day = IDataUtil.getString( pipelineCursor, "Day" );
			String	Month = IDataUtil.getString( pipelineCursor, "Month" );
			String	Year = IDataUtil.getString( pipelineCursor, "Year" );
		pipelineCursor.destroy();
		
		
		GregorianCalendar gc = new GregorianCalendar( Integer.parseInt(Year), 
		                                              (Integer.parseInt(Month) - 1), 
		                                              Integer.parseInt(Day));
		Date dt = gc.getTime();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		Object JavaDate = new Object();
		IDataUtil.put( pipelineCursor_1, "JavaDate", dt );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

