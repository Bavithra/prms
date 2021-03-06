package sg.edu.nus.iss.phoenix.radioprogram.delegate;

import java.sql.SQLException;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.radioprogram.service.ProgramService;

public class ProgramDelegate {
/*	
	public ArrayList<RadioProgram> searchPrograms(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		ProgramService service = new ProgramService();
		return service.searchPrograms(rp);	
	}
	
	public ArrayList<RadioProgram> findRPByCriteria(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		ProgramService service = new ProgramService();
		return service.searchPrograms(rp);	
	}
	
	public RadioProgram findRP(String rpName) {
		RadioProgram rp = new RadioProgram(rpName);
		ProgramService service = new ProgramService();
		return (service.searchPrograms(rp)).get(0);	
		
	}
	public ArrayList<RadioProgram> findAllRP() {
		ProgramService service = new ProgramService();
		return service.findAllRP();
		
	}
*/	
	public void processCreate(RadioProgram rp) {
		ProgramService service = new ProgramService();
		service.processCreate(rp);
		
	}
	public void processModify(RadioProgram rp) {
		ProgramService service = new ProgramService();
		service.processModify(rp);
		
	}

	public void processDelete(String name) throws NotFoundException,SQLException {
		ProgramService service = new ProgramService();
		service.processDelete(name);
	}
        
        public RadioProgram loadRadioProgram(String name) {
            ProgramService service = new ProgramService();
            return service.findRP(name);
        }
}
