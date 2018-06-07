/**
 * 
 */
function authority_check(auth_object, field_name, field_value, actvt_value,
		Valid_user) {
	var check_val_result = false;

	var access = $.ajax({
		type : "GET",
		url : "authority_check?user_id=" + Valid_user + " &auth_object="
				+ auth_object + "&field_name=" + field_name + "&field_value="
				+ field_value + "&actvt_value=" + actvt_value,
		async : false
	}).responseText;
	var common_value = access.split("~");
	if (access == null) {
		check_val_result = false;
	} else if (common_value[0] !== "E") {
		check_val_result = true;
	} else {
		check_val_result = false;
	}
	return check_val_result;
}


