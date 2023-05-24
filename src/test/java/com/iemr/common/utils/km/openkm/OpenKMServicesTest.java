package com.iemr.common.utils.km.openkm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.http.HttpUtils;
import com.iemr.common.utils.km.KMService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { OpenKMServiceImpl.class, ConfigProperties.class, HttpUtils.class })
public class OpenKMServicesTest
{

	private KMService serv;

	@Autowired
	public void setServ(OpenKMServiceImpl openKMServiceImpl)
	{
		this.serv = openKMServiceImpl;
	}
	private String filepath = "e:/FAQ  for Onsite.docx";
	private String destPath = "1/2/3/FAQ.docx";

	@Test
	public void testGetRoot()
	{
		assertTrue(serv.getDocumentRoot().equals(""));
	}

	@Test
	public void testCreateDocument()
	{
		assertTrue(serv.createDocument(destPath, filepath).equals(destPath));
	}

}
