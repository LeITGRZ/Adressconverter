package com.leit.bzl.adressconverter;

public class KundeAlt {
    private String Kundennummer;
    private String Anredebezeichnung;
    private String AktiveAdresse;
    private String Name1;
    private String Name2;
    private String Strasse;
    private String Postleitzahl;
    private String Ort;
    private String EMailAdresse;
    private String Branchenkennzeichen;
    private String Branchenbezeichnung;
    private String Statusbezeichnung;
    private String NeuanlageDatum;
    private String PflegeDatum;
    private String Werbung;

    public KundeAlt(String kundennummer,
                    String anredebezeichnung,
                    String aktiveAdresse,
                    String name1,
                    String name2,
                    String strasse,
                    String postleitzahl,
                    String ort,
                    String EMailAdresse,
                    String branchenkennzeichen,
                    String branchenbezeichnung,
                    String statusbezeichnung,
                    String neuanlageDatum,
                    String pflegeDatum,
                    String werbung) {

        Kundennummer = kundennummer;
        Anredebezeichnung = anredebezeichnung;
        AktiveAdresse = aktiveAdresse;
        Name1 = name1;
        Name2 = name2;
        Strasse = strasse;
        Postleitzahl = postleitzahl;
        Ort = ort;
        this.EMailAdresse = EMailAdresse;
        Branchenkennzeichen = branchenkennzeichen;
        Branchenbezeichnung = branchenbezeichnung;
        Statusbezeichnung = statusbezeichnung;
        NeuanlageDatum = neuanlageDatum;
        PflegeDatum = pflegeDatum;
        Werbung = werbung;
    }
}
