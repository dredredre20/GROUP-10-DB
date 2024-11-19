public class Driver {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // First populate the data
            PopulateData.main(null);
            
            // Then initialize MVC components
            View view = new View();
            Model model = new Model();
            Controller controller = new Controller(view, model);
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("Make sure mysql-connector-j-9.1.0.jar is in your classpath");
            e.printStackTrace();
        }
    }
}
