package com.example.services;

import java.io.Serializable;
import java.util.List;

public class Transaksjon implements Serializable{
    //TODO usikkert hva dette blir, men endring på veil
    Transaksjon_Status status_Transaksjon=Transaksjon_Status.NONE;
    //TODO forslag. Lister eventuelt avvik
    List<Avvik> listeAvvik;

    //Document/CstmrCdtTrfInitn/GrpHdr/MsgId Max35Text
    String message_id;
    //Document/CstmrCdtTrfInitn/PmtInf/PmtInfId Max35Text
    long payment_information_id;
    //Document/CstmrCdtTrfInitn/PmtInf/CdtTrfTxInf/PmtId/InstrId Max35Text
    String transaction_id;
    // EndToEndId: Unik NAV-referanse som identifiserer transaksjonen
    //Document/CstmrCdtTrfInitn/PmtInf/CdtTrfTxInf/PmtId/EndToEndId Max35Text
    String end_to_end_id;
    String instruction_priority;
    String category_purpose_code;
    Double instructed_amount;
    String current_code;
    String checque_type;
    //DlvryMtd code  : Cd MLCD, MLDB PUDB
    String delivery_method_code;
    //Navn kunde
    String creditor_name;
    String creditor_postal_code;
    String creditor_postal;
    String creditor_countrycode;
    String creditor_address;
    //Kunde
    String creditor_account;
    String creditor_code;
    String remittance_information;
    String remittance_information_code;
    String remittance_information_number;



    public Transaksjon_Status getStatus_Transaksjon() {
        return status_Transaksjon;
    }

    public void setStatus_Transaksjon(Transaksjon_Status status_Transaksjon) {
        this.status_Transaksjon = status_Transaksjon;
    }

    public List<Avvik> getListeAvvik() {
        return listeAvvik;
    }

    public void setListeAvvik(List<Avvik> listeAvvik) {
        this.listeAvvik = listeAvvik;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public long getPayment_information_id() {
        return payment_information_id;
    }

    public void setPayment_information_id(long payment_information_id) {
        this.payment_information_id = payment_information_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getEnd_to_end_id() {
        return end_to_end_id;
    }

    public void setEnd_to_end_id(String end_to_end_id) {
        this.end_to_end_id = end_to_end_id;
    }

    public String getInstruction_priority() {
        return instruction_priority;
    }

    public void setInstruction_priority(String instruction_priority) {
        this.instruction_priority = instruction_priority;
    }

    public String getCategory_purpose_code() {
        return category_purpose_code;
    }

    public void setCategory_purpose_code(String category_purpose_code) {
        this.category_purpose_code = category_purpose_code;
    }

    public Double getInstructed_amount() {
        return instructed_amount;
    }

    public void setInstructed_amount(Double instructed_amount) {
        this.instructed_amount = instructed_amount;
    }

    public String getCurrent_code() {
        return current_code;
    }

    public void setCurrent_code(String current_code) {
        this.current_code = current_code;
    }

    public String getChecque_type() {
        return checque_type;
    }

    public void setChecque_type(String checque_type) {
        this.checque_type = checque_type;
    }

    public String getDelivery_method_code() {
        return delivery_method_code;
    }

    public void setDelivery_method_code(String delivery_method_code) {
        this.delivery_method_code = delivery_method_code;
    }

    public String getCreditor_name() {
        return creditor_name;
    }

    public void setCreditor_name(String creditor_name) {
        this.creditor_name = creditor_name;
    }

    public String getCreditor_postal_code() {
        return creditor_postal_code;
    }

    public void setCreditor_postal_code(String creditor_postal_code) {
        this.creditor_postal_code = creditor_postal_code;
    }

    public String getCreditor_postal() {
        return creditor_postal;
    }

    public void setCreditor_postal(String creditor_postal) {
        this.creditor_postal = creditor_postal;
    }

    public String getCreditor_countrycode() {
        return creditor_countrycode;
    }

    public void setCreditor_countrycode(String creditor_countrycode) {
        this.creditor_countrycode = creditor_countrycode;
    }

    public String getCreditor_address() {
        return creditor_address;
    }

    public void setCreditor_address(String creditor_address) {
        this.creditor_address = creditor_address;
    }

    public String getCreditor_account() {
        return creditor_account;
    }

    public void setCreditor_account(String creditor_account) {
        this.creditor_account = creditor_account;
    }

    public String getCreditor_code() {
        return creditor_code;
    }

    public void setCreditor_code(String creditor_code) {
        this.creditor_code = creditor_code;
    }

    public String getRemittance_information() {
        return remittance_information;
    }

    public void setRemittance_information(String remittance_information) {
        this.remittance_information = remittance_information;
    }

    public String getRemittance_information_code() {
        return remittance_information_code;
    }

    public void setRemittance_information_code(String remittance_information_code) {
        this.remittance_information_code = remittance_information_code;
    }

    public String getRemittance_information_number() {
        return remittance_information_number;
    }

    public void setRemittance_information_number(String remittance_information_number) {
        this.remittance_information_number = remittance_information_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaksjon that = (Transaksjon) o;

        if (payment_information_id != that.payment_information_id) return false;
        if (status_Transaksjon != that.status_Transaksjon) return false;
        if (listeAvvik != null ? !listeAvvik.equals(that.listeAvvik) : that.listeAvvik != null) return false;
        if (message_id != null ? !message_id.equals(that.message_id) : that.message_id != null) return false;
        if (!transaction_id.equals(that.transaction_id)) return false;
        if (end_to_end_id != null ? !end_to_end_id.equals(that.end_to_end_id) : that.end_to_end_id != null)
            return false;
        if (instruction_priority != null ? !instruction_priority.equals(that.instruction_priority) : that.instruction_priority != null)
            return false;
        if (category_purpose_code != null ? !category_purpose_code.equals(that.category_purpose_code) : that.category_purpose_code != null)
            return false;
        if (instructed_amount != null ? !instructed_amount.equals(that.instructed_amount) : that.instructed_amount != null)
            return false;
        if (current_code != null ? !current_code.equals(that.current_code) : that.current_code != null) return false;
        if (checque_type != null ? !checque_type.equals(that.checque_type) : that.checque_type != null) return false;
        if (delivery_method_code != null ? !delivery_method_code.equals(that.delivery_method_code) : that.delivery_method_code != null)
            return false;
        if (creditor_name != null ? !creditor_name.equals(that.creditor_name) : that.creditor_name != null)
            return false;
        if (creditor_postal_code != null ? !creditor_postal_code.equals(that.creditor_postal_code) : that.creditor_postal_code != null)
            return false;
        if (creditor_postal != null ? !creditor_postal.equals(that.creditor_postal) : that.creditor_postal != null)
            return false;
        if (creditor_countrycode != null ? !creditor_countrycode.equals(that.creditor_countrycode) : that.creditor_countrycode != null)
            return false;
        if (creditor_address != null ? !creditor_address.equals(that.creditor_address) : that.creditor_address != null)
            return false;
        if (creditor_account != null ? !creditor_account.equals(that.creditor_account) : that.creditor_account != null)
            return false;
        if (creditor_code != null ? !creditor_code.equals(that.creditor_code) : that.creditor_code != null)
            return false;
        if (remittance_information != null ? !remittance_information.equals(that.remittance_information) : that.remittance_information != null)
            return false;
        if (remittance_information_code != null ? !remittance_information_code.equals(that.remittance_information_code) : that.remittance_information_code != null)
            return false;
        return remittance_information_number != null ? remittance_information_number.equals(that.remittance_information_number) : that.remittance_information_number == null;

    }

    @Override
    public int hashCode() {
        int result = status_Transaksjon.hashCode();
        result = 31 * result + (listeAvvik != null ? listeAvvik.hashCode() : 0);
        result = 31 * result + (message_id != null ? message_id.hashCode() : 0);
        result = 31 * result + (int) (payment_information_id ^ (payment_information_id >>> 32));
        result = 31 * result + transaction_id.hashCode();
        result = 31 * result + (end_to_end_id != null ? end_to_end_id.hashCode() : 0);
        result = 31 * result + (instruction_priority != null ? instruction_priority.hashCode() : 0);
        result = 31 * result + (category_purpose_code != null ? category_purpose_code.hashCode() : 0);
        result = 31 * result + (instructed_amount != null ? instructed_amount.hashCode() : 0);
        result = 31 * result + (current_code != null ? current_code.hashCode() : 0);
        result = 31 * result + (checque_type != null ? checque_type.hashCode() : 0);
        result = 31 * result + (delivery_method_code != null ? delivery_method_code.hashCode() : 0);
        result = 31 * result + (creditor_name != null ? creditor_name.hashCode() : 0);
        result = 31 * result + (creditor_postal_code != null ? creditor_postal_code.hashCode() : 0);
        result = 31 * result + (creditor_postal != null ? creditor_postal.hashCode() : 0);
        result = 31 * result + (creditor_countrycode != null ? creditor_countrycode.hashCode() : 0);
        result = 31 * result + (creditor_address != null ? creditor_address.hashCode() : 0);
        result = 31 * result + (creditor_account != null ? creditor_account.hashCode() : 0);
        result = 31 * result + (creditor_code != null ? creditor_code.hashCode() : 0);
        result = 31 * result + (remittance_information != null ? remittance_information.hashCode() : 0);
        result = 31 * result + (remittance_information_code != null ? remittance_information_code.hashCode() : 0);
        result = 31 * result + (remittance_information_number != null ? remittance_information_number.hashCode() : 0);
        return result;
    }
}
