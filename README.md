# vehicle-survey
Generate various vehicle survey reports based on input data file

### Project dependencies

	The project requires Java 1.7 or higher and gradle version 1.12
	
### Checkout from git
	
	git clone git@github.com:coding-challenge/vehicle-survey.git
	
### Building and Running the project

	Execute 'gradle clean build' from the project root directory to build the project.
	
	This should also run the junit testcases and create an executable jar file 'vehicle-survey.jar' in the build/libs directory.
	
	Run the Reports on the data file using the following command :
	
	java -jar build/libs/vehicle-survey.jar <path_to_input_data_file>
	