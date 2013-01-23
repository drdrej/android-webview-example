
function createCreditControlTest() {
	this.callContactsManager = function() {
		alert( "Contract selected ..." );
	};
}

// fügt objekte zum model hinzu, falls 
// diese nicht vorhanden waren.
if ( (typeof CreateCreditControl == "undefined") ) {
	alert( "Running in Test-Environment..." );
	CreateCreditControl = new createCreditControlTest();
}



console.debug( "Obj: " + CreateCreditControl + " /n " );