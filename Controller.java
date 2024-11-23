import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;  
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller{
    private View view;
    private Model model;
    private Transactions transactions;
    private HMOReports reports;

    public View getView() {
	return this.view;
    }

    public Controller(View view, Model model, Transactions transactions, HMOReports reports) {
	this.view = view;
	this.model = model;
	this.transactions = transactions;
	this.reports = reports;

	this.getView().setBack(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		view.refresh();
		switch(view.getMenu()) {
		    case 1000: 
		    case 2000: 
		    case 3000: 
		    case 4000: 
		    case 5000:
		    case 6000:
		    case 7000:
		    	view.mainMenu();
		    	break;
		    case 1100:
		    case 1200:
		    case 1300:
			view.patient();
			break;
		    case 1010:
		    case 1020:
		    case 1021:
			view.patientMenu();
			break;
		    case 1011:
		    case 1012:
		    case 1013:
			view.patientMenuEdit();
			break;
		    case 2100:
			view.pUpdate(transactions.viewRecord("patients"));
			break;
		    case 3100:
			view.consult(transactions.viewRecord("consultations"));
			break;
		    case 3110:
		    case 3120:
		    case 3130:
		    case 3140:
		    case 3150:
		    case 3160:
		    case 3170:
			view.consultUpdate();
			break;
		    case 4100:
		    case 4200:
		    case 4300:
		    case 4400:
		    case 4500:
		    case 4600:
			view.remove();
			break;
		    case 5100:
		    case 5200:
		    case 5300:
			view.doctor();
			break;
		    case 5010:
		    case 5020:
		    case 5030:
			view.doctorMenu();
			break;
		    case 6100:
		    case 6200:
		    case 6300:
		    case 6400:
		    case 6500:
		    case 6600:
			view.refer();
			break;
		    case 6210:
			view.referLabEdit(transactions.viewRecord("laboratory"));
			break;
		    case 6410:
			view.refer();
			break;
		    case 6610:
			view.referMed();
			break;
		    case 7100:
		    case 7200:
		    case 7300:
		    case 7400:
			view.report();
			break;
		    case 7110:
		    case 7120:
			view.reportConsult();
			break;
		    case 7210:
		    case 7220:
			view.reportHealth();
			break;
		    case 7310:
		    case 7320:
			view.reportPerf();
			break;
		    case 7410:
		    case 7420:
			view.reportComm();
			break;
		}
		view.setVisible();
	    }
	});

	this.getView().setConfirm(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		String gender = "";
		DateTimeFormatter mdy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter mdyhm = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

		switch(view.getMenu()) {
		    case 1100: 
			if (view.isButtonSelected(view.getRadio1())) {
			    gender = "M";
			} else {
			    gender = "F";
			}
			view.setID(transactions.addPatient(view.getText1(), view.getText2(), gender, Timestamp.valueOf(LocalDate.parse(view.getText3(), mdy).atStartOfDay()), view.getText4(), view.getText5(), view.getText10()));
			transactions.addPatientContact(view.getID(), view.getText6(), view.getText7(), view.getText8(), view.getText9());
			view.refresh();
			System.out.println(view.getID());
			view.patientMenu();
			view.setVisible();
			break;
		    case 1011:
			transactions.addPatientContact(view.getID(), view.getText1(), view.getText2(), view.getText3(), view.getText4());
			break;
		    case 1012:
			transactions.removePatientContact(view.getID(), view.getText1(), view.getText2());
			break;
		    case 1013:
			if (view.isButtonSelected(view.getRadio1())) {
			    gender = "M";
			} else {
			    gender = "F";
			}
			transactions.editPatient(view.getID(), view.getText1(), view.getText2(), gender, Timestamp.valueOf(LocalDate.parse(view.getText3(), mdy).atStartOfDay()), view.getText4(), view.getText5(), view.getText6(), view.getText7());
			break;
		    case 1020:
			if (transactions.availableDoctors(LocalDateTime.parse(view.getText1(), mdyhm), LocalDateTime.parse(view.getText2(), mdyhm), transactions.getRecordAttribute("complaints", "recommendedSpecialization", "complaintDescription", view.getText3())) != null) {
			view.refresh();
			view.patientMenuConsultDoctor(transactions.availableDoctors(LocalDateTime.parse(view.getText1(), mdyhm), LocalDateTime.parse(view.getText2(), mdyhm), transactions.getRecordAttribute("complaints", "recommendedSpecialization", "complaintDescription", view.getText3())));
			view.setVisible();
			view.setText5(view.getText1());
			view.setText6(view.getText2());
			view.setText7(view.getText3());
			} else {
			    view.setResult1("No available doctors");
			}
			break;
		    case 1021:
			if(transactions.isDoctorAvailable(LocalDateTime.parse(view.getText5(), mdyhm), LocalDateTime.parse(view.getText6(), mdyhm), view.getText7(), Integer.parseInt(view.getText1()))) {
			    transactions.bookAppointment(view.getID(), Integer.parseInt(view.getText1()), Timestamp.valueOf(LocalDateTime.parse(view.getText5(), mdyhm)), Timestamp.valueOf(LocalDateTime.parse(view.getText6(), mdyhm)));
			    break;
			} else {
			    view.setResult1("Doctor unavailable");
			}
		    case 2100:
			if (view.isButtonSelected(view.getRadio1())) {
			    gender = "M";
			} else {
			    gender = "F";
			}
			transactions.editPatient(view.getID(), view.getText1(), view.getText2(), gender, Timestamp.valueOf(LocalDate.parse(view.getText3(), mdy).atStartOfDay()), view.getText4(), view.getText5(), view.getText6(), view.getText7());
			break;
		    case 3110:
			transactions.editRecord("consultations", "satisfactionRating", view.getText1(), "consultationID", view.getID());
			break;
		    case 3120:
			transactions.addLabReq(Integer.parseInt(view.getText1()), view.getID(), Integer.parseInt(transactions.getRecordAttribute("consultations", "doctorID", "consultationID", String.valueOf(view.getID()))));
			break;
		    case 3130:
			transactions.removeRecord2("labRequest", "laboratoryID", view.getText1(), "consultationID", view.getID());
			break;
		    case 3140:
			transactions.addDiagnosis(view.getID(), view.getText1(), view.getText2());
			break;
		    case 3150:
			transactions.removeRecord2("diagnosis", "diagnosisDescription", view.getText1(), "consultationID", view.getID());
			break;
		    case 3160:
			transactions.addPrescription(view.getID(), Integer.parseInt(view.getText1()), view.getText2(), view.getText3(), Timestamp.valueOf(LocalDateTime.parse(view.getText4(), mdyhm)), Timestamp.valueOf(LocalDateTime.parse(view.getText5(), mdyhm)), view.getText6());
			break;
		    case 3170:
			transactions.removeRecord2("prescription", "medicineID", view.getText1(), "consultationID", view.getID());
			break;
		    case 4100:
			transactions.removeRecord("contactPerson", "patientID", view.getText1());
			transactions.removeRecord("patients", "patientID", view.getText1());
			view.setResult1("Record removed");
			break;
		    case 4200:
			transactions.removeRecord("consultationComplaints", "consultationID", view.getText1());
			transactions.removeRecord("consultations", "consultationID", view.getText1());
			view.setResult1("Record removed");
			break;
		    case 4300:
			transactions.removeRecord("doctorWorkInfo", "doctorID", view.getText1());
			transactions.removeRecord("doctorSpecializations", "doctorID", view.getText1());
			transactions.removeRecord("doctors", "doctorID", view.getText1());
			view.setResult1("Record removed");
			break;
		    case 4400:
			transactions.removeRecord("laboratory", "laboratoryID", view.getText1());
			view.setResult1("Record removed");
			break;
		    case 4500:
			transactions.removeRecord("complaints", "complaintDescription", view.getText1());
			view.setResult1("Record removed");
			break;
		    case 4600:
			transactions.removeRecord("medicine", "medicineID", view.getText1());
			view.setResult1("Record removed");
			break;
		    case 5100:
			if (view.isButtonSelected(view.getRadio1())) {
			    gender = "M";
			} else {
			    gender = "F";
			}
			view.setID(transactions.addDoctor(view.getText1(), view.getText2(), gender, Timestamp.valueOf(LocalDate.parse(view.getText3(), mdy).atStartOfDay()), view.getText4(), view.getText5(), view.getText6()));
			transactions.addDoctorWork(view.getID(), Integer.parseInt(view.getText7()), Integer.parseInt(view.getText8()), Integer.parseInt(view.getText9()), Integer.parseInt(view.getText10()), Integer.parseInt(view.getText11()));
			view.refresh();
			System.out.println(view.getID());
			view.doctorMenu();
			view.setVisible();
			break;
		    case 5010:
			transactions.addDoctorSpecial(view.getID(), view.getText1(), view.getText2(), Timestamp.valueOf(LocalDate.parse(view.getText3(), mdy).atStartOfDay()), Timestamp.valueOf(LocalDate.parse(view.getText4(), mdy).atStartOfDay()));
			break;
		    case 5020:
			transactions.removeDoctorSpecial(view.getID(), view.getText1());
			break;
		    case 5030:
			if (view.isButtonSelected(view.getRadio1())) {
			    gender = "M";
			} else {
			    gender = "F";
			}
			transactions.editDoctor(view.getID(), view.getText1(), view.getText2(), gender, Timestamp.valueOf(LocalDate.parse(view.getText3(), mdy).atStartOfDay()), view.getText4(), view.getText5(), view.getText6());
			transactions.editDoctorWork(view.getID(), Integer.parseInt(view.getText7()), Integer.parseInt(view.getText8()), Integer.parseInt(view.getText9()), Integer.parseInt(view.getText10()), Integer.parseInt(view.getText11()));
			view.setResult1("Edit success");
			break;
		    case 6100:
			transactions.addLab(view.getText1(), view.getText2(), view.getText3());
			break;
		    case 6210:
			transactions.editLab(view.getID(), view.getText1(), view.getText2(), view.getText3());
			break;
		    case 6300:
			transactions.addComplaint(view.getText1(), view.getText2());
			break;
		    case 6410:
			transactions.editComplaint(view.getText1(), view.getText2());
			break;
		    case 6500:
			transactions.addMedicine(view.getText1(), view.getText2(), Integer.parseInt(view.getText3()), Integer.parseInt(view.getText4()));
			break;
		    case 6610:
			transactions.editMedicine(view.getText1(), view.getText2(), Integer.parseInt(view.getText3()), Integer.parseInt(view.getText4()));
		    	break;
		    case 1200:
			try {
			if (transactions.patientID(Integer.parseInt(view.getText1()))) {
			    view.refresh();
			    view.setID(Integer.parseInt(view.getText1()));
			    view.setText1("");
			    view.setResult1("");
		    	    view.patientMenu();
			    view.setVisible();	
			} else {
			    view.setResult1("ID does not exist");
			}
			} catch (Exception _) {
			    view.setResult1("Input an integer");
			}
		    	break;
		    case 2000:
			view.refresh();
			if(transactions.patientID(Integer.parseInt(view.getText1()))) {
				view.setID(Integer.parseInt(view.getText1()));
				view.refresh();
				view.setText1(transactions.patientAttribute("patientLastName", view.getID()));
				view.setText2(transactions.patientAttribute("patientFirstName", view.getID()));
				if (transactions.patientAttribute("sex", view.getID()).equals("M"))
					view.setSelected(view.getRadio1());
				else
					view.setSelected(view.getRadio2());
				view.setText3(transactions.patientAttribute("birthday", view.getID()));
				view.setText4(transactions.patientAttribute("phoneNumber", view.getID()));
				view.setText5(transactions.patientAttribute("address", view.getID()));
				view.setText6(transactions.patientAttribute("bloodType", view.getID()));
				view.setText7(transactions.patientAttribute("allergies", view.getID()));
			view.setResult1("");
		    	view.pUpdateData();
			view.setVisible();
			}
			break;
		    case 3000:
			view.refresh();
			view.setID(Integer.parseInt(view.getText1()));
		    	view.consultUpdate();
			view.setVisible();
		    	break;
		    case 5200:
			if(transactions.doctorID(Integer.parseInt(view.getText1())))
			    view.setID(Integer.parseInt(view.getText1()));
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.doctorMenu();
			view.setVisible();
		    	break;
		    case 6200:
			try {
			    if(transactions.findID(view.getText1(),"laboratory","laboratoryID")) {
			    	view.refresh();
			    	view.setID(Integer.parseInt(view.getText1()));
			    	view.setText1("");
			    	view.setResult1("");
		    	    	view.referLabEditData();
			    	view.setVisible();
                            } else {
			    	view.setResult1("ID not found");
			    }
			} catch (Exception _) {
			    view.setResult1("Input an integer");
			}
		    	break;
		    case 6400:
			try {
			    if(transactions.findID(view.getText1(),"complaints","complaintDescription")) {
			    	view.refresh();
			    	view.setID(Integer.parseInt(view.getText1()));
			    	view.setText1("");
			    	view.setResult1("");
		    	    	view.referCompEditData(transactions.getSpecial());
			    	view.setVisible();
                            } else {
			    	view.setResult1("ID not found");
			    }
			} catch (Exception _) {
			    view.setResult1("Invalid input");
			}
		    	break;
		    case 6600:
			try {
			    if(transactions.findID(view.getText1(),"medicine","medicineID")) {
			    	view.refresh();
			    	view.setID(Integer.parseInt(view.getText1()));
			    	view.setText1("");
			    	view.setResult1("");
		    	    	view.referMedEditData();
			    	view.setVisible();
                            } else {
			    	view.setResult1("ID not found");
			    }
			} catch (Exception _) {
			    view.setResult1("Invalid input");
			}
		    	break;
		}
	    }
	});

	this.getView().setButton1(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.patient();
			view.setVisible();
		    	break;

		    case 1000:
			view.refresh();
			view.setResult1("");
		    	view.patientNew();
			view.setVisible();
			break;

		    case 1300:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuEdit();
			view.setVisible();
			break;

		    case 1010:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuEditAddC();
			view.setVisible();
			break;

		    case 1020:
			view.setResult1("test");
			break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultUpdateRating();
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removePatient(transactions.viewRecord("patients"));
			view.setVisible();
			break;

		    case 5000:
			view.refresh();
			view.setResult1("");
		    	view.doctorNew();
			view.setVisible();
			break;

		    case 5300:
			view.refresh();
			view.setResult1("");
			view.setText1("");
			view.setText2("");
			view.setText3("");
			view.setText4("");
		    	view.doctorMenuAdd();
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referLabAdd();
			view.setVisible();
			break;

		    case 7000:
			view.refresh();
			view.reportConsult();
			view.setVisible();
			break;

		    case 7100:
				view.refresh();
				try {
					view.reportConsultMonth(reports.monthlyPatientAccomodations(Integer.parseInt(view.getText2()), Integer.parseInt(view.getText1())));					

				} catch (Exception e4){
					view.setResult1("No reports to be found.");
				}
				view.setVisible();
			break;

			case 7200:
				view.refresh();

				try {
					view.reportHealthMonth(reports.monthlyHealthRiskReport(Integer.parseInt(view.getText2()), Integer.parseInt(view.getText1())));
				} catch (Exception e5) {
					view.setResult1("No reports to be found.");
				}
			view.setVisible();
			break;

		    case 7300:
				view.refresh();
				try {
					view.reportPerfMonth(reports.monthlyPerformanceEvaluation(Integer.parseInt(view.getText2()), Integer.parseInt(view.getText1())));
				} catch (Exception e6) {
					view.setResult1("No reports to be found.");
				}
				view.setVisible();
			break;

		    case 7400:
				view.refresh();
				try {
					view.reportCommMonth(reports.monthlyCommissionReport(Integer.parseInt(view.getText2()), Integer.parseInt(view.getText1())));
				} catch (Exception e7) {
					view.setResult1("No reports to be found.");
				}
				view.setVisible();
			break;			
		}

	    }
	});

	this.getView().setButton2(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.pUpdate(transactions.viewRecord("patients"));
			view.setVisible();
		    	break;

		    case 1000:
			view.refresh();
			view.setResult1("");
		    	view.patientOld(transactions.viewRecord("patients"));
			view.setVisible();
			break;

		    case 1300:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuConsult(transactions.viewRecord("complaints"));
			view.setVisible();
			break;

		    case 1010:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuEditRemoveC(transactions.viewRecord2("contactPerson", "patientID", view.getID()));
			view.setVisible();
			break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultUpdateLab(transactions.viewRecord("laboratory"));
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeConsult(transactions.viewRecord("consultations"));
			view.setVisible();
			break;

		    case 5000:
			view.refresh();
			view.setResult1("");
		    	view.doctorOld(transactions.viewRecord("doctors"));
			view.setVisible();
			break;

		    case 5300:
			view.refresh();
			view.setResult1("");
		    	view.doctorMenuRemove(transactions.viewDoctorSpecial(view.getID()));
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referLabEdit(transactions.viewRecord("laboratory"));
			view.setVisible();
			break;

		    case 7000:
			view.refresh();
			view.reportHealth();
			view.setVisible();
			break;

		   case 7100:
				view.refresh();

				try {
					view.reportConsultYear(reports.yearlyPatientAccomodations(Integer.parseInt(view.getText2())));
				} catch (Exception e2) {
					view.setResult1("No reports to be found.");
				}

				view.setVisible();
			break;

		    case 7200:
				view.refresh();

				try {
					view.reportHealthYear(reports.yearlyHealthRiskReport(Integer.parseInt(view.getText2())));
				} catch (Exception e7) {
					view.setResult1("No reports to be found.");
				}
				view.setVisible();

			break;

		    case 7300:
				view.refresh();
				try {
					view.reportPerfYear(reports.YearlyPerformanceEvaluation(Integer.parseInt(view.getText2())));
				} catch (Exception e7) {
					view.setResult1("No reports to be found.");
				}
				view.setVisible();
			break;

		    case 7400:
				view.refresh();
				try {
					view.reportCommYear(reports.yearlyCommissionReport(Integer.parseInt(view.getText2())));
				} catch (Exception e7) {
					view.setResult1("No reports to be found.");
				}	
				view.setVisible();
			break;	
		}

	    }
	});

	this.getView().setButton3(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.consult(transactions.viewRecord("consultations"));
			view.setVisible();
		    	break;

		    case 1010:
			view.refresh();
			if(transactions.patientID(view.getID())) {
				view.refresh();
				view.setText1(transactions.patientAttribute("patientLastName", view.getID()));
				view.setText2(transactions.patientAttribute("patientFirstName", view.getID()));
				if (transactions.patientAttribute("sex", view.getID()).equals("M"))
					view.setSelected(view.getRadio1());
				else
					view.setSelected(view.getRadio2());
				view.setText3(transactions.patientAttribute("birthday", view.getID()));
				view.setText4(transactions.patientAttribute("phoneNumber", view.getID()));
				view.setText5(transactions.patientAttribute("address", view.getID()));
				view.setText6(transactions.patientAttribute("bloodType", view.getID()));
				view.setText7(transactions.patientAttribute("allergies", view.getID()));
			view.setResult1("");
		    	view.patientMenuEditPatient();
			view.setVisible();
			}
			break;
		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultRemoveLab(transactions.viewRecord2("labRequest", "consultationID", view.getID()));
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeDoctor(transactions.viewRecord("doctors"));
			view.setVisible();
			break;

		    case 5300:
			view.refresh();
			view.setResult1("");
			view.setText1(transactions.doctorAttribute("lastName", view.getID()));
			view.setText2(transactions.doctorAttribute("firstName", view.getID()));
			if (transactions.doctorAttribute("sex", view.getID()).equals("M"))
			    view.setSelected(view.getRadio1());
			else
			    view.setSelected(view.getRadio2());
			view.setText3(transactions.doctorAttribute("birthday", view.getID()));
			view.setText4(transactions.doctorAttribute("phoneNumber", view.getID()));
			view.setText5(transactions.doctorAttribute("address", view.getID()));
			view.setText6(transactions.doctorAttribute("email", view.getID()));
			view.setText7(transactions.getRecordAttribute("doctorWorkInfo", "salary", "doctorID", String.valueOf(view.getID())));
			view.setText8(transactions.getRecordAttribute("doctorWorkInfo", "licenseNumber", "doctorID", String.valueOf(view.getID())));
			view.setText9(transactions.getRecordAttribute("doctorWorkInfo", "workingStart", "doctorID", String.valueOf(view.getID())));
			view.setText10(transactions.getRecordAttribute("doctorWorkInfo", "workingEnd", "doctorID", String.valueOf(view.getID())));
			view.setText11(transactions.getRecordAttribute("doctorWorkInfo", "maxPatientLoad", "doctorID", String.valueOf(view.getID())));
		    	view.doctorMenuEdit();
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referComp(transactions.getSpecial());
			view.setVisible();
			break;

		    case 7000:
			view.refresh();
			view.reportPerf();
			view.setVisible();
			break;
		}

	    }
	});

	this.getView().setButton4(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.remove();
			view.setVisible();
		    	break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultUpdateDia();
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeLab(transactions.viewRecord("laboratory"));
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referCompEdit(transactions.viewRecord("complaints"));
			view.setVisible();
			break;

		    case 7000:
			view.refresh();
			view.reportComm();
			view.setVisible();
			break;
		}
	    }
	});

	this.getView().setButton5(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.doctor();
			view.setVisible();
		    	break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultRemoveDia(transactions.viewRecord2("diagnosis", "consultationID", view.getID()));
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeComplaint(transactions.viewRecord("complaints"));
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referMed();
			view.setVisible();
			break;

		    case 7000:
			view.setResult1("test");
			break;
		}
	    }
	});

	this.getView().setButton6(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.refer();
			view.setVisible();
		    	break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultUpdatePre(transactions.viewRecord("medicine"));
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeMedicine(transactions.viewRecord("medicine"));
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referMedEdit(transactions.viewRecord("medicine"));
			view.setVisible();
			break;

		    case 7000:
			view.setResult1("test");
			break;
		}
	    }
	});

	this.getView().setButton7(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 0000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.report();
			view.setVisible();
		    	break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultRemovePre(transactions.viewRecord2("prescription", "consultationID", view.getID()));
			view.setVisible();
			break;
		}
	    }
	});
    }
}
