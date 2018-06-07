/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * ---------------------------------------------------------------------
 *
 * Program Name: FormValidate.js
 *
 * Author      : Vinoth.R        Date :  Aug 2010.
 *
 *---------------------------------------------------------------------
 *
 * Description
 *
 *
 *
 *
 *
 *
 *
 *---------------------------------------------------------------------
 *Corrections
 *---------------------------------------------------------------------
 *
 *
 * Name            Date      Version                ECCO     Reason
 *
 *
 *
 *---------------------------------------------------------------------
 *
 * */
var isalpha = /^[A-Za-z0-9_.]{1,20}$/;//for alpha numeric
var isletter = /^[A-Za-z_.]{1,30}$/;//for characters
var isdate = /^[0-9\/-_.]{1,11}$/;//for date
var isnumber = /^[0-9_.]{1,3}$/;//for numbers
var isbankcharg = /^[0-9\._.]{1,5}$/;
var isreceiptno = /^[0-9\._.]{1,10}$/;
window.history.forward(-1);
//to trim
String.prototype.trim_js = function()
{
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
};

$(document).ready(function() {
    $(function() {
        /*
         * this swallows backspace keys on any non-input element.
         * stops backspace -> back
         */
        var rx = /INPUT|SELECT|TEXTAREA/i;

        $(document).bind("keydown keypress", function(e) {
            if (e.which == 8) { // 8 == backspace
                if (!rx.test(e.target.tagName) || e.target.disabled || e.target.readOnly) {
                    e.preventDefault();
                }
            }
        });
    });
});
// clear space
function clearSpace(id)
{
    document.getElementById(id).value = document.getElementById(id).value.trim_js();
}
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

function isNumberWithComma(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57) && charCode != 44) {
        return false;
    }
    return true;
}



function CheckNumericValue(e)                                                      //number only
{
    var key;
    key = e.which ? e.which : e.keyCode;
    if (key >= 48 && key <= 57) {
        return true;
    }
    else {
        //alert("please enter number only");
        return false;
    }

}
function CheckSignedNumericValue(e)                                                      //number only
{
    var key;
    key = e.which ? e.which : e.keyCode;
    if (key == 45 || (key >= 48 && key <= 57)) {
        return true;
    }
    else {
        //alert("please enter number only");
        return false;
    }

}
function checkZeroMinus(id)
{
    var pa = document.getElementById(id).value;
    if ((pa.length == 1 && pa == '0'))
    {
        var pa1 = parseInt(pa);
        if (pa1 == 0) {
            document.getElementById(id).value = "";
        }
    }
    else if (pa.length > 0)
    {
        if (pa.indexOf("-") != -1)
        {
            if (pa.indexOf("-", 0) > 0)
            {
            }
        }
    }
//                 else if(pa1 == 0)
//                 {}
}
function checkZero(id)
{
    var pa = document.getElementById(id).value;
    var pa1 = parseInt(pa);
    if ((pa.length == 1 && pa == '0') || pa1 == 0)
    {
        document.getElementById(id).value = "";
    }
//                 else if(pa1 == 0)
//                 {}
}
function floatValidation_minus(e, control)                                             //decimal points 3 after .
{

    if (e.keyCode == 46)
    {
        var patt1 = new RegExp("\\.");
        var ch = patt1.exec(control.value);
        if (ch == ".")
        {
            e.keyCode = 0;
        }


    }
    else if (e.keyCode == 45) {
        var patt2 = new RegExp("\\-");
        var ch1 = patt2.exec(control.value);
        if (ch1 == "-")
        {
            e.keyCode = 0;
        }
    }
    else if ((e.keyCode >= 48 && e.keyCode <= 57) || e.keyCode == 8)//Numbers or BackSpace
    {
        if (control.value.indexOf('.') != -1)//. Exisist in TextBox
        {
            var pointIndex = control.value.indexOf('.');
            var beforePoint = control.value.substring(0, pointIndex);
            var afterPoint = control.value.substring(pointIndex + 1);
            var iCaretPos = 0;
            if (document.selection)
            {
                if (control.type == 'text') // textbox
                {
                    var selectionRange = document.selection.createRange();
                    selectionRange.moveStart('character', -control.value.length);
                    iCaretPos = selectionRange.text.length;
                }
            }
            if (iCaretPos > pointIndex && afterPoint.length >= 3)
            {
                e.keyCode = 0;
            }
            else if (iCaretPos <= pointIndex && beforePoint.length >= 7)
            {
                e.keyCode = 0;
            }
        }
        else//. Not Exisist in TextBox
        {
            if (control.value.length >= 7)
            {
                e.keyCode = 0;
            }
        }
    }
    else
    {
        e.keyCode = 0;
    }
}
function floatValidation(e, control)                                             //decimal points 3 after .
{
    if (e.keyCode == 46)
    {
        var patt1 = new RegExp("\\.");
        var ch = patt1.exec(control.value);
        if (ch == ".")
        {
            e.keyCode = 0;
        }
    }
    else if ((e.keyCode >= 48 && e.keyCode <= 57) || e.keyCode == 8)//Numbers or BackSpace
    {
        if (control.value.indexOf('.') != -1)//. Exisist in TextBox
        {
            var pointIndex = control.value.indexOf('.');
            var beforePoint = control.value.substring(0, pointIndex);
            var afterPoint = control.value.substring(pointIndex + 1);
            var iCaretPos = 0;
            if (document.selection)
            {
                if (control.type == 'text') // textbox
                {
                    var selectionRange = document.selection.createRange();
                    selectionRange.moveStart('character', -control.value.length);
                    iCaretPos = selectionRange.text.length;
                }
            }
            if (iCaretPos > pointIndex && afterPoint.length >= 3)
            {
                e.keyCode = 0;
            }
            else if (iCaretPos <= pointIndex && beforePoint.length >= 7)
            {
                e.keyCode = 0;
            }
        }
        else//. Not Exisist in TextBox
        {
            if (control.value.length >= 7)
            {
                e.keyCode = 0;
            }
        }
    }
    else
    {
        e.keyCode = 0;
    }
}

function myFloatValidation(e, control)                                             //decimal points 3 after .
{
    if (e.keyCode == 46)
    {
        var patt1 = new RegExp("\\.");
        var ch = patt1.exec(control.value);
        if (ch == ".")
        {
            return false;
//            e.keyCode = 0;
        }
    }
    else if ((e.keyCode >= 48 && e.keyCode <= 57) || e.keyCode == 8)//Numbers or BackSpace
    {
        if (control.value.indexOf('.') != -1)//. Exisist in TextBox
        {
            var pointIndex = control.value.indexOf('.');
            var beforePoint = control.value.substring(0, pointIndex);
            var afterPoint = control.value.substring(pointIndex + 1);
            var iCaretPos = 0;
            if (document.selection)
            {
                if (control.type == 'text') // textbox
                {
                    var selectionRange = document.selection.createRange();
                    selectionRange.moveStart('character', -control.value.length);
                    iCaretPos = selectionRange.text.length;
                }
            }
            if (iCaretPos > pointIndex && afterPoint.length >= 2)
            {
                return false;
//                e.keyCode = 0;
            }
            else if (iCaretPos <= pointIndex && beforePoint.length >= 12)
            {
                return false;
//                e.keyCode = 0;
            }
        }
        else//. Not Exisist in TextBox
        {
            if (control.value.length >= 12)
            {
                return false;
//                e.keyCode = 0;
            }
        }
    }
    else
    {
        return false;
//        e.keyCode =0;
    }
}
function setCaretPosition(ctrl, pos)
{
    if (ctrl.setSelectionRange)
    {
        ctrl.focus();
        ctrl.setSelectionRange(pos, pos);
    }
    else if (ctrl.createTextRange)
    {
        var range = ctrl.createTextRange();
        range.collapse(true);
        range.moveEnd('character', pos);
        range.moveStart('character', pos);
        range.select();
    }
}

function alphaOnly(evt)
{
    var charCode = (evt.which) ? evt.which : window.event.keyCode;

    if (charCode <= 13)
    {
        return true;
    }
    else
    {
        var keyChar = String.fromCharCode(charCode);
        var re = /[a-zA-Z]/
        return re.test(keyChar);
    }
}

function alphaNumOnly(evt)
{
    var charCode = (evt.which) ? evt.which : window.event.keyCode;

    if (charCode <= 13)
    {
        return true;
    }
    else if (charCode == 32)
    {
        return true;
    }
    else
    {
        var keyChar = String.fromCharCode(charCode);
        var re = /[a-zA-Z0-9_-]/
        return re.test(keyChar);
    }
}
function noWhiteSpace(evt)
{
    var charCode = (evt.which) ? evt.which : window.event.keyCode;

    if (charCode <= 13)
    {
        return true;
    }
    else
    {
        var keyChar = String.fromCharCode(charCode);
        var re = /\s/
        return !re.test(keyChar);
    }
}
//======================================================= Date Validation (Vinoth)===============================================
/**
 * DHTML date validation script for dd/mm/yyyy. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */
// Declaring valid date character, minimum year and maximum year
var dtCh = "/";
var cur_date = new Date();
var minYear = cur_date.getYear();
var maxYear = minYear + 1;

function isInteger(s) {
    var i;
    for (i = 0; i < s.length; i++) {
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9")))
            return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag) {
    var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++) {
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1)
            returnString += c;
    }
    return returnString;
}

function daysInFebruary(year) {
    // February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ((!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28);
}
function DaysArray(n) {
    for (var i = 1; i <= n; i++) {
        this[i] = 31
        if (i == 4 || i == 6 || i == 9 || i == 11) {
            this[i] = 30
        }
        if (i == 2) {
            this[i] = 29
        }
    }
    return this
}

function isDate(dtStr) {
    var daysInMonth = DaysArray(12)
    var pos1 = dtStr.indexOf(dtCh)
    var pos2 = dtStr.indexOf(dtCh, pos1 + 1)
    var strDay = dtStr.substring(0, pos1)
    var strMonth = dtStr.substring(pos1 + 1, pos2)
    var strYear = dtStr.substring(pos2 + 1)
    strYr = strYear
    if (strDay.charAt(0) == "0" && strDay.length > 1)
        strDay = strDay.substring(1)
    if (strMonth.charAt(0) == "0" && strMonth.length > 1)
        strMonth = strMonth.substring(1)
    for (var i = 1; i <= 3; i++) {
        if (strYr.charAt(0) == "0" && strYr.length > 1)
            strYr = strYr.substring(1)
    }
    month = parseInt(strMonth)
    day = parseInt(strDay)
    year = parseInt(strYr)
    if (pos1 == -1 || pos2 == -1) {
        alert("The date format should be : dd/mm/yyyy")
        return false
    }
    if (strMonth.length < 1 || month < 1 || month > 12) {
        alert("Please enter a valid month")
        return false
    }
    if (strDay.length < 1 || day < 1 || day > 31 || (month == 2 && day > daysInFebruary(year)) || day > daysInMonth[month]) {
        alert("Please enter a valid day")
        return false
    }
    if (strYear.length != 4 || year == 0 || year < minYear || year > maxYear) {
        alert("Please enter a valid 4 digit year between " + minYear + " and " + maxYear)
        return false
    }
    if (dtStr.indexOf(dtCh, pos2 + 1) != -1 || isInteger(stripCharsInBag(dtStr, dtCh)) == false) {
        alert("Please enter a valid date")
        return false
    }
    return true
}

//date validation ends here
//====================================================================================================================================

//Invoice Table Validation
function checkInvoiceTable() {

    var table = document.getElementById('invoicetable');
    var rowCount = table.rows.length;

    for (i = 2; i <= rowCount; i++) {
        //for Product Code
        if (document.getElementById("productcodetxt" + i).value == "") {
            document.getElementById("productcodetxt" + i).style.borderColor = "red";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "";
            document.getElementById("batchtxt" + i).style.backgroundColor = "";
            document.getElementById("nopacktxt" + i).style.borderColor = "";
            return false;
        }
        else if (!isalpha.test(document.getElementById("productcodetxt" + i).value)) {
            document.getElementById("productcodetxt" + i).style.borderColor = "red";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "";
            document.getElementById("batchtxt" + i).style.backgroundColor = "";
            document.getElementById("nopacktxt" + i).style.borderColor = "";
            return false;
        }
        //for Storage Location
        else if (document.getElementById("storageloctxt" + i).value == "")
        {
            document.getElementById("productcodetxt" + i).style.borderColor = "";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "red";
            document.getElementById("batchtxt" + i).style.backgroundColor = "";
            document.getElementById("nopacktxt" + i).style.borderColor = "";
            return false;
        }
        //for Batch
        else if (document.getElementById("batchtxt" + i).value == "") {
            document.getElementById("productcodetxt" + i).style.borderColor = "";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "";
            document.getElementById("batchtxt" + i).style.backgroundColor = "red";
            document.getElementById("nopacktxt" + i).style.borderColor = "";
            return false;
        }
        //for Number of Packs
        else if (document.getElementById("nopacktxt" + i).value == "") {
            document.getElementById("productcodetxt" + i).style.borderColor = "";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "";
            document.getElementById("batchtxt" + i).style.backgroundColor = "";
            document.getElementById("nopacktxt" + i).style.borderColor = "red";
            return false;
        }
        else if (!isnumber.test(document.getElementById("nopacktxt" + i).value)) {
            document.getElementById("productcodetxt" + i).style.borderColor = "";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "";
            document.getElementById("batchtxt" + i).style.backgroundColor = "";
            document.getElementById("nopacktxt" + i).style.borderColor = "red";
            return false;
        }
        else {
            document.getElementById("productcodetxt" + i).style.borderColor = "";
            document.getElementById("storageloctxt" + i).style.backgroundColor = "";
            document.getElementById("batchtxt" + i).style.backgroundColor = "";
            document.getElementById("nopacktxt" + i).style.borderColor = "";
            return true;
        }
    }//end of for loop
}
//Invoice-customer code validation
function in_custcode()
{
    var custcode = document.getElementById("customercodetxt").value;
    var nam = document.getElementById("customercodetxt");
    // alert(custcode.value);
    if (custcode == "") {
        nam.style.borderColor = "red";
        ErrorLoad("Enter Customer Code!");
        //nam.focus();
        return false;
    }
    else if (!isalpha.test(custcode)) {
        nam.style.borderColor = "red";
        // ErrorLoad("Invalid Customer Code!");
        //nam.focus();
        return false;
    }
    else {
        // document.getElementById("customercodetxt")
        nam.style.borderColor = "";
        ErrorLoad("");
        //loadXMLDoc();
        return true;
    }

}//Invoice-Sales Officer code validation
function in_socode() {
    var nam = document.getElementById("socodetxt");
    var socode = document.getElementById("socodetxt").value;
    if (socode == "") {
        nam.style.borderColor = "red";
        ErrorLoad("Invalid SO Code!");
        nam.focus();
        return false;
    }
    else if (!isalpha.test(socode)) {
        //document.getElementById("socodetxt").
        nam.style.borderColor = "red";
        ErrorLoad("Invalid SO Code!");
        nam.focus();
        return false;
    }
    else {
        //document.getElementById("socodetxt").
        nam.style.borderColor = "";
        ErrorLoad("");
        return true;
    }
}
//Invoice-pay by date validation
function in_paybydate() {
    var paybydate = document.getElementById("paybydatetxt").value;
    if (paybydate == "") {
        document.getElementById("paybydatetxt").style.borderColor = "red";
        ErrorLoad("Enter Pay By Date!");
        document.getElementById("paybydatetxt").focus();
        return false;
    }
    else if (!isdate.test(paybydate)) {
        document.getElementById("paybydatetxt").style.borderColor = "red";
        ErrorLoad("Invalid Pay By Date!");
        document.getElementById("paybydatetxt").focus();
        return false;
    }
    else {
        document.getElementById("paybydatetxt").style.borderColor = "";
        return true;
    }
}
function in_date() {

    var invoice_date = document.getElementById("datetxt").value;
    if (invoice_date == "") {
        document.getElementById("datetxt").style.borderColor = "red";
        ErrorLoad("Enter Invoice Date!");
        document.getElementById("datetxt").focus();
        return false;
    }
    else if (!isdate.test(invoice_date)) {
        document.getElementById("datetxt").style.borderColor = "red";
        ErrorLoad("Invalid Invoice Date!");
        document.getElementById("datetxt").focus();
        return false;
    }
    else {
        document.getElementById("datetxt").style.borderColor = "";
        return true;
    }
}

//Invoice Form Validation
function checkInvoice() {
    if (!in_custcode()) {
        return false;
    }
    else if (!in_socode()) {
        return false;
    }
    else if (!in_paybydate()) {
        return false;
    }
    else if (!in_date()) {
        return false;
    }
    else {
        return true;
    }
}

//Complete Invoice Validation
function combineInvoice() {
    // alert("check invoice");
    if (!checkInvoice()) {
        return false;
    }
    else if (!checkInvoiceTable()) {
        return false;
    }
    else {
        return true;
    }
}

//for SRCN Creation
//SRCN - Reasons for Stock Return
function srcn_reason() {
    var srcn_reason = document.getElementById("reasontxt").value;
    if (srcn_reason == "") {
        document.getElementById("reasontxt").style.backgroundColor = "red";
        return false;
    }
    else {
        document.getElementById("reasontxt").style.backgroundColor = "";
        return true;
    }
}
function checkSRCN() {
    if (!srcn_Invoice()) {
        return false;
    }
    else if (!srcn_reason()) {
        return false;
    }
    else {
        return true;
    }
}


//for Accounts Receivable Status
//Accounts Receivable Status - Sales Office
function ac_SalesOffice() {
    var ac_soffice = document.getElementById("salesofficetxt").value;
    if (ac_soffice == "") {
        document.getElementById("salesofficetxt").style.backgroundColor = "red";
        ErrorLoad("Enter Sales Office Code!");
        document.getElementById("salesofficetxt").focus();
        return false;
    }
    else if (!isalpha.test(ac_soffice)) {
        document.getElementById("salesofficetxt").style.backgroundColor = "red";
        ErrorLoad("Invalid Sales Office Code!");
        document.getElementById("salesofficetxt").focus();
        return false;
    }
    else {
        document.getElementById("salesofficetxt").style.backgroundColor = "";
        return true;
    }
}
//Accounts Receivable Status - Sales Executive
function ac_SalesExecutive() {
    var ac_salesexe = document.getElementById("salesexecutivetxt").value;
    if (ac_salesexe == "") {
        document.getElementById("salesexecutivetxt").style.borderColor = "red";
        ErrorLoad("Enter Sales Executive Code!");
        document.getElementById("salesexecutivetxt").focus();
        return false;
    }
    else if (!isalpha.test(ac_salesexe)) {
        document.getElementById("salesexecutivetxt").style.borderColor = "red";
        ErrorLoad("Invalid Sales Executive Code!");
        document.getElementById("salesexecutivetxt").focus();
        return false;
    }
    else {
        document.getElementById("salesexecutivetxt").style.borderColor = "";
        return true;
    }
}
//Accounts Receivable Status - Customer
function ac_Customer() {
    var ac_customer = document.getElementById("customertxt").value;
    if (ac_customer == "") {
        document.getElementById("customertxt").style.borderColor = "red";
        ErrorLoad("Enter Customer Code!");
        document.getElementById("customertxt").focus();
        return false;
    }
    else if (!isalpha.test(ac_customer)) {
        ErrorLoad("Enter Sales Executive Code!");
        document.getElementById("salesexecutivetxt").focus();
        document.getElementById("customertxt").style.borderColor = "red";
        return false;
    }
    else {
        document.getElementById("customertxt").style.borderColor = "";
        return true;
    }
}
//Accounts Receivable Status - Complete Validation
function checkAccounts() {
    if (!ac_SalesOffice()) {
        return false;
    }
    else if (!ac_SalesExecutive()) {
        return false;
    }
    else if (!ac_Customer()) {
        return false;
    }
    else {
        return true;
    }
}

//for Collection

function show_error(msg)
{
    alert(msg);
}

function onFocusValid(id)
{
    var value = document.getElementById(id).value;
    if (value == "")
    {
        return false;
    }
    else
    {
        return true;
    }
}

function cl_CustCode() {
    var cl_custcode = document.getElementById("customerCodetxt").value;

    if (cl_custcode == "") {
        var msg = "please enter customer code";
        show_error(msg);

        return false;
    }
    else {
        return true;

    }
}

//check cheque
function cl_Cheque()
{
    if (!onFocusValid("customerCodetxt"))
    {
        var msg = "please enter customer code";
        document.getElementById("cheqreftxt").value = "";
        show_error(msg);

        return false;
    }
    if (!onFocusValid("cheqreftxt"))
    {
        msg = "please enter cheque number";
        show_error(msg);
        return false;
    }
    else
    {
        return true;
    }
}

//check cheque amount
function cl_ChequeAmount() {

    var cl_cheqamt = document.getElementById("chequeamounttxt").value;
    if (!onFocusValid("customerCodetxt"))
    {
        var msg = "please enter customer code";
        show_error(msg);
        // document.getElementById("customerCodetxt").focus();
        document.getElementById("chequeamounttxt").value = "";
        return false;
    }
    if (!onFocusValid("cheqreftxt"))
    {
        msg = "please enter cheque number";
        document.getElementById("chequeamounttxt").value = "";
        show_error(msg);
        //document.getElementById("cheqreftxt").focus();
        return false;
    }
    if (!onFocusValid("chequeamounttxt"))
    {
        msg = "please enter cheque amount";
        show_error(msg);
        //document.getElementById("cheqreftxt").focus();
        return false;
    }
    if (parseInt(cl_cheqamt) <= 0) {
        msg = "Cheque amount should not be Zero";
        document.getElementById("chequeamounttxt").value = "";
        show_error(msg);

        return false;
    }
    else {
        document.getElementById("chequeamounttxt").value = round_decimals(cl_cheqamt, 2);

        return true;
    }
}

function cl_receiptno()
{
    if (!onFocusValid("customerCodetxt"))
    {
        var msg = "please enter customer code";
        show_error(msg);
        document.getElementById("receipttxt").value = "";
        return false;
    }
    else if (!onFocusValid("cheqreftxt"))
    {
        msg = "please enter cheque number";
        show_error(msg);
        document.getElementById("receipttxt").value = "";
        return false;
    }
    else if (!onFocusValid("chequeamounttxt"))
    {
        msg = "please enter cheque amount";
        show_error(msg);
        document.getElementById("receipttxt").value = "";
        return false;
    }
    else
        return true;
}

////Collection-bank
function cl_Bank() {
    if (!onFocusValid("customerCodetxt"))
    {
        var msg = "please enter customer code";
        show_error(msg);
        document.getElementById("banktxt").value = "";
        return false;
    }
    else if (!onFocusValid("cheqreftxt"))
    {
        msg = "please enter cheque number";
        show_error(msg);
        document.getElementById("banktxt").value = "";
        return false;
    }
    else if (!onFocusValid("chequeamounttxt"))
    {
        msg = "please enter cheque amount";
        show_error(msg);
        document.getElementById("banktxt").value = "";
        return false;
    }
    else if (!onFocusValid("banktxt"))
    {
        msg = "please enter bank name";
        show_error(msg);

        return false;
    }
    else
    {
        return true;
    }
}
////Collection - Bank Charges
function cl_BankCharge() {
    var chequeamt = document.getElementById("chequeamounttxt").value;
    var cl_bankcharge = document.getElementById("bankchrgstxt").value;
    if (parseFloat(cl_bankcharge) >= parseFloat(chequeamt)) {

        document.getElementById("bankchrgstxt").value = "0.00";
        msg = "please enter lesser than cheque amount";
        show_error(msg);

        // document.getElementById("bankchrgstxt").focus();
        return false;
    }
    else {
        document.getElementById("bankchrgstxt").value = round_decimals(cl_bankcharge, 2);
        return true;
    }
}
//Collection - Complete Validation
function checkCollection() {
    if (!onFocusValid("customerCodetxt"))
    {
        show_error("please enter customer code");
        return false;
    }
    else if (!onFocusValid("cheqreftxt"))
    {
        show_error("please enter cheque number");
        return false;
    }
    else if (!onFocusValid("chequeamounttxt"))
    {
        show_error("please enter cheque amount");
        return false;
    }

    else if (!isPaymentZero())
    {
        return false;
    }
    else if (!isPaymentLength())
    {
        return false;
    }
    else
    {
        document.getElementById("customerCodetxt").readOnly = true;
        submitAllData();
        document.getElementById("home").style.visibility = "hidden";
        document.getElementById("submit").disabled = true;
        return true;
    }
}

//for grid validation
function float_check(a)
{
    if (a.toString().indexOf("."))
    {
        a = a.toString() + ".00"
    }
    else {
        a = a.toString();
    }
    return a;
}


// preventing clearing the form when pressing ESC twise
//var keycount=0;
function disableesc()
{
    if (event.keyCode == 27)
    {
        //        keycount++;
        //        if(keycount==0)
        //        {
        event.returnValue = false;
        //        }
    }
}

function check_date(e)
{
    var key;
    var keycount = 0;
    key = e.which ? e.which : e.keyCode;
    // alert(e.keyCode);
    if ((key >= 47 && key <= 57) || key == 191)
    {
        if (key == 191)
        {
            keycount++;
            if (keycount > 3)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }
    else {
        return false;
    }
}

function navi(id)
{
    var node = document.getElementById(id);
    var div_visi = node.style.visibility;
    var div_disp = node.style.display;
    if (div_visi != "hidden" && div_disp != "none")
    {
        help_vin.dialog.show('Navigation', '', 'You Have Unsaved Data! Are You Sure?', 'Yes|N_clear_butt|goHome', 'No|N_cancel_butt|cancel');
    }
    else
    {
        goHome();
    }
}
function goHome()
{
    window.location = "Home.jsp";
}
function f_sendexception(msg, prog)
{
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        }
    }
    //pass textfield value to catchException.jsp file
    xmlhttp.open("GET", "catchException.jsp?Msg=" + msg + "&prog=" + prog, true);
    xmlhttp.send();
}

// function for Round off to n no of decimal places
//
function roundNumber(num, dec)
{
    var result = Math.round(num * Math.pow(10, dec)) / Math.pow(10, dec);
    return result;
}

function Enter_Go(evt, function_nam, function_param)
{
    if (evt.keyCode == 13)
    {
        if (function_param != undefined && function_param != '')
        {
//            alert("go");
            window[function_nam](function_param);
        }
        else
        {
            window[function_nam]();
        }
    }
}

function set_focus(id)
{
    document.getElementById(id).focus();
}
//for updating stock use
//for Clearing Qty
function clearing_Qty(plant, matnr, lgort, charg, qty)
{
    //clearing qty
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
        }
    }
    xmlhttp.open("GET", "IBTA_setQtyZero.jsp?plant=" + plant + "&matnr=" + matnr + "&lgort=" + lgort + "&charg=" + charg + "&qty=" + qty, true);
    xmlhttp.send();
}

function read_XMLFile(id)
{
    try
    {
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("GET", "data\\Customer.xml", false);
        xmlhttp.send();
        xmlDoc = xmlhttp.responseXML;
        txt = xmlDoc.getElementsByTagName(id)[0].childNodes[0].nodeValue;
        //alert(txt);
        return txt;
    }
    catch (e)
    {
        alert(e.message);
    }
}
//function for disable right click
/*
 var message="Function Disabled!";
 function clickIE4(){
 if (event.button==2){
 alert(message);
 return false;
 }
 }
 function clickNS4(e){
 if (document.layers||document.getElementById&&!document.all){
 if (e.which==2||e.which==3){
 alert(message);
 return false;
 }
 }
 }
 
 if (document.layers){
 document.captureEvents(Event.MOUSEDOWN);
 document.onmousedown=clickNS4;
 }
 else if (document.all&&!document.getElementById){
 document.onmousedown=clickIE4;
 }
 
 document.oncontextmenu=new Function("alert(message);return false")
 */
/*
 * function for disabling F5
 */
function checkKeyCode(evt)
{

    var evt = (evt) ? evt : ((event) ? event : null);
    var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
    if (event.keyCode == 116)
    {
        evt.keyCode = 0;
        return false
    }
}
document.onkeydown = showDown;
function showDown(evt) {
    evt = (evt) ? evt : ((event) ? event : null);
    if (evt) {
        if (event.keyCode == 8 && (event.srcElement.type != "text" && event.srcElement.type != "textarea" && event.srcElement.type != "password")) {
// When backspace is pressed but not in form element
            cancelKey(evt);
        }
        else if (event.keyCode == 116) {
// When F5 is pressed
            cancelKey(evt);
        }
        else if (event.keyCode == 122) {
// When F11 is pressed
            cancelKey(evt);
        }
        else if (event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82)) {
// When ctrl is pressed with R or N
            cancelKey(evt);
        }
        else if (event.altKey && event.keyCode == 37) {
// stop Alt left cursor
            return false;
        }
    }
}

function cancelKey(evt) {
    if (evt.preventDefault) {
        evt.preventDefault();
        return false;
    }
    else {
        evt.keyCode = 0;
        evt.returnValue = false;
    }
}
//function for Session Timout

var timerId;
timerId = window.setTimeout("timeOut()", 14400000);//300000);1800000->30Minutes

function timeOut() {
    // do something here
    if (GetCurrentPageName() == 'index') {
    }
    else
    {
        alert("Session has Expired");
        window.location = "logout";
    }
}
document.onmousedown = resetTimer;
function resetTimer() {
    
    window.clearTimeout(timerId);
    timerId = window.setTimeout("timeOut()",14400000);//300000);
}

function GetCurrentPageName() {
    //method to get Current page name from url.
    //return page name in small .
    var sPath = window.location.pathname;
    var sPage = sPath.substring(sPath.lastIndexOf('/') + 1);
    return sPage.toLowerCase();
}
function round_decimals(original_number, decimals) {
    var p = Math.pow(10, decimals);
    original_number = original_number * p;
    original_number = Round1(original_number, decimals);
    var tmp = Math.round(original_number);
    var rest = tmp / p;
    rest = round_decimals12(rest, decimals)
    return  rest;
}
function Round1(original_number, decimals) {
    var p = Math.pow(10, decimals);
    original_number = original_number * p;
    var tmp = Math.round(original_number);
    return  tmp / p;
}
//round
function round_decimals12(original_number, decimals) {
    try
    {
        original_number = parseFloat(original_number);

        var result1 = original_number * Math.pow(10, decimals)
        var result2 = Math.round(result1)
        var result3 = result2 / Math.pow(10, decimals)
        return pad_with_zeros(result3, decimals);
    } catch (e) {
        Er_message = "invoicing.js, round_decimals() ex:" + e.description;
        sendexception(Er_message);
    }
}
/*/round
 function round_decimals(original_number, decimals) {
 try
 {
 original_number=parseFloat(original_number);
 if(original_number!=="NaN"){            
 var wh_nu=original_number.toString().trim_js().split(".");
 
 var result=wh_nu[0].search("-");            
 
 var num=wh_nu[0].length;
 num=num+parseInt(decimals);
 
 if(result=="-1"){
 }else{
 num=num-1;
 }
 var ret_srt=original_number.toPrecision(num);
 return ret_srt;
 }else{
 return 0;
 }
 } catch(e){
 return 0;
 }
 }*/

function pad_with_zeros(rounded_value, decimal_places) {

    // Convert the number to a string
    var value_string = rounded_value.toString()

    // Locate the decimal point
    var decimal_location = value_string.indexOf(".")

    // Is there a decimal point?
    if (decimal_location == -1) {

        // If no, then all decimal places will be padded with 0s
        decimal_part_length = 0

        // If decimal_places is greater than zero, tack on a decimal point
        value_string += decimal_places > 0 ? "." : ""
    }
    else {
        // If yes, then only the extra decimal places will be padded with 0s
        decimal_part_length = value_string.length - decimal_location - 1
    }

    // Calculate the number of decimal places that need to be padded with 0s
    var pad_total = decimal_places - decimal_part_length

    if (pad_total > 0) {

        // Pad the string with 0s
        for (var counter = 1; counter <= pad_total; counter++)
            value_string += "0"
    }
    return value_string
}

function checkSpecialCharacters(event) {

    if (event.keyCode == 44) {
        return true;
    } else if ((event.keyCode < 31 || event.keyCode > 32) && (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 97 || event.keyCode > 122) && (event.keyCode < 65 || event.keyCode > 90))
    {
        return false;
    }
}

function checkSpecialCharacter(e) {
    var key;
    key = e.which ? e.which : e.keyCode;
    if (key != 34 && key != 39 && key != 96) {
        return true;
    }
    else {
        return false;
    }
}

function CheckBackspace(e)                                                      //number only
{
    var key;
    key = e.which ? e.which : e.keyCode;
    alert(e.keyCode);
    if (key != 9) {
        return true;
    }
    else {
        return false;
    }

}

function ValidateEmail(id)
{
    var mail = document.getElementById(id).value;
    if(mail==""){
        return true;
    }else{
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
    {
        return true;
    } else {
        alert("You have entered an invalid email address!");
        document.getElementById(id).focus();
        return false;
    }
}
}

function isAlphaNumericWithHypen(event) {
    if (event.keyCode == 45) {
        return true;
    } else if ((event.keyCode < 31 || event.keyCode > 32) && (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 97 || event.keyCode > 122) && (event.keyCode < 65 || event.keyCode > 90))
    {
        return false;
    }
}

function isAlphaNumeric(event) {
    if ((event.keyCode < 31 || event.keyCode > 32) && (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 97 || event.keyCode > 122) && (event.keyCode < 65 || event.keyCode > 90))
    {
        return false;
    }
}
