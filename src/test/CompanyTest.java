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
		company = new Company();

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testGetAddress() {
		assertEquals("Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy",company.getAddress());
	}

	@Test
	public void testSetAddress() {
		company.setAddress("Amphitheatre Parkway, 1600 - 94034 Mountain View (CA) - USA");
		assertEquals("Amphitheatre Parkway, 1600 - 94034 Mountain View (CA) - USA",company.getAddress());
	}

	@Test
	public void testGetBusinessName() {
		assertEquals("G&R Megastore di Gori M. e Renzi A.",company.getBusinessName());
	}

	@Test
	public void testSetBusinessName() {
		company.setBusinessName("Google Inc.");
		assertEquals("Google Inc.",company.getBusinessName());
	}

	@Test
	public void testGetContactDetails() {
		assertEquals("Tel: 055.653258 - Fax: 055.653126",company.getContactDetails());
	}

	@Test
	public void testSetContactDetails() {
		company.setContactDetails("Tel: 650.6234000 - Fax: 650.6182678");
		assertEquals("Tel: 650.6234000 - Fax: 650.6182678",company.getContactDetails());
	}

	@Test
	public void testGetOther() {
		assertEquals("VAT: 00231500246 - E-mail: gerMegastore@gmail.com",company.getOther());
	}

	@Test
	public void testSetOther() {
		company.setOther("VAT: 00231500246 - E-mail: googleinc@gmail.com");
		assertEquals("VAT: 00231500246 - E-mail: googleinc@gmail.com",company.getOther());
	}

	@Test
	public void testPrint() {
		company.printCompanyInfo();
		assertEquals("G&R Megastore di Gori M. e Renzi A.\n" +
				"Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy\n"+
				"Tel: 055.653258 - Fax: 055.653126\n" +
				"VAT: 00231500246 - E-mail: gerMegastore@gmail.com",outContent.toString());	
	}
}
