package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.BaseData;

public class sampleTesting {

	@Test
	public void testBaseData() {
		BaseData data = new BaseData(1,2,3);
		assertEquals("eventId",1,data.getEventId().intValue());
		assertNotSame("eventId",2,data.getEventId().intValue());
		
		assertEquals("failureClass",2,data.getFailureClass().intValue());
		assertNotSame("failureClass",1,data.getFailureClass().intValue());
		
		assertEquals("UEType",3,data.getUEType().intValue());
		assertNotSame("eventId",1,data.getUEType().intValue());
	}
	

}
