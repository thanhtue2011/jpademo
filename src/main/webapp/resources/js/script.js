function checkForm() {
	  name=validname();
	  fname=validfname();
	  lname=validlname();
	  return name && fname && lname;
		
		}
function validate(ipname,nameer,ml,mxl){
	var name=document.getElementById(ipname).value.trim();
	if(name.length>=ml && name.length<=mxl){
		var regex=/^[a-zA-Z]+$/;
		if (!regex.test(name)){
			document.getElementById(nameer).innerHTML="Ten chi gom cac chu cai a-z, A-Z";
			return false;
		}
		document.getElementById(nameer).innerHTML="";
		document.getElementById(ipname).value=name;
		return true;
	}
	else if(name==""){
		document.getElementById(nameer).innerHTML="Khong duoc rong!";
		return false;
	}
	else{
		document.getElementById(nameer).innerHTML="Phai co do dai "+ ml + " den "+ mxl + " ky tu";
		return false;
	}
}
function validname(){
	return validate("name","tname",2,10);
}
function validfname(){
	return validate("firstname","fname",2,12);
}
function validlname(){
	return validate("lastname","lname",2,12);
}