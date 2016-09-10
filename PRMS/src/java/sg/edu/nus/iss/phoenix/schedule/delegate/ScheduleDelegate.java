/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import sg.edu.nus.iss.phoenix.schedule.entity.Year;
import sg.edu.nus.iss.phoenix.schedule.service.ScheduleService;

/**
 *
 * @author linby
 */
public class ScheduleDelegate {
    
    public void processCreateYear(Year valueObject) {
        ScheduleService service = new ScheduleService();
        service.processCreateYear(valueObject);
    }
}
