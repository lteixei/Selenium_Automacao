package br.ce.wcaquino.tests;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ce.wcaquino.utils.DataUtils;

public class InserirChipTest {
	public DataUtils utils = new DataUtils();
	
	public String gerarChip() {
	utils.newBSCSIXConnection();
	ResultSet chip = utils.executeAndReturnFirstResult("Select smix.sm_serialnum From STORAGE_MEDIUM SMIX," 
	+ "STORAGE_MEDIUM@BSCSIX_TO_BSCS6_LINK SM6, "
	+ "PORT PIX, " + "PORT@BSCSIX_TO_BSCS6_LINK P6, "
	+ "HLR_AREA@BSCSIX_TO_BSCS6_LINK HA, " + "MPDHLTAB@BSCSIX_TO_BSCS6_LINK HL, "
	+ "AREA@BSCSIX_TO_BSCS6_LINK A " + "Where SMIX.SM_ID = SM6.SM_ID "
	+ "And PIX.PORT_ID = P6.PORT_ID "
	+ "And SMIX.SM_ID = PIX.SM_ID " + "And SM6.SM_ID = P6.SM_ID " + "And SMIX.SM_STATUS = 'r' " 
	+ "And SM6.SM_STATUS = 'r' " + "And PIX.PORT_STATUS = 'r' " + "And P6.PORT_STATUS = 'r' " 
	+ "And P6.HLCODE = HA.HLCODE " + "And HL.HLCODE = HA.HLCODE " + "And HA.AREA_ID = A.AREA_ID " 
	+ " AND SMIX.SMC_ID ='2' " + "And HL.SWITCH_ID In ('1', '2', '3') " + "And A.AREA_DESC LIKE 'SP_13"
	+ "' order by dbms_random.value");
	System.out.print("Consulta efetuada");
	try {
		return chip.getString(1);
	}
	catch (SQLException e){
	    e.printStackTrace();
	    return null;
	}
	}
	
	public void inserindochip() {
		String meuchip = gerarChip();
	}
}
