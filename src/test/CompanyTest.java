package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import database.Company;

public class CompanyTest {
	private Company company;
	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() {
		company = Company.getInstance();

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testGetAddress() {
		assertEquals("Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy",company.getAddress());
	}

	@Test
	public void testGetBusinessName() {
		assertEquals("G&R Megastore di Gori M. e Renzi A.",company.getBusinessName());
	}

	@Test
	public void testGetContactDetails() {
		assertEquals("Tel: 055.653258 - Fax: 055.653126",company.getContactDetails());
	}

	@Test
	public void testGetOther() {
		assertEquals("VAT: 00231500246 - E-mail: gerMegastore@gmail.com",company.getOther());
	}

	@Test
	public void testPrint() {
		company.printCompany();
		assertEquals("G&R Megastore di Gori M. e Renzi A.\n" +
				"Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy\n"+
				"Tel: 055.653258 - Fax: 055.653126\n" +
				"VAT: 00231500246 - E-mail: gerMegastore@gmail.com",outContent.toString());	
	}
}
