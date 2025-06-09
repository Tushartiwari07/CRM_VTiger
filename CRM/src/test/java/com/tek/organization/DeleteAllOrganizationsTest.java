package com.tek.organization;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.tek.crm.generic.baseutility.BaseClass;
import com.tek.crm.object_repository.OrganizationPage;
import com.tek.crm.webdriverutility.WebDriverUtility;

public class DeleteAllOrganizationsTest extends BaseClass{
	@Test
	public void deleteAllOrg() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
				OrganizationPage org= new OrganizationPage(driver);
				WebDriverUtility wlib= new WebDriverUtility(driver);

			
				hp.getOrgainzationLink().click();
				for(int i=1;i<=4;i++)
				{
					org.getSelectAllCheckBox().click();
					if(i==4)
					{
						break;
					}
					org.getNextPageIcon().click();
					Thread.sleep(6000);
				}
				org.getDeleteIcon().click();
				wlib.switchToAlertAccept(driver);
	}

}
