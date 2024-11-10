/*just for testing the code again*/

DELETE FROM consultations /*delete first*/
WHERE consultationID = 18;

DELETE FROM doctors  /*2nd*/
WHERE doctorID = 19202632;

DELETE FROM patients /*3rd*/
WHERE patientID = 1234328500;

DELETE FROM departments /*4th*/
WHERE departmentID = 1; 

DELETE FROM address
WHERE addressID = 1128301398;

DELETE FROM address
WHERE addressID = 1811001002;

DELETE FROM address
WHERE addressID = 1121381012;
