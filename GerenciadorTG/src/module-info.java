module Gerenciador {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires transitive java.sql;
	
	exports application;
	exports application.controller;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.graphics, javafx.fxml;
		
}
