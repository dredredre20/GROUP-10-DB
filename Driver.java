public class Driver {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // First populate the data
            PopulateData.main(null);
            
            // Then initialize MVC components
            View view = new View();

		//ENTER DATABASE HERE

		String hmo = "jdbc:mysql://127.0.0.1:3306/hmo";
		String user = "root";
		String pass = "password";

	        Transactions transactions = new Transactions(hmo, user, pass);
		HMOReports reports = new HMOReports(hmo, user, pass);
            Controller controller = new Controller(view, transactions, reports);
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
        }
    }
}
