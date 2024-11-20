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

    public View getView() {
	return this.view;
    }

    public Controller(View view, Model model, Transactions transactions) {
	this.view = view;
	this.model = model;
	this.transactions = transactions;

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
			view.patientMenu();
			break;
		    case 1011:
		    case 1012:
		    case 1013:
			view.patientMenuEdit();
			break;
		    case 2100:
			view.pUpdate();
			break;
		    case 3100:
			view.consult();
			break;
		    case 3110:
		    case 3120:
		    case 3130:
		    case 3140:
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
			view.referLabEdit();
			break;
		    case 6410:
			view.referCompEdit();
			break;
		    case 6610:
			view.referMedEdit();
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

		switch(view.getMenu()) {
		    case 1100: 
		    case 1011:
		    case 1012:
		    case 1013:
		    case 1020:
		    case 2100:
		    case 3110:
		    case 3120:
		    case 3130:
		    case 3140:
		    case 4100:
		    case 4200:
		    case 4300:
		    case 4400:
		    case 4500:
		    case 4600:
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
		    case 6210:
		    case 6300:
		    case 6410:
		    case 6500:
		    case 6610:
			view.setResult1("test");
		    	break;
		    case 1200:
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.patientMenu();
			view.setVisible();
		    	break;
		    case 2000:
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.pUpdateData();
			view.setVisible();
		    	break;
		    case 3000:
			view.refresh();
			view.setText1("");
			view.setResult1("");
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
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.referLabEditData();
			view.setVisible();
		    	break;
		    case 6400:
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.referCompEditData();
			view.setVisible();
		    	break;
		    case 6600:
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.referMedEditData();
			view.setVisible();
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
		    	view.removePatient();
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
			view.setResult1("test");
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
		    	view.pUpdate();
			view.setVisible();
		    	break;

		    case 1000:
			view.refresh();
			view.setResult1("");
		    	view.patientOld();
			view.setVisible();
			break;

		    case 1300:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuConsult();
			view.setVisible();
			break;

		    case 1010:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuEditRemoveC();
			view.setVisible();
			break;

		    case 3100:
			view.refresh();
			view.setResult1("");
		    	view.consultUpdateLab();
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeConsult();
			view.setVisible();
			break;

		    case 5000:
			view.refresh();
			view.setResult1("");
		    	view.doctorOld(transactions.viewDoctor());
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
		    	view.referLabEdit();
			view.setVisible();
			break;

		    case 7000:
			view.setResult1("test");
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
		    	view.consult();
			view.setVisible();
		    	break;

		    case 1010:
			view.refresh();
			view.setResult1("");
		    	view.patientMenuEditPatient();
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
		    	view.removeDoctor();
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
			view.setText7(transactions.doctorWorkAttribute("salary", view.getID()));
			view.setText8(transactions.doctorWorkAttribute("licenseNumber", view.getID()));
			view.setText9(transactions.doctorWorkAttribute("workingStart", view.getID()));
			view.setText10(transactions.doctorWorkAttribute("workingEnd", view.getID()));
			view.setText11(transactions.doctorWorkAttribute("maxPatientLoad", view.getID()));
		    	view.doctorMenuEdit();
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referComp();
			view.setVisible();
			break;

		    case 7000:
			view.setResult1("test");
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
		    	view.consultUpdatePre();
			view.setVisible();
			break;

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeLab();
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referCompEdit();
			view.setVisible();
			break;

		    case 7000:
			view.setResult1("test");
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

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeComplaint();
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

		    case 4000:
			view.refresh();
			view.setResult1("");
		    	view.removeMedicine();
			view.setVisible();
			break;

		    case 6000:
			view.refresh();
			view.setResult1("");
		    	view.referMedEdit();
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
		}
	    }
	});
    }
}
