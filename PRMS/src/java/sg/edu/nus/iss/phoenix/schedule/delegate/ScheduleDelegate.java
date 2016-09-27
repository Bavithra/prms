/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;
import sg.edu.nus.iss.phoenix.schedule.service.ScheduleService;

/**
 *
 * @author linby
 */
public class ScheduleDelegate {
    private ScheduleService service;
    
    public ScheduleDelegate(){
        service = new ScheduleService();
    }
    public void processCreateYear(Year valueObject) {
        service.processCreateYear(valueObject);
    }
    
    public void processCreateProgramSlot(ProgramSlot valueObject){
        service.processCreateProgramSlot(valueObject);
    }
    
    public void processDeleteProgramSlot(ProgramSlot valueObject){
        service.processDeleteProgramSlot(valueObject);
    }
    
    public void processUpdateProgramSlot(ProgramSlot valueObject){
        service.processUpdateProgramSlot(valueObject);
    }
}
