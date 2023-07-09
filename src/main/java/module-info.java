module com.leit.bzl.adressconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.leit.bzl.adressconverter to javafx.fxml;
    exports com.leit.bzl.adressconverter;
}