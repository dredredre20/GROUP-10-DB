import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller{
    private View view;
    private Model model;

    public View getView() {
	return this.view;
    }

    public Controller(View view, Model model) {
	this.view = view;
	this.model = model;

	this.getView().setBack(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		view.refresh();
		switch(view.getMenu()) {
		    case 100: 
		    case 200: 
		    case 300: 
		    case 400: 
		    case 500:
		    case 600:
		    case 700:
		    	view.mainMenu();
		    	break;
		    case 110:
		    case 120:
			view.appoint();
			break;
		    case 101:
			view.mainMenu();
			break;
		    case 210:
			view.update();
			break;
		    case 310:
			view.consult();
			break;
		    case 410:
		    case 420:
		    case 430:
			view.remove();
			break;
		    case 510:
			view.assign();
		    case 610:
			view.config();
		}
		view.setVisible();
	    }
	});

	this.getView().setConfirm(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		switch(view.getMenu()) {
		    case 110: 
		    case 120:
		    case 101:
		    case 200:
		    case 210:
		    case 300:
		    case 310:
		    case 410:
		    case 420:
		    case 430:
		    case 500:
		    case 510:
		    case 600:
		    case 610:
			view.setResult1("test");
		    	break;
		}
	    }
	});

	this.getView().setButton1(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.appoint();
			view.setVisible();
		    	break;

		    case 100:
			view.refresh();
			view.setResult1("");
		    	view.appointNew();
			view.setVisible();
			break;

		    case 400:
			view.refresh();
			view.setResult1("");
		    	view.removePatient();
			view.setVisible();
			break;

		    case 700:
			view.setResult1("test");
			break;
		}

	    }
	});

	this.getView().setButton2(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.update();
			view.setVisible();
		    	break;

		    case 100:
			view.refresh();
			view.setResult1("");
		    	view.appointOld();
			view.setVisible();
			break;

		    case 400:
			view.refresh();
			view.setResult1("");
		    	view.removeConsult();
			view.setVisible();
			break;

		    case 700:
			view.setResult1("test");
			break;
		}

	    }
	});

	this.getView().setButton3(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		switch(view.getMenu()) {
		    case 000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.remove();
			view.setVisible();
		    	break;

		    case 400:
			view.refresh();
			view.setResult1("");
		    	view.removeDoctor();
			view.setVisible();
			break;

		    case 700:
			view.setResult1("test");
			break;
		}

	    }
	});

	this.getView().setButton4(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		view.refresh();

		switch(view.getMenu()) {
		    case 000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.assign();
			view.setVisible();
		    	break;

		    case 700:
			view.setResult1("test");
			break;
		}

		view.setVisible();
	    }
	});

	this.getView().setButton5(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		view.refresh();

		switch(view.getMenu()) {
		    case 000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.config();
			view.setVisible();
		    	break;
		}

		view.setVisible();
	    }
	});

	this.getView().setButton6(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		view.refresh();

		switch(view.getMenu()) {
		    case 000: 
			view.refresh();
			view.setText1("");
			view.setResult1("");
		    	view.report();
			view.setVisible();
		    	break;
		}

		view.setVisible();
	    }
	});
    }
}
