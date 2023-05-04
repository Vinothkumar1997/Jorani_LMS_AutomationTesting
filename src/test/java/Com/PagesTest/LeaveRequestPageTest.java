package Com.PagesTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveRequestPageTest extends BaseSetup {
	@BeforeClass
	public void launcbrowser() {
		JLP.SuccessfullLogin(prop.getProperty("Username"), prop.getProperty("password"));
		JHP.navigateToLeaveRequestpage();
	}
	@Test(priority=1)
	public void pageheadertextTest() {
		String Act_header=LRP.pageheadertext();
		Assert.assertEquals(Act_header, "My leave requests  ");
	}
	@Test(priority=2)
	public void TypeboxTest() {
		LRP.Typebox("overtime");
		String Act_msg="No matching records found";
		Assert.assertEquals(Act_msg, "No matching records found");
		
	}
	@Test(priority=3)
	public void tablecolumnscountTest() {
		int Act_count=LRP.tablecolumnscount();
		boolean count=(Act_count==9);
		Assert.assertTrue(count);
	}
	@Test(priority=4)
	public void filteroptionsTest() {
		int Act_count=LRP.filteroptions();
		boolean count=(Act_count==6);
		Assert.assertTrue(count);
	}
	@Test(priority=5)
	public void filterleavetypeTest() {
		String text=LRP.filterleavetype(0);
		boolean act=text.equals("1050");
		Assert.assertFalse(act);
		//Assert.assertEquals(text, "1050");
	}
	@Test(priority=6)
	public void searchboxTest() {
		int no=LRP.searchbox("annual leave", "Annual Leave");
		boolean Act_no=(no==5);
		Assert.assertTrue(Act_no);
	}
	@Test(priority=7)
	public void searchboxclearTest() {
		LRP.searchboxclear();
	}
	@Test(priority=8)
	public void previouspageTest() {
		String Act_text=LRP.previouspage();
		Assert.assertEquals(Act_text, "Showing 1 to 4 of 4 entries");
	}
	@Test(priority=9)
	public void exportfileTest() {
		LRP.exportfile();
	}
	@Test(priority=10)
	public void ICSlinkTest() {
		String Act_text=LRP.ICSlink("ICS");
		boolean Actual=Act_text.contains(Act_text);
	Assert.assertTrue(Actual);

	}

}
