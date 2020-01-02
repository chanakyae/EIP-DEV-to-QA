package demo.stuff;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2010-07-18 14:34:01 PDT
// -----( ON-HOST: sagbase.softwareag.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class recordLibrary

{
	// ---( internal utility methods )---

	final static recordLibrary _instance = new recordLibrary();

	static recordLibrary _newInstance() { return new recordLibrary(); }

	static recordLibrary _cast(Object o) { return (recordLibrary)o; }

	// ---( server methods )---




	public static final void flattenStructureJava (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(flattenStructureJava)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:1:required ConsolidatedTitles
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
			// AlbumCollection
			IData[]	AlbumCollection = IDataUtil.getIDataArray( pipelineCursor, "AlbumCollection" );
			if ( AlbumCollection != null)
			{
		                String[]	ConsolidatedTitles = new String[AlbumCollection.length];
				for ( int i = 0; i < AlbumCollection.length; i++ )
				{
					IDataCursor AlbumCollectionCursor = AlbumCollection[i].getCursor();
						String	Title = IDataUtil.getString( AlbumCollectionCursor, "Title" );
						String	ArtistName = IDataUtil.getString( AlbumCollectionCursor, "ArtistName" );
						String	NoOfTracks = IDataUtil.getString( AlbumCollectionCursor, "NoOfTracks" );
		                        ConsolidatedTitles[i] = Title + ";" + ArtistName + ";" + NoOfTracks;
					AlbumCollectionCursor.destroy();
				}
		                IDataUtil.put( pipelineCursor, "ConsolidatedTitles", ConsolidatedTitles );
			}
		pipelineCursor.destroy();
		
		
		// --- <<IS-END>> ---

                
	}
}

