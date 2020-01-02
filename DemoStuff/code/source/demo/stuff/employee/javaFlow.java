package demo.stuff.employee;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2011-11-03 04:10:20 PKT
// -----( ON-HOST: sagbase.softwareag.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.*;
import java.io.*;
import com.wm.lang.ns.NSService;
import java.util.Stack;
// --- <<IS-END-IMPORTS>> ---

public final class javaFlow

{
	// ---( internal utility methods )---

	final static javaFlow _instance = new javaFlow();

	static javaFlow _newInstance() { return new javaFlow(); }

	static javaFlow _cast(Object o) { return (javaFlow)o; }

	// ---( server methods )---




	public static final void getJobsJava (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getJobsJava)>> ---
		// @specification demo.stuff.employee.javaFlow:getJobsSpec
		// @subtype unknown
		// @sigtype java 3.5
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			// Employee
			IData	Employee = IDataUtil.getIData( pipelineCursor, "Employee" );
			if ( Employee != null)
			{
				IDataCursor EmployeeCursor = Employee.getCursor();
					String	Name = IDataUtil.getString( EmployeeCursor, "Name" );
					String[]	Children = IDataUtil.getStringArray( EmployeeCursor, "Children" );
		
					// i.EmpBirthday
					IData	EmpBirthday = IDataUtil.getIData( EmployeeCursor, "EmpBirthday" );
					if ( EmpBirthday != null)
					{
						IDataCursor EmpBirthdayCursor = EmpBirthday.getCursor();
							String	Day = IDataUtil.getString( EmpBirthdayCursor, "Day" );
							String	Month = IDataUtil.getString( EmpBirthdayCursor, "Month" );
							String	Year = IDataUtil.getString( EmpBirthdayCursor, "Year" );
						EmpBirthdayCursor.destroy();
					}
		
					// i.Positions
					IData[]	Positions = IDataUtil.getIDataArray( EmployeeCursor, "Positions" );
					if ( Positions != null)
					{
						IData[]	Jobs = new IData[Positions.length];
						for ( int i = 0; i < Positions.length; i++ )
						{
							Jobs[i] = IDataFactory.create();
							IDataCursor JobsCursor = Jobs[i].getCursor();
							IDataCursor PositionsCursor = Positions[i].getCursor();
								String	JobTitle = IDataUtil.getString( PositionsCursor, "JobTitle" );
								IDataUtil.put( JobsCursor, "Title", JobTitle.toUpperCase() );
		
								// i_1.DateStarted
								IData	DateStarted = IDataUtil.getIData( PositionsCursor, "DateStarted" );
								if ( DateStarted != null)
								{
									IDataCursor DateStartedCursor = DateStarted.getCursor();
										String	Day_1 = IDataUtil.getString( DateStartedCursor, "Day" );
										String	Month_1 = IDataUtil.getString( DateStartedCursor, "Month" );
										String	Year_1 = IDataUtil.getString( DateStartedCursor, "Year" );
										IDataUtil.put( JobsCursor, "YrStarted", Year_1 );
									DateStartedCursor.destroy();
								}
							PositionsCursor.destroy();
							JobsCursor.destroy();
						}
						IDataUtil.put( pipelineCursor, "Jobs", Jobs );
					}
				EmployeeCursor.destroy();
			}
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static Reader getReader(IDataCursor cursor, String key)
	{
	  Reader reader = null;
	  if (cursor.first(key))
	  {
	    Object o = cursor.getValue();
	    if (o == null)
	    {
	      reader = new StringReader("");
	    }
	    else if (o instanceof BufferedReader)
	    {
	      reader = (BufferedReader) o;
	    }
	    else if (o instanceof Reader)
	    {
	      reader = new BufferedReader((Reader) o);
	    }
	    else if (o instanceof InputStream)
	    {
	      reader = new BufferedReader(new InputStreamReader((InputStream) o));
	    }
	    else if (o instanceof String)
	    {
	      reader = new BufferedReader(new StringReader((String) o));
	    }
	    else if (o instanceof byte[])
	    {
	      reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream((byte[]) o)));
	    }
	  }
	  return reader;
	
	}
	
	static Writer getWriter(IDataCursor cursor, String key)
	{
	  Writer writer = new StringWriter();
	  if (cursor.first(key))
	  {
	    Object o = cursor.getValue();
	    if (o == null)
	    {
	      return writer;
	    }
	    else if (o instanceof BufferedWriter)
	    {
	      writer = (BufferedWriter) o;
	    }
	    else if (o instanceof Writer)
	    {
	      writer = new BufferedWriter((Writer) o);
	    }
	    else if (o instanceof OutputStream)
	    {
	      writer = new BufferedWriter(new OutputStreamWriter((OutputStream) o));
	    }
	  }
	  return writer;
	
	}
	// --- <<IS-END-SHARED>> ---
}

