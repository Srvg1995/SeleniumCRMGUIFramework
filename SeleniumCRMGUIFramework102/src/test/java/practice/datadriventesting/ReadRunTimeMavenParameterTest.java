package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {

	@Test
	public void runtimeParameterTest()
	{
		String url = System.getProperty("url");
		System.out.println("Env Data==>URL======>"+url);
	}
}
