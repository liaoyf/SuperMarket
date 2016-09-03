var Login = function() {

	return {
		// main function to initiate the module
		init : function() {
			$('.login-form')
					.validate(
							{
								errorElement : 'label', // default input error
								// message container
								errorClass : 'help-inline', // default input
								// error message
								// class
								focusInvalid : false, // do not focus the last
								// invalid input
								rules : {
									staffName : {
										required : true
									},
									password : {
										required : true
									},
								},

								messages : {
									staffName : {
										required : "需要填写用户名."
									},
									password : {
										required : "需要填写密码."
									}
								},
								highlight : function(element) { // hightlight
									// error inputs
									$(element).closest('.control-group')
											.addClass('error'); // set error
									// class to the
									// control group
								},

								success : function(label) {
									label.closest('.control-group')
											.removeClass('error');
									label.remove();
								},

								errorPlacement : function(error, element) {
									error
											.addClass(
													'help-small no-left-padding')
											.insertAfter(
													element
															.closest('.input-icon'));
								},
							});
		}

	};

}();