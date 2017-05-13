/*   
Template Name: Color Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.4
Version: 1.7.0
Author: Sean Ngu
Website: http://www.seantheme.com/color-admin-v1.7/admin/
*/

var handleBootstrapWizardsValidation = function() {
	"use strict";
	$("#wizard").bwizard({ validating: function (e, ui) { 
	        if (ui.index == 0) {
	            // step-1 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-1')) {
                    return false;
                }
	        } else if (ui.index == 1) {
	            // step-2 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-2')) {
                    return false;
                }
	        } else if (ui.index == 2) {
	            // step-3 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-3')) {
                    return false;
                }
            } else if (ui.index == 3) {
                // step-4 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-4')) {
                    return false;
                }
            } else if (ui.index == 4) {
                // step-5 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-5')) {
                    return false;
                }
            } else if (ui.index == 5) {
                // step-6 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-6')) {
                    return false;
                }
            } else if (ui.index == 6) {
                // step-7 validation
                if (false === $('form[name="form-wizard"]').parsley().validate('wizard-step-7')) {
                    return false;
                }
            }
	    } 
	});
};

var FormWizardValidation = function () {
	"use strict";
    return {
        //main function
        init: function () {
            handleBootstrapWizardsValidation();
        }
    };
}();