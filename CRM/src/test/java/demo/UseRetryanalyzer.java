package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UseRetryanalyzer {
	@Test(retryAnalyzer = com.tek.crm.genericutility.RetryListnerImplimentation.class)
	public void testRetry()
	{
		String name="tushar";
		System.out.println("Retry analyzer execution started");
		Assert.assertEquals(name, "Tushar");
		System.out.println("Retry analyzer execution End");

	}

}
