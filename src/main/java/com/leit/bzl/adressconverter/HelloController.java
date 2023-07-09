package com.leit.bzl.adressconverter;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HelloController {

    @FXML
    Button get;
    @FXML
    TextField getTxt;

    private File selectedFile;

    private FileChooser fileChooser = new FileChooser();

    @FXML
    public void getClicked(Event e){
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
        getTxt.setText(selectedFile.getAbsolutePath());
        System.out.println(selectedFile.getAbsolutePath());
    }

    private void readAndCorrectCustomerData(){
        try(ICsvBeanReader beanReader
                    = new CsvBeanReader(new FileReader(selectedFile), CsvPreference.STANDARD_PREFERENCE))
        {
            // the header elements are used to map the values to the bean
            final String[] headers = beanReader.getHeader(true);
            //final String[] headers = new String[]{"CustomerId","CustomerName","Country","PinCode","Email"};
            final CellProcessor[] processors = getProcessors();

            Customer customer;
            while ((customer = beanReader.read(Customer.class, headers, processors)) != null) {
                System.out.println(customer);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets up the processors used for the examples.
     */
    private static CellProcessor[] getProcessors() {
        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+";
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");

        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseInt()), // CustomerId
                new NotNull(), // CustomerName
                new NotNull(), // Country
                new Optional(new ParseLong()), // PinCode
                new StrRegEx(emailRegex) // Email
        };
        return processors;
    }
}